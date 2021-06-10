public class criaConta {
	public static void main(String[] args) {
		Conta primeiraConta = new Conta(); 
		primeiraConta.saldo = 200;
		System.out.println(primeiraConta.saldo);
		
		primeiraConta.saldo += 100;
		System.out.println(primeiraConta.saldo);
		
		Conta segundaConta = new Conta();
		segundaConta.saldo = 50;
		
		System.out.println("Primeira conta tem " + primeiraConta.saldo + " pila");
		System.out.println("Segunda conta tem " + segundaConta.saldo + " pila");
		System.out.println(primeiraConta.agencia);
		System.out.println(primeiraConta.numero);
		
		if(primeiraConta == segundaConta) {
			System.out.println("É a mesma coisa");
		} else {
			System.out.println("Não é a mesma coisa");
		}
		
		System.out.println(primeiraConta);
		System.out.println(segundaConta);
	}
}
