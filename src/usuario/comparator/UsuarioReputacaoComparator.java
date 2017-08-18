package usuario.comparator;

import java.util.Comparator;

import usuario.Usuario;

public class UsuarioReputacaoComparator implements Comparator<Usuario> {

	@Override
	public int compare(Usuario arg0, Usuario arg1) {
		if (arg0.getReputacao() == arg1.getReputacao()) {
			return 0;
		} else if (arg0.getReputacao() < arg1.getReputacao()) {
			return -1;
		} else {
			return 1;
		}
	}
	
}
