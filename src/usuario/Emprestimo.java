package usuario;

import item.Item;
import util.Validador;

public class Emprestimo {

	private Usuario dono;
	private Usuario requerente;
	private Item item;
	private String dataEmprestimo;
	private int periodo;
	private String dataRealDaDevolucaoDoItem;
	private Validador validador;

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

	}

	public String getNomeDono() {
		return this.dono.getNome();
	}
	
	public String getTelefoneDono() {
		return this.dono.getTelefone();
	}

	public String getNomeRequerente() {
		return this.requerente.getNome();
	}
	
	public String getTelefoneRequerente() {
		return this.requerente.getTelefone();
	}

	public String getNomeItem() {
		return this.item.getNome();
	}

	public String getDataEmprestimo() {
		return this.dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.validador.validaData(dataEmprestimo);
		this.dataEmprestimo = dataEmprestimo;
	}

	public int getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(int periodo) {
		this.validador.validaPeriodo(periodo);
		this.periodo = periodo;
	}

	public String getDataRealDaDevolucaoDoItem() {
		return this.dataRealDaDevolucaoDoItem;
	}

	public void setDataRealDaDevolucaoDoItem(String dataRealDaDevolucaoDoItem) {
		this.validador.validaData(dataRealDaDevolucaoDoItem);
		this.dataRealDaDevolucaoDoItem = dataRealDaDevolucaoDoItem;
	}
	
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

	public void finaliza(String dataDevolucao) {
		this.validador.validaData(dataDevolucao);
		this.dataRealDaDevolucaoDoItem = dataDevolucao;
		// Continua no us5.
	}

}
