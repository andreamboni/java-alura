# Anotações Java

## Curso 1 (De 26/01/2021 a ??? - Revisão)

### Java JRE e JDK: Escreva o seu primeiro código com Eclipse

JRE (Java Runtime Enviroment) é composto pela JVM (Java Virtual Machine) e por bibliotecas. O JVM é utilizar para ler e executar o bytecode. 

JDK (Java Development Kit) é composto pelo JRE mais o kit para desenvolver aplicações Java. Dentro do JDK está o compilador Java, que é utilizado para gerar o bytecode que a JVM vai executar. 

#### Observações da instalação no Windows

Quando instalamos o JDK em um ambiente Windows, se tentarmos executar o comando ```javac``` (que chama o compilador do Java) no ```cmd```, o terminal não vai encontrar o compilador e nos dará uma mensagem de erro. Para que esse comando funcione, precisamos colocar o diretório ``bin`` (de binário) no nosso ambiente de variáveis. 

#### "Primeiro" programa Java

Como é tradição, o meu "primeiro" programa em Java vou exibir a mensagem ```Olá mundo!```. Diferente do C, Java é um pouco mais verboso, então preciso escrever um pouco mais para exibir a minha mensagem. 

```java
    public class Programa {
        public static void main(String[] args) {
            System.out.println("Olá mundo!");
        }
    }

```
Esse arquivo será salvo como Programa.java. O nome do arquivo precisa ter o mesmo nome da classe principal do programa, nesse caso é ``Programa``, e precisamos usar a extenção ``.java`` para conseguir compilar. 

Para compilar esse programa no terminal, vamos inserir o comando ``javac Programa.java``. 

Depois de compilado, é gerado um novo arquivo chamado ``Programa.class`` e para executá-lo, vamos chamar a JVM com o comando ``java Programa``. Quando vamos executar, nós não temos que passar o nome do arquivo, tipo ```Programa.class```, mas sim chamar a classe principal (não sei se é correto chamar de classe principal), que é ```Programa```. 

#### Observações sobre o Eclipse

A tela toda do Eclipse é chamada de ``perspectiva``, que é composta de várias ``views``. Onde eu edito o meu código, vejo os meus arquivos ou as mensagens de erro são ``views``. 

#### Tipagem

O Java é estaticamente e fortemente tipado, ou seja, toda vez que vamos declarar uma variável, temos que indicar qual vai ser o tipo dela. 

#### Características (pegadinhas)

Existem algumas particularidades quando operações matemágicas são feitas com Java. 

Primeiro caso: se tentarmos dividir ``5`` por ``2`` como ``int``, o Java não fazer um arredondamento, ele vai truncar o valor.

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

O que acontece nesse caso é que o Java primeiro faz a operação da direita e depois volta pra esquerda para ver o tipo, como ele não encontrou nenhum número com ponto flutuante na direita, depois que ele ler o ``double`` na esquerda ele não vai refazer a conta. Para obter o resultado de ``2.5``, temos que fazer conforme abaixo: 

```java
double divisao = 5.0 / 2;
System.out.println(divisao);
// Resultado: 2.5
```

Quando o compilador lê o ``5.0``, ele já entende que é um double, e com isso faz a operação e o resultado é ``2.5``. 

#### Type casting 

Type casting é uma conversão de tipos. Vamos supor que declarei uma variável double salario = 15000.00 e depois uma int valor = salario. Isso aqui não vai compilar porque não são do mesmo tipo. Para fazer isso da certo, temos que usar o type casting, assim: 

```java
double salario = 15000.00;
int valor = (int) salario;
```

Se fizermos o oposto, conforme abaixo, o compilador não encontra erro pois é possível colocar um ``int`` dentro de um ``double``

```java
int salario = 15000;
double valor = salario;
```

#### Tipos primitivos

+ int: valor de 32 bits
+ long: valor de 64 bits
+ short:  valor de 16 bits
+ double: valor de 64 bits
+ float: valor de 32 bits
+ byte: valor de um byte 

Quando vamos declarar um long, precisamos colocar o ``l`` ou ``L`` de literal no final do número, assim: 

```java
long numeroGrande = 123445L;
```

No float é parecido, ou a gente põe um ``f`` ou fazemos o type casting. 

```java
float pontoFlutuante1 = 22.3f;
float pontoFlutuante2 - (float) 234,3;
```
