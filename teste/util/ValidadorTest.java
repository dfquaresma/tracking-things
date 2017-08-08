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
	public void testValidaDuracao() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidaArtista() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidaClassificacao() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidaNomeBluray() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidaGenero() {
		fail("Not yet implemented");
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
