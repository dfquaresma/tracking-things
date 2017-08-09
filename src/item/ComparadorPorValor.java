package item;

import java.util.Comparator;

public class ComparadorPorValor implements Comparator<Item> {

	@Override
	public int compare(Item itemA, Item itemB) { 
		if (itemA.getPreco() == itemB.getPreco()) {
			return 0;
		}
		return itemA.getPreco() > itemB.getPreco()? 1: -1;
	}

}
