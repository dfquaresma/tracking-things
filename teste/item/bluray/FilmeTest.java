package item.bluray;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Testa criar um bluray de filme
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class FilmeTest {

	private Filme filmeTest;

	/**
	 * Prepara o ambiente para testes.
	 */
	@Before
	public void setUp() {
		this.filmeTest = new Filme("Senhor dos anéis", 220, 150, "ACAO", "DEZ_ANOS", 2002);
	}

	/**
	 * Testa instanciar um bluray de filme com nome nulo
	 */
	@Test(expected = NullPointerException.class)
	public void testFilmeNomeNull() {
		new Filme(null, 220, 150, "ACAO", "DEZ_ANOS", 2002);
	}

	/**
	 * Testa instanciar um bluray de filme com nome vazio
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFilmeNomeVazio() {
		new Filme(" ", 220, 150, "ACAO", "DEZ_ANOS", 2002);
	}

	/**
	 * Testa instanciar um bluray de filme com preco invalido
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFilmeValorInvalido() {
		new Filme("Senhor dos anéis", -0.0001, 150, "ACAO", "DEZ_ANOS", 2002);
	}

	/**
	 * Testa instanciar um bluray de filme com duracao igual a zero
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFilmeDuracaoInvalida() {
		new Filme("Senhor dos anéis", 220, 0, "ACAO", "DEZ_ANOS", 2002);
	}

	/**
	 * Testa instanciar um bluray de filme com genero nulo
	 */
	@Test(expected = NullPointerException.class)
	public void testFilmeGeneroNull() {
		new Filme("Senhor dos anéis", 220, 150, null, "DEZ_ANOS", 2002);
	}

	/**
	 * Testa instanciar um bluray de filme com genero vazio
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFilmeGeneroVazio() {
		new Filme("Senhor dos anéis", 220, 150, " ", "DEZ_ANOS", 2002);
	}

	/**
	 * Testa instanciar um bluray de filme com genero invalido
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFilmeGeneroInvalido() {
		new Filme("Senhor dos anéis", 220, 150, "acao", "DEZ_ANOS", 2002);
	}

	/**
	 * Testa instanciar um bluray de filme com classificacao nula
	 */
	@Test(expected = NullPointerException.class)
	public void testFilmeClassificacaoNull() {
		new Filme("Senhor dos anéis", 220, 150, "ACAO", null, 2002);
	}

	/**
	 * Testa instanciar um bluray de filme com classificacao vazia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFilmeClassificacaoVazia() {
		new Filme("Senhor dos anéis", 220, 150, "ACAO", " ", 2002);
	}

	/**
	 * Testa instanciar um bluray de filme com classificacao invalida
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFilmeClassificacaoInvalida() {
		new Filme("Senhor dos anéis", 220, 150, "ACAO", "quinze_", 2002);
	}

	/**
	 * Testa instanciar um bluray de filme com ano de lancamento igual a zero
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFilmeAnoLancamentoInvalido() {
		new Filme("Senhor dos anéis", 220, 150, "ACAO", "DEZ_ANOS", 0);
	}

	/**
	 * Testa atribuir um genero ao bluray de genero com generos invalidos
	 */
	@Test
	public void testSetGenero() {
		try {
			filmeTest.setGenero(null);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Genero nao pode ser nulo", npe.getMessage());
		}
		try {
			filmeTest.setGenero("");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Genero nao pode ser vazio", iae.getMessage());
		}
		try {
			filmeTest.setGenero("ZERO_ANOS");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Genero inválido", iae.getMessage());
		}
		filmeTest.setGenero("DRAMA");
		assertEquals("DRAMA", filmeTest.getGenero());

	}

	/**
	 * Testa atribuir um ano de lancamento ao bluray de filme válido e igual a
	 * zero
	 */
	@Test
	public void testSetAnoLancamento() {
		try {
			filmeTest.setAnoDeLancamento(0);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Ano nao pode ser menor ou igual a zero.", iae.getMessage());
		}
		filmeTest.setAnoDeLancamento(10);
		assertEquals(10, filmeTest.getAnoDeLancamento());

	}

	/**
	 * Testa pegar informacoes de um bluray de filme
	 */
	@Test
	public void testGetInfo() {
		assertEquals("ACAO", this.filmeTest.getInfo("Genero"));
		assertEquals("2002", this.filmeTest.getInfo("Lancamento"));
		assertEquals("Senhor dos anéis", this.filmeTest.getInfo("Nome"));
	}

	/**
	 * Testa pegar uma informacao de um bluray de genero com atributo nulo
	 */
	@Test(expected = NullPointerException.class)
	public void testGetInfoAtributoNull() {
		this.filmeTest.getInfo(null);
	}

	/**
	 * Testa pegar uma informacao de um bluray de filme com atributo vazio
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAtributoVazio() {
		this.filmeTest.getInfo("  ");
	}

	/**
	 * Testa pegar uma informacao de um bluray de filme com atributo invalido
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAtributoInvalido() {
		this.filmeTest.getInfo("naosouumatributo");
	}

	/**
	 * Testa a representacao de um bluray de filme
	 */
	@Test
	public void testToString() {
		assertEquals("FILME: Senhor dos anéis, R$ 220.0, Nao emprestado, 150 min, DEZ_ANOS, ACAO, 2002",
				filmeTest.toString());
	}

	/**
	 * Testa pegar informacoes especificas de um bluray de filme
	 */
	@Test
	public void testGetsEspecificos() {

		assertEquals("Senhor dos anéis", filmeTest.getNome());
		assertEquals(220, filmeTest.getPreco(), 0.01);
		assertEquals(150, filmeTest.getDuracao());
		assertEquals("DEZ_ANOS", filmeTest.getClassificacao());

		assertEquals("Senhor dos anéis", filmeTest.getInfo("Nome"));
		assertEquals("DEZ_ANOS", filmeTest.getInfo("Classificacao"));
	}

	/**
	 * Testa atualizar os atributos de um bluray de filme
	 */
	@Test
	public void testAtualizaAtributo() {
		this.filmeTest.atualizaAtributo("Genero", "COMEDIA");
		assertEquals("COMEDIA", this.filmeTest.getGenero());
		this.filmeTest.atualizaAtributo("Ano de Lancamento", "2010");
		assertEquals(2010, this.filmeTest.getAnoDeLancamento());
		this.filmeTest.atualizaAtributo("Duracao", "150");
		assertEquals(150, this.filmeTest.getDuracao());
	}

	/**
	 * Testa atualizar um atributo de um bluray de filme passando um atributo
	 * nulo
	 */
	@Test(expected = NullPointerException.class)
	public void testAtualizaAtributoNull() {
		this.filmeTest.atualizaAtributo(null, "COMEDIA");
	}

	/**
	 * Testa atualizar um atributo de um bluray de filme passando um atributo
	 * vazio
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaAtributoVazio() {
		this.filmeTest.atualizaAtributo(" ", "COMEDIA");
	}

	/**
	 * Testa atualizar um atributo de um bluray de filme passando um atributo
	 * invalido
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaAtributoInvalido() {
		this.filmeTest.atualizaAtributo("naosouatributo", "COMEDIA");
	}

	/**
	 * Testa atualizar um atributo de um bluray de filme passando um valor nulo
	 */
	@Test(expected = NullPointerException.class)
	public void testAtualizaValorNull() {
		this.filmeTest.atualizaAtributo("Genero", null);
	}

	/**
	 * Testa atualizar um atributo de um bluray de filme passando um valor vazio
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaValorVazio() {
		this.filmeTest.atualizaAtributo("Ano de Lancamento", " ");
	}

	/**
	 * Testa atualizar um atributo de um bluray de filme passando um valor
	 * invalido
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaAnoLancamentoNaoInt() {
		this.filmeTest.atualizaAtributo("Ano de Lancamento", "doismiledois");
	}

	/**
	 * Testa atualizar um atributo de um bluray de filme passando um genero
	 * invalido
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaAtributoGeneroInvalido() {
		this.filmeTest.atualizaAtributo("Genero", "naosoudotipogenero");
	}

}
