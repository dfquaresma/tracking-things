package item.bluray;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class FilmeTest {

	private Filme filmeTest;
	
	@Before
	public void setUp() {
		this.filmeTest = new Filme("Senhor dos anéis", 220, 150, "ACAO", "DEZ_ANOS", 2002);
	}
	
	@Test(expected=NullPointerException.class)
	public void testFilmeNomeNull()
	{
		new Filme(null, 220, 150, "ACAO", "DEZ_ANOS", 2002);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFilmeNomeVazio()
	{
		new Filme(" ", 220, 150, "ACAO", "DEZ_ANOS", 2002);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFilmeValorInvalido()
	{
		new Filme("Senhor dos anéis", -0.0001, 150, "ACAO", "DEZ_ANOS", 2002);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFilmeDuracaoInvalida()
	{
		new Filme("Senhor dos anéis", 220, 0, "ACAO", "DEZ_ANOS", 2002);
	}
	
	@Test(expected=NullPointerException.class)
	public void testFilmeGeneroNull()
	{
		new Filme("Senhor dos anéis", 220, 150, null, "DEZ_ANOS", 2002);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFilmeGeneroVazio()
	{
		new Filme("Senhor dos anéis", 220, 150, " ", "DEZ_ANOS", 2002);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFilmeGeneroInvalido()
	{
		new Filme("Senhor dos anéis", 220, 150, "acao", "DEZ_ANOS", 2002);
	}
	
	@Test(expected=NullPointerException.class)
	public void testFilmeClassificacaoNull()
	{
		new Filme("Senhor dos anéis", 220, 150, "ACAO", null, 2002);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFilmeClassificacaoVazia()
	{
		new Filme("Senhor dos anéis", 220, 150, "ACAO", " ", 2002);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFilmeClassificacaoInvalida()
	{
		new Filme("Senhor dos anéis", 220, 150, "ACAO", "quinze_", 2002);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFilmeAnoLancamentoInvalido()
	{
		new Filme("Senhor dos anéis", 220, 150, "ACAO", "DEZ_ANOS", 0);
	}
	
	@Test
	public void testSetGenero()
	{
		try {
			filmeTest.setGenero(null);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Genero nao pode ser nulo", npe.getMessage());
		}
		try {
			filmeTest.setGenero("");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Genero nao pode ser vazio", iae.getMessage());
		}
		try {
			filmeTest.setGenero("ZERO_ANOS");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Genero inválido", iae.getMessage());
		}
		filmeTest.setGenero("DRAMA");
		assertEquals("DRAMA", filmeTest.getGenero());
		
	}
	
	@Test
	public void testSetAnoLancamento()
	{
		try {
			filmeTest.setAnoDeLancamento(0);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Ano nao pode ser menor ou igual a zero.", iae.getMessage());
		}
		filmeTest.setAnoDeLancamento(10);
		assertEquals(10, filmeTest.getAnoDeLancamento());
		
	}
	
	//new Filme("Senhor dos anéis", 220, 150, "ACAO", "DEZ_ANOS", 2002);
	
	@Test
	public void testGetInfo()
	{
		assertEquals("ACAO", this.filmeTest.getInfo("Genero"));
		assertEquals("2002", this.filmeTest.getInfo("Lancamento"));
		assertEquals("Senhor dos anéis", this.filmeTest.getInfo("Nome"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testGetInfoAtributoNull()
	{
		this.filmeTest.getInfo(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAtributoVazio()
	{
		this.filmeTest.getInfo("  ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAtributoInvalido()
	{
		this.filmeTest.getInfo("naosouumatributo");
	}
	
	@Test
	public void testToString()
	{
		assertEquals("FILME: Senhor dos anéis, R$ 220.0, Nao emprestado, 150 min, DEZ_ANOS, ACAO, 2002", filmeTest.toString());
	}
	
	@Test
	public void testGetsEspecificos() {

		assertEquals("Senhor dos anéis", filmeTest.getNome());
		assertEquals(220, filmeTest.getPreco(), 0.01);
		assertEquals(150, filmeTest.getDuracao());
		assertEquals("DEZ_ANOS", filmeTest.getClassificacao());

		assertEquals("Senhor dos anéis", filmeTest.getInfo("Nome"));
		assertEquals("DEZ_ANOS", filmeTest.getInfo("Classificacao"));
	}

	@Test
	public void testAtualizaAtributo()
	{
		this.filmeTest.atualizaAtributo("Genero", "COMEDIA");
		assertEquals("COMEDIA", this.filmeTest.getGenero());
		this.filmeTest.atualizaAtributo("Ano de Lancamento", "2010");
		assertEquals(2010, this.filmeTest.getAnoDeLancamento());
		this.filmeTest.atualizaAtributo("Duracao", "150");
		assertEquals(150, this.filmeTest.getDuracao());
	}
	
	@Test(expected=NullPointerException.class)
	public void testAtualizaAtributoNull()
	{
		this.filmeTest.atualizaAtributo(null, "COMEDIA");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaAtributoVazio()
	{
		this.filmeTest.atualizaAtributo(" ", "COMEDIA");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaAtributoInvalido()
	{
		this.filmeTest.atualizaAtributo("naosouatributo", "COMEDIA");
	}
	
	@Test(expected=NullPointerException.class)
	public void testAtualizaValorNull()
	{
		this.filmeTest.atualizaAtributo("Genero", null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaValorVazio()
	{
		this.filmeTest.atualizaAtributo("Ano de Lancamento", " ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaAnoLancamentoNaoInt()
	{
		this.filmeTest.atualizaAtributo("Ano de Lancamento", "doismiledois");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaAtributoGeneroInvalido()
	{
		this.filmeTest.atualizaAtributo("Genero", "naosoudotipogenero");
	}

}
