package item;

import static org.junit.Assert.*;

import org.junit.Test;

import item.bluray.Show;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;

public class ComparadorPorValorTest {

	@Test
	public void test() {
		ComparadorPorValor comparador = new ComparadorPorValor();
		Item itemA = new JogoTabuleiro("Xadrez", 200);
		Item itemB = new JogoEletronico("Dota", 200, "PC");
		Item itemC = new Show("AC DC - Live in River Plate", 300, 2, 11, "AC_DC", "DEZ_ANOS");
		
		assertEquals(0, comparador.compare(itemA, itemB));
		assertEquals(1, comparador.compare(itemC, itemB));
		assertEquals(-1, comparador.compare(itemA, itemC));
				
	}

}
