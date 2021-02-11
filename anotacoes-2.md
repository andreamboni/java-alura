# Curso 2 (De 30/01/2021 a 09/02/2021 - Revisão)

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

### Métodos

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

### Composição de objetos

Vamos supor que a partir de agora, queremos saber o nome completo, CPF e profissão do titular da conta do bytebank. Nós podemos adicionar esses atributos na nossa classe conta, conforme abaixo: 

```java
public class Conta {
    // saldo, agência, conta e titular

    String nome;
    String cpf;
    String profissao;

    // Métodos depositar, sacar e transferir
}
```

Por mais que possa parecer que faz sentido ter essas informações na conta, podemos criar uma classe chamada ``Cliente`` e incluir esses atributos. 

```java
public class Cliente {
    String nome;
    String cpf;
    String profissao;
}
```

Como separamos as informações do cliente em outra classe, e essas dados do cliente são do titular também, nós podemos falar que ``titular`` é do tipo ``Cliente``, assim: 

```java
public class Conta {
    double saldo;
    int agencia;
    int conta;
    Cliente titular;

    // Métodos
}
```

Agora podemos criar um objeto do tipo ``Cliente`` e depois atribuir ao titular da conta. Assim:

```java
public class TestaConta {
    public static void main(String[] args) {
        Cliente luiz = new Cliente();
        luiz.nome = "Luiz Medeiros";
        luiz.cpf = "222.222.222-22";
        luiz.profissao = "Programador";

        Conta contaDoLuiz = new Conta();
        contaDoLuiz.titular = luiz;
    }
}
```

Podemos fazer isso de um jeito melhor também (claro).

```java
public class TestaConta {
    public static void main(String[] args) {
        Conta contaDoLuiz = new Conta();
        contaDoLuiz.titular = new Cliente();
    }
}
```

Assim eu consigo já instanciar ``Cliente`` e se quiser, posso acessar diretamente um atributo da classe.

```java
public class TestaConta {
    public static void main(String[] args) {
        Conta contaDoLuiz = new Conta();
        contaDoLuiz.titular = new Cliente();

        contaDoLuiz.titular.nome = "Luiz Medeiros";
    }
}
```

Caso houver a necessidade, nós podemos criar um objeto ``Cliente`` toda vez que uma ``Conta`` for instanciada.

```java
public class Conta {
    double saldo;
    int agencia;
    int conta;
    Cliente titular = new Cliente();

    // Métodos
}
```

A separação de atributos em várias classes é algo normal dentro de Java e provavelmente de outras linguagens OO.

### Encapsulamento

Quando definimos os nossos métodos na classe ``Conta``, nós inserimos uma lógica para que o ``saldo`` nunca fique negativo, mas isso pode ser facilmente contornado quando fazemos acessamos diretamente o atríbuto e colocamos um valor maior do que temos em saldo.  

Para previnir que isso acontece, precisamos encontrar uma forma para os atributos serem acessados somente através dos métodos, e para fazer isso, nós temos que **encapsular** os nosso atributos. E para isso temos a palavra reserva ``private``. Agora a nossa classe conta ficaria assim: 

```java
public class Conta {
    private double saldo;
    private int agencia;
    private int conta;
    private Cliente titular = new Cliente();

    // Métodos
}
```

Dessa forma, para inserir algum valor no saldo, por exemplo, vamos ter que usar obrigatóriamente um dos métodos que a gente criou: saca, deposita e transfere. 

### Getters e Setters

Agora que encapsulamos tudo, nós precisamos criar os métodos para acessar os atributos ``agência`` e ``conta``. Vamos precisar de dois métodos para cada atributo: uma para definir e outro para verificar os valores. Em Java é usado a nomenclatura **Getter** para verificar o valor e **Setter** para definir o valor e usamos esses termos no nome do método. Assim: 

```java
public class Conta {
    // Atributos

    // Outros métodos

    public int getAgencia() {
        return this.agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getConta() {
        return this.conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }
}
```

### Construtores

Em alguns cenários, nós queremos que um objeto sempre tenha algumas informações. No nosso caso, nós queremos que toda conta, quando instanciada, tenha agência e conta. Para fazer isso, nós vamos criar um construtor na nossa classe Conta. 

O Java já nos dá um construtor padrão quando criamos uma classe. Mas a partir do momento que criamos um construtor, aquele construtor padrão não pode ser mais utilizado. 

```java
public class Conta {
    // Atributos

	public Conta(int agencia, int conta) {
		if(agencia >= 0 && conta >= 0) {
			this.agencia = agencia;
			this.conta = conta;
		} return;
	
    // Métodos
}
```

Dentro desse construtor, nós colocamos uma validação para que não seja cadastrada nenhuma agência ou conta com número negativo. 

Agora, toda vez que eu for criar um novo objeto Conta, eu vou ser obrigado a informar os parametros ``agencia`` e ``conta``

#### Static

Vamos supor que queremos saber quantas contas já foram instanciadas. Para isso, precisamos declarar uma variável que vai fazer essa contagem pra gente. Então vamos declarar ela como um atributo da classe Conta. 

```java
public class Conta {
    // Atributos
    private static int total;

    // Métodos
}
```

A palavra chave static transforma a variável total em um atributo da classe e não do objeto. Por exemplo: quando criamos uma conta e definimos um saldo, aquele saldo vale para aquela conta, por isso usamos o this nos métodos de saca, deposita e transfere. Já no caso do total, esse valor não é de um objeto especifico, e sim da classe como um todo. É tipo uma variável global.

Agora, vamos completar o nosso construtor: 

```java
	public Conta(int agencia, int conta) {
		Conta.total++;
		System.out.println("O total de contas é " + Conta.total);
		if(agencia >= 0 && conta >= 0) {
			this.agencia = agencia;
			this.conta = conta;
		} return;
```

#### Quando revisar: 

Depois disso dar uma olhada no exemplo de dois construtores no curso.