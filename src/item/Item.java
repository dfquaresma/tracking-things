package item;

import util.ValidadorItem;

/**
 * Representação de um item.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public abstract class Item {

	private String nome;
	private double preco;
	private boolean emprestado;
	private int qtdVezesEmprestado;
	protected ValidadorItem validador;

	/**
	 * Constrói um item com nome e preço.
	 * 
	 * @param nome
	 *            o nome do item.
	 * @param preco
	 *            o preço do item.
	 */
	public Item(String nome, double preco) {
		this.validador = new ValidadorItem();
		this.validador.validaNomeItem(nome);
		this.validador.validaPreco(preco);

		this.nome = nome;
		this.preco = preco;
		this.emprestado = false;
		this.qtdVezesEmprestado = 0;
	}

	/**
	 * Recupera um booleano informando se o item pode ser emprestado.
	 * 
	 * @return true caso possa ser emprestado, false caso contrário.
	 */
	public boolean podeSerEmprestado() {
		return !this.isEmprestado();
	}

	/**
	 * Recupera o nome deste item.
	 * 
	 * @return o nome.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Muda o nome deste item.
	 * 
	 * @param nome
	 *            o novo nome deste item.
	 */
	public void setNome(String nome) {
		this.validador.validaNomeItem(nome);
		this.nome = nome;
	}

	/**
	 * Recupera o preço deste item.
	 * 
	 * @return o preço deste item.
	 */
	public double getPreco() {
		return this.preco;
	}

	/**
	 * Recupera o número de vezes que este item foi emprestado.
	 * 
	 * @return quantas vezes foi emprestado.
	 */
	public int getQtdVezesEmprestado() {
		return this.qtdVezesEmprestado;
	}

	/**
	 * Muda o preço deste item.
	 * 
	 * @param preco
	 *            o novo preço deste item.
	 */
	public void setPreco(double preco) {
		this.validador.validaPreco(preco);
		this.preco = preco;
	}

	/**
	 * Recupera um booleano indicando se o item está ou não emprestado
	 * 
	 * @return true se estiver emprestado, false caso contrário.
	 */
	public boolean isEmprestado() {
		return this.emprestado;
	}

	/**
	 * Muda o estado de empréstimo deste item, recebendo um booleano indicando o
	 * estado do item.
	 * 
	 * @param emprestado
	 *            true caso o item agora tenha sido emprestado, false caso tenha
	 *            sido desolvido.
	 */
	public void setEmprestado(boolean emprestado) {
		if (this.emprestado == emprestado && this.emprestado) {
			throw new IllegalArgumentException("Item emprestado no momento");
		}
		if (this.emprestado == emprestado && !this.emprestado) {
			throw new IllegalArgumentException("Item nao esta emprestado no momento");
		}
		this.emprestado = emprestado;
		if (emprestado) {
			this.qtdVezesEmprestado++;			
		}
	}

	/**
	 * Recupera uma string representando o estado do item.
	 * 
	 * @return uma representação em string do estado do item.
	 */
	public String getEstadoEmprestimo() {
		return this.isEmprestado() ? "Emprestado" : "Nao emprestado";
	}

	/**
	 * Retorna um valor hash code desse item.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Indica quando um outro objeto é igual a este.
	 */
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

	/**
	 * Recupera um atributo deste item.
	 * 
	 * @param atributo
	 *            o atributo a ser recuperado.
	 * @return o valor do atributo em String.
	 */
	public String getInfo(String atributo) {
		this.validador.validaAtributo(atributo);

		switch (atributo) {
		case ("Nome"):
			return this.nome;
		case ("Preco"):
			return String.valueOf(this.preco);
		default:
			throw new IllegalArgumentException("Atributo invalido.");

		}

	}

	/**
	 * Atualiza um atributo específico deste item.
	 * 
	 * @param atributo
	 *            o atributo a ser atualizado.
	 * @param valor
	 *            o novo valor do atributo a ser atualizado
	 */
	public void atualizaAtributo(String atributo, String valor) {
		this.validador.validaAtributo(atributo);
		this.validador.validaValor(valor);

		if (atributo.equals("Nome")) {
			setNome(valor);

		} else if (atributo.equals("Preco")) {
			this.validador.validaConversaoStringToDouble(atributo, valor);
			setPreco(Double.parseDouble(valor));

		} else {
			throw new IllegalArgumentException("Atributo invalido");
		}

	}

}
