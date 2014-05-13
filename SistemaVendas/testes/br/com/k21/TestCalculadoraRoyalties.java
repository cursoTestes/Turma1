package br.com.k21;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.k21.dao.VendaDAO;
import br.com.k21.modelo.Venda;

public class TestCalculadoraRoyalties {
	
	private CalculadoraComissao mockCalculadoraComissao;
	private VendaDAO mockDao;

	@Before
	public void preparaMocks(){
		mockCalculadoraComissao = mock(CalculadoraComissao.class);
		mockDao = mock(VendaDAO.class);
	}
	
	@Test
	public void calculaParaMesSemVendas() {
		int mes = 3;
		int ano = 2014;
		double valorEsperado = 0.0;
		
		
		List<Venda> listaVazia = Collections.emptyList();
		when(mockDao.obterVendasPorMesEAno(ano, mes)).thenReturn(listaVazia);
		
		CalculadoraRoyalties calculadoraRoyalties = new CalculadoraRoyalties();
		calculadoraRoyalties.setDao(mockDao);
		double retorno = calculadoraRoyalties.calcula(mes, ano);
		
		assertEquals(valorEsperado, retorno, 0);
	}
	
	@Test
	public void calculaParaMesCom1VendaDe100Reais() {
		int mes = 4;
		int ano = 2014;
		double valorEsperado = 19.0;
		int valorVenda = 100;
		
		when(mockCalculadoraComissao.calcula(valorVenda)).thenReturn(5.0);
		
		when(mockDao.obterVendasPorMesEAno(ano, mes)).thenReturn(Arrays.asList(new Venda(0, 0, mes, ano, valorVenda)));
		
		CalculadoraRoyalties calculadoraRoyalties = new CalculadoraRoyalties();
		calculadoraRoyalties.setDao(mockDao);
		calculadoraRoyalties.setCalculadoraComissao(mockCalculadoraComissao);
		double retorno = calculadoraRoyalties.calcula(mes, ano);
		
		assertEquals(valorEsperado, retorno, 0);
	}
	
	@Test
	public void calculaParaMesCom1VendaDe200Reais() {
		int mes = 4;
		int ano = 2014;
		double valorEsperado = 40.0;
		int valorVenda = 200;
		
		when(mockCalculadoraComissao.calcula(valorVenda)).thenReturn(0.0);
		
		when(mockDao.obterVendasPorMesEAno(ano, mes)).thenReturn(Arrays.asList(new Venda(0, 0, mes, ano, valorVenda)));
		
		CalculadoraRoyalties calculadoraRoyalties = new CalculadoraRoyalties();
		calculadoraRoyalties.setDao(mockDao);
		calculadoraRoyalties.setCalculadoraComissao(mockCalculadoraComissao);
		double retorno = calculadoraRoyalties.calcula(mes, ano);
		
		assertEquals(valorEsperado, retorno, 0);
		
		verify(mockCalculadoraComissao,times(1)).calcula(valorVenda);
	}

}
