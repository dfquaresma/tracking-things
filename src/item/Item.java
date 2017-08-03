package item;

public abstract class Item implements Comparable<Item>
{

	private String nome;
	private double valor;
	private boolean emprestado;

	public Item(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
		this.emprestado = false; //Um item no momento que eh cadastrado nao eh emprestado
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

	@Override
	public int compareTo(Item outroItem) {
		return this.nome.compareTo(outroItem.nome);
	}

}
