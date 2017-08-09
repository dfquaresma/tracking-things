package usuario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IdUsuarioTest {
	private IdUsuario id1;
	private IdUsuario id2;
	private IdUsuario id3;
	private IdUsuario id4;
	private IdUsuario id5;
	
	@Before
	public void setUp() {
		this.id1 = new IdUsuario("Funalo", "3371-0000");
		this.id2 = new IdUsuario("Beltrano", "3371-0000");
		this.id3 = new IdUsuario("Sicrano", "3371-0001");
		this.id4 = new IdUsuario("Sicrano", "3371-0000");
		this.id5 = new IdUsuario("Funalo", "3371-0000");
	}
	
	@Test
	public void testIdUsuario() {
		assertEquals("Funalo", id1.getNome());
		assertEquals("3371-0000", id1.getTelefone());
	}

	@Test
	public void testEqualsObject() {
		assertFalse(id1.equals(id2));
		assertFalse(id1.equals(id3));
		assertFalse(id2.equals(id3));
		assertFalse(id1.equals(id4));
		assertFalse(id2.equals(id4));
		assertFalse(id3.equals(id4));
		assertFalse(id2.equals(id5));
		assertFalse(id3.equals(id5));
		
		assertTrue(id1.equals(id5));
		
	}

}
