public class TestaValores {
	public static void main(String[] args) {
		Conta conta = new Conta(2351, 15578);

		System.out.println(conta.getAgencia());
		System.out.println(conta.getNumero());
		
		Conta conta2 = new Conta(2351, 41528);
		Conta conta3 = new Conta(2351, 25158);
		
		System.out.println(Conta.getTotal());
		
	}
}
