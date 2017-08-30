package util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import emprestimo.Emprestimo;
import emprestimo.comparador.EmprestimoComparatorNomeDono;
import emprestimo.comparador.EmprestimoComparatorNomeItem;
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
public class Listador implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ValidadorListagem validador;
	private ItemComparatorNome comparaItemPorNome;
	private ItemComparatorValor comparaItemPorValor;
	private ItemComparatorVezesEmprestadas comparaItemVezesEmprestadas;
	private EmprestimoComparatorNomeDono comparaEmprestimoDono;
	private EmprestimoComparatorNomeItem comparaEmprestimoItem;
	private EmprestimosComparatorDataEmprestimo comparaEmprestimosPorDataRegistro;
	private UsuarioNomeComparator comparaUsuarioPorNome;
	private UsuarioReputacaoComparator comparaUsuarioPorReputacao;
	private UsuarioReputacaoReversaComparator comparaUsuarioPorReputacaoInvertida;

	/**
	 * Constrói um listador.
	 */
	public Listador() {
		this.validador = new ValidadorListagem();
		this.comparaItemPorNome = new ItemComparatorNome();
		this.comparaItemPorValor = new ItemComparatorValor();
		this.comparaItemVezesEmprestadas = new ItemComparatorVezesEmprestadas();
		this.comparaEmprestimoDono = new EmprestimoComparatorNomeDono();
		this.comparaEmprestimoItem = new EmprestimoComparatorNomeItem();
		this.comparaEmprestimosPorDataRegistro = new EmprestimosComparatorDataEmprestimo();
		this.comparaUsuarioPorNome = new UsuarioNomeComparator();
		this.comparaUsuarioPorReputacao = new UsuarioReputacaoComparator();
		this.comparaUsuarioPorReputacaoInvertida = new UsuarioReputacaoReversaComparator();
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
		itens.sort(this.comparaItemPorNome);
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
		this.validador.validaListaDeItensParaListagem(itens);
		itens.sort(this.comparaItemPorValor);
		return listagemDeItens(itens);
	}

	private String listagemDeItens(List<Item> itens) {
		String repr = "";
		for (Item item : itens) {
			repr += item + "|";
		}
		return repr;
	}

	/**
	 * Recupera uma representação em string dos itens não emprestados no sistema
	 * ordenados pelo nome.
	 * 
	 * @param itensNaoEmprestados
	 *            os itens que estão no sistema.
	 * @return a representação em string dos itens não emprestados.
	 */
	public String listarItensNaoEmprestados(List<Item> itensNaoEmprestados) {
		this.validador.validaListaDeItensParaListagem(itensNaoEmprestados);
		itensNaoEmprestados.sort(this.comparaItemPorNome);
		return listagemDeItens(itensNaoEmprestados);
	}

	/**
	 * Recupera uma representação em string dos itens emprestados no sistema
	 * ordenados pelo nome do dono.
	 * 
	 * @param emprestimosNaoFinalizados
	 *            os emprestimos no sistema que ainda não foram finalizados.
	 * @return a representação em string dos itens emprestados.
	 */
	public String listarItensEmprestados(List<Emprestimo> emprestimosNaoFinalizados) {
		this.validador.validaListaDeEmprestimosParaListagem(emprestimosNaoFinalizados);

		emprestimosNaoFinalizados.sort(this.comparaEmprestimoDono);
		String listagem = "";
		for (Emprestimo emprestimo : emprestimosNaoFinalizados) {
			listagem += "Dono do item: " + emprestimo.getNomeDono() + ", Nome do item emprestado: "
					+ emprestimo.getNomeItem() + "|";
		}
		return listagem;
	}

	/**
	 * Recupera uma representação em string dos 10 itens mais emprestados
	 * ordenados de forma decrescente, ou seja, o mais emprestado ocupa a
	 * posição 1.
	 * 
	 * @param itens
	 *            os itens no sistema.
	 * @return a representação do top 10 itens mais emprestados.
	 */
	public String listarTop10Itens(List<Item> itens) {
		this.validador.validaListaDeItensParaListagem(itens);
		itens.sort(this.comparaItemVezesEmprestadas);

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

	/**
	 * Recupera uma representação em string dos emprestimos de algum usuario ao
	 * emprestar itens em ordem de registro.
	 * 
	 * @param emprestimos
	 *            os emprestimos de um usuário.
	 * @return a representação dos emprestimos.
	 */
	public String listarEmprestimosUsuarioEmprestando(List<Emprestimo> emprestimos) {
		return this.listaEmprestimosEmOrdemDeNomeDeItem(emprestimos, "Emprestimos: ", "Nenhum item emprestado");
	}

	/**
	 * Recupera uma representação em string dos emprestimos de algum usuario ao
	 * pegar emprestado itens em ordem de registro.
	 * 
	 * @param emprestimos
	 *            os emprestimos de um usuário.
	 * @return a representação dos emprestimos.
	 */
	public String listarEmprestimosUsuarioPegandoEmprestado(List<Emprestimo> emprestimos) {
		return this.listaEmprestimosEmOrdemDeNomeDeItem(emprestimos, "Emprestimos pegos: ",
				"Nenhum item pego emprestado");
	}

	/**
	 * Recupera uma representação em string dos emprestimos associados a algum
	 * item em ordem de registro.
	 * 
	 * @param emprestimos
	 *            os emprestimos associados a algum item.
	 * @return a representação em string da listagem.
	 */
	public String listarEmprestimosItem(List<Emprestimo> emprestimos) {
		return this.listaEmprestimosEmOrdemDeRegistro(emprestimos, "Emprestimos associados ao item: ",
				"Nenhum emprestimo associado ao item");

	}

	private String listaEmprestimosEmOrdemDeNomeDeItem(List<Emprestimo> emprestimos, String msgListagemValida,
			String msgListagemComZeroElementos) {
		this.validador.validaListaDeEmprestimosParaListagem(emprestimos);
		if (emprestimos.size() == 0) {
			return msgListagemComZeroElementos;
		}
		emprestimos.sort(this.comparaEmprestimoItem);
		return msgListagemValida + listagemDeEmprestimos(emprestimos);
	}

	private String listaEmprestimosEmOrdemDeRegistro(List<Emprestimo> emprestimos, String msgListagemValida,
			String msgListagemComZeroElementos) {
		this.validador.validaListaDeEmprestimosParaListagem(emprestimos);
		if (emprestimos.size() == 0) {
			return msgListagemComZeroElementos;
		}
		emprestimos.sort(this.comparaEmprestimosPorDataRegistro);
		return msgListagemValida + listagemDeEmprestimos(emprestimos);
	}

	private String listagemDeEmprestimos(List<Emprestimo> emprestimos) {
		String repr = "";
		for (Emprestimo emprestimo : emprestimos) {
			repr += emprestimo + "|";
		}
		return repr;
	}

	/**
	 * Recupera uma representação em string dos usuários caloteiros no sistema.
	 * 
	 * @param usuarios
	 *            os usuários no sistema.
	 * @return a representação dos caloteiros no sistema.
	 */
	public String listarCaloteiros(List<Usuario> usuarios) {
		this.validador.validaListaDeUsuariosParaListagem(usuarios);
		String repr = "Lista de usuarios com reputacao negativa: ";
		List<Usuario> usuariosCaloteiros = new ArrayList<Usuario>();
		for (Usuario usuario : usuarios) {
			if (usuario.getReputacao() < 0) {
				usuariosCaloteiros.add(usuario);
			}
		}

		usuariosCaloteiros.sort(this.comparaUsuarioPorNome);
		for (Usuario usuario : usuariosCaloteiros) {
			repr += usuario.toString() + "|";
		}

		return repr;
	}

	/**
	 * Recupera uma representação em string listando os 10 usuários com melhor
	 * reputação no sitema.
	 * 
	 * @param usuarios
	 *            os usuários do sistema.
	 * @return a representação em string dessa listagem.
	 */
	public String listarTop10MelhoresUsuarios(List<Usuario> usuarios) {
		this.validador.validaListaDeUsuariosParaListagem(usuarios);
		usuarios.sort(this.comparaUsuarioPorReputacao);
		return this.listarPelaReputacao(usuarios);
	}

	/**
	 * Recupera uma representação em string listando os 10 usuários com pior
	 * reputação no sitema.
	 * 
	 * @param usuarios
	 *            os usuários do sistema.
	 * @return a representação em string dessa listagem.
	 */
	public String listarTop10PioresUsuarios(List<Usuario> usuarios) {
		this.validador.validaListaDeUsuariosParaListagem(usuarios);
		usuarios.sort(this.comparaUsuarioPorReputacaoInvertida);
		return this.listarPelaReputacao(usuarios);
	}

	private String listarPelaReputacao(List<Usuario> usuarios) {
		String repr = "";
		for (int i = 0; i < usuarios.size() && i < 10; i++) {
			Usuario usuario = usuarios.get(i);

			repr += (i + 1) + ": " + usuario.getNome() + " - " + "Reputacao: "
					+ String.format("%.2f", usuario.getReputacao()) + "|";
		}

		return repr;
	}

}
