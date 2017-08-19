package item;

import java.util.Iterator;
import java.util.List;

import item.bluray.Filme;
import item.bluray.Show;
import item.bluray.Temporada;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;
import util.ValidadorItem;

public class ItemController {

	private ValidadorItem validador; 

	public ItemController() {
		this.validador = new ValidadorItem();
	}

	/**
	 * Cadastra um jogo eletrônico.
	 * 
	 * @param nomeItem
	 *            o nome do jogo.
	 * @param nomeItem2 
	 * @param telefone 
	 * @param preco
	 *            o preço do jogo.
	 * @param plataforma
	 *            a plataforma do jogo.
	 */
	public Item cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		this.validador.validaAtributosDeCadastroDeItem(nomeItem, preco);
		this.validador.validaPlataforma(plataforma);
		return new JogoEletronico(nomeItem, preco, plataforma);
	}
	
	/**
	 * Cadastra um jogo de tabuleiro.
	 * 
	 * @param nomeItem
	 *            o nome do jogo.
	 * @param nomeItem2 
	 * @param telefone 
	 * @param preco
	 *            o preço do jogo.
	 */
	public Item cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		this.validador.validaAtributosDeCadastroDeItem(nomeItem, preco);
		return new JogoTabuleiro(nomeItem, preco);
	}

	/**
	 * Cadastra um filme blu-ray.
	 * 
	 * @param nomeItem
	 *            o nome do filme.
	 * @param nomeItem 
	 * @param telefone 
	 * @param preco
	 *            o preço do filme.
	 * @param duracao
	 *            a duração do filme.
	 * @param genero
	 *            o gênero do filme.
	 * @param classificacao
	 *            a classificação do filme.
	 * @param anoLancamento
	 *            o ano de lançamento do filme.
	 */
	public Item cadastrarBlurayFilme(String nome, String telefone, String nomeItem, double preco, int duracao, String genero, String classificacao,
			int anoLancamento) {
		this.validador.validaAtributosDeCadastroDeItem(nomeItem, preco);
		this.validador.validaAtributosDeCadastroDeBluRays(duracao, classificacao);
		this.validador.validaGenero(genero);
		this.validador.validaAnoLancamento(anoLancamento);

		return new Filme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
	}

	/**
	 * Cadastra uma temporada em blu-ray.
	 * 
	 * @param nomeItem
	 *            o nome da temporada.
	 * @param nomeItem 
	 * @param telefone 
	 * @param preco
	 *            o preço da temporada.
	 * @param descricao
	 *            a descrição da temporada.
	 * @param duracao
	 *            a duração da temporada.
	 * @param classificacao
	 *            a classificação da temporada.
	 * @param genero
	 *            o gênero da temporada.
	 * @param temporada
	 *            a temporada da temporada.
	 */
	public Item cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao, int duracao, String classificacao,
			String genero, int temporada) {
		this.validador.validaAtributosDeCadastroDeItem(nomeItem, preco);
		this.validador.validaAtributosDeCadastroDeBluRays(duracao, classificacao);
		this.validador.validaDescricao(descricao);
		this.validador.validaGenero(genero);
		this.validador.validaTemporada(temporada);
		return new Temporada(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
		
	}

	/**
	 * Cadastra um show blu-ray.
	 * 
	 * @param nomeItem
	 *            o nome do show.
	 * @param nomeItem2 
	 * @param telefone 
	 * @param preco
	 *            o preço do show.
	 * @param duracao
	 *            a duração do show.
	 * @param numeroFaixas
	 *            o número de faixar do show.
	 * @param artista
	 *            o artista do show.
	 * @param classificacao
	 *            a classificação do show.
	 */
	public Item cadastrarBlurayShow(String nome, String telefone, String nomeItem, double preco, int duracao, int numeroFaixas, String artista,
			String classificacao) {
		this.validador.validaAtributosDeCadastroDeItem(nomeItem, preco);
		this.validador.validaAtributosDeCadastroDeBluRays(duracao, classificacao);
		this.validador.validaNumeroDeFaixas(numeroFaixas);
		this.validador.validaArtista(artista);

		return new Show(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		
	}

	public List<Item> getItensNaoEmprestados(List<Item> itens) {		
		Iterator<Item> itr = itens.iterator();
		while (itr.hasNext()) {
			if (itr.next().isEmprestado()) {
				itr.remove();
			}
		}
		return itens;
		
	}
	


	
	
	
}
