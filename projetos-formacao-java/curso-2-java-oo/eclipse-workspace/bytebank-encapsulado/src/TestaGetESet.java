public class TestaGetESet {
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setConta(1337);
		System.out.println(conta.getConta());
				
		Cliente paulo = new Cliente();
		conta.setTitular(paulo);
		System.out.println(conta.getTitular());
		
		paulo.setNome("Paulo");
		System.out.println(paulo.getNome());
	}
}
