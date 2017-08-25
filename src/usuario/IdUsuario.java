package usuario;

import java.io.Serializable;

import util.ValidadorUsuario;

/**
 * Representação de um identificador de usuário.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class IdUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String telefone;
	private ValidadorUsuario validador;

	/**
	 * Constrói um identificador com nome e telefone.
	 * 
	 * @param nome
	 *            o nome do usuário a ser identificado.
	 * @param telefone
	 *            o telefone do usuário a ser identificado.
	 */
	public IdUsuario(String nome, String telefone) {
		this.validador = new ValidadorUsuario();
		this.validador.validaNome(nome);
		this.validador.validaTelefone(telefone);

		this.nome = nome;
		this.telefone = telefone;
	}

	/**
	 * Recupera o nome do usuário que este objeta identificada.
	 * 
	 * @return o nome do usuário identificado.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Recupera o telefone do usuário que este objeta identificada.
	 * 
	 * @return o telefone do usuário identificado.
	 */
	public String getTelefone() {
		return this.telefone;
	}

	/**
	 * Retorna um valor hash code desse identificador.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	/**
	 * Indica quando um outro objeto é igual a este.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdUsuario other = (IdUsuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

}
