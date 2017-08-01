package sistema;

public class Emprestimo {

	private String donoDoItem;
	private String quemPegouEmprestado;
	private String itemEmprestado;
	private String dataInicial;
	private int diasCombinadosDoEmprestimo;
	private String dataRealDaDevolucaoDoItem;

	public Emprestimo(String donoDoItem, String quemPegouEmprestado, String itemEmprestado, String dataInicial,
			int diasCombinadosDoEmprestimo, String dataRealDaDevolucaoDoItem) {

		this.donoDoItem = donoDoItem;
		this.quemPegouEmprestado = quemPegouEmprestado;
		this.itemEmprestado = itemEmprestado;
		this.dataInicial = dataInicial;
		this.diasCombinadosDoEmprestimo = diasCombinadosDoEmprestimo;
		this.dataRealDaDevolucaoDoItem = dataRealDaDevolucaoDoItem;

	}

	public String getDonoDoItem() {
		return donoDoItem;
	}

	public void setDonoDoItem(String donoDoItem) {
		this.donoDoItem = donoDoItem;
	}

	public String getQuemPegouEmprestado() {
		return quemPegouEmprestado;
	}

	public void setQuemPegouEmprestado(String quemPegouEmprestado) {
		this.quemPegouEmprestado = quemPegouEmprestado;
	}

	public String getItemEmprestado() {
		return itemEmprestado;
	}

	public void setItemEmprestado(String itemEmprestado) {
		this.itemEmprestado = itemEmprestado;
	}

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public int getDiasCombinadosDoEmprestimo() {
		return diasCombinadosDoEmprestimo;
	}

	public void setDiasCombinadosDoEmprestimo(int diasCombinadosDoEmprestimo) {
		this.diasCombinadosDoEmprestimo = diasCombinadosDoEmprestimo;
	}

	public String getDataRealDaDevolucaoDoItem() {
		return dataRealDaDevolucaoDoItem;
	}

	public void setDataRealDaDevolucaoDoItem(String dataRealDaDevolucaoDoItem) {
		this.dataRealDaDevolucaoDoItem = dataRealDaDevolucaoDoItem;
	}
	
	
	

}
