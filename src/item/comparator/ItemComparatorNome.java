package item.comparator;

import java.util.Comparator;

import item.Item;

public class ItemComparatorNome implements Comparator<Item> {

	@Override
	public int compare(Item itemA, Item itemB) {
		return itemA.getNome().compareTo(itemB.getNome());
	}

}
