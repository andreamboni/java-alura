public class TesteTributaveis {
	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente(2222, 3333333);
		cc.deposita(100);
		
		SeguroDeVida seguro = new SeguroDeVida();
		
		CalculadorImposto calc = new CalculadorImposto();
		calc.registra(cc);
		calc.registra(seguro);
		
		System.out.println(calc.getTotalImposto());
	}
}
