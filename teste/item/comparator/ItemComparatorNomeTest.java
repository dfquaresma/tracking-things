package item.comparator;

import static org.junit.Assert.*;

import org.junit.Test;

import item.Item;
import item.bluray.Show;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;

public class ItemComparatorNomeTest {

	/**
	 * Executa a bateria de testes a fim de verificar a corretude da classe
	 * ComparadorPorValor.
	 */
	@Test
	public void testCompare() {
		ItemComparatorNome comparador = new ItemComparatorNome();
		Item itemA = new JogoTabuleiro("Xadrez", 200);
		Item itemB = new JogoEletronico("Dota", 200, "PC");
		Item itemC = new Show("AC DC - Live in River Plate", 300, 2, 11, "AC_DC", "DEZ_ANOS");
		
		assertTrue(comparador.compare(itemA, itemB) > 0);
		assertTrue(comparador.compare(itemC, itemB) < 0);
		assertTrue(comparador.compare(itemA, itemC) > 0);
		assertTrue(comparador.compare(itemA, itemA) == 0);

	}

}
