package excecoes;

public class ItemNaoEhDoTipoEsperadoExcecao extends RuntimeException {

	private static final long serialVersionUID = 296085355876777468L;

	public ItemNaoEhDoTipoEsperadoExcecao (String msg) {
		super(msg);
	}
}
