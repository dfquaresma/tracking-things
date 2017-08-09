package excecoes;

/**
 * Lançado para indicar que a operação não é permitida no momento.
 * 
 * @author David Ferreira
 *
 */
public class OperacaoNaoPermitidaNoMomentoExcecao extends RuntimeException {

	private static final long serialVersionUID = 5861420653202594172L;

	/**
	 * Constrói uma OperacaoNaoPermitidaNoMomentoExcecao com uma mensagem
	 * específica.
	 * 
	 * @param msg
	 *            a mensagem.
	 */
	public OperacaoNaoPermitidaNoMomentoExcecao(String msg) {
		super(msg);
	}

}
