package util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import emprestimo.Emprestimo;
import excecoes.OperacaoNaoPermitidaNoMomentoExcecao;
import item.Item;
import item.bluray.Show;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;
import usuario.Usuario;

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
	 * Testa se, quando é passado uma lista de itens válida para listagem, nenhuma
	 * exceção é lançada.
	 */
	@Test
	public void testValidaItensParaListagem() {
		List<Item> itens = new ArrayList<Item>();

		Item itemA = new JogoTabuleiro("Xadrez", 200);
		Item itemB = new JogoEletronico("Dota", 200, "PC");
		Item itemC = new Show("AC DC - Live in River Plate", 300, 2, 11, "AC_DC", "DEZ_ANOS");

		itens.add(itemA);
		itens.add(itemB);
		itens.add(itemC);

		this.validador.validaListaDeItensParaListagem(itens);
	}

	/**
	 * Testa se, quando é passado uma lista de emprestimos válida para listagem,
	 * nenhuma exceção é lançada.
	 */
	@Test
	public void testValidaEmprestimosParaListagem() {
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

		Usuario user1 = new Usuario("Amandio", "3371-0000", "amandio@gmail.com");
		Usuario user2 = new Usuario("Testandio", "3371-0001", "testandio@ccc.ufcg.edu.com");
		Usuario user3 = new Usuario("Errandio", "3371-0002", "errandio@hotmail.com");

		Item itemA = new JogoTabuleiro("Xadrez", 200);
		Item itemB = new JogoEletronico("Dota", 200, "PC");
		Item itemC = new Show("AC DC - Live in River Plate", 300, 2, 11, "AC_DC", "DEZ_ANOS");

		user1.adicionaItem(itemA);
		user2.adicionaItem(itemB);
		user3.adicionaItem(itemC);

		Emprestimo emprestimo1 = new Emprestimo(user1, user2, itemA.getNome(), "18/08/2017", 1);
		Emprestimo emprestimo2 = new Emprestimo(user2, user3, itemB.getNome(), "16/08/2017", 2);
		Emprestimo emprestimo3 = new Emprestimo(user3, user1, itemC.getNome(), "15/08/2017", 3);

		emprestimos.add(emprestimo1);
		emprestimos.add(emprestimo2);
		emprestimos.add(emprestimo3);

		this.validador.validaListaDeEmprestimosParaListagem(emprestimos);

	}

	/**
	 * Metodo para testar se, quando é passado uma lista de itens vazia, uma excecao
	 * é lancada.
	 */
	@Test(expected = OperacaoNaoPermitidaNoMomentoExcecao.class)
	public void testValidaItensParaListagemVazia() {
		List<Item> itens = new ArrayList<Item>();
		this.validador.validaListaDeItensParaListagem(itens);
	}

	/**
	 * Metodo para testar se, quando é passado uma lista de emprestimos vazia, uma
	 * excecao é lancada.
	 */
	@Test(expected = OperacaoNaoPermitidaNoMomentoExcecao.class)
	public void testValidaEmprestimosParaListagemVazia() {
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		this.validador.validaListaDeEmprestimosParaListagem(emprestimos);
	}

	/**
	 * Metodo para testar se, quando é passado uma lista de itens null, uma excecao
	 * é lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testValidaItensParaListagemNull() {
		this.validador.validaListaDeItensParaListagem(null);
	}

	/**
	 * Metodo para testar se, quando é passado uma lista de emprestimos null, uma
	 * excecao é lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testValidaEmprestimosParaListagemNull() {
		this.validador.validaListaDeEmprestimosParaListagem(null);
	}

	/**
	 * Metodo para testar se, quando é passado uma lista de itens com elementos
	 * null, uma excecao é lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testValidaItensParaListagemItemNull() {
		List<Item> itens = new ArrayList<Item>();
		itens.add(null);
		this.validador.validaListaDeItensParaListagem(itens);
	}

	/**
	 * Metodo para testar se, quando é passado uma lista de emprestimos com
	 * elementos null, uma excecao é lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testValidaEmprestimosParaListagemEmprestimoNull() {
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		emprestimos.add(null);
		this.validador.validaListaDeEmprestimosParaListagem(emprestimos);
	}

}
