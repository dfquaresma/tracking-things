package usuario.comparator;

import java.util.Comparator;

import usuario.Usuario;

/**
 * Representação de um comparador de usuários. O critério de comparação é o nome
 * dos usuários envolvidos.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class UsuarioNomeComparator implements Comparator<Usuario> {

	/**
	 * Comparada o usuarioA com o usuarioB. Retorna 0 caso estes usuários tenham
	 * nomes iguais, um valor maior que zero se usuarioA vier depois do usuarioB
	 * na ordem alfabética e uma valor negativo caso o usuarioB venha depois do
	 * usuarioA na ordem alfabética.
	 */
	@Override
	public int compare(Usuario usuarioA, Usuario usuarioB) {
		return usuarioA.getNome().compareTo(usuarioB.getNome());
	}

}
