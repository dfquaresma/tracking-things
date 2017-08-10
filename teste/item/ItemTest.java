package item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import item.bluray.Filme;

public class ItemTest {
	private Filme filmeTest;
	
	@Before
	public void setUp() {
		this.filmeTest = new Filme("Senhor dos anéis", 220, 150, "ACAO", "DEZ_ANOS", 2002);
	}

	@Test
	public void testGetsDeItem() {

		assertEquals("Senhor dos anéis", filmeTest.getNome());
		assertEquals(220, filmeTest.getPreco(), 0.01);

		assertEquals("Senhor dos anéis", filmeTest.getInfo("Nome"));
		assertEquals("220.0", filmeTest.getInfo("Preco"));

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
	
	@Test
	public void testAttNome() {
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
	public void testAttPreco() {
		try {
			filmeTest.setPreco(0);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Preco invalido", iae.getMessage());
		}
		filmeTest.setPreco(100);
		assertEquals(100, filmeTest.getPreco(), 0.01);
	}

	
	
}
