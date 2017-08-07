package usuario;

public class Emprestimo {

	private String nomeDono;
	private String telefoneDono;
	private String nomeRequerente;
	private String telefoneRequerente;
	private String nomeItem;
	private String dataEmprestimo;
	private int periodo;
	private String dataRealDaDevolucaoDoItem;

	public Emprestimo(String nomeDono, String telefoneDono, String telefoneRequerente, String nomeRequerente,
			String nomeItem, String dataEmprestimo, int periodo) {
		this.nomeDono = nomeDono;
		this.telefoneDono = telefoneDono;
		this.nomeRequerente = nomeRequerente;
		this.telefoneRequerente = telefoneRequerente;
		this.nomeItem = nomeItem;
		this.dataEmprestimo = dataEmprestimo;
		this.periodo = periodo;

	}

	public String getNomeDono() {
		return nomeDono;
	}

	public void setNomeDono(String nomeDono) {
		this.nomeDono = nomeDono;
	}

	public String getNomeRequerente() {
		return nomeRequerente;
	}

	public void setNomeRequerente(String nomeRequerente) {
		this.nomeRequerente = nomeRequerente;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
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

	public String getTelefoneDono() {
		return telefoneDono;
	}

	public String getTelefoneRequerente() {
		return telefoneRequerente;
	}

	public void setTelefoneDono(String telefoneDono) {
		this.telefoneDono = telefoneDono;
	}

	public void setTelefoneRequerente(String telefoneRequerente) {
		this.telefoneRequerente = telefoneRequerente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeDono == null) ? 0 : nomeDono.hashCode());
		result = prime * result + ((nomeItem == null) ? 0 : nomeItem.hashCode());
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
		if (nomeDono == null) {
			if (other.nomeDono != null)
				return false;
		} else if (!nomeDono.equals(other.nomeDono))
			return false;
		if (nomeItem == null) {
			if (other.nomeItem != null)
				return false;
		} else if (!nomeItem.equals(other.nomeItem))
			return false;
		return true;
	}

	public void finaliza(String dataDevolucao) {
		this.dataRealDaDevolucaoDoItem = dataDevolucao;
		// Continua no us5.
	}

}
