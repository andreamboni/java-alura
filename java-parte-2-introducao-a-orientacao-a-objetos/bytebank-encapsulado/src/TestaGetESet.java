public class TestaGetESet {
	public static void main(String[] args) {
		Conta conta = new Conta(595, 1337);
		System.out.println(conta.getNumero());
		
		Cliente andre = new Cliente();
		conta.setTitular(andre);
		andre.setNome("Andre Luiz");
		
		System.out.println(conta.getTitular().getNome());
		
		conta.getTitular().setProfissao("Programador");
		System.out.println(conta.getTitular().getProfissao());
		// agora o mesmo código em duas linhas
		Cliente contaTitular = conta.getTitular();
		contaTitular.setProfissao("Desenvolvedor");
		System.out.println(conta.getTitular().getProfissao());
		System.out.println(contaTitular.getProfissao());
		System.out.println(andre.getProfissao());
		
		// vou imprimir o local da memória
		
		System.out.println(conta.getTitular());
		System.out.println(contaTitular);
		System.out.println(andre);
	}
}
