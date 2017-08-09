package usuario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import item.Item;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;

public class EmprestimoTest {
	private Emprestimo emprestimo;
	private Usuario user1;
	private Usuario user2;
	private Item item;

	@Before
	public void setUp() {
		this.user1 = new Usuario("Alguem", "3371-0001", "alguem@gmail.com");
		this.user2 = new Usuario("Outro", "3371-0002", "outro@gmail.com");
		this.item = new JogoEletronico("Bola Quadrada", 100000, "PC");
		this.emprestimo = new Emprestimo(user1, user2, item, "08/08/2017", 7);
	}

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

	}

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
