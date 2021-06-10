public class GerenteSobrecarga extends Funcionario {
	private String login;
	private int senha;
	
	public void setLogin(String login) {
		this.login = login;
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
	
	public boolean autentica(String login, int senha) {
		if (this.senha == senha && this.login == login) {
			return true;
		} else {
			return false;
		}
		
	}
	
	 public double getBonificacao() {
		return super.getSalario();
	}
	
}
