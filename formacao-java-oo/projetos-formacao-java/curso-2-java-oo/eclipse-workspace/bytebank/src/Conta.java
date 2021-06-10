public class Conta {
	private double saldo; 
	private int agencia;
	private int conta;
	private Cliente titular; 
	
	
	public void deposita(double valor) {
		this.saldo += valor; 
	}	
	
	public boolean saca(double valor) {
		if(this.saldo >= valor) {
			this.saldo -= valor;	
			return true;
		} else {
			return false;
		}
	}
	
	public boolean transfere(double valor, Conta destino) {
		if(this.saldo >= valor) {
			this.saldo -= valor;
			destino.deposita(valor);
			return true;
		}
		return false;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getConta() {
		return this.conta;
	}
	
	public void setConta(int novaConta) {
		this.conta = novaConta;
	}
	
	
}
