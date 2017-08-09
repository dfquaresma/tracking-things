package excecoes;

public class UsuarioJaExistenteExcecao extends RuntimeException {

	private static final long serialVersionUID = -487452161406235481L;
	
	public UsuarioJaExistenteExcecao(String msg) {
		super(msg);
	}
	
}
