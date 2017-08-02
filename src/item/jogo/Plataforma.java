package item.jogo;

public enum Plataforma {

	PC(""), MAC(""), PS3(""), PS4(""), XBOX360(""), XBOX_ONE(""), NINTENDO_3DS(""), OUTRO("");

	private String plataforma;

	private Plataforma(String plataforma) {
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
