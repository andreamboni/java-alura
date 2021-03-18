# Curso 5 (De 15/03/2021 a 19/03/2021)

## Java e java.lang

### Pacotes

Pacotes ou packages, nada mais são do que pastas que usamos para organizar o nosso projeto. Quando fazemos essa separação, precisamos indicar na nossa classe o pacote que ele faz parte. Por exemplo: 

![Imagem 1](./imgs/java-javalang-img-1.png)

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

![Imagem 2](./imgs/java-javalang-img-2.png)

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

### Revisitando modificadores de acesso

Agora que sabemos os que são pacotes, podemos entender por completo os modificadores de acesso.

**Public:** pode ser visto tanto dentro quanto fora do pacote. Modificador mais permissivo.

**Protected:** pode ser visto dentro do pacote, e fora somente para as classes filhas. Segundo modificador mais permissivo.

**Package private ou default:** visível somente dentro do pacote. Ele só é utilizado quando não utilizamos nenhum modificador de aceso. Terceiro modificador mais permissivo. 

**Private:** visível somente dentro da clase. Modificador menos permissivo. 

### Javadoc

Dentro do Java existe uma forma de criar comentários para servir de documentação das classes. Para isso usamos ``/**``` e tag para indicar versão, autor e etc. (@version, @author respectivamente) A partir desses comentários, conseguimos criar um arquivo para documentação. É possível fazer isso direto no Eclipse. 

Essa documentação trata somente dos membros públicos da classe.

### Biblioteca JAR

Podemos exportar os nossos projetos em um arquivo compactado, mas com a extensão JAR (Java Archive). Depois, se quisermos utilizar, podemos criar uma pasta e importar esse arquivo. Normalmente o nome dessa pasta é **libs**, e assim, que importarmos o arquivos, podemos adicionar ao nosso build path para importar no nosso novo projeto. 

![Imagem 3](./imgs/java-javalang-img-3.png)

O arquivo JAR é somente o código compilado, não o código fonte. 

Também é possível criar um JAR executável. 

### Um pouco sobre Maven

O Maven é um organizador de código compilado, código fonte e documentação, parecido com npm. 