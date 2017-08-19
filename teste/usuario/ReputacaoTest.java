package usuario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReputacaoTest
{
	private Reputacao reputacao;
	
	@Before
	public void criaReputacao()
	{
		this.reputacao = new Reputacao();
	}
	@Test
	public void testReputacao()
	{
		assertEquals(0, this.reputacao.getReputacao(), 0.000005);
	}

	@Test
	public void testAdicionandoItemParaEmprestimo()
	{
		this.reputacao.adicionandoItemParaEmprestimo(100);
		assertEquals(5.00, this.reputacao.getReputacao(), 0.000005);
	}

	@Test
	public void testRemovendoItemParaEmprestimo()
	{
		this.reputacao.adicionandoItemParaEmprestimo(100);
		assertEquals(5.00, this.reputacao.getReputacao(), 0.000005);
		this.reputacao.removendoItemParaEmprestimo(100);
		assertEquals(0.00, this.reputacao.getReputacao(), 0.000005);
	}

	@Test
	public void testEmprestandoItem()
	{
		this.reputacao.emprestandoItem(200);
		assertEquals(20.00, this.reputacao.getReputacao(), 0.000005);
	}

	@Test
	public void testDevolvendo()
	{
		this.reputacao.devolvendoItem(300, 0);
		assertEquals(15.00, this.reputacao.getReputacao(), 0.000005);
		this.reputacao.devolvendoItem(1000, 10);
		assertEquals(-100.00 + 15.00, this.reputacao.getReputacao(), 0.000005);
		this.reputacao.devolvendoItem(300, -3);
		assertEquals(-100.00 + 15.00 + 15.00, this.reputacao.getReputacao(), 0.000005);
	}

}
