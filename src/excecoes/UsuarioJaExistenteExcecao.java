package excecoes;

import java.io.Serializable;

/**
 * Lançado para indicar que o novo id de usuário (originado a partir de uma
 * atualização de nome ou telefone) pertence a outro usuário já cadastrado no
 * sistema.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class UsuarioJaExistenteExcecao extends RuntimeException implements Serializable {

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
