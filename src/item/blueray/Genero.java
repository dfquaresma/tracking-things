package item.blueray;

public enum Genero {

	ACAO(""), ANIMACAO(""), AVENTURA(""), COMEDIA(""), DOCUMENTARIO(""), DRAMA(""), EROTICO(""), FAROESTE(""), FICCAO(
			""), MUSICAL(""), POLICIAL(""), ROMANCE(""), SUSPENSE(""), TERROR(""), OUTRO("");

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
