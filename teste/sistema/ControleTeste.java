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
		assertEquals("JOGO ELETRONICO: Bioshock, R$ 35.0, Nao emprestado, PC", controle.getDetalhesItem("Rick", "4002-8922", "Bioshock"));
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
	
	/*@Test VER O RETORNO DISSO AQUI
	public void cadastrarEletronicoPlataformaInvalida() {
		Controller controle = new Controller();
		try {
			controle.cadastrarUsuario("Rick", "4002-8922", "rick@mail.com");
			controle.cadastrarEletronico("Rick", "4002-8922", "Bioshock", 35.00, "Gameboy");			
		} catch (IllegalArgumentException iae) {
			assertEquals("", iae.getMessage());
		
		}
	}*/
	
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
		assertEquals("JOGO DE TABULEIRO: D&D, R$ 80.0, Nao emprestado, COMPLETO", controle.getDetalhesItem("Rick", "4002-8922", "D&D"));
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
		assertEquals("JOGO DE TABULEIRO: D&D, R$ 80.0, Nao emprestado, COM PECAS PERDIDAS", controle.getDetalhesItem("Rick", "4002-8922", "D&D"));
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
		assertEquals("FILME: Sharknado, R$ 10.0, Nao emprestado, 120 min, DEZ_ANOS, COMEDIA, 2000", controle.getDetalhesItem("Rick", "4002-8922", "Sharknado"));
	}
	
}
