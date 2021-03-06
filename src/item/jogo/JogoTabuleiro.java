package item.jogo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import item.Item;

/**
 * Representação de um jogo de tabuleiro. Guarda as informações básicas para o
 * que é classificado com jogo de tabuleiro neste sistema.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class JogoTabuleiro extends Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> pecasPerdidas;

	/**
	 * Constrói um jogo de tabuleiro com nome e preco.
	 * 
	 * @param nome
	 *            o nome do jogo.
	 * @param preco
	 *            o preco do jogo.
	 */
	public JogoTabuleiro(String nome, double preco) {
		super(nome, preco);
		this.pecasPerdidas = new ArrayList<>();
	}

	/**
	 * Adiciona uma peça a lista de peças perdidas.
	 * 
	 * @param nomePeca
	 *            o nome da peça perdida.
	 */
	public void adicionarPecaPerdida(String nomePeca) {
		this.validador.validaPeca(nomePeca);
		this.pecasPerdidas.add(nomePeca);
	}

	/**
	 * Recupera um booleano indicando se o jogo de tabuleiro está completo.
	 * 
	 * @return true caso esteja completo, false caso contrário.
	 */
	public boolean isCompleto() {
		return this.pecasPerdidas.size() == 0;
	}

	/**
	 * Indica quando um outro objeto é igual a este.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		JogoTabuleiro other = (JogoTabuleiro) obj;
		if (pecasPerdidas == null) {
			if (other.pecasPerdidas != null)
				return false;
		} else if (other.pecasPerdidas == null)
			return false;
		else {
			Collections.sort(this.pecasPerdidas);
			Collections.sort(other.pecasPerdidas);
		}

		if (!pecasPerdidas.equals(other.pecasPerdidas))
			return false;
		return true;
	}

	/**
	 * Retorna uma representação em string deste usuário.
	 */
	@Override
	public String toString() {
		return "JOGO DE TABULEIRO: " + this.getNome() + ", R$ " + String.valueOf(this.getPreco()) + ", "
				+ this.getEstadoEmprestimo() + ", " + (this.isCompleto() ? "COMPLETO" : "COM PECAS PERDIDAS");
	}

}
