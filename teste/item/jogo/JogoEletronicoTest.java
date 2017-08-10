package item.jogo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.Validador;

public class JogoEletronicoTest
{
	private JogoEletronico jogo;
	
	@Before
	public void criaJogoEletronico()
	{
		this.jogo = new JogoEletronico("Super Mario", 1500.00, "PC");
	}
	
	@Test
	public void testJogoEletronico()
	{
		assertEquals("Super Mario", this.jogo.getNome());
		assertEquals(1500.00, this.jogo.getPreco(), 0.0005);
		assertEquals("Nao emprestado", this.jogo.getEstadoEmprestimo());
	}
	
	@Test(expected=NullPointerException.class)
	public void testJogoEletronicoNomeNull()
	{
		new JogoEletronico(null, 1500.00, "PC");
	}
	
	@Test(expected=NullPointerException.class)
	public void testJogoEletronicoPlataformaNull()
	{
		new JogoEletronico("Super Mario", 1500.00, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testJogoEletronicoNomeInvalido()
	{
		new JogoEletronico("    ", 1500.00, "PC");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testJogoEletronicoPrecoInvalido()
	{
		new JogoEletronico("Super Mario", -0.0001, "PC");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testJogoEletronicoPlataformaInvalida()
	{
		new JogoEletronico("Super Mario", 1500.00, "   ");
	}
	
	/**
	 * Metodo que testa a criacao de um jogo quando a plataforma eh uma string valida, porem, 
	 * nao pertence ao conjunto de plataformas cadastrada no sistema
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testJogoEletronicoPlataformaNotInside()
	{
		new JogoEletronico("Super Mario", 1500.00, "pc");
	}
	
	@Test
	public void testGetPlataforma()
	{
		assertEquals("PC", this.jogo.getPlataforma());
	}
	
	@Test
	public void testSetPlataforma()
	{
		this.jogo.setPlataforma("NINTENDO_3DS");
		assertEquals("NINTENDO_3DS", this.jogo.getPlataforma());
		
		this.jogo.setPlataforma("MAC");
		assertEquals("MAC", this.jogo.getPlataforma());
		
		this.jogo.setPlataforma("PS3");
		assertEquals("PS3", this.jogo.getPlataforma());
		
		this.jogo.setPlataforma("PS4");
		assertEquals("PS4", this.jogo.getPlataforma());
		
		this.jogo.setPlataforma("XBOX360");
		assertEquals("XBOX360", this.jogo.getPlataforma());
		
		this.jogo.setPlataforma("XBOX_ONE");
		assertEquals("XBOX_ONE", this.jogo.getPlataforma());
		
		this.jogo.setPlataforma("OUTRO");
		assertEquals("OUTRO", this.jogo.getPlataforma());
	}
	
	@Test(expected=NullPointerException.class)
	public void testSetPlataformaNull()
	{
		this.jogo.setPlataforma(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetPlataformaVazia()
	{
		this.jogo.setPlataforma("    ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetPlataformaInvalida()
	{
		this.jogo.setPlataforma("naosouumaplataforma");
	}

	@Test
	public void testGetInfo()
	{
		assertEquals("PC", this.jogo.getInfo("Plataforma"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testGetInfoNull()
	{
		this.jogo.getInfo(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoVazio()
	{
		this.jogo.getInfo("  ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoInvalida()
	{
		this.jogo.getInfo("plataforma");
	}
	
	@Test
	public void testToString()
	{
		assertEquals("JOGO ELETRONICO: Super Mario, R$ 1500.0, Nao emprestado, PC", this.jogo.toString());
	}

	@Test
	public void testAtualizaAtributo()
	{
		this.jogo.atualizaAtributo("Plataforma", "OUTRO");
		assertEquals("OUTRO", this.jogo.getPlataforma());
	}
	
	@Test(expected=NullPointerException.class)
	public void testAtualizaAtributoNull()
	{
		this.jogo.atualizaAtributo(null, "OUTRO");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaAtributoVazio()
	{
		this.jogo.atualizaAtributo("  ", "OUTRO");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaAtributoInvalido()
	{
		this.jogo.atualizaAtributo("plataforma", "OUTRO");
	}
	
	@Test(expected=NullPointerException.class)
	public void testAtualizaAtributoValorNull()
	{
		this.jogo.atualizaAtributo("Plataforma", null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaAtributoValorVazio()
	{
		this.jogo.atualizaAtributo("Plataforma", "   ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaAtributoValorInvalido()
	{
		this.jogo.atualizaAtributo("Plataforma", "outro");
	}
	
	@Test
	public void testEquals()
	{
		JogoEletronico equalJogo = new JogoEletronico("Super Mario", 100.0, "PC");
		JogoEletronico diffJogoN = new JogoEletronico("Mario", 200.00, "PC");
		JogoEletronico diffJogoP = new JogoEletronico("Super Mario", 300.00, "OUTRO");
		
		assertEquals(true, this.jogo.equals(equalJogo));
		assertEquals(false, this.jogo.equals(diffJogoP));
		assertEquals(false, this.jogo.equals(diffJogoN));
		assertEquals(true, this.jogo.equals(this.jogo));
		assertEquals(false, this.jogo.equals(null));
		assertEquals(false, this.jogo.equals(new Validador()));
	}
}
