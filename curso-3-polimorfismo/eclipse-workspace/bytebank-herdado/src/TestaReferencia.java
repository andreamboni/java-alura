public class TestaReferencia {
	public static void main(String[] args) {
		Gerente g1 = new Gerente();
		g1.setNome("Marcos");
		g1.setSalario(5000.0);
		
		Funcionario f = new Funcionario();
		f.setSalario(2000.00);
		
		Designer d = new Designer();
		d.setSalario(3500.0);
		
		ControleBonificacao controle = new ControleBonificacao();
		controle.registro(g1);
		controle.registro(f);
		controle.registro(d);
		
		System.out.println(controle.getSoma());
		
	}
}
