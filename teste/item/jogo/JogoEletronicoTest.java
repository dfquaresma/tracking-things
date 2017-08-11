package item.jogo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.Validador;

/**
 * Testa os métodos da classe Jogo Eletrônico.
 * 
 * @author David Ferreira
 *
 */
public class JogoEletronicoTest {
	private JogoEletronico jogo;

	/**
	 * Prepara o ambiente para os testes.
	 */
	@Before
	public void criaJogoEletronico() {
		this.jogo = new JogoEletronico("Super Mario", 1500.00, "PC");
	}

	/**
	 * Testa os métodos getters da classe.
	 */
	@Test
	public void testJogoEletronico() {
		assertEquals("Super Mario", this.jogo.getNome());
		assertEquals(1500.00, this.jogo.getPreco(), 0.0005);
		assertEquals("Nao emprestado", this.jogo.getEstadoEmprestimo());
	}

	/**
	 * Metodo para testar se, quando o nome é passado como Null, uma excecao é
	 * lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testJogoEletronicoNomeNull() {
		new JogoEletronico(null, 1500.00, "PC");
	}

	/**
	 * Metodo para testar se, quando a plataforma é passada como Null, uma
	 * excecao é lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testJogoEletronicoPlataformaNull() {
		new JogoEletronico("Super Mario", 1500.00, null);
	}

	/**
	 * Metodo para testar se, quando o nome é passado como vazio, uma excecao é
	 * lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testJogoEletronicoNomeInvalido() {
		new JogoEletronico("    ", 1500.00, "PC");
	}

	/**
	 * Metodo para testar se, quando o preço é passado menor que zero, uma
	 * excecao é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testJogoEletronicoPrecoInvalido() {
		new JogoEletronico("Super Mario", -0.0001, "PC");
	}

	/**
	 * Metodo para testar se, quando a plataforma é passado como vazia, uma
	 * excecao é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testJogoEletronicoPlataformaInvalida() {
		new JogoEletronico("Super Mario", 1500.00, "   ");
	}

	/**
	 * Metodo que testa a criacao de um jogo quando a plataforma é uma string
	 * valida, porem, não pertence ao conjunto de plataformas cadastrada no
	 * sistema
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testJogoEletronicoPlataformaNotInside() {
		new JogoEletronico("Super Mario", 1500.00, "pc");
	}

	/**
	 * Testa se o getter retorna valores esperados.
	 */
	@Test
	public void testGetPlataforma() {
		assertEquals("PC", this.jogo.getPlataforma());
	}

	/**
	 * Testa se ao utilizar valores válidos, os setters não lançam exceção e se
	 * modificam corretamente os atributos a que se responsabilizam em
	 * atualizar.
	 */
	@Test
	public void testSetPlataforma() {
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

	/**
	 * Metodo para testar se, quando a plataforma é passada como Null, uma
	 * excecao é lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testSetPlataformaNull() {
		this.jogo.setPlataforma(null);
	}

	/**
	 * Metodo para testar se, quando a plataforma é passada como vazia, uma
	 * excecao é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetPlataformaVazia() {
		this.jogo.setPlataforma("    ");
	}

	/**
	 * Metodo para testar se, quando é passada uma plataforma inválida, uma
	 * excecao é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetPlataformaInvalida() {
		this.jogo.setPlataforma("naosouumaplataforma");
	}

	/**
	 * Testa se getInfo recupera o valor esperado.
	 */
	@Test
	public void testGetInfo() {
		assertEquals("PC", this.jogo.getInfo("Plataforma"));
	}

	/**
	 * Metodo para testar se, quando é passado um atributo Null, uma excecao é
	 * lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testGetInfoNull() {
		this.jogo.getInfo(null);
	}

	/**
	 * Metodo para testar se, quando é passado um atributo vazio, uma excecao é
	 * lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoVazio() {
		this.jogo.getInfo("  ");
	}

	/**
	 * Metodo para testar se, quando é passado um atributo inválido (por não
	 * está na formatação esperada), uma excecao é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoInvalida() {
		this.jogo.getInfo("plataforma");
	}

	/**
	 * Verifica se o toString recupera uma representação em string no formato
	 * desejado.
	 */
	@Test
	public void testToString() {
		assertEquals("JOGO ELETRONICO: Super Mario, R$ 1500.0, Nao emprestado, PC", this.jogo.toString());
	}

	/**
	 * Testa se ao atualizar um atributo a partir de valores válidos, a
	 * atualização do atributo acontece corretamente.
	 */
	@Test
	public void testAtualizaAtributo() {
		this.jogo.atualizaAtributo("Plataforma", "OUTRO");
		assertEquals("OUTRO", this.jogo.getPlataforma());
	}

	/**
	 * Metodo para testar se, quando é passado um atributo Null, uma excecao é
	 * lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testAtualizaAtributoNull() {
		this.jogo.atualizaAtributo(null, "OUTRO");
	}

	/**
	 * Metodo para testar se, quando é passado um atributo vazio, uma excecao é
	 * lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaAtributoVazio() {
		this.jogo.atualizaAtributo("  ", "OUTRO");
	}

	/**
	 * Metodo para testar se, quando é passado um atributo inválido (Por não
	 * estar na formatação esperada), uma excecao é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaAtributoInvalido() {
		this.jogo.atualizaAtributo("plataforma", "OUTRO");
	}

	/**
	 * Metodo para testar se, quando é passado um atributo válido, uma excecao é
	 * lancada devido o valor para atualização do atributo ser Null.
	 */
	@Test(expected = NullPointerException.class)
	public void testAtualizaAtributoValorNull() {
		this.jogo.atualizaAtributo("Plataforma", null);
	}

	/**
	 * Metodo para testar se, quando é passado um atributo válido, uma excecao é
	 * lancada devido o valor para atualização do atributo ser vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaAtributoValorVazio() {
		this.jogo.atualizaAtributo("Plataforma", "   ");
	}

	/**
	 * Metodo para testar se, quando é passado um atributo válido, uma excecao é
	 * lancada devido o valor para atualização do atributo ser inválido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaAtributoValorInvalido() {
		this.jogo.atualizaAtributo("Plataforma", "outro");
	}

	/**
	 * Verifica se o equals funciona como esperado.
	 */
	@Test
	public void testEquals() {
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
