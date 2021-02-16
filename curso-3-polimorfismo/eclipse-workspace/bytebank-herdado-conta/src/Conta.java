public class Conta {
	private double saldo; 
	private int agencia;
	private int conta;
	private Cliente titular; 
	private static int total;
	
	public Conta() {
		
	}
	
	public Conta(int agencia, int conta) {
		Conta.total++;
		// System.out.println("O total de contas é " + Conta.total);
		if(agencia >= 0 && conta >= 0) {
			this.agencia = agencia;
			this.conta = conta;
		} return;
	}
	
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
		if(this.saca(valor)) {
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
	
	public void setConta(int conta) {
		this.conta = conta;
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}  
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public Cliente getTitular() {
		return this.titular;
	}
	
	public static int getTotal() {
		return Conta.total;
	}
}
