package item;

public abstract class Item {

	private String nome;
	private double valor;
	private boolean emprestado;

	public Item(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;

		this.emprestado = false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isEmprestado() {
		return this.emprestado;
	}

	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}

}
