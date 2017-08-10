package item.bluray;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BluRayTest
{
	private BluRay blurayTemp;
	private BluRay blurayFilme;
	private BluRay blurayShow;
	
	@Before
	public void criaBluray()
	{
		this.blurayTemp = new Temporada("South Park", 1000.00, "Primeira temporada de South Park", 120, 
				"DEZOITO_ANOS", "COMEDIA", 1);
		this.blurayFilme = new Filme("Lagoa Azul", 100.00, 60, "COMEDIA", "DEZ_ANOS", 1900);
		this.blurayShow = new Show("Que Show", 10.50, 90, 10, "eu sou artista", "LIVRE");
	}
	
	@Test
	public void testGetInfo()
	{
		assertEquals("120", this.blurayTemp.getInfo("Duracao"));
		assertEquals("60", this.blurayFilme.getInfo("Duracao"));
		assertEquals("90", this.blurayShow.getInfo("Duracao"));
		
		assertEquals("DEZOITO_ANOS", this.blurayTemp.getInfo("Classificacao"));
		assertEquals("DEZ_ANOS", this.blurayFilme.getInfo("Classificacao"));
		assertEquals("LIVRE", this.blurayShow.getInfo("Classificacao"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testGetInfoNull()
	{
		this.blurayTemp.getInfo(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoInvalida()
	{
		this.blurayTemp.getInfo("   ");
	}

	@Test
	public void testAtualizaAtributo()
	{
		this.blurayFilme.atualizaAtributo("Duracao", "1000");
		assertEquals(1000, this.blurayFilme.getDuracao());
		this.blurayFilme.atualizaAtributo("Classificacao", "QUATORZE_ANOS");
		assertEquals("QUATORZE_ANOS", this.blurayFilme.getClassificacao());
	}
	
	@Test(expected=NullPointerException.class)
	public void testAtualizaAtributoNull()
	{
		this.blurayFilme.atualizaAtributo(null, "1000");
	}
	
	@Test(expected=NullPointerException.class)
	public void testAtualizaAtributoValorNull()
	{
		this.blurayFilme.atualizaAtributo("Duracao", null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaAtributoInvalido()
	{
		this.blurayFilme.atualizaAtributo("   ", "1000");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaAtributoValorInvalido()
	{
		this.blurayFilme.atualizaAtributo("Duracao", "  ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaAtributoValorDuracaoNaoInteiro()
	{
		this.blurayFilme.atualizaAtributo("Duracao", "naosouinteiro");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaAtributoValorDuracaoInvalida()
	{
		this.blurayFilme.atualizaAtributo("Duracao", "0");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaAtributoValorClassificacaoInvalida()
	{
		this.blurayFilme.atualizaAtributo("Classificacao", "naosouclassificacao");
	}

	@Test
	public void testSetDuracao()
	{
		this.blurayShow.setDuracao(300);
		assertEquals(300, this.blurayShow.getDuracao());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetDuracaoInvalida()
	{
		this.blurayShow.setDuracao(0);
	}

	@Test
	public void testSetClassificacao()
	{
		this.blurayShow.setClassificacao("DEZESSEIS_ANOS");
		assertEquals("DEZESSEIS_ANOS", this.blurayShow.getClassificacao());
	}

	@Test(expected=NullPointerException.class)
	public void testSetClassificacaoNull()
	{
		this.blurayShow.setClassificacao(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetClassificacaoInvalida()
	{
		this.blurayShow.setClassificacao("  ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetClassificacaoNotInside()
	{
		this.blurayShow.setClassificacao("naosouclassificacao");
	}
}
