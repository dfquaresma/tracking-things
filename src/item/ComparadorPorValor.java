package item;

import java.util.Comparator;

/**
 * Representação de um comparador de itens.
 * 
 * @author David Ferreira
 *
 */
public class ComparadorPorValor implements Comparator<Item> {

	/**
	 * Comparada o itemA com o itemB. Retorna 0 caso estes itens forem iguais, 1
	 * se itemA tiver maior preço que itemB e -1 caso itemB tiver maior preço
	 * que itemA.
	 */
	@Override
	public int compare(Item itemA, Item itemB) {
		if (itemA.getPreco() == itemB.getPreco()) {
			return 0;
		}
		return itemA.getPreco() > itemB.getPreco() ? 1 : -1;
	}

}
