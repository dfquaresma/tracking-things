package item.comparator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import item.Item;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;

public class ItemComparatorVezesEmprestadasTest {

	@Test
	public void testCompare() {
		ItemComparatorVezesEmprestadas comparador = new ItemComparatorVezesEmprestadas();
		Item itemA = new JogoTabuleiro("Xadrez", 200);
		Item itemB = new JogoEletronico("Dota", 200, "PC");
		
		assertTrue(comparador.compare(itemA, itemB) == 0);
		
		itemA.setEmprestado(true);
		assertTrue(comparador.compare(itemA, itemB) < 0);
		
		assertTrue(comparador.compare(itemB, itemA) > 0);
		

	}

}
