public class TestaConta {
	public static void main(String[] args) {
		Cliente Andre  = new Cliente();
		Andre.nome = "Andre Luiz Amboni de Medeiros";
		Andre.cpf = "444.444.444/60";
		Andre.profissao = "Analista Importacao";
		
		Conta contaAndre = new Conta();
		contaAndre.deposita(100);
		
		contaAndre.titular = Andre;
		System.out.println(contaAndre.titular.nome);
		System.out.println(contaAndre.titular);
		System.out.println(Andre);
		
		
	}
}
