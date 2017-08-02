package sistema;

public class Emprestimo {

	private String nomeDono;
	private String nomeRequerente;
	private String nomeItem;
	private String dataEmprestimo;
	private int periodo;
	private String dataRealDaDevolucaoDoItem;

	public Emprestimo(String nomeDono, String nomeRequerente, String nomeItem, String dataEmprestimo, int periodo) {

		this.nomeDono = nomeDono;
		this.nomeRequerente = nomeRequerente;
		this.nomeItem = nomeItem;
		this.dataEmprestimo = dataEmprestimo;
		this.dataEmprestimo = dataEmprestimo;
		this.periodo = periodo;

	}

	public String getnomeDono() {
		return nomeDono;
	}

	public void setnomeDono(String nomeDono) {
		this.nomeDono = nomeDono;
	}

	public String getnomeRequerente() {
		return nomeRequerente;
	}

	public void setnomeRequerente(String nomeRequerente) {
		this.nomeRequerente = nomeRequerente;
	}

	public String getnomeItem() {
		return nomeItem;
	}

	public void setnomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public String getdataEmprestimo() {
		return dataEmprestimo;
	}

	public void setdataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public int getperiodo() {
		return periodo;
	}

	public void setperiodo(int periodo) {
		this.periodo = periodo;
	}

	public String getDataRealDaDevolucaoDoItem() {
		return dataRealDaDevolucaoDoItem;
	}

	public void setDataRealDaDevolucaoDoItem(String dataRealDaDevolucaoDoItem) {
		this.dataRealDaDevolucaoDoItem = dataRealDaDevolucaoDoItem;
	}

}
