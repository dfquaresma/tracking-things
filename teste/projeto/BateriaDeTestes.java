package projeto;

import org.junit.Before;
import org.junit.Test;

import item.ComparadorPorValorTest;
import item.ItemTest;
import item.bluray.BluRayTest;
import item.bluray.EpisodioTest;
import item.bluray.FilmeTest;
import item.bluray.ShowTest;
import item.bluray.TemporadaTest;
import item.jogo.JogoEletronicoTest;
import item.jogo.JogoTabuleiroTest;
import usuario.IdUsuarioTest;
import util.ValidadorTest;

public class BateriaDeTestes {
	private ValidadorTest validador;
	private IdUsuarioTest id;
	private JogoTabuleiroTest jogoTabuleiro;
	private JogoEletronicoTest jogoEletronico;
	private TemporadaTest temporada;
	private ShowTest show;
	private FilmeTest filme;
	private EpisodioTest episodio;
	private BluRayTest bluray;
	private ItemTest item;
	private ComparadorPorValorTest comparadorPorValor;
	
	@Before
	public void setUp() {
		this.validador = new ValidadorTest();
		this.id = new IdUsuarioTest();
		this.jogoTabuleiro = new JogoTabuleiroTest();
		this.jogoEletronico = new JogoEletronicoTest();
		this.temporada = new TemporadaTest();
		this.show = new ShowTest();
		this.filme = new FilmeTest();
		this.episodio = new EpisodioTest();
		this.bluray = new BluRayTest();
		this.item = new ItemTest();
		this.comparadorPorValor = new ComparadorPorValorTest();
	}
	
	@Test
	public void testMaster() {
		// aqui iremos implementar algo para sair testando tudo... kk
	}
	

}
