package usuario;

import item.Item;

public class Emprestimo {

	private Usuario dono;
	private Usuario requerente;
	private Item item;
	private String dataEmprestimo;
	private int periodo;
	private String dataRealDaDevolucaoDoItem;

	public Emprestimo(Usuario dono, Usuario requerente, Item item, String dataEmprestimo, int periodo) {
		this.dono = dono;
		this.requerente = requerente;
		this.item = item;
		this.dataEmprestimo = dataEmprestimo;
		this.periodo = periodo;

	}

	public String getNomeDono() {
		return dono.getNome();
	}


	public String getNomeRequerente() {
		return requerente.getNome();
	}


	public String getNomeItem() {
		return item.getNome();
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public String getDataRealDaDevolucaoDoItem() {
		return dataRealDaDevolucaoDoItem;
	}

	public void setDataRealDaDevolucaoDoItem(String dataRealDaDevolucaoDoItem) {
		this.dataRealDaDevolucaoDoItem = dataRealDaDevolucaoDoItem;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dono.getNome() == null) ? 0 : dono.getNome().hashCode());
		result = prime * result + ((item.getNome() == null) ? 0 : item.getNome().hashCode());
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
		if (dono.getNome() == null) {
			if (other.dono.getNome() != null)
				return false;
		} else if (!dono.getNome().equals(other.dono.getNome()))
			return false;
		if (item.getNome() == null) {
			if (other.item.getNome() != null)
				return false;
		} else if (!item.getNome().equals(other.item.getNome()))
			return false;
		return true;
	}

	public void finaliza(String dataDevolucao) {
		this.dataRealDaDevolucaoDoItem = dataDevolucao;
		// Continua no us5.
	}

}
