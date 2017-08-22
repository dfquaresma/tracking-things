package emprestimo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import excecoes.OperacaoNaoPermitidaNoMomentoExcecao;
import item.Item;
import usuario.Usuario;
import util.ValidadorEmprestimo;

/**
 * Representação de um emprestimo. Guarda informações referentes a um emprestimo
 * entre usuários de um item pertencente a um dos envolvidos.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class Emprestimo {

	private Usuario dono;
	private Usuario requerente;
	private Item item;
	private Date dataEmprestimo;
	private DateFormat dateFormat;
	private int periodo;
	private Date dataRealDaDevolucaoDoItem;
	private ValidadorEmprestimo validador;
	private boolean finalizado;

	/**
	 * Constrói um emprestimo com o dono do item, o requerente do item, o item,
	 * a data de emprestimo e o período de emprestimo.
	 * 
	 * @param dono
	 *            o dono do item a ser emprestado.
	 * @param requerente
	 *            quem receberá o item emprestado.
	 * @param nomeItem
	 *            o item a ser emprestado.
	 * @param dataEmprestimo
	 *            a data de quando começou o emprestimo.
	 * @param periodo
	 *            o período em que o item irá passar emprestado.
	 */
	public Emprestimo(Usuario dono, Usuario requerente, String nomeItem, String dataEmprestimo, int periodo) {
		this.validador = new ValidadorEmprestimo();
		this.validador.validaDono(dono);
		this.validador.validaRequerente(requerente);
		this.validador.validaData(dataEmprestimo);
		this.validador.validaPeriodo(periodo);

		this.dono = dono;
		this.requerente = requerente;
		this.item = dono.getItem(nomeItem);

		this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.dataEmprestimo = this.dateFormat.parse(dataEmprestimo);
		} catch (ParseException e) {
			throw new IllegalArgumentException("O formato da data inserido está incorreto, utilize dd/MM/yyyy");
		}

		this.periodo = periodo;
		this.finalizado = false;

		if (requerente.isCaloteiro()) {
			throw new IllegalArgumentException("Usuario nao pode pegar nenhum item emprestado");
		}

		if (this.periodo > requerente.getPeriodo()) {
			throw new IllegalArgumentException("Usuario impossiblitado de pegar emprestado por esse periodo");
		}

		this.dono.emprestaItem(getNomeItem());
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
		try {
			this.dataRealDaDevolucaoDoItem = this.dateFormat.parse(dataDevolucao);
		} catch (ParseException e) {
			throw new IllegalArgumentException("O formato da data inserido está incorreto, utilize dd/MM/yyyy");
		}
		this.validador.validaDataDevolucao(this.dataEmprestimo, this.dataRealDaDevolucaoDoItem);

		this.finalizado = true;

		int diasAtraso = this.getDiasDeEmprestimo() - this.periodo;

		this.requerente.devolveItem(this.item.getPreco(), diasAtraso);

		this.dono.recebeItem(getNomeItem());
	}

	/**
	 * Calcula quantos dias o item ficou emprestado com o usuario requerente.
	 * 
	 * @return inteiro que representa quantos dias um item ficou emprestado ao
	 *         usuario requerente.
	 */
	public int getDiasDeEmprestimo() {
		return (int) ((this.dataRealDaDevolucaoDoItem.getTime() - this.dataEmprestimo.getTime())
				/ (60 * 60 * 24 * 1000));
	}

	/**
	 * Recupera o usuário dono do item deste emprestimo.
	 * 
	 * @return o usuário dono do item deste emprestimo.
	 */
	public Usuario getDono() {
		return this.dono;

	}

	/**
	 * Recupera o usuário requerente do item deste emprestimo.
	 * 
	 * @return o usuário requerente do item deste emprestimo.
	 */
	public Usuario getRequerente() {
		return this.requerente;
	}

	/**
	 * Recupera o item emprestado.
	 * 
	 * @return o item emprestado.
	 */
	public Item getItem() {
		return this.item;

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
	 * Recupera uma string representando a data em que o item foi emprestado.
	 * 
	 * @return a data em que o item foi emprestado.
	 */
	public String getDataEmprestimo() {
		return this.dateFormat.format(this.dataEmprestimo);
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

		try {
			this.dataEmprestimo = this.dateFormat.parse(dataEmprestimo);
		} catch (ParseException e) {
			throw new IllegalArgumentException("O formato da data inserido está incorreto, utilize dd/MM/yyyy");
		}
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

		return this.dateFormat.format(this.dataRealDaDevolucaoDoItem);
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

		try {
			this.dataRealDaDevolucaoDoItem = this.dateFormat.parse(dataRealDaDevolucaoDoItem);
		} catch (ParseException e) {
			throw new IllegalArgumentException("O formato da data inserido está incorreto, utilize dd/MM/yyyy");
		}
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
	 * Retorna uma representação em string deste emprestimo.
	 */
	@Override
	public String toString() {

		String modificador;
		if (isFinalizado()) {
			modificador = this.getDataRealDaDevolucaoDoItem();
		} else {
			modificador = "Emprestimo em andamento";
		}

		return "EMPRESTIMO - De: " + this.getNomeDono() + ", Para: " + this.getNomeRequerente() + ", "
				+ this.getNomeItem() + ", " + this.getDataEmprestimo() + ", " + this.getPeriodo() + " dias, ENTREGA: "
				+ modificador;
	}

	/**
	 * Recupera um objeto representando a data em que o item foi emprestado.
	 * 
	 * @return a data em que o item foi emprestimo.
	 */
	public Date getDataDoEmprestimo() {
		return this.dataEmprestimo;
	}

}
