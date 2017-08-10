package util;

import java.util.List;

import excecoes.OperacaoNaoPermitidaNoMomentoExcecao;
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
			throw new IllegalArgumentException("Duracao nao pode ser menor ou igual a zero");
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
	public void validaClassificacao(String classificacao) {
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
			throw new IllegalArgumentException("Ano nao pode ser menor ou igual a zero.");
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
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
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

	/**
	 * Valida se valor tem o formato de um Inteiro.
	 * 
	 * @param valor
	 *            - String a ser convertida em Int.
	 */
	public void validaConversaoStringToInt(String atributo, String valor) {
		try {
			Integer.parseInt(valor);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(atributo + " deve ter o formato de um tipo int");
		}

		if (Integer.parseInt(valor) <= 0) {
			throw new IllegalArgumentException("Valor nao pode ser menor ou igual a zero para essa operacao");

		}

	}

	/**
	 * Valida se valor tem o formato de um Double.
	 * 
	 * @param valor
	 *            - String a ser convertida em Int.
	 */
	public void validaConversaoStringToDouble(String atributo, String valor) {
		try {
			Double.parseDouble(valor);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(atributo + " deve ter o formato de um tipo double");
		}

		if (Double.parseDouble(valor) <= 0) {
			throw new IllegalArgumentException("Valor nao pode ser menor ou igual a zero para essa operacao");

		}
	}

	/**
	 * Valida dados referentes a uma entidade do tipo Emprestimo.
	 * 
	 * @param nomeDono
	 *            o nome do usuário dono do item a ser emprestado.
	 * @param telefoneDono
	 *            o telefone do usuário dono do item a se emprestado.
	 * @param nomeRequerente
	 *            o nome do usuário que deseja pegar o item emprestado.
	 * @param telefoneRequerente
	 *            o telefone do usuário que deseja pegar o item emprestado.
	 * @param nomeItem
	 *            o nome do item a ser emprestado.
	 * @param dataEmprestimo
	 *            a data em que o emprestimo foi iniciado.
	 */
	public void validaDadosDeEmprestimos(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo) {
		this.validaNome(nomeDono);
		this.validaNome(nomeRequerente);
		this.validaNomeItem(nomeItem);
		this.validaTelefone(telefoneDono);
		this.validaTelefone(telefoneRequerente);
		this.validaData(dataEmprestimo);
	}

	/**
	 * Valida uma lista de itens recebida no parâmetro.
	 * 
	 * @param itens
	 *            uma lista de itens a ser validada.
	 */
	public void validaListaParaListagem(List<Item> itens) {
		if (itens == null)
			throw new NullPointerException("A lista de itens para listagem nao pode ser nula");

		if (itens.size() == 0) {
			throw new OperacaoNaoPermitidaNoMomentoExcecao("Nao ha itens para serem listados no momento");
		}

		for (Item item : itens) {
			if (item == null)
				throw new NullPointerException("A lista de itens para listagem nao pode possuir itens nulos");
		}

	}

	/**
	 * Valida atributos de cadastro de blu-rays
	 * 
	 * @param duracao
	 *            a duração do blu-ray a ser validada.
	 * @param classificacao
	 *            a classificação do blu-ray a ser validada.
	 */
	public void validaAtributosDeCadastroDeBluRays(int duracao, String classificacao) {
		this.validaDuracao(duracao);
		this.validaClassificacao(classificacao);
	}

	/**
	 * Valida atributos para cadastro de item.
	 * 
	 * @param nomeItem
	 *            o nome do item para cadastro.
	 * @param preco
	 *            o preço do item para cadastro.
	 */
	public void validaAtributosDeCadastroDeItem(String nomeItem, double preco) {
		this.validaNomeItem(nomeItem);
		this.validaPreco(preco);
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

}
