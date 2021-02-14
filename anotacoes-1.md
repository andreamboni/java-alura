# Curso 1 (De 26/01/2021 a 30/01/2021 - Revisão)

## Java JRE e JDK: Escreva o seu primeiro código com Eclipse

JRE (Java Runtime Enviroment) é composto pela JVM (Java Virtual Machine), bibliotecas de classe Java e o carregador dessas classes. O JVM é utilizado para ler e executar o bytecode gerador pelo compilador. 

JDK (Java Development Kit) é composto pelo JRE mais o kit para desenvolver aplicações Java. Dentro do JDK está o compilador Java, que é utilizado para gerar o bytecode que a JVM vai executar. 

### Observações da instalação no Windows

Quando instalamos o JDK em um ambiente Windows, se tentarmos executar o comando ```javac``` (que chama o compilador do Java) no ```cmd```, o terminal não vai encontrar o compilador e nos dará uma mensagem de erro. Para que esse comando funcione, precisamos colocar o diretório ``bin`` (que significa binário) no nosso ambiente de variáveis. 

### "Primeiro" programa Java

Como é tradição, o meu "primeiro" programa em Java irá exibir a mensagem ```Olá mundo!```. Diferente do C, Java é um pouco mais verboso, então preciso escrever um pouco mais para exibir a minha mensagem. 

```java
    public class Programa {
        public static void main(String[] args) {
            System.out.println("Olá mundo!");
        }
    }

```
Esse arquivo será salvo como Programa.java. O nome do arquivo precisa ter o mesmo nome da classe principal do programa, nesse caso é ``Programa``, e precisamos usar a extenção ``.java`` para conseguir compilar. 

Para fazer a compilação pelo terminal, vamos inserir o comando ``javac Programa.java``. 

Depois de compilado, é gerado um novo arquivo chamado ``Programa.class`` e para executá-lo, vamos chamar a JVM com o comando ``java Programa``. Quando vamos executar, não é necessário passar o nome do arquivo, tipo ```Programa.class```, mas sim chamar a classe principal, que é ```Programa```. 

### Observações sobre o Eclipse

A tela toda do Eclipse é chamada de ``perspectiva``, que é composta de várias ``views``. São nas ``views`` que eu edito o meu código e verifico os meus erros, por exemplo.

### Tipagem

O Java é estaticamente e fortemente tipado, ou seja, toda vez que vamos declarar uma variável, temos que indicar qual vai ser o tipo dela. 

### Características (pegadinhas)

Existem algumas particularidades quando operações matemágicas são feitas com Java. 

Primeiro caso: se tentarmos dividir ``5`` por ``2`` como ``int``, o Java não vai fazer um arredondamento, ele vai truncar o valor.

```java
int divisao = 5 / 2;
System.out.println(divisao);
// Resultado: 2
```

Segundo caso: se tentarmos fazer a mesma divisão, só que com o tipo ``double``, o resultado é quase o mesmo.

```java
double divisao = 5 / 2;
System.out.println(divisao);
// Resultado: 2.0
```

O que acontece nesse caso é que o Java primeiro faz a operação da direita e depois volta para a  esquerda para ver o tipo, como ele não encontrou nenhum número com ponto flutuante na direita, depois que ele ler o ``double`` na esquerda ele não vai refazer a conta. Para obter o resultado de ``2.5``, temos que fazer conforme abaixo: 

```java
double divisao = 5.0 / 2;
System.out.println(divisao);
// Resultado: 2.5
```

Quando o compilador lê o ``5.0``, ele já entende que é um ``double``, e com isso faz a operação e o resultado é ``2.5``. 

### Type casting 

``Type casting`` é uma conversão de tipos. Vamos supor que declarei uma variável ``double salario = 15000.00`` e depois uma ``int valor = salario``. Esse código não vai compilar porque as variáveis não são do mesmo tipo. Para dar certo, temos que usar o type casting. Assim: 

```java
double salario = 15000.00;
int valor = (int) salario;
```

Se declararmos int`` salario = 15000`` e ``double valor = salario``, não há necessidade de fazer o ``type casting``, pois um ``int`` cabe dentro de um ``double``.

```java
int salario = 15000;
double valor = salario;
```

### Tipos primitivos

| Tipo   | Tamanho |
| -------| ------- |
| byte   | 8 bits  |
| int    | 32 bits |
| long   | 64 bits |
| short  | 16 bits |
| double | 64 bits |
| float  | 32 bits |

Quando vamos declarar um ``long``, precisamos colocar o ``l`` ou ``L`` no final do número, para indicar que é um literar.Assim: 

```java
long numeroGrande = 123445L;
// Ou
long numeroGrande2 = 123543l;
```

No float é parecido, ou a gente põe um ``f`` ou fazemos o type casting. 

```java
float pontoFlutuante1 = 22.3f;
// Ou
float pontoFlutuante2 = (float) 234,3;
```

### Char e String 

