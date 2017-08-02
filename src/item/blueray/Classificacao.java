package item.blueray;

public enum Classificacao {

	LIVRE(""), DEZ_ANOS(""), DOZE_ANOS(""), QUATORZE_ANOS(""), DEZESSEIS_ANOS(""), DEZOITO_ANOS("");

	private String classificacao;

	private Classificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	/**
	 * Retorna uma representação em string deste enum.
	 */
	@Override
	public String toString() {
		return this.classificacao;
	}

}
