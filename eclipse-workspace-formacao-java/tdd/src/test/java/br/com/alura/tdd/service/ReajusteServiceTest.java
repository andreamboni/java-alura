package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	@Test
	public void reajusteDeveriaSerDeTresPorcento() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Marshall", LocalDate.now(), new BigDecimal("1000"));

		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteDeveriaSerDeQuinzePorcento() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Marshall", LocalDate.now(), new BigDecimal("1000"));
		BigDecimal salarioReajustado = funcionario.getSalario().add(funcionario.getSalario().multiply(new BigDecimal("0.15")));

		service.concederReajuste(funcionario, Desempenho.BOM);

		assertEquals(salarioReajustado, funcionario.getSalario());
	}

	@Test
	public void reajusteDeveriaSerDeVintePorcento() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Marshall", LocalDate.now(), new BigDecimal("1000"));
		BigDecimal salarioReajustado = funcionario.getSalario().add(funcionario.getSalario().multiply(new BigDecimal("0.20")));

		service.concederReajuste(funcionario, Desempenho.OTIMO);

		assertEquals(salarioReajustado, funcionario.getSalario());
	}
}
