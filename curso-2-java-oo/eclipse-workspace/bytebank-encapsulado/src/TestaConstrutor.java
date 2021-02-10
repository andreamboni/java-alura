public class TestaConstrutor {
	public static void main(String[] args) {
		Conta conta = new Conta(1337, 10025);
		System.out.println("A agencia é " + conta.getAgencia() + " e a conta é " + conta.getConta());
		
		Conta outraConta = new Conta(-20, 10);
		System.out.println("A agencia é " + outraConta.getAgencia() + " e a conta é " + outraConta.getConta());
		
		System.out.println(Conta.getTotal());
	}
}
