# Curso 5 (De 22/03/2021 a 08/05/2021)

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

### Equals

Equals é outro método que existe na classe **Object** que está lá para ser sobreescrito, igual **toString**, por exemplo.

### ArrayList x LinkedList

Para o ArrayList é muito custoso quando apagamos um elemento dele, pois ele precisa reorganizar tudo. Por outro lado, conseguimos acessar qualquer elemento via indice. Já o LinkedList consegue trabalhar bem quando algum elemento é excluído, mas para acessar o último elemento da lista, ele precisa passar para todos os outros. 

O LinkedList também tem os métodos remove, contains, size e etc. LinkedList também é do pacote java.util.

Também é possível usar a interface **List** como se fosse uma referência mais genérica entre LinkedList e ArrayList.

List é uma interface, a ArrayList e a LinkedList são implementações.

### Vector

O Vector é também um array e uma lista, é utilizado para multi threads. O vector é threadsafe. 

### Collection

As listas (ArrayList, LinkedList e Vector) são estenções da interface java.util.Collection. 

### Classes wrappers 

Existem algumas classes no Java que tem como objetivo "substituir" os tipos primitivos. A classe ``Integer`` é uma dessas classes. 

Ela possui algumas funcionalidades bem importantes como parsing, autoboxing e etc.

O Autoboxing é uma funcionalidade que auxilia o desenvolvedor quando ele tenta apontar uma variável primitiva dentro de uma lista (ArrayList, LinkedList e Vector).Como essas listas guardam somente referências, o compilador pega essa variável primitiva e faz o autoboxing, que transforma transforma o valor primitivo em uma referência. O Autoboxing é feito com a criação de uma classe Wrapper. 

Dentro da classe Integer também existem alguns métodos que fazem o parsing dos valores, transformando uma string em um int, por exemplo.

Também existe o unboxing, que desembrula ou desemcapsula o primitivo da referência. Ou seja, tira o primtivo da classe Wrapper. 

### Exemplo de autoboxing e unboxing

```java

// Integer

Integer iRef = Integer.valueOf(29); // Autoboxing
System.out.println(iRef.intValue()); // Unboxing

```

Não existe a necessidade de fazer o autoboxing através do ``Integer.valueOf()``, visto que o compilador faz isso automaticamente. Mas é uma boa prática deixar isso claro. 

### Herança dos wrappers

Os wrappers númericos (double, float e long) estendem a classe ``Number``. Então existe uma referência mais genérica para essas classes. 

A classe ``Number`` também estende a classe ``Object``.

### Ordenção

Podemos usar duas interfaces para ordenação: java.util.Comparator e java.lang.Comparable. 

Usando o Comparable, podemos criar uma ordem natural dentro da classe do elemento sendo comparado. 

Dentro de Comparable também podemos usar o método shuffle, reverse e rotate.

### Classes anônimas

Quando criamos uma classes, precisamos definir quais são os seus atributos e métodos. Porém, as vezes precisamos só de um método novo que não se encaixa em nenhuma classe que já temos. Para isso, podemos criar classes anônimas para implementar o método que precisamos. 

Exemplo:

```java 
      Comparator comp = new Comparator<Conta>() {
    		@Override
    		public int compare(Conta c1, Conta c2) {
    			String nomeC1 = c1.getTitular().getNome();
    			String nomeC2 = c2.getTitular().getNome();
    			return nomeC1.compareTo(nomeC2);
    		}
    	};
```

Ou

```java
      Comparator comp = new Comparator<Conta>() {
    		@Override
    		public int compare(Conta c1, Conta c2) {
    			String nomeC1 = c1.getTitular().getNome();
    			String nomeC2 = c2.getTitular().getNome();
    			return nomeC1.compareTo(nomeC2);
    		}
    	};

```

### Lambdas

Com os Lambdas conseguimos encurtar muito o código acima.

Exemplo:

```java
lista.sort((c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()));
```

```java
Comparator<Conta> comp = (Conta c1, Conta c2) -> {
		String nomeC1 = c1.getTitular().getNome();
   		String nomeC2 = c2.getTitular().getNome();
   		return nomeC1.compareTo(nomeC2);
	};
```

### Foreach

Podemos usar um laço especifico para percorrer uma lista. Abaixo segue sintaxe: 

```java
lista.forEach((conta) -> System.out.println(conta + ", " + conta.getTitular().getNome()));
```


