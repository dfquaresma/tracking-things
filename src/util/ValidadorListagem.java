package util;

import java.util.List;

import emprestimo.Emprestimo;
import excecoes.OperacaoNaoPermitidaNoMomentoExcecao;
import item.Item;

/**
 * Represetanção de um validador.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class ValidadorListagem {

	
	/**
	 * Valida uma lista de itens recebida no parâmetro.
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
	
	public void validaListaDeEmprestimosParaListagem(List<Emprestimo> emprestimos) {
		if (emprestimos == null)
			throw new NullPointerException("A lista de emprestimos para listagem nao pode ser nula");

		for (Emprestimo emprestimo: emprestimos) {
			if (emprestimo == null)
				throw new NullPointerException("A lista de emprestimos para listagem nao pode possuir emprestimos nulos");
		}

	}


}
