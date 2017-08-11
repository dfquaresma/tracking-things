package usuario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Testa a representação de um id de usuário, a classe IdUsuario.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class IdUsuarioTest {
	private IdUsuario id1;
	private IdUsuario id2;
	private IdUsuario id3;
	private IdUsuario id4;
	private IdUsuario id5;

	/**
	 * Prepara o ambiente para os testes.
	 */
	@Before
	public void setUp() {
		this.id1 = new IdUsuario("Funalo", "3371-0000");
		this.id2 = new IdUsuario("Beltrano", "3371-0000");
		this.id3 = new IdUsuario("Sicrano", "3371-0001");
		this.id4 = new IdUsuario("Sicrano", "3371-0000");
		this.id5 = new IdUsuario("Funalo", "3371-0000");
	}

	/**
	 * Valida a funcionalidades básicas e exceção no construtor.
	 */
	@Test
	public void testIdUsuario() {
		assertEquals("Funalo", id1.getNome());
		assertEquals("3371-0000", id1.getTelefone());

		try {
			new IdUsuario(null, "3381-1293");
			fail();
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo", e.getMessage());
		}

		try {
			new IdUsuario("", "3381-1293");
			fail();
		} catch (Exception e) {
			assertEquals("Nome nao pode ser vazio", e.getMessage());
		}

		try {
			new IdUsuario("algo", null);
			fail();
		} catch (Exception e) {
			assertEquals("Telefone nao pode ser nulo", e.getMessage());
		}

		try {
			new IdUsuario("algo", "");
			fail();
		} catch (Exception e) {
			assertEquals("Telefone nao pode ser vazio", e.getMessage());
		}
	}

	/**
	 * Verifica se o equals está se comportando conforme esperado.
	 */
	@Test
	public void testEqualsObject() {
		assertFalse(id1.equals(id2));
		assertFalse(id1.equals(id3));
		assertFalse(id2.equals(id3));
		assertFalse(id1.equals(id4));
		assertFalse(id2.equals(id4));
		assertFalse(id3.equals(id4));
		assertFalse(id2.equals(id5));
		assertFalse(id3.equals(id5));
		assertTrue(id1.equals(id5));

	}

}
