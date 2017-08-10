package util;

import java.util.Collections;
import java.util.List;

import item.ComparadorPorValor;
import item.Item;

/**
 * Representa um listador de objetos.
 * 
 * @author David Ferreira
 *
 */
public class Listador {
	private Validador validador;

	/**
	 * Constrói um listador.
	 */
	public Listador() {
		this.validador = new Validador();
	}

	/**
	 * Lista itens ordenando-os por nome.
	 * 
	 * @param itens
	 *            os itens a serem listados.
	 * @return a listagem dos itens.
	 */
	public String listaItensOrdenadosPorNome(List<Item> itens) {
		this.validador.validaListaParaListagem(itens);
		Collections.sort(itens);
		return listagemDeItens(itens);
	}

	/**
	 * Lista itens ordenando-os por valor.
	 * 
	 * @param itens
	 *            os itens a serem listados.
	 * @return a listagem dos itens.
	 */
	public String listaItensOrdenadosPorValor(List<Item> itens) {
		this.validador.validaListaParaListagem(itens);
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
