package br.com.k21;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculadoraComissao {
	
	@Test
	public void entrandoComValorDe100ReaisEsperaSeComissaoDe5Reais() {
		int valorDaVenda = 100;
		int esperado = 5;
		
		double comissao = new CalculadoraComissao().calcula(valorDaVenda);
		
		assertEquals(esperado, comissao, 0);
	}
	
	@Test
	public void entrandoComValorDe200ReaisEsperaSeComissaoDe10Reais() {
		int valorDaVenda = 200;
		int esperado = 10;
		
		double comissao = new CalculadoraComissao().calcula(valorDaVenda);
		
		assertEquals(esperado, comissao, 0);
	}	

	@Test
	public void entrandoComValorDe10000ReaisEsperaSeComissaoDe500Reais() {
		int valorDaVenda = 10000;
		int esperado = 500;
		
		double comissao = new CalculadoraComissao().calcula(valorDaVenda);
		
		assertEquals(esperado, comissao, 0);
	}	

	@Test
	public void entrandoComValorDe1RealEsperaSeComissaoDe5Centavos() {
		double valorDaVenda = 1;
		double esperado = 0.05;
		
		double comissao = new CalculadoraComissao().calcula(valorDaVenda);
		
		assertEquals(esperado, comissao, 0);
	}
	
	@Test
	public void entrandoComValorDe1RealE50CentavosEsperaSeComissaoDe7Centavos() {
		double valorDaVenda = 1.50;
		double esperado = 0.07;
		
		double comissao = new CalculadoraComissao().calcula(valorDaVenda);
		System.out.println(comissao);
		assertEquals(esperado, comissao, 0);
	}
}
