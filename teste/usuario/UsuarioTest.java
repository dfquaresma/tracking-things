package usuario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import item.Item;

/**
 * Testa as funcionalidades da classe Usuario.
 * 
 * @author David Ferreira
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
	 * Testa se está cadastrando um eletrônico.
	 */
	@Test
	public void testCadastrarEletronico() {
		this.usuario.cadastrarEletronico("GTA San Andreas", 34.99, "PC");
	}

	/**
	 * Testa cadastrarEletronico quando o nome do item é vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarEletronicoNomeItemVazio() {
		this.usuario.cadastrarEletronico("", 34.99, "PC");
	}

	/**
	 * Testa cadastrarEletronico quando o nome do item é vazio com espaços.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarEletronicoNomeItemVazioComEspacos() {
		this.usuario.cadastrarEletronico("      ", 34.99, "PC");
	}

	/**
	 * Testa cadastrarEletronico quando o nome do item é nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastrarEletronicoNomeItemNulo() {
		this.usuario.cadastrarEletronico(null, 34.99, "PC");
	}

	/**
	 * Testa se está cadastrando um jogo de tabuleiro.
	 */
	@Test
	public void testCadastrarJogoTabuleiro() {
		this.usuario.cadastrarJogoTabuleiro("Jogo da Vida", 100.0);
	}

	/**
	 * Testa cadastrarJogoTabuleiro com nome do item vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarJogoTabuleiroNomeItemVazio() {
		this.usuario.cadastrarJogoTabuleiro("", 100.0);
	}

	/**
	 * Testa cadastrarJogoTabuleiro com nome do item vazio e com espaços.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarJogoTabuleiroNomeItemVazioComEspacos() {
		this.usuario.cadastrarJogoTabuleiro("    ", 100.0);
	}

	/**
	 * Testa cadastrarJogoTabuleiro com nome do item nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastrarJogoTabuleiroNomeItemNulo() {
		this.usuario.cadastrarJogoTabuleiro(null, 100.0);
	}

	/**
	 * Testa se está adicionando peça perdida em um jogo de tabuleiro.
	 */
	@Test
	public void testAddPecaPerdida() {
		this.testCadastrarJogoTabuleiro();

		this.usuario.addPecaPerdida("Jogo da Vida", "Carro (azul)");
		this.usuario.addPecaPerdida("Jogo da Vida", "Nota ($100)");
	}

	/**
	 * Testa addPecaPerdida quando o nome do item é vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddPecaPerdidaNomeItemVazio() {
		this.testCadastrarJogoTabuleiro();

		this.usuario.addPecaPerdida("", "Carro (azul)");
	}

	/**
	 * Testa addPecaPerdida quando o nome do item é vazio e com espaços.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddPecaPerdidaNomeItemVazioComEspacos() {
		this.testCadastrarJogoTabuleiro();

		this.usuario.addPecaPerdida("       ", "Carro (azul)");
	}

	/**
	 * Testa addPecaPerdida quando o nome do item é nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testAddPecaPerdidaNomeItemNulo() {
		this.testCadastrarJogoTabuleiro();

		this.usuario.addPecaPerdida(null, "Carro (azul)");
	}

	/**
	 * Testa addPecaPerdida quando o nome da peça é vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddPecaPerdidaNomePecaVazio() {
		this.testCadastrarJogoTabuleiro();

		this.usuario.addPecaPerdida("Jogo da Vida", "");
	}

	/**
	 * Testa addPecaPerdida quando o nome da peça é vazia e com espaços.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddPecaPerdidaNomePecaVazioComEspacos() {
		this.testCadastrarJogoTabuleiro();

		this.usuario.addPecaPerdida("Jogo da Vida", "    ");
	}

	/**
	 * Testa addPecaPerdida quando o nome da peça é nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testAddPecaPerdidaNomePecaNulo() {
		this.testCadastrarJogoTabuleiro();

		this.usuario.addPecaPerdida("Jogo da Vida", null);
	}

	/**
	 * Testa se está cadastrando blueray de filme.
	 */
	@Test
	public void testCadastrarBlurayFilme() {
		this.usuario.cadastrarBlurayFilme("O Senhor dos Anéis I", 230, 95, "FICCAO", "QUATORZE_ANOS", 2001);
	}

	/**
	 * Testa cadastrarBluerayFilme quando o nome do filme é vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarBlurayFilmeNomeItemVazio() {
		this.usuario.cadastrarBlurayFilme("", 230, 95, "FICCAO", "QUATORZE_ANOS", 2001);
	}

	/**
	 * Testa cadastrarBluerayFilme quando o nome do filme é vazio e com espaços.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarBlurayFilmeNomeItemVazioComEspacos() {
		this.usuario.cadastrarBlurayFilme("   ", 230, 95, "FICCAO", "QUATORZE_ANOS", 2001);
	}

	/**
	 * Testa cadastrarBluerayFilme quando o nome do filme é nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastrarBlurayFilmeNomeItemNulo() {
		this.usuario.cadastrarBlurayFilme(null, 230, 95, "FICCAO", "QUATORZE_ANOS", 2001);
	}

	/**
	 * Testa cadastrarBluerayFilme quando o valor é nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarBlurayFilmePrecoNulo() {
		this.usuario.cadastrarBlurayFilme("Filmezao", 0, 95, "FICCAO", "QUATORZE_ANOS", 2001);
	}

	/**
	 * Testa cadastrarBluerayFilme quando o valor é negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarBlurayFilmePrecoNegativo() {
		this.usuario.cadastrarBlurayFilme("Filmezao", -1, 95, "FICCAO", "QUATORZE_ANOS", 2001);
	}

	/**
	 * Testa cadastrarBluerayFilme quando a duração é nula.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarBlurayFilmeDuracaoNula() {
		this.usuario.cadastrarBlurayFilme("Filmezao", 230, 0, "FICCAO", "QUATORZE_ANOS", 2001);
	}

	/**
	 * Testa cadastrarBluerayFilme quando a duração é negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarBlurayFilmeNomeItemDuracaoNegativa() {
		this.usuario.cadastrarBlurayFilme("Filmezao", 230, -1, "FICCAO", "QUATORZE_ANOS", 2001);
	}

	/**
	 * Testa cadastrarBluerayFilme quando o genero é vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarBlurayFilmeGenroVazio() {
		this.usuario.cadastrarBlurayFilme("Filmezao", 230, 95, "", "QUATORZE_ANOS", 2001);
	}

	/**
	 * Testa cadastrarBluerayFilme quando o genero é vazio e com espaços.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarBlurayFilmeGeneroVazioComEspacos() {
		this.usuario.cadastrarBlurayFilme("Filmezao", 230, 95, " ", "QUATORZE_ANOS", 2001);
	}

	/**
	 * Testa cadastrarBluerayFilme quando o genero é nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastrarBlurayFilmeGeneroNulo() {
		this.usuario.cadastrarBlurayFilme("Filmezao", 230, 95, null, "QUATORZE_ANOS", 2001);
	}

	/**
	 * Testando todos os gêneros.
	 */
	@Test
	public void testCadastrarBlurayFilmeGeneroTodos() {
		this.usuario.cadastrarBlurayFilme("00", 230, 95, "ACAO", "QUATORZE_ANOS", 2001);
		this.usuario.cadastrarBlurayFilme("01", 230, 95, "ANIMACAO", "QUATORZE_ANOS", 2001);
		this.usuario.cadastrarBlurayFilme("02", 230, 95, "AVENTURA", "QUATORZE_ANOS", 2001);
		this.usuario.cadastrarBlurayFilme("03", 230, 95, "COMEDIA", "QUATORZE_ANOS", 2001);
		this.usuario.cadastrarBlurayFilme("04", 230, 95, "DOCUMENTARIO", "QUATORZE_ANOS", 2001);
		this.usuario.cadastrarBlurayFilme("05", 230, 95, "DRAMA", "QUATORZE_ANOS", 2001);
		this.usuario.cadastrarBlurayFilme("06", 230, 95, "EROTICO", "QUATORZE_ANOS", 2001);
		this.usuario.cadastrarBlurayFilme("07", 230, 95, "FAROESTE", "QUATORZE_ANOS", 2001);
		this.usuario.cadastrarBlurayFilme("08", 230, 95, "FICCAO", "QUATORZE_ANOS", 2001);
		this.usuario.cadastrarBlurayFilme("09", 230, 95, "MUSICAL", "QUATORZE_ANOS", 2001);
		this.usuario.cadastrarBlurayFilme("10", 230, 95, "OUTRO", "QUATORZE_ANOS", 2001);
		this.usuario.cadastrarBlurayFilme("11", 230, 95, "POLICIAL", "QUATORZE_ANOS", 2001);
		this.usuario.cadastrarBlurayFilme("12", 230, 95, "ROMANCE", "QUATORZE_ANOS", 2001);
		this.usuario.cadastrarBlurayFilme("13", 230, 95, "SUSPENSE", "QUATORZE_ANOS", 2001);
		this.usuario.cadastrarBlurayFilme("14", 230, 95, "TERROR", "QUATORZE_ANOS", 2001);
	}

	/**
	 * Testa cadastrarBluerayFilme quando a classificação é vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarBlurayFilmeClassificacaoVazio() {
		this.usuario.cadastrarBlurayFilme("Filmezao", 230, 95, "TERROR", "", 2001);
	}

	/**
	 * Testa cadastrarBluerayFilme quando a classificação é vazia e com espaços.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarBlurayFilmeClassificacaoVazioComEspacos() {
		this.usuario.cadastrarBlurayFilme("Filmezao", 230, 95, "TERROR", " ", 2001);
	}

	/**
	 * Testa cadastrarBluerayFilme quando a classificação é nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastrarBlurayFilmeClassificacaoNulo() {
		this.usuario.cadastrarBlurayFilme("Filmezao", 230, 95, "TERROR", null, 2001);
	}

	/**
	 * Testa todas as classificações.
	 */
	@Test
	public void testCadastrarBlurayFilmeClassificacaoTodas() {
		this.usuario.cadastrarBlurayFilme("00", 230, 95, "ACAO", "DEZ_ANOS", 2001);
		this.usuario.cadastrarBlurayFilme("01", 230, 95, "ANIMACAO", "DEZESSEIS_ANOS", 2001);
		this.usuario.cadastrarBlurayFilme("02", 230, 95, "AVENTURA", "DEZOITO_ANOS", 2001);
		this.usuario.cadastrarBlurayFilme("03", 230, 95, "COMEDIA", "DOZE_ANOS", 2001);
		this.usuario.cadastrarBlurayFilme("04", 230, 95, "DOCUMENTARIO", "LIVRE", 2001);
		this.usuario.cadastrarBlurayFilme("05", 230, 95, "DRAMA", "QUATORZE_ANOS", 2001);
	}

	/**
	 * Testa quando o ano é nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarBlurayFilmeAnoNulo() {
		this.usuario.cadastrarBlurayFilme("05", 230, 95, "DRAMA", "QUATORZE_ANOS", 0);
	}

	/**
	 * Testa quando o ano é negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarBlurayFilmeAnoNegativo() {
		this.usuario.cadastrarBlurayFilme("05", 230, 95, "DRAMA", "QUATORZE_ANOS", -1);
	}

	/**
	 * Testa se está cadastrando blueray de série.
	 */
	@Test
	public void testCadastrarBluRaySerie() {
		this.usuario.cadastrarBluRaySerie("Game of Thrones", 12, "Eu não sei descrever", 1200, "DEZESSEIS_ANOS",
				"AVENTURA", 8);
	}

	/**
	 * Testa se está cadastrando blueray de show.
	 */
	@Test
	public void testCadastrarBlurayShow() {
		this.usuario.cadastrarBlurayShow("Show do Safadão", 49.99, 120, 20, "Wesley Safadão", "DEZ_ANOS");
	}

	/**
	 * Testa se está adicionando blueray em uma série.
	 */
	@Test
	public void testAddBlueray() {
		this.testCadastrarBluRaySerie();

		this.usuario.addBlueray("Game of Thrones", 60);
		this.usuario.addBlueray("Game of Thrones", 60);
		this.usuario.addBlueray("Game of Thrones", 60);
	}

	/**
	 * Testa se está dando erro ao tentar pegar informação de um item que não
	 * existe mais.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRemoverItem() {
		this.testCadastrarBlurayShow();
		this.usuario.removerItem("Show do Safadão");

		this.usuario.getInfoItem("Show do Safadão", "Nome");
	}

	/**
	 * Testa se está pegando item normalmente.
	 */
	@Test
	public void testPegaItem() {
		this.testCadastrarBlurayFilme();

		Item item = this.usuario.getItem("O Senhor dos Anéis I");
		assertEquals("O nome do Item não confere.", "O Senhor dos Anéis I", item.getNome());
	}

	/**
	 * Testa se está conseguindo pegar os atributos padrões de um item.
	 */
	@Test
	public void testAttItem() {
		this.testCadastrarBlurayFilme();

		this.usuario.attItem("O Senhor dos Anéis I", "Nome", "The Lord of the Rings I");
		this.usuario.attItem("The Lord of the Rings I", "Preco", "30");

		Item item = this.usuario.getItem("The Lord of the Rings I");

		assertEquals("O valor difere.", 30, item.getPreco(), 0.00001);
	}

	/**
	 * Testa se está conseguindo pegar os detalhes de um item em String.
	 */
	@Test
	public void testGetDetalhesItem() {
		this.testCadastrarBlurayFilme();
		this.testCadastrarBluRaySerie();
		this.testCadastrarJogoTabuleiro();
		this.testCadastrarBlurayShow();
		this.testCadastrarEletronico();

		assertEquals("FILME: O Senhor dos Anéis I, R$ 230.0, Nao emprestado, 95 min, QUATORZE_ANOS, FICCAO, 2001",
				this.usuario.getDetalhesItem("O Senhor dos Anéis I"));
		assertEquals("SERIE: Game of Thrones, R$ 12.0, Nao emprestado, 1200 min, DEZESSEIS_ANOS, AVENTURA, Temporada 8",
				this.usuario.getDetalhesItem("Game of Thrones"));
		assertEquals("JOGO DE TABULEIRO: Jogo da Vida, R$ 100.0, Nao emprestado, COMPLETO",
				this.usuario.getDetalhesItem("Jogo da Vida"));
		assertEquals("SHOW: Show do Safadão, R$ 49.99, Nao emprestado, 120 min, DEZ_ANOS, Wesley Safadão, 20 faixas",
				this.usuario.getDetalhesItem("Show do Safadão"));
		assertEquals("JOGO ELETRONICO: GTA San Andreas, R$ 34.99, Nao emprestado, PC",
				this.usuario.getDetalhesItem("GTA San Andreas"));
	}

	/**
	 * Testa se está emprestando item normalmente, testando se ao emprestar, o
	 * item se torna "emprestado".
	 */
	@Test
	public void testEmprestaItem() {
		this.testCadastrarEletronico();

		Item item = this.usuario.getItem("GTA San Andreas");
		Emprestimo emprestimo = new Emprestimo(this.usuario, this.usuario2, item, "06/08/2017", 7);
		this.usuario.emprestaItem(item.getNome(), this.usuario2, emprestimo);
		assertTrue(this.usuario.getItem("GTA San Andreas").isEmprestado());
	}

	/**
	 * Apenas testa se não está dando erro no devolveItem.
	 */
	@Test
	public void testDevolveItem() {
		this.testEmprestaItem();
		this.usuario2.devolveItem("GTA San Andreas", "06/08/2017", "07/08/2017", this.usuario);
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
