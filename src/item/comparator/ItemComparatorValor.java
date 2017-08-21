package item.comparator;

import java.util.Comparator;

import item.Item;

/**
 * Representação de um comparador de itens. O critério de comparação são os
 * valores associados aos itens.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class ItemComparatorValor implements Comparator<Item> {

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
