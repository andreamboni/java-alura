public class TestaFuncionario {

	public static void main(String[] args) {
		Gerente nico = new Gerente();
		nico.setNome("Nico Steppat");
		nico.setCpf("22222222222");
		nico.setSalario(2600.00);
		
		System.out.println(nico.getNome());
		System.out.println(nico.getBonificacao());
		
//		GerenteSobrecarga assato = new GerenteSobrecarga();
//		assato.setLogin("aassato");
//		assato.setSenha(1234);
//		System.out.println(assato.autentica("aassato", 8584));
		
		ControleBonificacao cb = new ControleBonificacao();
		cb.registro(nico);
	}

}
