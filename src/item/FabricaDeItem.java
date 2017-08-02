package item;

import item.blueray.Filme;
import item.blueray.Show;
import item.blueray.Temporada;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;

public class FabricaDeItem {
	
	public JogoEletronico criaJogoEletronico(String nome, double valor, String plataforma) {
		return new JogoEletronico(nome, valor, plataforma);
	}

	public JogoTabuleiro criaJogoTabuleiro(String nome, double valor) {
		return new JogoTabuleiro(nome, valor);
	}
	
	public Filme criaFilme(String nome, double valor, int duracao, String genero, String classificacao, int anoDeLancamento) {
		return new Filme(nome, valor, duracao, genero, classificacao, anoDeLancamento);
	}
	
	public Show criaShow(String nome, double valor, int duracao, int numDeFaixas, String artista, String classificacao) {
		return new Show(nome, valor, duracao, numDeFaixas, artista, classificacao);
	}
	
	public Temporada criaTemporada(String nome, double valor, String descricao, int duracao, String classificacao, String genero, int temporada) {
		return new Temporada(nome, valor, descricao, duracao, classificacao, genero, temporada);
	}
	
}
