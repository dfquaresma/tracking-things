package item.comparator;

import static org.junit.Assert.*;

import org.junit.Test;

import item.Item;
import item.bluray.Show;
import item.comparator.ItemComparatorValor;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;

/**
 * Testa se o comparador de itens por valor funciona corretamente.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class ItemComparatorValorTest {

	/**
	 * Executa a bateria de testes a fim de verificar a corretude da classe
	 * comparador por valor.
	 */
	@Test
	public void testCompare() {
		ItemComparatorValor comparador = new ItemComparatorValor();
		Item itemA = new JogoTabuleiro("Xadrez", 200);
		Item itemB = new JogoEletronico("Dota", 200, "PC");
		Item itemC = new Show("AC DC - Live in River Plate", 300, 2, 11, "AC_DC", "DEZ_ANOS");

		assertEquals(0, comparador.compare(itemA, itemB));
		assertEquals(1, comparador.compare(itemC, itemB));
		assertEquals(-1, comparador.compare(itemA, itemC));

	}

}
