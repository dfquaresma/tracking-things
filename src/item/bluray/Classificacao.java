package item.bluray;

import java.io.Serializable;

/**
 * Representação das classificações disponíveis.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public enum Classificacao implements Serializable {

	LIVRE("LIVRE"), DEZ_ANOS("DEZ_ANOS"), DOZE_ANOS("DOZE_ANOS"), QUATORZE_ANOS("QUATORZE_ANOS"), DEZESSEIS_ANOS(
			"DEZESSEIS_ANOS"), DEZOITO_ANOS("DEZOITO_ANOS");

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
