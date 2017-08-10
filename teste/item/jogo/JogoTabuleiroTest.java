package item.jogo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JogoTabuleiroTest
{
	private JogoTabuleiro jogo;
	
	@Before
	public void criaJogoTabuleiro()
	{
		this.jogo = new JogoTabuleiro("xadrex", 333.66);
	}

	@Test
	public void testJogoTabuleiro()
	{
		assertEquals("xadrex", this.jogo.getNome());
		assertEquals(333.66, this.jogo.getPreco(), 0.0005);
		assertEquals("Nao emprestado", this.jogo.getEstadoEmprestimo());
		assertEquals(true, this.jogo.isCompleto());
	}
	
	@Test
	public void testEqualsObjectPecasVazia()
	{
		JogoTabuleiro equalJogo = new JogoTabuleiro("xadrex", 100.00);
		JogoTabuleiro diffJogoN = new JogoTabuleiro("dama", 200.00);
		
		assertEquals(true, this.jogo.equals(equalJogo));
		assertEquals(false, this.jogo.equals(diffJogoN));
	}
	
	@Test
	public void testEqualsObjectPecas()
	{
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

	@Test
	public void testAdicionarPecaPerdida() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsCompleto() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
