package util;

import java.io.Serializable;

import item.Item;

/**
 * Represetanção de um validador de elementos associados a usuários.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class ValidadorUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	/**
	 * Valida um item recebido como parâmetro, lançando exceção sempre que o
	 * item for nulo.
	 * 
	 * @param item
	 *            o item a ser validado.
	 */
	public void validaItem(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("Item nao pode ser nulo");
		}
	}

	/**
	 * Valida o nome de item recebido no parâmetro. lança exceção sempre que o
	 * nome for vazio ou nulo.
	 * 
	 * @param nomeItem
	 *            o nome a ser validado.
	 */
	public void validaNomeItem(String nomeItem) {
		this.validaString(nomeItem, "Nome do item");
	}

	/**
	 * Valida dados de identificação.
	 * 
	 * @param nome
	 *            o nome do usuário a ser identificado.
	 * @param telefone
	 *            o telefone do usuário a ser identificado.
	 */
	public void validaDadosDeIdentificacao(String nome, String telefone) {
		this.validaNome(nome);
		this.validaTelefone(telefone);
	}

	private void validaString(String atributo, String atributoMsg) {
		if (atributo == null) {
			throw new NullPointerException(atributoMsg + " nao pode ser nulo");
		}
		if (atributo.trim().isEmpty()) {
			throw new IllegalArgumentException(atributoMsg + " nao pode ser vazio");
		}
	}

	/**
	 * Valida um atributo recebido no parâmetro.
	 * 
	 * @param atributo
	 *            o atributo a ser validado.
	 */
	public void validaAtributo(String atributo) {
		this.validaString(atributo, "Atributo");
	}

	/**
	 * Valida um valor recebido como parâmetro.
	 * 
	 * @param valor
	 *            o valor a ser validado.
	 */
	public void validaValor(String valor) {
		this.validaString(valor, "Valor");
	}

}
