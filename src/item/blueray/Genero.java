package item.blueray;

public enum Genero {

	ACAO("ACAO"), ANIMACAO("ANIMACAO"), AVENTURA("AVENTURA"), COMEDIA("COMEDIA"), DOCUMENTARIO("DOCUMENTARIO"), DRAMA("DRAMA"), EROTICO("EROTICO"), FAROESTE("FAROESTE"), FICCAO(
			"FICCAO"), MUSICAL("MUSICAL"), POLICIAL("POLICIAL"), ROMANCE("ROMANCE"), SUSPENSE("SUSPENSE"), TERROR("TERROR"), OUTRO("OUTRO");

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
