package org.intellij.sdk.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.psi.XCSTypes;
import com.intellij.psi.TokenType;

%%

%class XCSLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

END_OF_FUNCTION_LINE_COMMENT=("*")[^\r\n]*
END_OF_LINE_COMMENT=("//")[^\r\n]*
WHITE_SPACE=[\ \n\t\f]


COLLECTION_EVENT=COLLECTIONEVENT_VARIABLES
DATA_VARIABLE=DATAVARIABLES
EQUIPMENT_CONSTANT=EQUIPMENTCONSTANTS
EVENTS=EVENTS
SCENARIOS=SCENARIOS
SECS_ITEM_TYPE=SECSITEM_TYPES
STANDART_SECTION=REMOTE_COMMANDS|TRACE_DEFINITIONS|POLLING_EVENT_DEFINITIONS|FORMATTED_RECIPES|OVERWRITTEN_SECS_STANDARD_MESSAGES|PREDEFINED_FORMATTED_STATUS_LISTS|PREDEFINED_UNIQUE_REPORT_ID_REPORTS|PREDEFINED_UNIQUE_CEID_REPORTS|SECSVALUE_TO_VFEITEXTVALUE_VARIABLES
STATUS_VARIABLE=STATUSVARIABLES
VFEI_SECS_SEQ=VFEI_SECS_SEQUENCES
FUNCTION_NAME=\w+

COLON=:
STREAM_FUNCTION=S\d+F\d+(" W")?
CORE_START=<

