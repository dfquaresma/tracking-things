package usuario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import item.Item;

public class UsuarioTest {

	Usuario usuario;
	
	@Before
	public void Inicializa() {
		this.usuario = new Usuario("Ícaro", "+55 (83) 9.9384-7651", "icaro.lima@ccc.ufcg.edu.br"); 
	}

	@Test
	public void testCadastrarEletronico() {
		this.usuario.cadastrarEletronico("GTA San Andreas", 34.99, "PC");
	}

	@Test
	public void testCadastrarJogoTabuleiro() {
		this.usuario.cadastrarJogoTabuleiro("Jogo da Vida", 100.0);
	}

	@Test
	public void testAddPecaPerdida() {
		this.testCadastrarJogoTabuleiro();
		
		this.usuario.addPecaPerdida("Jogo da Vida", "Carro (azul)");
		this.usuario.addPecaPerdida("Jogo da Vida", "Nota ($100)");
	}

	@Test
	public void testCadastrarBlurayFilme() {
		this.usuario.cadastrarBlurayFilme("O Senhor dos Anéis I", 230, 95, "FICCAO", "QUATORZE_ANOS", 2001);
	}

	@Test
	public void testCadastrarBluRaySerie() {
		this.usuario.cadastrarBluRaySerie("Game of Thrones", 12, "Eu não sei descrever", 1200, "DEZESSEIS_ANOS", "AVENTURA", 8);
	}

	@Test
	public void testCadastrarBlurayShow() {
		this.usuario.cadastrarBlurayShow("Show do Safadão", 49.99, 120, 20, "Wesley Safadão", "DEZ_ANOS");
	}

	@Test
	public void testAddBlueray() {
		this.testCadastrarBluRaySerie();
		
		this.usuario.addBlueray("Game of Thrones", 60);
		this.usuario.addBlueray("Game of Thrones", 60);
		this.usuario.addBlueray("Game of Thrones", 60);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testRemoverItem() {
		this.testCadastrarBlurayShow();
		this.usuario.removerItem("Show do Safadão");
		
		this.usuario.getInfoItem("Show do Safadão", "Nome");
	}

	@Test
	public void testPegaItem() {
		this.testCadastrarBlurayFilme();
		
		Item item = this.usuario.pegaItem("O Senhor dos Anéis I");
		
		assertEquals("O nome do Item não confere.", "O Senhor dos Anéis I", item.getNome());
	}

	@Test
	public void testAttItem() {
		this.testCadastrarBlurayFilme();
		
		this.usuario.attItem("O Senhor dos Anéis I", "Nome", "The Lord of the Rings I");
		this.usuario.attItem("The Lord of the Rings I", "Preco", "30");
		
		Item item = this.usuario.pegaItem("The Lord of the Rings I");
		
		assertEquals("O valor difere.", 30, item.getValor(), 0.00001);
	}

	@Test
	public void testGetInfoItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDetalhesItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testEmprestaItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetItens() {
		fail("Not yet implemented");
	}

	@Test
	public void testDevolveItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testVerificaPreco() {
		fail("Not yet implemented");
	}

}
