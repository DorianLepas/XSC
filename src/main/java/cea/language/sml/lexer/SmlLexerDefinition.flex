package cea.language.sml;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import cea.language.sml.psi.SmlTypes;
import com.intellij.psi.TokenType;

%%

%public
%class SmlLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType

%{
    // Vrai si le lexer se trouve dans un bloc if, else if, else ou condition
    boolean conditionBlock = false;
    // Vrao si le script que le lexer vient de lire se trouve à la racine du fichier
    boolean rootScript = false;

    // Nombre de début de bloc trouvé dans un code Javascript
    int nbBlockBegin = 0;
    // Nombre de fin de bloc trouvé dans un code Javascript
    int nbBlockEnd = 0;
%}

/* Espaces blancs */
WHITESPACE = \s
/* Fin de ligne */
END_OF_LINE = \R

/* Commentaires */
// Sur une ligne
ONELINE_COMMENT = "//"[^\r\n]* {END_OF_LINE}?
// Sur plusieurs lignes
MULTILINE_COMMENT = "/*" ([^*] | \*+ [^/*])* "*"+ "/"

/* Séparateur entre un mot clé et un nom d'état ou d'alias, etc... */
SEPARATOR = [:]

/* Délimiteurs de bloc */
// Début d'un bloc
BEGIN_BLOCK = "{"
// Fin d'un bloc
END_BLOCK = "}"

/* Noms d'états */
STATE_NAME = [\w]+

/* Noms d'alias */
ALIAS_NAME = [\w]+

/* Noms d'événements */
EVENT_NAME = [&]?[\w]+ | \'.+\'

/* Séparateur entre les noms d'événements dans une définition d'événements */
EVENT_NAME_SEPARATOR = ","

SET_VARIABLES = [a-zA-Z0-9\_$]+

THREAD_KEYWORD = #thread

PROCESS_KEYWORD = #process

DOT_SEPARATOR = \.

/* Variables en SML */
SML_VARS = (\#|\$|\@)[\w]+((\((\#|\$|\@)[\w]+\))?|(\.[\w]+)*)

/* Conditions */
// Constantes
CONSTANTES_CONDITIONS = \"[^\"]+\" | [0-9]+
// Opérateurs
OPERATORS_CONDITIONS = ("+"|"-"|"*"|"/"|"&&"|"||")
// Comparateurs
COMPARATORS_CONDITIONS = ("=="|"!="|"<="|"<"|">="|">")

/* Appels d'une fonction dans le code Java */
JAVA_FUNCTION_CALL = [\w]+(\.)*[\w]*("(".*")")*

/* Nom d'un thread */
THREAD_NAME = [\w]+

/* Clé d'indentification d'un état ou d'un thread */
IDENTIFICATION_KEY = \(.+\)

/* Messages de traces
(chaine de caractères pouvant se trouver après un MESSAGE, WARNING ou un DEBUG) */
TRACE_MESSAGE_STRING = (\"[^\"]+\")
TRACE_MESSAGE_SEPARATOR = [+]

/* Nom d'un lien */
BIND_NAME = [\w]+

/* Séparateur liens - expression mathématique associée */
EQUALS_SEPARATOR = [=]

/* Déclaration des états lexicaux du lexer */
%state  STATES_NAMES
%state  ALIAS_NAMES
%state  EVENTS_NAMES
%state  EVENTS_DEFINITIONS
%state  INSTRUCTIONS
%state  CONDITIONS
%state  OPTIONS
%state  STATES_CALLS
%state  THREADS_NAMES
%state  BINDINGS
%state  JAVASCRIPT_CODE
%state  CALL
%state  SET

%%

/* Tokens définis pour tous les états lexicaux */
// Espaces blancs
{WHITESPACE}+ { if(yystate() == STATES_CALLS) { yybegin(INSTRUCTIONS); } return TokenType.WHITE_SPACE; }
// Commentaires
{ONELINE_COMMENT}|{MULTILINE_COMMENT} { return SmlTypes.COMMENT; }
// Séparateur
{SEPARATOR} { return SmlTypes.SEPARATOR; }
// Début d'un bloc
{BEGIN_BLOCK} {
        if(yystate() == JAVASCRIPT_CODE) {
          nbBlockBegin++;
          return SmlTypes.JAVASCRIPT_CODE;
        } else if(yystate() == EVENTS_DEFINITIONS) {
          yybegin(INSTRUCTIONS);
        }
        return SmlTypes.BEGIN_BLOCK;
}
// Fin d'un bloc
{END_BLOCK} {
        if(yystate() == JAVASCRIPT_CODE && nbBlockBegin > nbBlockEnd && nbBlockBegin != 0) {
          nbBlockEnd++;
          return SmlTypes.JAVASCRIPT_CODE;
        } else if(yystate() == BINDINGS) {
          yybegin(JAVASCRIPT_CODE);
        } else if(conditionBlock) {
          conditionBlock = false;
          yybegin(INSTRUCTIONS);
        } else if(yystate() == INSTRUCTIONS || yystate() == OPTIONS || yystate() == EVENTS_NAMES) {
          yybegin(YYINITIAL);
        } else if(yystate() == JAVASCRIPT_CODE) {
          yybegin(rootScript ? YYINITIAL : INSTRUCTIONS);
        }
        return SmlTypes.END_BLOCK;
}

/* Etat lexical pour des mots clés des blocs pouvant se trouver à la racine du fichier */
<YYINITIAL> {
  //Mots clés des blocs pouvant se trouver à la racine du fichier (sauf binding)
  "state"   { yybegin(STATES_NAMES); return SmlTypes.STATE; }
  "alias"   { yybegin(ALIAS_NAMES); return SmlTypes.ALIAS; }
  "alarm"   { yybegin(EVENTS_DEFINITIONS); return SmlTypes.ALARM; }
  "event"   { yybegin(EVENTS_DEFINITIONS); return SmlTypes.EVENT; }
  "trace"   { yybegin(EVENTS_DEFINITIONS); return SmlTypes.TRACE; }
  "script"  { rootScript = true; return SmlTypes.SCRIPT; }
  "binding" { yybegin(BINDINGS); return SmlTypes.BINDING; }

  // Mots clés des blocs pouvant se trouver uniquement dans un état
  "enter"  { yybegin(INSTRUCTIONS); return SmlTypes.ENTER; }
  "exit"   { yybegin(INSTRUCTIONS); return SmlTypes.EXIT; }
  "option" { yybegin(OPTIONS); return SmlTypes.OPTION; }

  [\w]+ { return TokenType.BAD_CHARACTER; }
}

/* Etat lexical des noms d'états */
<STATES_NAMES> {
  {STATE_NAME}  { yybegin(YYINITIAL); return SmlTypes.STATE_NAME; }
}

/* Etat lexical des noms d'alias */
<ALIAS_NAMES> {
  {ALIAS_NAME}  { yybegin(EVENTS_NAMES); return SmlTypes.ALIAS_NAME; }
}

/* Etat lexical des noms d'événements */
<EVENTS_NAMES> {
  {EVENT_NAME}  { return SmlTypes.EVENT_NAME; }
}

/* Etat lexical des définitions d'événements */
<EVENTS_DEFINITIONS> {
  {EVENT_NAME}  { return SmlTypes.EVENT_NAME; }

  {EVENT_NAME_SEPARATOR}  { return SmlTypes.EVENT_NAME_SEPARATOR; }

  [*] { return SmlTypes.ALL_EVENTS; }
}

/* Etat lexical des conditions */
<CONDITIONS> {
  {THREAD_KEYWORD}  { return SmlTypes.THREAD_KEYWORD; }
  {PROCESS_KEYWORD}  { return SmlTypes.PROCESS_KEYWORD; }
  // Constantes
  {CONSTANTES_CONDITIONS} { return SmlTypes.CONST_CONDS; }
  // Opérateurs
  {OPERATORS_CONDITIONS}  { return SmlTypes.OP_CONDS; }
  // Comparateurs
  {COMPARATORS_CONDITIONS} { return SmlTypes.COMP_CONDS; }
  // Variables SML
  {SML_VARS}  { return SmlTypes.SML_VARS; }

  {JAVA_FUNCTION_CALL} ")"? {yybegin(INSTRUCTIONS); return SmlTypes.JAVA_FUNCTION_CALL; }

  "(" { return SmlTypes.BEGIN_PARENTHESE; }
  ")" { yybegin(INSTRUCTIONS); return SmlTypes.END_PARENTHESE; }
}

/* Etat lexical des options */
<OPTIONS> {
  "no_lookup" { return SmlTypes.OPTIONS; }
}

/* Etat lexical des instructions */
<INSTRUCTIONS> {
  // Mots clés des instructions
  "goto state"    { yybegin(STATES_CALLS); return SmlTypes.GOTO_STATE; }
  "process state" { yybegin(STATES_CALLS); return SmlTypes.PROCESS_STATE; }
  "call"          { yybegin(CALL);return SmlTypes.CALL; }
  "thread state"  { yybegin(THREADS_NAMES); return SmlTypes.THREAD_STATE; }
  "thread_end"    { return SmlTypes.THREAD_END; }
  "exec_end"      { return SmlTypes.EXEC_END; }
  "consume_event" { return SmlTypes.CONSUME_EVENT; }
  "MESSAGE"       { return SmlTypes.MESSAGE; }
  "DEBUG"         { return SmlTypes.DEBUG; }
  "WARNING"       { return SmlTypes.WARNING; }
  "set "          { yybegin(SET); return SmlTypes.SET; }

  // Mots clés des blocs considérés comme des instructions
  "condition" { conditionBlock = true; yybegin(CONDITIONS); return SmlTypes.CONDITION; }
  "if"        { conditionBlock = true; yybegin(CONDITIONS); return SmlTypes.IF; }
  "else if"   { conditionBlock = true; yybegin(CONDITIONS); return SmlTypes.ELSE_IF; }
  "else"      { return SmlTypes.ELSE; }
  "script"    { rootScript = false; return SmlTypes.SCRIPT; }
  "binding"   { yybegin(BINDINGS); return SmlTypes.BINDING; }

  {JAVA_FUNCTION_CALL} {return SmlTypes.JAVA_FUNCTION_CALL; }

  {THREAD_KEYWORD}  { return SmlTypes.THREAD_KEYWORD; }
  {PROCESS_KEYWORD}  { return SmlTypes.PROCESS_KEYWORD; }

  // Messages de traces (chaine de caractères pouvant se trouver après un MESSAGE, WARNING ou un DEBUG)
  {TRACE_MESSAGE_STRING}    { return SmlTypes.TRACE_MESSAGE_STRING; }
  {TRACE_MESSAGE_SEPARATOR} { return SmlTypes.TRACE_MESSAGE_SEPARATOR; }

  // Variables SML
  {SML_VARS}  { return SmlTypes.SML_VARS; }

  // Clé d'indentification d'un état ou d'un thread
  {IDENTIFICATION_KEY}  { return SmlTypes.IDENTIFICATION_KEY; }

}

<SET>{
  // Structure d'un set
  {EQUALS_SEPARATOR}  { yybegin(INSTRUCTIONS); return SmlTypes.EQUALS_SEPARATOR; }
  {THREAD_KEYWORD}  { return SmlTypes.THREAD_KEYWORD; }
  {PROCESS_KEYWORD}  { return SmlTypes.PROCESS_KEYWORD; }
  {DOT_SEPARATOR}  { return SmlTypes.DOT_SEPARATOR; }
  {SET_VARIABLES} { return SmlTypes.SML_VARS; }
  {SML_VARS}  { return SmlTypes.SML_VARS; }
  // Clé d'indentification d'un état ou d'un thread
  {IDENTIFICATION_KEY}  { return SmlTypes.IDENTIFICATION_KEY; }
}

<CALL>{
  // Appel d'un fonction dans le code Java
  {JAVA_FUNCTION_CALL}  { yybegin(INSTRUCTIONS); return SmlTypes.JAVA_FUNCTION_CALL; }
}

/* Etat lexical des appels d'états ou de sous-états */
<STATES_CALLS> {
  // Noms d'états (pour un appel d'état dans ce cas)
  {STATE_NAME}  { return SmlTypes.STATE_NAME; }

  // Point pour appeler un sous état lors d'un appel d'état
  "." { return SmlTypes.STATE_NAME_SEPARATOR; }

  // Clé d'indentification d'un état ou d'un thread
  {IDENTIFICATION_KEY}  { return SmlTypes.IDENTIFICATION_KEY; }
}

/* Etat lexical des noms de threads */
<THREADS_NAMES> {
  {THREAD_NAME} { yybegin(INSTRUCTIONS); return SmlTypes.THREAD_NAME; }
}

/* Etat lexical des liens */
<BINDINGS> {
  // Nom d'un lien
  {BIND_NAME}  { return SmlTypes.BIND_NAME; }

  // Séparateur lien - variable
  {EQUALS_SEPARATOR}  { return SmlTypes.EQUALS_SEPARATOR; }

  // Variables SML
  {SML_VARS}  { return SmlTypes.SML_VARS; }
}

/* Etat lexical du code Javascript */
<JAVASCRIPT_CODE> {
  [^\{\}] { return SmlTypes.JAVASCRIPT_CODE; }
}

/* Quand le lexer ne trouve aucun token */
[^] { return TokenType.BAD_CHARACTER; }