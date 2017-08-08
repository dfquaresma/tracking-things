package usuario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import item.Item;

public class UsuarioTest {

	Usuario usuario;
	Usuario usuario2;
	
	@Before
	public void Inicializa() {
		this.usuario = new Usuario("Ícaro", "+55 (83) 9.9384-7651", "icaro.lima@ccc.ufcg.edu.br"); 
		this.usuario2 = new Usuario("David", "+55 (83) 9.1234-5678", "david.quaresma@ccc.ufcg.edu.br");
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
		
		Item item = this.usuario.getItem("O Senhor dos Anéis I");
		
		assertEquals("O nome do Item não confere.", "O Senhor dos Anéis I", item.getNome());
	}

	@Test
	public void testAttItem() {
		this.testCadastrarBlurayFilme();
		
		this.usuario.attItem("O Senhor dos Anéis I", "Nome", "The Lord of the Rings I");
		this.usuario.attItem("The Lord of the Rings I", "Preco", "30");
		
		Item item = this.usuario.getItem("The Lord of the Rings I");
		
		assertEquals("O valor difere.", 30, item.getValor(), 0.00001);
	}

	@Test
	public void testGetDetalhesItem() {
		this.testCadastrarBlurayFilme();
		this.testCadastrarBluRaySerie();
		this.testCadastrarJogoTabuleiro();
		this.testCadastrarBlurayShow();
		this.testCadastrarEletronico();
		
		assertEquals("FILME: O Senhor dos Anéis I, R$ 230.0, Nao emprestado, 95 min, QUATORZE_ANOS, FICCAO, 2001", this.usuario.getDetalhesItem("O Senhor dos Anéis I"));
		assertEquals("SERIE: Game of Thrones, R$ 12.0, Nao emprestado, 1200 min, DEZESSEIS_ANOS, AVENTURA, Temporada 8", this.usuario.getDetalhesItem("Game of Thrones"));
		assertEquals("JOGO DE TABULEIRO: Jogo da Vida, R$ 100.0, Nao emprestado, COMPLETO", this.usuario.getDetalhesItem("Jogo da Vida"));
		assertEquals("SHOW: Show do Safadão, R$ 49.99, Nao emprestado, 120 min, DEZ_ANOS, Wesley Safadão, 20 faixas", this.usuario.getDetalhesItem("Show do Safadão"));
		assertEquals("JOGO ELETRONICO: GTA San Andreas, R$ 34.99, Nao emprestado, PC", this.usuario.getDetalhesItem("GTA San Andreas"));
	}

	@Test
	public void testEmprestaItem() {
		this.testCadastrarEletronico();
	
		//this.usuario.emprestaItem("GTA San Andreas", "06/08/2017", 4, this.usuario2);
		
		//assertEquals(true, this.usuario.getItens().get(0).isEmprestado());
	}

	@Test
	public void testDevolveItem() {
		this.testEmprestaItem();	
		Usuario user = new Usuario("Ícaro", "+55 (83) 9.9384-7651", "icaro.gamer@gmail.com");
		this.usuario2.devolveItem("GTA San Andreas", "06/08/2017", "07/08/2017", user);
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
