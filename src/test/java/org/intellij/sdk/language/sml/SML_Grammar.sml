/**
* File test.sml
* Created by VF235500 on 25/11/2020.
* Copyright (c) CEA-LETI. All rights reserved.
* Unauthorized use, duplication or distribution is strictly prohibited by law.
*/


state:Initial {

  enter {
    call Equipment.initControlState(false)
    process state:ALARM("Alarm")
  }
}

event:INIT_END {
  condition {
    #main_process
  }
  MESSAGE
  call Equipment.setInitEnd()
}


/** General event handling com loss
*/

event:COM_DISABLE {
  condition {
    #main_thread
  }
  goto state:OFFLINE
}

event:COM_ENABLE {
  condition {
    #main_thread
  }
  goto state:ONLINE
}

state:OFFLINE {

  enter {
    MESSAGE
    call EquipmentManager.setControlState(ControlState.OFFLINE)
  }
}


/********************/
/**     ALARM      **/
/********************/

state:ALARM {

  enter {
    MESSAGE
  }

  option {
      no_lookup
  }

  alarm:'^(?!980).*$' {
      // Disable alarms reporting. Waiting for AMAT informations on which alarm is relevant or not
    // MESSAGE
    // call EquipmentManager.logAlarm(#event)
  }
}



/******************/
/** STATE ONLINE **/
/******************/

state:ONLINE {

  enter {
    MESSAGE
    call EquipmentManager.setControlState(ControlState.ONLINE)
    call Equipment.initControlState(true)
    call DataHandler.init()
  }

  event:GemControlStateLOCAL {
    MESSAGE
    call EquipmentManager.setControlState(ControlState.ONLINE_LOCAL)
  }

  event:GemControlStateREMOTE {
    MESSAGE
    call EquipmentManager.setControlState(ControlState.ONLINE_REMOTE)
  }

  event:PRJobSMTrans11, PRJobSMTrans13, PRJobSMTrans14, PRJobSMTrans15, SemuraiProcessingAborted {
    MESSAGE
    call DataHandler.handleProcessAbort()
    goto state:IDLE
  }

  event:CarrierSMTrans13, CarrierSMTrans14, CarrierSMTrans15 {
    goto state:PROCESSING
  }

  state:IDLE {

    enter {
      MESSAGE
      call EquipmentManager.setProcessState(ProcessState.IDLE)
    }
  }

  state:PROCESSING {

    enter {
      MESSAGE
      call EquipmentManager.setProcessState(ProcessState.READY)
      thread state:PORT($PortID)
    }

    event:PortTransferSMTrans09 {
      condition {
        #no_thread
      }
      goto state:IDLE
    }

    event:CarrierSMTrans13, CarrierSMTrans14, CarrierSMTrans15 {
      condition {
        #thread_not_exists($PortID)
      }
      thread state:PORT($PortID)
    }
  }
}


/****************/
/** STATE PORT **/
/****************/

