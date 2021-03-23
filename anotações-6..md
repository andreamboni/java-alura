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