package item.bluray;

import util.Validador;

/**
 * Representação de um episódio de temporada.
 * 
 * @author David Ferreira
 *
 */
public class Episodio {

	private int duracao;
	private Validador validador;

	/**
	 * Constrói um episódio com duração.
	 * 
	 * @param duracao
	 *            a duração do episódio.
	 */
	public Episodio(int duracao) {
		this.validador = new Validador();
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
