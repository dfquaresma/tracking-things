package item.bluray;

import java.io.Serializable;

/**
 * Representação dos gêneros disponíveis.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public enum Genero implements Serializable {

	ACAO("ACAO"), ANIMACAO("ANIMACAO"), AVENTURA("AVENTURA"), COMEDIA("COMEDIA"), DOCUMENTARIO("DOCUMENTARIO"), DRAMA(
			"DRAMA"), EROTICO("EROTICO"), FAROESTE("FAROESTE"), FICCAO("FICCAO"), MUSICAL("MUSICAL"), POLICIAL(
					"POLICIAL"), ROMANCE("ROMANCE"), SUSPENSE("SUSPENSE"), TERROR("TERROR"), OUTRO("OUTRO");

	private String Genero;

	private Genero(String genero) {
		this.Genero = genero;
	}

	/**
	 * Retorna uma representação em string deste enum.
	 */
	@Override
	public String toString() {
		return this.Genero;
	}

}
