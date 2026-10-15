# Prática 3 - Herança e Polimorfismo

Implementação dos dois exercícios: agenda telefônica e bilheteria de eventos.

## Executar

Requer JDK 25, conforme o pom.xml original. Na raiz do projeto:

```bash
mvn compile
java -cp target/classes org.example.Main
```

Sem Maven:

```bash
javac -encoding UTF-8 -d target/classes src/main/java/org/example/*.java
java -cp target/classes org.example.Main
```

Escolha 1 para agenda ou 2 para bilheteria. Cada submenu contém as opções 1 até 7 do enunciado. A opção 7 finaliza o módulo e volta à seleção; 0 finaliza o programa. Os cadastros são mantidos em memória ao alternar entre módulos e descartados ao encerrar.

A agenda busca por igualdade de nome, email ou telefone, ignorando maiúsculas e espaços nas extremidades. Se houver nomes repetidos, a busca e a remoção por nome selecionam o primeiro. A busca por telefone usa o telefone (o enunciado repete “nome” nesse item por aparente erro de digitação).

A bilheteria utiliza códigos únicos. Os valores finais são 100% do valor base para ingresso comum, 50% para estudante e 180% para VIP. A listagem e a arrecadação usam os métodos polimórficos de Ingresso.

Os setters das listas fazem cópias; os getters devolvem listas não modificáveis. A quantidade da agenda é atualizada pelas operações de cadastro e remoção; seu setter só aceita a quantidade correspondente à lista.
