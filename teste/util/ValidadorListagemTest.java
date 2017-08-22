package util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import excecoes.OperacaoNaoPermitidaNoMomentoExcecao;
import item.Item;
import item.bluray.Temporada;

/**
 * Testa a classe de validação.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class ValidadorListagemTest {

	private ValidadorListagem validador;

	/**
	 * Prepara o ambiente para os testes.
	 */
	@Before
	public void criaValidador() {
		this.validador = new ValidadorListagem();
	}

	/**
	 * Testa se, quando é passado uma lista válida para listagem, nenhuma
	 * exceção é lançada.
	 */
	@Test
	public void testValidaItensParaListagem() {
		List<Item> itens = new ArrayList<Item>();
		itens.add(new Temporada("South Park", 1000.00, "Primeira temporada de South Park", 120, "DEZOITO_ANOS",
				"COMEDIA", 1));
		this.validador.validaListaDeItensParaListagem(itens);
	}

	/**
	 * Metodo para testar se, quando é passado uma lista vazia, uma excecao é
	 * lancada.
	 */
	@Test(expected = OperacaoNaoPermitidaNoMomentoExcecao.class)
	public void testValidaItensParaListagemVazia() {
		List<Item> itens = new ArrayList<Item>();
		this.validador.validaListaDeItensParaListagem(itens);
	}

	/**
	 * Metodo para testar se, quando é passado uma lista Null, uma excecao é
	 * lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testValidaItensParaListagemNull() {
		this.validador.validaListaDeItensParaListagem(null);
	}

	/**
	 * Metodo para testar se, quando é passado uma lista com elementos Null, uma
	 * excecao é lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testValidaItensParaListagemItemNull() {
		List<Item> itens = new ArrayList<Item>();
		itens.add(null);
		this.validador.validaListaDeItensParaListagem(itens);
	}

}
