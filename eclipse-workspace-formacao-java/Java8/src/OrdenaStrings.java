import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {
	
	public static void main(String[] args) {
	
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");
		
		System.out.println(palavras);
		
		Comparator<String> comparador = new ComparadorPorTamanho();
		
		/*
		 * Ordenando
		 * */
		
		//Collections.sort(palavras, comparador); //Jeito antigo usando Collections e o seus metodos estaticos
		palavras.sort(comparador); // a partir do java 8, é possivel usar sort a partir da lista
		System.out.println(palavras);
		
		/* 
		 * A partir do java 8, se tornou possivel inserir metodos com implemntação dentro de interfaces, porém, é necessario usar a palavra chave default 
		 * 
		 * Como exemplo veja implementação do metodo sort da lista
		 * */
		
		/*
		 * Foreach
		 */
		
//		for (String p : palavras) { // Jeito veio
//			System.out.println(p);
//		}
		
		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);
		
		/*
		 * O foreach também é um método implemntando com default na interface
		 * */
		
		
		// Lambda
		
		/* Versão original usando classe anonima. O nome classe anonima vem pq a gente não da um nome para essa classe, a gente meio que só implementa. 
		palavras.sort(new Comparator<String>() {
		    public int compare(String s1, String s2) {
		        if (s1.length() < s2.length())
		            return -1;
		        if (s1.length() > s2.length())
		            return 1;
		        return 0;
		    }
		});
		
		Usando lambda, mas ainda não tão bom. Quando o lambda tiver muita logica como esse, é melhor externalizar essa função ou usar classe anonima
		palavras.sort((s1, s2) -> {
		    if (s1.length() < s2.length())
		        return -1;
		    if (s1.length() > s2.length())
		        return 1;
		    return 0;
		});
		
		Lambda quase bão
		palavras.sort((s1, s2) -> {
		    return Integer.compare(s1.length(), s2.length());
		});
		*/
		
		/*
		 * O lambda só funciona com uma interface funcional
		 * */
		
		//Lambdão
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		// Podemos deixar mais curto com method reference
		palavras.sort(Comparator.comparing(s -> s.length()));
		palavras.sort(Comparator.comparing(String::length));
		
		//Factory? 
		
		
		//Lambda substitiondo o imprime linha
		palavras.forEach(s -> System.out.println(s));
		
		// Esse aqui também com method reference
		palavras.forEach(s -> System.out.println(s));
		palavras.forEach(System.out::println);
		
	}
	
}

//
//class ImprimeNaLinha implements Consumer<String> {
//
//	@Override
//	public void accept(String s) {
//		System.out.println(s);
//	}
//}
//
//
//class ComparadorPorTamanho implements Comparator<String> {
//
//	@Override
//	public int compare(String s1, String s2) {
//		if (s1.length() < s2.length())
//			return -1;
//		if (s1.length() > s2.length())
//			return 1;
//		return 0;
//	}
//	
//}