public class ContaCorrente extends Conta{
	
	public ContaCorrente(int agencia, int conta) {
		super(agencia, conta);
	}
	
	@Override
	public boolean saca(double valor) {
		double valorSaque = valor + 0.2;
		return super.saca(valorSaque);
	}

}
