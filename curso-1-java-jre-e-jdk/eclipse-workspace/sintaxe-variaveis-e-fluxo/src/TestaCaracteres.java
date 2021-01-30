public class TestaCaracteres {
	public static void main(String[] args) {
		char letra = 'a'; // Cabe somente um caractere
		System.out.println(letra);
		
		char valor = 66;
		System.out.println(valor);
		
		int meuTeste = letra;
		System.out.println(meuTeste);
		
		valor += (char) 1;
		System.out.println("Meu teste " + valor);
		
		String palavra = "Alura curso de Java sei lá";
		System.out.println(palavra);
		
		palavra = palavra + 2020; 
		System.out.println(palavra);
	}
}
