package br.com.k21;

import junit.framework.Assert;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Test;

public class CadastroDeUmaVendaInterfaceTest extends FluentTest {

	@Test
	public void teste_cadastra_uma_venda_Sem_preencher_campos_obrigatorios() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("");
		fill("#DataVenda").with("");
		fill("#Valor").with("");
		
		submit("input[type=\"submit\"]");
		
		Assert.assertEquals("O campo Id Vendedor é obrigatório.", findFirst("#validacaoVendedor").getText()); 
		Assert.assertEquals("O campo Valor é obrigatório.", findFirst("#validacaoValor").getText()); 
		Assert.assertEquals("O campo Data Venda é obrigatório.", findFirst("#validacaoDataVenda").getText());
					
	}
	
	@Test
	public void teste_cadastra_uma_venda_caminho_feliz() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("1");
		fill("#DataVenda").with("01/01/2014");
		fill("#Valor").with("100");
		
		submit("input[type=\"submit\"]");
		
		FluentWebElement findFirst = findFirst("#vendaEfetuada");
		
		Assert.assertNotNull("Nao encontrei a mensagem de venda registrada com sucesso",findFirst);
		Assert.assertEquals("A venda foi registrada com sucesso.", findFirst.getText());
					
	}

	@Test
	public void teste_cadastra_uma_venda_com_data_futura() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("1");
		fill("#DataVenda").with("01/01/3000");
		fill("#Valor").with("100");
		
		submit("input[type=\"submit\"]");
		
		Assert.assertEquals("Algumas condições para o cadastro na venda nao sao satisfatorias!", findFirst("*//form/h2").getText());
		Assert.assertEquals("A data da venda não pode ser no futuro.", findFirst("#validacaoDataVenda").getText());
					
	}

}
