package usuario.fidelidade;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Testa a classe do cartão de fidelidade Caloteiro.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class CaloteiroTest {

	private Fidelidade cartao;

	/**
	 * Prepara o ambiente de testes.
	 */
	@Before
	public void setup() {
		this.cartao = new Caloteiro();
	}

	/**
	 * Testa o periodo maximo que o usuario da categoria pode pegar um item
	 * emprestado
	 */
	@Test
	public void testGetPeriodo() {
		assertEquals(0, cartao.getPeriodo());
	}

	/**
	 * Testa se o usuario da categoria pode pegar itens emprestado
	 */
	@Test
	public void testPodePegarEmprestado() {
		assertFalse(cartao.podePegarEmprestado());
	}

	/**
	 * Testa a representacao string da categoria
	 */
	@Test
	public void testToString() {
		assertEquals("Caloteiro", cartao.toString());
	}

}
