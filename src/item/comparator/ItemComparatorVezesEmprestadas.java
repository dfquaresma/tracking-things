package item.comparator;

import java.io.Serializable;
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
public class ItemComparatorVezesEmprestadas implements Comparator<Item>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Comparada o itemA com o itemB. Retorna 0 caso estes itens forem iguais, 1
	 * se itemA tiver sido emprestado mais vezes que o itemB e -1 caso itemB
	 * tiver sido emprestado mais vezes que o itemA.
	 */
	@Override
	public int compare(Item itemA, Item itemB) {
		if (itemA.getQtdVezesEmprestado() == itemB.getQtdVezesEmprestado()) {
			return 0;
		}
		return itemA.getQtdVezesEmprestado() < itemB.getQtdVezesEmprestado() ? 1 : -1;

	}

}
