package emprestimo.comparador;

import java.util.Comparator;

import emprestimo.Emprestimo;

public class EmprestimosComparatorDataEmprestimo implements Comparator<Emprestimo> {

	@Override
	public int compare(Emprestimo emprestimoA, Emprestimo emprestimoB) {
		return emprestimoA.getDataDoEmprestimo().compareTo(emprestimoB.getDataDoEmprestimo());
	}

}
