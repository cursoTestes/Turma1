package br.com.k21;

public class CalculadoraComissao {

	public double calcula(double valorDaVenda) {
			double comissao = valorDaVenda * 5 / 100;
			comissao *= 100;
			comissao = Math.floor(comissao);
			comissao /= 100;
			return comissao;
	}

}
