package util;

import java.util.List;

import item.Item;
import item.bluray.Classificacao;
import item.bluray.Genero;
import item.jogo.Plataforma;
import usuario.Usuario;

/**
 * Represetanção de um validador.
 * 
 * @author David Ferreira
 *
 */
public class Validador {

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

	/**
	 * Valida um valor recebido como parâmetro.
	 * 
	 * @param valor
	 *            o valor a ser validado.
	 */
	public void validaValor(String valor) {
		this.validaString(valor, "Valor");
	}

	/**
	 * Valida um nome de item recebido como parâmetro.
	 * 
	 * @param nomeItem
	 *            o nome a ser validado.
	 */
	public void validaNomeItem(String nomeItem) {
		this.validaString(nomeItem, "Nome do item");
	}

	/**
	 * Valida uma duração recebida como parâmetro.
	 * 
	 * @param duracao
	 *            a duração a ser validada.
	 */
	public void validaDuracao(int duracao) {
		if (duracao <= 0) {
			throw new IllegalArgumentException("Duracao nao pode ser negativa");
		}
	}

	/**
	 * Valida um nome de artista recebido como parâmetro.
	 * 
	 * @param artista
	 *            o nome de artista a ser validado.
	 */
	public void validaArtista(String artista) {
		this.validaString(artista, "Artista");
	}

	/**
	 * Valida uma classificação de blu-ray recebido no parâmetro.
	 * 
	 * @param classificacao
	 *            a classificação a ser validada.
	 */
	public void validaClassificacao(String classificacao)
	{
		this.validaString(classificacao, "Classificacao");

		try {
			Classificacao.valueOf(classificacao);
		} catch (Exception e) {
			throw new IllegalArgumentException("Classificacao inválida");
		}
	}

	/**
	 * Valida o nome de um blu-ray recebido como parâmetro.
	 * 
	 * @param nomeBluray
	 *            o nome do blu-ray a ser validado.
	 */
	public void validaNomeBluray(String nomeBluray) {
		this.validaString(nomeBluray, "Nome do bluray");
	}

	/**
	 * Valida o gênero recebido no parâmetro.
	 * 
	 * @param genero
	 *            o gênero a ser validado.
	 */
	public void validaGenero(String genero) {
		this.validaString(genero, "Genero");

		try {
			Genero.valueOf(genero);
		} catch (Exception e) {
			throw new IllegalArgumentException("Genero inválido");
		}

	}

	/**
	 * Valida um inteiro representado o número da temporada.
	 * 
	 * @param temporada
	 *            o número da temporada.
	 */
	public void validaTemporada(int temporada) {
		if (temporada <= 0) {
			throw new IllegalArgumentException("Temporada nao pode ser negativa");
		}

	}

	/**
	 * Valida uma plataforma recebida no parâmetro.
	 * 
	 * @param plataforma
	 *            a plataforma a ser validada.
	 */
	public void validaPlataforma(String plataforma) {
		this.validaString(plataforma, "Plataforma");

		try {
			Plataforma.valueOf(plataforma);
		} catch (Exception e) {
			throw new IllegalArgumentException("Plataforma inválida");
		}

	}

	/**
	 * Valida um inteiro representando um ano qualquer recebido no parâmetro.
	 * 
	 * @param ano
	 *            o ano a ser validado.
	 */
	public void validaAnoLancamento(int ano) {
		if (ano <= 0) {
			throw new IllegalArgumentException("Ano nao pode ser negativo");
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

	/**
	 * Valida um preço recebido como parâmetro.
	 * 
	 * @param preco
	 *            o preço a ser validado.
	 */
	public void validaPreco(double preco) {
		if (preco < 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
	}

	/**
	 * Valida uma lista de itens recebida no parâmetro.
	 * 
	 * @param itens
	 *            uma lista de itens a ser validada.
	 */
	public void validaItensParaListagem(List<Item> itens)
	{
		if (itens == null)
			throw new NullPointerException("A lista de itens para listagem nao pode ser nula");
		for(Item item : itens)
			if(item == null)
				throw new NullPointerException("A lista de itens para listagem nao pode possuir itens nulos");
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
	 * Valida uma descrição recebida no parâmetro.
	 * 
	 * @param descricao
	 *            a descrição a ser validada.
	 */
	public void validaDescricao(String descricao) {
		this.validaString(descricao, "Descricao");

	}

	/**
	 * Valida um numero de faixas.
	 * 
	 * @param numeroFaixas
	 *            o número de faixas a ser validada.
	 */
	public void validaNumeroDeFaixas(int numeroFaixas) {
		if (numeroFaixas <= 0) {
			throw new IllegalArgumentException("Numero de faixas nao pode ser menor ou igual a zero.");
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
	 * Valida um nome de peça perdida recebida como parâmetro.
	 * 
	 * @param nomePeca
	 *            o nome da peça a ser validado.
	 */
	public void validaPeca(String nomePeca) {
		this.validaString(nomePeca, "Nome da peca");
	}

	private void validaObjetos(Object o, String msg) {
		if (o == null) {
			throw new IllegalArgumentException(msg + " nao pode ser nulo");
		}
	}

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
	 * @param dono
	 *            o requerente a ser validado.
	 */
	public void validaRequerente(Usuario requerente) {
		this.validaObjetos(requerente, "Usuario requerente");
	}

	/**
	 * Valida um item qualquer recebido no parÂmetro.
	 * 
	 * @param item
	 *            o item a ser validado.
	 */
	public void validaItem(Item item) {
		this.validaObjetos(item, "Item");
	}

}
