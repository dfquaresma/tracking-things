package excecoes;

public class ExcecaoUsuarioJaExistente extends RuntimeException {

	private static final long serialVersionUID = -487452161406235481L;
	
	public ExcecaoUsuarioJaExistente(String msg) {
		super(msg);
	}
	
}
