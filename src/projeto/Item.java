package projeto;

public class Item {

	private String nome;
	private int valor;
	private boolean emprestado;

	public Item(String nome, int valor) {
		this.nome = nome;
		this.valor = valor;

		this.emprestado = false;
	}

	public String getNome() {
		return this.nome;
	}

	public int getValor() {
		return this.valor;
	}

	public boolean isEmprestado() {
		return this.emprestado;
	}

}
