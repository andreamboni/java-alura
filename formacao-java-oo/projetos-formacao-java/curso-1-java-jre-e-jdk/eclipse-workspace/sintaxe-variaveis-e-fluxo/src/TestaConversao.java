public class TestaConversao {
	public static void main(String[] args) {
		double salario = 1270.50;
		float pontoFlutuante = 3.14f; // Ou faço um Type casting (float) 
		int valor = (int) salario; // Type casting
		System.out.println(valor);
		
		long numeroGrande = 3432345234l; // Pode ser com o L maiúsculo também 
		
		double valor1 = 0.2;
		double valor2 = 0.1;
		double total = valor1 + valor2;
		System.out.println(total);
		
	}
}
