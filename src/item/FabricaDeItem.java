package item;

import item.blueray.Filme;
import item.blueray.Show;
import item.blueray.Temporada;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;

public class FabricaDeItem {
	
	public JogoEletronico criaJogoEletronico(String nome, double preco, String plataforma) {
		return new JogoEletronico(nome, preco, plataforma);
	}

	public JogoTabuleiro criaJogoTabuleiro(String nome, double preco) {
		return new JogoTabuleiro(nome, preco);
	}
	
	public Filme criaFilme(String nome, double preco, int duracao, String genero, String classificacao, int anoDeLancamento) {
		return new Filme(nome, preco, duracao, genero, classificacao, anoDeLancamento);
	}
	
	public Show criaShow(String nome, double preco, int duracao, int numDeFaixas, String artista, String classificacao) {
		return new Show(nome, preco, duracao, numDeFaixas, artista, classificacao);
	}
	
	public Temporada criaTemporada(String nome, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) {
		return new Temporada(nome, preco, descricao, duracao, classificacao, genero, temporada);
	}
	
}
