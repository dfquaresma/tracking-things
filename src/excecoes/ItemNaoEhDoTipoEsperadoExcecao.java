package excecoes;

/**
 * Lançado para indicar que a operação sobre o item de interesse é inválida pois
 * o item não é do tipo esperado para a operação.
 * 
 * @author David Ferreira
 *
 */
public class ItemNaoEhDoTipoEsperadoExcecao extends RuntimeException {

	private static final long serialVersionUID = 296085355876777468L;

	/**
	 * Constrói uma ItemNaoEhDoTipoEsperadoExcecao com uma mensagem específica.
	 * 
	 * @param msg
	 *            a mensagem.
	 */
	public ItemNaoEhDoTipoEsperadoExcecao(String msg) {
		super(msg);
	}
}
