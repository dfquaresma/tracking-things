package util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ValidadorTest {

	Validador validador;
	
	@Before
	public void criaValidador()
	{
		this.validador = new Validador();
	}
	
	@Test
	public void testValidaNome()
	{
		this.validador.validaNome("paulofelipe");
	}
	
	@Test(expected=NullPointerException.class)
	public void testValidaNomeNull()
	{
		this.validador.validaNome(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaNomeInvalido()
	{
		this.validador.validaNome("       ");
	}
	
	@Test
	public void testValidaTelefone()
	{
		this.validador.validaTelefone("chama no zap bb: 8398777777");
	}
	
	@Test(expected=NullPointerException.class)
	public void testValidaTelefoneNull()
	{
		this.validador.validaTelefone(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaTelefoneInvalido()
	{
		this.validador.validaTelefone("       ");
	}
	
	@Test
	public void testValidaEmail()
	{
		this.validador.validaEmail("paulopaulopaulo@gmail.com");
	}
	
	@Test(expected=NullPointerException.class)
	public void testValidaEmailNull()
	{
		this.validador.validaEmail(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaEmailInvalido()
	{
		this.validador.validaEmail("       ");
	}
	
	@Test
	public void testValidaValor()
	{
		this.validador.validaValor("Nome");
	}
	
	@Test(expected=NullPointerException.class)
	public void testValidaValorNull()
	{
		this.validador.validaValor(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaValorInvalido()
	{
		this.validador.validaValor("       ");
	}
	
	@Test
	public void testValidaNomeItem()
	{
		this.validador.validaNomeItem("parafuso");
	}
	
	@Test(expected=NullPointerException.class)
	public void testValidaNomeItemNull()
	{
		this.validador.validaNomeItem(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaNomeItemInvalido()
	{
		this.validador.validaNomeItem("       ");
	}
	
	@Test
	public void testValidaArtista()
	{
		this.validador.validaArtista("REBELDES");
	}
	
	@Test(expected=NullPointerException.class)
	public void testValidaArtistaNull()
	{
		this.validador.validaArtista(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaArtistaInvalido()
	{
		this.validador.validaArtista("       ");
	}
	
	@Test
	public void testValidaClassificacao()
	{
		this.validador.validaClassificacao("LIVRE");
		this.validador.validaClassificacao("DEZ_ANOS");
		this.validador.validaClassificacao("DOZE_ANOS");
		this.validador.validaClassificacao("QUATORZE_ANOS");
		this.validador.validaClassificacao("DEZESSEIS_ANOS");
		this.validador.validaClassificacao("DEZOITO_ANOS");
	}
	
	@Test(expected=NullPointerException.class)
	public void testValidaClassificacaoNull()
	{
		this.validador.validaClassificacao(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaClassificacaoInvalido()
	{
		this.validador.validaClassificacao("       ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaClassificacaoNotInside()
	{
		this.validador.validaClassificacao("livre");
	}

	@Test
	public void testValidaDuracao()
	{
		this.validador.validaDuracao(1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaDuracaoInvalida()
	{
		this.validador.validaDuracao(0);	//upper bound of (-inf, 0]
	}

	@Test
	public void testValidaNomeBluray()
	{
		this.validador.validaNomeBluray("GoT");
	}
	
	@Test(expected=NullPointerException.class)
	public void testValidaNomeBlurayNull()
	{
		this.validador.validaNomeBluray(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaNomeBlurayInvalido()
	{
		this.validador.validaNomeBluray("       ");
	}

	@Test
	public void testValidaGenero()
	{
		this.validador.validaGenero("DOCUMENTARIO");
		this.validador.validaGenero("DRAMA");
		this.validador.validaGenero("EROTICO");
		this.validador.validaGenero("FAROESTE");
		this.validador.validaGenero("FICCAO");
		this.validador.validaGenero("MUSICAL");
		this.validador.validaGenero("POLICIAL");
		this.validador.validaGenero("ROMANCE");
		this.validador.validaGenero("SUSPENSE");
		this.validador.validaGenero("TERROR");
		this.validador.validaGenero("OUTRO");
	}
	
	@Test(expected=NullPointerException.class)
	public void testValidaGeneroNull()
	{
		this.validador.validaGenero(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaGeneroInvalido()
	{
		this.validador.validaGenero("       ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaGeneroNotInside()
	{
		this.validador.validaGenero("livre");
	}

	@Test
	public void testValidaTemporada() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidaPlataforma() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidaAnoLancamento() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidaData() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidaPreco() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidaItensParaListagem() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidaPeriodo() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidaDescricao() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidaNumeroDeFaixas() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidaAtributo() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidaPeca() {
		fail("Not yet implemented");
	}

}
