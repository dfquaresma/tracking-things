package usuario;

import excecoes.OperacaoNaoPermitidaNoMomentoExcecao;
import item.Item;
import util.Validador;

/**
 * Representação de um emprestimo.
 * 
 * @author David Ferreira
 *
 */
public class Emprestimo {

	private Usuario dono;
	private Usuario requerente;
	private Item item;
	private String dataEmprestimo;
	private int periodo;
	private String dataRealDaDevolucaoDoItem;
	private Validador validador;
	private boolean finalizado;

	/**
	 * Constrói um emprestimo com o dono do item, o requerente do item, o item,
	 * a data de emprestimo e o período de emprestimo.
	 * 
	 * @param dono
	 * @param requerente
	 * @param item
	 * @param dataEmprestimo
	 * @param periodo
	 */
	public Emprestimo(Usuario dono, Usuario requerente, Item item, String dataEmprestimo, int periodo) {
		this.validador = new Validador();
		this.validador.validaDono(dono);
		this.validador.validaRequerente(requerente);
		this.validador.validaItem(item);
		this.validador.validaData(dataEmprestimo);
		this.validador.validaPeriodo(periodo);

		this.dono = dono;
		this.requerente = requerente;
		this.item = item;
		this.dataEmprestimo = dataEmprestimo;
		this.periodo = periodo; 
		this.finalizado = false;

	}

	/**
	 * Recupera o nome do dono do item emprestado.
	 * 
	 * @return o nome do dono do item.
	 */
	public String getNomeDono() {
		return this.dono.getNome();
	}

	/**
	 * Recupera o telefone do dono do item emprestado.
	 * 
	 * @return o telefone do dono do item.
	 */
	public String getTelefoneDono() {
		return this.dono.getTelefone();
	}

	/**
	 * Recupera o nome do requerente do item emprestado.
	 * 
	 * @return o nome do requerente do item.
	 */
	public String getNomeRequerente() {
		return this.requerente.getNome();
	}

	/**
	 * Recupera o telefone do requerente do item emprestado.
	 * 
	 * @return o telefone do requerente do item.
	 */
	public String getTelefoneRequerente() {
		return this.requerente.getTelefone();
	}

	/**
	 * Recupera o nome do item emprestado.
	 * 
	 * @return o nome do item.
	 */
	public String getNomeItem() {
		return this.item.getNome();
	}

	/**
	 * Recupera a data em que o item foi emprestado.
	 * 
	 * @return a data em que o item foi emprestado.
	 */
	public String getDataEmprestimo() {
		return this.dataEmprestimo;
	}

	/**
	 * Recupera o período de dias que o item passará (ou passou, caso o
	 * emprestimo tenha sido finalizado) emprestado.
	 * 
	 * @return o período de dias.
	 */
	public int getPeriodo() {
		return this.periodo;
	}

	/**
	 * Recupera o estado do emprestimo. Se o emprestimo foi ou não finalizado.
	 * 
	 * @return true caso tenha sido finalizado, false caso contrário.
	 */
	public boolean isFinalizado() {
		return finalizado;
	}

	/**
	 * Muda a data em que o item foi emprestado.
	 * 
	 * @param dataEmprestimo
	 *            a nova data do emprestimo.
	 */
	public void setDataEmprestimo(String dataEmprestimo) {
		this.validador.validaData(dataEmprestimo);
		this.dataEmprestimo = dataEmprestimo;
	}

	/**
	 * Muda o período de dias que o item passará (ou passou, caso já tenha sido
	 * finalizado) emprestado.
	 * 
	 * @param periodo
	 *            o período de dias.
	 */
	public void setPeriodo(int periodo) {
		this.validador.validaPeriodo(periodo);
		this.periodo = periodo;
	}

	/**
	 * Recupera a data de devolução do item, ou seja, a data em que o item foi
	 * devolvido.
	 * 
	 * @return a data de devolução.
	 */
	public String getDataRealDaDevolucaoDoItem() {
		if (!this.finalizado) {
			throw new OperacaoNaoPermitidaNoMomentoExcecao("Este emprestimo ainda não foi finalizado.");
		}
		return this.dataRealDaDevolucaoDoItem;
	}

	/**
	 * Muda a data de devolução do item.
	 * 
	 * @param dataRealDaDevolucaoDoItem
	 *            a nova data em que o item foi devolvido.
	 */
	public void setDataRealDaDevolucaoDoItem(String dataRealDaDevolucaoDoItem) {
		this.validador.validaData(dataRealDaDevolucaoDoItem);
		if (!this.finalizado) {
			throw new OperacaoNaoPermitidaNoMomentoExcecao("Este emprestimo ainda não foi finalizado.");
		}
		this.dataRealDaDevolucaoDoItem = dataRealDaDevolucaoDoItem;
	}

	/**
	 * Retorna um valor hash code desse emprestimo.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((dono == null) ? 0 : dono.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((requerente == null) ? 0 : requerente.hashCode());
		return result;
	}

	/**
	 * Indica quando um outro objeto é igual a este.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (dataEmprestimo == null) {
			if (other.dataEmprestimo != null)
				return false;
		} else if (!dataEmprestimo.equals(other.dataEmprestimo))
			return false;
		if (dono == null) {
			if (other.dono != null)
				return false;
		} else if (!dono.equals(other.dono))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (requerente == null) {
			if (other.requerente != null)
				return false;
		} else if (!requerente.equals(other.requerente))
			return false;
		return true;
	}

	/**
	 * Finaliza esse emprestimo.
	 * 
	 * @param dataDevolucao
	 *            a data em que o item foi devolvido.
	 */
	public void finaliza(String dataDevolucao) {
		this.validador.validaData(dataDevolucao);
		if (this.finalizado) {
			throw new OperacaoNaoPermitidaNoMomentoExcecao("Este emprestimo ja foi finalizado.");
		}
		this.dataRealDaDevolucaoDoItem = dataDevolucao;
		this.finalizado = true;
	}

}
