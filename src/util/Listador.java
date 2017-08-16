package util;

import java.util.Collections;
import java.util.List;

import emprestimo.Emprestimo;
import emprestimo.EmprestimoController;
import item.ComparadorPorValor;
import item.Item;
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
	
	/**
	 * Constrói um listador.
	 * @param emprestimoController 
	 * @param usuarioController 
	 */
	public Listador(UsuarioController usuarioController, EmprestimoController emprestimoController) {
		this.validador = new Validador();
		this.usuarioController = usuarioController;
		this.emprestimoController = emprestimoController;
	}
	
	/**
	 * Lista itens ordenando-os por nome.
	 * 
	 * @param itens
	 *            os itens a serem listados.
	 * @return a listagem dos itens.
	 */
	public String listaItensOrdenadosPorNome() {
		List<Item> itens = this.usuarioController.recuperaItensNoSistema();
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
		List<Item> itens = this.usuarioController.recuperaItensNoSistema();
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
 
	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {
		List<Emprestimo> emprestimos = this.emprestimoController.getEmprestimosUserEmprestando(nome, telefone);
		Collections.sort(emprestimos);
		return listagemDeEmprestimos(emprestimos);
	}
	
	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		List<Emprestimo> emprestimos = this.emprestimoController.getEmprestimosUserPegandoEmprestado(nome, telefone);
		Collections.sort(emprestimos);
		return listagemDeEmprestimos(emprestimos);
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
	

	
	public String listarItensNaoEmprestados() {
		return null;
	}
	
	public String listarItensEmprestados() {
		return null;
	}
	
	public String listarTop10Itens() {
		return null;
	}
	
	
}
