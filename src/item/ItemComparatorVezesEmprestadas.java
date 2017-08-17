package item;

import java.util.Comparator;

public class ItemComparatorVezesEmprestadas implements Comparator<Item> {

	@Override
	public int compare(Item itemA, Item itemB) {
		if (itemA.getQtdVezesEmprestado() == itemB.getQtdVezesEmprestado()) {
			return 0;
		}
		return itemA.getQtdVezesEmprestado() < itemB.getQtdVezesEmprestado() ? 1 : -1;
		
	}

}
