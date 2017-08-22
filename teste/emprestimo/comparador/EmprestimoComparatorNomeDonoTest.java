package emprestimo.comparador;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import emprestimo.Emprestimo;
import item.Item;
import item.bluray.Show;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;
import usuario.Usuario;

/**
 * Testa as funcionalidades da clase EmprestimoComparatorNomeDonoTest.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class EmprestimoComparatorNomeDonoTest {

    /**
     * Faz alguns testes de comparação entre empréstimos a partir do nome do
     * dono do item emprestado.
     */
    @Test
    public void testCompare() {
	EmprestimoComparatorNomeDono comparador = new EmprestimoComparatorNomeDono();

	Usuario user1 = new Usuario("Amandio", "3371-0000", "amandio@gmail.com");
	Usuario user2 = new Usuario("Testandio", "3371-0001", "testandio@ccc.ufcg.edu.com");
	Usuario user3 = new Usuario("Errandio", "3371-0002", "errandio@hotmail.com");

	Item itemA = new JogoTabuleiro("Xadrez", 200);
	Item itemB = new JogoEletronico("Dota", 200, "PC");
	Item itemC = new Show("AC DC - Live in River Plate", 300, 2, 11, "AC_DC", "DEZ_ANOS");

	user1.adicionaItem(itemA);
	user2.adicionaItem(itemB);
	user3.adicionaItem(itemC);

	Emprestimo emprestimo1 = new Emprestimo(user1, user2, itemA.getNome(), "18/08/2017", 1);
	Emprestimo emprestimo2 = new Emprestimo(user2, user3, itemB.getNome(), "16/08/2017", 2);
	Emprestimo emprestimo3 = new Emprestimo(user3, user1, itemC.getNome(), "15/08/2017", 3);

	assertTrue(comparador.compare(emprestimo1, emprestimo2) < 0);
	assertTrue(comparador.compare(emprestimo1, emprestimo3) < 0);
	assertTrue(comparador.compare(emprestimo2, emprestimo3) > 0);
	assertTrue(comparador.compare(emprestimo1, emprestimo1) == 0);

    }

}
