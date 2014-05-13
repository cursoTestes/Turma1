package br.com.k21;

import java.util.List;

import br.com.k21.dao.VendaDAO;
import br.com.k21.modelo.Venda;

public class CalculadoraRoyalties {

	private VendaDAO dao;
	private CalculadoraComissao calculadoraComissao ;

	public double calcula(int mes, int ano) {
		
		List<Venda> vendas = dao.obterVendasPorMesEAno(ano, mes);
		double total = 0.0;
		
		for (Venda venda : vendas) {
			total += venda.getValor() ;
		}
		
		double royalty = total * 0.2; 
		
		return royalty;
	}

	public VendaDAO getDao() {
		return dao;
	}

	public void setDao(VendaDAO dao) {
		this.dao = dao;
	}

	public CalculadoraComissao getCalculadoraComissao() {
		return calculadoraComissao;
	}

	public void setCalculadoraComissao(CalculadoraComissao calculadoraComissao) {
		this.calculadoraComissao = calculadoraComissao;
	}

	
}
