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
public class ValidadorUsuarioTest {

	private ValidadorUsuario validador;

	/**
	 * Prepara o ambiente para os testes.
	 */
	@Before
	public void criaValidador() {
		this.validador = new ValidadorUsuario();
	}

	/**
	 * Metodo para testar se, quando o nome é passado corretamente é validado.
	 */
	@Test
	public void testValidaNome() {
		this.validador.validaNome("paulofelipe");
	}

	/**
	 * Metodo para testar se, quando o nome é passado como Null, uma excecao é
	 * lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testValidaNomeNull() {
		this.validador.validaNome(null);
	}

	/**
	 * Metodo para testar se, quando o nome é passado como vazio, uma excecao é
	 * lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaNomeInvalido() {
		this.validador.validaNome("       ");
	}

	/**
	 * Testa se qualquer padrão de telefone é aceito no sistema.
	 */
	@Test
	public void testValidaTelefone() {
		this.validador.validaTelefone("chama no zap bb: 8398777777");
	}

	/**
	 * Metodo para testar se, quando o telefone é passado como Null, uma excecao
	 * é lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testValidaTelefoneNull() {
		this.validador.validaTelefone(null);
	}

	/**
	 * Metodo para testar se, quando o telefone é passado como vazio, uma
	 * excecao é lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaTelefoneInvalido() {
		this.validador.validaTelefone("       ");
	}

	/**
	 * Testa se qualquer padrão de email é aceito no sistema.
	 */
	@Test
	public void testValidaEmail() {
		this.validador.validaEmail("paulopaulopaulo@gmail.com");
	}

	/**
	 * Metodo para testar se, quando o email é passado como Null, uma excecao é
	 * lancada.
	 */
	@Test(expected = NullPointerException.class)
	public void testValidaEmailNull() {
		this.validador.validaEmail(null);
	}

	/**
	 * Metodo para testar se, quando o email é passado como vazio, uma excecao é
	 * lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaEmailInvalido() {
		this.validador.validaEmail("       ");
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

}
