package item.bluray;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Testa as funcionalidades da classe Show.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class ShowTest {
	private Show showTest;

	/**
	 * Prepara o ambiente para os testes.
	 */
	@Before
	public void setUp() {
		this.showTest = new Show("AC_DC - Live in River Plate", 200, 120, 20, "AC DC", "DEZ_ANOS");
	}

	/**
	 * Metodo que testa o comportamento do Construtor quando o nome do Show eh
	 * nulo
	 */
	@Test(expected = NullPointerException.class)
	public void testShowNomeNull() {
		new Show(null, 200, 120, 20, "AC DC", "DEZ_ANOS");
	}

	/**
	 * Metodo que testa o comportamento do Construtor quando o nome do Show eh
	 * vazio
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testShowNomeVazio() {
		new Show("   ", 200, 120, 20, "AC DC", "DEZ_ANOS");
	}

	/**
	 * Metodo que testa o comportamento do Construtor quando o preco do Show eh
	 * Invalido
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testShowValorInvalido() {
		new Show("AC_DC", -0.0001, 120, 20, "AC DC", "DEZ_ANOS");
	}

	/**
	 * Metodo que testa o comportamento do Construtor quando a duracao do Show
	 * eh Invalida
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testShowDuracaoInvalida() {
		new Show("AC_DC", 200, 0, 20, "AC DC", "DEZ_ANOS");
	}

	/**
	 * Metodo que testa o comportamento do Construtor quando o numero de faixas
	 * do Show eh invalido
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testShowNumeroFaixasInvalida() {
		new Show("AC_DC", 200, 120, 0, "AC DC", "DEZ_ANOS");
	}

	/**
	 * Metodo que testa o comportamento do Construtor quando o nome do Artista
	 * do Show eh nulo
	 */
	@Test(expected = NullPointerException.class)
	public void testShowArtistaNull() {
		new Show("AC_DC", 200, 120, 20, null, "DEZ_ANOS");
	}

	/**
	 * Metodo que testa o comportamento do Construtor quando o nome do Artista
	 * do Show eh vazio
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testShowArtistaVazio() {
		new Show("AC_DC", 200, 120, 20, "  ", "DEZ_ANOS");
	}

	/**
	 * Metodo que testa o comportamento do Construtor quando a classificacao do
	 * Show eh nula
	 */
	@Test(expected = NullPointerException.class)
	public void testShowClassificacaoNull() {
		new Show("AC_DC", 200, 120, 20, "AC DC", null);
	}

	/**
	 * Metodo que testa o comportamento do Construtor quando a classificacao do
	 * Show eh vazia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testShowClassificacaoVazio() {
		new Show("AC_DC", 200, 120, 20, "AC DC", " ");
	}

	/**
	 * Metodo que testa o comportamento do Construtor quando a classificacao do
	 * Show eh invalida
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testShowClassificacaoInvalida() {
		new Show("AC_DC", 200, 120, 20, "AC DC", "novinho");
	}

	/**
	 * Metodo que testa se os getters e setters estao retornando corretamente os
	 * atributos desejados
	 */
	@Test
	public void testGets() {
		assertEquals("AC_DC - Live in River Plate", showTest.getNome());
		assertEquals(200, showTest.getPreco(), 0.01);
		assertEquals(120, showTest.getDuracao());
		assertEquals(20, showTest.getNumDeFaixas());
		assertEquals("AC DC", showTest.getArtista());
		assertEquals("DEZ_ANOS", showTest.getClassificacao());

		assertEquals("AC DC", showTest.getInfo("Artista"));
		assertEquals("20", showTest.getInfo("Numero de faixas"));
	}

	/**
	 * Metodo que testa o comportamento de setNumDeFaixas (tambem incluidos os
	 * comportamentos de risco)
	 */
	@Test
	public void testSetNumeroDeFaixas() {
		try {
			showTest.setNumDeFaixas(0);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Numero de faixas nao pode ser menor ou igual a zero.", iae.getMessage());
		}
		showTest.setNumDeFaixas(2);
		assertEquals(2, showTest.getNumDeFaixas());
	}

	/**
	 * Metodo que testa os comportamento de setArtista quando eh necessario
	 * realizar uma mudanca
	 */
	@Test
	public void testSetArtista() {
		try {
			showTest.setArtista(null);
			fail();
		} catch (NullPointerException iae) {
			assertEquals("Artista nao pode ser nulo", iae.getMessage());
		}
		try {
			showTest.setArtista("");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Artista nao pode ser vazio", iae.getMessage());
		}
		showTest.setArtista("Alguem");
		assertEquals("Alguem", showTest.getArtista());
	}

	/**
	 * Metodo que testa se getInfo() esta retorno os atributos desejados
	 */
	@Test
	public void testGetInfo() {
		assertEquals("AC DC", this.showTest.getInfo("Artista"));
		assertEquals("20", this.showTest.getInfo("Numero de faixas"));
		assertEquals("AC_DC - Live in River Plate", this.showTest.getInfo("Nome"));
	}

	/**
	 * Metodo que testa o comportamento quando o atributo a ser buscado eh null
	 */
	@Test(expected = NullPointerException.class)
	public void testGetInfoAtributoNull() {
		this.showTest.getInfo(null);
	}

	/**
	 * Metodo que testa quando o atributo a ser buscado eh vazio
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAtributoVazio() {
		this.showTest.getInfo(" ");
	}

	/**
	 * Metodo que testa quando o atributo nao eh nenhum atributo cadastrado no
	 * sistema
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAtributoInvalido() {
		this.showTest.getInfo("nao sou atributo");
	}

	/**
	 * Metodo que testa a corretude do metodo toString().
	 */
	@Test
	public void testToString() {
		assertEquals("SHOW: AC_DC - Live in River Plate, R$ 200.0, Nao emprestado, 120 min, DEZ_ANOS, AC DC, 20 faixas",
				showTest.toString());
	}

	/**
	 * Metodo que testa o comportamento, em relacao a corretudo, de
	 * atualizaAtributo
	 */
	@Test
	public void testAtualizaAtributo() {
		this.showTest.atualizaAtributo("Artista", "PabloVittar");
		assertEquals("PabloVittar", this.showTest.getArtista());
		this.showTest.atualizaAtributo("Numero de faixas", "50");
		assertEquals(50, this.showTest.getNumDeFaixas());
		this.showTest.atualizaAtributo("Duracao", "150");
		assertEquals(150, this.showTest.getDuracao());
	}

	/**
	 * Metodo que testa o comportamento de atualizaAtributo quando o nome do
	 * atributo eh nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testAtualizaAtributoNull() {
		this.showTest.atualizaAtributo(null, "PabloVittar");
	}

	/**
	 * Metodo que testa o comportamento de atualizaAtributo quando o nome do
	 * atributo eh vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaAtributoVazio() {
		this.showTest.atualizaAtributo(" ", "PabloVittar");
	}

	/**
	 * Metodo que testa o comportamento de atualizaAtributo quando o nome do
	 * atributo eh invalido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaAtributoInvalido() {
		this.showTest.atualizaAtributo("naosouatributo", "PabloVittar");
	}

	/**
	 * Metodo que testa o comportamento de atualizaAtributo quando o valor do
	 * atributo eh nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testAtualizaValorNull() {
		this.showTest.atualizaAtributo("Artista", null);
	}

	/**
	 * Metodo que testa o comportamento de atualizaAtributo quando o valor do
	 * atributo eh vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaValorVazio() {
		this.showTest.atualizaAtributo("Numero de faixas", " ");
	}

	/**
	 * Metodo que testa o comportamento de atualizaAtributo quando o numero de
	 * faixas do atributo nao eh um inteiro.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaNumFaixaNaoInt() {
		this.showTest.atualizaAtributo("Numero de faixas", "cinquentamil");
	}
}
