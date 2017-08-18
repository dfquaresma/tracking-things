package util;

import org.junit.Before;
import org.junit.Test;

/**
 * Testa a classe de validação.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class ValidadorItemTest {

	private ValidadorItem validador;

	/**
	 * Prepara o ambiente para os testes.
	 */
	@Before
	public void criaValidador() {
		this.validador = new ValidadorItem();
	}

	/**
	 * Testa se a validação de valor não lança exceção quando o valor é válido.
	 */
	@Test
	public void testValidaValor() {
		this.validador.validaValor("Nome");
	}

	/**
	 * Metodo para testar se, quando o valor é passado como Null, uma excecao é
	 * lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testValidaValorNull() {
		this.validador.validaValor(null);
	}

	/**
	 * Metodo para testar se, quando o valor é passado como vazio, uma excecao é
	 * lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaValorInvalido() {
		this.validador.validaValor("       ");
	}

	/**
	 * Testa se quando o nome de item é válido, nenhuma exceção é lançada.
	 */
	@Test
	public void testValidaNomeItem() {
		this.validador.validaNomeItem("parafuso");
	}

	/**
	 * Metodo para testar se, quando o nome de item é passado como Null, uma
	 * excecao é lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testValidaNomeItemNull() {
		this.validador.validaNomeItem(null);
	}

	/**
	 * Metodo para testar se, quando o nome de item é passado como vazio, uma
	 * excecao é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaNomeItemInvalido() {
		this.validador.validaNomeItem("       ");
	}

	/**
	 * Testa se quando o nome de artista é válido, nenhuma exceção é lançada.
	 */
	@Test
	public void testValidaArtista() {
		this.validador.validaArtista("REBELDES");
	}

	/**
	 * Metodo para testar se, quando o nome de artista é passado como Null, uma
	 * excecao é lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testValidaArtistaNull() {
		this.validador.validaArtista(null);
	}

	/**
	 * Metodo para testar se, quando o nome de artista é passado como vazio, uma
	 * excecao é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaArtistaInvalido() {
		this.validador.validaArtista("       ");
	}

	/**
	 * Testa se quando a classificação é válida, nenhuma exceção é lançada.
	 */
	@Test
	public void testValidaClassificacao() {
		this.validador.validaClassificacao("LIVRE");
		this.validador.validaClassificacao("DEZ_ANOS");
		this.validador.validaClassificacao("DOZE_ANOS");
		this.validador.validaClassificacao("QUATORZE_ANOS");
		this.validador.validaClassificacao("DEZESSEIS_ANOS");
		this.validador.validaClassificacao("DEZOITO_ANOS");
	}

	/**
	 * Metodo para testar se, quando uma classificação é passada como Null, uma
	 * excecao é lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testValidaClassificacaoNull() {
		this.validador.validaClassificacao(null);
	}

	/**
	 * Metodo para testar se, quando uma classificação é passada como vazia, uma
	 * excecao é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaClassificacaoInvalido() {
		this.validador.validaClassificacao("       ");
	}

	/**
	 * Metodo para testar se, quando é passada uma classificação não válida, uma
	 * excecao é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaClassificacaoNotInside() {
		this.validador.validaClassificacao("livre");
	}

	/**
	 * Testa se quando a duração é válida, nenhuma exceção é lançada.
	 */
	@Test
	public void testValidaDuracao() {
		this.validador.validaDuracao(1);
	}

	/**
	 * Metodo para testar se, quando é passada uma duração não válida, uma
	 * excecao é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaDuracaoInvalida() {
		this.validador.validaDuracao(0); // upper bound of (-inf, 0]
	}

	/**
	 * Testa se quando o nome do blu-ray é válido, nenhuma exceção é lançada.
	 */
	@Test
	public void testValidaNomeBluray() {
		this.validador.validaNomeBluray("GoT");
	}

	/**
	 * Metodo para testar se, quando é passada um nome de blu-ray Null, uma
	 * excecao é lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testValidaNomeBlurayNull() {
		this.validador.validaNomeBluray(null);
	}

	/**
	 * Metodo para testar se, quando é passada um nome de blu-ray vazio, uma
	 * excecao é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaNomeBlurayInvalido() {
		this.validador.validaNomeBluray("       ");
	}

	/**
	 * Testa se quando o gênero é válido, nenhuma exceção é lançada.
	 */
	@Test
	public void testValidaGenero() {
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

	/**
	 * Metodo para testar se, quando é passada um gênero Null, uma excecao é
	 * lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testValidaGeneroNull() {
		this.validador.validaGenero(null);
	}

	/**
	 * Metodo para testar se, quando é passada um gênero vazio, uma excecao é
	 * lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaGeneroInvalido() {
		this.validador.validaGenero("       ");
	}

	/**
	 * Metodo para testar se, quando é passada um gênero inválido, uma excecao é
	 * lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaGeneroNotInside() {
		this.validador.validaGenero("any");
	}

	/**
	 * Testa se quando a temporada é válida, nenhuma exceção é lançada.
	 */
	@Test
	public void testValidaTemporada() {
		this.validador.validaTemporada(1);
	}

	/**
	 * Metodo para testar se, quando é passada uma temporada inválida, uma
	 * excecao é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaTemporadaInvalida() {
		this.validador.validaTemporada(0);
	}

	/**
	 * Testa se quando é passado uma plataforma válida, nenhuma exceção é
	 * lançada.
	 */
	@Test
	public void testValidaPlataforma() {
		this.validador.validaPlataforma("PC");
		this.validador.validaPlataforma("MAC");
		this.validador.validaPlataforma("PS3");
		this.validador.validaPlataforma("PS4");
		this.validador.validaPlataforma("XBOX360");
		this.validador.validaPlataforma("XBOX_ONE");
		this.validador.validaPlataforma("NINTENDO_3DS");
		this.validador.validaPlataforma("OUTRO");
	}

	/**
	 * Metodo para testar se, quando é passada uma plataforma Null, uma excecao
	 * é lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testValidaPlataformaNull() {
		this.validador.validaPlataforma(null);
	}

	/**
	 * Metodo para testar se, quando é passada uma plataforma vazio, uma excecao
	 * é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaPlataformaInvalido() {
		this.validador.validaPlataforma("       ");
	}

	/**
	 * Metodo para testar se, quando é passada uma plataforma inválida, uma
	 * excecao é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaPlataformaNotInside() {
		this.validador.validaPlataforma("any");
	}

	/**
	 * Testa se quando é passado uma ano de lançamento válido, nenhuma exceção é
	 * lançada.
	 */
	@Test
	public void testValidaAnoLancamento() {
		this.validador.validaAnoLancamento(1);
	}

	/**
	 * Metodo para testar se, quando é passado ano de lançamento inválido, uma
	 * excecao é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaAnoLancamentoInvalido() {
		this.validador.validaAnoLancamento(0);
	}

	/**
	 * Testa se quando é passado uma data válida, nenhuma exceção é lançada.
	 */
	@Test
	public void testValidaData() {
		this.validador.validaData("15/12/2016");
	}

	/**
	 * Metodo para testar se, quando é passado uma data Null, uma excecao é
	 * lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testValidaDataNull() {
		this.validador.validaData(null);
	}

	/**
	 * Metodo para testar se, quando é passado uma data vazio, uma excecao é
	 * lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaDataInvalido() {
		this.validador.validaData("       ");
	}

	/**
	 * Testa se, quando é passado um preço válido, nenhuma exceção é lançada.
	 */
	@Test
	public void testValidaPreco() {
		this.validador.validaPreco(1);
	}

	/**
	 * Metodo para testar se, quando é passado um preço inválido, uma excecao é
	 * lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaPrecoInvalido() {
		this.validador.validaPreco(-0.0001);
	}

	/**
	 * Testa se, quando é passado um período válido, nenhuma exceção é lançada.
	 */
	@Test
	public void testValidaPeriodo() {
		this.validador.validaPeriodo(1);
	}

	/**
	 * Metodo para testar se, quando é passado um período inválido, uma excecao
	 * é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaPeriodoInvalido() {
		this.validador.validaPeriodo(0);
	}

	/**
	 * Testa se, quando é passado uma descrição válida, nenhuma exceção é
	 * lançada.
	 */
	@Test
	public void testValidaDescricao() {
		this.validador.validaDescricao("Eu devo descrever alguma coisa aqui");
	}

	/**
	 * Metodo para testar se, quando é passado uma descrição Null, uma excecao é
	 * lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testValidaDescricaoNull() {
		this.validador.validaDescricao(null);
	}

	/**
	 * Metodo para testar se, quando é passado uma descrição vazia, uma excecao
	 * é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaDescricaoInvalido() {
		this.validador.validaDescricao("       ");
	}

	/**
	 * Teste se, quando é passado um número válido de faixas, nenhuma exceção é
	 * lançada.
	 */
	@Test
	public void testValidaNumeroDeFaixas() {
		this.validador.validaNumeroDeFaixas(1);
	}

	/**
	 * Metodo para testar se, quando é passado um número inválido de faixas, uma
	 * excecao é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaNumeroDeFaixasInvalido() {
		this.validador.validaNumeroDeFaixas(0);
	}

	/**
	 * Teste se, quando é passado um atributo válido, nenhuma exceção é lançada.
	 */
	@Test
	public void testValidaAtributo() {
		this.validador.validaAtributo("Nome");
	}

	/**
	 * Metodo para testar se, quando é passado um atributo Null, uma excecao é
	 * lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testValidaAtributoNull() {
		this.validador.validaAtributo(null);
	}

	/**
	 * Metodo para testar se, quando é passado um atributo vazio, uma excecao é
	 * lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaAtributoInvalido() {
		this.validador.validaAtributo("       ");
	}

	/**
	 * Teste se, quando é passado uma pela de tabuleiro válida, nenhuma exceção
	 * é lançada.
	 */
	@Test
	public void testValidaPeca() {
		this.validador.validaPeca("Cavalo");
	}

	/**
	 * Metodo para testar se, quando é passado uma peça de tabuleiro Null, uma
	 * excecao é lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testValidaPecaNull() {
		this.validador.validaPeca(null);
	}

	/**
	 * Metodo para testar se, quando é passado uma peça de tabuleiro vazia, uma
	 * excecao é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaPecaInvalido() {
		this.validador.validaPeca("       ");
	}
}
