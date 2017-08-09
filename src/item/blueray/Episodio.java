package item.blueray;

import util.Validador;

/**
 * Description: Um episodio eh uma unidade de blu-ray, cada temporada tem uma serie de episodios e a duracao de todos os episodios
 * 				de uma temporada tem que ser igual a duracao total da temporada.
 *
 */
public class Episodio {

	private int duracao;
	private Validador validador;

	public Episodio(int duracao) {
		this.validador = new Validador();
		this.validador.validaDuracao(duracao);
		this.duracao = duracao;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.validador.validaDuracao(duracao);
		this.duracao = duracao;
	}

}
