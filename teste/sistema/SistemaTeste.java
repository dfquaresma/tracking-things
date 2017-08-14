package sistema;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Testa os metodos da classe sistema
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 */
public class SistemaTeste {
	private Sistema sistema;

	/**
	 * Prepara o ambiente para testes.
	 */
	@Before
	public void setUp() {
		this.sistema = new Sistema();
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
	 * Testa cadastrar um jogo eletronico e pegar detalhes dele
	 */
	@Test
	public void cadastrarEletronicoEGetDetalhesItem() {

		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarEletronico("Rick", "4002-8922", "Bioshock", 35.00, "PC");
		assertEquals("JOGO ELETRONICO: Bioshock, R$ 35.0, Nao emprestado, PC",
				sistema.getDetalhesItem("Rick", "4002-8922", "Bioshock"));
	}

	/**
	 * Testa cadastrar um jogo eletronica com um nome de usuario vazio
	 */
	@Test
	public void cadastrarEletronicoNomeUserVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico(" ", "4002-8922", "Bioshock", 35.00, "PC");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um jogo eletronico com o telefone do usuario vazio
	 */
	@Test
	public void cadastrarEletronicoTelefoneUserVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", " ", "Bioshock", 35.00, "PC");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um jogo eletronico com um nome de item vazio
	 */
	@Test
	public void cadastrarEletronicoNomeItemVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", " ", 35.00, "PC");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um jogo eletronico com um nome de usuario nulo
	 */
	@Test
	public void cadastrarEletronicoNomeUserNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico(null, "4002-8922", "Bioshock", 35.00, "PC");
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa cadastrar um jogo eletronico com um telefone de usuario nulo
	 */
	@Test
	public void cadastrarEletronicoTelefoneUserNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", null, "Bioshock", 35.00, "PC");
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa cadastrar um jogo eletronico com um nome de item nulo
	 */
	@Test
	public void cadastrarEletronicoNomeItemNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", null, 35.00, "PC");
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Nome do item nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa cadastrar um jogo eletronico em uma plataforma invalida
	 */
	@Test
	public void cadastrarEletronicoPlataformaInvalida() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Bioshock", 35.00, "Gameboy");
			fail();

		} catch (IllegalArgumentException iae) {
			assertEquals("Plataforma inválida", iae.getMessage());

		}
	}

	/**
	 * Testa cadastrar um jogo eletronico com um preco invalido
	 */
	@Test
	public void cadastrarEletronicoPrecoInvalido() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Bioshock", -35.00, "PC");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Preco invalido", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um jogo de tabuleiro e pegar os detalhes dele
	 */
	@Test
	public void cadastrarJogoTabuleiroEGetDetalhesItem() {

		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
		assertEquals("JOGO DE TABULEIRO: D&D, R$ 80.0, Nao emprestado, COMPLETO",
				sistema.getDetalhesItem("Rick", "4002-8922", "D&D"));
	}

	/**
	 * Testa cadastrar um jogo de tabuleiro com um nome de usuario vazio
	 */
	@Test
	public void cadastrarJogoTabuleiroNomeUserVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro(" ", "4002-8922", "D&D", 80.00);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um jogo de tabuleiro com um telefone de usuario vazio
	 */
	@Test
	public void cadastrarJogoTabuleiroTelefoneUserVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", " ", "D&D", 80.00);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um jogo de tabuleiro com nome de item vazio
	 */
	@Test
	public void cadastrarJogoTabuleiroNomeItemVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", " ", 80.00);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um jogo de tabuleiro com preco invalido
	 */
	@Test
	public void cadastrarJogoTabuleiroPrecoInvalido() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", -80.00);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Preco invalido", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um jogo de tabuleiro com um nome de usuario nulo
	 */
	@Test
	public void cadastrarJogoTabuleiroNomeUserNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro(null, "4002-8922", "D&D", 80.00);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa cadastrar um jogo de tabuleiro com um telefone de usuario nulo
	 */
	@Test
	public void cadastrarJogoTabuleiroTelefoneUserNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", null, "D&D", 80.00);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa cadastrar um jogo de tabuleiro com um nome de item nulo
	 */
	@Test
	public void cadastrarJogoTabuleiroNomeItemNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", null, 80.00);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Nome do item nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa adicionar uma peca perdida
	 */
	@Test
	public void addPecaPerdida() {

		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
		sistema.addPecaPerdida("Rick", "4002-8922", "D&D", "Dado");
		assertEquals("JOGO DE TABULEIRO: D&D, R$ 80.0, Nao emprestado, COM PECAS PERDIDAS",
				sistema.getDetalhesItem("Rick", "4002-8922", "D&D"));
	}

	/**
	 * Testa adicionar peca perdida em um item que nao existe
	 */
	@Test
	public void addPecaPerdidaItemInvalido() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			sistema.addPecaPerdida("Rick", "4002-8922", "Munchkin", "Dado");
			fail();

		} catch (IllegalArgumentException iae) {
			assertEquals("Item nao encontrado", iae.getMessage());
		}
	}

	/**
	 * Testa adicionar peca perdida com nome de usuario vazio
	 */
	@Test
	public void addPecaPerdidaNomeUserVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			sistema.addPecaPerdida(" ", "4002-8922", "D&D", "Dado");
			fail();

		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa adicionar peca perdida com um telefone de usuario vazio
	 */
	@Test
	public void addPecaPerdidaTelefoneUserVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			sistema.addPecaPerdida("Rick", " ", "D&D", "Dado");
			fail();

		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa adicionar peca perdida com um nome de item vazio
	 */
	@Test
	public void addPecaPerdidaNomeItemVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			sistema.addPecaPerdida("Rick", "4002-8922", "  ", "Dado");
			fail();

		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa adicionar peca perdida com um nome da peca vazio
	 */
	@Test
	public void addPecaPerdidaNomePecaVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			sistema.addPecaPerdida("Rick", "4002-8922", "D&D", " ");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome da peca nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa adicionar peca perdida com nome de usuario nulo
	 */
	@Test
	public void addPecaPerdidaNomeUserNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			sistema.addPecaPerdida(null, "4002-8922", "D&D", "Dado");
			fail();

		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa adicionar peca perdida com um telefone de usuario nulo
	 */
	@Test
	public void addPecaPerdidaTelefoneUserNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			sistema.addPecaPerdida("Rick", null, "D&D", "Dado");
			fail();

		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa adicionar peca perdida com nome de item nulo
	 */
	@Test
	public void addPecaPerdidaNomeItemNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			sistema.addPecaPerdida("Rick", "4002-8922", null, "Dado");
			fail();

		} catch (NullPointerException npe) {
			assertEquals("Nome do item nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa adicionar peca perdida com nome da peca nulo
	 */
	@Test
	public void addPecaPerdidaNomePecaNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			sistema.addPecaPerdida("Rick", "4002-8922", "D&D", null);
			fail();

		} catch (NullPointerException npe) {
			assertEquals("Nome da peca nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de filme e pegar os detalhes dele
	 */
	@Test
	public void cadastrarBlurayFilmeEGetDetalhesItem() {

		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", "DEZ_ANOS", 2000);
		assertEquals("FILME: Sharknado, R$ 10.0, Nao emprestado, 120 min, DEZ_ANOS, COMEDIA, 2000",
				sistema.getDetalhesItem("Rick", "4002-8922", "Sharknado"));
	}

	/**
	 * Testa cadastrar um bluray de filme com um nome de usuario vazio
	 */
	@Test
	public void cadastrarBlurayFilmeNomeUserVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("  ", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", "DEZ_ANOS", 2000);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de filme com telefone de usuario vazio
	 */
	@Test
	public void cadastrarBlurayFilmeTelefoneUserVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "  ", "Sharknado", 10.00, 120, "COMEDIA", "DEZ_ANOS", 2000);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de filme com o nome do filme vazio
	 */
	@Test
	public void cadastrarBlurayFilmeNomeFilmeVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "4002-8922", " ", 10.00, 120, "COMEDIA", "DEZ_ANOS", 2000);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de filme com preco invalido
	 */
	@Test
	public void cadastrarBlurayFilmePrecoInvalido() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", -10.00, 120, "COMEDIA", "DEZ_ANOS", 2000);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Preco invalido", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de filme em um usuario inexistente
	 */
	@Test
	public void cadastrarBlurayFilmeUserInvalido() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Morty", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", "DEZ_ANOS", 2000);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Usuario invalido", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de filme com duracao invalida
	 */
	@Test
	public void cadastrarBlurayFilmeDuracaoInvalida() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, -120, "COMEDIA", "DEZ_ANOS", 2000);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Duracao nao pode ser menor ou igual a zero", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de filme com genero invalido
	 */
	@Test
	public void cadastrarBlurayFilmeGeneroInvalido() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "BATATA", "DEZ_ANOS", 2000);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Genero inválido", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de filme com generio vazio
	 */
	@Test
	public void cadastrarBlurayFilmeGeneroVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "  ", "DEZ_ANOS", 2000);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Genero nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de filme com genero nulo
	 */
	@Test
	public void cadastrarBlurayFilmeGeneroNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, null, "DEZ_ANOS", 2000);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Genero nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de filme com classificacao invalida
	 */
	@Test
	public void cadastrarBlurayFilmeClassificacaoInvalida() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", "VINTE_ANOS", 2000);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao inválida", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de filme com classificacao vazia
	 */
	@Test
	public void cadastrarBlurayFilmeClassificacaoVazia() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", " ", 2000);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de filme com classificacao nula
	 */
	@Test
	public void cadastrarBlurayFilmeClassificacaoNula() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", null, 2000);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Classificacao nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de filme com ano invalido
	 */
	@Test
	public void cadastrarBlurayFilmeAnoInvalido() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", "DEZ_ANOS", -2000);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Ano nao pode ser menor ou igual a zero.", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de serie e pegar detalhes dele
	 */
	@Test
	public void cadastrarBluraySerieEGetDetalhesItem() {

		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 666.00, "Loucura total", 120,
				"DEZESSEIS_ANOS", "FICCAO", 1);
		assertEquals("SERIE: Rick e Morty, R$ 666.0, Nao emprestado, 120 min, DEZESSEIS_ANOS, FICCAO, Temporada 1",
				sistema.getDetalhesItem("Rick", "4002-8922", "Rick e Morty"));
	}

	/**
	 * Testa cadastrar um bluray de serie com nome do usuario vazio
	 */
	@Test
	public void cadastrarBluraySerieNomeUserVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("  ", "4002-8922", "Rick e Morty", 666.00, "Loucura total", 120,
					"DEZESSEIS_ANOS", "FICCAO", 1);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de serie com telefone do usuario vazio
	 */
	@Test
	public void cadastrarBluraySerieTelefoneUserVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "  ", "Rick e Morty", 666.00, "Loucura total", 120, "DEZESSEIS_ANOS",
					"FICCAO", 1);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de serie com o nome do item vazio
	 */
	@Test
	public void cadastrarBluraySerieNomeItemVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", " ", 666.00, "Loucura total", 120, "DEZESSEIS_ANOS",
					"FICCAO", 1);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de serie com um preco invalido
	 */
	@Test
	public void cadastrarBluraySeriePrecoInvalido() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", -666.00, "Loucura total", 120,
					"DEZESSEIS_ANOS", "FICCAO", 1);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Preco invalido", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de serie com descricao vazia
	 */
	@Test
	public void cadastrarBluraySerieDescricaoVazia() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 666.00, " ", 120, "DEZESSEIS_ANOS",
					"FICCAO", 1);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Descricao nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de serie com duracao invalida
	 */
	@Test
	public void cadastrarBluraySerieDuracaoInvalida() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 666.00, "Loucura total", -120,
					"DEZESSEIS_ANOS", "FICCAO", 1);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Duracao nao pode ser menor ou igual a zero", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de serie com classificacao invalida
	 */
	@Test
	public void cadastrarBluraySerieClassificacaoInvalida() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 666.00, "Loucura total", 120,
					"VINTE_ANOS", "FICCAO", 1);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao inválida", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de serie com classificacao vazia
	 */
	@Test
	public void cadastrarBluraySerieClassificacaoVazia() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 666.00, "Loucura total", 120, "  ",
					"FICCAO", 1);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de serie com classificacao nula
	 */
	@Test
	public void cadastrarBluraySerieClassificacaoNula() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 666.00, "Loucura total", 120, null,
					"FICCAO", 1);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Classificacao nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de show e pegar os detalhes dele
	 */
	@Test
	public void cadastrarBlurayShowEGetDetalhesItem() {

		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 12, "Safadao", "LIVRE");
		assertEquals("SHOW: Safadao DVD, R$ 30.0, Nao emprestado, 100 min, LIVRE, Safadao, 12 faixas",
				sistema.getDetalhesItem("Rick", "4002-8922", "Safadao DVD"));

	}

	/**
	 * Testa cadastrar um bluray de show com nome de usuario vazio
	 */
	@Test
	public void cadastrarBlurayShowNomeUserVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow(" ", "4002-8922", "Safadao DVD", 30.00, 100, 12, "Safadao", "LIVRE");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de show com telefone de usuario vazio
	 */
	@Test
	public void cadastrarBlurayShowTelefoneUserVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", " ", "Safadao DVD", 30.00, 100, 12, "Safadao", "LIVRE");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de show com nome do item vazio
	 */
	@Test
	public void cadastrarBlurayShowNomeItemVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", " ", 30.00, 100, 12, "Safadao", "LIVRE");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de show com preco invalido
	 */
	@Test
	public void cadastrarBlurayShowPrecoInvalido() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", -30.00, 100, 12, "Safadao", "LIVRE");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Preco invalido", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de show com duracao invalida
	 */
	@Test
	public void cadastrarBlurayShowDuracaoInvalida() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, -100, 12, "Safadao", "LIVRE");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Duracao nao pode ser menor ou igual a zero", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de show com numerode faixas negativo
	 */
	@Test
	public void cadastrarBlurayShowFaixasNegativo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, -12, "Safadao", "LIVRE");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Numero de faixas nao pode ser menor ou igual a zero.", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de show com numero de faizas igual a zero
	 */
	@Test
	public void cadastrarBlurayShowFaixasZero() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 0, "Safadao", "LIVRE");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Numero de faixas nao pode ser menor ou igual a zero.", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray show com artista vazio
	 */
	@Test
	public void cadastrarBlurayShowArtistaVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 12, " ", "LIVRE");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Artista nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de show com classificacao invalida
	 */
	@Test
	public void cadastrarBlurayShowClassificacaoInvalida() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 12, "Safadao", "BATATA");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao inválida", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de show com classificacao vazia
	 */
	@Test
	public void cadastrarBlurayShowClassificacaoVazia() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 12, "Safadao", " ");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de show com classificacao nula
	 */
	@Test
	public void cadastrarBlurayShowClassificacaoNula() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 12, "Safadao", null);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Classificacao nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de show com nome de usuario nulo
	 */
	@Test
	public void cadastrarBlurayShowNomeUserNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow(null, "4002-8922", "Safadao DVD", 30.00, 100, 12, "Safadao", "LIVRE");
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de show com telefone de usuario nulo
	 */
	@Test
	public void cadastrarBlurayShowTelefoneUserNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", null, "Safadao DVD", 30.00, 100, 12, "Safadao", "LIVRE");
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de show com nome de item nulo
	 */
	@Test
	public void cadastrarBlurayShowNomeItemNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", null, 30.00, 100, 12, "Safadao", "LIVRE");
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Nome do item nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa cadastrar um bluray de show com artista nulo
	 */
	@Test
	public void cadastrarBlurayArtistaNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 12, null, "LIVRE");
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Artista nao pode ser nulo", npe.getMessage());
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

	/**
	 * Testa pegar o nome de um item
	 */
	@Test
	public void getInfoItemNome() {

		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarEletronico("Rick", "4002-8922", "GTA V", 200.00, "PS4");
		assertEquals("GTA V", sistema.getInfoItem("Rick", "4002-8922", "GTA V", "Nome"));
	}

	/**
	 * Testa pegar o preco de um item
	 */
	@Test
	public void getInfoItemPreco() {

		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarEletronico("Rick", "4002-8922", "GTA V", 200.00, "PS4");
		assertEquals("200.0", sistema.getInfoItem("Rick", "4002-8922", "GTA V", "Preco"));
	}

	/**
	 * Testa pegar a plataforma de um item
	 */
	@Test
	public void getInfoItemPlataforma() {

		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarEletronico("Rick", "4002-8922", "GTA V", 200.00, "PS4");
		assertEquals("PS4", sistema.getInfoItem("Rick", "4002-8922", "GTA V", "Plataforma"));
	}

	/**
	 * Testa pegar informacao de um item com atributo invalido
	 */
	@Test
	public void getInfoItemAtributoInvalido() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "GTA V", 200.00, "PS4");
			sistema.getInfoItem("Rick", "4002-8922", "GTA V", "Classificacao");
			fail();

		} catch (IllegalArgumentException iae) {
			assertEquals("Atributo invalido.", iae.getMessage());// TÁ SEM
																	// MENSAGEM
		}
	}

	/**
	 * Testa adicionar um bluray
	 */
	@Test
	public void addBluray() {

		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS",
				"FICCAO", 1);
		sistema.addBluray("Rick", "4002-8922", "Rick e Morty", 22);
	}

	/**
	 * Testa adicionar um bluray em uma serie inexistente
	 */
	@Test
	public void addBluraySerieInvalida() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100,
					"DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.addBluray("Rick", "4002-8922", "CDZ", 22);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Item nao encontrado", iae.getMessage());
		}
	}

	/**
	 * Testa adicionar um bluray com nome de usuario vazio
	 */
	@Test
	public void addBlurayNomeUserVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100,
					"DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.addBluray(" ", "4002-8922", "CDZ", 22);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa adicionar um bluray com telefone de usuario vazio
	 */
	@Test
	public void addBlurayTelefoneUserVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100,
					"DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.addBluray("Rick", "  ", "CDZ", 22);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa adicionar um bluray com nome do episodio vazio
	 */
	@Test
	public void addBlurayEpisodioVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100,
					"DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.addBluray("Rick", "4002-8922", " ", 22);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do bluray nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa adicionar um bluray com duracao invalida
	 */
	@Test
	public void addBlurayDuracaoInvalida() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100,
					"DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.addBluray("Rick", "4002-8922", "Rick e Morty", -22);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Duracao nao pode ser menor ou igual a zero", iae.getMessage());
		}
	}

	/**
	 * Testa adicionar um bluray com nome de usuario nulo
	 */
	@Test
	public void addBlurayNomeUserNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100,
					"DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.addBluray(null, "4002-8922", "Rick e Morty", 22);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa adicionar um bluray com telefone de usuario nulo
	 */
	@Test
	public void addBlurayTelefoneUserNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100,
					"DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.addBluray("Rick", null, "Rick e Morty", 22);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa adicionar um bluray com o nome do bluray nulo
	 */
	@Test
	public void addBlurayNomeBlurayNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100,
					"DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.addBluray("Rick", "4002-8922", null, 22);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Nome do bluray nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa adicionar um bluray com um usuario inexistente
	 */
	@Test
	public void addBlurayUsuarioInvalido() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100,
					"DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.addBluray("Morty", "4002-8922", "Rick e Morty", 22);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Usuario invalido", iae.getMessage());
		}
	}

	/**
	 * Testa remover um item
	 */
	@Test
	public void removerItem() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100,
					"DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.removerItem("Rick", "4002-8922", "Rick e Morty");
			sistema.getInfoItem("Rick", "4002-8922", "Rick e Morty", "Nome");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Item nao encontrado", iae.getMessage());
		}
	}

	/**
	 * Testa remover um item com nome de usuario nulo
	 */
	@Test
	public void removerItemNomeNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100,
					"DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.removerItem(null, "4002-8922", "Rick e Morty");
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa remover um item com telefone de usuario nulo
	 */
	@Test
	public void removerItemTelefoneNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100,
					"DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.removerItem("Rick", null, "Rick e Morty");
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa remover um item com nome do item nulo
	 */
	@Test
	public void removerItemNomeItemNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100,
					"DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.removerItem("Rick", "4002-8922", null);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Nome do item nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa remover um item com nome do usuario vazio
	 */
	@Test
	public void removerItemNomeVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100,
					"DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.removerItem(" ", "4002-8922", "Rick e Morty");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa remover um item com telefone do usuario vazio
	 */
	@Test
	public void removerItemTelefoneVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100,
					"DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.removerItem("Rick", "  ", "Rick e Morty");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa remover um item com o nome do item vazio
	 */
	@Test
	public void removerItemNomeItemVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100,
					"DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.removerItem("Rick", "4002-8922", "  ");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa remover um item de um usuario inexistente
	 */
	@Test
	public void removerItemUsuarioInvalido() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100,
					"DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.removerItem("Morty", "4002-8922", "Rick e Morty");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Usuario invalido", iae.getMessage());
		}
	}

	/**
	 * Testa atualizar o nome de um item
	 */
	@Test
	public void attNomeItem() {
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
		assertEquals("Overwatch", sistema.getInfoItem("Rick", "4002-8922", "Overwatch", "Nome"));

		sistema.attItem("Rick", "4002-8922", "Overwatch", "Nome", "Jogo caro da Blizzard");
		assertEquals("Jogo caro da Blizzard",
				sistema.getInfoItem("Rick", "4002-8922", "Jogo caro da Blizzard", "Nome"));

	}

	/**
	 * Testa atualizar o preco de um item
	 */
	@Test
	public void attPrecoItem() {

		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
		sistema.attItem("Rick", "4002-8922", "Overwatch", "Preco", "250.0");
		assertEquals("250.0", sistema.getInfoItem("Rick", "4002-8922", "Overwatch", "Preco"));
	}

	/**
	 * Testa atualizar um item passando um atributo invalido
	 */
	@Test
	public void attItemAtributoInvalido() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem("Rick", "4002-8922", "Overwatch", "Batata", "PS4");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Atributo invalido", iae.getMessage());
		}
	}

	/**
	 * Testa atualizar um item com nome de usuario vazio
	 */
	@Test
	public void attItemNomeVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem(" ", "4002-8922", "Overwatch", "Plataforma", "PS4");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa atualiza um item com telefone de usuario vazio
	 */
	@Test
	public void attItemTelefoneVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem("Rick", "  ", "Overwatch", "Plataforma", "PS4");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa atualizar um item com nome do item vazio
	 */
	@Test
	public void attItemNomeItemVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem("Rick", "4002-8922", " ", "Plataforma", "PS4");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa atualizar um item com um atributo vazio
	 */
	@Test
	public void attItemAtributoVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem("Rick", "4002-8922", "Overwatch", " ", "PS4");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Atributo nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa atualizar um item com valor vazio
	 */
	@Test
	public void attItemValorVazio() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem("Rick", "4002-8922", "Overwatch", "Plataforma", "  ");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Valor nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa atualizar um item com nome de usuario nulo
	 */
	@Test
	public void attItemNomeNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem(null, "4002-8922", "Overwatch", "Plataforma", "PS4");
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa atualizar um item com telefone de usuario nulo
	 */
	@Test
	public void attItemTelefoneNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem("Rick", null, "Overwatch", "Plataforma", "PS4");
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa atualizar um item com nome do item nulo
	 */
	@Test
	public void attItemNomeItemNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem("Rick", "4002-8922", null, "Plataforma", "PS4");
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Nome do item nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa atualizar um item com nome do item nulo
	 */
	@Test
	public void attItemAtributoNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem("Rick", "4002-8922", "Overwatch", null, "PS4");
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Atributo nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa atualizar um item com valor nulo
	 */
	@Test
	public void attItemValorNulo() {

		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem("Rick", "4002-8922", "Overwatch", "Plataforma", null);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Valor nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa emprestar um item
	 */
	@Test
	public void emprestarItem() {
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
		sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
		sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
		assertEquals("JOGO ELETRONICO: Overwatch, R$ 200.0, Emprestado, PC",
				sistema.getDetalhesItem("Rick", "4002-8922", "Overwatch"));
		// sistema.devolverItem("Rick", "4002-8922", "Morty", "4220",
		// "Overwatch", "09/08/2017", "11/08/2017");
	}

	/**
	 * Testa emprestar um item com nome do dono vazio
	 */
	@Test
	public void emprestarItemNomeDonoVazio() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo(" ", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa emprestar um item com nome do requerente vazio
	 */
	@Test
	public void emprestarItemNomeRequerenteVazio() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", " ", "4220", "Overwatch", "09/08/2017", 3);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa emprestar um item com telefone do dono vazio
	 */
	@Test
	public void emprestarItemTelefoneDonoVazio() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", " ", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa emprestar um item com telefone do requerente vazio
	 */
	@Test
	public void emprestarItemTelefoneRequerenteVazio() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "  ", "Overwatch", "09/08/2017", 3);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa emprestar um item com um nome do item vazio
	 */
	@Test
	public void emprestarItemNomeItemVazio() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "  ", "09/08/2017", 3);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa emprestar um item com data vazia
	 */
	@Test
	public void emprestarItemDataVazia() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", " ", 3);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Data nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa emprestar um item com periodo invalido
	 */
	@Test
	public void emprestarItemPeriodoInvalido() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", -3);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Periodo nao pode ser menor ou iguals a zero.", iae.getMessage());
		}
	}

	/**
	 * Testa emprestar um item com nome do emprestador nulo
	 */
	@Test
	public void emprestarItemNomeEmprestadorNulo() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo(null, "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa emprestar um item com nome do requerente nulo
	 */
	@Test
	public void emprestarItemNomeRequerenteNulo() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", null, "4220", "Overwatch", "09/08/2017", 3);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa emprestrar um item com telefone do emprestador nulo
	 */
	@Test
	public void emprestarItemTelefoneEmprestadorNulo() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", null, "Morty", "4220", "Overwatch", "09/08/2017", 3);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa emprestar um item com telefone do requerente nulo
	 */
	@Test
	public void emprestarItemTelefoneRequerenteNulo() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", null, "Overwatch", "09/08/2017", 3);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa emprestar um item com nome de item nulo
	 */
	@Test
	public void emprestarItemNomeItemNulo() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", null, "09/08/2017", 3);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Nome do item nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa emprestar um item com data nula
	 */
	@Test
	public void emprestarItemDataNula() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", null, 3);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Data nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa emprestar item com um usuario requerente inexistente
	 */
	@Test
	public void emprestarItemUsuarioRequerenteInvalido() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Summer", "4220", "Overwatch", "09/08/2017", 3);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Usuario invalido", iae.getMessage());
		}
	}

	/**
	 * Testa emprestar um item com um emprestador inexistente
	 */
	@Test
	public void emprestarItemUsuarioEmprestadorInvalido() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Summer", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Usuario invalido", iae.getMessage());
		}
	}

	/**
	 * Testa emprestar um item inexistente
	 */
	@Test
	public void emprestarItemItemInvalido() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Bioshock", "09/08/2017", 3);
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Item nao encontrado", iae.getMessage());
		}
	}

	/**
	 * Testa devolver um item
	 */
	@Test
	public void devolverItem() {

		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
		sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
		sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
		assertEquals("JOGO ELETRONICO: Overwatch, R$ 200.0, Emprestado, PC",
				sistema.getDetalhesItem("Rick", "4002-8922", "Overwatch"));
		sistema.devolverItem("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", "11/08/2017");
		assertEquals("JOGO ELETRONICO: Overwatch, R$ 200.0, Nao emprestado, PC",
				sistema.getDetalhesItem("Rick", "4002-8922", "Overwatch"));
	}

	/**
	 * Testa devolver um item com nome de emprestador vazio
	 */
	@Test
	public void devolverItemNomeEmprestadorVazio() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			sistema.devolverItem(" ", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", "11/08/2017");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa devolver um item com nome de requerente vazio
	 */
	@Test
	public void devolverItemNomeRequerenteVazio() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			sistema.devolverItem("Rick", "4002-8922", " ", "4220", "Overwatch", "09/08/2017", "11/08/2017");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa devolver um item com telefone do emprestador vazio
	 */
	@Test
	public void devolverItemTelefoneEmprestadorVazio() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			sistema.devolverItem("Rick", "  ", "Morty", "4220", "Overwatch", "09/08/2017", "11/08/2017");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa devolver um item com telefone do requerente vazio
	 */
	@Test
	public void devolverItemTelefoneRequerenteVazio() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			sistema.devolverItem("Rick", "4002-8922", "Morty", "  ", "Overwatch", "09/08/2017", "11/08/2017");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa devolver item com nome do item vazio
	 */
	@Test
	public void devolverItemNomeItemVazio() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			sistema.devolverItem("Rick", "4002-8922", "Morty", "4220", "  ", "09/08/2017", "11/08/2017");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa devolver um item com data de emprestimo vazia
	 */
	@Test
	public void devolverItemDataEmprestimoVazia() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			sistema.devolverItem("Rick", "4002-8922", "Morty", "4220", "Overwatch", " ", "11/08/2017");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Data nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa devolver um item com data de devolucao vazia
	 */
	@Test
	public void devolverItemDataDevolucaoVazia() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			sistema.devolverItem("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", " ");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Data nao pode ser vazio", iae.getMessage());
		}
	}

	/**
	 * Testa devolver um item com nome de emprestador nulo
	 */
	@Test
	public void devolverItemNomeEmprestadorNulo() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			sistema.devolverItem(null, "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", "11/08/2017");
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa devolver item com nome de requerente nulo
	 */
	@Test
	public void devolverItemNomeRequerenteNulo() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			sistema.devolverItem("Rick", "4002-8922", null, "4220", "Overwatch", "09/08/2017", "11/08/2017");
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa devolver item com telefone do emprestador nulo
	 */
	@Test
	public void devolverItemTelefoneEmprestadorNulo() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			sistema.devolverItem("Rick", null, "Morty", "4220", "Overwatch", "09/08/2017", "11/08/2017");
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa devolver item com telefone do requerente nulo
	 */
	@Test
	public void devolverItemTelefoneRequerenteNulo() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			sistema.devolverItem("Rick", "4002-8922", "Morty", null, "Overwatch", "09/08/2017", "11/08/2017");
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa devolver um item com nome do item nulo
	 */
	@Test
	public void devolverItemNomeItemNulo() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			sistema.devolverItem("Rick", "4002-8922", "Morty", "4220", null, "09/08/2017", "11/08/2017");
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Nome do item nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa devolver um item com data de emprestimo nula
	 */
	@Test
	public void devolverItemDataEmprestimoNula() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			sistema.devolverItem("Rick", "4002-8922", "Morty", "4220", "Overwatch", null, "11/08/2017");
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Data nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa devolver um item com data de devolucao nula
	 */
	@Test
	public void devolverItemDataDevolucaoNula() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			sistema.devolverItem("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", null);
			fail();
		} catch (NullPointerException npe) {
			assertEquals("Data nao pode ser nulo", npe.getMessage());
		}
	}

	/**
	 * Testa devolver um item com um emprestador inexistente
	 */
	@Test
	public void devolverItemUsuarioEmprestadorInvalido() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			sistema.devolverItem("Summer", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", "11/08/2017");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Usuario invalido", iae.getMessage());
		}
	}

	/**
	 * Testa devolver um item com um requerente inexistente
	 */
	@Test
	public void devolverItemUsuarioRequerenteInvalido() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			sistema.devolverItem("Rick", "4002-8922", "Summer", "4220", "Overwatch", "09/08/2017", "11/08/2017");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Usuario invalido", iae.getMessage());
		}
	}

	/**
	 * Testa devolver um item inexistente
	 */
	@Test
	public void devolverItemItemInvalido() {
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarUsuario("Morty", "4220", "morty@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.registrarEmprestimo("Rick", "4002-8922", "Morty", "4220", "Overwatch", "09/08/2017", 3);
			sistema.devolverItem("Rick", "4002-8922", "Morty", "4220", "Bioshock", "09/08/2017", "11/08/2017");
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Emprestimo nao encontrado.", iae.getMessage());
		}
	}
}
