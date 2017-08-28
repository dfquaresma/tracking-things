package excecoes;

import java.io.Serializable;

/**
 * Lançado para indicar que a operação sobre o item de interesse é inválida pois
 * o item não é do tipo esperado para a operação.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class ItemNaoEhDoTipoEsperadoExcecao extends RuntimeException implements Serializable {

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
