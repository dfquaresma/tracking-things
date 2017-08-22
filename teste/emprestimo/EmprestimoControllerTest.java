package emprestimo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import emprestimo.comparador.EmprestimoComparatorNomeDono;
import item.Item;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;
import usuario.Usuario;

/**
 * Testa as funcionalidades da clase EmprestimoController.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class EmprestimoControllerTest {
	private EmprestimoController controller;
	private Usuario user1;
	private Usuario user2;
	private JogoEletronico item1;
	private JogoTabuleiro item2;

	/**
	 * Apenas inicializa algumas variáveis (antes de cada @Test) que serão úteis
	 * durante os testes.
	 */
	@Before
	public void testEmprestimoController() {
		this.controller = new EmprestimoController();
		this.user1 = new Usuario("Alguem", "3371-0001", "alguem@gmail.com");
		this.user2 = new Usuario("Outro", "3371-0002", "outro@gmail.com");
		this.item1 = new JogoEletronico("Bola Quadrada", 100000, "PC");
		this.item2 = new JogoTabuleiro("Xadrez Quadrado", 100000);
		this.user1.adicionaItem(this.item1);
		this.user2.adicionaItem(this.item2);
		this.controller.registrarEmprestimo(user1, user2, item1.getNome(), "08/08/2017", 4);
		this.controller.registrarEmprestimo(user2, user1, item2.getNome(), "08/08/2017", 4);
	}

	/**
	 * Testa se está registrando empréstimo corretamente.
	 */
	@Test
	public void testRegistrarEmprestimo() {
		Usuario user3 = new Usuario("Novo na budega", "3371-0000", "noov@gmil.com");
		JogoTabuleiro tabuleiro = new JogoTabuleiro("Algum", 123);
		user3.adicionaItem(tabuleiro);

		assertFalse(tabuleiro.isEmprestado());

		try {
			this.controller.registrarEmprestimo(user3, user1, tabuleiro.getNome(), "10/08/2017", 3);
		} catch (Exception e) {
			fail();
		}

		assertTrue(tabuleiro.isEmprestado());

	}

	/**
	 * Testa se está devolvendo um item, primeiro verifica que está emprestado,
	 * devolve e verifica que não está emprestado.
	 */
	@Test
	public void testDevolverItem() {
		assertTrue(this.item1.isEmprestado());
		this.controller.devolverItem(user1, user2, item1.getNome(), "08/08/2017", "12/08/2017");
		assertFalse(this.item1.isEmprestado());
	}

	/**
	 * Testa se está pegando um empréstimo corretamente.
	 */
	@Test
	public void testGetEmprestimo() {
		Usuario user1 = new Usuario("Alguem", "3371-0001", "alguem@gmail.com");
		Usuario user2 = new Usuario("Outro", "3371-0002", "outro@gmail.com");
		Item item1 = new JogoEletronico("Bola Quadrada", 100000, "PC");
		user1.adicionaItem(item1);
		Emprestimo emprestimo = new Emprestimo(user1, user2, item1.getNome(), "08/08/2017", 4);
		assertEquals(emprestimo, this.controller.getEmprestimo(user1, user2, item1.getNome(), "08/08/2017"));
	}

	/**
	 * Testa se está pegando empréstimo do usuário que está emprestando.
	 */
	@Test
	public void testGetEmprestimosUserEmprestando() {
		List<Emprestimo> emprestimos = this.controller.getEmprestimosUserEmprestando(this.user1);
		assertEquals(1, emprestimos.size());

		Item item = new JogoEletronico("Bola Quadrada", 100000, "PC");
		this.user1.adicionaItem(item);
		this.controller.registrarEmprestimo(user1, user2, item.getNome(), "21/08/2017", 4);

		emprestimos = this.controller.getEmprestimosUserEmprestando(this.user1);
		assertEquals(2, emprestimos.size());

		this.controller.devolverItem(user1, user2, item.getNome(), "21/08/2017", "25/08/2017");
		emprestimos = this.controller.getEmprestimosUserEmprestando(this.user1);
		assertEquals(2, emprestimos.size()); // A descrição da us5 não detalha,
												// então listamos até
												// emprestimos finalizados.

	}

	/**
	 * Testa se está pegando empréstimo do usuário que está pegando emprestado (requerente).
	 */
	@Test
	public void testGetEmprestimosUserPegandoEmprestado() {
		List<Emprestimo> emprestimos = this.controller.getEmprestimosUserPegandoEmprestado(this.user1);
		assertEquals(1, emprestimos.size());
	}

	/**
	 * Testa se está pegando os empréstimos de um certo item.
	 */
	@Test
	public void testGetEmprestimosItem() {
		List<Emprestimo> emprestimos = this.controller.getEmprestimosItem("Xadrez Quadrado");
		assertEquals(1, emprestimos.size());
	}

	/**
	 * Testa se está pegando os empréstimos não finalizados.
	 */
	@Test
	public void testGetEmprestimosNaoFinalizados() {
		List<Emprestimo> emprestimos = this.controller.getEmprestimosNaoFinalizados();
		emprestimos.sort(new EmprestimoComparatorNomeDono());
		assertEquals("Alguem", emprestimos.get(0).getNomeDono());
		assertEquals("Outro", emprestimos.get(1).getNomeDono());
	}

}
