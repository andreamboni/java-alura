public class Gerente extends Funcionario {
	private int senha;
	
	 public double getBonificacao() {
		 System.out.println("Bonificação do gerente");
		return super.getBonificacao() + super.getSalario();
	}
	
	public void setSenha(int senha) {
		this.senha = senha; 
	}
	
	public boolean autentica(int senha) {
		if (this.senha == senha) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
