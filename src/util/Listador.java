package util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import emprestimo.Emprestimo;
import emprestimo.comparador.EmprestimoComparatorNomeDono;
import emprestimo.comparador.EmprestimosComparatorDataEmprestimo;
import item.Item;
import item.comparator.ItemComparatorNome;
import item.comparator.ItemComparatorValor;
import item.comparator.ItemComparatorVezesEmprestadas;
import usuario.Usuario;
import usuario.comparator.UsuarioNomeComparator;
import usuario.comparator.UsuarioReputacaoComparator;
import usuario.comparator.UsuarioReputacaoReversaComparator;

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
	private ValidadorListagem validador;
	
	/**
	 * Constrói um listador.
	 * @param emprestimoController 
	 * @param usuarioController 
	 */
	public Listador() {
		this.validador = new ValidadorListagem();
	}
	
	/**
	 * Lista itens ordenando-os por nome.
	 * 
	 * @param itens
	 *            os itens a serem listados.
	 * @return a listagem dos itens.
	 */
	public String listaItensOrdenadosPorNome(List<Item> itens) {
		this.validador.validaListaDeItensParaListagem(itens);
		itens.sort(new ItemComparatorNome());
		return listagemDeItens(itens);
	}

	/**
	 * Lista itens ordenando-os por valor.
	 * 
	 * @param itens
	 *            os itens a serem listados.
	 * @return a listagem dos itens.
	 */
	public String listaItensOrdenadosPorValor(List<Item> itens ) {
		this.validador.validaListaDeItensParaListagem(itens);
		itens.sort(new ItemComparatorValor());
		return listagemDeItens(itens);
	}

	private String listagemDeItens(List<Item> itens) {
		String repr = "";
		for (Item item : itens) {
			repr += item + "|";
		}
		return repr;
	}
		
	public String listarItensNaoEmprestados(List<Item> itens) {
		this.validador.validaListaDeItensParaListagem(itens);
		itens.sort(new ItemComparatorNome());
		return listagemDeItens(itens);
	}
	
	public String listarItensEmprestados(List<Emprestimo> emprestimos) {
		emprestimos.sort(new EmprestimoComparatorNomeDono());
		String listagem = "";
		for (Emprestimo emprestimo : emprestimos) {
			listagem += "Dono do item: " + emprestimo.getNomeDono() + ", Nome do item emprestado: " + emprestimo.getNomeItem() + "|";
		}
		return listagem;
	}
	
	public String listarTop10Itens(List<Item> itens) {
		this.validador.validaListaDeItensParaListagem(itens);
		itens.sort(new ItemComparatorVezesEmprestadas());
		
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
	
	public String listarEmprestimosUsuarioEmprestando(List<Emprestimo> emprestimos) {
		this.validador.validaListaDeEmprestimosParaListagem(emprestimos);
		if (emprestimos.size() == 0) {
			return "Nenhum item emprestado";
		}
		emprestimos.sort(new EmprestimosComparatorDataEmprestimo());
		return "Emprestimos: " + listagemDeEmprestimos(emprestimos);
	}
	
	public String listarEmprestimosUsuarioPegandoEmprestado(List<Emprestimo> emprestimos) {
		this.validador.validaListaDeEmprestimosParaListagem(emprestimos);
		if (emprestimos.size() == 0) {
			return "Nenhum item pego emprestado";
		}
		emprestimos.sort(new EmprestimosComparatorDataEmprestimo());
		return "Emprestimos pegos: " + listagemDeEmprestimos(emprestimos);
	}
	
	public String listarEmprestimosItem(List<Emprestimo> emprestimos) {
		this.validador.validaListaDeEmprestimosParaListagem(emprestimos);
		emprestimos.sort(new EmprestimosComparatorDataEmprestimo());
		if (emprestimos.size() == 0) {
			return "Nenhum emprestimo associado ao item";
		}
		return "Emprestimos associados ao item: " + listagemDeEmprestimos(emprestimos);
	}
	
	private String listagemDeEmprestimos(List<Emprestimo> emprestimos) {	
		String repr = "";
		for (Emprestimo emprestimo : emprestimos) {
			repr += emprestimo + "|";
		}
		return repr;
	}
	
	public String listarCaloteiros(List<Usuario> usuarios) {
		String repr = "Lista de usuarios com reputacao negativa: ";
		List<Usuario> usuariosCaloteiros = new ArrayList<Usuario>();
		for (Usuario usuario: usuarios) {
			if (usuario.getReputacao() < 0) {
				usuariosCaloteiros.add(usuario);
			}
		}
		
		usuariosCaloteiros.sort(new UsuarioNomeComparator());
		for (Usuario usuario: usuariosCaloteiros) {
			repr += usuario.toString() + "|";
		}
		
		return repr;
	}
	
	private String listarPelaReputacao(List<Usuario> usuarios) {
		String repr = "";
		for (int i = 0; i < usuarios.size() && i < 10; i++) {
			Usuario usuario = usuarios.get(i);
			
			repr += (i + 1) + ": " + usuario.getNome() + " - " + "Reputacao: " + String.format("%.2f", usuario.getReputacao()) + "|";
		}
		
		return repr;
	}
	
	public String listarTop10MelhoresUsuarios(List<Usuario> usuarios) {
		usuarios.sort(new UsuarioReputacaoComparator());
		return this.listarPelaReputacao(usuarios);
	}
	
	public String listarTop10PioresUsuarios(List<Usuario> usuarios) {
		usuarios.sort(new UsuarioReputacaoReversaComparator());
		return this.listarPelaReputacao(usuarios);
	}
	
}
