package item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import item.bluray.Filme;

public class ItemTest {
	private Item filmeTest;
	
	@Before
	public void setUp() {
		this.filmeTest = new Filme("Kickass", 220, 150, "ACAO", "DEZ_ANOS", 2002);
	}
	
	@Test
	public void testItem()
	{
		assertEquals("Kickass", this.filmeTest.getNome());
		assertEquals(220.0, this.filmeTest.getPreco(), 0.00005);
		assertEquals("Nao emprestado", this.filmeTest.getEstadoEmprestimo());
	}
	
	@Test
	public void testPodeSerEmprestado()
	{
		assertEquals(true, this.filmeTest.podeSerEmprestado());
		this.filmeTest.setEmprestado(true);
		assertEquals(false, this.filmeTest.podeSerEmprestado());
	}
	
	@Test
	public void testSetNome()
	{
		this.filmeTest.setNome("Lagoa Azul");
		assertEquals("Lagoa Azul", this.filmeTest.getNome());
	}
	
	@Test(expected=NullPointerException.class)
	public void testSetNomeNull()
	{
		this.filmeTest.setNome(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetNomeVazio()
	{
		this.filmeTest.setNome("");
	}
	
	@Test
	public void testSetPreco()
	{
		this.filmeTest.setPreco(345.50);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetPrecoInvalido()
	{
		this.filmeTest.setPreco(0.000);
	}
	
	@Test
	public void testIsEmprestado()
	{
		this.filmeTest.setEmprestado(false);
		assertEquals(false, this.filmeTest.isEmprestado());
		this.filmeTest.setEmprestado(true);
		assertEquals(true, this.filmeTest.isEmprestado());
	}
	
	@Test
	public void testGetEstadoEmprestimo()
	{
		assertEquals("Nao emprestado", this.filmeTest.getEstadoEmprestimo());
		this.filmeTest.setEmprestado(true);
		assertEquals("Emprestado", this.filmeTest.getEstadoEmprestimo());
	}
	
	@Test
	public void testCompareTo()
	{
		Item newItem = new Filme("Rodaviva", 220, 150, "OUTRO", "DEZ_ANOS", 1999);
		assertEquals(true, this.filmeTest.compareTo(newItem) < 0);
		assertEquals(true, newItem.compareTo(filmeTest) > 0);
		assertEquals(true, this.filmeTest.compareTo(filmeTest) == 0);
	}

	@Test
	public void testGetsDeItem()
	{
		assertEquals("Kickass", filmeTest.getNome());
		assertEquals(220, filmeTest.getPreco(), 0.01);

		assertEquals("Kickass", filmeTest.getInfo("Nome"));
		assertEquals("220.0", filmeTest.getInfo("Preco"));
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
