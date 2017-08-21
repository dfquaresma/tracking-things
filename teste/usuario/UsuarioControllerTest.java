package usuario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import excecoes.UsuarioJaExistenteExcecao;
import usuario.UsuarioController;

/**
 * Testa os metodos da classe sistema
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 */
public class UsuarioControllerTest {
	private UsuarioController sistema;

	/**
	 * Prepara o ambiente para testes.
	 */
	@Before
	public void setUp() {
		this.sistema = new UsuarioController();
	}

	/**
	 * Testa cadastrar e exibir o nome de um usuario
	 */
	@Test
	public void CadastrarEExibirNomeDoUsuario() {
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		assertEquals("Rick", sistema.getInfoUser("Rick", "4002-8922", "Nome"));
	}

	/**
	 * Testa cadastrar e exibir o telefone de um usuario
	 */
	@Test
	public void CadastrarEExibirTelefoneDoUsuario() {
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		assertEquals("4002-8922", sistema.getInfoUser("Rick", "4002-8922", "Telefone"));
	}

	/**
	 * Testa cadastrar e exibir o email de um usuario
	 */
	@Test
	public void CadastrarEExibirEmailDoUsuario() {
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		assertEquals("rick@mail.com", sistema.getInfoUser("Rick", "4002-8922", "Email"));
	}

	/**
	 * Testa cadastrar um usuario com nome vazio
	 */
	@Test
	public void cadastrarUsuarioNomeVazio() {

		try {
			sistema.cadastrarUsuario(" ", "4002-8922", "rick@mail.com");
			fail();

		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um usuario com telefone vazio
	 */
	@Test
	public void cadastrarUsuarioTelefoneVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "  ", "rick@mail.com");
			fail();

		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um usuario com email vazio
	 */
	@Test
	public void cadastrarUsuarioEmailVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "  ");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Email nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um usuario com nome nulo
	 */
	@Test
	public void cadastrarUsuarioNomeNulo() {

		try {
			sistema.cadastrarUsuario(null, "4002-8922", "rick@mail.com");
			fail();

		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa cadastrar um usuario com telefone nulo
	 */
	@Test
	public void cadastrarUsuarioTelefoneNulo() {

		try {
			sistema.cadastrarUsuario("Rick", null, "rick@mail.com");
			fail();

		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa cadastrar um usuario com email nulo
	 */
	@Test
	public void cadastrarUsuarioEmailNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", null);
			fail();

		} catch (NullPointerException npe) {
			assertEquals("Email nao pode ser nulo", npe.getMessage());
		}
	}
	
	/**
	 * Testa cadastrar um usuario com email nulo
	 */
	@Test
	public void cadastrarUsuarioNomeExistente() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@gmail.com");
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@gmail.com");
			fail();

		} catch (UsuarioJaExistenteExcecao ujee) {
			assertEquals("Usuario ja cadastrado", ujee.getMessage());
		}
	}

	/**
	 * Testa pegar a informação de um usuario com um atributo invalido
	 */
	@Test
	public void getInfoUserAtributoInvalido() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.getInfoUser("Rick", "4002-8922", "Plataforma");
			fail();

		} catch (IllegalArgumentException iae) {
			assertEquals("Atributo invalido.", iae.getMessage());
		}
	}

	/**
	 * Testa atualizar o nome de um usuario
	 */
	@Test
	public void attNomeUsuario() {

		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.attUsuario("Rick", "4002-8922", "Nome", "Morty");
		assertEquals("Morty", sistema.getInfoUser("Morty", "4002-8922", "Nome"));
	}

	/**
	 * Testa atualizar o telefone de um usuario
	 */
	@Test
	public void attTelefoneUsuario() {

		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.attUsuario("Rick", "4002-8922", "Telefone", "0800-721-1530");
		assertEquals("0800-721-1530", sistema.getInfoUser("Rick", "0800-721-1530", "Telefone"));
	}

	/**
	 * Testa atualizar o email de um usuario
	 */
	@Test
	public void attEmailUsuario() {

		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.attUsuario("Rick", "4002-8922", "Email", "rick2@mail.com");
		assertEquals("rick2@mail.com", sistema.getInfoUser("Rick", "4002-8922", "Email"));
	}

	/**
	 * Testa atualizar um usuario com um atributo invalido
	 */
	@Test
	public void attUsuarioAtributoInvalido() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.attUsuario("Rick", "4002-8922", "Classificacao", "Morty");
			fail();

		} catch (IllegalArgumentException iae) {
			assertEquals("Atributo invalido", iae.getMessage());
		}
	}

	/**
	 * Testa atualizar um usuario com nome vazio
	 */
	@Test
	public void attUsuarioNomeVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.attUsuario(" ", "4002-8922", "Nome", "Morty");
			fail();

		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa atualizar um usuario com telefone vazio
	 */
	@Test
	public void attUsuarioTelefoneVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.attUsuario("Rick", " ", "Nome", "Morty");
			fail();

		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa atualizar um usuario com um valor vazio
	 */
	@Test
	public void attUsuarioValorVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.attUsuario("Rick", "4002-8922", "Nome", " ");
			fail();

		} catch (IllegalArgumentException iae) {
			assertEquals("Valor nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa atualizar um usuario com nome nulo
	 */
	@Test
	public void attUsuarioNomeNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.attUsuario(null, "4002-8922", "Nome", "Morty");
			fail();

		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa atalizar o usuario com telefone nulo
	 */
	@Test
	public void attUsuarioTelefoneNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.attUsuario("Rick", null, "Nome", "Morty");
			fail();

		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa atualizar o usuario com valor nulo
	 */
	@Test
	public void attUsuarioValorNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.attUsuario("Rick", "4002-8922", "Nome", null);
			fail();

		} catch (NullPointerException npe) {
			assertEquals("Valor nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa atualizar um usuario que nao existe
	 */
	@Test
	public void attUsuarioInvalido() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.attUsuario("Morty", "4002-8922", "Nome", "Summer");
			fail();

		} catch (IllegalArgumentException iae) {
			assertEquals("Usuario invalido", iae.getMessage());
		}
	}

	/**
	 * Testa remover um usuario
	 */
	@Test
	public void removerUsuario() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.removeUsuario("Rick", "4002-8922");
			sistema.getInfoUser("Rick", "4002-8922", "Nome");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Usuario invalido", iae.getMessage());
		}
	}

	/**
	 * Testa remover um usuario com nome vazio
	 */
	@Test
	public void removerUsuarioNomeVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.removeUsuario(" ", "4002-8922");
			fail();

		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa remover um usuario com telefone vazio
	 */
	@Test
	public void removerUsuarioTelefoneVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.removeUsuario("Rick", "   ");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa pegar informacoes de um usuario inexistente
	 */
	@Test
	public void getInfoUserInvalido() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.getInfoUser("Morty", "4002-8922", "Nome");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Usuario invalido", iae.getMessage());
		}
	}

}
