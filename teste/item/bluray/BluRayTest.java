package item.bluray;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Testa os métodos da classe BluRay
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class BluRayTest {
	private BluRay blurayTemp;
	private BluRay blurayFilme;
	private BluRay blurayShow;

	/**
	 * Prepara o ambiente para testes.
	 */
	@Before
	public void criaBluray() {
		this.blurayTemp = new Temporada("South Park", 1000.00, "Primeira temporada de South Park", 120, "DEZOITO_ANOS",
				"COMEDIA", 1);
		this.blurayFilme = new Filme("Lagoa Azul", 100.00, 60, "COMEDIA", "DEZ_ANOS", 1900);
		this.blurayShow = new Show("Que Show", 10.50, 90, 10, "eu sou artista", "LIVRE");
	}

	/**
	 * Testa pegar as informacoes do bluray
	 */
	@Test
	public void testGetInfo() {
		assertEquals("120", this.blurayTemp.getInfo("Duracao"));
		assertEquals("60", this.blurayFilme.getInfo("Duracao"));
		assertEquals("90", this.blurayShow.getInfo("Duracao"));

		assertEquals("DEZOITO_ANOS", this.blurayTemp.getInfo("Classificacao"));
		assertEquals("DEZ_ANOS", this.blurayFilme.getInfo("Classificacao"));
		assertEquals("LIVRE", this.blurayShow.getInfo("Classificacao"));
	}

	/**
	 * Testa pegar informacao do bluray passando como parametro null
	 */
	@Test(expected = NullPointerException.class)
	public void testGetInfoNull() {
		this.blurayTemp.getInfo(null);
	}

	/**
	 * Testa pegar informacao do bluray passando como parametro string vazia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoInvalida() {
		this.blurayTemp.getInfo("   ");
	}

	/**
	 * Testa atualizar os atributos do bluray
	 */
	@Test
	public void testAtualizaAtributo() {
		this.blurayFilme.atualizaAtributo("Duracao", "1000");
		assertEquals(1000, this.blurayFilme.getDuracao());
		this.blurayFilme.atualizaAtributo("Classificacao", "QUATORZE_ANOS");
		assertEquals("QUATORZE_ANOS", this.blurayFilme.getClassificacao());
		this.blurayFilme.atualizaAtributo("Nome", "Os Simpsons");
		assertEquals("Os Simpsons", this.blurayFilme.getNome());
	}

	/**
	 * Testa atualizar um atributo do bluray passando como atributo null
	 */
	@Test(expected = NullPointerException.class)
	public void testAtualizaAtributoNull() {
		this.blurayFilme.atualizaAtributo(null, "1000");
	}

	/**
	 * Testa atualizar um atributo do bluray passando como valor null
	 */
	@Test(expected = NullPointerException.class)
	public void testAtualizaAtributoValorNull() {
		this.blurayFilme.atualizaAtributo("Duracao", null);
	}

	/**
	 * Testa atualizar um atributo do bluray passando como atributo uma string
	 * vazia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaAtributoInvalido() {
		this.blurayFilme.atualizaAtributo("   ", "1000");
	}

	/**
	 * Testa atualizar um atributo do bluray passando como valor uma string
	 * vazia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaAtributoValorInvalido() {
		this.blurayFilme.atualizaAtributo("Duracao", "  ");
	}

	/**
	 * Testa atualizar a duracao do bluray passando um valor que nao é um
	 * inteiro
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaAtributoValorDuracaoNaoInteiro() {
		this.blurayFilme.atualizaAtributo("Duracao", "naosouinteiro");
	}

	/**
	 * Testa atualizar a duracao do bluray passando zero como valor
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaAtributoValorDuracaoInvalida() {
		this.blurayFilme.atualizaAtributo("Duracao", "0");
	}

	/**
	 * Testa atualizar a classificacao do bluray passando um valor invalido
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaAtributoValorClassificacaoInvalida() {
		this.blurayFilme.atualizaAtributo("Classificacao", "naosouclassificacao");
	}

	/**
	 * Testa atualizar a duracao de um bluray passando um atributo invalido
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaAtributoValorAtributoDuracaoInvalido() {
		this.blurayFilme.atualizaAtributo("duracao", "100");
	}

	/**
	 * Testa atribuir uma duracao ao bluray
	 */
	@Test
	public void testSetDuracao() {
		this.blurayShow.setDuracao(300);
		assertEquals(300, this.blurayShow.getDuracao());
	}

	/**
	 * Testa atribuir uma duracao de valor zero no bluray
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetDuracaoInvalida() {
		this.blurayShow.setDuracao(0);
	}

	/**
	 * Testa atribuir uma classificacao ao bluray
	 */
	@Test
	public void testSetClassificacao() {
		this.blurayShow.setClassificacao("DEZESSEIS_ANOS");
		assertEquals("DEZESSEIS_ANOS", this.blurayShow.getClassificacao());
	}

	/**
	 * Testa atribuir uma classificacao ao bluray com parametro nulo
	 */
	@Test(expected = NullPointerException.class)
	public void testSetClassificacaoNull() {
		this.blurayShow.setClassificacao(null);
	}

	/**
	 * Testa atribuir uma classificacao ao bluray com parametro vazio
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetClassificacaoInvalida() {
		this.blurayShow.setClassificacao("  ");
	}

	/**
	 * Testa atribuir uma classificacao ao bluray com parametro invalido
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetClassificacaoNotInside() {
		this.blurayShow.setClassificacao("naosouclassificacao");
	}
}
