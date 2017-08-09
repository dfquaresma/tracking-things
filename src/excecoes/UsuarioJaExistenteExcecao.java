package excecoes;

/**
 * Lançado para indicar que o novo id de usuário (originado a partir de uma
 * atualização de nome ou telefone) pertence a outro usuário já cadastrado no
 * sistema.
 * 
 * @author David Ferreira
 *
 */
public class UsuarioJaExistenteExcecao extends RuntimeException {

	private static final long serialVersionUID = -487452161406235481L;

	/**
	 * Constrói uma UsuarioJaExistenteExcecao com uma mensagem específica.
	 * 
	 * @param msg
	 *            a mensagem.
	 */
	public UsuarioJaExistenteExcecao(String msg) {
		super(msg);
	}

}
