package item.comparator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import item.Item;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;

/**
 * Testa se o comparador de itens por quantidade de vezes que foi emprestado
 * funciona corretamente.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class ItemComparatorVezesEmprestadasTest {

	/**
	 * Executa a bateria de testes a fim de verificar a corretude da classe
	 * comparador por quantidade de vezes emprestado.
	 */
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
