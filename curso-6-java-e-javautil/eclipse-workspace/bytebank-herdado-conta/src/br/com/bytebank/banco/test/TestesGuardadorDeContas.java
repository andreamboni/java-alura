package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.GuardadorDeContas;
import br.com.bytebank.banco.modelo.Conta;

public class TestesGuardadorDeContas {
	
	public static void main(String[] args) {
		
		GuardadorDeContas guardador = new GuardadorDeContas();
		
		Conta conta = new ContaCorrente(22, 11);
		guardador.adiciona(conta);
		System.out.println("Oi");
		
	}
}
