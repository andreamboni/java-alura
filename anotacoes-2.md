# Curso 2 (De 30/01/2021 a ??? - Revisão)

## Java OO

### Especificando um objeto e criando ele

Nesse curso nós vamos fazer um banco chamado bytebank. Esse banco terá quatro atributos: saldo, conta, agência e titular. 

Antes de sair criando contas e me dando o saldo que eu quiser, eu preciso criar uma especificação para essa conta. Como se fosse um blueprint de uma casa. 

Para isso, eu vou criar uma classe chamada ``Conta`` e colocar os atributos dela: 

```java
public class Conta {
    double saldo;
    int agencia;
    int conta;
    String titular;
}
```

Nessa classe eu não uso ``public static void main`` porque ele não será o ponto de partida da minha aplicação. Essa classe contém as regras que eu vou usar para criar contas em outras classes. São os atributos para que um **objeto Conta** vai ter quando for criado. 

Os atributos nada mais são que **caracteristicas da classe**, que também serão as caracteristicas dos objetos que for criar do tipo ``Conta``. 

Outros sinônimos para atributos nesse contexto são **campos** ou **propriedade**. 

Agora que eu tenho as minhas especificações, vou criar uma classe chamada ``CriaConta`` para criar um objeto Conta.

Para criar esse objeto, eu tenho que declarar uma variável do tipo ``Conta`` e depois do ``=`` eu tenho que usar o ``new Conta()``. Fica assim: 

```java
public class CriaConta {
    public static void main(String[] args) {
        Conta primeiraConta = new Conta();
    }
}
```

Agora eu quero colocar um valor no saldo dessa minha conta, então vou fazer assim: 

```java
public class CriaConta {
    public static void main(String[] args) {
        Conta primeiraConta = new Conta();
        primeiraConta.saldo = 200.0;
    }
}
```

O ``.`` é forma que eu uso para navegar entre os atributos da minha classe ``Conta``. 

Quando a gente declara uma variável para criar um objeto, nós não estamos armazenando o objeto em si na variável, nós estamos apontando para ela na memória. O conceito é parecido com o de ponteiro no C. 

Um objeto pode ser chamado de instância, e o processo de criar um objeto pode ser chamado de instanciar. 

Talvez a imagem abaixo não esteja 100% correta, mas vamos usar ela por enquanto.

![Imagem 1](./imgs/java-oo-img-1.png)

### Valores padrão

Antes, quando declaravámos uma variável e não era atribuido nenhum valor à ela, o eclipse indicava um erro de compilação pois ela não tinha sido inicializada, ou seja, não possui nenhum valor. 

Agora, quando criamos uma classe, podemos atribuir alguns valores padrão para cada atributo. Mesmo se não fizermos isso deliberadamente, quando criarmos um objeto, o Java zera todos os valores dos atributos. Então se printarmos o saldo de um objeto tipo conta que ainda não teve um saldo definido, o valor que receberemos sera ``0``

#### Métodos

Quando fazemos a especificação de uma conta, definimos quais são as caracteristicas dela, o que podemos chamar de **atributos** e também precisamos definir qual será o comportamento e como a conta executará as ações desse comportamento. Para isso usamos métodos, que é algo parecido com as funções do C.

Vamos definir três ações da conta: deposita, saca e transfere, e depois vamos criar esses métodos dentro da nossa classe Conta.

```java
public class Conta {
    // Atributos

    public void deposita(double valor) {
        this.saldo += valor;
    }

    public boolean saca(double valor) {
        if(this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transfere(double valor, Conta destino) {
        if(this.saldo >= valor) {
            this.saldo -= valor;
            destino.deposita(valor);
            return true;    
        }
        return false;
    }

}
```

O método ``deposita`` foi declarado como ``public void``. O ``public`` a gente não sabe o que é ainda, mas o ``void`` indica que não vamos dar nenhum retorno depois do método ser executado. 

É boa prática declarar o nome do método com a primeira letra minúscula e se tiver mais de uma palavra, usar o ``camelCase``. 

Depois declaramos uma variável tipo ``double`` para receber o ``valor`` que será depositado na conta. Dentro das chaves, nós definimos como o método irá executar essa ação. Pelo o que eu entendi, quando trabalhamos com OO, nós sempre fazemos a referência ao objeto que nós queremos mexer, por isso é usado o ``this``. Então se eu crio um objeto e faço uma referência com a variável chamada conta e depois quero depositar 100 reais, o código vai ficar assim: 

```java
//  Classe 

Conta conta = new Conta();
conta.deposita(100);
```

Então, parecido quando vamos mexer em um atributo do objeto, nós invocamos o método com a ``referencia.método``.

Os métodos saca e transfere são parecidos. Dessa vez teremos um retorno, por isso declaramos como public boolean. Definimos os argumentos que eles receberão e depois como farão a ação. 

