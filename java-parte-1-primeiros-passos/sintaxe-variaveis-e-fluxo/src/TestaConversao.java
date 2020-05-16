public class TestaConversao {
	public static void main(String[] args) {
		
		float pontoFlutuante = 3.14f;
		double salario = 1270.5;
		int valor = (int) salario;
		System.out.println(valor);
		
		long numeroGrande = 354424324354l; // 64bits
		short valorPequeno = 2131;	   // 16bits
		byte b = 127;
		
		double valor1 = 0.2;
		double valor2 = 0.1;
		double total = valor1 + valor2;
		System.out.println(total);
		
	}
}
