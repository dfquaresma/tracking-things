package item.bluray;

import java.util.ArrayList;

/**
 * Representação de uma temporada de série com episódios.
 * 
 * @author David Ferreira
 *
 */
public class Temporada extends BluRay {

	private String descricao;
	private Genero genero;
	private int temporada;
	private ArrayList<Episodio> episodios;

	/**
	 * Constrói uma temporada com nome, preço, descrição, duração,
	 * classificação, gênero e temporada (edição dessa temporada. Ex: temporada
	 * 1, temporada 2....).
	 * 
	 * @param nome
	 *            o nome da temporada.
	 * @param preco
	 *            o preço da série.
	 * @param descricao
	 *            a descrição da série.
	 * @param duracao
	 *            a duração da série.
	 * @param classificacao
	 *            a classificação da série.
	 * @param genero
	 *            o gênero da série.
	 * @param temporada
	 *            a edição da temporada.
	 */
	public Temporada(String nome, double valor, String descricao, int duracao, String classificacao, String genero,
			int temporada) {
		super(nome, valor, duracao, classificacao);
		this.validador.validaDescricao(descricao);
		this.validador.validaGenero(genero);
		this.validador.validaTemporada(temporada);
		
		this.descricao = descricao;
		this.genero = Genero.valueOf(genero);
		this.temporada = temporada;
		this.episodios = new ArrayList<Episodio>();
	}

	/**
	 * Recupera a descrição da temporada.
	 * 
	 * @return uma string representando a descrição.
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Atualiza a descrição da temporada.
	 * 
	 * @param descricao
	 *            a nova descrição da temporada.
	 */
	public void setDescricao(String descricao) {
		this.validador.validaDescricao(descricao);
		this.descricao = descricao;
	}

	/**
	 * Recupera o gênero da temporada.
	 * 
	 * @return uma string representando o gênero.
	 */
	public String getGenero() {
		return genero.toString();
	}

	/**
	 * Atualiza o gênero da temporada.
	 * 
	 * @param genero
	 *            o novo gênero.
	 */
	public void setGenero(String genero) {
		this.validador.validaGenero(genero);
		this.genero = Genero.valueOf(genero);
	}

	/**
	 * Recupera o número da temporada.
	 * 
	 * @return um inteiro indicando a temporada.
	 */
	public int getTemporada() {
		return temporada;
	}

	/**
	 * Atualiza o número da temporada.
	 * 
	 * @param temporada
	 *            o novo número da temporada.
	 */
	public void setTemporada(int temporada) {
		this.validador.validaTemporada(temporada);
		this.temporada = temporada;
	}

	/**
	 * Adiciona um episódio á temporada.
	 * 
	 * @param duracao
	 *            a duração do episódio a ser adicionado.
	 */
	public void addBlueray(int duracao) {
		this.validador.validaDuracao(duracao);
		this.episodios.add(new Episodio(duracao));
	}

	/**
	 * Sobrescreve o método da classe mãe para verificar se o atributo a ser
	 * recuperado pertence a esta classe. Caso não seja, o método da classe mãe
	 * é chamado.
	 */
	@Override
	public String getInfo(String atributo) {
		this.validador.validaAtributo(atributo);

		switch (atributo) {
		case ("Descricao"):
			return this.descricao;
		case ("Genero"):
			return this.genero.toString();
		case ("Temporada"):
			return String.valueOf(this.temporada);
		default:
			return super.getInfo(atributo);
		}

	}

	/**
	 * Recupera um booleano informando se o item pode ser emprestado.
	 * 
	 * @return true caso possa ser emprestado, false caso contrário.
	 */
	@Override
	public boolean podeSerEmprestado() {
		int duracaoTotalEpisodios = 0;

		for (Episodio ep : this.episodios)
			duracaoTotalEpisodios += ep.getDuracao();

		return (duracaoTotalEpisodios == super.getDuracao()) && super.podeSerEmprestado();
	}

	/**
	 * Retorna uma representação em string deste jogo.
	 */
	@Override
	public String toString() {
		return "SERIE: " + this.getNome() + ", R$ " + String.valueOf(this.getPreco()) + ", "
				+ this.getEstadoEmprestimo() + ", " + this.getDuracao() + " min, " + this.getClassificacao() + ", "
				+ this.getGenero() + ", Temporada " + this.getTemporada();
	}
	
	/**
	 * Sobrescreve o método da classe mãe para verificar se o atributo a ser
	 * atualizado pertence a esta classe. Caso não seja, o método da classe mãe
	 * é chamado.
	 */
	@Override
	public void atualizaAtributo(String atributo, String valor) {
		this.validador.validaAtributo(atributo);
		this.validador.validaValor(valor);
		
		if (atributo.equals("Descricao")) {
			this.descricao = valor;
			
		} else if (atributo.equals("Genero")) {
			this.genero = Genero.valueOf(valor);
			
		} else if (atributo.equals("Temporada")) {
			this.validador.validaConversaoStringToInt(atributo, valor);
			this.temporada = Integer.parseInt(valor);
			
		} else {
			super.atualizaAtributo(atributo, valor);
		}
		
	}

}
