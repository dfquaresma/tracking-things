package item.bluray;

/**
 * Representação de um show em blu-ray.
 * 
 * @author David Ferreira
 *
 */
public class Show extends BluRay {

	private int numDeFaixas;
	private String artista;

	/**
	 * Constrói um show blu-ray com nome, preço, duração, numero de faixas,
	 * artista e classificação.
	 * 
	 * @param nome
	 *            o nome do show.
	 * @param preco
	 *            o preço do show.
	 * @param duracao
	 *            a duração do show.
	 * @param numDeFaixas
	 *            o número de faixas do show.
	 * @param artista
	 *            o artista do show.
	 * @param classificacao
	 *            a classificação do show.
	 */
	public Show(String nome, double valor, int duracao, int numDeFaixas, String artista, String classificacao) {
		super(nome, valor, duracao, classificacao);
		this.validador.validaNumeroDeFaixas(numDeFaixas);
		this.validador.validaArtista(artista);
		
		this.numDeFaixas = numDeFaixas;
		this.artista = artista;
	}

	/**
	 * Recupera o número de faixas do show.
	 * 
	 * @return um inteiro representando o número de faixas.
	 */
	public int getNumDeFaixas() {
		return numDeFaixas;
	}

	/**
	 * Atualiza o número de faixas do show.
	 * 
	 * @param numDeFaixas
	 *            o novo número de faixas.
	 */
	public void setNumDeFaixas(int numDeFaixas) {
		this.validador.validaNumeroDeFaixas(numDeFaixas);
		this.numDeFaixas = numDeFaixas;
	}

	/**
	 * Recupera o nome artista do show.
	 * 
	 * @return uma representação em String do nome do artista.
	 */
	public String getArtista() {
		return artista;
	}

	/**
	 * Atualiza o nome do artista do show.
	 * 
	 * @param artista
	 *            o novo nome do artista.
	 */
	public void setArtista(String artista) {
		this.validador.validaArtista(artista);
		this.artista = artista;
	}

	/**
	 * Sobrescreve o método da classe mãe para verificar se o atributo a ser
	 * recuperado pertence a esta classe. Caso não seja, o método da classe mãe
	 * é chamado.
	 */
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

	/**
	 * Retorna uma representação em string deste jogo.
	 */
	@Override
	public String toString() {
		return "SHOW: " + this.getNome() + ", R$ " + String.valueOf(this.getPreco())
				+ ", " + this.getEstadoEmprestimo() + ", " + this.getDuracao() + " min, " + this.getClassificacao() + ", "
				+ this.getArtista() + ", " + this.getNumDeFaixas() + " faixas";
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
		
		if (atributo.equals("Artista")) {
			this.artista = valor;			
			
		} else if (atributo.equals("Numero de faixas")) {
			this.validador.validaConversaoStringToInt(atributo, valor);
			this.numDeFaixas = Integer.parseInt(valor);
		
		} else {
			super.atualizaAtributo(atributo, valor);
		}
		
	}

}
