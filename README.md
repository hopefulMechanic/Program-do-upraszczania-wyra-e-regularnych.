# Program do upraszczania wyrażeń logicznych.

##### Autorzy:
### Sylwester M.
### Dominik Ż.


## Budowanie:
`mvn package`

## Uruchomienie:

### Preferowane za pomocą IntelliJ. Pozwala to na poręczniejsze uruchamianie i podawanie argumentów.


### Za pomocą command line:

##### Bez parametrów (wydrukuje sie pomoc):

`java -classpath lib/antlr4-runtime-4.7.2.jar:target/logic-expression-simplifier-1.0-SNAPSHOT.jar logic.expression.simplifier.Main`


##### Z przykladowym rownaniem do uproszczenia:

`java -classpath lib/antlr4-runtime-4.7.2.jar:target/logic-expression-simplifier-1.0-SNAPSHOT.jar logic.expression.simplifier.Main "((NOT A XOR B) XNOR C) AND (B AND A) NOR B OR FALSE"`
