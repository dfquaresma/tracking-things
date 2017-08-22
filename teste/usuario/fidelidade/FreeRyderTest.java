package usuario.fidelidade;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Testa a classe do cartão de fidelidade FreeRyder.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class FreeRyderTest {

	private CartaoFidelidade cartao;

	/**
	 * Prepara o ambiente de testes.
	 */
	@Before
	public void setup() {
		this.cartao = new FreeRyder();
	}

	/**
	 * Testa o periodo maximo que o usuario da categoria pode pegar um item
	 * emprestado
	 */
	@Test
	public void testGetPeriodo() {
		assertEquals(5, cartao.getPeriodo());
	}

	/**
	 * Testa se o usuario da categoria pode pegar itens emprestado
	 */
	@Test
	public void testPodePegarEmprestado() {
		assertTrue(cartao.podePegarEmprestado());
	}

	/**
	 * Testa a representacao string da categoria
	 */
	@Test
	public void testToString() {
		assertEquals("FreeRyder", cartao.toString());
	}

}
