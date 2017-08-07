package util;

import java.util.Collections;
import java.util.List;

import item.ComparadorPorValor;
import item.Item;

public class Listador {

	
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
		for (Item item : itens) {
			repr += item + "|";
		}
		return repr;
	}

}
