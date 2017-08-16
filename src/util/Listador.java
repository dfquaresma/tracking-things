package util;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import emprestimo.Emprestimo;
import emprestimo.EmprestimoController;
import item.ComparadorPorValor;
import item.ComparadorPorVezesEmprestadas;
import item.Item;
import item.ItemController;
import usuario.UsuarioController;

/**
 * Representa um listador de objetos.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class Listador {
	private Validador validador;
	private UsuarioController usuarioController;
	private EmprestimoController emprestimoController;
	private ItemController itemController;
	
	/**
	 * Constrói um listador.
	 * @param emprestimoController 
	 * @param usuarioController 
	 */
	public Listador(UsuarioController usuarioController, EmprestimoController emprestimoController, ItemController itemController) {
		this.validador = new Validador();
		this.usuarioController = usuarioController;
		this.emprestimoController = emprestimoController;
		this.itemController = itemController;
	}
	
	/**
	 * Lista itens ordenando-os por nome.
	 * 
	 * @param itens
	 *            os itens a serem listados.
	 * @return a listagem dos itens.
	 */
	public String listaItensOrdenadosPorNome() {
		List<Item> itens = this.usuarioController.getItensNoSistema();
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
	public String listaItensOrdenadosPorValor() {
		List<Item> itens = this.usuarioController.getItensNoSistema();
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
		
	public String listarItensNaoEmprestados() {
		List<Item> itens = this.itemController.getItensNaoEmprestados();
		Collections.sort(itens);
		return listagemDeItens(itens);
	}
	
	public String listarItensEmprestados() {
		List<Item> itens = this.itemController.getItensEmprestados();
		throw new IllegalArgumentException("NAO IMPLEMENTEI");
	}
	
	public String listarTop10Itens() {
		List<Item> itens = this.usuarioController.getItensNoSistema();
		Collections.sort(itens, new ComparadorPorVezesEmprestadas());
		
		int count = 1;
		String repr = "";
		Iterator<Item> itr = itens.iterator();
				
		while (itr.hasNext() && count <= 10) {
			Item item = itr.next();
			if (item.getQtdVezesEmprestado() == 0) {
				break;				
			}
			repr += count + ") " + item.getQtdVezesEmprestado() + " emprestimos - " + item + "|";
			count++;
		}
		
		return repr;
		
	}
	
	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {
		List<Emprestimo> emprestimos = this.emprestimoController.getEmprestimosUserEmprestando(nome, telefone);
		if (emprestimos.size() == 0) {
			return "Nenhum item emprestado";
		}
		Collections.sort(emprestimos);
		return "Emprestimos: " + listagemDeEmprestimos(emprestimos);
	}
	
	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		List<Emprestimo> emprestimos = this.emprestimoController.getEmprestimosUserPegandoEmprestado(nome, telefone);
		if (emprestimos.size() == 0) {
			return "Nenhum item pego emprestado";
		}
		Collections.sort(emprestimos);
		return "Emprestimos pegos: " + listagemDeEmprestimos(emprestimos);
	}
	
	public String listarEmprestimosItem(String nomeItem) {
		List<Emprestimo> emprestimos = this.emprestimoController.getEmprestimosItem(nomeItem);
		return listagemDeEmprestimos(emprestimos);
	}
	
	private String listagemDeEmprestimos(List<Emprestimo> emprestimos) {	
		String repr = "";
		for (Emprestimo emprestimo : emprestimos) {
			repr += emprestimo + "|";
		}
		return repr;
	}
	
}
