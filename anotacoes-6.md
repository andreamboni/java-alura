# Curso 5 (De 22/03/2021 a 00/03/2021)

## Java e java.util

### Arrays

``Array`` é uma estrutura de dados que comporta uma lista de um determinado tipo. O ``Array`` também é um objeto, então declaramos da seguinte forma: 

```java
package br.com.bytebank.banco.test;

public class Teste {

	public static void main(String[] args) {
		int[] idades = new int[5];// O número é a quantidade de posições
		
		idades[0] = 1;
		idades[1] = 2;
		idades[2] = 3;
		idades[3] = 4;
		idades[4] = 5;
		
		System.out.println(idades[5]);
	}

}
```

No código acima está a declaração do ``Array`` e como inicializamos ela. Note que o número dentro dos colchetes é a quantidade de posição, nesse caso cinco, de 0 à 4. 

Quando declaramos um ``array``, temos que informar o tipo. (``int``, ``double`` e etc.).

Se tentarmos inicializar uma posição que não deveria existir dentro do ``array``, por exemplo, uma sexta posição, tomariamos uma exceção. 

### Type casting 

Quando estamos instaciando um objeto com uma referência muito genérica, para acessar algum método de uma classe específica, precisamos fazer o **type casting**.

Podemos usar o código abaixo como exemplo:

```java
public static void main(String[] args) {
	double valor = 3.56;
	int numero = (int) valor;
}
```

### String[] args

O String[] args, pelo o que eu entendi, é uma variável do tipo string, que podemos usar no momento da execução. Se chamarmos a jvm pelo terminal e passar argumentos, eles serão exibidos. 

### Desvantagens do Array

Não é possível quantas posições já foram ocupadas. Conseguimos saber somente quantas tem.

Não conseguimos mudar o tamanho do array de forma dinâmica. Uma vez que o array é criado com dez posições, sempre terá dez posições. 

### ArrayList

O ArrayList é um recurso do pacote java.util para utilizar o Array de uma mais "orientada a objetos". Ela já vem com vários métodos como ``add``, ``remove``, ``get``, ``size`` e etc.

O limite de elementor que o ArrayList pode guardar é o limite da memória da **JVM**.

### Generics

Para evitar uma possível confusão com a tipagem dos arrays, é possível usar generics para especificar o tipo do ArrayList que você está criando. Vamos supor que você quer criar um Array de contas e outro que só recebe strings. Teremos que fazer da seguinte forma, respectivamente: ``ArrayList<Conta> conta = new ArrayList<Conta>()`` e ``ArrayList<String> string = new ArrayList<String>()``.

Esse recurso evita que seja salvo uma conta dentro de um array de strings ou vice versa. Assim você não precisa ficar fazendo os castings. 

O tipo depois da virgula não é necessário, pode ficar assim: ``ArrayList<String> string = new ArrayList<>()``

Também é possível fazer um ArrayList com o tamanho que eu preciso ou indicando outro Array: ``ArrayList lista = new ArrayList(26);`` e ``ArrayList nova = new ArrayList(lista);`` respectivamente. 