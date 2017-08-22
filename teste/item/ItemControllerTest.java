package item;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import item.bluray.Filme;
import item.bluray.Show;
import item.bluray.Temporada;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;

public class ItemControllerTest {
	private ItemController controller;

	@Before
	public void setUp() {
		this.controller = new ItemController();
	}

	@Test
	public void testCadastrarEletronico() {
		JogoEletronico jogo = new JogoEletronico("Dota 2", 20, "PC");
		Item jogoTest = this.controller.cadastrarEletronico("Dota 2", 20, "PC");
		assertEquals(jogoTest, jogo);
	}

	@Test
	public void testCadastrarJogoTabuleiro() {
		JogoTabuleiro jogo = new JogoTabuleiro("Xadrez", 20);
		Item jogoTest = this.controller.cadastrarJogoTabuleiro("Xadrez", 20);
		assertEquals(jogoTest, jogo);
	}

	@Test
	public void testCadastrarBlurayFilme() {
		Filme filme = new Filme("Senhor do aneis", 9999999, 9999999, "FICCAO", "DEZ_ANOS", 2002);
		Item filmeTest = this.controller.cadastrarBlurayFilme("Senhor do aneis", 9999999, 9999999, "FICCAO", "DEZ_ANOS",
				2002);
		assertEquals(filmeTest, filme);
	}

	@Test
	public void testCadastrarBluRaySerie() {
		Temporada temporada = new Temporada("GoT", 999999, "Sem comentários", 67, "DEZ_ANOS", "FICCAO", 1);
		Item temporadaTest = this.controller.cadastrarBluRaySerie("GoT", 999999, "Sem comentários", 67, "DEZ_ANOS",
				"FICCAO", 1);
		assertEquals(temporadaTest, temporada);
	}

	@Test
	public void testCadastrarBlurayShow() {
		Show show = new Show("AC_DC Live", 10000, 120, 12, "AC DC", "DEZ_ANOS");
		Item showTest = this.controller.cadastrarBlurayShow("AC_DC Live", 10000, 120, 12, "AC DC", "DEZ_ANOS");
		assertEquals(showTest, show);
	}

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

}
