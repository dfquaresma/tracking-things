package item;

import java.util.Comparator;

public class ComparadorPorValor implements Comparator<Item> {

	@Override
	public int compare(Item itemA, Item itemB) { 
		if (itemA.getValor() == itemB.getValor()) {
			return 0;
		}
		return itemA.getValor() > itemB.getValor()? 1: -1;
	}

}
