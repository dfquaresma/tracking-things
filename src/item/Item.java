package item;

/**
 * Description: Todo item precisa manter o seu nome, o seu valor (que pode ser o valor de compra) e se esta ou não emprestado no momento.
 * 
 * @author paulofelipe
 *
 */
public abstract class Item implements Comparable<Item>
{

	private String nome;
	private double valor;
	private boolean emprestado;

	public Item(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
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
