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
EQUIPMENT_CONSTANT=EQUIPMENTCONSTANTS
SECS_ITEM_TYPE=SECSITEM_TYPES
STATUS_VARIABLE=STATUSVARIABLES
VFEI_SECS_SEQ=VFEI_SECS_SEQUENCES
FUNCTION_NAME=\w+

COLON=:
STREAM_FUNCTION=S\d+F\d+(" W")?
CORE_START=<

VARIABLE_TYPE=(U|I)[1248]|F[48]|(B|V|BOOLEAN|Boolean)(\[\d+\])?|J|V
VARIABLE_NAME=\w+
VARIABLE_VALUE=(\w+)|(\'\w+\')|(\-\w+)|(\'\-\w+\')
CEID=CEID
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
PROPERTY_VALUE=\"\w+\"
PROPERTY_NAME_CE=VfeiName|SecsType|ReplaceVfeiName|ReplaceItems|EventLevel8
PROPERTY_NAME_EC=VfeiName|VfeiType|SecsType|MinSecsValue|DefaultSecsValue
PROPERTY_NAME_SV=VfeiName|VfeiType|SecsType|SecsValueToVfeiText|SecsValueAlignment|ReplaceVfeiName|ReplaceItems
PROPERTY_NAME_VSS=CheckAck|SecsItemsToCheck

ASCII_TYPE=A(\[\d+\])?|A
ASCII_VALUE=(\".*\")|(\'.*\')
LIST_TYPE=L(\[\d+\])?|L

CORE_END=>
FUNCTION_END=.

//STATE
%state FUNCTION_HEADER
%state CE_HEADER
%state EC_HEADER
%state SIT_HEADER
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

//EQUIPMENT CONSTANT
%state EC_CORE
%state EC_NAME
%state EC_NAME_ASCII
%state EC_PROPERTY
%state EC_PROPERTY_ASCII

//SECSITEM TYPES
%state SIT_CORE
%state SIT_NAME

//STATUS VARIABLE
%state SV_CORE
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
    {EQUIPMENT_CONSTANT}    { yybegin(EC_HEADER); return XCSTypes.EQUIPMENT_CONSTANT; }
    {SECS_ITEM_TYPE}        { yybegin(SIT_HEADER); return XCSTypes.SECS_ITEM_TYPE; }
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
    {CORE_START}        {yybegin(CORE); return XCSTypes.CORE_START; }
    {CORE_END}          {yybegin(CORE); return XCSTypes.CORE_END ;}
}

<NAME_ASCII>{
    {VARIABLE_NAME}     {yybegin(CORE); return XCSTypes.VARIABLE_NAME; }
    {ASCII_VALUE}       {yybegin(CORE); return XCSTypes.ASCII_VALUE; }
    {PROPERTY_START}    {yybegin(PROPERTY_ASCII); return XCSTypes.PROPERTY_START; }
    {CORE_START}        {yybegin(CORE); return XCSTypes.CORE_START; }
    {CORE_END}          {yybegin(CORE); return XCSTypes.CORE_END ;}
}

<PROPERTY>{
     {PROPERTY_NAME}    {return XCSTypes.PROPERTY_NAME; }
     {EQUALS}           {return XCSTypes.EQUALS; }
     {PROPERTY_VALUE}   {return XCSTypes.PROPERTY_VALUE; }
     {PROPERTY_END}     {yybegin(NAME);return XCSTypes.PROPERTY_END; }
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
    {PROPERTY_END}        {yybegin(CE_NAME);return XCSTypes.PROPERTY_END; }
}

<CE_PROPERTY_ASCII>{
    {PROPERTY_NAME_CE}    {return XCSTypes.PROPERTY_NAME_CE; }
    {EQUALS}              {return XCSTypes.EQUALS; }
    {PROPERTY_VALUE}      {return XCSTypes.PROPERTY_VALUE; }
    {PROPERTY_END}        {yybegin(CE_NAME_ASCII);return XCSTypes.PROPERTY_END; }
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
    {PROPERTY_END}        {yybegin(EC_NAME);return XCSTypes.PROPERTY_END; }
}

<EC_PROPERTY_ASCII>{
    {PROPERTY_NAME_EC}    {return XCSTypes.PROPERTY_NAME_EC; }
    {EQUALS}              {return XCSTypes.EQUALS; }
    {PROPERTY_VALUE}      {return XCSTypes.PROPERTY_VALUE; }
    {PROPERTY_END}        {yybegin(EC_NAME_ASCII);return XCSTypes.PROPERTY_END; }
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

<SV_HEADER>{
    {COLON}                        {return XCSTypes.COLON; }
    {END_OF_FUNCTION_LINE_COMMENT} {return XCSTypes.FUNCTION_COMMENT; }
    {CORE_START}                   {yybegin(SV_CORE); return XCSTypes.CORE_START; }
    {FUNCTION_END}                 {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
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
    {VARIABLE_VALUE}    {yybegin(SV_CORE); return XCSTypes.VARIABLE_VALUE; }
    {PROPERTY_START}    {yybegin(SV_PROPERTY); return XCSTypes.PROPERTY_START; }
    {CORE_START}        {yybegin(SV_CORE); return XCSTypes.CORE_START; }
    {CORE_END}          {yybegin(SV_CORE); return XCSTypes.CORE_END ;}
}

<SV_NAME_ASCII>{
    {SVID}              {yybegin(SV_CORE); return XCSTypes.SVID; }
    {ASCII_VALUE}       {yybegin(SV_CORE); return XCSTypes.ASCII_VALUE; }
    {PROPERTY_START}    {yybegin(SV_PROPERTY_ASCII); return XCSTypes.PROPERTY_START; }
    {CORE_START}        {yybegin(SV_CORE); return XCSTypes.CORE_START; }
    {CORE_END}          {yybegin(SV_CORE); return XCSTypes.CORE_END ;}
}

<SV_PROPERTY>{
    {PROPERTY_NAME_SV}    {return XCSTypes.PROPERTY_NAME_SV; }
    {EQUALS}              {return XCSTypes.EQUALS; }
    {PROPERTY_VALUE}      {return XCSTypes.PROPERTY_VALUE; }
    {PROPERTY_END}        {yybegin(SV_NAME);return XCSTypes.PROPERTY_END; }
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
     {PROPERTY_END}         {yybegin(VSS_NAME);return XCSTypes.PROPERTY_END; }
}

<VSS_PROPERTY_ASCII>{
     {PROPERTY_NAME_VSS}    {return XCSTypes.PROPERTY_NAME_VSS; }
     {EQUALS}               {return XCSTypes.EQUALS; }
     {PROPERTY_VALUE}       {return XCSTypes.PROPERTY_VALUE; }
     {PROPERTY_END}         {yybegin(VSS_NAME_ASCII);return XCSTypes.PROPERTY_END; }
}


[^]                     { return TokenType.BAD_CHARACTER; }