package usuario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import item.Item;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;

/**
 * Testa as funcionalidades da classe emprestimo.
 * 
 * @author David Ferreira
 *
 */
public class EmprestimoTest {
	private Emprestimo emprestimo;
	private Usuario user1;
	private Usuario user2;
	private Item item;

	/**
	 * Configura o ambiente de testes para garantir a eficiência dos testes.
	 */
	@Before
	public void setUp() {
		this.user1 = new Usuario("Alguem", "3371-0001", "alguem@gmail.com");
		this.user2 = new Usuario("Outro", "3371-0002", "outro@gmail.com");
		this.item = new JogoEletronico("Bola Quadrada", 100000, "PC");
		this.emprestimo = new Emprestimo(user1, user2, item, "08/08/2017", 7);
	}

	/**
	 * Testa se o construtor está lançando as devidas exceções quando é passado
	 * parâmetros inválidos.
	 */
	@Test
	public void testConstrutorFalha() {
		try {
			new Emprestimo(null, user2, item, "22/12/12", 9);
			fail();
		} catch (Exception e) {
			assertEquals("Usuario dono nao pode ser nulo", e.getMessage());
		}

		try {
			new Emprestimo(user1, null, item, "22/12/12", 9);
			fail();
		} catch (Exception e) {
			assertEquals("Usuario requerente nao pode ser nulo", e.getMessage());
		}

		try {
			new Emprestimo(user1, user2, null, "22/12/12", 9);
			fail();
		} catch (Exception e) {
			assertEquals("Item nao pode ser nulo", e.getMessage());
		}

		try {
			new Emprestimo(user1, user2, item, null, 9);
			fail();
		} catch (Exception e) {
			assertEquals("Data nao pode ser nulo", e.getMessage());
		}

		try {
			new Emprestimo(user1, user2, item, "", 9);
			fail();
		} catch (Exception e) {
			assertEquals("Data nao pode ser vazio", e.getMessage());
		}

		try {
			new Emprestimo(user1, user2, item, "22/12/12", 0);
			fail();
		} catch (Exception e) {
			assertEquals("Periodo nao pode ser menor ou iguals a zero.", e.getMessage());
		}
	}

	/**
	 * testa se as funcionalidade básicas de emprestimo se comportam como
	 * desejado e se lança exceção quando é necessário.
	 */
	@Test
	public void testEmprestimo() {
		assertEquals("08/08/2017", this.emprestimo.getDataEmprestimo());
		this.emprestimo.setDataEmprestimo("09/08/2017");
		assertEquals("09/08/2017", this.emprestimo.getDataEmprestimo());

		assertEquals(7, this.emprestimo.getPeriodo());
		this.emprestimo.setPeriodo(8);
		assertEquals(8, this.emprestimo.getPeriodo());

		assertEquals("Alguem", this.emprestimo.getNomeDono());
		assertEquals("Outro", this.emprestimo.getNomeRequerente());
		assertEquals("3371-0001", this.emprestimo.getTelefoneDono());
		assertEquals("3371-0002", this.emprestimo.getTelefoneRequerente());
		assertEquals("Bola Quadrada", this.emprestimo.getNomeItem());

		try {
			this.emprestimo.getDataRealDaDevolucaoDoItem();
		} catch (Exception e) {
			assertEquals("Este emprestimo ainda não foi finalizado.", e.getMessage());
		}

		this.emprestimo.finaliza("22/12/2018");
		assertEquals("22/12/2018", this.emprestimo.getDataRealDaDevolucaoDoItem());

	}

	/**
	 * verifica se o equals está funcionando corretamente.
	 */
	@Test
	public void testEqualsObject() {
		Emprestimo emprestimo = new Emprestimo(this.user1, this.user2, this.item, "08/08/2017", 7);
		assertTrue(this.emprestimo.equals(emprestimo));

		emprestimo = new Emprestimo(this.user1, this.user2, this.item, "08/08/2017", 134);
		assertTrue(this.emprestimo.equals(emprestimo));

		emprestimo = new Emprestimo(this.user1, this.user2, this.item, "08/08/2018", 134);
		assertFalse(this.emprestimo.equals(emprestimo));

		emprestimo = new Emprestimo(this.user2, this.user1, this.item, "08/08/2017", 134);
		assertFalse(this.emprestimo.equals(emprestimo));

		emprestimo = new Emprestimo(this.user1, new Usuario("Abra", "3371-0003", "abriu@gmail.com"), this.item,
				"08/08/2017", 134);
		assertFalse(this.emprestimo.equals(emprestimo));

		emprestimo = new Emprestimo(this.user1, this.user2, new JogoTabuleiro("Damas", 1.99), "08/08/2017", 134);
		assertFalse(this.emprestimo.equals(emprestimo));

	}

}
