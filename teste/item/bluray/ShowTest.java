package item.bluray;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShowTest {
	private Show showTest;

	@Before
	public void setUp() {
		this.showTest = new Show("AC_DC - Live in River Plate", 200, 120, 20, "AC DC", "DEZ_ANOS");
	}

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

		try {
			showTest.getInfo(null);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Atributo nao pode ser nulo", npe.getMessage());
		}

		try {
			showTest.getInfo("");
			fail();
		} catch (IllegalArgumentException npe) {
			assertEquals("Atributo nao pode ser vazio", npe.getMessage());
		}

	}

	@Test
	public void testSetNome() {
		try {
			showTest.setNome(null);
			fail();
		} catch (NullPointerException iae) {
			assertEquals("Nome nao pode ser nulo", iae.getMessage());
		}
		try {
			showTest.setNome("");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
		showTest.setNome("NomeTest1");
		assertEquals("NomeTest1", showTest.getNome());

	}

	@Test
	public void testSetPreco() {
		try {
			showTest.setPreco(0);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Preco invalido", iae.getMessage());
		}
		showTest.setPreco(100);
		assertEquals(100, showTest.getPreco(), 0.01);
	}

	@Test
	public void testSetDuracao() {
		try {
			showTest.setDuracao(0);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Duracao nao pode ser menor ou igual a zero", iae.getMessage());
		}
		showTest.setDuracao(10);
		assertEquals(10, showTest.getDuracao());
	}

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

	@Test
	public void testSetClassificacao() {
		try {
			showTest.setClassificacao(null);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Classificacao nao pode ser nulo", npe.getMessage());
		}
		try {
			showTest.setClassificacao("");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao nao pode ser vazio", iae.getMessage());
		}
		try {
			showTest.setClassificacao("ZERO_ANOS");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao inválida", iae.getMessage());
		}
		showTest.setClassificacao("DOZE_ANOS");
		assertEquals("DOZE_ANOS", showTest.getClassificacao());
	}
	
	@Test
	public void testAtualizaAtributoNome() {
		try {
			showTest.atualizaAtributo("Nome", null);
			fail();
		} catch (NullPointerException iae) {
			assertEquals("Valor nao pode ser nulo", iae.getMessage());
		}
		try {
			showTest.atualizaAtributo("Nome", "");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Valor nao pode ser vazio", iae.getMessage());
		}
		showTest.atualizaAtributo("Nome", "Outro");
		
	}

	@Test
	public void testAtualizaAtributoPreco() {
		try {
			showTest.atualizaAtributo("Preco", "-1");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Valor nao pode ser menor ou igual a zero para essa operacao", iae.getMessage());
		}
		showTest.atualizaAtributo("Preco", "20");
		
	}

	@Test
	public void testAtualizaAtributoDuracao() {
		try {
			showTest.atualizaAtributo("Duracao", "0");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Valor nao pode ser menor ou igual a zero para essa operacao", iae.getMessage());
		}
		showTest.atualizaAtributo("Duracao", "20");

	}

	@Test
	public void testAtualizaAtributoClassificacao() {
		
		try {
			showTest.atualizaAtributo("Classificacao", null);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Valor nao pode ser nulo", npe.getMessage());
		}
		try {
			showTest.atualizaAtributo("Classificacao", "");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Valor nao pode ser vazio", iae.getMessage());
		}
		try {
			showTest.atualizaAtributo("Classificacao", "ZERO_ANOS");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao inválida", iae.getMessage());
		}
		showTest.atualizaAtributo("Classificacao", "DOZE_ANOS");
		
	}
	
	@Test
	public void testToString() {
		assertEquals("SHOW: AC_DC - Live in River Plate, R$ 200.0, Nao emprestado, 120 min, DEZ_ANOS, AC DC, 20 faixas",
				showTest.toString());
	}

}
