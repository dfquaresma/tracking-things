package sistema;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SistemaTeste {
	private Sistema sistema;
	
	@Before
	public void setUp() {
		this.sistema = new Sistema();
	}
	
	@Test
	public void CadastrarEExibirNomeDoUsuario() {
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		assertEquals("Rick", sistema.getInfoUser("Rick", "4002-8922", "Nome"));
	}


	@Test
	public void CadastrarEExibirTelefoneDoUsuario() {
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		assertEquals("4002-8922", sistema.getInfoUser("Rick", "4002-8922", "Telefone"));
	}

	@Test
	public void CadastrarEExibirEmailDoUsuario() {
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		assertEquals("rick@mail.com", sistema.getInfoUser("Rick", "4002-8922", "Email"));
	}

	@Test
	public void cadastrarUsuarioNomeVazio() {
		
		try {
			sistema.cadastrarUsuario(" ", "4002-8922", "rick@mail.com");

		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void cadastrarUsuarioTelefoneVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "  ", "rick@mail.com");

		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void cadastrarUsuarioEmailVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "  ");

		} catch (IllegalArgumentException iae) {
			assertEquals("Email nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void cadastrarUsuarioNomeNulo() {
		
		try {
			sistema.cadastrarUsuario(null, "4002-8922", "rick@mail.com");

		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void cadastrarUsuarioTelefoneNulo() {
		
		try {
			sistema.cadastrarUsuario("Rick", null, "rick@mail.com");

		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void cadastrarUsuarioEmailNulo() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", null);

		} catch (NullPointerException npe) {
			assertEquals("Email nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void getInfoUserAtributoInvalido() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.getInfoUser("Rick", "4002-8922", "Plataforma");

		} catch (IllegalArgumentException iae) {
			assertEquals("Atributo invalido.", iae.getMessage());
		}
	}

	@Test
	public void attNomeUsuario() {
		
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.attUsuario("Rick", "4002-8922", "Nome", "Morty");
		assertEquals("Morty", sistema.getInfoUser("Morty", "4002-8922", "Nome"));
	}

	@Test
	public void attTelefoneUsuario() {
		
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.attUsuario("Rick", "4002-8922", "Telefone", "0800-721-1530");
		assertEquals("0800-721-1530", sistema.getInfoUser("Rick", "0800-721-1530", "Telefone"));
	}

	@Test
	public void attEmailUsuario() {
		
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.attUsuario("Rick", "4002-8922", "Email", "rick2@mail.com");
		assertEquals("rick2@mail.com", sistema.getInfoUser("Rick", "4002-8922", "Email"));
	}

	@Test
	public void attUsuarioAtributoInvalido() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.attUsuario("Rick", "4002-8922", "Classificacao", "Morty");

		} catch (IllegalArgumentException iae) {
			assertEquals("Atributo invalido", iae.getMessage());
		}
	}

	@Test
	public void attUsuarioNomeVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.attUsuario(" ", "4002-8922", "Nome", "Morty");

		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void attUsuarioTelefoneVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.attUsuario("Rick", " ", "Nome", "Morty");

		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void attUsuarioValorVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.attUsuario("Rick", "4002-8922", "Nome", " ");

		} catch (IllegalArgumentException iae) {
			assertEquals("Valor nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void attUsuarioNomeNulo() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.attUsuario(null, "4002-8922", "Nome", "Morty");

		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void attUsuarioTelefoneNulo() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.attUsuario("Rick", null, "Nome", "Morty");

		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void attUsuarioValorNulo() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.attUsuario("Rick", "4002-8922", "Nome", null);

		} catch (NullPointerException npe) {
			assertEquals("Valor nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void attUsuarioInvalido() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.attUsuario("Morty", "4002-8922", "Nome", "Summer");

		} catch (IllegalArgumentException iae) {
			assertEquals("Usuario invalido", iae.getMessage());
		}
	}

	@Test
	public void removerUsuario() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.removeUsuario("Rick", "4002-8922");

		} catch (NullPointerException npe) {

		}
	}

	@Test
	public void removerUsuarioNomeVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.removeUsuario(" ", "4002-8922");

		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void removerUsuarioTelefoneVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.removeUsuario("Rick", "   ");

		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void cadastrarEletronicoEGetDetalhesItem() {
		
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarEletronico("Rick", "4002-8922", "Bioshock", 35.00, "PC");
		assertEquals("JOGO ELETRONICO: Bioshock, R$ 35.0, Nao emprestado, PC",
				sistema.getDetalhesItem("Rick", "4002-8922", "Bioshock"));
	}

	@Test
	public void cadastrarEletronicoNomeUserVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico(" ", "4002-8922", "Bioshock", 35.00, "PC");
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void cadastrarEletronicoTelefoneUserVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", " ", "Bioshock", 35.00, "PC");
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void cadastrarEletronicoNomeItemVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", " ", 35.00, "PC");
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void cadastrarEletronicoNomeUserNulo() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico(null, "4002-8922", "Bioshock", 35.00, "PC");
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void cadastrarEletronicoTelefoneUserNulo() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", null, "Bioshock", 35.00, "PC");
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void cadastrarEletronicoNomeItemNulo() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", null, 35.00, "PC");
		} catch (NullPointerException npe) {
			assertEquals("Nome do item nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void cadastrarEletronicoPlataformaInvalida() {
		try { 
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com"); 
			sistema.cadastrarEletronico("Rick", "4002-8922", "Bioshock", 35.00, "Gameboy");
		
		} catch (IllegalArgumentException iae) {
			assertEquals("Plataforma inválida", iae.getMessage());
			
		} 
	}
	
	@Test
	public void cadastrarEletronicoPrecoInvalido() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Bioshock", -35.00, "PC");
		} catch (IllegalArgumentException iae) {
			assertEquals("Preco invalido", iae.getMessage());
		}
	}

	@Test
	public void cadastrarJogoTabuleiroEGetDetalhesItem() {
		
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
		assertEquals("JOGO DE TABULEIRO: D&D, R$ 80.0, Nao emprestado, COMPLETO",
				sistema.getDetalhesItem("Rick", "4002-8922", "D&D"));
	}

	@Test
	public void cadastrarJogoTabuleiroNomeUserVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro(" ", "4002-8922", "D&D", 80.00);
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void cadastrarJogoTabuleiroTelefoneUserVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", " ", "D&D", 80.00);
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void cadastrarJogoTabuleiroNomeItemVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", " ", 80.00);
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void cadastrarJogoTabuleiroPrecoInvalido() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", -80.00);
		} catch (IllegalArgumentException iae) {
			assertEquals("Preco invalido", iae.getMessage());
		}
	}

	@Test
	public void cadastrarJogoTabuleiroNomeUserNulo() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro(null, "4002-8922", "D&D", 80.00);
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void cadastrarJogoTabuleiroTelefoneUserNulo() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", null, "D&D", 80.00);
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void cadastrarJogoTabuleiroNomeItemNulo() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", null, 80.00);
		} catch (NullPointerException npe) {
			assertEquals("Nome do item nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void addPecaPerdida() {
		
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
		sistema.addPecaPerdida("Rick", "4002-8922", "D&D", "Dado");
		assertEquals("JOGO DE TABULEIRO: D&D, R$ 80.0, Nao emprestado, COM PECAS PERDIDAS",
				sistema.getDetalhesItem("Rick", "4002-8922", "D&D"));
	}

	@Test
	public void addPecaPerdidaItemInvalido() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			sistema.addPecaPerdida("Rick", "4002-8922", "Munchkin", "Dado");

		} catch (IllegalArgumentException iae) {
			assertEquals("Item nao encontrado", iae.getMessage());
		}
	}

	@Test
	public void addPecaPerdidaNomeUserVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			sistema.addPecaPerdida(" ", "4002-8922", "D&D", "Dado");

		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void addPecaPerdidaTelefoneUserVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			sistema.addPecaPerdida("Rick", " ", "D&D", "Dado");

		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void addPecaPerdidaNomeItemVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			sistema.addPecaPerdida("Rick", "4002-8922", "  ", "Dado");

		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void addPecaPerdidaNomePecaVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			sistema.addPecaPerdida("Rick", "4002-8922", "D&D", " ");

		} catch (IllegalArgumentException iae) {
			assertEquals("Nome da peca nao pode ser vazio", iae.getMessage());
		}
	}

	@Test
	public void addPecaPerdidaNomeUserNulo() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			sistema.addPecaPerdida(null, "4002-8922", "D&D", "Dado");

		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void addPecaPerdidaTelefoneUserNulo() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			sistema.addPecaPerdida("Rick", null, "D&D", "Dado");

		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void addPecaPerdidaNomeItemNulo() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			sistema.addPecaPerdida("Rick", "4002-8922", null, "Dado");

		} catch (NullPointerException npe) {
			assertEquals("Nome do item nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void addPecaPerdidaNomePecaNulo() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarJogoTabuleiro("Rick", "4002-8922", "D&D", 80.00);
			sistema.addPecaPerdida("Rick", "4002-8922", "D&D", null);

		} catch (NullPointerException npe) {
			assertEquals("Nome da peca nao pode ser nulo", npe.getMessage());
		}
	}

	@Test
	public void cadastrarBlurayFilmeEGetDetalhesItem() {
		
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", "DEZ_ANOS", 2000);
		assertEquals("FILME: Sharknado, R$ 10.0, Nao emprestado, 120 min, DEZ_ANOS, COMEDIA, 2000",
				sistema.getDetalhesItem("Rick", "4002-8922", "Sharknado"));
	}

	@Test
	public void cadastrarBlurayFilmeNomeUserVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("  ", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", "DEZ_ANOS", 2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio",iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmeTelefoneUserVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "  ", "Sharknado", 10.00, 120, "COMEDIA", "DEZ_ANOS", 2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio",iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmeNomeFilmeVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "4002-8922", " ", 10.00, 120, "COMEDIA", "DEZ_ANOS", 2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio",iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmePrecoInvalido() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", -10.00, 120, "COMEDIA", "DEZ_ANOS", 2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Preco invalido",iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmeUserInvalido() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Morty", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", "DEZ_ANOS", 2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Usuario invalido",iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmeDuracaoInvalida() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, -120, "COMEDIA", "DEZ_ANOS", 2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Duracao nao pode ser negativa",iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmeGeneroInvalido() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "BATATA", "DEZ_ANOS", 2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Genero inválido",iae.getMessage());
		}
	}

	@Test
	public void cadastrarBlurayFilmeGeneroVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "  ", "DEZ_ANOS", 2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Genero nao pode ser vazio",iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmeGeneroNulo() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, null, "DEZ_ANOS", 2000);
		} catch (NullPointerException npe) {
			assertEquals("Genero nao pode ser nulo",npe.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmeClassificacaoInvalida() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", "VINTE_ANOS", 2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao inválida",iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmeClassificacaoVazia() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", " ", 2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao nao pode ser vazio",iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmeClassificacaoNula() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", null, 2000);
		} catch (NullPointerException npe) {
			assertEquals("Classificacao nao pode ser nulo",npe.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayFilmeAnoInvalido() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayFilme("Rick", "4002-8922", "Sharknado", 10.00, 120, "COMEDIA", "DEZ_ANOS", -2000);
		} catch (IllegalArgumentException iae) {
			assertEquals("Ano nao pode ser negativo",iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBluraySerieEGetDetalhesItem() {
		
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 666.00, "Loucura total", 120, "DEZESSEIS_ANOS", "FICCAO", 1);
		assertEquals("SERIE: Rick e Morty, R$ 666.0, Nao emprestado, 120 min, DEZESSEIS_ANOS, FICCAO, Temporada 1",
				sistema.getDetalhesItem("Rick", "4002-8922", "Rick e Morty"));
	}
	
	@Test
	public void cadastrarBluraySerieNomeUserVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("  ", "4002-8922", "Rick e Morty", 666.00, "Loucura total", 120, "DEZESSEIS_ANOS", "FICCAO", 1);
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBluraySerieTelefoneUserVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "  ", "Rick e Morty", 666.00, "Loucura total", 120, "DEZESSEIS_ANOS", "FICCAO", 1);
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBluraySerieNomeItemVazio() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", " ", 666.00, "Loucura total", 120, "DEZESSEIS_ANOS", "FICCAO", 1);
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBluraySeriePrecoInvalido() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", -666.00, "Loucura total", 120, "DEZESSEIS_ANOS", "FICCAO", 1);
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Preco invalido", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBluraySerieDescricaoVazia() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 666.00, " ", 120, "DEZESSEIS_ANOS", "FICCAO", 1);
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Descricao nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBluraySerieDuracaoInvalida() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 666.00, "Loucura total", -120, "DEZESSEIS_ANOS", "FICCAO", 1);
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Duracao nao pode ser negativa", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBluraySerieClassificacaoInvalida() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 666.00, "Loucura total", 120, "VINTE_ANOS", "FICCAO", 1);
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao inválida", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBluraySerieClassificacaoVazia() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 666.00, "Loucura total", 120, "  ", "FICCAO", 1);
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBluraySerieClassificacaoNula() {
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 666.00, "Loucura total", 120, null, "FICCAO", 1);
			
		} catch (NullPointerException npe) {
			assertEquals("Classificacao nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowEGetDetalhesItem(){
		
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 12, "Safadao", "LIVRE");
		assertEquals("SHOW: Safadao DVD, R$ 30.0, Nao emprestado, 100 min, LIVRE, Safadao, 12 faixas", sistema.getDetalhesItem("Rick", "4002-8922", "Safadao DVD"));
		
	}
	
	@Test
	public void cadastrarBlurayShowNomeUserVazio(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow(" ", "4002-8922", "Safadao DVD", 30.00, 100, 12, "Safadao", "LIVRE");			
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}
		
	@Test
	public void cadastrarBlurayShowTelefoneUserVazio(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", " ", "Safadao DVD", 30.00, 100, 12, "Safadao", "LIVRE");			
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowNomeItemVazio(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", " ", 30.00, 100, 12, "Safadao", "LIVRE");			
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowPrecoInvalido(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", -30.00, 100, 12, "Safadao", "LIVRE");			
		} catch (IllegalArgumentException iae) {
			assertEquals("Preco invalido", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowDuracaoInvalida(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, -100, 12, "Safadao", "LIVRE");			
		} catch (IllegalArgumentException iae) {
			assertEquals("Duracao nao pode ser negativa", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowFaixasNegativo(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, -12, "Safadao", "LIVRE");			
		} catch (IllegalArgumentException iae) {
			assertEquals("Numero de faixas nao pode ser menor ou igual a zero.", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowFaixasZero(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 0, "Safadao", "LIVRE");			
		} catch (IllegalArgumentException iae) {
			assertEquals("Numero de faixas nao pode ser menor ou igual a zero.", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowArtistaVazio(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 12, " ", "LIVRE");			
		} catch (IllegalArgumentException iae) {
			assertEquals("Artista nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowClassificacaoInvalida(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 12, "Safadao", "BATATA");			
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao inválida", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowClassificacaoVazia(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 12, "Safadao", " ");			
		} catch (IllegalArgumentException iae) {
			assertEquals("Classificacao nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowClassificacaoNula(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 12, "Safadao", null);			
		} catch (NullPointerException npe) {
			assertEquals("Classificacao nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowNomeUserNulo(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow(null, "4002-8922", "Safadao DVD", 30.00, 100, 12, "Safadao", "LIVRE");			
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowTelefoneUserNula(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", null, "Safadao DVD", 30.00, 100, 12, "Safadao", "LIVRE");			
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayShowNomeItemNulo(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", null, 30.00, 100, 12, "Safadao", "LIVRE");			
		} catch (NullPointerException npe) {
			assertEquals("Nome do item nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void cadastrarBlurayArtistaNulo(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBlurayShow("Rick", "4002-8922", "Safadao DVD", 30.00, 100, 12, null, "LIVRE");			
		} catch (NullPointerException npe) {
			assertEquals("Artista nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void getInfoUserInvalido(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.getInfoUser("Morty", "4002-8922", "Nome");
		} catch (IllegalArgumentException iae) {
			assertEquals("Usuario invalido", iae.getMessage());
		}
	}
	
	@Test
	public void getInfoItemNome(){
		
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarEletronico("Rick", "4002-8922", "GTA V", 200.00, "PS4");
		assertEquals("GTA V",sistema.getInfoItem("Rick", "4002-8922", "GTA V", "Nome") );
	}
	
	@Test
	public void getInfoItemPreco(){
		
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarEletronico("Rick", "4002-8922", "GTA V", 200.00, "PS4");
		assertEquals("200.0",sistema.getInfoItem("Rick", "4002-8922", "GTA V", "Preco") );
	}
	
	@Test
	public void getInfoItemPlataforma(){
		
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarEletronico("Rick", "4002-8922", "GTA V", 200.00, "PS4");
		assertEquals("PS4",sistema.getInfoItem("Rick", "4002-8922", "GTA V", "Plataforma"));
	}
	
	@Test
	public void getInfoItemAtributoInvalido(){
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "GTA V", 200.00, "PS4");
			sistema.getInfoItem("Rick", "4002-8922", "GTA V", "Classificacao");
			fail();
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Atributo invalido.", iae.getMessage());// TÁ SEM MENSAGEM
		}
	} 
	
	@Test
	public void addBluray(){
		
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
		sistema.addBluray("Rick", "4002-8922", "Rick e Morty", 22);
	}
	
	@Test
	public void addBluraySerieInvalida(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.addBluray("Rick", "4002-8922", "CDZ", 22);
		} catch (IllegalArgumentException iae) {
			assertEquals("Item nao encontrado", iae.getMessage());
		}
	}
	
	@Test
	public void addBlurayNomeUserVazio(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.addBluray(" ", "4002-8922", "CDZ", 22);
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void addBlurayTelefoneUserVazio(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.addBluray("Rick", "  ", "CDZ", 22);
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void addBlurayEpisodioVazio(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.addBluray("Rick", "4002-8922", " ", 22);
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do bluray nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void addBlurayDuracaoInvalida(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.addBluray("Rick", "4002-8922", "Rick e Morty", -22);
		} catch (IllegalArgumentException iae) {
			assertEquals("Duracao nao pode ser negativa", iae.getMessage());
		}
	}
	
	@Test
	public void addBlurayNomeUserNulo(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.addBluray(null, "4002-8922", "Rick e Morty", 22);
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void addBlurayTelefoneUserNulo(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.addBluray("Rick", null, "Rick e Morty", 22);
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void addBlurayNomeBlurayNulo(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.addBluray("Rick", "4002-8922", null, 22);
		} catch (NullPointerException npe) {
			assertEquals("Nome do bluray nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void addBlurayUsuarioInvalido(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.addBluray("Morty", "4002-8922", "Rick e Morty", 22);
		} catch (IllegalArgumentException iae) {
			assertEquals("Usuario invalido", iae.getMessage());
		}
	}
	
	@Test
	public void removerItem(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.removerItem("Rick", "4002-8922", "Rick e Morty");
		} catch (NullPointerException npe) {
		}
	}
	
	@Test
	public void removerItemNomeNulo(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.removerItem(null, "4002-8922", "Rick e Morty");
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void removerItemTelefoneNulo(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.removerItem("Rick", null, "Rick e Morty");
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void removerItemNomeItemNulo(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.removerItem("Rick", "4002-8922", null);
		} catch (NullPointerException npe) {
			assertEquals("Nome do item nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void removerItemNomeVazio(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.removerItem(" ", "4002-8922", "Rick e Morty");
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void removerItemTelefoneVazio(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.removerItem("Rick", "  ", "Rick e Morty");
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void removerItemNomeItemVazio(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.removerItem("Rick", "4002-8922", "  ");
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void removerItemUsuarioInvalido(){
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarBluRaySerie("Rick", "4002-8922", "Rick e Morty", 50.00, "Loucura total", 100, "DEZESSEIS_ANOS", "FICCAO", 1);
			sistema.removerItem("Morty", "4002-8922", "Rick e Morty");
		} catch (IllegalArgumentException iae) {
			assertEquals("Usuario invalido", iae.getMessage());
		}
	}
	
	@Test
	public void attNomeItem() { //DEU ERRO AQUI
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
		assertEquals("Overwatch", sistema.getInfoItem("Rick", "4002-8922", "Overwatch", "Nome"));
		
		sistema.attItem("Rick", "4002-8922", "Overwatch", "Nome", "Jogo caro da Blizzard");
		assertEquals("Jogo caro da Blizzard", sistema.getInfoItem("Rick", "4002-8922", "Jogo caro da Blizzard", "Nome"));

	}
	
	@Test
	public void attPrecoItem() { 
		
		sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
		sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
		sistema.attItem("Rick", "4002-8922", "Overwatch", "Preco", "250.0");
		assertEquals("250.0", sistema.getInfoItem("Rick", "4002-8922", "Overwatch", "Preco"));
	}
	
	@Test
	public void attItemAtributoInvalido() { 
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem("Rick", "4002-8922", "Overwatch", "Plataforma", "PS4");
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Atributo invalido", iae.getMessage());
		}
	}
	
	@Test
	public void attItemNomeVazio() { 
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem(" ", "4002-8922", "Overwatch", "Plataforma", "PS4");
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void attItemTelefoneVazio() { 
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem("Rick", "  ", "Overwatch", "Plataforma", "PS4");
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Telefone nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void attItemNomeItemVazio() { 
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem("Rick", "4002-8922", " ", "Plataforma", "PS4");
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome do item nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void attItemAtributoVazio() { 
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem("Rick", "4002-8922", "Overwatch", " ", "PS4");
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Atributo nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void attItemValorVazio() { 
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem("Rick", "4002-8922", "Overwatch", "Plataforma", "  ");
			
		} catch (IllegalArgumentException iae) {
			assertEquals("Valor nao pode ser vazio", iae.getMessage());
		}
	}
	
	@Test
	public void attItemNomeNulo() { 
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem(null, "4002-8922", "Overwatch", "Plataforma", "PS4");
			
		} catch (NullPointerException npe) {
			assertEquals("Nome nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void attItemTelefoneNulo() { 
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem("Rick", null, "Overwatch", "Plataforma", "PS4");
			
		} catch (NullPointerException npe) {
			assertEquals("Telefone nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void attItemNomeItemNulo() { 
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem("Rick", "4002-8922", null, "Plataforma", "PS4");
			
		} catch (NullPointerException npe) {
			assertEquals("Nome do item nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void attItemAtributoNulo() { 
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem("Rick", "4002-8922", "Overwatch", null, "PS4");
			
		} catch (NullPointerException npe) {
			assertEquals("Atributo nao pode ser nulo", npe.getMessage());
		}
	}
	
	@Test
	public void attItemValorNulo() { 
		
		try {
			sistema.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			sistema.cadastrarEletronico("Rick", "4002-8922", "Overwatch", 200.0, "PC");
			sistema.attItem("Rick", "4002-8922", "Overwatch", "Plataforma", null);
			
		} catch (NullPointerException npe) {
			assertEquals("Valor nao pode ser nulo", npe.getMessage());
		}
	} //FALTA TESTAR REALIZAR EMPRESTIMO E DEVOLVER ITEM
}
