package item.bluray;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import item.bluray.Episodio;

/**
 * Testa a criacao de um episodio.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class EpisodioTest {
	private Episodio episodio;

	/**
	 * Prepara o ambiente para testes.
	 */
	@Before
	public void criaEpisodio() {
		this.episodio = new Episodio(1000);
	}

	/**
	 * Testa pegar a duracao de um episodio
	 */
	@Test
	public void testEpisodio() {
		assertEquals(1000, this.episodio.getDuracao());
	}

	/**
	 * Testa instanciar um episodio passando como parametro zero
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testEpisodioComDuracaoInvalida() {
		new Episodio(0);
	}

	/**
	 * Testa se esta atualizando corretamente a duração do episódio.
	 */
	@Test
	public void testSetEpisodioDuracao() {
		this.episodio.setDuracao(1);
		assertEquals(1, this.episodio.getDuracao());
	}

	/**
	 * Testa se é lançada exceção quando tenta-se atualizar a duração para o
	 * valor 0.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetEpisodioDuracaoInvalido() {
		this.episodio.setDuracao(0);
	}

}
