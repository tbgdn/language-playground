grammar PropertyFile;
file : prop+ ;
prop : ID '=' STRING NEWLINE ;
ID   : [a-z]+ ;
STRING : '"' .*? '"' ;
NEWLINE : '\r'? '\n' ;
