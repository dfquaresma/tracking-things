package usuario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe que realiza os testes de unidade da Classe Reputação.
 * 
 * @author pauloffs
 *
 */
public class ReputacaoTest {
	private Reputacao reputacao;

	/**
	 * Método que constrói uma reputação para ser utilizada nos demais testes.
	 */
	@Before
	public void criaReputacao() {
		this.reputacao = new Reputacao();
	}

	/**
	 * Método que testa o comportamento do método construtor de Reputação.
	 */
	@Test
	public void testReputacao() {
		assertEquals(0, this.reputacao.getReputacao(), 0.000005);
	}

	/**
	 * Método que testa o comportamento do método que atualiza o valor da Reputação
	 * quando o usuário adiciona um item para empréstimo.
	 */
	@Test
	public void testAdicionandoItemParaEmprestimo() {
		this.reputacao.adicionandoItemParaEmprestimo(100);
		assertEquals(5.00, this.reputacao.getReputacao(), 0.000005);
	}

	/**
	 * Método que testa o comportamento do método que atualiza o valor da Reputação
	 * quando o usuário empresta um item a outro usuário.
	 */
	@Test
	public void testEmprestandoItem() {
		this.reputacao.emprestandoItem(200);
		assertEquals(20.00, this.reputacao.getReputacao(), 0.000005);
	}

	/**
	 * Método que testa o comportamento do método que atualiza o valor da Reputação
	 * quando o usuário devolve um item que pegou emprestado.
	 */
	@Test
	public void testDevolvendo() {
		this.reputacao.devolvendoItem(300, 0);
		assertEquals(15.00, this.reputacao.getReputacao(), 0.000005);
		this.reputacao.devolvendoItem(1000, 10);
		assertEquals(-100.00 + 15.00, this.reputacao.getReputacao(), 0.000005);
		this.reputacao.devolvendoItem(300, -3);
		assertEquals(-100.00 + 15.00 + 15.00, this.reputacao.getReputacao(), 0.000005);
	}

}
