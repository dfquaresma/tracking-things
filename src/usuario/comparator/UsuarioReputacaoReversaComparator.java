package usuario.comparator;

import java.util.Comparator;

import usuario.Usuario;

/**
 * Representação de um comparador de usuários. O critério de comparação é a
 * reputação dos usuários envolvidos.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class UsuarioReputacaoReversaComparator implements Comparator<Usuario> {

	/**
	 * Comparada o usuarioA com o usuarioB. Retorna 0 caso estes usuários tenham
	 * reputações iguais, um valor maior que zero se usuarioA tiver menor
	 * reputação que usuarioBe uma valor negativo caso o usuarioB tenha uma
	 * reputação menor que usuarioA.
	 */
	@Override
	public int compare(Usuario usuarioA, Usuario usuarioB) {
		if (usuarioA.getReputacao() == usuarioB.getReputacao()) {
			return 0;
		} else if (usuarioA.getReputacao() < usuarioB.getReputacao()) {
			return -1;
		} else {
			return 1;
		}
	}

}
