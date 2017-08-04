package item.blueray;

/**
 * Description: Os blu rays de shows devem indicar o nome do artista e o número
 * de faixas.
 * 
 *
 */
public class Show extends BlueRay {

	private int numDeFaixas;
	private String artista;

	public Show(String nome, double valor, int duracao, int numDeFaixas, String artista, String classificacao) {
		super(nome, valor, duracao, classificacao);
		this.numDeFaixas = numDeFaixas;
		this.artista = artista;
	}

	public int getNumDeFaixas() {
		return numDeFaixas;
	}

	public void setNumDeFaixas(int numDeFaixas) {
		this.numDeFaixas = numDeFaixas;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	@Override
	public String getInfo(String atributo) {

		switch (atributo) {
		case ("Artista"):
			return this.artista;
		case ("Numero de Faixas"):
			return String.valueOf(this.numDeFaixas);
		default:
			return super.getInfo(atributo);
		}

	}

	@Override
	public String toString() {
		return "SHOW: " + super.getNome() + ", R$ " + super.getValor() + ", " + super.isEmprestadoString() + ", "
				+ super.getDuracao() + "min, " + super.getClassificacao() + this.numDeFaixas + ", " + this.artista;
	}

}
