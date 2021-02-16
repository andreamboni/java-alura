# Curso 2 (De 10/02/2021 a ????)

## Contexto

Nesse curso, vamos criar uma classe chamada ``Funcionario`` que é quase idêntica a classe ``Cliente`` que criamos no curso anterior. O código dessa classe segue abaixo: 

```java
public class Funcionario {
	private String nome;
	private String cpf;
	protected double salario;
	
	public double getBonificacao() {
		return this.salario * 0.1;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
```

### Extends

Se quisermos criar uma classe ``Gerente``, que tenha as mesmas características de ``Funcionario``, mas somente com um novo atributo e uma bonificação diferente, nós podemos usar o comando ``extends``.

A classe Gerente ficaria assim: 

```java
public class Gerente extends Funcionario {
	private int senha;
	
	public void setSenha(int senha) {
		this.senha = senha; 
	}
	
	public boolean autentica(int senha) {
		if (this.senha == senha) {
			return true;
		} else {
			return false;
		}
	}
	
	 public double getBonificacao() {
		return this.salario;
	}
	
}
```

Inserimos também um método de autenticação da senha e outro para setar a senha. 

Quando usamos o ``extends``, podemos dizer que ``Gerente`` herdou atributos e métodos de ``Funcionario``. 

### Super class

Super class, classe mãe, classe pai ou base class, é o nome que podemos dar para a classe no maior nível hierarquico. Podemos usar como exemplos as classes Funcionario e Gerente. A classe ``Funcionario`` é a classe pai e a ``Gerente`` é a classe filha. 

![Imagem 1](./imgs/java-polimorfismo-img-1.png)

### Protected

Mesmo extendendo a classe ``Funcionario`` com a classe ``Gerente``, nós não conseguimos acessar o atributo ``saldo`` diretamente e consequentemente existe um erro no nosso método ``getBonificacao``. Temos duas opções para resolver esse problema: 

Uma das opções é alterar a visibilidade do atributo ``saldo`` para ``protected``. O ``protected`` dá visibilidade para a própria classe e suas filhas. No nosso caso, visibilidade para ``Funcionario`` e ``Gerente``. 

### Protected x Private 

A segunda opção é manter o saldo como ``private`` e utilizar o método ``getBonificacao`` da classe ``Funcionario`` no  ``getBonificacao`` da classe ``Gerente`` com o seguinte comando: ``super.getBonificacao``. Ficaria assim: 


```java
public class Gerente extends Funcionario {
    // Atributos
    // Métodos

	 public double getBonificacao() {
		return super.getBonificacao;
	}
	
}
```

Aqui estamos usando a palavra chave ``super`` para acessar a classe ``Funcionario`` e usar o método ``getBonificacao``. Assim conseguimos manter o atributo encapsulado e usar o método que já criamos.

### Sobrescrita (Override) x Sobrecarga (Overload)

**Sobrescrita** é o que fizemos com o ``getBonificacao``: temos um método mais geral para o ``Funcionario``, e criamos um mais específico para o ``Gerente``. Então sobrescrita é reescrever um método que já existe na classe mãe, só que na classe filha, para atender uma necessidade mais específica. Segue exemplo: 

**getBonificacao Funcionario**

```java
public class Funcionario {
    // Atributos
	
	public double getBonificacao() {
		return this.salario * 0.1;
	}
	
    // Métodos
	
}
```

**getBonificacao Gerente**

```java
public class Gerente extends Funcionario {
    // Atributos
    // Métodos

	 public double getBonificacao() {
		return super.getBonificacao;
	}
	
}
```

**Sobrecarga** é a escrita de um método que já existe na classe, mas com parâmetros e comportamentos diferentes. Como no exemplo abaixo, que temos dois métodos ``autentica``: um que recebe somente a senha como parâmetro e outro que recebe login e senha. 

**Exemplo 1:** 

```java
public boolean autentica(int senha) {
    if (this.senha == senha) {
        return true;
    } else {
        return false;
    }
}
```

**Exemplo 2:**

```java
public boolean autentica(String login, int senha) {
	if (this.senha == senha && this.login == login) {
		return true;
	} else {
		return false;
	}
	
}
```

### Polimorfismo

Com o polimorfismo nós conseguimos usar referências mais genéricas apontarem para objetos específicos. Agora queremos saber quanto pagamos de bonificação aos funcionários, e para isso, criaremos uma classe chamada ``ControleBonificacao``.

```java
public class ControleBonificacao {
	private double soma;

	public void registro(Funcionario f) {
		double boni = f.getBonificacao();
		this.soma += boni;
	}

	public double getSoma() {
		return this.soma;
	}
}
```

Também vamos criar mais um tipo de funcionário chamado ``Designer``.

```java
public class Designer extends Funcionario {
	public double getBonificacao() {
		System.out.println("Bonificação designer");
		return 200;
	}
}
```

Agora vamos criar outra classe chamada ``TestaReferencia`` para começar a contabilizar as bonificações. 


```java
public class TestaReferencia {
	public static void main(String[] args) {
		Gerente g1 = new Gerente();
		g1.setNome("Marcos");
		g1.setSalario(5000.0);
		
		Funcionario f = new Funcionario();
		f.setSalario(2000.00);
		
		Designer d = new Designer();
		d.setSalario(3500.0);
		
		ControleBonificacao controle = new ControleBonificacao();
		controle.registro(g1);
		controle.registro(f);
		controle.registro(d);
		
		System.out.println(controle.getSoma());
	}
}
```

Nessa classe declaramos três funcionários: ``g1 (Gerente)``, ``f (Funcionário)`` e ``d (Designer)``, e setamos o salário para cada um deles. Depois de definir os salários, criamos um objeto do tipo ``ControleBonificacao`` para fazer a soma dos valores, chamamos o método ``registro`` e passamos como argumento os funcionários. 

Após tudo isso, chamamos o ``getSoma`` dentro de um ``sysout``, e o resultado foi ``5550.0``, que é a soma de todas as bonificações. 

A vantagem e o objetivo do polimorfismo é usar uma referência genérica para apontar para um objeto específico. O método ``registro``, por exemplo, usa um argumento do tipo ``Funcionario``, que é a nossa classe mãe. Como todo objeto instanciado dentro de ``TestaReferencia`` é um funcionário, é possível fazer a soma de todas as bonificações. E isso ocorre porque o Java, nesses casos, sempre olha para o objeto e não para o tipo. 