package item;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import item.bluray.Filme;
import item.bluray.Show;
import item.bluray.Temporada;
import item.comparator.ItemComparatorNome;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;
import usuario.Usuario;

/**
 * Testa as funcionalidades da clase ItemControllerTest.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class ItemControllerTest {
	private ItemController controller;

	/**
	 * Inicializa um ItemController antes de cada método marcado com @Test.
	 */
	@Before
	public void setUp() {
		this.controller = new ItemController();
	}

	/**
	 * Testa se está cadastrando um Eletronico.
	 */
	@Test
	public void testCadastrarEletronico() {
		JogoEletronico jogo = new JogoEletronico("Dota 2", 20, "PC");
		Item jogoTest = this.controller.cadastrarEletronico("Dota 2", 20, "PC");
		assertEquals(jogoTest, jogo);
	}

	/**
	 * Testa se está cadastrando JogoTabuleiro.
	 */
	@Test
	public void testCadastrarJogoTabuleiro() {
		JogoTabuleiro jogo = new JogoTabuleiro("Xadrez", 20);
		Item jogoTest = this.controller.cadastrarJogoTabuleiro("Xadrez", 20);
		assertEquals(jogoTest, jogo);
	}

	/**
	 * Testa se está cadastrando um Blueray de Filme.
	 */
	@Test
	public void testCadastrarBlurayFilme() {
		Filme filme = new Filme("Senhor do aneis", 9999999, 9999999, "FICCAO", "DEZ_ANOS", 2002);
		Item filmeTest = this.controller.cadastrarBlurayFilme("Senhor do aneis", 9999999, 9999999, "FICCAO", "DEZ_ANOS",
				2002);
		assertEquals(filmeTest, filme);
	}

	/**
	 * Testa se está cadastrando um Blueray de Serie.
	 */
	@Test
	public void testCadastrarBluRaySerie() {
		Temporada temporada = new Temporada("GoT", 999999, "Sem comentários", 67, "DEZ_ANOS", "FICCAO", 1);
		Item temporadaTest = this.controller.cadastrarBluRaySerie("GoT", 999999, "Sem comentários", 67, "DEZ_ANOS",
				"FICCAO", 1);
		assertEquals(temporadaTest, temporada);
	}

	/**
	 * Testa se está cadastrando um Blueray de Show.
	 */
	@Test
	public void testCadastrarBlurayShow() {
		Show show = new Show("AC_DC Live", 10000, 120, 12, "AC DC", "DEZ_ANOS");
		Item showTest = this.controller.cadastrarBlurayShow("AC_DC Live", 10000, 120, 12, "AC DC", "DEZ_ANOS");
		assertEquals(showTest, show);
	}

	/**
	 * Testa o método getItensNaoEmprestados da classe ItemController.
	 */
	@Test
	public void testGetItensNaoEmprestados() {
		List<Item> itens = new ArrayList<>();
		JogoEletronico jogoE = new JogoEletronico("Dota 2", 20, "PC");
		JogoTabuleiro jogoT = new JogoTabuleiro("Xadrez", 20);
		Filme filme = new Filme("Senhor do aneis", 9999999, 9999999, "FICCAO", "DEZ_ANOS", 2002);
		Temporada temporada = new Temporada("GoT", 999999, "Sem comentários", 67, "DEZ_ANOS", "FICCAO", 1);
		Show show = new Show("AC_DC Live", 10000, 120, 12, "AC DC", "DEZ_ANOS");

		itens.add(jogoE);
		itens.add(jogoT);
		itens.add(filme);
		itens.add(temporada);
		itens.add(show);

		this.controller.getItensNaoEmprestados(itens);
		assertEquals(5, this.controller.getItensNaoEmprestados(itens).size());

		jogoE.setEmprestado(true);
		filme.setEmprestado(true);
		assertEquals(3, this.controller.getItensNaoEmprestados(itens).size());

		jogoT.setEmprestado(true);
		temporada.setEmprestado(true);
		show.setEmprestado(true);
		assertEquals(0, this.controller.getItensNaoEmprestados(itens).size());

	}

	@Test
	public void testGetItensNoSistema() {
		List<Usuario> usuarios = new ArrayList<>();

		usuarios.add(new Usuario("Ícaro", "(83) 9.9384-7651", "icaro.lima@ccc.ufcg.edu.br"));
		usuarios.add(new Usuario("David", "(83) 9.2345-6780", "david.ferreira@ccc.ufcg.edu.br"));
		usuarios.add(new Usuario("Amanda", "(83) 9.5783-3450", "amanda.vivian@ccc.ufcg.edu.br"));

		Usuario icaro = usuarios.get(0);
		icaro.adicionaItem(this.controller.cadastrarEletronico("Messiah", 16.99, "PC"));
		icaro.adicionaItem(this.controller.cadastrarJogoTabuleiro("Monopoli", 155.59));
		Usuario david = usuarios.get(1);
		david.adicionaItem(
				this.controller.cadastrarBlurayFilme("Expresso Polar", 4.00, 140, "AVENTURA", "LIVRE", 1997));
		david.adicionaItem(this.controller.cadastrarBluRaySerie("O Sócio", 10.00,
				"Marcus Lemmonys é o sócio e ajuda negócios ao redor do mundo.", 60, "LIVRE", "OUTRO", 1));
		Usuario amanda = usuarios.get(2);
		amanda.adicionaItem(this.controller.cadastrarBlurayShow("Scorpions", 22.90, 200, 25, "Fulano", "DOZE_ANOS"));
		amanda.adicionaItem(this.controller.cadastrarJogoTabuleiro("Jogo da Vida", 90.54));

		List<Item> itens = new ArrayList<>();
		itens.add(icaro.getItem("Messiah"));
		itens.add(icaro.getItem("Monopoli"));
		itens.add(david.getItem("Expresso Polar"));
		itens.add(david.getItem("O Sócio"));
		itens.add(amanda.getItem("Scorpions"));
		itens.add(amanda.getItem("Jogo da Vida"));
		
		List<Item> itensController = this.controller.getItensNoSistema(usuarios);
		
		itens.sort(new ItemComparatorNome());
		itensController.sort(new ItemComparatorNome());
		
		assertEquals(itens, itensController);
	}

}
