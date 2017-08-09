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
		this.validador.validaNumeroDeFaixas(numDeFaixas);
		this.validador.validaArtista(artista);
		
		this.numDeFaixas = numDeFaixas;
		this.artista = artista;
	}

	public int getNumDeFaixas() {
		return numDeFaixas;
	}

	public void setNumDeFaixas(int numDeFaixas) {
		this.validador.validaNumeroDeFaixas(numDeFaixas);
		this.numDeFaixas = numDeFaixas;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.validador.validaArtista(artista);
		this.artista = artista;
	}

	@Override
	public String getInfo(String atributo) {
		this.validador.validaAtributo(atributo);

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
		return "SHOW: " + this.getNome() + ", R$ " + String.valueOf(this.getPreco())
				+ ", " + this.getEstadoEmprestimo() + ", " + this.getDuracao() + " min, " + this.getClassificacao() + ", "
				+ this.getArtista() + ", " + this.getNumDeFaixas() + " faixas";
	}
	
	@Override
	public void atualizaAtributo(String atributo, String valor) {
		this.validador.validaAtributo(atributo);
		this.validador.validaValor(valor);
		
		if (atributo.equals("Artista")) {
			this.artista = valor;			
			
		} else if (atributo.equals("Numero de faixas")) {
			this.numDeFaixas = Integer.parseInt(valor);
		
		} else {
			super.atualizaAtributo(atributo, valor);
		}
		
	}

}
