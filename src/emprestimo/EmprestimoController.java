package emprestimo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import excecoes.OperacaoNaoPermitidaNoMomentoExcecao;
import item.Item;
import usuario.Usuario;

/**
 * Representação de um controlador de emprestimos. Nele estão guardados todos os
 * emprestimos do sistema.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class EmprestimoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Emprestimo> emprestimos;

	/**
	 * Constrói um controlador de emprestimos.
	 */
	public EmprestimoController() {
		this.emprestimos = new ArrayList<>();
	}

	/**
	 * Registra um emprestimo de um item.
	 * 
	 * @param userEmprestador
	 *            o usuário que está emprestando o item.
	 * @param userRequerente
	 *            o usuário que está pegando emprestado o item.
	 * @param nomeItem
	 *            o nome do item.
	 * @param dataEmprestimo
	 *            a data em que o emprestimo foi iniciado.
	 * @param periodo
	 *            o período em que o item ficará emprestado.
	 */
	public void registrarEmprestimo(Usuario userEmprestador, Usuario userRequerente, String nomeItem,
			String dataEmprestimo, int periodo) {
		this.validaAddEmprestimo(userEmprestador, userRequerente, nomeItem, dataEmprestimo);
		Emprestimo emprestimo = new Emprestimo(userEmprestador, userRequerente, nomeItem, dataEmprestimo, periodo);
		this.emprestimos.add(emprestimo);

	}

	/**
	 * Finaliza um emprestimo em que o item foi devolvido.
	 * 
	 * @param userEmprestador
	 *            o usuário que emprestou o item.
	 * @param userRequerente
	 *            o usuário que pegou emprestado o item e o está devolvendo.
	 * @param nomeItem
	 *            o nome do item pego emprestado.
	 * @param dataEmprestimo
	 *            a data em que o emprestimo foi iniciado.
	 * @param dataDevolucao
	 *            a data em que o item foi devolvido.
	 */
	public void devolverItem(Usuario userEmprestador, Usuario userRequerente, String nomeItem, String dataEmprestimo,
			String dataDevolucao) {
		Emprestimo emprestimo = getEmprestimo(userEmprestador, userRequerente, nomeItem, dataEmprestimo);
		emprestimo.finaliza(dataDevolucao);

	}

	/**
	 * Recupera um emprestimo no sistema.
	 * 
	 * @param userEmprestador
	 *            o usuário quem emprestou o item.
	 * @param userRequerente
	 *            o usuário que pegou emprestado o item.
	 * @param nomeItem
	 *            o nome do item que foi emprestado.
	 * @param dataEmprestimo
	 *            a data em que o emprestimo aconteceu.
	 * @return o emprestimo de interesse.
	 */
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

	/**
	 * Recupera uma lista de emprestimos de um determinado usuário ao emprestar
	 * itens.
	 * 
	 * @param user
	 *            o usuário quem emprestou o item.
	 * @return os emprestimos associados a este usuário como emprestador.
	 */
	public List<Emprestimo> getEmprestimosUserEmprestando(Usuario user) {

		List<Emprestimo> emprestimos = new ArrayList<>();

		for (Emprestimo emprestimo : this.emprestimos) {
			if (emprestimo.getDono().equals(user)) {
				emprestimos.add(emprestimo);
			}
		}

		return emprestimos;
	}

	/**
	 * Recupera uma lista de emprestimos de um determinado usuário ao pegar
	 * emprestado itens.
	 * 
	 * @param user
	 *            o usuário quem pegou emprestado o item.
	 * @return os emprestimos associados a este usuário como quem pegou
	 *         emprestado.
	 */
	public List<Emprestimo> getEmprestimosUserPegandoEmprestado(Usuario user) {

		List<Emprestimo> emprestimos = new ArrayList<>();

		for (Emprestimo emprestimo : this.emprestimos) {
			if (emprestimo.getRequerente().equals(user)) {
				emprestimos.add(emprestimo);
			}
		}

		return emprestimos;
	}

	/**
	 * Recupera um lista com os emprestimos associados o item recebido como
	 * parâmetro.
	 * 
	 * @param nomeItem
	 *            o nome do item.
	 * @return uma lista de emprestimos associados o item.
	 */
	public List<Emprestimo> getEmprestimosItem(String nomeItem) {
		List<Emprestimo> emprestimos = new ArrayList<>();

		for (Emprestimo emprestimo : this.emprestimos) {
			if (emprestimo.getNomeItem().equals(nomeItem)) {
				emprestimos.add(emprestimo);
			}
		}

		return emprestimos;

	}

	/**
	 * Recupera um lista de emprestimos que ainda não foram finalizados no
	 * sistema.
	 * 
	 * @return uma lista de emprestimos não finalizados.
	 */
	public List<Emprestimo> getEmprestimosNaoFinalizados() {
		List<Emprestimo> emprestimos = new ArrayList<>();

		for (Emprestimo emprestimo : this.emprestimos) {
			if (!emprestimo.isFinalizado()) {
				emprestimos.add(emprestimo);
			}
		}

		return emprestimos;

	}

	/**
	 * Recupera a lista de emprestimos.
	 * 
	 * @return a lista de emprestimos.
	 */
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	/**
	 * Atribui a lista de emprestimos a lista recebida.
	 * 
	 * @param emprestimos
	 *            a lista de emprestimos nova.
	 */
	public void setEmprestimos(List<Emprestimo> emprestimos) {
		if (emprestimos == null) {
			throw new NullPointerException("Emprestimos nao pode ser nulo");
		}
		if (!emprestimos.isEmpty()) {
			if (emprestimos.contains(null)) {
				throw new IllegalArgumentException("Emprestimos invalido.");
			}
			for (Emprestimo e : emprestimos) {
				if (e.getUID() != 1L) {
					throw new OperacaoNaoPermitidaNoMomentoExcecao("Persistencia invalida. Emprestimo(s) obsoleto(s).");
				}
			}
		}

		this.emprestimos = emprestimos;
	}

}
