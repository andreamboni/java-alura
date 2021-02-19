public class Gerente extends Funcionario {

	 @Override
	 public double getBonificacao() {
		 System.out.println("Bonificação do gerente");
		return super.getSalario();
	}
}