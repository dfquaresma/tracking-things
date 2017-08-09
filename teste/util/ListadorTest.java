package util;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import item.Item;
import item.bluray.Show;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;

public class ListadorTest {
	private Listador listador;
	private ArrayList<Item> itens;
	private JogoEletronico itemA;
	private JogoTabuleiro itemB;
	private Show itemC;
	
	@Before
	public void setUp() {
		this.listador = new Listador();
		this.itens = new ArrayList<>();
		this.itemA = new JogoEletronico("Dota", 30, "PC");
		this.itemB = new JogoTabuleiro("Xadrez", 20);
		this.itemC = new Show("AC_DC - LIVE in River Plate", 50, 2, 11, "AC_DC", "DEZ_ANOS");		
		this.itens.add(itemA);
		this.itens.add(itemB);
		this.itens.add(itemC);
	}

	@Test
	public void testListaItensOrdenadosPorNome() {
		assertEquals( itemC.toString() + "|" + itemA.toString() + "|" + itemB.toString() + "|", listador.listaItensOrdenadosPorNome(itens) );
	}

	@Test
	public void testListaItensOrdenadosPorValor() {
		assertEquals( itemB.toString() + "|" + itemA.toString() + "|" + itemC.toString() + "|", listador.listaItensOrdenadosPorValor(itens) );
	}

}
