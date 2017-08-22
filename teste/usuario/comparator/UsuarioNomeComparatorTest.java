package usuario.comparator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import usuario.Usuario;

/**
 * Testa as funcionalidades da clase UsuarioNomeComparator.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class UsuarioNomeComparatorTest {

	/**
	 * Faz alguns testes de comparação entre usuários a partir do nome dos
	 * usuários envolvidos.
	 */
	@Test
	public void testCompare() {
		UsuarioNomeComparator comparador = new UsuarioNomeComparator();
		Usuario user1 = new Usuario("Amandio", "3371-0000", "amandio@gmail.com");
		Usuario user2 = new Usuario("Testandio", "3371-0001", "testandio@ccc.ufcg.edu.com");
		Usuario user3 = new Usuario("Errandio", "3371-0002", "errandio@hotmail.com");

		assertTrue(comparador.compare(user1, user2) < 0);
		assertTrue(comparador.compare(user2, user3) > 0);
		assertTrue(comparador.compare(user1, user3) < 0);
		assertTrue(comparador.compare(user1, user1) == 0);

	}

}
