package item;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import item.bluray.Filme;

/**
 * Testa as funcionalidades da clase Item.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class ItemTest {
	private Item filmeTest;

	/**
	 * Prepara o ambiente de testes.
	 */
	@Before
	public void setUp() {
		this.filmeTest = new Filme("Kickass", 220, 150, "ACAO", "DEZ_ANOS", 2002);
	}

	/**
	 * Metodo que testa a corretude do Construtor de Item.
	 */
	@Test
	public void testItem() {
		assertEquals("Kickass", this.filmeTest.getNome());
		assertEquals(220.0, this.filmeTest.getPreco(), 0.00005);
		assertEquals("Nao emprestado", this.filmeTest.getEstadoEmprestimo());
	}

	/**
	 * Metodo que testa a corretude do metodo podeSerEmprestado de Item.
	 */
	@Test
	public void testPodeSerEmprestado() {
		assertEquals(true, this.filmeTest.podeSerEmprestado());
		this.filmeTest.setEmprestado(true);
		assertEquals(false, this.filmeTest.podeSerEmprestado());
	}

	/**
	 * Metodo que testa a corretude do metodo setNome de Item.
	 */
	@Test
	public void testSetNome() {
		this.filmeTest.setNome("Lagoa Azul");
		assertEquals("Lagoa Azul", this.filmeTest.getNome());
	}

	/**
	 * Metodo que testa o comportamento do metodo setNome de Item quando o nome
	 * passado é nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testSetNomeNull() {
		this.filmeTest.setNome(null);
	}

	/**
	 * Metodo que testa o comportamento do metodo setNome de Item quando o nome
	 * passado é vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetNomeVazio() {
		this.filmeTest.setNome("");
	}

	/**
	 * Metodo que testa a corretude do metodo setPreco de Item.
	 */
	@Test
	public void testSetPreco() {
		this.filmeTest.setPreco(345.50);
		assertEquals(345.50, this.filmeTest.getPreco(), 0.0001);
	}

	/**
	 * Metodo que testa o comportamento do metodo setPreco quando o preco do
	 * Item é invalido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetPrecoInvalido() {
		this.filmeTest.setPreco(0.000);
	}

	/**
	 * Metodo que testa a corretude do metodo isEmprestado de Item.
	 */
	@Test
	public void testIsEmprestado() {
		this.filmeTest.setEmprestado(true);
		assertEquals(true, this.filmeTest.isEmprestado());
		this.filmeTest.setEmprestado(false);
		assertEquals(false, this.filmeTest.isEmprestado());
	}

	/**
	 * Metodo que testa a corretude do metodo getEstadoEmprestimo de Item.
	 */
	@Test
	public void testGetEstadoEmprestimo() {
		assertEquals("Nao emprestado", this.filmeTest.getEstadoEmprestimo());
		this.filmeTest.setEmprestado(true);
		assertEquals("Emprestado", this.filmeTest.getEstadoEmprestimo());
	}

	/**
	 * Metodo que testa a corretude do metodo getInfo de Item.
	 */
	@Test
	public void testGetInfo() {
		assertEquals("Kickass", this.filmeTest.getInfo("Nome"));
		assertEquals("220.0", this.filmeTest.getInfo("Preco"));
	}

	/**
	 * Metodo que testa o comportamento de getInfo quando o atributo passado é
	 * nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testGetInfoAtributoNull() {
		this.filmeTest.getInfo(null);
	}

	/**
	 * Metodo que testa o comportamento de getInfo quando o atributo passado é
	 * vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAtributoVazio() {
		this.filmeTest.getInfo(" ");
	}

	/**
	 * Metodo que testa o comportamento de getInfo quando o atributo passado é
	 * Invalido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAtributoInvalido() {
		this.filmeTest.getInfo("naosouatributo");
	}

	/**
	 * Metodo que testa a corretude dos getters e setters de Item.
	 */
	@Test
	public void testGetsDeItem() {
		assertEquals("Kickass", filmeTest.getNome());
		assertEquals(220, filmeTest.getPreco(), 0.01);

		assertEquals("Kickass", filmeTest.getInfo("Nome"));
		assertEquals("220.0", filmeTest.getInfo("Preco"));
	}

	/**
	 * Metodo que testa a corretude do método atualizaAtributo() de Item.
	 */
	@Test
	public void testAtualizaAtributo() {
		this.filmeTest.atualizaAtributo("Preco", "10000.0");
		assertEquals(10000.0, this.filmeTest.getPreco(), 0.000005);
	}

	/**
	 * Metodo que testa o comportamento de atualizaAtributo() quando o valor
	 * passado é Invalido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaAtributoPrecoInvalido() {
		this.filmeTest.atualizaAtributo("Preco", "nao sou numero");
	}

	/**
	 * Metodo que testa o comportamento de atualizaAtributo() quando o valor
	 * passado é Invalido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaAtributoPrecoZero() {
		this.filmeTest.atualizaAtributo("Preco", "0");
	}
}
