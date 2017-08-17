package emprestimo.comparador;

import java.util.Comparator;

import emprestimo.Emprestimo;

public class EmprestimoComparatorNomeDono implements Comparator<Emprestimo> {

	@Override
	public int compare(Emprestimo emprestimoA, Emprestimo emprestimoB) {
		return emprestimoA.getNomeDono().compareTo(emprestimoB.getNomeDono());
	}

}
