package emprestimo;

import java.util.Comparator;

public class EmprestimoComparatorNomeDono implements Comparator<Emprestimo> {

	@Override
	public int compare(Emprestimo emprestimoA, Emprestimo emprestimoB) {
		return emprestimoA.getNomeDono().compareTo(emprestimoB.getNomeDono());
	}

}
