package item;

import static org.junit.Assert.*;

import org.junit.Test;

import item.bluray.Show;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;

/**
 * Testa se o comparadro de itens por valor funciona corretamente.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class ComparadorPorValorTest {

	/**
	 * Executa a bateria de testes a fim de verificar a corretude da classe
	 * ComparadorPorValor.
	 */
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