state:PORT {

  option {
      no_lookup
  }

  enter {
    MESSAGE
    goto state:LOADCARRIER
  }

  state:LOADCARRIER {

    enter {
      MESSAGE
      call DataHandler.handleLoadCarrier(#event)
    }

    event:SubstSMTrans02 {

      script {
        binding {
          a = $SubstID
          b = #thread
        }
        var substIdToCarrier = a.split(".")[0];
        var threadToCarrier = "Carrier"+b;
      }
      condition {
        #thread_not_exists($SubstID)
        $SubstLocID == "EtuWayIn"
        @substIdToCarrier == @threadToCarrier
      }
      thread state:PROCESSWAFER($SubstID)
    }
  }

  event:PortTransferSMTrans09 {
    condition {
      $PortID == #thread
    }
    goto state:UNLOADCARRIER
  }

  state:UNLOADCARRIER {

    enter {
      MESSAGE
      call DataHandler.handleUnloadCarrier(#event)
      thread_end
    }
  }
}



/**************************/
/** STATE PROCESSWAFER **/
/**************************/

state:PROCESSWAFER {

  enter {
    MESSAGE
    goto state:WAF_ETU_WAY_IN
  }

    /**************************/

  state:WAF_ETU_WAY_IN {

    enter {
      MESSAGE
        //call DataHandler.setStatus(#event, #state)
    }
  }

  event:SubstSMTrans04 {
    condition {
      $SubstID == #thread
      $SubstLocID == "LlkIn"
    }
    if (#state != "WAF_ETU_WAY_IN") {
      WARNING "\n    the wafer's current position has to be WAF_ETU_WAY_IN instead of " + #state + " before going to WAF_LLK_IN"
    }
    goto state:WAF_LLK_IN
  }

    /**************************/

  state:WAF_LLK_IN {

    enter {
      MESSAGE
        //call DataHandler.setStatus(#event, #state)
    }
  }

  event:SubstSMTrans04 {
    condition {
      $SubstID == #thread
      $SubstLocID == "ItuWayIn"
    }
    if (#state != "WAF_LLK_IN") {
      WARNING "\n    the waffer's current position has to be WAF_LLK_IN instead of " + #state + " before going to WAF_ITU_WAY_IN"
    }
    goto state:WAF_ITU_WAY_IN
  }

    /**************************/

  state:WAF_ITU_WAY_IN {

    enter {
      MESSAGE
        //call DataHandler.setStatus(#event, #state)
    }
  }

  event:SubstSMTrans04 {
    condition {
      $SubstID == #thread
      $SubstLocID == "OnStage"
    }
    if (#state != "WAF_ITU_WAY_IN") {
      WARNING "\n    the waffer's current position has to be WAF_ITU_WAY_IN instead of " + #state + " before going to WAF_ON_STAGE"
    }
    goto state:WAF_ON_STAGE
  }

    /**************************/

  state:WAF_ON_STAGE {

    enter {
      MESSAGE
      call EquipmentManager.setProcessState(ProcessState.PROCESSING)
        //call DataHandler.setStatus(#event, #state)
    }
  }

  event:SemuraiWaferMeas {

    script {
      binding {
        varWaferId = $SemuraiWaferMeasResults.WaferMeasResults.InfoMeasurement.Attributs.WaferId.WaferId
      }
    }
    condition {
      @varWaferId == #thread
    }
    if (#state != "WAF_ON_STAGE") {
      WARNING "\n    the waffer's current position has to be WAF_ON_STAGE instead of " + #state + " before going to WAF_MEASURED"
    }
    goto state:WAF_MEASURED
  }

    /**************************/

  state:WAF_MEASURED {

    enter {
      MESSAGE
      call DataHandler.handleMeasureReport(#event)
    }
  }

  event:SubstSMTrans04 {
    condition {
      $SubstID == #thread
      $SubstLocID == "ItuWayOut"
    }
    if (#state != "WAF_MEASURED" && #state != "WAF_ON_STAGE") {
      WARNING "\n    the waffer's current position has to be WAF_MEASURED or WAF_ON_STAGE instead of " + #state + " before going to WAF_ITU_WAY_OUT"
    }
    goto state:WAF_ITU_WAY_OUT
  }

    /**************************/

  state:WAF_ITU_WAY_OUT {

    enter {
      MESSAGE
        //call DataHandler.setStatus(#event, #state)
    }
  }

  event:SubstSMTrans04 {
    condition {
      $SubstID == #thread
      $SubstLocID == "LlkOut"
    }
    if (#state != "WAF_ITU_WAY_OUT") {
      WARNING "\n    the waffer's current position has to be WAF_ITU_WAY_OUT instead of " + #state + " before going to WAF_LLK_OUT"
    }
    goto state:WAF_LLK_OUT
  }

    /**************************/

  state:WAF_LLK_OUT {

    enter {
      MESSAGE
        //call DataHandler.setStatus(#event, #state)
    }
  }

  event:SubstSMTrans04 {
    condition {
      $SubstID == #thread
      $SubstLocID == "EtuWayOut"
    }
    if (#state != "WAF_LLK_OUT") {
      WARNING "\n    the waffer's current position has to be WAF_LLK_OUT instead of " + #state + " before going to WAF_ETU_WAY_OUT"
    }
    goto state:WAF_ETU_WAY_OUT
  }

    /**************************/

  state:WAF_ETU_WAY_OUT {

    enter {
      MESSAGE
        //call DataHandler.setStatus(#event, #state)
    }
  }

  event:SubstSMTrans05 {
    condition {
      $SubstID == #thread
    }
    if (#state != "WAF_ETU_WAY_OUT") {
      WARNING "\n    the waffer's current position has to be WAF_ETU_WAY_OUT instead of " + #state + " before going to WAF_BACK_IN_CARRIER"
    }
    goto state:WAF_BACK_IN_CARRIER
  }

    /**************************/

  state:WAF_BACK_IN_CARRIER {

    enter {
      MESSAGE
      thread_end
    }
  }
}
