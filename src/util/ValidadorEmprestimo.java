package util;

import usuario.Usuario;

public class ValidadorEmprestimo {


	/**
	 * Valida um usuario, recebido no parâmetro, dono de um item.
	 * 
	 * @param dono
	 *            o dono a ser validado.
	 */
	public void validaDono(Usuario dono) {
		this.validaObjetos(dono, "Usuario dono");
	}

	/**
	 * Valida um usuario, recebido no parâmetro, requerente de um item.
	 * 
	 * @param requerente
	 *            o requerente a ser validado.
	 */
	public void validaRequerente(Usuario requerente) {
		this.validaObjetos(requerente, "Usuario requerente");
	}


	private void validaObjetos(Object o, String msg) {
		if (o == null) {
			throw new IllegalArgumentException(msg + " nao pode ser nulo");
		}
	}

	/**
	 * Valida um inteiro representando período de dias.
	 * 
	 * @param periodo
	 *            o período a ser validado.
	 */
	public void validaPeriodo(int periodo) {
		if (periodo <= 0) {
			throw new IllegalArgumentException("Periodo nao pode ser menor ou iguals a zero.");
		}

	}

	/**
	 * Valida uma data recebida como parâmetro.
	 * 
	 * @param data
	 *            a data a ser validada.
	 */
	public void validaData(String data) {
		this.validaString(data, "Data");
	}
	
	
	private void validaString(String atributo, String atributoMsg) {
		if (atributo == null) {
			throw new NullPointerException(atributoMsg + " nao pode ser nulo");
		}
		if (atributo.trim().isEmpty()) {
			throw new IllegalArgumentException(atributoMsg + " nao pode ser vazio");
		}
	}

}
