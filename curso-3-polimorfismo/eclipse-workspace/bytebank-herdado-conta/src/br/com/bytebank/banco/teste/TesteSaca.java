package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.SaldoInsuficienteException;

public class TesteSaca {
	public static void main(String[] args) {
		Conta conta = new ContaCorrente(123, 4321);
		
		conta.deposita(200.00);
		try {
			conta.saca(210.0);
		} catch(SaldoInsuficienteException ex) {
			System.out.println("Ex: " + ex.getMessage());
		}
		
		System.out.println(conta.getSaldo());
	}
}
