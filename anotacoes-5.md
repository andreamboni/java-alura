# Curso 5 (De 15/03/2021 a 19/03/2021)

## Java e java.lang

### Pacotes

Pacotes ou packages, nada mais são do que pastas que usamos para organizar o nosso projeto. Quando fazemos essa separação, precisamos indicar na nossa classe o pacote que ele faz parte. Por exemplo: 

![Imagem 1](./imgs/java-excecoes-img-1.png)

Separamos o nosso código em duas pastas: **modelo** e **testes**. Nas classes do pacote modelo, usamos a palavra chave ``package`` seguido do nome da pasta.

```java
package modelo;

public class CalculadorImposto {
	private double totalImposto;
	
	public void registra(Tributavel t) {
		double valor = t.getValorImposto();
		this.totalImposto += valor;
	}
	
	public double getTotalImposto() {
		return totalImposto;
	}
}
```

No caso de teste: 

```java
package teste;

public class TestaConta {
	public static void main(String[] args) throws SaldoInsuficienteException {
		ContaCorrente cc = new ContaCorrente(111, 12345);
		cc.deposita(100.0);
		ContaPoupanca cp = new ContaPoupanca(222, 12234);
		cp.deposita(200.0);
		
		cc.transfere(10.0, cp);
		System.out.println(cc.getSaldo());
		System.out.println(cp.getSaldo());
		
	}
}
```

Depois de dividirmos os arquivos, ainda temos erros no código. Quando colocamos as classes em pacotes, o nome delas também é alterado. Por exemplo, para fazer referência a ``ContaCorrente``, precisamos usar o nome do package seguido de um ponto e o nome da classe, assim:

```java
package teste;

public class TestaConta {
	public static void main(String[] args) throws modelo.SaldoInsuficienteException {
		modelo.ContaCorrente cc = new modelo.ContaCorrente(111, 12345);
		cc.deposita(100.0);
		modelo.ContaPoupanca cp = new modelo.ContaPoupanca(222, 12234);
		cp.deposita(200.0);
		
		cc.transfere(10.0, cp);
		System.out.println(cc.getSaldo());
		System.out.println(cp.getSaldo());
		
	}
}
```

O nome desse tipo de referência é **Full Qualified Name** ou **FQN**

### Boa prática na criação de pacotes

Para criar um pacote único no mundo para que não ocorra nenhum conflito durante a comunicação entre sistemas, usaremos a URL do site da empresa. Então, se o site da nossa empresa for bytebank.com.br, vamos criar primeiro uma pasta chamada ``br``, depois ``com``, depois ``bytebank``, um com o nome do ``projeto`` e depois as divisões que queremos fazer. Vai ficar assim: 

![Imagem 1](./imgs/java-excecoes-img-1.png)

Agora vamos atualizar isso nas nossas classes.

```java
package br.com.bytebank.banco.modelo;

public class CalculadorImposto {
	private double totalImposto;
	
	public void registra(Tributavel t) {
		double valor = t.getValorImposto();
		this.totalImposto += valor;
	}
	
	public double getTotalImposto() {
		return totalImposto;
	}
}
```

```java
package br.com.bytebank.banco.teste;

public class TestaConta {
	public static void main(String[] args) throws modelo.SaldoInsuficienteException {
		modelo.ContaCorrente cc = new modelo.ContaCorrente(111, 12345);
		cc.deposita(100.0);
		modelo.ContaPoupanca cp = new modelo.ContaPoupanca(222, 12234);
		cp.deposita(200.0);
		
		cc.transfere(10.0, cp);
		System.out.println(cc.getSaldo());
		System.out.println(cp.getSaldo());
		
	}
}
```

Agora teremos que usar o FQN para chamar todas as nossas classes: 

```java
package br.com.bytebank.banco.teste;

public class TestaConta {
	public static void main(String[] args) throws br.com.bytebank.banco.modelo.SaldoInsuficienteException {
		br.com.bytebank.banco.modelo.ContaCorrente cc = new br.com.bytebank.banco.modelo.ContaCorrente(111, 12345);
		cc.deposita(100.0);
		br.com.bytebank.banco.modelo.ContaPoupanca cp = new br.com.bytebank.banco.modelo.ContaPoupanca(222, 12234);
		cp.deposita(200.0);
		
		cc.transfere(10.0, cp);
		System.out.println(cc.getSaldo());
		System.out.println(cp.getSaldo());
		
	}
}
```

### Importando pacotes

Para não ter que escrever essa tripa toda para chamar uma classe, podemos usar a importação logo após a declaração do pacote. Assim: 

```java
package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.*;

public class TestaConta {
	public static void main(String[] args) throws SaldoInsuficienteException {
		ContaCorrente cc = new ContaCorrente(111, 12345);
		cc.deposita(100.0);
		ContaPoupanca cp = new ContaPoupanca(222, 12234);
		cp.deposita(200.0);
		
		cc.transfere(10.0, cp);
		System.out.println(cc.getSaldo());
		System.out.println(cp.getSaldo());
		
	}
}
```

Muito melhor eim! Assim não precisamos usar o *Full Qualified Name*.

Note que estamos usando o ``*`` no ``import br.com.bytebank.banco.modelo.*;``. A boa prática nessas importações é especificar qual classe você está importando. Por exemplo: 

```java
package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;
import br.com.bytebank.banco.modelo.SaldoInsuficienteException;

public class TestaConta {
	public static void main(String[] args) throws SaldoInsuficienteException {
		ContaCorrente cc = new ContaCorrente(111, 12345);
		cc.deposita(100.0);
		ContaPoupanca cp = new ContaPoupanca(222, 12234);
		cp.deposita(200.0);
		
		cc.transfere(10.0, cp);
		System.out.println(cc.getSaldo());
		System.out.println(cp.getSaldo());
		
	}
}
```

Para isso, podemos usar o atalho ``Ctrl + Shift + O`` no Eclipse. 