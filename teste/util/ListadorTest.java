package util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import emprestimo.Emprestimo;
import item.Item;
import item.bluray.Show;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;
import usuario.Usuario;

/**
 * Testa as funcionalidades da classe Listador
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class ListadorTest {
	private Listador listador;
	private List<Item> itens;
	private List<Usuario> usuarios;
	private List<Emprestimo> emprestimos;
	private JogoEletronico itemA;
	private JogoTabuleiro itemB;
	private Show itemC;
	private Usuario user1;
	private Usuario user2;
	private Usuario user3;
	private Emprestimo emprestimo1;
	private Emprestimo emprestimo2;
	private Emprestimo emprestimo3;

	/**
	 * Configura o ambiente de teste para garantir a validez dos testes.
	 */
	@Before
	public void setUp() {
		this.itens = new ArrayList<>();
		this.itemA = new JogoEletronico("Dota", 30, "PC");
		this.itemB = new JogoTabuleiro("Xadrez", 20);
		this.itemC = new Show("AC_DC - LIVE in River Plate", 50, 2, 11, "AC_DC", "DEZ_ANOS");

		this.listador = new Listador();
		this.itens.add(itemA);
		this.itens.add(itemB);
		this.itens.add(itemC);

		this.user1 = new Usuario("Amandio", "3371-0000", "amandio@gmail.com");
		this.user2 = new Usuario("Testandio", "3371-0001", "testandio@ccc.ufcg.edu.com");
		this.user3 = new Usuario("Errandio", "3371-0002", "errandio@hotmail.com");

		this.usuarios = new ArrayList<>();
		this.usuarios.add(user1);
		this.usuarios.add(user2);
		this.usuarios.add(user3);

		user1.adicionaItem(itemA);
		user2.adicionaItem(itemB);
		user3.adicionaItem(itemC);
		this.emprestimo1 = new Emprestimo(user1, user2, itemA.getNome(), "18/08/2017", 1);
		this.emprestimo2 = new Emprestimo(user2, user3, itemB.getNome(), "16/08/2017", 2);
		this.emprestimo3 = new Emprestimo(user3, user1, itemC.getNome(), "15/08/2017", 3);

		this.emprestimos = new ArrayList<>();
		this.emprestimos.add(emprestimo1);
		this.emprestimos.add(emprestimo2);
		this.emprestimos.add(emprestimo3);
	}

	/**
	 * Verifica se a listagem por ordem de nome funciona como esperado e se lança
	 * exceção quando nessário.
	 */
	@Test
	public void testListaItensOrdenadosPorNome() {
		try {
			listador.listaItensOrdenadosPorNome(null);
			fail();
		} catch (Exception e) {
			assertEquals("A lista de itens para listagem nao pode ser nula", e.getMessage());
		}

		assertEquals(itemC.toString() + "|" + itemA.toString() + "|" + itemB.toString() + "|",
				listador.listaItensOrdenadosPorNome(itens));
	}

	/**
	 * Verifica se a listagem de itens ordenados por valor funciona como esperado e
	 * se lança exceção quando necessário.
	 */
	@Test
	public void testListaItensOrdenadosPorValor() {
		try {
			listador.listaItensOrdenadosPorValor(null);
			fail();
		} catch (Exception e) {
			assertEquals("A lista de itens para listagem nao pode ser nula", e.getMessage());
		}

		assertEquals(itemB.toString() + "|" + itemA.toString() + "|" + itemC.toString() + "|",
				listador.listaItensOrdenadosPorValor(itens));
	}

	@Test
	public void listarItensNaoEmprestados() {
		fail();
	}

	@Test
	public void listarItensEmprestados() {
		fail();
	}

	@Test
	public void testListarTop10Itens() {
		this.itemA.setEmprestado(false);
		this.itemA.setEmprestado(true);
		this.itemA.setEmprestado(false);
		this.itemA.setEmprestado(true);

		this.itemB.setEmprestado(false);
		this.itemB.setEmprestado(true);

		assertEquals("1) 3 emprestimos - " + itemA.toString() + "|2) 2 emprestimos - " + itemB.toString()
				+ "|3) 1 emprestimos - " + itemC.toString() + "|", listador.listarTop10Itens(itens));
	}

	@Test
	public void listarEmprestimosUsuarioEmprestando() {
		fail();
	}

	@Test
	public void listarEmprestimosUsuarioPegandoEmprestado() {
		fail();
	}

	@Test
	public void listarEmprestimosItem() {
		fail();
	}

	@Test
	public void testListarCaloteiros() {
		fail();

	}

	@Test
	public void listarTop10MelhoresUsuarios() {
		fail();
	}

	public void listarTop10PioresUsuarios() {
		fail();
	}

}
