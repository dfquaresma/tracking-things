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
		this.itemA = new JogoEletronico("Dota", 30, "PC");
		this.itemB = new JogoTabuleiro("Xadrez", 20);
		this.itemC = new Show("AC_DC - LIVE in River Plate", 50, 2, 11, "AC_DC", "DEZ_ANOS");

		this.user1 = new Usuario("Amandio", "3371-0000", "amandio@gmail.com");
		this.user2 = new Usuario("Testandio", "3371-0001", "testandio@ccc.ufcg.edu.com");
		this.user3 = new Usuario("Errandio", "3371-0002", "errandio@hotmail.com");

		user1.adicionaItem(itemA);
		user2.adicionaItem(itemB);
		user3.adicionaItem(itemC);
		this.emprestimo1 = new Emprestimo(user1, user2, itemA.getNome(), "18/08/2017", 1);
		this.emprestimo2 = new Emprestimo(user2, user3, itemB.getNome(), "16/08/2017", 2);
		this.emprestimo3 = new Emprestimo(user3, user1, itemC.getNome(), "15/08/2017", 3);

		this.listador = new Listador();
		this.itens = new ArrayList<>();
		this.emprestimos = new ArrayList<>();
		this.usuarios = new ArrayList<>();
	}

	/**
	 * Verifica se a listagem por ordem de nome funciona como esperado e se
	 * lança exceção quando nessário.
	 */
	@Test
	public void testListaItensOrdenadosPorNome() {
		try {
			listador.listaItensOrdenadosPorNome(null);
			fail();
		} catch (Exception e) {
			assertEquals("A lista de itens para listagem nao pode ser nula", e.getMessage());
		}

		adicionaItensAListaDeItens();
		assertEquals(itemC.toString() + "|" + itemA.toString() + "|" + itemB.toString() + "|",
				listador.listaItensOrdenadosPorNome(itens));
	}

	/**
	 * Verifica se a listagem de itens ordenados por valor funciona como
	 * esperado e se lança exceção quando necessário.
	 */
	@Test
	public void testListaItensOrdenadosPorValor() {
		try {
			listador.listaItensOrdenadosPorValor(null);
			fail();
		} catch (Exception e) {
			assertEquals("A lista de itens para listagem nao pode ser nula", e.getMessage());
		}

		adicionaItensAListaDeItens();
		assertEquals(itemB.toString() + "|" + itemA.toString() + "|" + itemC.toString() + "|",
				listador.listaItensOrdenadosPorValor(itens));
	}

	/**
	 * Verifica se a listagem de itens não emprestados funciona como esperado e
	 * se lança exceção quando necessário.
	 */
	@Test
	public void testlistarItensNaoEmprestados() {
		try {
			listador.listarItensNaoEmprestados(null);
			fail();
		} catch (Exception e) {
			assertEquals("A lista de itens para listagem nao pode ser nula", e.getMessage());
		}

		Item item1 = new JogoTabuleiro("Dama", 2);
		Item item2 = new JogoTabuleiro("Xadrez", 3);

		this.itens.add(item1);
		this.itens.add(item2);
		assertEquals(item1.toString() + "|" + item2.toString() + "|", listador.listarItensNaoEmprestados(itens));
	}

	/**
	 * Verifica se a listagem de itens emprestados funciona como esperado e se
	 * lança exceção quando necessário.
	 */
	@Test
	public void testlistarItensEmprestados() {
		try {
			listador.listarItensEmprestados(null);
			fail();
		} catch (Exception e) {
			assertEquals("A lista de emprestimos para listagem nao pode ser nula", e.getMessage());
		}

		adicionaEmprestimosAListaDeEmprestimos();
		assertEquals(
				"Dono do item: " + user1.getNome() + ", Nome do item emprestado: " + itemA.getNome() + "|"
						+ "Dono do item: " + user3.getNome() + ", Nome do item emprestado: " + itemC.getNome() + "|"
						+ "Dono do item: " + user2.getNome() + ", Nome do item emprestado: " + itemB.getNome() + "|",
				listador.listarItensEmprestados(emprestimos));
	}

	/**
	 * Verifica se a listagem dos 10 itens mais emprestados funciona como
	 * esperado e se lança exceção quando necessário.
	 */
	@Test
	public void testListarTop10Itens() {

		try {
			listador.listarTop10Itens(null);
			fail();
		} catch (Exception e) {
			assertEquals("A lista de itens para listagem nao pode ser nula", e.getMessage());
		}

		this.itemA.setEmprestado(false);
		this.itemA.setEmprestado(true);
		this.itemA.setEmprestado(false);
		this.itemA.setEmprestado(true);

		this.itemB.setEmprestado(false);
		this.itemB.setEmprestado(true);

		adicionaItensAListaDeItens();
		assertEquals("1) 3 emprestimos - " + itemA.toString() + "|2) 2 emprestimos - " + itemB.toString()
				+ "|3) 1 emprestimos - " + itemC.toString() + "|", listador.listarTop10Itens(itens));
		
		Item item = new JogoTabuleiro("War", 30);
		this.itens.add(item);
		
		assertEquals("1) 3 emprestimos - " + itemA.toString() + "|2) 2 emprestimos - " + itemB.toString()
		+ "|3) 1 emprestimos - " + itemC.toString() + "|", listador.listarTop10Itens(itens));
	}

	private void adicionaItensAListaDeItens() {
		this.itens.add(itemA);
		this.itens.add(itemB);
		this.itens.add(itemC);
	}

	/**
	 * Verifica se a listagem de emprestimos de um usuário ao emprestar funciona
	 * como esperado e se lança exceção quando necessário.
	 */
	@Test
	public void testlistarEmprestimosUsuarioEmprestando() {
		try {
			listador.listarEmprestimosUsuarioEmprestando(null);
			fail();
		} catch (Exception e) {
			assertEquals("A lista de emprestimos para listagem nao pode ser nula", e.getMessage());
		}

		assertEquals("Nenhum item emprestado", listador.listarEmprestimosUsuarioEmprestando(this.emprestimos));
		
		adicionaEmprestimosAListaDeEmprestimos();
		assertEquals("Emprestimos: " + emprestimo3.toString() + "|" + emprestimo2.toString() + "|"
				+ emprestimo1.toString() + "|", listador.listarEmprestimosUsuarioEmprestando(emprestimos));
	}

	/**
	 * Verifica se a listagem de emprestimos de um usuário ao pegar emprestado
	 * funciona como esperado e se lança exceção quando necessário.
	 */
	@Test
	public void testlistarEmprestimosUsuarioPegandoEmprestado() {
		try {
			listador.listarEmprestimosUsuarioPegandoEmprestado(null);
			fail();
		} catch (Exception e) {
			assertEquals("A lista de emprestimos para listagem nao pode ser nula", e.getMessage());
		}

		assertEquals("Nenhum item pego emprestado", listador.listarEmprestimosUsuarioPegandoEmprestado(this.emprestimos));

		adicionaEmprestimosAListaDeEmprestimos();
		assertEquals(
				"Emprestimos pegos: " + emprestimo3.toString() + "|" + emprestimo2.toString() + "|"
						+ emprestimo1.toString() + "|",
				listador.listarEmprestimosUsuarioPegandoEmprestado(emprestimos));
	}

	/**
	 * Verifica se a listagem do histórico de emprestimos de um item funciona
	 * como esperado e se lança exceção quando necessário.
	 */
	@Test
	public void testlistarEmprestimosItem() {
		try {
			listador.listarEmprestimosItem(null);
			fail();
		} catch (Exception e) {
			assertEquals("A lista de emprestimos para listagem nao pode ser nula", e.getMessage());
		}

		assertEquals("Nenhum emprestimo associado ao item", listador.listarEmprestimosItem(this.emprestimos));
		
		this.emprestimos.add(emprestimo3);
		assertEquals("Emprestimos associados ao item: " + emprestimo3.toString() + "|",
				listador.listarEmprestimosItem(emprestimos));
	}

	private void adicionaEmprestimosAListaDeEmprestimos() {
		this.emprestimos.add(emprestimo1);
		this.emprestimos.add(emprestimo2);
		this.emprestimos.add(emprestimo3);
	}

	/**
	 * Verifica se a listagem de usuários caloteiros funciona como esperado e se
	 * lança exceção quando necessário.
	 */
	@Test
	public void testListarCaloteiros() {

		try {
			listador.listarCaloteiros(null);
			fail();
		} catch (Exception e) {
			assertEquals("A lista de usuarios para listagem nao pode ser nula", e.getMessage());
		}

		adicionaUsuarioALIstaDeUsuarios();

		this.emprestimo1.finaliza("18/08/2018");

		assertEquals("Lista de usuarios com reputacao negativa: " + user2.toString() + "|",
				this.listador.listarCaloteiros(usuarios));

	}

	/**
	 * Verifica se a listagem dos 10 usuários com maior reputação funciona como
	 * esperado e se lança exceção quando necessário.
	 */
	@Test
	public void testlistarTop10MelhoresUsuarios() {
		try {
			listador.listarTop10MelhoresUsuarios(null);
			fail();
		} catch (Exception e) {
			assertEquals("A lista de usuarios para listagem nao pode ser nula", e.getMessage());
		}

		adicionaUsuarioALIstaDeUsuarios();

		assertEquals(
				"1: " + user3.getNome() + " - Reputacao: " + String.format("%.2f", user3.getReputacao()) + "|" + "2: "
						+ user1.getNome() + " - Reputacao: " + String.format("%.2f", user1.getReputacao()) + "|" + "3: "
						+ user2.getNome() + " - Reputacao: " + String.format("%.2f", user2.getReputacao()) + "|",
				this.listador.listarTop10MelhoresUsuarios(usuarios));

	}

	/**
	 * Verifica se a listagem dos 10 usuários com menor reputação funciona como
	 * esperado e se lança exceção quando necessário.
	 */
	@Test
	public void testlistarTop10PioresUsuarios() {
		try {
			listador.listarTop10PioresUsuarios(null);
			fail();
		} catch (Exception e) {
			assertEquals("A lista de usuarios para listagem nao pode ser nula", e.getMessage());
		}

		adicionaUsuarioALIstaDeUsuarios();

		assertEquals(
				"1: " + user2.getNome() + " - Reputacao: " + String.format("%.2f", user2.getReputacao()) + "|" + "2: "
						+ user1.getNome() + " - Reputacao: " + String.format("%.2f", user1.getReputacao()) + "|" + "3: "
						+ user3.getNome() + " - Reputacao: " + String.format("%.2f", user3.getReputacao()) + "|",
				this.listador.listarTop10PioresUsuarios(usuarios));

	}

	private void adicionaUsuarioALIstaDeUsuarios() {
		this.usuarios.add(user1);
		this.usuarios.add(user2);
		this.usuarios.add(user3);
	}

}
