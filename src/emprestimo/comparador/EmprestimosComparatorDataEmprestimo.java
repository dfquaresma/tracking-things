package emprestimo.comparador;

import java.util.Comparator;

import emprestimo.Emprestimo;

/**
 * Representação de um comparador de emprestimos. O critério de comparação é a
 * data em que o emprestimo aconteceu.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class EmprestimosComparatorDataEmprestimo implements Comparator<Emprestimo> {

	/**
	 * Comparada o emprestimoA com o emprestimoB. Retorna 0 caso estes
	 * emprestimos sejam iguais, um valor positivo se emprestimoA aconteceu
	 * depois de EmprestimoB e uma valor negativo caso emprestimoB tenha
	 * acontecido depois do emprestimoA.
	 */
	@Override
	public int compare(Emprestimo emprestimoA, Emprestimo emprestimoB) {
		return emprestimoA.getDataDoEmprestimo().compareTo(emprestimoB.getDataDoEmprestimo());
	}

}
