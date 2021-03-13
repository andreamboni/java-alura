public class TestaConta {
	public static void main(String[] args) throws SaldoInsuficienteException {
		ContaCorrente cc = new ContaCorrente(111, 12345);
		cc.deposita(100.0);
		ContaPoupanca cp = new ContaPoupanca(222, 12234);
		cp.deposita(200.0);
		
		cc.transfere(10.0, cp);
		System.out.println(cc.getSaldo());
		System.out.println(cp.getSaldo());
		
	}
}
