package emprestimo.comparador;

import java.util.Comparator;

import emprestimo.Emprestimo;

/**
 * Representação de um comparador de emprestimos. O critério de comparação é o
 * nome do dono do item associado ao emprestimo.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class EmprestimoComparatorNomeDono implements Comparator<Emprestimo> {

	/**
	 * Comparada o emprestimoA com o emprestimoB. Retorna 0 caso estes
	 * emprestimos sejam iguais, um valor maior que zero se emprestimoA vier
	 * depois do emprestimoB na ordem alfabética e uma valor negativo caso o
	 * emprestimoB venha depois do emprestimoA na ordem alfabética.
	 */
	@Override
	public int compare(Emprestimo emprestimoA, Emprestimo emprestimoB) {
		return emprestimoA.getNomeDono().compareTo(emprestimoB.getNomeDono());
	}

}
