package item.bluray;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class FilmeTest {

	private Filme filmeTest;
	
	@Before
	public void setUp() {
		this.filmeTest = new Filme("Senhor dos anéis", 220, 150, "ACAO", "DEZ_ANOS", 2002);
	}
	
	@Test
	public void testGetsEspecificos() {

		assertEquals("Senhor dos anéis", filmeTest.getNome());
		assertEquals(220, filmeTest.getPreco(), 0.01);
		assertEquals(150, filmeTest.getDuracao());
		assertEquals("DEZ_ANOS", filmeTest.getClassificacao());

		assertEquals("Senhor dos anéis", filmeTest.getInfo("Nome"));
		assertEquals("DEZ_ANOS", filmeTest.getInfo("Classificacao"));

		try {
			filmeTest.getInfo(null);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Atributo nao pode ser nulo", npe.getMessage());
		}

		try {
			filmeTest.getInfo("");
			fail();
		} catch (IllegalArgumentException npe) {
			assertEquals("Atributo nao pode ser vazio", npe.getMessage());
		}

	}
	
	public void testSetGenero() {
		try {
			filmeTest.setGenero(null);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Valor nao pode ser nulo", npe.getMessage());
		}
		try {
			filmeTest.setGenero("");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Valor nao pode ser vazio", iae.getMessage());
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
	
	public void testSetAnoLancamento() {
		try {
			filmeTest.setAnoDeLancamento(0);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Ano de lancamento nao pode ser menor ou igual a zero", iae.getMessage());
		}
		filmeTest.setAnoDeLancamento(10);
		assertEquals(10, filmeTest.getAnoDeLancamento());
		
	}
	
	@Test
	public void testSetNome() {
		try {
			filmeTest.setNome(null);
			fail();
		} catch (NullPointerException iae) {
			assertEquals("Nome nao pode ser nulo", iae.getMessage());
		}
		try {
			filmeTest.setNome("");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
		filmeTest.setNome("NomeTest1");
		assertEquals("NomeTest1", filmeTest.getNome());

	}

	@Test
	public void testSetPreco() {
		try {
			filmeTest.setPreco(0);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Preco invalido", iae.getMessage());
		}
		filmeTest.setPreco(100);
		assertEquals(100, filmeTest.getPreco(), 0.01);
	}

	@Test
	public void testSetDuracao() {
		try {
			filmeTest.setDuracao(0);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Duracao nao pode ser menor ou igual a zero", iae.getMessage());
		}
		filmeTest.setDuracao(10);
		assertEquals(10, filmeTest.getDuracao());
	}

	@Test
	public void testSetClassificacao() {
		try {
			filmeTest.setClassificacao(null);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Classificacao nao pode ser nulo", npe.getMessage());
		}
		try {
			filmeTest.setClassificacao("");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao nao pode ser vazio", iae.getMessage());
		}
		try {
			filmeTest.setClassificacao("ZERO_ANOS");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao inválida", iae.getMessage());
		}
		filmeTest.setClassificacao("DOZE_ANOS");
		assertEquals("DOZE_ANOS", filmeTest.getClassificacao());
	}

	@Test
	public void testAtualizaAtributoNome() {
		try {
			filmeTest.atualizaAtributo("Nome", null);
			fail();
		} catch (NullPointerException iae) {
			assertEquals("Valor nao pode ser nulo", iae.getMessage());
		}
		try {
			filmeTest.atualizaAtributo("Nome", "");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Valor nao pode ser vazio", iae.getMessage());
		}
		filmeTest.atualizaAtributo("Nome", "Outro");
		
	}

	@Test
	public void testAtualizaAtributoPreco() {
		try {
			filmeTest.atualizaAtributo("Preco", "-1");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Valor nao pode ser menor ou igual a zero para essa operacao", iae.getMessage());
		}
		filmeTest.atualizaAtributo("Preco", "20");
		
	}
	
	@Test
	public void testAtualizaAtributoDuracao() {
		try {
			filmeTest.atualizaAtributo("Duracao", "0");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Valor nao pode ser menor ou igual a zero para essa operacao", iae.getMessage());
		}
		filmeTest.atualizaAtributo("Duracao", "20");

	}

	@Test
	public void testAtualizaAtributoAnoLancamento() {
		try {
			filmeTest.setAnoDeLancamento(0);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Ano nao pode ser menor ou igual a zero.", iae.getMessage());
		}
		filmeTest.setAnoDeLancamento(10);
		assertEquals(10, filmeTest.getAnoDeLancamento());
		
	}

	@Test
	public void testAtualizaAtributoClassificacao() {
		

		try {
			filmeTest.atualizaAtributo("Classificacao", null);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Valor nao pode ser nulo", npe.getMessage());
		}
		try {
			filmeTest.atualizaAtributo("Classificacao", "");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Valor nao pode ser vazio", iae.getMessage());
		}
		try {
			filmeTest.atualizaAtributo("Classificacao", "ZERO_ANOS");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao inválida", iae.getMessage());
		}
		filmeTest.atualizaAtributo("Classificacao", "DOZE_ANOS");
		
	}

	@Test
	public void testAtualizaAtributoGenero() {
		try {
			filmeTest.atualizaAtributo("Genero", null);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Valor nao pode ser nulo", npe.getMessage());
		}
		try {
			filmeTest.atualizaAtributo("Genero", "");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Valor nao pode ser vazio", iae.getMessage());
		}
		try {
			filmeTest.atualizaAtributo("Genero", "ZERO_ANOS");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Genero inválido", iae.getMessage());
		}
		filmeTest.atualizaAtributo("Genero", "DRAMA");

	}

	@Test
	public void testAtualizaAtributoInvalido() {
		try {
			filmeTest.atualizaAtributo("Outro", "-1");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Atributo invalido", iae.getMessage());
		}
	}
	
	@Test
	public void testToString() {
		assertEquals("FILME: Senhor dos anéis, R$ 220.0, Nao emprestado, 150 min, DEZ_ANOS, ACAO, 2002", filmeTest.toString());

	}

}
