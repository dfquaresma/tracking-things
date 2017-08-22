package emprestimo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import item.Item;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;
import usuario.Usuario;

/**
 * Testa as funcionalidades da classe emprestimo.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silvaw
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
		this.user1.adicionaItem(this.item);
		this.emprestimo = new Emprestimo(user1, user2, item.getNome(), "08/08/2017", 4);
	}

	/**
	 * Testa se vai dar um IllegalArgumentException por conta da data em um formato incorreto.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testEmprestimoDataSemFormato() {
		this.emprestimo.finaliza("09/09/2017");
		(new Emprestimo(this.user1, this.user2, this.item.getNome(), "222/17/17", 2)).getDataEmprestimo();
	}

	/**
	 * Testa o que acontece no caso de um nome de usuário (tanto o emprestador como o requerente) nulo no construtor de emprestimo, deve gerar uma exception.
	 */
	@Test
	public void testConstrutorFalhaUsuarioInvalido() {
		try {
			new Emprestimo(null, user2, item.getNome(), "22/12/12", 9);
			fail();
		} catch (Exception e) {
			assertEquals("Usuario dono nao pode ser nulo", e.getMessage());
		}

		try {
			new Emprestimo(user1, null, item.getNome(), "22/12/12", 9);
			fail();
		} catch (Exception e) {
			assertEquals("Usuario requerente nao pode ser nulo", e.getMessage());
		}
	}

	/**
	 * Testa o que acontece quando o item é nulo no construtor do empréstimo, deve gerar uma exception.
	 */
	@Test
	public void testConstrutorFalhaItemInvalido() {
		try {
			new Emprestimo(user1, user2, null, "22/12/12", 9);
			fail();
		} catch (Exception e) {
			assertEquals("Nome do item nao pode ser nulo", e.getMessage());
		}
	}

	/**
	 * Testa o caso da data inválida no construtor de um empréstimo, tanto para null, como para vazio e também para formato inválido.
	 */
	@Test
	public void testConstrutorFalhaDataInvalida() {
		try {
			new Emprestimo(user1, user2, item.getNome(), null, 9);
			fail();
		} catch (Exception e) {
			assertEquals("Data nao pode ser nulo", e.getMessage());
		}

		try {
			new Emprestimo(user1, user2, item.getNome(), "", 9);
			fail();
		} catch (Exception e) {
			assertEquals("Data nao pode ser vazio", e.getMessage());
		}

		try {
			new Emprestimo(user1, user2, item.getNome(), "22/12/12", 0);
			fail();
		} catch (Exception e) {
			assertEquals("Periodo nao pode ser menor ou iguals a zero.", e.getMessage());
		}
	}

	/**
	 * Testa o construtor para quando o período for inválido.
	 */
	@Test
	public void testConstrutorFalhaPeriodoInvalido() {
		try {
			new Emprestimo(user1, user2, item.getNome(), "22/12/12", 0);
			fail();
		} catch (Exception e) {
			assertEquals("Periodo nao pode ser menor ou iguals a zero.", e.getMessage());
		}
	}
	
	/**
	 * Testa apenas o hashCode.
	 */
	@Test
	public void testHashCode() {
		assertEquals(this.emprestimo.hashCode(), this.emprestimo.hashCode());
	}

	/**
	 * Testa um construtor válido de Emprestimo.
	 */
	@Test
	public void testEmprestimo() {
		assertEquals("08/08/2017", this.emprestimo.getDataEmprestimo());
		this.emprestimo.setDataEmprestimo("09/08/2017");
		assertEquals("09/08/2017", this.emprestimo.getDataEmprestimo());

		assertEquals(4, this.emprestimo.getPeriodo());
		this.emprestimo.setPeriodo(5);
		assertEquals(5, this.emprestimo.getPeriodo());

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
	 * Testa o equals de Emprestimo.
	 */
	@Test
	public void testEqualsObject() {

		try {
			emprestimo = new Emprestimo(this.user1, this.user2, this.item.getNome(), "08/08/2017", 5);
			fail();
		} catch (Exception e) {
			assertEquals("Item emprestado no momento", e.getMessage());
		}

		Usuario user1 = new Usuario("Alguem", "3371-0001", "alguem@gmail.com");
		Usuario user2 = new Usuario("Outro", "3371-0002", "outro@gmail.com");
		Item item = new JogoEletronico("Bola Quadrada", 100000, "PC");
		user1.adicionaItem(item);
		Emprestimo emprestimo = new Emprestimo(user1, user2, item.getNome(), "08/08/2017", 4);
		assertTrue(this.emprestimo.equals(emprestimo));

		user1 = new Usuario("Alguem", "3371-0001", "alguem@gmail.com");
		user2 = new Usuario("Outro", "3371-0002", "outro@gmail.com");
		item = new JogoEletronico("Bola Quadrada", 100000, "PC");
		user1.adicionaItem(item);
		emprestimo = new Emprestimo(user1, user2, item.getNome(), "08/08/2018", 4);
		assertFalse(this.emprestimo.equals(emprestimo));

		user1 = new Usuario("Alguem", "3371-0001", "alguem@gmail.com");
		user2 = new Usuario("Outro", "3371-0002", "outro@gmail.com");
		item = new JogoEletronico("Bola Quadrada", 100000, "PC");
		user2.adicionaItem(item);
		emprestimo = new Emprestimo(user2, user1, item.getNome(), "08/08/2017", 4);
		assertFalse(this.emprestimo.equals(emprestimo));

		user1 = new Usuario("Alguem", "3371-0001", "alguem@gmail.com");
		item = new JogoEletronico("Bola Quadrada", 100000, "PC");
		user1.adicionaItem(item);
		emprestimo = new Emprestimo(user1, new Usuario("Abra", "3371-0003", "abriu@gmail.com"), this.item.getNome(),
				"08/08/2017", 5);
		assertFalse(this.emprestimo.equals(emprestimo));

		user1 = new Usuario("Alguem", "3371-0001", "alguem@gmail.com");
		user2 = new Usuario("Outro", "3371-0002", "outro@gmail.com");
		item = new JogoTabuleiro("Damas", 1.99);
		user1.adicionaItem(item);
		emprestimo = new Emprestimo(user1, user2, item.getNome(), "08/08/2017", 5);
		assertFalse(this.emprestimo.equals(emprestimo));
		
		assertTrue(this.emprestimo.equals(this.emprestimo));
		assertFalse(this.emprestimo.equals(null));
		assertFalse(this.emprestimo.equals(new String()));

	}

	/**
	 * Testa a finalização de um Emprestimo.
	 */
	@Test
	public void testFinaliza() {
		assertFalse(this.emprestimo.isFinalizado());
		this.emprestimo.finaliza("23/01/9999");
		assertTrue(this.emprestimo.isFinalizado());
	}

	/**
	 * Testa o método getDono.
	 */
	@Test
	public void testGetDono() {
		assertEquals(this.user1, this.emprestimo.getDono());
	}

	/**
	 * Testa o método getRequerente.
	 */
	@Test
	public void testGetRequerente() {
		assertEquals(this.user2, this.emprestimo.getRequerente());
	}

	/**
	 * Testa o método getItem.
	 */
	@Test
	public void testGetItem() {
		assertEquals(this.item, this.emprestimo.getItem());
	}

	/**
	 * Testa o método getNomeDono.
	 */
	@Test
	public void testGetNomeDono() {
		assertEquals("Alguem", this.emprestimo.getNomeDono());
	}

	/**
	 * Testa o método getTelefoneDono.
	 */
	@Test
	public void testGetTelefoneDono() {
		assertEquals("3371-0001", this.emprestimo.getTelefoneDono());
	}

	/**
	 * Testa o método getNomeRequerente.
	 */
	@Test
	public void testGetNomeRequerente() {
		assertEquals("Outro", this.emprestimo.getNomeRequerente());
	}

	/**
	 * Testa o método getTelefoneRequerente.
	 */
	@Test
	public void testGetTelefoneRequerente() {
		assertEquals("3371-0002", this.emprestimo.getTelefoneRequerente());
	}

	/**
	 * Testa o método getNomeItem.
	 */
	@Test
	public void testGetNomeItem() {
		assertEquals("Bola Quadrada", this.emprestimo.getNomeItem());
	}

	/**
	 * Testa o método getDataEmprestimo.
	 */
	@Test
	public void testGetDataEmprestimo() {
		assertEquals("08/08/2017", this.emprestimo.getDataEmprestimo());
	}

	/**
	 * Testa o método getPeriodo.
	 */
	@Test
	public void testGetPeriodo() {
		assertEquals(4, this.emprestimo.getPeriodo());
	}

	/**
	 * Testa o método isFinalizado.
	 */
	@Test
	public void testIsFinalizado() {
		assertFalse(this.emprestimo.isFinalizado());
		this.emprestimo.finaliza("22/01/2200");
		assertTrue(this.emprestimo.isFinalizado());

	}

	/**
	 * Testa o método setDataEmprestimo.
	 */
	@Test
	public void testSetDataEmprestimo() {
		assertEquals("08/08/2017", this.emprestimo.getDataEmprestimo());
		this.emprestimo.setDataEmprestimo("22/01/2200");
		assertEquals("22/01/2200", this.emprestimo.getDataEmprestimo());
	}

	/**
	 * Testa o método setPeriodo.
	 */
	@Test
	public void testSetPeriodo() {
		assertEquals(4, this.emprestimo.getPeriodo());
		this.emprestimo.setPeriodo(5);
		assertEquals(5, this.emprestimo.getPeriodo());
	}

	/**
	 * Testa o método getDataRealDaDevolucaoDoItem.
	 */
	@Test
	public void testGetDataRealDaDevolucaoDoItem() {
		this.emprestimo.finaliza("22/01/2200");
		assertEquals("22/01/2200", this.emprestimo.getDataRealDaDevolucaoDoItem());
	}

	/**
	 * Testa setDataRealDaDevolucaoDoItem.
	 */
	@Test
	public void testSetDataRealDaDevolucaoDoItem() {
		this.emprestimo.finaliza("22/01/2200");
		assertEquals("22/01/2200", this.emprestimo.getDataRealDaDevolucaoDoItem());
		this.emprestimo.setDataRealDaDevolucaoDoItem("10/12/2222");
		assertEquals("10/12/2222", this.emprestimo.getDataRealDaDevolucaoDoItem());

	}

	/**
	 * Testa o método toString, tanto quando é em andamento e quando está finalizado..
	 */
	@Test
	public void testToString() {
		assertEquals(
				"EMPRESTIMO - De: Alguem, Para: Outro, Bola Quadrada, 08/08/2017, 4 dias, ENTREGA: Emprestimo em andamento",
				this.emprestimo.toString());

		this.emprestimo.finaliza("20/09/2021");

		assertEquals(
				"EMPRESTIMO - De: Alguem, Para: Outro, Bola Quadrada, 08/08/2017, 4 dias, ENTREGA: 20/09/2021",
				this.emprestimo.toString());
	}

	/**
	 * Testa o método getDataDoEmprestimo, verifica se está no formato correto.
	 */
	@Test
	public void testGetDataDoEmprestimo() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date dataEmprestimo = dateFormat.parse("08/08/2017");
			assertEquals(dataEmprestimo, this.emprestimo.getDataDoEmprestimo());
		} catch (Exception e) {
			fail();
		}
	}

}