Além dos tipos primitivos citados acima, temos o tipo ``char``, que armazena somente um caractere entre aspas simples. Assim como no C, o ``char`` é um ``int`` que aceita números naturais.

Se colocarmos um número dentro de uma variável ``char`` e depois printar, ele vai trazer o caractere correspondente na tabela ``UNICODE``. 

**Exemplo 1:** 

```java
char letra = 'a';
char codigoLetra = 97; 
```

No exemplo acima, eu declarei duas variáveis aparentemente com dois valores diferentes. Porém, quando printar elas, os resultados serão iguais:  ``a``. 

Isso ocorre porque atribuimos o literal ``a`` na variável ``letra`` e no ``codigoLetra`` estamos passando o número que correspondente à letra ``a`` na tabela ``UNICODE``. 

**Exemplo 2:**

```java
char letra = 'a';
letra = (char) (letra + 1);
```

Aqui eu estou querendo printar a próxima letra na tabela ``UNICODE`` fazendo uma soma. No Java eu não posso simplesmente somar ``letra = letra + 1``. Se fizermos isso, o código não compila. Isso ocorre porque quando o compilador fizer a soma de ``letra + 1``, ele vai converter tudo para ``int``, que é um tipo maior (maior de tamanho mesmo, visto que ele comporta um número de 64 bits), e um ``int`` não cabe em um ``char``. Nesse caso precisamos fazer duas alterações: a primeira é usar o type casting inserindo o (char) antes da soma; e a segunda é colocar a soma entre parenteses.

A gente pode escrever essa soma de uma forma melhor também. Abaixo seguem duas opções: 

```java
char letra = 'a';
letra += (char) 1;
```

```java
char letra = 'a';
letra++;
```

A ```String``` não é um tipo primitivo do Java, tem um arquivo bem lindo que eu não entendi nada fazendo a definição de tipo. Com a string, é possível colocar uma cadeia de caracteres entre aspas duplas, conforme abaixo: 

```java
String palavra = "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
```

Como ele não é um tipo primitivo, nós declaramos ele com a inicial maiúscula. 

Também podemos concatenar strings com strings ou com outros tipos usando o sinal ``+``

### Estrutura de decisão, famoso if 

O ``if`` no Java é igual ao C. Se tivermos somente uma ação dentro de uma condição, as chaves não são necessárias, mas é boa prática usá-las mesmo assim. 

Também temos o ``else if``, da mesma forma que temos no C. 

**Exemplo:**

```java

if (idade >= 18) {
    System.out.println("Você tem mais de 18 anos, seja bem-vindo");
} else if (quantidadePessoas >= 2) {
    System.out.println("Você não tem 18 anos, mas pode entrar, pois está acompanhado");
} else {
    System.out.println("Infelizmente você não pode entrar");
}
```

### Boolean, expressões booleanas e alguns operadores lógicos

O ``boolean`` é mais um tipo primitivo do Java. Esse tipo aceita somente duas coisas: ``true`` e ``false``. 

```java
boolean trueCondition = true;
boolean falseCondition = false; 
```

Podemos também colocar uma expressão booleana dentro de um boolean: 

```java
boolean peopleQuantity = 3;
boolean booleanExpression = peopleQuantity >= 2;
```

Se imprimirmos a variável ``booleanExpression``, teremos o valor ``true`` como resposta. 

As condicionais que inserimos dentro de um if também é uma expressão booleana.

```java
if (booleanExpression) {
    System.out.println("Bem-vindo");
} else {
    System.out.println("Você não pode entrar");
}
```

Quando colocamos só o nome da variável dentro do parênteses do ``if``, é a mesma coisa se colocassemos ``if (booleanExpression == true)``. 

Falamos de operadores lógicos um pouco mais acima. O Java também tem os operadores ``||`` e ``&&``, igual ao C. 

### Escopo de variáveis

Escopo nada mais é do que quando uma variável nasce e morre. Por exemplo: 

```java
public static void main (String[] args) {
    int primeiraVariavel = 1;
    int segundaVariavel = 2; 

    if (primeiraVariavel == 1) {
        boolean teste = true;
    } else {
        boolean teste = false; 
    }
}
```

As variáveis ``primeiraVariavel`` e ``segundaVariavel`` existem a partir da linha 217 e 218 respectivamente e morrem na linha ``225`` que é justamente onde tem a chave que fecha o ``public static void main``. Já a variável ``teste`` nasce a primeira vez na linha ``221`` e morre na linha seguinte, e nasce de novo na linha ``223`` e morre na linha seguinte, seguindo a mesma regra da anterior. Se eu tentar printar ``teste`` depois da linha ``224``, eu não vou conseguir porque ela não foi declarada dentro do escopo que ``sysout`` está. 

Obs: eu não criei o arquivo ``TestaEscopo`` no Eclipse porque achei melhor explicar aqui. 

### Laços

No Java existem os mesmos loops que temos no C. ``While``, ``For`` e ``Do While``. A sintaxe e modo de funcionamento são os mesmos.