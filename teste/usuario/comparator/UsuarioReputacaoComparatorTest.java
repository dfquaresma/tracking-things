package usuario.comparator;

import static org.junit.Assert.*;

import org.junit.Test;

import emprestimo.EmprestimoController;
import item.Item;
import item.bluray.Show;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;
import usuario.Usuario;

public class UsuarioReputacaoComparatorTest {

	@Test
	public void testCompare() {
		UsuarioReputacaoComparator comparador = new UsuarioReputacaoComparator();
		Usuario user1 = new Usuario("Amandio", "3371-0000", "amandio@gmail.com");
		Usuario user2 = new Usuario("Testandio", "3371-0001", "testandio@ccc.ufcg.edu.com");
		Usuario user3 = new Usuario("Errandio", "3371-0002", "errandio@hotmail.com");
		Item itemA = new JogoTabuleiro("Xadrez", 200);
		Item itemB = new JogoEletronico("Dota", 200, "PC");
		Item itemC = new Show("AC DC - Live in River Plate", 300, 2, 11, "AC_DC", "DEZ_ANOS");
		user1.adicionaItem(itemA);
		user1.adicionaItem(itemB);
		user2.adicionaItem(itemC);
		EmprestimoController controller = new EmprestimoController();
		controller.registrarEmprestimo(user1, user2, itemA.getNome(), "20/08/2018", 4);
		controller.registrarEmprestimo(user1, user3, itemB.getNome(), "20/08/2018", 4);
		controller.registrarEmprestimo(user2, user3, itemC.getNome(), "20/08/2018", 4);
		
		assertTrue(comparador.compare(user1, user2) > 0);
		assertTrue(comparador.compare(user2, user3) > 0);
		assertTrue(comparador.compare(user3, user1) < 0);
		assertTrue(comparador.compare(user1, user1) == 0);
	}

}
