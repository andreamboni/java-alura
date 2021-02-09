public class TestaBanco {
	public static void main(String[] args) {
		Cliente luiz = new Cliente();
		luiz.nome = "Luiz Medeiros";
		luiz.cpf = "222.222.222-22";
		luiz.profissao = "Programador";
		
		Conta contaDoLuiz = new Conta();

		contaDoLuiz.titular = luiz;
		System.out.println(contaDoLuiz.titular);
		System.out.println(luiz);
	}
	
}
