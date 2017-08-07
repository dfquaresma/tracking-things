package excecoes;

public class ExcecaoItemNaoEhDoTipoEsperado extends RuntimeException {

	private static final long serialVersionUID = 296085355876777468L;

	public ExcecaoItemNaoEhDoTipoEsperado (String msg) {
		super(msg);
	}
}
