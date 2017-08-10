package item.bluray;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import item.bluray.Temporada;

public class TemporadaTest {

	private Temporada temporada;
	
	@Before
	public void criaTemporada()
	{
		this.temporada = new Temporada("South park", 1000.10, "Primeira temporada de South park", 1000, "DEZOITO_ANOS", "COMEDIA", 1);
	}
	
	
	
	@Test
	public void testPodeSerEmprestado()
	{
		assertEquals(false, this.temporada.podeSerEmprestado());
		this.temporada.addBlueray(500);
		this.temporada.addBlueray(500);
		assertEquals(true, this.temporada.podeSerEmprestado());
	}
	
	
	
	@Test
	public void testTemporada()
	{
		assertEquals("South park", this.temporada.getNome());
		assertEquals(1000.10, this.temporada.getPreco(), 0.0005);
		assertEquals("Primeira temporada de South park", this.temporada.getDescricao());
		assertEquals(1000, this.temporada.getDuracao());
		assertEquals("DEZOITO_ANOS", this.temporada.getClassificacao());
		assertEquals("COMEDIA", this.temporada.getGenero());
		assertEquals(1, this.temporada.getTemporada());
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTemporadaValorInvalido()
	{
		new Temporada("South park", -0.0001, "Primeira temporada de South park", 1000, "DEZOITO_ANOS", "COMEDIA", 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTemporadaDuracaoInvalida()
	{
		new Temporada("South park", 1000.10, "Primeira temporada de South park", 0, "DEZOITO_ANOS", "COMEDIA", 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTemporadaClassificacaoInvalida()
	{
		new Temporada("South park", 1000.10, "Primeira temporada de South park", 1000, "dezoito anos", "COMEDIA", 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTemporadaGeneroInvalido()
	{
		new Temporada("South park", 1000.10, "Primeira temporada de South park", 1000, "DEZOITO_ANOS", "comedia", 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTemporadaTemporadaInvalida()
	{
		new Temporada("South park", 1000.10, "Primeira temporada de South park", 1000, "DEZOITO_ANOS", "COMEDIA", 0);
	}
	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTemporadaNomeVazia()
	{
		new Temporada("   ", 1000.10, "Primeira temporada de South park", 1000, "DEZOITO_ANOS", "COMEDIA", 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTemporadaDescricaoVazia()
	{
		new Temporada("South park", 1000.10, "     ", 1000, "DEZOITO_ANOS", "COMEDIA", 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTemporadaClassificacaoVazia()
	{
		new Temporada("South park", 1000.10, "Primeira temporada de South park", 1000, "     ", "COMEDIA", 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTemporadaGeneroVazio()
	{
		new Temporada("South park", 1000.10, "Primeira temporada de South park", 1000, "DEZOITO_ANOS", "    ", 1);
	}

	
	
	@Test(expected=NullPointerException.class)
	public void testTemporadaNomeNull()
	{
		new Temporada(null, 1000.10, "Primeira temporada de South park", 1000, "DEZOITO_ANOS", "COMEDIA", 1);
	}
	
	@Test(expected=NullPointerException.class)
	public void testTemporadaDescricaoNull()
	{
		new Temporada("South park", 1000.10, null, 1000, "DEZOITO_ANOS", "COMEDIA", 1);
	}
	
	@Test(expected=NullPointerException.class)
	public void testTemporadaClassificacaoNull()
	{
		new Temporada("South park", 1000.10, "Primeira temporada de South park", 1000, null, "COMEDIA", 1);
	}
	
	@Test(expected=NullPointerException.class)
	public void testTemporadaGeneroNull()
	{
		new Temporada("South park", 1000.10, "Primeira temporada de South park", 1000, "DEZOITO_ANOS", null, 1);
	}
	
	
}
