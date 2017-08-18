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
public class ValidadorEmprestimoTest {

	private ValidadorEmprestimo validador;

	/**
	 * Prepara o ambiente para os testes.
	 */
	@Before
	public void criaValidador() {
		this.validador = new ValidadorEmprestimo();
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

}
