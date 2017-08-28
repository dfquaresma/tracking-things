package item.jogo;

import java.io.Serializable;

/**
 * Representação das plataformas disponíveis.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public enum Plataforma implements Serializable {

	PC("PC"), MAC("MAC"), PS3("PS3"), PS4("PS4"), XBOX360("XBOX360"), XBOX_ONE("XBOX_ONE"), NINTENDO_3DS(
			"NINTENDO_3DS"), OUTRO("OUTRO");

	private String plataforma;

	Plataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	/**
	 * Retorna uma representação em string deste enum.
	 */
	@Override
	public String toString() {
		return this.plataforma;
	}

}
