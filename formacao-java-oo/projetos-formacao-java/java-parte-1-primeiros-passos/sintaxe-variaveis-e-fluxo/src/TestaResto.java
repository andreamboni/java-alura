public class TestaResto {
	public static void main(String[] args) {
		//int numero = 3;
		for(int numero = 3; numero <= 100; numero++) {
			if (numero % 3 == 0) {
				  System.out.println(numero + " é divisível por 3");
				} else {
					System.out.println(numero + " não é divisível por 3");
				}
		}
		
	}
}
