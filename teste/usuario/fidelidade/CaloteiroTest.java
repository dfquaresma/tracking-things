package usuario.fidelidade;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CaloteiroTest {

private CartaoFidelidade cartao;
	
	@Before
	public void setup(){
		this.cartao = new Caloteiro();
	}
	/**
	 * Testa o periodo maximo que o usuario da categoria pode pegar um item emprestado
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
