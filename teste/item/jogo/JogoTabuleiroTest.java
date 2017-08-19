package item.jogo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Testa as funcionalidade da clase JogoTabuleiro
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class JogoTabuleiroTest {
	private JogoTabuleiro jogo;

	/**
	 * Apenas instancia o jogoTabuleiro.
	 */
	@Before
	public void criaJogoTabuleiro() {
		this.jogo = new JogoTabuleiro("xadrex", 333.66);
	}

	/**
	 * Testa um instanciamento normal de JogoTabuleiro.
	 */
	@Test
	public void testJogoTabuleiro() {
		assertEquals("xadrex", this.jogo.getNome());
		assertEquals(333.66, this.jogo.getPreco(), 0.0005);
		assertEquals("Nao emprestado", this.jogo.getEstadoEmprestimo());
		assertEquals(true, this.jogo.isCompleto());
	}

	/**
	 * Testa o equals de JogoTabuleiro, especificamente sem contar com peças
	 * perdidas.
	 */
	@Test
	public void testEqualsObjectPecasVazia() {
		JogoTabuleiro equalJogo = new JogoTabuleiro("xadrex", 100.00);
		JogoTabuleiro diffJogoN = new JogoTabuleiro("dama", 200.00);

		assertEquals(true, this.jogo.equals(equalJogo));
		assertEquals(false, this.jogo.equals(diffJogoN));
	}

	/**
	 * Testa o equals de JogoTabuleiro, dessa vez, contando com as peças perdidas.
	 */
	@Test
	public void testEqualsObjectPecas() {
		JogoTabuleiro equalJogo = new JogoTabuleiro("xadrex", 100.00);
		JogoTabuleiro diffJogoN = new JogoTabuleiro("dama", 200.00);
		JogoTabuleiro diffJogoP = new JogoTabuleiro("xadrex", 300.00);

		this.jogo.adicionarPecaPerdida("cavalo");
		this.jogo.adicionarPecaPerdida("torre");

		equalJogo.adicionarPecaPerdida("torre");
		equalJogo.adicionarPecaPerdida("cavalo");

		diffJogoN.adicionarPecaPerdida("cavalo");
		diffJogoN.adicionarPecaPerdida("torre");

		diffJogoP.adicionarPecaPerdida("cavalo");
		diffJogoP.adicionarPecaPerdida("rainha");

		assertEquals(true, this.jogo.equals(equalJogo));
		assertEquals(false, this.jogo.equals(diffJogoN));
		assertEquals(false, this.jogo.equals(diffJogoP));
	}

	/**
	 * Testa se está adicionando peças perdidas corretamente.
	 */
	@Test
	public void testAdicionarPecaPerdida() {
		this.jogo.adicionarPecaPerdida("cavalo");
		assertEquals(false, this.jogo.isCompleto());
	}

	/**
	 * Testa o ToString de um JogoTabuleiro.
	 */
	@Test
	public void testToString()
	{
		assertEquals("JOGO DE TABULEIRO: xadrex, R$ 333.66, Nao emprestado, COMPLETO", this.jogo.toString());
		this.jogo.adicionarPecaPerdida("cavalo");
		assertEquals("JOGO DE TABULEIRO: xadrex, R$ 333.66, Nao emprestado, COM PECAS PERDIDAS", this.jogo.toString());
	}

}
