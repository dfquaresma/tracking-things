package emprestimo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import item.Item;
import usuario.Usuario;
import usuario.UsuarioController;

public class EmprestimoController {
	private Set<Emprestimo> emprestimos;
	private UsuarioController usuarioController;

	public EmprestimoController(UsuarioController usuarioController) {
		this.emprestimos = new HashSet<>();
		this.usuarioController = usuarioController;
	}

	/**
	 * Registra um emprestimo de um item.
	 * 
	 * @param nomeDono
	 *            o nome do usuário dono do item.
	 * @param telefoneDono
	 *            o telefone do usuário dono do item.
	 * @param nomeRequerente
	 *            o nome do usuário requerente do item.
	 * @param telefoneRequerente
	 *            o telefone do usuário requerente do item.
	 * @param nomeItem
	 *            o nome do item.
	 * @param dataEmprestimo
	 *            a data em que o emprestimo foi iniciado.
	 * @param periodo
	 *            o período em que o item ficará emprestado.
	 */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {

		Usuario userEmprestador = usuarioController.getUser(nomeDono, telefoneDono);
		Usuario userRequerente = usuarioController.getUser(nomeRequerente, telefoneRequerente);
		registraEmprestimo(userEmprestador, userRequerente, nomeItem, dataEmprestimo, periodo);		
		
	}

	/**
	 * Devolve um item.
	 * 
	 * @param nomeDono
	 *            o nome do usuário dono do item.
	 * @param telefoneDono
	 *            o telefone do usuário dono do item.
	 * @param nomeRequerente
	 *            o nome do usuário requerente do item.
	 * @param telefoneRequerente
	 *            o telefone do usuário requerente do item.
	 * @param nomeItem
	 *            o nome do item.
	 * @param dataEmprestimo
	 *            a data em que o emprestimo foi iniciado.
	 * @param dataDevolucao
	 *            a data em que o item foi devolvido.
	 */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {

		Usuario userEmprestador = usuarioController.getUser(nomeDono, telefoneDono);
		Usuario userRequerente = usuarioController.getUser(nomeRequerente, telefoneRequerente);
		fecharEmprestimo(userEmprestador, userRequerente, nomeItem, dataEmprestimo, dataDevolucao);
		
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

	public List<Emprestimo> getEmprestimosUserEmprestando(String nome, String telefone) {
		Usuario user = this.usuarioController.getUser(nome, telefone);
		
		List<Emprestimo> emprestimos = new ArrayList<>();
		
		for (Emprestimo emprestimo : this.emprestimos) {
			if (emprestimo.getDono().equals(user)) {
				emprestimos.add(emprestimo);
			}
		}
		
		return emprestimos;
	}

	public List<Emprestimo> getEmprestimosUserPegandoEmprestado(String nome, String telefone) {
		Usuario user = this.usuarioController.getUser(nome, telefone);
		
		List<Emprestimo> emprestimos = new ArrayList<>();
		
		for (Emprestimo emprestimo : this.emprestimos) {
			if (emprestimo.getRequerente().equals(user)) {
				emprestimos.add(emprestimo);
			}
		}
		
		return emprestimos;
	}

	public List<Emprestimo> getEmprestimosItem(String nomeItem) {
		List<Emprestimo> emprestimos = new ArrayList<>();
		
		for (Emprestimo emprestimo : this.emprestimos) {
			if (emprestimo.getNomeItem().equals(nomeItem)) {
				emprestimos.add(emprestimo);
			}
		}
		
		return emprestimos;

	}
	

}
