package emprestimo;

import java.util.HashSet;
import java.util.Set;

import item.Item;
import usuario.Usuario;

public class EmprestimoController {
	private Set<Emprestimo> emprestimos;

	public EmprestimoController() {
		this.emprestimos = new HashSet<>();
	}

	public void registraEmprestimo(Usuario userEmprestador, Usuario userRequerente, String nomeItem,
			String dataEmprestimo, int periodo) {
		this.validaAddEmprestimo(userEmprestador, userRequerente, nomeItem, dataEmprestimo);
		Emprestimo emprestimo = new Emprestimo(userEmprestador, userRequerente, nomeItem, dataEmprestimo, periodo);
		this.emprestimos.add(emprestimo);

	}

	public void fecharEmprestimo(Usuario userEmprestador, Usuario userRequerente, String nomeItem,
			String dataEmprestimo, String dataDevolucao) {
		Emprestimo emprestimo = getEmprestimo(userEmprestador, userRequerente, nomeItem, dataEmprestimo);
		emprestimo.finaliza(dataDevolucao);

	}

	public Emprestimo getEmprestimo(Usuario userEmprestador, Usuario userRequerente, String nomeItem,
			String dataEmprestimo) {

		try {
			userEmprestador.getItem(nomeItem); // Checa se o userEmprestador tem
												// o item.
		} catch (Exception e) {
			throw new IllegalArgumentException("Emprestimo nao encontrado.");
		}

		Emprestimo emprestimo = encontraEmprestimo(userEmprestador, userRequerente, nomeItem, dataEmprestimo);

		if (emprestimo == null) {
			throw new IllegalArgumentException("Emprestimo nao encontrado");
		}

		return emprestimo;
	}

	private Emprestimo encontraEmprestimo(Usuario userEmprestador, Usuario userRequerente, String nomeItem,
			String dataEmprestimo) {

		Item item = userEmprestador.getItem(nomeItem);

		for (Emprestimo emprestimo : this.emprestimos) {
			if (emprestimo.getDono().equals(userEmprestador) && emprestimo.getRequerente().equals(userRequerente)
					&& emprestimo.getItem().equals(item) && emprestimo.getDataEmprestimo().equals(dataEmprestimo)) {
				return emprestimo;
			}
		}
		return null;
	}

	private void validaAddEmprestimo(Usuario userEmprestador, Usuario userRequerente, String nomeItem,
			String dataEmprestimo) {
		userEmprestador.getItem(nomeItem); // Garante que o usuário tenha o
											// item.
		if (conteinsEmprestimo(userEmprestador, userRequerente, nomeItem, dataEmprestimo)) {
			throw new IllegalArgumentException("Emprestimo ja cadastrado");
		}
	}

	private boolean conteinsEmprestimo(Usuario userEmprestador, Usuario userRequerente, String nomeItem,
			String dataEmprestimo) {
		Emprestimo emprestimo = encontraEmprestimo(userEmprestador, userRequerente, nomeItem, dataEmprestimo);
		if (emprestimo == null) {
			return false;
		}
		return true;
	}

}
