# Curso 7 (De 16/05/2021)

## Java Collections

### Métodos para manipular listas

Dentro das listas temos alguns métodos para facilitar a manipulação das informações. 

```java
package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {
	public static void main(String[] args) {
		String aula1 = "Modelando a classe Aula";
		String aula2 = "Conhecendo mais de listas";
		String aula3 = "Trabalhando com Cursos e Sets";

		ArrayList<String> aulas = new ArrayList<>();
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);

		System.out.println(aulas);

		aulas.remove(0);

		System.out.println(aulas);

		for (String aula : aulas) {
			System.out.println("Aula: " + aula);
		}

		String primeiraAula = aulas.get(0);
		System.out.println("A primeira aula é " + primeiraAula);

		for (int i = 0; i < aulas.size(); i++) {
			System.out.println("Aula " + i + ": " + aulas.get(i));
		}
		
		System.out.println(aulas.size());
		
		aulas.forEach(aula -> {
			System.out.print("Percorrendo ");
			System.out.println("aula: " + aula);
		});
		
		aulas.add("Aumentando o nosso conhecimento");
		System.out.println("Antes de ordenar: " + aulas);

		Collections.sort(aulas);
		System.out.println("Depois de ordenar: " + aulas);
	}
}
```

### Comparando e organizando


```java
package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestaListaDeAula {
	public static void main(String[] args) {
		
		Aula a1 = new Aula("Revisando as ArrayLists", 21);
		Aula a2 = new Aula("Listas de objetos", 20);
		Aula a3 = new Aula("Relacionamento de listas e objetos", 15);
		

		ArrayList<Aula> aulas = new ArrayList<>();
		aulas.add(a1);
		aulas.add(a2);
		aulas.add(a3);
		
		System.out.println(aulas);
		
		Collections.sort(aulas);
		System.out.println(aulas);
		
		Collections.sort(aulas, Comparator.comparing(Aula::getTempo));
		System.out.println(aulas);
		
		aulas.sort(Comparator.comparing(Aula::getTempo));
		System.out.println(aulas);
		
	}
}
```

### Sets e equals

Existe um problema com o set que é o equals. Quando a gente vai comparar elementos ou procurar dentro do set, precisamos usar o contains. Preciso dar uma lidinha melhor sobre isso. 