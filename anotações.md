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