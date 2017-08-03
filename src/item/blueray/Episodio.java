package item.blueray;

/**
 * Description: Um episodio eh uma unidade de blu-ray, cada temporada tem uma serie de episodios e a duracao de todos os episodios
 * 				de uma temporada tem que ser igual a duracao total da temporada.
 *
 */
public class Episodio {

	private int duracao;
	
	public Episodio(int duracao) {
		this.duracao = duracao;
	}
	
	public int getDuracao() {
		return this.duracao;
	}

}
