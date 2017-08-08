package util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import item.Item;
import item.blueray.Classificacao;
import item.blueray.Genero;
import item.jogo.Plataforma;

public class Validador {

	private void validaString(String atributo, String atributoMsg) {
		if (atributo == null) {
			throw new NullPointerException(atributoMsg + " nao pode ser nulo");
		}
		if (atributo.trim().isEmpty()) {
			throw new IllegalArgumentException(atributoMsg + " nao pode ser vazio");
		}
	}

	public void validaNome(String nome) {
		this.validaString(nome, "Nome");
	}

	public void validaTelefone(String telefone) {
		this.validaString(telefone, "Telefone");
	}

	public void validaEmail(String email) {
		this.validaString(email, "Email");
	}

	public void validaValor(String valor) {
		this.validaString(valor, "Valor");
	}

	public void validaNomeItem(String nomeItem) {
		this.validaString(nomeItem, "Nome do item");
	}

	public void validaDuracao(int duracao) {
		if (duracao <= 0) {
			throw new IllegalArgumentException("Duracao nao pode ser negativa");
		}
	}

	public void validaArtista(String artista) {
		this.validaString(artista, "Artista");
	}

	public void validaClassificacao(String classificacao) {
		this.validaString(classificacao, "Classificacao");
		this.validaClassificacao(Classificacao.values(), classificacao);
	}

	private void validaClassificacao(Classificacao[] values, String classificacao) {
		Set<String> classificacoes = new HashSet<>();
		for (Classificacao c : values) {
			classificacoes.add(c.toString());
		}
		if (!classificacoes.contains(classificacao)) {
			throw new IllegalArgumentException("Classificacao inválida");
		}
	}

	public void validaNomeBluray(String nomeBluray) {
		this.validaString(nomeBluray, "Nome do bluray");
	}

	public void validaGenero(String genero) {
		this.validaString(genero, "Genero");
		this.validaGenero(Genero.values(), genero);
	}

	private void validaGenero(Genero[] values, String genero) {
		Set<String> generos = new HashSet<>();
		for (Genero g : values) {
			generos.add(g.toString());
		}
		if (!generos.contains(genero)) {
			throw new IllegalArgumentException("Genero inválido");
		}
	}

	public void validaTemporada(int temporada) {
		if (temporada <= 0) {
			throw new IllegalArgumentException("Temporada nao pode ser negativa");
		}

	}

	public void validaPlataforma(String plataforma) {
		this.validaString(plataforma, "Plataforma");
		this.validaPlataforma(Plataforma.values(), plataforma);
	}

	private void validaPlataforma(Plataforma[] values, String plataforma) {
		Set<String> plataformas = new HashSet<>();
		for (Plataforma p : values) {
			plataformas.add(p.toString());
		}
		if (!plataformas.contains(plataforma)) {
			throw new IllegalArgumentException("Plataforma inválida");
		}

	}

	public void validaAnoLancamento(int ano) {
		if (ano <= 0) {
			throw new IllegalArgumentException("Ano nao pode ser negativo");
		}
	}

	public void validaData(String data) {
		this.validaString(data, "Data");
	}

	public void validaPreco(double preco) {
		if (preco < 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
	}

	public void validaItensParaListagem(List<Item> itens) {
		if (itens == null) {
			throw new NullPointerException("A lista de itens para listagem nao pode ser nula");
		}
	}

	public void validaPeriodo(int periodo) {
		if (periodo <= 0) {
			throw new IllegalArgumentException("Periodo nao pode ser menor ou iguals a zero.");
		}

	}

	public void validaDescricao(String descricao) {
		this.validaString(descricao, "Descricao");

	}

	public void validaNumeroDeFaixas(int numeroFaixas) {
		if (numeroFaixas <= 0) {
			throw new IllegalArgumentException("Numero de faixar nao pode ser menor ou igual a zero.");
		}

	}

	public void validaAtributo(String atributo) {
		this.validaString(atributo, "Atributo");
		
	}

	public void validaPeca(String nomePeca) {
		this.validaString(nomePeca, "Nome da peca");
		
	}

}
