package util;

import item.Item;
import item.bluray.Temporada;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import excecoes.OperacaoNaoPermitidaNoMomentoExcecao;


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
		this.validador.validaGenero("ACAO");
		this.validador.validaGenero("ANIMACAO");
		this.validador.validaGenero("AVENTURA");
		this.validador.validaGenero("COMEDIA");
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
		this.validador.validaGenero("any");
	}

	@Test
	public void testValidaTemporada()
	{
		this.validador.validaTemporada(1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaTemporadaInvalida() {
		this.validador.validaTemporada(0);
	}

	@Test
	public void testValidaPlataforma()
	{
		this.validador.validaPlataforma("PC");
		this.validador.validaPlataforma("MAC");
		this.validador.validaPlataforma("PS3");
		this.validador.validaPlataforma("PS4");
		this.validador.validaPlataforma("XBOX360");
		this.validador.validaPlataforma("XBOX_ONE");
		this.validador.validaPlataforma("NINTENDO_3DS");
		this.validador.validaPlataforma("OUTRO");
	}
	
	@Test(expected=NullPointerException.class)
	public void testValidaPlataformaNull()
	{
		this.validador.validaPlataforma(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaPlataformaInvalido()
	{
		this.validador.validaPlataforma("       ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaPlataformaNotInside()
	{
		this.validador.validaPlataforma("any");
	}

	@Test
	public void testValidaAnoLancamento()
	{
		this.validador.validaAnoLancamento(1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaAnoLancamentoInvalido()
	{
		this.validador.validaAnoLancamento(0);
	}

	@Test
	public void testValidaData()
	{
		this.validador.validaData("15/12/2016");
	}
	
	@Test(expected=NullPointerException.class)
	public void testValidaDataNull()
	{
		this.validador.validaData(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaDataInvalido()
	{
		this.validador.validaData("       ");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testValidaPreco()
	{
		this.validador.validaPreco(0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaPrecoInvalido()
	{
		this.validador.validaPreco(-0.0001);
	}

	@Test
	public void testValidaItensParaListagem()
	{
		List<Item>itens = new ArrayList<Item>();
		itens.add(new Temporada("South Park", 1000.00, "Primeira temporada de South Park", 120, 
				"DEZOITO_ANOS", "COMEDIA", 1));
		this.validador.validaListaParaListagem(itens);
	}
	
	@Test(expected=OperacaoNaoPermitidaNoMomentoExcecao.class)
	public void testValidaItensParaListagemVazia()
	{
		List<Item>itens = new ArrayList<Item>();
		this.validador.validaListaParaListagem(itens);
	}
	
	@Test(expected=NullPointerException.class)
	public void testValidaItensParaListagemNull()
	{
		this.validador.validaListaParaListagem(null);
	}
	
	@Test(expected=NullPointerException.class)
	public void testValidaItensParaListagemItemNull()
	{
		List<Item>itens = new ArrayList<Item>();
		itens.add(null);
		this.validador.validaListaParaListagem(itens);
	}

	@Test
	public void testValidaPeriodo()
	{
		this.validador.validaPeriodo(1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaPeriodoInvalido()
	{
		this.validador.validaPeriodo(0);
	}

	@Test
	public void testValidaDescricao()
	{
		this.validador.validaDescricao("Eu devo descrever alguma coisa aqui");
	}
	
	@Test(expected=NullPointerException.class)
	public void testValidaDescricaoNull()
	{
		this.validador.validaDescricao(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaDescricaoInvalido()
	{
		this.validador.validaDescricao("       ");
	}

	@Test
	public void testValidaNumeroDeFaixas()
	{
		this.validador.validaNumeroDeFaixas(1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaNumeroDeFaixasInvalido()
	{
		this.validador.validaNumeroDeFaixas(0);
	}

	@Test
	public void testValidaAtributo()
	{
		this.validador.validaAtributo("Nome");
	}
	
	@Test(expected=NullPointerException.class)
	public void testValidaAtributoNull()
	{
		this.validador.validaAtributo(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaAtributoInvalido()
	{
		this.validador.validaAtributo("       ");
	}

	@Test
	public void testValidaPeca()
	{
		this.validador.validaPeca("Cavalo");
	}

	@Test(expected=NullPointerException.class)
	public void testValidaPecaNull()
	{
		this.validador.validaPeca(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaPecaInvalido()
	{
		this.validador.validaPeca("       ");
	}
}
