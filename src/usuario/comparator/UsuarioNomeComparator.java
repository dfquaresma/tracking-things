package usuario.comparator;
import java.util.Comparator;

import usuario.Usuario;

public class UsuarioNomeComparator implements Comparator<Usuario> {

	@Override
	public int compare(Usuario o1, Usuario o2) {
		return o1.getNome().compareTo(o2.getNome());
	}

}
