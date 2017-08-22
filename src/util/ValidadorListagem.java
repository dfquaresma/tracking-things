package util;

import java.util.List;

import emprestimo.Emprestimo;
import excecoes.OperacaoNaoPermitidaNoMomentoExcecao;
import item.Item;
import usuario.Usuario;

/**
 * Represetanção de um validador de elementos associados a listagens.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class ValidadorListagem {

	/**
	 * Valida uma lista de itens recebida no parâmetro. Lança exceção sempre que
	 * itens é null, itens tem tamanho 0 ou se há algum item null em itens.
	 * 
	 * @param itens
	 *            uma lista de itens a ser validada.
	 */
	public void validaListaDeItensParaListagem(List<Item> itens) {
		if (itens == null)
			throw new NullPointerException("A lista de itens para listagem nao pode ser nula");

		if (itens.size() == 0) {
			throw new OperacaoNaoPermitidaNoMomentoExcecao("Nao ha itens para serem listados no momento");
		}

		for (Item item : itens) {
			if (item == null)
				throw new NullPointerException("A lista de itens para listagem nao pode possuir itens nulos");
		}

	}

	/**
	 * Valida uma lista de emprestimos recebida no parâmetro. Lança exceção
	 * sempre que emprestimos é null ou se há algum emprestimo null em
	 * emprestimos.
	 * 
	 * @param emprestimos
	 *            uma lista de emprestimos a ser validada.
	 */
	public void validaListaDeEmprestimosParaListagem(List<Emprestimo> emprestimos) {
		if (emprestimos == null)
			throw new NullPointerException("A lista de emprestimos para listagem nao pode ser nula");

		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo == null)
				throw new NullPointerException(
						"A lista de emprestimos para listagem nao pode possuir emprestimos nulos");
		}

	}

	/**
	 * Valida uma lista de usuarios recebida no parâmetro. Lança exceção sempre
	 * que usuarios é null ou se há algum usuario null em usuarios.
	 * 
	 * @param usuarios
	 *            uma lista de emprestimos a ser validada.
	 */
	public void validaListaDeUsuariosParaListagem(List<Usuario> usuarios) {
		if (usuarios == null)
			throw new NullPointerException("A lista de usuarios para listagem nao pode ser nula");

		for (Usuario usuario : usuarios) {
			if (usuario == null)
				throw new NullPointerException("A lista de usuarios para listagem nao pode possuir emprestimos nulos");
		}

	}

}
