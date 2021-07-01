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
VFEI_SECS_SEQ=VFEI_SECS_SEQUENCES
FUNCTION_NAME=\w+

COLON=:
STREAM_FUNCTION=S\d+F\d+(" W")?
CORE_START=<

VARIABLE_TYPE=(U|I)[1248]|F[48]|(L|B|V|BOOLEAN|Boolean)(\[\d+\])?|J|A|V
VARIABLE_NAME=\w+
VARIABLE_VALUE=(\w+)|(\'\w+\')|(\-\w+)
CEID=CEID
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
PROPERTY_NAME_VSS=CheckAck|SecsItemsToCheck

ASCII_TYPE=A(\[\d+\])?|A
ASCII_VALUE=\".*\"
LIST_TYPE=L(\[\d+\])?|L

CORE_END=>
FUNCTION_END=.

//STATE
%state FUNCTION_HEADER
%state CE_HEADER
%state VSS_HEADER

//FUNCTION
%state CORE
%state NAME
%state PROPERTY

//COLLLECTION EVENT
%state CE_CORE
%state CE_NAME
%state CE_PROPERTY

//VFEI SECS SEQUENCES
%state VSS_CORE
%state VSS_LIST_1
%state VSS_LIST_2
%state VSS_PROPERTY


%%



<YYINITIAL> {END_OF_LINE_COMMENT}               { yybegin(YYINITIAL); return XCSTypes.COMMENT; }
<YYINITIAL> {END_OF_FUNCTION_LINE_COMMENT}      { yybegin(YYINITIAL); return XCSTypes.FUNCTION_COMMENT; }
{WHITE_SPACE}                                   {return TokenType.WHITE_SPACE; }


<YYINITIAL>{
    {COLLECTION_EVENT}  { yybegin(CE_HEADER); return XCSTypes.COLLECTION_EVENT; }
    {VFEI_SECS_SEQ}     { yybegin(VSS_HEADER); return XCSTypes.VFEI_SECS_SEQ; }
    {FUNCTION_NAME}     { yybegin(FUNCTION_HEADER); return XCSTypes.FUNCTION_NAME; }
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
     {ASCII_TYPE}                        {yybegin(NAME); return XCSTypes.ASCII_TYPE; }
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
    {PROPERTY_START}    {yybegin(PROPERTY); return XCSTypes.PROPERTY_START; }
    {ASCII_VALUE}       {yybegin(CORE); return XCSTypes.ASCII_VALUE; }
    {VARIABLE_VALUE}    {yybegin(CORE); return XCSTypes.VARIABLE_VALUE; }
    {CORE_START}        {yybegin(CORE); return XCSTypes.CORE_START; }
    {CORE_END}          {yybegin(CORE); return XCSTypes.CORE_END ;}
}

<PROPERTY>{
     {PROPERTY_NAME}    {return XCSTypes.PROPERTY_NAME; }
     {EQUALS}           {return XCSTypes.EQUALS; }
     {PROPERTY_VALUE}   {return XCSTypes.PROPERTY_VALUE; }
     {PROPERTY_END}     {yybegin(CORE);return XCSTypes.PROPERTY_END; }
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
     {CORE_START}                        {yybegin(CE_CORE); return XCSTypes.CORE_START; }
     //ASCII
     {ASCII_TYPE}                        {yybegin(CE_NAME); return XCSTypes.ASCII_TYPE; }
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
    {PROPERTY_START}    {yybegin(CE_PROPERTY); return XCSTypes.PROPERTY_START; }
    {ASCII_VALUE}       {yybegin(CE_CORE); return XCSTypes.ASCII_VALUE; }
    {VARIABLE_VALUE}    {yybegin(CE_CORE); return XCSTypes.VARIABLE_VALUE; }
    {CORE_START}        {yybegin(CE_CORE); return XCSTypes.CORE_START; }
    {CORE_END}          {yybegin(CE_CORE); return XCSTypes.CORE_END ;}
}

<CE_PROPERTY>{
     {PROPERTY_NAME_CE}    {return XCSTypes.PROPERTY_NAME_CE; }
     {EQUALS}              {return XCSTypes.EQUALS; }
     {PROPERTY_VALUE}      {return XCSTypes.PROPERTY_VALUE; }
     {PROPERTY_END}        {yybegin(CE_CORE);return XCSTypes.PROPERTY_END; }
}


////////////////////////////////////////////////////////////////////////////////
///////////////////////          VSS         ///////////////////////////////////
////////////////////////////////////////////////////////////////////////////////


<VSS_HEADER>{
    {COLON}                        {return XCSTypes.COLON; }
    {END_OF_FUNCTION_LINE_COMMENT} {return XCSTypes.FUNCTION_COMMENT; }
    {CORE_START}                   {yybegin(VSS_LIST_1); return XCSTypes.CORE_START; }
    {FUNCTION_END}                 {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}

<VSS_LIST_1>{
      //LIST
     {LIST_TYPE}                         {return XCSTypes.LIST_TYPE; }
     {CORE_START}                        {yybegin(VSS_LIST_2); return XCSTypes.CORE_START; }
}

<VSS_LIST_2>{
      //LIST
     {LIST_TYPE}                         {return XCSTypes.LIST_TYPE; }
     {VFEI_CMD_ITEM_NAME}                {return XCSTypes.VFEI_CMD_ITEM_NAME; }
     {CORE_START}                        {yybegin(VSS_CORE); return XCSTypes.CORE_START; }
}

<VSS_CORE>{
     //ASCII
     {ASCII_TYPE}                        {return XCSTypes.ASCII_TYPE; }
     {ASCII_VALUE}                       {return XCSTypes.ASCII_VALUE; }

     {PROPERTY_START}                    {yybegin(VSS_PROPERTY); return XCSTypes.PROPERTY_START; }
     {CORE_START}                        {return XCSTypes.CORE_START; }
     {CORE_END}                          {return XCSTypes.CORE_END ;}
     {END_OF_FUNCTION_LINE_COMMENT}      {return XCSTypes.FUNCTION_COMMENT; }
     {FUNCTION_END}                      {yybegin(YYINITIAL); return XCSTypes.FUNCTION_END; }
}

<VSS_PROPERTY>{
     {PROPERTY_NAME_VSS}    {return XCSTypes.PROPERTY_NAME_VSS; }
     {EQUALS}               {return XCSTypes.EQUALS; }
     {PROPERTY_VALUE}       {return XCSTypes.PROPERTY_VALUE; }
     {PROPERTY_END}         {yybegin(VSS_CORE);return XCSTypes.PROPERTY_END; }
}


[^]                     { return TokenType.BAD_CHARACTER; }