VARIABLE_TYPE=(U|I)[1248](\[\d+\])?|F[48](\[\d+\])?|(B|V|BOOLEAN|Boolean)(\[\d+\])?|J|V
VARIABLE_NAME=(\$)?\w*[a-zA-Z]\w*
VARIABLE_VALUE=(\w+)|(\'\w+\')|(\-\w+)|(\'\-\w+\')
CEID=CEID
DVID=DVID
ECID=ECID
SVID=SVID
VFEI_CMD_ITEM_NAME=INITIALIZE

PROPERTY_START=\{
PROPERTY_END=\}
EQUALS=\=
PROPERTY_NAME=VfeiQualifier|VfeiName|SecsValueAlignment|SecsValueWidth|SecsValueToVfeiText|SecsName|VfeiValue|
              VfeiType|CheckAck|AllowedSecsItemValues|SecsItemsToCheck|PutSecsReplyToVfeiReply|SecsType|SecsValue|
              IsTemplate|VfeiNameTemplateNames|ReuseProperties|ReusePropertiesNoArrays|ReplaceVfeiName|ReplaceItems|
              SendAsList|Disabled|ReplyMatch|WrapInList|EventLevel8
PROPERTY_NAME_CE=VfeiName|SecsType|ReplaceVfeiName|ReplaceItems|EventLevel8
PROPERTY_NAME_DV=VfeiName|VfeiType|SecsType|SecsValueToVfeiText|SecsValueAlignment|ReplaceVfeiName|ReplaceItems|SendAsList|ReuseProperties
PROPERTY_NAME_EC=VfeiName|VfeiType|SecsType|MinSecsValue|DefaultSecsValue
PROPERTY_NAME_SV=VfeiName|VfeiType|SecsType|SecsValueToVfeiText|SecsValueAlignment|ReplaceVfeiName|ReplaceItems|SendAsList|ReuseProperties
PROPERTY_NAME_VSS=CheckAck|SecsItemsToCheck
PROPERTY_VALUE=\"\w+\"

ASCII_TYPE=A(\[\d+\])?|A
ASCII_VALUE=(\"[^\"]*\")|(\'[^\']*\')
LIST_TYPE=L(\[\d+\])?|L

CORE_END=>
FUNCTION_END=.

//STATE
%state FUNCTION_HEADER
%state CE_HEADER
%state DV_HEADER
%state EC_HEADER
%state EVENTS_HEADER
%state SCE_HEADER
%state SIT_HEADER
%state SS_HEADER
%state SV_HEADER
%state VSS_HEADER

//FUNCTION
%state CORE
%state NAME
%state NAME_ASCII
%state PROPERTY
%state PROPERTY_ASCII

//COLLLECTION EVENT
%state CE_CORE
%state CE_NAME
%state CE_NAME_ASCII
%state CE_PROPERTY
%state CE_PROPERTY_ASCII

//DATA VARIABLE
%state DV_CORE
%state DV_LIST
%state DV_NAME
%state DV_NAME_ASCII
%state DV_PROPERTY
%state DV_PROPERTY_ASCII

//EQUIPMENT CONSTANT
%state EC_CORE
%state EC_NAME
%state EC_NAME_ASCII
%state EC_PROPERTY
%state EC_PROPERTY_ASCII

//EVENTS
%state EVENTS_CORE
%state EVENTS_NAME
%state EVENTS_NAME_ASCII

//SCENARIOS
%state SCE_CORE
%state SCE_NAME
%state SCE_NAME_ASCII

//SECSITEM TYPES
%state SIT_CORE
%state SIT_NAME

//STATUS VARIABLE
%state SV_CORE
%state SV_LIST
%state SV_NAME
%state SV_NAME_ASCII
%state SV_PROPERTY
%state SV_PROPERTY_ASCII

//VFEI SECS SEQUENCES
%state VSS_LIST
%state VSS_CORE
%state VSS_NAME
%state VSS_NAME_ASCII
%state VSS_PROPERTY
%state VSS_PROPERTY_ASCII


%%



{END_OF_LINE_COMMENT}                           {return XCSTypes.COMMENT; }
<YYINITIAL> {END_OF_FUNCTION_LINE_COMMENT}      { yybegin(YYINITIAL); return XCSTypes.FUNCTION_COMMENT; }
{WHITE_SPACE}                                   {return TokenType.WHITE_SPACE; }


<YYINITIAL>{
    {COLLECTION_EVENT}      { yybegin(CE_HEADER); return XCSTypes.COLLECTION_EVENT; }
    {DATA_VARIABLE}         { yybegin(DV_HEADER); return XCSTypes.DATA_VARIABLE; }
    {EQUIPMENT_CONSTANT}    { yybegin(EC_HEADER); return XCSTypes.EQUIPMENT_CONSTANT; }
    {EVENTS}                { yybegin(EVENTS_HEADER); return XCSTypes.EVENTS; }
    {SCENARIOS}             { yybegin(SCE_HEADER); return XCSTypes.SCENARIOS; }
    {SECS_ITEM_TYPE}        { yybegin(SIT_HEADER); return XCSTypes.SECS_ITEM_TYPE; }
    {STANDART_SECTION}      { yybegin(SS_HEADER); return XCSTypes.STANDART_SECTION; }
    {STATUS_VARIABLE}       { yybegin(SV_HEADER); return XCSTypes.STATUS_VARIABLE; }
    {VFEI_SECS_SEQ}         { yybegin(VSS_HEADER); return XCSTypes.VFEI_SECS_SEQ; }
    {FUNCTION_NAME}         { yybegin(FUNCTION_HEADER); return XCSTypes.FUNCTION_NAME; }
}

////////////////////////////////////////////////////////////////////////////////
/////////////////////          FUNCTIONS        ////////////////////////////////
////////////////////////////////////////////////////////////////////////////////


<FUNCTION_HEADER>{
    {COLON}                        {return XCSTypes.COLON; }
    {STREAM_FUNCTION}              {return XCSTypes.STREAM_FUNCTION; }
    {END_OF_FUNCTION_LINE_COMMENT} {return XCSTypes.FUNCTION_COMMENT; }
    {CORE_START}                   {yybegin(CORE); return XCSTypes.CORE_START; }
    {FUNCTION_END}                 {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}

<CORE>{
      //LIST
     {LIST_TYPE}                         {yybegin(NAME); return XCSTypes.LIST_TYPE; }
     {CORE_START}                        {yybegin(CORE); return XCSTypes.CORE_START; }
     //ASCII
     {ASCII_TYPE}                        {yybegin(NAME_ASCII); return XCSTypes.ASCII_TYPE; }
     {ASCII_VALUE}                       {return XCSTypes.ASCII_VALUE; }
     //OTHERS
     {VARIABLE_TYPE}                     {yybegin(NAME); return XCSTypes.VARIABLE_TYPE; }
     {VARIABLE_VALUE}                    {return XCSTypes.VARIABLE_VALUE; }

     {PROPERTY_START}                    {yybegin(PROPERTY); return XCSTypes.PROPERTY_START; }
     {CORE_END}                          {return XCSTypes.CORE_END ;}
     {END_OF_FUNCTION_LINE_COMMENT}      {return XCSTypes.FUNCTION_COMMENT; }
     {FUNCTION_END}                      {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}

<NAME>{
    {VARIABLE_NAME}     {yybegin(CORE); return XCSTypes.VARIABLE_NAME; }
    {VARIABLE_VALUE}    {yybegin(CORE); return XCSTypes.VARIABLE_VALUE; }
    {PROPERTY_START}    {yybegin(PROPERTY); return XCSTypes.PROPERTY_START; }
    {END_OF_FUNCTION_LINE_COMMENT}      {return XCSTypes.FUNCTION_COMMENT; }
    {CORE_START}        {yybegin(CORE); return XCSTypes.CORE_START; }
    {CORE_END}          {yybegin(CORE); return XCSTypes.CORE_END ;}
}

<NAME_ASCII>{
    {VARIABLE_NAME}     {yybegin(CORE); return XCSTypes.VARIABLE_NAME; }
    {ASCII_VALUE}       {yybegin(CORE); return XCSTypes.ASCII_VALUE; }
    {PROPERTY_START}    {yybegin(PROPERTY_ASCII); return XCSTypes.PROPERTY_START; }
    {END_OF_FUNCTION_LINE_COMMENT}      {return XCSTypes.FUNCTION_COMMENT; }
    {CORE_START}        {yybegin(CORE); return XCSTypes.CORE_START; }
    {CORE_END}          {yybegin(CORE); return XCSTypes.CORE_END ;}
}

<PROPERTY>{
     {PROPERTY_NAME}    {return XCSTypes.PROPERTY_NAME; }
     {EQUALS}           {return XCSTypes.EQUALS; }
     {PROPERTY_VALUE}   {return XCSTypes.PROPERTY_VALUE; }
     {PROPERTY_END}     {return XCSTypes.PROPERTY_END; }
     {VARIABLE_VALUE}   {return XCSTypes.VARIABLE_VALUE; }
     {CORE_START}       {yybegin(CORE); return XCSTypes.CORE_START; }
     {CORE_END}         {yybegin(CORE); return XCSTypes.CORE_END ;}
}

<PROPERTY_ASCII>{
     {PROPERTY_NAME}    {return XCSTypes.PROPERTY_NAME; }
     {EQUALS}           {return XCSTypes.EQUALS; }
     {PROPERTY_VALUE}   {return XCSTypes.PROPERTY_VALUE; }
     {PROPERTY_END}     {yybegin(NAME_ASCII);return XCSTypes.PROPERTY_END; }
}

////////////////////////////////////////////////////////////////////////////////
/////////////////////////         CE         ///////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

<CE_HEADER>{
    {COLON}                        {return XCSTypes.COLON; }
    {END_OF_FUNCTION_LINE_COMMENT} {return XCSTypes.FUNCTION_COMMENT; }
    {CORE_START}                   {yybegin(CE_CORE); return XCSTypes.CORE_START; }
    {FUNCTION_END}                 {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}

<CE_CORE>{
      //LIST
     {LIST_TYPE}                         {yybegin(CE_NAME); return XCSTypes.LIST_TYPE; }
     {CORE_START}                        {return XCSTypes.CORE_START; }
     //ASCII
     {ASCII_TYPE}                        {yybegin(CE_NAME_ASCII); return XCSTypes.ASCII_TYPE; }
     {ASCII_VALUE}                       {return XCSTypes.ASCII_VALUE; }
     //OTHERS
     {VARIABLE_TYPE}                     {yybegin(CE_NAME); return XCSTypes.VARIABLE_TYPE; }
     {VARIABLE_VALUE}                    {return XCSTypes.VARIABLE_VALUE; }

     {PROPERTY_START}                    {yybegin(CE_PROPERTY); return XCSTypes.PROPERTY_START; }
     {CORE_END}                          {return XCSTypes.CORE_END ;}
     {END_OF_FUNCTION_LINE_COMMENT}      {return XCSTypes.FUNCTION_COMMENT; }
     {FUNCTION_END}                      {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}

<CE_NAME>{
    {CEID}              {yybegin(CE_CORE); return XCSTypes.CEID; }
    {VARIABLE_VALUE}    {yybegin(CE_CORE); return XCSTypes.VARIABLE_VALUE; }
    {PROPERTY_START}    {yybegin(CE_PROPERTY); return XCSTypes.PROPERTY_START; }
    {CORE_START}        {yybegin(CE_CORE); return XCSTypes.CORE_START; }
    {CORE_END}          {yybegin(CE_CORE); return XCSTypes.CORE_END ;}
}

<CE_NAME_ASCII>{
    {CEID}              {yybegin(CE_CORE); return XCSTypes.CEID; }
    {ASCII_VALUE}       {yybegin(CE_CORE); return XCSTypes.ASCII_VALUE; }
    {PROPERTY_START}    {yybegin(CE_PROPERTY_ASCII); return XCSTypes.PROPERTY_START; }
    {CORE_START}        {yybegin(CE_CORE); return XCSTypes.CORE_START; }
    {CORE_END}          {yybegin(CE_CORE); return XCSTypes.CORE_END ;}
}

<CE_PROPERTY>{
    {PROPERTY_NAME_CE}    {return XCSTypes.PROPERTY_NAME_CE; }
    {EQUALS}              {return XCSTypes.EQUALS; }
    {PROPERTY_VALUE}      {return XCSTypes.PROPERTY_VALUE; }
    {PROPERTY_END}        {return XCSTypes.PROPERTY_END; }
    {VARIABLE_VALUE}      {return XCSTypes.VARIABLE_VALUE; }
    {CORE_START}          {yybegin(CE_CORE); return XCSTypes.CORE_START; }
    {CORE_END}            {yybegin(CE_CORE); return XCSTypes.CORE_END ;}
}

<CE_PROPERTY_ASCII>{
    {PROPERTY_NAME_CE}    {return XCSTypes.PROPERTY_NAME_CE; }
    {EQUALS}              {return XCSTypes.EQUALS; }
    {PROPERTY_VALUE}      {return XCSTypes.PROPERTY_VALUE; }
    {PROPERTY_END}        {yybegin(CE_NAME_ASCII);return XCSTypes.PROPERTY_END; }
}

////////////////////////////////////////////////////////////////////////////////
/////////////////////////         DV         ///////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

<DV_HEADER>{
    {COLON}                        {return XCSTypes.COLON; }
    {END_OF_FUNCTION_LINE_COMMENT} {return XCSTypes.FUNCTION_COMMENT; }
    {CORE_START}                   {yybegin(DV_LIST); return XCSTypes.CORE_START; }
    {FUNCTION_END}                 {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}

<DV_LIST>{
      //LIST
     {LIST_TYPE}                         {return XCSTypes.LIST_TYPE; }
     {CORE_START}                        {yybegin(DV_CORE); return XCSTypes.CORE_START; }
}

<DV_CORE>{
      //LIST
     {LIST_TYPE}                         {yybegin(DV_NAME); return XCSTypes.LIST_TYPE; }
     {CORE_START}                        {return XCSTypes.CORE_START; }
     //ASCII
     {ASCII_TYPE}                        {yybegin(DV_NAME_ASCII); return XCSTypes.ASCII_TYPE; }
     {ASCII_VALUE}                       {return XCSTypes.ASCII_VALUE; }
     //OTHERS
     {VARIABLE_TYPE}                     {yybegin(DV_NAME); return XCSTypes.VARIABLE_TYPE; }
     {VARIABLE_VALUE}                    {return XCSTypes.VARIABLE_VALUE; }

     {PROPERTY_START}                    {yybegin(DV_PROPERTY); return XCSTypes.PROPERTY_START; }
     {CORE_END}                          {return XCSTypes.CORE_END ;}
     {END_OF_FUNCTION_LINE_COMMENT}      {return XCSTypes.FUNCTION_COMMENT; }
     {FUNCTION_END}                      {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}

<DV_NAME>{
    {DVID}              {yybegin(DV_CORE); return XCSTypes.DVID; }
    {VARIABLE_NAME}     {return XCSTypes.VARIABLE_NAME; }
    {VARIABLE_VALUE}    {yybegin(DV_CORE); return XCSTypes.VARIABLE_VALUE; }
    {PROPERTY_START}    {yybegin(DV_PROPERTY); return XCSTypes.PROPERTY_START; }
    {CORE_START}        {yybegin(DV_CORE); return XCSTypes.CORE_START; }
    {CORE_END}          {yybegin(DV_CORE); return XCSTypes.CORE_END ;}
}


<DV_NAME_ASCII>{
    {DVID}              {yybegin(DV_CORE); return XCSTypes.DVID; }
    {VARIABLE_NAME}     {return XCSTypes.VARIABLE_NAME; }
    {ASCII_VALUE}       {yybegin(DV_CORE); return XCSTypes.ASCII_VALUE; }
    {PROPERTY_START}    {yybegin(DV_PROPERTY_ASCII); return XCSTypes.PROPERTY_START; }
    {CORE_START}        {yybegin(DV_CORE); return XCSTypes.CORE_START; }
    {CORE_END}          {yybegin(DV_CORE); return XCSTypes.CORE_END ;}
}

<DV_PROPERTY>{
    {PROPERTY_NAME_DV}    {return XCSTypes.PROPERTY_NAME_DV; }
    {EQUALS}              {return XCSTypes.EQUALS; }
    {PROPERTY_VALUE}      {return XCSTypes.PROPERTY_VALUE; }
    {PROPERTY_END}        {return XCSTypes.PROPERTY_END; }
    {VARIABLE_VALUE}      {return XCSTypes.VARIABLE_VALUE; }
    {CORE_START}          {yybegin(DV_CORE); return XCSTypes.CORE_START; }
    {CORE_END}            {yybegin(DV_CORE); return XCSTypes.CORE_END ;}
}

<DV_PROPERTY_ASCII>{
    {PROPERTY_NAME_DV}    {return XCSTypes.PROPERTY_NAME_DV; }
    {EQUALS}              {return XCSTypes.EQUALS; }
    {PROPERTY_VALUE}      {return XCSTypes.PROPERTY_VALUE; }
    {PROPERTY_END}        {yybegin(DV_NAME_ASCII); return XCSTypes.PROPERTY_END; }
}

////////////////////////////////////////////////////////////////////////////////
/////////////////////////         EC         ///////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

<EC_HEADER>{
    {COLON}                        {return XCSTypes.COLON; }
    {END_OF_FUNCTION_LINE_COMMENT} {return XCSTypes.FUNCTION_COMMENT; }
    {CORE_START}                   {yybegin(EC_CORE); return XCSTypes.CORE_START; }
    {FUNCTION_END}                 {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}

<EC_CORE>{
    //LIST
    {LIST_TYPE}                         {yybegin(EC_NAME); return XCSTypes.LIST_TYPE; }
    {CORE_START}                        {return XCSTypes.CORE_START; }
    //ASCII
    {ASCII_TYPE}                        {yybegin(EC_NAME_ASCII); return XCSTypes.ASCII_TYPE; }
    {ASCII_VALUE}                       {return XCSTypes.ASCII_VALUE; }
    //OTHERS
    {VARIABLE_TYPE}                     {yybegin(EC_NAME); return XCSTypes.VARIABLE_TYPE; }
    {VARIABLE_VALUE}                    {return XCSTypes.VARIABLE_VALUE; }

    {PROPERTY_START}                    {yybegin(EC_PROPERTY); return XCSTypes.PROPERTY_START; }
    {CORE_END}                          {return XCSTypes.CORE_END ;}
    {END_OF_FUNCTION_LINE_COMMENT}      {return XCSTypes.FUNCTION_COMMENT; }
    {FUNCTION_END}                      {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}

<EC_NAME>{
    {ECID}              {yybegin(EC_CORE); return XCSTypes.ECID; }
    {VARIABLE_VALUE}    {yybegin(EC_CORE); return XCSTypes.VARIABLE_VALUE; }
    {PROPERTY_START}    {yybegin(EC_PROPERTY); return XCSTypes.PROPERTY_START; }
    {CORE_START}        {yybegin(EC_CORE); return XCSTypes.CORE_START; }
    {CORE_END}          {yybegin(EC_CORE); return XCSTypes.CORE_END; }
}

<EC_NAME_ASCII>{
    {ECID}              {yybegin(EC_CORE); return XCSTypes.ECID; }
    {ASCII_VALUE}       {yybegin(EC_CORE); return XCSTypes.ASCII_VALUE; }
    {PROPERTY_START}    {yybegin(EC_PROPERTY_ASCII); return XCSTypes.PROPERTY_START; }
    {CORE_START}        {yybegin(EC_CORE); return XCSTypes.CORE_START; }
    {CORE_END}          {yybegin(EC_CORE); return XCSTypes.CORE_END; }
}


<EC_PROPERTY>{
    {PROPERTY_NAME_EC}    {return XCSTypes.PROPERTY_NAME_EC; }
    {EQUALS}              {return XCSTypes.EQUALS; }
    {PROPERTY_VALUE}      {return XCSTypes.PROPERTY_VALUE; }
    {PROPERTY_END}        {return XCSTypes.PROPERTY_END; }
    {VARIABLE_VALUE}      {return XCSTypes.VARIABLE_VALUE; }
    {CORE_START}          {yybegin(EC_CORE); return XCSTypes.CORE_START; }
    {CORE_END}            {yybegin(EC_CORE); return XCSTypes.CORE_END ;}
}

<EC_PROPERTY_ASCII>{
    {PROPERTY_NAME_EC}    {return XCSTypes.PROPERTY_NAME_EC; }
    {EQUALS}              {return XCSTypes.EQUALS; }
    {PROPERTY_VALUE}      {return XCSTypes.PROPERTY_VALUE; }
    {PROPERTY_END}        {yybegin(EC_NAME_ASCII);return XCSTypes.PROPERTY_END; }
}

////////////////////////////////////////////////////////////////////////////////
///////////////////////          EVENTS        /////////////////////////////////
////////////////////////////////////////////////////////////////////////////////


<EVENTS_HEADER>{
    {COLON}                        {return XCSTypes.COLON; }
    {STREAM_FUNCTION}              {return XCSTypes.STREAM_FUNCTION; }
    {END_OF_FUNCTION_LINE_COMMENT} {return XCSTypes.FUNCTION_COMMENT; }
    {CORE_START}                   {yybegin(EVENTS_CORE); return XCSTypes.CORE_START; }
    {FUNCTION_END}                 {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}

<EVENTS_CORE>{
      //LIST
     {LIST_TYPE}                         {yybegin(EVENTS_NAME); return XCSTypes.LIST_TYPE; }
     {CORE_START}                        {yybegin(EVENTS_CORE); return XCSTypes.CORE_START; }
     //ASCII
     {ASCII_TYPE}                        {yybegin(EVENTS_NAME_ASCII); return XCSTypes.ASCII_TYPE; }
     {ASCII_VALUE}                       {return XCSTypes.ASCII_VALUE; }

     {CORE_END}                          {return XCSTypes.CORE_END ;}
     {END_OF_FUNCTION_LINE_COMMENT}      {return XCSTypes.FUNCTION_COMMENT; }
     {FUNCTION_END}                      {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}

<EVENTS_NAME>{
    {VARIABLE_NAME}     {return XCSTypes.VARIABLE_NAME; }
    {CORE_START}        {yybegin(EVENTS_CORE); return XCSTypes.CORE_START; }
    {CORE_END}          {yybegin(EVENTS_CORE); return XCSTypes.CORE_END ;}
}

<EVENTS_NAME_ASCII>{
    {ASCII_VALUE}       {return XCSTypes.ASCII_VALUE; }
    {CORE_END}          {yybegin(EVENTS_CORE); return XCSTypes.CORE_END ;}
}

////////////////////////////////////////////////////////////////////////////////
/////////////////////          SCENARIOS        ////////////////////////////////
////////////////////////////////////////////////////////////////////////////////


<SCE_HEADER>{
    {COLON}                        {return XCSTypes.COLON; }
    {STREAM_FUNCTION}              {return XCSTypes.STREAM_FUNCTION; }
    {END_OF_FUNCTION_LINE_COMMENT} {return XCSTypes.FUNCTION_COMMENT; }
    {CORE_START}                   {yybegin(SCE_CORE); return XCSTypes.CORE_START; }
    {FUNCTION_END}                 {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}

<SCE_CORE>{
      //LIST
     {LIST_TYPE}                         {yybegin(SCE_NAME); return XCSTypes.LIST_TYPE; }
     {CORE_START}                        {yybegin(SCE_CORE); return XCSTypes.CORE_START; }
     //ASCII
     {ASCII_TYPE}                        {yybegin(SCE_NAME_ASCII); return XCSTypes.ASCII_TYPE; }
     {ASCII_VALUE}                       {return XCSTypes.ASCII_VALUE; }

     {CORE_END}                          {return XCSTypes.CORE_END ;}
     {END_OF_FUNCTION_LINE_COMMENT}      {return XCSTypes.FUNCTION_COMMENT; }
     {FUNCTION_END}                      {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}

<SCE_NAME>{
    {VARIABLE_NAME}     {return XCSTypes.VARIABLE_NAME; }
    {CORE_START}        {yybegin(SCE_CORE); return XCSTypes.CORE_START; }
    {CORE_END}          {yybegin(SCE_CORE); return XCSTypes.CORE_END ;}
}

<SCE_NAME_ASCII>{
    {ASCII_VALUE}       {return XCSTypes.ASCII_VALUE; }
    {CORE_END}          {yybegin(SCE_CORE); return XCSTypes.CORE_END ;}
}


////////////////////////////////////////////////////////////////////////////////
///////////////////////          SIT         ///////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

<SIT_HEADER>{
    {COLON}                        {return XCSTypes.COLON; }
    {END_OF_FUNCTION_LINE_COMMENT} {return XCSTypes.FUNCTION_COMMENT; }
    {CORE_START}                   {yybegin(SIT_CORE); return XCSTypes.CORE_START; }
    {FUNCTION_END}                 {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}

<SIT_CORE>{
    //LIST
    {LIST_TYPE}                         {yybegin(SIT_NAME); return XCSTypes.LIST_TYPE; }
    {CORE_START}                        {return XCSTypes.CORE_START; }
    //ASCII
    {ASCII_TYPE}                        {yybegin(SIT_NAME); return XCSTypes.ASCII_TYPE; }
    //OTHERS
    {VARIABLE_TYPE}                     {yybegin(SIT_NAME); return XCSTypes.VARIABLE_TYPE; }

    {CORE_END}                          {return XCSTypes.CORE_END ;}
    {END_OF_FUNCTION_LINE_COMMENT}      {return XCSTypes.FUNCTION_COMMENT; }
    {FUNCTION_END}                      {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}

<SIT_NAME>{
    {VARIABLE_NAME}     {yybegin(SIT_CORE); return XCSTypes.VARIABLE_NAME; }
    {CORE_START}        {yybegin(SIT_CORE); return XCSTypes.CORE_START; }
    {CORE_END}          {yybegin(SIT_CORE); return XCSTypes.CORE_END; }
}


////////////////////////////////////////////////////////////////////////////////
/////////////////////////         SV         ///////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

<SS_HEADER>{
    {COLON}                        {return XCSTypes.COLON; }
    {END_OF_FUNCTION_LINE_COMMENT} {return XCSTypes.FUNCTION_COMMENT; }
    {CORE_START}                   {yybegin(CORE); return XCSTypes.CORE_START; }
    {FUNCTION_END}                 {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}


////////////////////////////////////////////////////////////////////////////////
/////////////////////////         SV         ///////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

<SV_HEADER>{
    {COLON}                        {return XCSTypes.COLON; }
    {END_OF_FUNCTION_LINE_COMMENT} {return XCSTypes.FUNCTION_COMMENT; }
    {CORE_START}                   {yybegin(SV_LIST); return XCSTypes.CORE_START; }
    {FUNCTION_END}                 {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}

<SV_LIST>{
      //LIST
     {LIST_TYPE}                         {return XCSTypes.LIST_TYPE; }
     {CORE_START}                        {yybegin(SV_CORE); return XCSTypes.CORE_START; }
}

<SV_CORE>{
      //LIST
     {LIST_TYPE}                         {yybegin(SV_NAME); return XCSTypes.LIST_TYPE; }
     {CORE_START}                        {return XCSTypes.CORE_START; }
     //ASCII
     {ASCII_TYPE}                        {yybegin(SV_NAME_ASCII); return XCSTypes.ASCII_TYPE; }
     {ASCII_VALUE}                       {return XCSTypes.ASCII_VALUE; }
     //OTHERS
     {VARIABLE_TYPE}                     {yybegin(SV_NAME); return XCSTypes.VARIABLE_TYPE; }
     {VARIABLE_VALUE}                    {return XCSTypes.VARIABLE_VALUE; }

     {PROPERTY_START}                    {yybegin(SV_PROPERTY); return XCSTypes.PROPERTY_START; }
     {CORE_END}                          {return XCSTypes.CORE_END ;}
     {END_OF_FUNCTION_LINE_COMMENT}      {return XCSTypes.FUNCTION_COMMENT; }
     {FUNCTION_END}                      {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}

<SV_NAME>{
    {SVID}              {yybegin(SV_CORE); return XCSTypes.SVID; }
    {VARIABLE_NAME}     {return XCSTypes.VARIABLE_NAME; }
    {VARIABLE_VALUE}    {yybegin(SV_CORE); return XCSTypes.VARIABLE_VALUE; }
    {PROPERTY_START}    {yybegin(SV_PROPERTY); return XCSTypes.PROPERTY_START; }
    {CORE_START}        {yybegin(SV_CORE); return XCSTypes.CORE_START; }
    {CORE_END}          {yybegin(SV_CORE); return XCSTypes.CORE_END ;}
}


<SV_NAME_ASCII>{
    {SVID}              {yybegin(SV_CORE); return XCSTypes.SVID; }
    {VARIABLE_NAME}     {return XCSTypes.VARIABLE_NAME; }
    {ASCII_VALUE}       {yybegin(SV_CORE); return XCSTypes.ASCII_VALUE; }
    {PROPERTY_START}    {yybegin(SV_PROPERTY_ASCII); return XCSTypes.PROPERTY_START; }
    {CORE_START}        {yybegin(SV_CORE); return XCSTypes.CORE_START; }
    {CORE_END}          {yybegin(SV_CORE); return XCSTypes.CORE_END ;}
}

<SV_PROPERTY>{
    {PROPERTY_NAME_SV}    {return XCSTypes.PROPERTY_NAME_SV; }
    {EQUALS}              {return XCSTypes.EQUALS; }
    {PROPERTY_VALUE}      {return XCSTypes.PROPERTY_VALUE; }
    {PROPERTY_END}        {return XCSTypes.PROPERTY_END; }
    {VARIABLE_VALUE}      {return XCSTypes.VARIABLE_VALUE; }
    {CORE_START}          {yybegin(SV_CORE); return XCSTypes.CORE_START; }
    {CORE_END}            {yybegin(SV_CORE); return XCSTypes.CORE_END ;}
}

<SV_PROPERTY_ASCII>{
    {PROPERTY_NAME_SV}    {return XCSTypes.PROPERTY_NAME_SV; }
    {EQUALS}              {return XCSTypes.EQUALS; }
    {PROPERTY_VALUE}      {return XCSTypes.PROPERTY_VALUE; }
    {PROPERTY_END}        {yybegin(SV_NAME_ASCII);return XCSTypes.PROPERTY_END; }
}

////////////////////////////////////////////////////////////////////////////////
///////////////////////          VSS         ///////////////////////////////////
////////////////////////////////////////////////////////////////////////////////


<VSS_HEADER>{
    {COLON}                        {return XCSTypes.COLON; }
    {END_OF_FUNCTION_LINE_COMMENT} {return XCSTypes.FUNCTION_COMMENT; }
    {CORE_START}                   {yybegin(VSS_LIST); return XCSTypes.CORE_START; }
    {FUNCTION_END}                 {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}

<VSS_LIST>{
      //LIST
     {LIST_TYPE}                         {return XCSTypes.LIST_TYPE; }
     {CORE_START}                        {yybegin(VSS_CORE); return XCSTypes.CORE_START; }
}

<VSS_CORE>{
     //LIST
     {LIST_TYPE}                         {yybegin(VSS_NAME); return XCSTypes.LIST_TYPE; }
     {CORE_START}                        {return XCSTypes.CORE_START; }
     //ASCII
     {ASCII_TYPE}                        {yybegin(VSS_NAME_ASCII); return XCSTypes.ASCII_TYPE; }
     {ASCII_VALUE}                       {return XCSTypes.ASCII_VALUE; }

     {PROPERTY_START}                    {yybegin(VSS_PROPERTY); return XCSTypes.PROPERTY_START; }
     {CORE_END}                          {return XCSTypes.CORE_END ;}
     {END_OF_FUNCTION_LINE_COMMENT}      {return XCSTypes.FUNCTION_COMMENT; }
     {FUNCTION_END}                      {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}

<VSS_NAME>{
    {VFEI_CMD_ITEM_NAME}                {return XCSTypes.VFEI_CMD_ITEM_NAME; }
    {VARIABLE_NAME}                     {return XCSTypes.VARIABLE_NAME; }
    {VARIABLE_VALUE}                    {yybegin(VSS_CORE); return XCSTypes.VARIABLE_VALUE; }
    {PROPERTY_START}                    {yybegin(VSS_PROPERTY); return XCSTypes.PROPERTY_START; }
    {CORE_START}                        {yybegin(VSS_CORE); return XCSTypes.CORE_START; }
    {CORE_END}                          {yybegin(VSS_CORE); return XCSTypes.CORE_END; }
}

<VSS_NAME_ASCII>{
    {VFEI_CMD_ITEM_NAME}                {return XCSTypes.VFEI_CMD_ITEM_NAME; }
    {VARIABLE_NAME}                     {return XCSTypes.VARIABLE_NAME; }
    {ASCII_VALUE}                       {yybegin(VSS_CORE); return XCSTypes.ASCII_VALUE; }
    {PROPERTY_START}                    {yybegin(VSS_PROPERTY_ASCII); return XCSTypes.PROPERTY_START; }
    {CORE_START}                        {yybegin(VSS_CORE); return XCSTypes.CORE_START; }
    {CORE_END}                          {yybegin(VSS_CORE); return XCSTypes.CORE_END; }
}

<VSS_PROPERTY>{
     {PROPERTY_NAME_VSS}    {return XCSTypes.PROPERTY_NAME_VSS; }
     {EQUALS}               {return XCSTypes.EQUALS; }
     {PROPERTY_VALUE}       {return XCSTypes.PROPERTY_VALUE; }
     {PROPERTY_END}         {return XCSTypes.PROPERTY_END; }
     {VARIABLE_VALUE}       {return XCSTypes.VARIABLE_VALUE; }
     {CORE_START}           {yybegin(VSS_CORE); return XCSTypes.CORE_START; }
     {CORE_END}             {yybegin(VSS_CORE); return XCSTypes.CORE_END ;}
}

<VSS_PROPERTY_ASCII>{
     {PROPERTY_NAME_VSS}    {return XCSTypes.PROPERTY_NAME_VSS; }
     {EQUALS}               {return XCSTypes.EQUALS; }
     {PROPERTY_VALUE}       {return XCSTypes.PROPERTY_VALUE; }
     {PROPERTY_END}         {yybegin(VSS_NAME_ASCII);return XCSTypes.PROPERTY_END; }
}


[^]                     { return TokenType.BAD_CHARACTER; }