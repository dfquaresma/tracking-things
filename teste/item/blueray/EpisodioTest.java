package item.blueray;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EpisodioTest
{
	private Episodio episodio;
		
	@Before
	public void criaEpisodio()
	{
		this.episodio = new Episodio(1000);
	}
	
	@Test
	public void testEpisodio()
	{
		assertEquals(1000, this.episodio.getDuracao());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testEpisodioComDuracaoInvalida()
	{
		new Episodio(0);
	}
	
}
