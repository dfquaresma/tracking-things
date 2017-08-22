package usuario.fidelidade;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Testa a classe do cartão de fidelidade Noob.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class NoobTest {

	private CartaoFidelidade cartao;

	/**
	 * Prepara o ambiente de testes.
	 */
	@Before
	public void setup() {
		this.cartao = new Noob();
	}

	/**
	 * Testa o periodo maximo que o usuario da categoria pode pegar um item
	 * emprestado
	 */
	@Test
	public void testGetPeriodo() {
		assertEquals(7, cartao.getPeriodo());
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
		assertEquals("Noob", cartao.toString());
	}
}
