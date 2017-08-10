package item.bluray;

/**
 * Representação de um filme blu-ray.
 */
public class Filme extends BluRay {

	private Genero genero;
	private int anoDeLancamento;

	/**
	 * Constrói um filme com nome, preço, duração, gênero, classificação e ano
	 * de lançamento.
	 * 
	 * @param nome
	 *            o nome do filme.
	 * @param preco
	 *            o preço do filme.
	 * @param duracao
	 *            a duração do filme.
	 * @param genero
	 *            o gênero do filme.
	 * @param classificacao
	 *            a classificação do filme.
	 * @param anoDeLancamento
	 *            o ano de lançamento do filme.
	 */
	public Filme(String nome, double valor, int duracao, String genero, String classificacao, int anoDeLancamento) {
		super(nome, valor, duracao, classificacao);
		this.validador.validaGenero(genero);
		this.validador.validaAnoLancamento(anoDeLancamento);
		
		this.genero = Genero.valueOf(genero);
		this.anoDeLancamento = anoDeLancamento;
	}

	/**
	 * Recupera o gênero do filme.
	 * 
	 * @return uma representação em string do filme.
	 */
	public String getGenero() {
		return genero.toString();
	}

	/**
	 * Atualiza o gênero do filme para o gênero passado no parâmetro.
	 * 
	 * @param genero
	 *            o novo gênero do filme.
	 */
	public void setGenero(String genero) {
		this.validador.validaGenero(genero);
		this.genero = Genero.valueOf(genero);
	}

	/**
	 * Recupera o ano de lançamento do filme.
	 * 
	 * @return um inteiro representando o ano de lançamento do filme.
	 */
	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}

	/**
	 * Atualiza o ano de lançamento do filme a partir do parâmetro recebido.
	 * 
	 * @param anoDeLancamento
	 *            o novo ano de lançamento do filme.
	 */
	public void setAnoDeLancamento(int anoDeLancamento) {
		this.validador.validaAnoLancamento(anoDeLancamento);
		this.anoDeLancamento = anoDeLancamento;
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
		case ("Genero"):
			return this.genero.toString();
		case ("Lancamento"):
			return String.valueOf(this.anoDeLancamento);
		default:
			return super.getInfo(atributo);
		}

	}

	/**
	 * Retorna uma representação em string deste usuário.
	 */
	@Override
	public String toString() {
		return "FILME: " + this.getNome() + ", R$ " + String.valueOf(this.getPreco()) + ", "
				+ this.getEstadoEmprestimo() + ", " + this.getDuracao() + " min, " + this.getClassificacao() + ", "
				+ this.getGenero() + ", " + this.getAnoDeLancamento();
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
		
		if (atributo.equals("Genero")) {
			this.validador.validaGenero(valor);
			this.genero = Genero.valueOf(valor);			
			
		} else if (atributo.equals("Ano de Lancamento")) {
			this.validador.validaConversaoStringToInt(atributo, valor);
			this.anoDeLancamento = Integer.parseInt(valor);
		
		} else {
			super.atualizaAtributo(atributo, valor);
		}
		
	}

}
