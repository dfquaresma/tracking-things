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
		this.emprestimo = new Emprestimo(user1, user2, item.getNome(), "08/08/2017", 7);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEmprestimoDataSemFormato() //FIXME: Emprestimo nao deveria deixar criar a nova instancia de emprestimo, porem ela cria e ainda associa com a data do emprestimo da anterior
	{
		this.emprestimo.finaliza("09/09/2017");
		(new Emprestimo(this.user1, this.user2, this.item.getNome(), "222/17/17", 2)).getDataEmprestimo();
	}
	
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
	
	@Test
	public void testConstrutorFalhaItemInvalido() {
		try {
			new Emprestimo(user1, user2, null, "22/12/12", 9);
			fail();
		} catch (Exception e) {
			assertEquals("Nome do item nao pode ser nulo", e.getMessage());
		}
	}

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
	
	@Test
	public void testConstrutorFalhaPeriodoInvalido() {
		try {
			new Emprestimo(user1, user2, item.getNome(), "22/12/12", 0);
			fail();
		} catch (Exception e) {
			assertEquals("Periodo nao pode ser menor ou iguals a zero.", e.getMessage());
		}
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

		try {
			this.emprestimo.getDataRealDaDevolucaoDoItem();
		} catch (Exception e) {
			assertEquals("Este emprestimo ainda não foi finalizado.", e.getMessage());
		}

		this.emprestimo.finaliza("22/12/2018");
		assertEquals("22/12/2018", this.emprestimo.getDataRealDaDevolucaoDoItem());

	}

	@Test
	public void testEqualsObject() {

		try {
			emprestimo = new Emprestimo(this.user1, this.user2, this.item.getNome(), "08/08/2017", 134);
			fail();
		} catch (Exception e) {
			assertEquals("Item emprestado no momento", e.getMessage());
		}

		Usuario user1 = new Usuario("Alguem", "3371-0001", "alguem@gmail.com");
		Usuario user2 = new Usuario("Outro", "3371-0002", "outro@gmail.com");
		Item item = new JogoEletronico("Bola Quadrada", 100000, "PC");
		user1.adicionaItem(item);
		Emprestimo emprestimo = new Emprestimo(user1, user2, item.getNome(), "08/08/2017", 7);
		assertTrue(this.emprestimo.equals(emprestimo));

		user1 = new Usuario("Alguem", "3371-0001", "alguem@gmail.com");
		user2 = new Usuario("Outro", "3371-0002", "outro@gmail.com");
		item = new JogoEletronico("Bola Quadrada", 100000, "PC");
		user1.adicionaItem(item);
		emprestimo = new Emprestimo(user1, user2, item.getNome(), "08/08/2018", 7);
		assertFalse(this.emprestimo.equals(emprestimo));

		user1 = new Usuario("Alguem", "3371-0001", "alguem@gmail.com");
		user2 = new Usuario("Outro", "3371-0002", "outro@gmail.com");
		item = new JogoEletronico("Bola Quadrada", 100000, "PC");
		user2.adicionaItem(item);
		emprestimo = new Emprestimo(user2, user1, item.getNome(), "08/08/2017", 7);
		assertFalse(this.emprestimo.equals(emprestimo));

		user1 = new Usuario("Alguem", "3371-0001", "alguem@gmail.com");
		item = new JogoEletronico("Bola Quadrada", 100000, "PC");
		user1.adicionaItem(item);
		emprestimo = new Emprestimo(user1, new Usuario("Abra", "3371-0003", "abriu@gmail.com"), this.item.getNome(),
				"08/08/2017", 134);
		assertFalse(this.emprestimo.equals(emprestimo));

		user1 = new Usuario("Alguem", "3371-0001", "alguem@gmail.com");
		user2 = new Usuario("Outro", "3371-0002", "outro@gmail.com");
		item = new JogoTabuleiro("Damas", 1.99);
		user1.adicionaItem(item);
		emprestimo = new Emprestimo(user1, user2, item.getNome(), "08/08/2017",
				134);
		assertFalse(this.emprestimo.equals(emprestimo));

	}

	@Test
	public void testFinaliza() {
		assertFalse(this.emprestimo.isFinalizado());
		this.emprestimo.finaliza("23/01/9999");
		assertTrue(this.emprestimo.isFinalizado());
	}

	@Test
	public void testGetDono() {
		assertEquals(this.user1, this.emprestimo.getDono());
	}

	@Test
	public void testGetRequerente() {
		assertEquals(this.user2, this.emprestimo.getRequerente());
	}

	@Test
	public void testGetItem() {
		assertEquals(this.item, this.emprestimo.getItem());
	}

	@Test
	public void testGetNomeDono() {
		assertEquals("Alguem", this.emprestimo.getNomeDono());
	}

	@Test
	public void testGetTelefoneDono() {
		assertEquals("3371-0001", this.emprestimo.getTelefoneDono());
	}

	@Test
	public void testGetNomeRequerente() {
		assertEquals("Outro", this.emprestimo.getNomeRequerente());
	}

	@Test
	public void testGetTelefoneRequerente() {
		assertEquals("3371-0002", this.emprestimo.getTelefoneRequerente());
	}

	@Test
	public void testGetNomeItem() {
		assertEquals("Bola Quadrada", this.emprestimo.getNomeItem());
	}

	@Test
	public void testGetDataEmprestimo() {
		assertEquals("08/08/2017", this.emprestimo.getDataEmprestimo());
	}

	@Test
	public void testGetPeriodo() {
		assertEquals(7, this.emprestimo.getPeriodo());
	}

	@Test
	public void testIsFinalizado() {
		assertFalse(this.emprestimo.isFinalizado());
		this.emprestimo.finaliza("22/01/2200");
		assertTrue(this.emprestimo.isFinalizado());
		
	}

	@Test
	public void testSetDataEmprestimo() {
		assertEquals("08/08/2017", this.emprestimo.getDataEmprestimo());
		this.emprestimo.setDataEmprestimo("22/01/2200");
		assertEquals("22/01/2200", this.emprestimo.getDataEmprestimo());
	}

	@Test
	public void testSetPeriodo() {
		assertEquals(7, this.emprestimo.getPeriodo());
		this.emprestimo.setPeriodo(8);
		assertEquals(8, this.emprestimo.getPeriodo());
	}

	@Test
	public void testGetDataRealDaDevolucaoDoItem() {
		this.emprestimo.finaliza("22/01/2200");
		assertEquals("22/01/2200", this.emprestimo.getDataRealDaDevolucaoDoItem());
	}

	@Test
	public void testSetDataRealDaDevolucaoDoItem() {
		this.emprestimo.finaliza("22/01/2200");
		assertEquals("22/01/2200", this.emprestimo.getDataRealDaDevolucaoDoItem());
		this.emprestimo.setDataRealDaDevolucaoDoItem("10/12/2222");
		assertEquals("10/12/2222", this.emprestimo.getDataRealDaDevolucaoDoItem());
		
	}

	@Test
	public void testToString() {
		assertEquals("EMPRESTIMO - De: Alguem, Para: Outro, Bola Quadrada, 08/08/2017, 7 dias, ENTREGA: Emprestimo em andamento", this.emprestimo.toString());
		
	}

	@Test
	public void testGetDataDoEmprestimo()  {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date dataEmprestimo = dateFormat.parse("08/08/2017");
			assertEquals(dataEmprestimo, this.emprestimo.getDataDoEmprestimo());
		} catch (Exception e) {
			fail();
		}
	}
	

}
