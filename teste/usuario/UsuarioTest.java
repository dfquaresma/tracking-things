package usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Testa as funcionalidades da classe Usuario.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class UsuarioTest {

	private Usuario usuario;
	private Usuario usuario2;

	/**
	 * Inicianlizando usuario e usuario2.
	 */
	@Before
	public void Inicializa() {
		this.usuario = new Usuario("Ícaro", "+55 (83) 9.9384-7651", "icaro.lima@ccc.ufcg.edu.br");
		this.usuario2 = new Usuario("David", "+55 (83) 9.1234-5678", "david.quaresma@ccc.ufcg.edu.br");
	}

	/**
	 * Testa o construtor de Usuario quanto o nome está vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testUsuarioNomeVazio() {
		this.usuario = new Usuario("", "93428573498", "icaro.lima@ccc.ufcg.edu.br");
	}

	/**
	 * Testa o construtor de Usuario quanto o telefone está vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testUsuarioTelefoneVazio() {
		this.usuario = new Usuario("Higor", "", "icaro.lima@ccc.ufcg.edu.br");
	}

	/**
	 * Testa o construtor de Usuario quanto o email está vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testUsuarioEmailVazio() {
		this.usuario = new Usuario("Higor", "9879878997", "");
	}

	/**
	 * Testa o construtor de Usuario quando o nome está vazio só que com espaços
	 * mesmo assim.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testUsuarioNomeVazioComEspacos() {
		this.usuario = new Usuario(" ", "93428573498", "icaro.lima@ccc.ufcg.edu.br");
	}

	/**
	 * Testa o construtor de Usuario quando o telefone está vazio só que com
	 * espaços mesmo assim.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testUsuarioTelefoneVazioComEspacos() {
		this.usuario = new Usuario("Higor", "   ", "icaro.lima@ccc.ufcg.edu.br");
	}

	/**
	 * Testa o construtor de Usuario quando o email está vazio só que com
	 * espaços mesmo assim.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testUsuarioEmailVazioComEspacos() {
		this.usuario = new Usuario("Higor", "9879878997", "  ");
	}

	/**
	 * Testa o construtor de Usuario quando o nome está nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testUsuarioNomeNulo() {
		this.usuario = new Usuario(null, "93428573498", "icaro.lima@ccc.ufcg.edu.br");
	}

	/**
	 * Testa o construtor de Usuario quando o telefone está nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testUsuarioTelefoneNulo() {
		this.usuario = new Usuario("Higor", null, "icaro.lima@ccc.ufcg.edu.br");
	}

	/**
	 * Testa o construtor de Usuario quando o email está nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testUsuarioEmailNulo() {
		this.usuario = new Usuario("Higor", "9879878997", null);
	}

	/**
	 * Testa o equals de um Usuario.
	 */
	@Test
	public void testEqualsObject() {
		Usuario userTest = new Usuario("Ícaro", "+55 (83) 9.9384-7651", "icaro.lima@ccc.ufcg.edu.br");
		assertTrue(this.usuario.equals(userTest));
		assertFalse(this.usuario.equals(this.usuario2));
	}

	/**
	 * Testa o toString de um Usuario.
	 */
	@Test
	public void testToString() {
		assertEquals("Ícaro, +55 (83) 9.9384-7651, icaro.lima@ccc.ufcg.edu.br", this.usuario.toString());
	}

}
