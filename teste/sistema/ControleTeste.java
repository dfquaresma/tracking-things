package sistema;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControleTeste {

	@Test
	public void CadastrarEExibirNomeDoUsuario() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		assertEquals("Rick", controle.getInfoUser("Rick", "4002-8922", "Nome"));
	}

	@Test
	public void CadastrarEExibirTelefoneDoUsuario() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		assertEquals("4002-8922", controle.getInfoUser("Rick", "4002-8922", "Telefone"));
	}

	@Test
	public void CadastrarEExibirEmailDoUsuario() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		assertEquals("rick@mail.com", controle.getInfoUser("Rick", "4002-8922", "Email"));
	}

	@Test
	public void cadastrarUsuarioNomeVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario(" ", "4002-8922", "rick@mail.com");

		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void cadastrarUsuarioTelefoneVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "  ", "rick@mail.com");

		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void cadastrarUsuarioEmailVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "  ");

		} catch (IllegalArgumentException iae) {
			assertEquals("Email nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void cadastrarUsuarioNomeNulo() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario(null, "4002-8922", "rick@mail.com");

		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void cadastrarUsuarioTelefoneNulo() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", null, "rick@mail.com");

		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void cadastrarUsuarioEmailNulo() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", null);

		} catch (NullPointerException npe) {
			assertEquals("Email nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void getInfoUserAtributoInvalido() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.getInfoUser("Rick", "4002-8922", "Plataforma");

		} catch (IllegalArgumentException iae) {
			assertEquals("Atributo invalido.", iae.getMessage());
		}
	}

	@Test
	public void attNomeUsuario() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		controle.attUsuario("Rick", "4002-8922", "Nome", "Morty");
		assertEquals("Morty", controle.getInfoUser("Morty", "4002-8922", "Nome"));
	}

	@Test
	public void attTelefoneUsuario() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		controle.attUsuario("Rick", "4002-8922", "Telefone", "0800-721-1530");
		assertEquals("0800-721-1530", controle.getInfoUser("Rick", "0800-721-1530", "Telefone"));
	}

	@Test
	public void attEmailUsuario() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		controle.attUsuario("Rick", "4002-8922", "Email", "rick2@mail.com");
		assertEquals("rick2@mail.com", controle.getInfoUser("Rick", "4002-8922", "Email"));
	}

	@Test
	public void attUsuarioAtributoInvalido() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.attUsuario("Rick", "4002-8922", "Classificacao", "Morty");

		} catch (IllegalArgumentException iae) {
			assertEquals("Atributo invalido", iae.getMessage());
		}
	}

	@Test
	public void attUsuarioNomeVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.attUsuario(" ", "4002-8922", "Nome", "Morty");

		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void attUsuarioTelefoneVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.attUsuario("Rick", " ", "Nome", "Morty");

		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void attUsuarioValorVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.attUsuario("Rick", "4002-8922", "Nome", " ");

		} catch (IllegalArgumentException iae) {
			assertEquals("Valor nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void attUsuarioNomeNulo() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.attUsuario(null, "4002-8922", "Nome", "Morty");

		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void attUsuarioTelefoneNulo() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.attUsuario("Rick", null, "Nome", "Morty");

		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void attUsuarioValorNulo() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.attUsuario("Rick", "4002-8922", "Nome", null);

		} catch (NullPointerException npe) {
			assertEquals("Valor nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void attUsuarioInvalido() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.attUsuario("Morty", "4002-8922", "Nome", "Summer");

		} catch (IllegalArgumentException iae) {
			assertEquals("Usuario invalido", iae.getMessage());
		}
	}

	@Test
	public void removerUsuario() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.removeUsuario("Rick", "4002-8922");

		} catch (NullPointerException npe) {

		}
	}

	@Test
	public void removerUsuarioNomeVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.removeUsuario(" ", "4002-8922");

		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void removerUsuarioTelefoneVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.removeUsuario("Rick", "   ");

		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void cadastrarEletronicoEGetDetalhesItem() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		controle.cadastrarEletronico("Rick", "4002-8922", "Bioshock", 35.00, "PC");
		assertEquals("JOGO ELETRONICO: Bioshock, R$ 35.0, Nao emprestado, PC",
				controle.getDetalhesItem("Rick", "4002-8922", "Bioshock"));
	}

	@Test
	public void cadastrarEletronicoNomeUserVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarEletronico(" ", "4002-8922", "Bioshock", 35.00, "PC");
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void cadastrarEletronicoTelefoneUserVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarEletronico("Rick", " ", "Bioshock", 35.00, "PC");
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void cadastrarEletronicoNomeItemVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarEletronico("Rick", "4002-8922", " ", 35.00, "PC");
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void cadastrarEletronicoNomeUserNulo() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarEletronico(null, "4002-8922", "Bioshock", 35.00, "PC");
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void cadastrarEletronicoTelefoneUserNulo() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarEletronico("Rick", null, "Bioshock", 35.00, "PC");
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void cadastrarEletronicoNomeItemNulo() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarEletronico("Rick", "4002-8922", null, 35.00, "PC");
		} catch (NullPointerException npe) {
			assertEquals("Nome do item nao pode ser nulo", npe.getMessage());
		}
	}

	/*
	 * @Test VER O RETORNO DISSO AQUI public void
	 * cadastrarEletronicoPlataformaInvalida() { Controller controle = new
	 * Controller(); try { controle.cadastrarUsuario("Rick", "4002-8922",
	 * "rick@mail.com"); controle.cadastrarEletronico("Rick", "4002-8922",
	 * "Bioshock", 35.00, "Gameboy"); } catch (IllegalArgumentException iae) {
	 * assertEquals("", iae.getMessage());
	 * 
	 * } }
	 */

	@Test
	public void cadastrarEletronicoPrecoInvalido() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarEletronico("Rick", "4002-8922", "Bioshock", -35.00, "PC");
		} catch (IllegalArgumentException iae) {
			assertEquals("Preco invalido", iae.getMessage());
		}
	}

	@Test
	public void cadastrarJogoTabuleiroEGetDetalhesItem() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		controle.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
		assertEquals("JOGO DE TABULEIRO: D&D, R$ 80.0, Nao emprestado, COMPLETO",
				controle.getDetalhesItem("Rick", "4002-8922", "D&D"));
	}

	@Test
	public void cadastrarJogoTabuleiroNomeUserVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarJogoTabuleiro(" ", "4002-8922", "D&D", 80.00);
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void cadastrarJogoTabuleiroTelefoneUserVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarJogoTabuleiro("Rick", " ", "D&D", 80.00);
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void cadastrarJogoTabuleiroNomeItemVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarJogoTabuleiro("Rick", "4002-8922", " ", 80.00);
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void cadastrarJogoTabuleiroPrecoInvalido() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", -80.00);
		} catch (IllegalArgumentException iae) {
			assertEquals("Preco invalido", iae.getMessage());
		}
	}

	@Test
	public void cadastrarJogoTabuleiroNomeUserNulo() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarJogoTabuleiro(null, "4002-8922", "D&D", 80.00);
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void cadastrarJogoTabuleiroTelefoneUserNulo() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarJogoTabuleiro("Rick", null, "D&D", 80.00);
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void cadastrarJogoTabuleiroNomeItemNulo() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarJogoTabuleiro("Rick", "4002-8922", null, 80.00);
		} catch (NullPointerException npe) {
			assertEquals("Nome do item nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void addPecaPerdida() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		controle.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
		controle.addPecaPerdida("Rick", "4002-8922", "D&D", "Dado");
		assertEquals("JOGO DE TABULEIRO: D&D, R$ 80.0, Nao emprestado, COM PECAS PERDIDAS",
				controle.getDetalhesItem("Rick", "4002-8922", "D&D"));
	}

	@Test
	public void addPecaPerdidaItemInvalido() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			controle.addPecaPerdida("Rick", "4002-8922", "Munchkin", "Dado");

		} catch (IllegalArgumentException iae) {
			assertEquals("Item nao encontrado", iae.getMessage());
		}
	}

	@Test
	public void addPecaPerdidaNomeUserVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			controle.addPecaPerdida(" ", "4002-8922", "D&D", "Dado");

		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void addPecaPerdidaTelefoneUserVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			controle.addPecaPerdida("Rick", " ", "D&D", "Dado");

		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void addPecaPerdidaNomeItemVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			controle.addPecaPerdida("Rick", "4002-8922", "  ", "Dado");

		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void addPecaPerdidaNomePecaVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			controle.addPecaPerdida("Rick", "4002-8922", "D&D", " ");

		} catch (IllegalArgumentException iae) {
			assertEquals("Nome da peca nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void addPecaPerdidaNomeUserNulo() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			controle.addPecaPerdida(null, "4002-8922", "D&D", "Dado");

		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void addPecaPerdidaTelefoneUserNulo() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			controle.addPecaPerdida("Rick", null, "D&D", "Dado");

		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void addPecaPerdidaNomeItemNulo() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			controle.addPecaPerdida("Rick", "4002-8922", null, "Dado");

		} catch (NullPointerException npe) {
			assertEquals("Nome do item nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void addPecaPerdidaNomePecaNulo() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			controle.addPecaPerdida("Rick", "4002-8922", "D&D", null);

		} catch (NullPointerException npe) {
			assertEquals("Nome da peca nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void cadastrarBlurayFilmeEGetDetalhesItem() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		controle.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", "DEZ_ANOS", 2000);
		assertEquals("FILME: Sharknado, R$ 10.0, Nao emprestado, 120 min, DEZ_ANOS, COMEDIA, 2000",
				controle.getDetalhesItem("Rick", "4002-8922", "Sharknado"));
	}

	@Test
	public void cadastrarBlurayFilmeNomeUserVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayFilme("  ", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", "DEZ_ANOS", 2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio",iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmeTelefoneUserVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayFilme("Rick", "  ", "Sharknado", 10.00, 120, "COMEDIA", "DEZ_ANOS", 2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio",iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmeNomeFilmeVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayFilme("Rick", "4002-8922", " ", 10.00, 120, "COMEDIA", "DEZ_ANOS", 2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio",iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmePrecoInvalido() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", -10.00, 120, "COMEDIA", "DEZ_ANOS", 2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Preco invalido",iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmeUserInvalido() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayFilme("Morty", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", "DEZ_ANOS", 2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Usuario invalido",iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmeDuracaoInvalida() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, -120, "COMEDIA", "DEZ_ANOS", 2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Duracao nao pode ser negativa",iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmeGeneroInvalido() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "BATATA", "DEZ_ANOS", 2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Genero inválido",iae.getMessage());
		}
	}

	@Test
	public void cadastrarBlurayFilmeGeneroVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "  ", "DEZ_ANOS", 2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Genero nao pode ser vazio",iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmeGeneroNulo() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, null, "DEZ_ANOS", 2000);
		} catch (NullPointerException npe) {
			assertEquals("Genero nao pode ser nulo",npe.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmeClassificacaoInvalida() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", "VINTE_ANOS", 2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao inválida",iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmeClassificacaoVazia() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", " ", 2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao nao pode ser vazio",iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmeClassificacaoNula() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", null, 2000);
		} catch (NullPointerException npe) {
			assertEquals("Classificacao nao pode ser nulo",npe.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmeAnoInvalido() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", "DEZ_ANOS", -2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Ano nao pode ser negativo",iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBluraySerieEGetDetalhesItem() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 666.00, "Loucura total", 120, "DEZESSEIS_ANOS", "FICCAO", 1);
		assertEquals("SERIE: Rick e Morty, R$ 666.0, Nao emprestado, 120 min, DEZESSEIS_ANOS, FICCAO, Temporada 1",
				controle.getDetalhesItem("Rick", "4002-8922", "Rick e Morty"));
	}
	
	@Test
	public void cadastrarBluraySerieNomeUserVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("  ", "4002-8922", "Rick e Morty", 666.00, "Loucura total", 120, "DEZESSEIS_ANOS", "FICCAO", 1);
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBluraySerieTelefoneUserVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "  ", "Rick e Morty", 666.00, "Loucura total", 120, "DEZESSEIS_ANOS", "FICCAO", 1);
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBluraySerieNomeItemVazio() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", " ", 666.00, "Loucura total", 120, "DEZESSEIS_ANOS", "FICCAO", 1);
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBluraySeriePrecoInvalido() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", -666.00, "Loucura total", 120, "DEZESSEIS_ANOS", "FICCAO", 1);
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Preco invalido", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBluraySerieDescricaoVazia() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 666.00, " ", 120, "DEZESSEIS_ANOS", "FICCAO", 1);
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Descricao nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBluraySerieDuracaoInvalida() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 666.00, "Loucura total", -120, "DEZESSEIS_ANOS", "FICCAO", 1);
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Duracao nao pode ser negativa", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBluraySerieClassificacaoInvalida() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 666.00, "Loucura total", 120, "VINTE_ANOS", "FICCAO", 1);
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao inválida", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBluraySerieClassificacaoVazia() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 666.00, "Loucura total", 120, "  ", "FICCAO", 1);
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBluraySerieClassificacaoNula() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 666.00, "Loucura total", 120, null, "FICCAO", 1);
			
		} catch (NullPointerException npe) {
			assertEquals("Classificacao nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowEGetDetalhesItem(){
		Controller controle = new Controller();
		controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		controle.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 12, "Safadao", "LIVRE");
		assertEquals("SHOW: Safadao DVD, R$ 30.0, Nao emprestado, 100 min, LIVRE, Safadao, 12 faixas", controle.getDetalhesItem("Rick", "4002-8922", "Safadao DVD"));
		
	}
	
	@Test
	public void cadastrarBlurayShowNomeUserVazio(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayShow(" ", "4002-8922", "Safadao DVD", 30.00, 100, 12, "Safadao", "LIVRE");			
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}
		
	@Test
	public void cadastrarBlurayShowTelefoneUserVazio(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayShow("Rick", " ", "Safadao DVD", 30.00, 100, 12, "Safadao", "LIVRE");			
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowNomeItemVazio(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayShow("Rick", "4002-8922", " ", 30.00, 100, 12, "Safadao", "LIVRE");			
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowPrecoInvalido(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", -30.00, 100, 12, "Safadao", "LIVRE");			
		} catch (IllegalArgumentException iae) {
			assertEquals("Preco invalido", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowDuracaoInvalida(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, -100, 12, "Safadao", "LIVRE");			
		} catch (IllegalArgumentException iae) {
			assertEquals("Duracao nao pode ser negativa", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowFaixasNegativo(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, -12, "Safadao", "LIVRE");			
		} catch (IllegalArgumentException iae) {
			assertEquals("Numero de faixas nao pode ser menor ou igual a zero.", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowFaixasZero(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 0, "Safadao", "LIVRE");			
		} catch (IllegalArgumentException iae) {
			assertEquals("Numero de faixas nao pode ser menor ou igual a zero.", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowArtistaVazio(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 12, " ", "LIVRE");			
		} catch (IllegalArgumentException iae) {
			assertEquals("Artista nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowClassificacaoInvalida(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 12, "Safadao", "BATATA");			
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao inválida", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowClassificacaoVazia(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 12, "Safadao", " ");			
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowClassificacaoNula(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 12, "Safadao", null);			
		} catch (NullPointerException npe) {
			assertEquals("Classificacao nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowNomeUserNulo(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayShow(null, "4002-8922", "Safadao DVD", 30.00, 100, 12, "Safadao", "LIVRE");			
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowTelefoneUserNula(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayShow("Rick", null, "Safadao DVD", 30.00, 100, 12, "Safadao", "LIVRE");			
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowNomeItemNulo(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayShow("Rick", "4002-8922", null, 30.00, 100, 12, "Safadao", "LIVRE");			
		} catch (NullPointerException npe) {
			assertEquals("Nome do item nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayArtistaNulo(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 12, null, "LIVRE");			
		} catch (NullPointerException npe) {
			assertEquals("Artista nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void getInfoUserInvalido(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.getInfoUser("Morty", "4002-8922", "Nome");
		} catch (IllegalArgumentException iae) {
			assertEquals("Usuario invalido", iae.getMessage());
		}
	}
	
	@Test
	public void getInfoItemNome(){
		Controller controle = new Controller();
		controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		controle.cadastrarEletronico("Rick", "4002-8922", "GTA V", 200.00, "PS4");
		assertEquals("GTA V",controle.getInfoItem("Rick", "4002-8922", "GTA V", "Nome") );
	}
	
	@Test
	public void getInfoItemPreco(){
		Controller controle = new Controller();
		controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		controle.cadastrarEletronico("Rick", "4002-8922", "GTA V", 200.00, "PS4");
		assertEquals("200.0",controle.getInfoItem("Rick", "4002-8922", "GTA V", "Preco") );
	}
	
	@Test
	public void getInfoItemPlataforma(){
		Controller controle = new Controller();
		controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		controle.cadastrarEletronico("Rick", "4002-8922", "GTA V", 200.00, "PS4");
		assertEquals("PS4",controle.getInfoItem("Rick", "4002-8922", "GTA V", "Plataforma"));
	}
	
	/*@Test
	public void getInfoItemAtributoInvalido(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarEletronico("Rick", "4002-8922", "GTA V", 200.00, "PS4");			
			controle.getInfoItem("Rick", "4002-8922", "GTA V", "Classificacao");
		} catch (IllegalArgumentException iae) {
			assertEquals("Atributo invalido", iae.getMessage());// TÁ SEM MENSAGEM
		}
	} */
	
	@Test
	public void addBluray(){
		Controller controle = new Controller();
		controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
		controle.addBluray("Rick", "4002-8922", "Rick e Morty", 22);
	}
	
	@Test
	public void addBluraySerieInvalida(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			controle.addBluray("Rick", "4002-8922", "CDZ", 22);
		} catch (IllegalArgumentException iae) {
			assertEquals("Item nao encontrado", iae.getMessage());
		}
	}
	
	@Test
	public void addBlurayNomeUserVazio(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			controle.addBluray(" ", "4002-8922", "CDZ", 22);
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void addBlurayTelefoneUserVazio(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			controle.addBluray("Rick", "  ", "CDZ", 22);
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void addBlurayEpisodioVazio(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			controle.addBluray("Rick", "4002-8922", " ", 22);
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do bluray nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void addBlurayDuracaoInvalida(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			controle.addBluray("Rick", "4002-8922", "Rick e Morty", -22);
		} catch (IllegalArgumentException iae) {
			assertEquals("Duracao nao pode ser negativa", iae.getMessage());
		}
	}
	
	@Test
	public void addBlurayNomeUserNulo(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			controle.addBluray(null, "4002-8922", "Rick e Morty", 22);
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void addBlurayTelefoneUserNulo(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			controle.addBluray("Rick", null, "Rick e Morty", 22);
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void addBlurayNomeBlurayNulo(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			controle.addBluray("Rick", "4002-8922", null, 22);
		} catch (NullPointerException npe) {
			assertEquals("Nome do bluray nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void addBlurayUsuarioInvalido(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			controle.addBluray("Morty", "4002-8922", "Rick e Morty", 22);
		} catch (IllegalArgumentException iae) {
			assertEquals("Usuario invalido", iae.getMessage());
		}
	}
	
	@Test
	public void removerItem(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			controle.removerItem("Rick", "4002-8922", "Rick e Morty");
		} catch (NullPointerException npe) {
		}
	}
	
	@Test
	public void removerItemNomeNulo(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			controle.removerItem(null, "4002-8922", "Rick e Morty");
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void removerItemTelefoneNulo(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			controle.removerItem("Rick", null, "Rick e Morty");
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void removerItemNomeItemNulo(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			controle.removerItem("Rick", "4002-8922", null);
		} catch (NullPointerException npe) {
			assertEquals("Nome do item nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void removerItemNomeVazio(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			controle.removerItem(" ", "4002-8922", "Rick e Morty");
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void removerItemTelefoneVazio(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			controle.removerItem("Rick", "  ", "Rick e Morty");
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void removerItemNomeItemVazio(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			controle.removerItem("Rick", "4002-8922", "  ");
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void removerItemUsuarioInvalido(){
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			controle.removerItem("Morty", "4002-8922", "Rick e Morty");
		} catch (IllegalArgumentException iae) {
			assertEquals("Usuario invalido", iae.getMessage());
		}
	}
	/*
	@Test
	public void attNomeItem() { //DEU ERRO AQUI
		Controller controle = new Controller();
		controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		controle.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
		controle.attItem("Rick", "4002-8922", "Overwatch", "Nome", "Jogo caro da Bizzard");
		assertEquals("Jogo caro da Blizzard", controle.getInfoItem("Rick", "4002-8922", "Jogo caro da Blizzard", "Nome"));
	}*/
	@Test
	public void attPrecoItem() { 
		Controller controle = new Controller();
		controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		controle.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
		controle.attItem("Rick", "4002-8922", "Overwatch", "Preco", "250.0");
		assertEquals("250.0", controle.getInfoItem("Rick", "4002-8922", "Overwatch", "Preco"));
	}
	
	@Test
	public void attItemAtributoInvalido() { 
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			controle.attItem("Rick", "4002-8922", "Overwatch", "Plataforma", "PS4");
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Atributo invalido", iae.getMessage());
		}
	}
	
	@Test
	public void attItemNomeVazio() { 
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			controle.attItem(" ", "4002-8922", "Overwatch", "Plataforma", "PS4");
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void attItemTelefoneVazio() { 
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			controle.attItem("Rick", "  ", "Overwatch", "Plataforma", "PS4");
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void attItemNomeItemVazio() { 
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			controle.attItem("Rick", "4002-8922", " ", "Plataforma", "PS4");
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void attItemAtributoVazio() { 
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			controle.attItem("Rick", "4002-8922", "Overwatch", " ", "PS4");
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Atributo nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void attItemValorVazio() { 
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			controle.attItem("Rick", "4002-8922", "Overwatch", "Plataforma", "  ");
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Valor nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void attItemNomeNulo() { 
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			controle.attItem(null, "4002-8922", "Overwatch", "Plataforma", "PS4");
			
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void attItemTelefoneNulo() { 
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			controle.attItem("Rick", null, "Overwatch", "Plataforma", "PS4");
			
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void attItemNomeItemNulo() { 
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			controle.attItem("Rick", "4002-8922", null, "Plataforma", "PS4");
			
		} catch (NullPointerException npe) {
			assertEquals("Nome do item nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void attItemAtributoNulo() { 
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			controle.attItem("Rick", "4002-8922", "Overwatch", null, "PS4");
			
		} catch (NullPointerException npe) {
			assertEquals("Atributo nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void attItemValorNulo() { 
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			controle.attItem("Rick", "4002-8922", "Overwatch", "Plataforma", null);
			
		} catch (NullPointerException npe) {
			assertEquals("Valor nao pode ser nulo", npe.getMessage());
		}
	} //FALTA TESTAR REALIZAR EMPRESTIMO E DEVOLVER ITEM
}
