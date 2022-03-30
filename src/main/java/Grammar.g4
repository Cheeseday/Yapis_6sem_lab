grammar Grammar;

program
	: (declare_func)* (operator)*
	;

declare_func
	:  type? NAME '(' type NAME ( ',' type NAME)* ')' ( '{' list_operator '}' )*
	;

type
	: 'Void' | 'Set' | 'Element'
	;

list_operator
	: ( operator )+
	;

operator
	: (declare_var | assign_op | call_func | if_op | for_op | print | add | get | delete | '{' list_operator '}') (';')*
	;

declare_var
	: type NAME ( '=' expr )?
	;

assign_op
	: NAME '=' expr
	;

call_func
	: NAME '(' arg_list ')'
	;

if_op
	: IF '(' expr ')' operator ( ELSE operator )?
	;

for_op
	: FOR '(' NAME ',' NAME ')' operator
	;

arg_list
	: expr ( ',' expr )*
	;

expr
	: NAME | STRING | NUMBER | get | call_func | NAME '.' expr | NAME '+' expr | NAME '<' expr
	;

print
    : PRINT '(' (NAME | STRING | size ) ')'
    ;

add
    : ADD '(' NAME ',' NAME ')'
    ;

delete
    : DELETE '(' NAME ',' (NAME | NUMBER) ')'
    ;

get
    : GET '(' NAME ',' NUMBER ')'
    ;

size
    : SIZE '(' NAME ')'
    ;

OPENING_CURLY_BRACE
	: '{'
	;

CLOSING_CURLY_BRACE
	: '}'
	;

OPENING_BRACE
	: '('
	;

CLOSING_BRACE
	: ')'
	;

COMMA
	: ','
	;

DOT
	: '.'
	;

DOT_COMMA
	:	';'
	;

ASSIGN
	: '='
	;

PLUS
	: '+'
	;

MINUS
    : '-'
    ;

LESS
	: '<'
	;

PRINT
    : 'Print'
    ;

ADD
    : 'Add'
    ;

DELETE
    : 'Delete'
    ;

GET
    : 'Get'
    ;

SIZE
    : 'Size'
    ;

FOR
	: 'For'
	;

IF
	: 'If'
	;

ELSE
	: 'Else'
	;

TYPE_VOID
	:	'Void'
	;

TYPE_SET
	:	'Set'
	;

TYPE_ELEMENT
	:	'Element'
	;

STRING
	:	'"' (.)+? '"'
	;

NUMBER
	:	[0-9]+
	;

NAME
	: LETTER+ ('.' LETTER+ )?
	;

fragment LETTER
	: ('a'..'z'|'A'..'Z')
	;

WS
   : (' ' | '\t' | '\n' | '\r') -> skip
   ;

COMMENT
    : ('/*' ~('\n'|'\r')* '\r'? '\n' '*/') -> skip
    ;

LINE_COMMENT
    : ('//' ~('\n'|'\r')* '\r'? '\n') -> skip
    ;