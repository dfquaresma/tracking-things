package item.comparator;

import java.util.Comparator;

import item.Item;

public class ItemComparatorVezesEmprestadas implements Comparator<Item> {

	@Override
	public int compare(Item itemA, Item itemB) {
		if (itemA.getQtdVezesEmprestado() == itemB.getQtdVezesEmprestado()) {
			return 0;
		}
		return itemA.getQtdVezesEmprestado() < itemB.getQtdVezesEmprestado() ? 1 : -1;
		
	}

}
