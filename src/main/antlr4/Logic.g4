grammar Logic;

parse
    : expression EOF ;

expression
    : LPAREN expression RPAREN                                      #parenExpression
    | NOT expression                                                #notExpression
    | left=expression op=binary right=expression                    #binaryExpression
    | LPAREN left=expression RPAREN LPAREN right=expression RPAREN  #posExpression
    | bool                                                          #boolExpression
    | IDENTIFIER                                                    #identifierExpression
    ;

binary
    : AND | OR | XOR | XNOR | NAND | NOR
    ;

bool
    : TRUE | FALSE
    ;

AND    : 'AND' ;
OR     : 'OR' ;
NOT    : 'NOT';
XOR    : 'XOR';
XNOR   : 'XNOR';
NOR    : 'NOR';
NAND   : 'NAND';

TRUE   : 'TRUE' ;
FALSE  : 'FALSE' ;
LPAREN : '(' ;
RPAREN : ')' ;

IDENTIFIER : [a-zA-Z_] [a-zA-Z_0-9]* ;
WS         : [ \r\t\n]+ -> skip;