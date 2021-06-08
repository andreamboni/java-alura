package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		BigDecimal calcularBonus = service.calcularBonus(new Funcionario("André", LocalDate.now(), new BigDecimal("25000")));
		
		assertEquals(new BigDecimal("0.00"), calcularBonus);
	}

	@Test
	void bonusDeveriaSerDezPorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal calcularBonus = service.calcularBonus(new Funcionario("André", LocalDate.now(), new BigDecimal("2500")));
		
		assertEquals(new BigDecimal("250.00"), calcularBonus);
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamenteDezMilReais() {
		BonusService service = new BonusService();
		BigDecimal calcularBonus = service.calcularBonus(new Funcionario("André", LocalDate.now(), new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"), calcularBonus);
	}
}
