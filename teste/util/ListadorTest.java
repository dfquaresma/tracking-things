package util;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import item.Item;
import item.bluray.Show;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;

/**
 * Testa as funcionalidades da classe Listador
 * 
 * @author David Ferreira
 *
 */
public class ListadorTest {
	private Listador listador;
	private ArrayList<Item> itens;
	private JogoEletronico itemA;
	private JogoTabuleiro itemB;
	private Show itemC;

	/**
	 * Configura o ambiente de teste para garantir a validez dos testes.
	 */
	@Before
	public void setUp() {
		this.listador = new Listador();
		this.itens = new ArrayList<>();
		this.itemA = new JogoEletronico("Dota", 30, "PC");
		this.itemB = new JogoTabuleiro("Xadrez", 20);
		this.itemC = new Show("AC_DC - LIVE in River Plate", 50, 2, 11, "AC_DC", "DEZ_ANOS");
		this.itens.add(itemA);
		this.itens.add(itemB);
		this.itens.add(itemC);
	}

	/**
	 * Verifica se a listagem por ordem de nome funciona como esperado e se
	 * lança exceção quando nessário.
	 */
	@Test
	public void testListaItensOrdenadosPorNome() {
		try {
			listador.listaItensOrdenadosPorNome(null);
			fail();
		} catch (Exception e) {
			assertEquals("A lista de itens para listagem nao pode ser nula", e.getMessage());
		}

		assertEquals(itemC.toString() + "|" + itemA.toString() + "|" + itemB.toString() + "|",
				listador.listaItensOrdenadosPorNome(itens));
	}

	/**
	 * Verifica se a listagem de itens ordenados por valor funciona como
	 * esperado e se lança exceção quando necessário.
	 */
	@Test
	public void testListaItensOrdenadosPorValor() {
		try {
			listador.listaItensOrdenadosPorValor(null);
			fail();
		} catch (Exception e) {
			assertEquals("A lista de itens para listagem nao pode ser nula", e.getMessage());
		}

		assertEquals(itemB.toString() + "|" + itemA.toString() + "|" + itemC.toString() + "|",
				listador.listaItensOrdenadosPorValor(itens));
	}

}
