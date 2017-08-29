package persistencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import excecoes.OperacaoNaoPermitidaNoMomentoExcecao;

/**
 * Testa os métodos da classe Capsula.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class CapsulaTest {

	private Capsula capsula;
	private String ob1;

	/**
	 * Prepara o ambiente para os testes.
	 */
	@Before
	public void setUp() {
		this.capsula = new Capsula();
		this.ob1 = "Ob1";
		this.capsula.addObjeto(this.ob1);
	}

	/**
	 * Testa se o método addObjeto() funciona como esperado e se lança exceção
	 * sempre que necessário.
	 */
	@Test
	public void testAddObjeto() {

		try {
			this.capsula.addObjeto(null);
			fail();
		} catch (NullPointerException e) {
			assertEquals("Objeto nao pode ser nulo.", e.getMessage());
		}

		try {
			this.capsula.addObjeto("Ob2");
		} catch (Exception e) {
			fail();
		}

	}

	/**
	 * Testa se o método getObjeto() funciona como esperado e se lança exceção
	 * sempre que necessário.
	 */
	@Test
	public void testGetObject() {

		assertEquals(this.ob1, this.capsula.getObjeto());

		testaExcecao();

		for (int i = 1; i <= 10; i++) {
			this.capsula.addObjeto("Ob" + i);
		}

		for (int i = 1; i <= 10; i++) {
			assertEquals("Ob" + i, this.capsula.getObjeto());
		}

		testaExcecao();
		testaExcecao();

	}

	private void testaExcecao() {
		try {
			this.capsula.getObjeto();
			fail();
		} catch (OperacaoNaoPermitidaNoMomentoExcecao e) {
			assertEquals("Nao ha mais objetos a serem desencapsulados.", e.getMessage());
		}
	}

	/**
	 * Testa se o metodo qtdObjetosContidos funciona como esperado.
	 */
	@Test
	public void testQtdObjetosContidos() {
		assertEquals(1, this.capsula.qtdObjetosContidos());

		this.capsula.addObjeto("ob2");
		this.capsula.addObjeto("ob2");
		assertEquals(3, this.capsula.qtdObjetosContidos());

		this.capsula.getObjeto();
		assertEquals(2, this.capsula.qtdObjetosContidos());

		this.capsula.getObjeto();
		this.capsula.getObjeto();
		assertEquals(0, this.capsula.qtdObjetosContidos());

	}

}
