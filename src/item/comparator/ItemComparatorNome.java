package item.comparator;

import java.util.Comparator;

import item.Item;

/**
 * Representação de um comparador de itens. O critério de comparação são os
 * nomes associados aos itens.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class ItemComparatorNome implements Comparator<Item> {

	/**
	 * Comparada o itemA com o itemB. Retorna 0 caso estes itens forem iguais,
	 * um valor maior que zero se itemA tiver vier depois do itemB na ordem
	 * alfabética e uma valor negativo caso o itemB venha depois do itemA na
	 * ordem alfabética.
	 */
	@Override
	public int compare(Item itemA, Item itemB) {
		return itemA.getNome().compareTo(itemB.getNome());
	}

}
