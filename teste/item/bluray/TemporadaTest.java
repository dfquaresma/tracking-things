package item.bluray;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import item.bluray.Temporada;

/**
 * Testa as funcionalidades da classe Temporada
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class TemporadaTest {

	private Temporada temporada;

	/**
	 * Prepara o ambiente para testes.
	 */
	@Before
	public void criaTemporada() {
		this.temporada = new Temporada("South park", 1000.10, "Primeira temporada de South park", 1000, "DEZOITO_ANOS",
				"COMEDIA", 1);
	}

	/**
	 * Testa pegar informacoes de uma temporada
	 */
	@Test
	public void testTemporada() {
		assertEquals("South park", this.temporada.getNome());
		assertEquals(1000.10, this.temporada.getPreco(), 0.0005);
		assertEquals("Primeira temporada de South park", this.temporada.getDescricao());
		assertEquals(1000, this.temporada.getDuracao());
		assertEquals("DEZOITO_ANOS", this.temporada.getClassificacao());
		assertEquals("COMEDIA", this.temporada.getGenero());
		assertEquals(1, this.temporada.getTemporada());
	}

	/**
	 * Testa instanciar uma temporada com valor invalido
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTemporadaValorInvalido() {
		new Temporada("South park", -0.0001, "Primeira temporada de South park", 1000, "DEZOITO_ANOS", "COMEDIA", 1);
	}

	/**
	 * Testa instanciar uma temporada com duracao invalida
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTemporadaDuracaoInvalida() {
		new Temporada("South park", 1000.10, "Primeira temporada de South park", 0, "DEZOITO_ANOS", "COMEDIA", 1);
	}

	/**
	 * Testa instanciar uma temporada com classificacao vazia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTemporadaClassificacaoInvalida() {
		new Temporada("South park", 1000.10, "Primeira temporada de South park", 1000, "dezoito anos", "COMEDIA", 1);
	}

	/**
	 * Testa instanciar uma temporada com genero invalido
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTemporadaGeneroInvalido() {
		new Temporada("South park", 1000.10, "Primeira temporada de South park", 1000, "DEZOITO_ANOS", "comedia", 1);
	}

	/**
	 * Testa instanciar uma temporada com um numero de temporada invalido
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTemporadaTemporadaInvalida() {
		new Temporada("South park", 1000.10, "Primeira temporada de South park", 1000, "DEZOITO_ANOS", "COMEDIA", 0);
	}

	/**
	 * Testa instanciar uma temporada com nome vazio
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTemporadaNomeVazia() {
		new Temporada("   ", 1000.10, "Primeira temporada de South park", 1000, "DEZOITO_ANOS", "COMEDIA", 1);
	}

	/**
	 * Testa instanciar uma temporada com descricao vazia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTemporadaDescricaoVazia() {
		new Temporada("South park", 1000.10, "     ", 1000, "DEZOITO_ANOS", "COMEDIA", 1);
	}

	/**
	 * Testa instanciar uma temporada com classificacao vazia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTemporadaClassificacaoVazia() {
		new Temporada("South park", 1000.10, "Primeira temporada de South park", 1000, "     ", "COMEDIA", 1);
	}

	/**
	 * Testa instanciar uma temporada com genero vazio
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTemporadaGeneroVazio() {
		new Temporada("South park", 1000.10, "Primeira temporada de South park", 1000, "DEZOITO_ANOS", "    ", 1);
	}

	/**
	 * Testa instanciar uma temporada com nome nulo
	 */
	@Test(expected = NullPointerException.class)
	public void testTemporadaNomeNull() {
		new Temporada(null, 1000.10, "Primeira temporada de South park", 1000, "DEZOITO_ANOS", "COMEDIA", 1);
	}

	/**
	 * Testa instanciar uma temporada com descricao nula
	 */
	@Test(expected = NullPointerException.class)
	public void testTemporadaDescricaoNull() {
		new Temporada("South park", 1000.10, null, 1000, "DEZOITO_ANOS", "COMEDIA", 1);
	}

	/**
	 * Testa instanciar uma temporada com classificacao nula
	 */
	@Test(expected = NullPointerException.class)
	public void testTemporadaClassificacaoNull() {
		new Temporada("South park", 1000.10, "Primeira temporada de South park", 1000, null, "COMEDIA", 1);
	}
	
	/**
	 * Testa se uma temporada pode ser emprestada
	 */
	@Test
	public void testPodeSerEmprestado() {
		assertEquals(false, this.temporada.podeSerEmprestado());
		this.temporada.addBlueray(500);
		this.temporada.addBlueray(500);
		assertEquals(true, this.temporada.podeSerEmprestado());
		this.temporada.setEmprestado(true);
		assertEquals(false, this.temporada.podeSerEmprestado());
	}
	
	@Test
	public void testAtualizaAtributo()
	{
		this.temporada.atualizaAtributo("Descricao", "temporada legal");
		assertEquals("temporada legal", this.temporada.getDescricao());
		this.temporada.atualizaAtributo("Genero", "EROTICO");
		assertEquals("EROTICO", this.temporada.getGenero());
		this.temporada.atualizaAtributo("Temporada", "3");
		assertEquals(3, this.temporada.getTemporada());
		this.temporada.atualizaAtributo("Duracao", "30");
		assertEquals(30, this.temporada.getDuracao());
	}
	
	@Test
	public void testGetInfo()
	{
		assertEquals("Primeira temporada de South park", this.temporada.getInfo("Descricao"));
		assertEquals("COMEDIA", this.temporada.getInfo("Genero"));
		assertEquals("1", this.temporada.getInfo("Temporada"));
	}

	/**
	 * Testa instanciar uma temporada com genero nulo
	 */
	@Test(expected = NullPointerException.class)
	public void testTemporadaGeneroNull() {
		new Temporada("South park", 1000.10, "Primeira temporada de South park", 1000, "DEZOITO_ANOS", null, 1);
	}
	
	@Test
	public void testSetDescricao()
	{
		this.temporada.setDescricao("Essa temporada eh muito legal");
		assertEquals("Essa temporada eh muito legal", this.temporada.getDescricao());
	}
	
	@Test
	public void testSetGenero()
	{
		this.temporada.setGenero("FAROESTE");
		assertEquals("FAROESTE", this.temporada.getGenero());
	}
	
	@Test
	public void testSetTemporada()
	{
		this.temporada.setTemporada(20);
		assertEquals(20, this.temporada.getTemporada());
	}
	
	@Test
	public void testToString()
	{
		//new Temporada("South park", 1000.10, "Primeira temporada de South park", 1000, "DEZOITO_ANOS",
				//"COMEDIA", 1);
		assertEquals("SERIE: South park, R$ 1000.1, Nao emprestado, 1000 min, DEZOITO_ANOS, COMEDIA, Temporada 1", this.temporada.toString());
	}
}
