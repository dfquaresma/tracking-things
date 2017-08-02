package sistema;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import item.ComparadorPorValor;
import item.Item;

public class Listador {
	
	public Listador() {
		
	}

	public String listaItensOrdenadosPorNome(List<Item> itens) {
		Collections.sort(itens);
		return listagemDeItens(itens);
	}

	public String listaItensOrdenadosPorValor(List<Item> itens) {
		Collections.sort(itens, new ComparadorPorValor());
		return listagemDeItens(itens);
	}
	
	private String listagemDeItens(List<Item> itens) {
		String repr = "";
		Iterator<Item> itr = itens.iterator();
		while (itr.hasNext()) {
			repr += itr.next();
			
			if (itr.hasNext()) {
				repr += System.lineSeparator(); 
			}
		}
		return repr;
	}

}
