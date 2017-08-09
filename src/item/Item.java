package item;

/**
 * Description: Todo item precisa manter o seu nome, o seu valor (que pode ser o
 * valor de compra) e se esta ou não emprestado no momento.
 * 
 *
 */
public abstract class Item implements Comparable<Item> {

	private String nome;
	private double preco;
	private boolean emprestado;

	public Item(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
		this.emprestado = false;
	}

	public boolean podeSerEmprestado() {
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isEmprestado() {
		return this.emprestado;
	}

	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}

	public String getEstadoEmprestimo() {
		return this.isEmprestado() ? "Emprestado" : "Nao emprestado";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Item other = (Item) obj;
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Item outroItem) {
		return this.nome.compareTo(outroItem.nome);
	}

	public String getInfo(String atributo) {

		switch (atributo) {
		case ("Nome"):
			return this.nome;
		case ("Preco"):
			return String.valueOf(this.preco);
		default:
			throw new IllegalArgumentException();

		}

	}

	public void atualizaAtributo(String atributo, String valor) {
		
		if (atributo.equals("Nome")) {
			setNome(valor);

		} else if (atributo.equals("Preco")) {
			setPreco(Double.parseDouble(valor));

		} else {
			throw new IllegalArgumentException("Atributo invalido");
		}
		
	}
	
}
