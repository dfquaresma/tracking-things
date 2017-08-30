package emprestimo.comparador;

import java.io.Serializable;
import java.util.Comparator;

import emprestimo.Emprestimo;

/**
 * Representação de um comparador de emprestimos. O critério de comparação é o
 * nome do item associado ao emprestimo.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class EmprestimoComparatorNomeItem implements Comparator<Emprestimo>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Comparada o emprestimoA com o emprestimoB. Retorna 0 caso estes
	 * emprestimos tenham nomes de itens iguais, um valor maior que zero se
	 * emprestimoA vier depois do emprestimoB na ordem alfabética e uma valor
	 * negativo caso o emprestimoB venha depois do emprestimoA na ordem
	 * alfabética.
	 */
	@Override
	public int compare(Emprestimo emprestimoA, Emprestimo emprestimoB) {
		return emprestimoA.getNomeItem().compareTo(emprestimoB.getNomeItem());
	}
}
