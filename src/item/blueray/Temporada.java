package item.blueray;

import java.util.ArrayList;

/**
 * Description: No blu ray de uma temporada você deve guardar a coleção de blu-rays que compõem a temporada.
 * 				A colecao de blu rays que representa uma temporada de uma série deve manter, além da colecao de blu rays, 
 * 				o genero da serie e o numero da temporada.
 * 
 * 				Uma temporada so eh emprestavel se possuir todos os seus episodios em blue-rays (Voces decidiram que nao sera possivel emprestar um único blu ray de uma temporada, ou empresta a temporada inteira ou não empresta nada)
 *
 */
public class Temporada extends BlueRay {

	private String descricao;
	private Genero genero;
	private int temporada;
	private ArrayList<Episodio> episodios;

	public Temporada(String nome, double valor, String descricao, int duracao, String classificacao, String genero, int temporada) {
		super(nome, valor, duracao, classificacao);
		this.descricao = descricao;
		this.genero = ajustatGenero(genero);
		this.temporada = temporada;
		this.episodios = new ArrayList<Episodio>();
	}
	
	public void addBlueray(int duracao) {
		// NAO COMPLETO
		this.episodios.add(new Episodio(duracao));
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGenero() {
		return genero.toString();
	}

	public void setGenero(String genero) {
		this.genero = ajustatGenero(genero);
	}

	public int getTemporada() {
		return temporada;
	}

	public void setTemporada(int temporada) {
		this.temporada = temporada;
	}

	public void addBlueray(int duracao) {
		// NAO COMPLETO
		this.episodios.add(new Episodio(duracao));
	}
		
	@Override
	public String getInfo(String atributo){
		
		switch (atributo) {
		case("Descricao"):
			return this.descricao;
		case("Genero"):
			return this.genero.toString();
		case("Temporada"):
			return String.valueOf(this.temporada);
		default:
			return super.getInfo(atributo);
		}
		
	}
	
	private Genero ajustatGenero(String genero) {
		
		switch (genero) {
		
		case  ("ACAO"):
			return Genero.ACAO;

		case  ("ANIMACAO"):
			return Genero.ANIMACAO;

		case  ("AVENTURA"):
			return Genero.AVENTURA;

		case  ("COMEDIA"):
			return Genero.COMEDIA;

		case  ("DOCUMENTARIO"):
			return Genero.DOCUMENTARIO;

		case  ("DRAMA"):
			return Genero.DRAMA;
			
		case  ("EROTICO"):
			return Genero.EROTICO;
			
		case  ("FAROESTE"):
			return Genero.FAROESTE;
			
		case  ("FICCAO"):
			return Genero.FICCAO;
			
		case  ("MUSICAL"):
			return Genero.MUSICAL;
			
		case  ("POLICIAL"):
			return Genero.POLICIAL;
			
		case  ("ROMANCE"):
			return Genero.ROMANCE;
			
		case  ("SUSPENSE"):
			return Genero.SUSPENSE;

		case  ("TERROR"):
			return Genero.TERROR;
			
		case  ("OUTRO"):		
			return Genero.OUTRO;
			
		default:
			throw new IllegalArgumentException();
	
		}
		
	}

	@Override
	public boolean podeSerEmprestado()
	{
		int duracaoTotalEpisodios = 0;
		
		for(Episodio ep : this.episodios)
			duracaoTotalEpisodios += ep.getDuracao();
		
		return ( duracaoTotalEpisodios == super.getDuracao() );
	}
	
}
