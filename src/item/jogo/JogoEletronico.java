package item.jogo;

import java.io.Serializable;

import item.Item;

/**
 * Representação de um jogo eletrônico. Guarda as informações básicas para o que
 * é classificado com um jogo eletrônico neste sistema.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class JogoEletronico extends Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Plataforma plataforma;

	/**
	 * Constrói um jogo eletrônico com nome, preço e plataforma.
	 * 
	 * @param nome
	 *            o nome do jogo.
	 * @param preco
	 *            o preço do jogo.
	 * @param plataforma
	 *            a plataforma do jogo.
	 */
	public JogoEletronico(String nome, double preco, String plataforma) {
		super(nome, preco);
		this.validador.validaPlataforma(plataforma);
		this.plataforma = Plataforma.valueOf(plataforma);
	}

	/**
	 * Recupera a plataforma do jogo.
	 * 
	 * @return uma string representando a plataforma deste jogo.
	 */
	public String getPlataforma() {
		return plataforma.toString();
	}

	/**
	 * Atualiza a plataforma deste Jogo com a plataforma recebida como
	 * parâmetro.
	 * 
	 * @param plataforma
	 *            a nova plataforma deste jogo.
	 */
	public void setPlataforma(String plataforma) {
		this.validador.validaPlataforma(plataforma);
		this.plataforma = Plataforma.valueOf(plataforma);
	}

	/**
	 * Sobrescreve o método da classe mãe para verificar se o atributo a ser
	 * recuperado pertence a esta classe. Caso não seja, o método da classe mãe
	 * é chamado.
	 */
	@Override
	public String getInfo(String atributo) {
		this.validador.validaAtributo(atributo);

		if (atributo.equals("Plataforma")) {
			return this.plataforma.toString();
		}
		return super.getInfo(atributo);
	}

	/**
	 * Retorna uma representação em string deste jogo.
	 */
	@Override
	public String toString() {
		return "JOGO ELETRONICO: " + this.getNome() + ", R$ " + String.valueOf(this.getPreco()) + ", "
				+ this.getEstadoEmprestimo() + ", " + this.getPlataforma();
	}

	/**
	 * Sobrescreve o método da classe mãe para verificar se o atributo a ser
	 * atualizado pertence a esta classe. Caso não seja, o método da classe mãe
	 * é chamado.
	 */
	@Override
	public void atualizaAtributo(String atributo, String valor) {
		this.validador.validaAtributo(atributo);
		this.validador.validaValor(valor);

		if (atributo.equals("Plataforma")) {
			this.setPlataforma(valor);

		} else {
			super.atualizaAtributo(atributo, valor);
		}

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
		JogoEletronico other = (JogoEletronico) obj;
		if (plataforma != other.plataforma)
			return false;
		return true;
	}
}
