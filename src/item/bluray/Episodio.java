package item.bluray;

import java.io.Serializable;

import util.ValidadorItem;

/**
 * Representação de um episódio de temporada.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class Episodio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int duracao;
	private ValidadorItem validador;

	/**
	 * Constrói um episódio com duração.
	 * 
	 * @param duracao
	 *            a duração do episódio.
	 */
	public Episodio(int duracao) {
		this.validador = new ValidadorItem();
		this.validador.validaDuracao(duracao);
		this.duracao = duracao;
	}

	/**
	 * Recupera a duração de um episódio.
	 * 
	 * @return a duração do epoisódio.
	 */
	public int getDuracao() {
		return duracao;
	}

	/**
	 * Muda a duração de um episódio.
	 * 
	 * @param duracao
	 *            a nova duração do episódio.
	 */
	public void setDuracao(int duracao) {
		this.validador.validaDuracao(duracao);
		this.duracao = duracao;
	}

}
