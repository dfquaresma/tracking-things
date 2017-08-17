package validador;

public class ValidadorUsuario {
	
	private void validaString(String atributo, String atributoMsg) {
		if (atributo == null) {
			throw new NullPointerException(atributoMsg + " nao pode ser nulo");
		}
		if (atributo.trim().isEmpty()) {
			throw new IllegalArgumentException(atributoMsg + " nao pode ser vazio");
		}
	}
	
	/**
	 * Valida um nome recebido como parâmetro.
	 * 
	 * @param nome
	 *            o nome a ser validado.
	 */
	public void validaNome(String nome) {
		this.validaString(nome, "Nome");
	}

	/**
	 * Valida um telefone recebido como parâmetro.
	 * 
	 * @param telefone
	 *            o telefone a ser validado.
	 */
	public void validaTelefone(String telefone) {
		this.validaString(telefone, "Telefone");
	}

	/**
	 * Valida um email recebido como parâmetro.
	 * 
	 * @param email
	 *            o email a ser validado.
	 */
	public void validaEmail(String email) {
		this.validaString(email, "Email");
	}
}
