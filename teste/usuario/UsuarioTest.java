package usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import item.Item;
import item.bluray.Temporada;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;

import org.junit.Before;
import org.junit.Test;

import excecoes.ItemNaoEhDoTipoEsperadoExcecao;
import excecoes.OperacaoNaoPermitidaNoMomentoExcecao;

/**
 * Testa as funcionalidades da classe Usuario.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class UsuarioTest {

	private Usuario usuario;
	private Usuario usuario2;

	/**
	 * Inicianlizando usuario e usuario2.
	 */
	@Before
	public void Inicializa() {
		this.usuario = new Usuario("Ícaro", "+55 (83) 9.9384-7651", "icaro.lima@ccc.ufcg.edu.br");
		this.usuario2 = new Usuario("David", "+55 (83) 9.1234-5678", "david.quaresma@ccc.ufcg.edu.br");
	}

	/**
	 * Testa o construtor de Usuario quanto o nome está vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testUsuarioNomeVazio() {
		this.usuario = new Usuario("", "93428573498", "icaro.lima@ccc.ufcg.edu.br");
	}

	/**
	 * Testa o construtor de Usuario quanto o telefone está vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testUsuarioTelefoneVazio() {
		this.usuario = new Usuario("Higor", "", "icaro.lima@ccc.ufcg.edu.br");
	}

	/**
	 * Testa o construtor de Usuario quanto o email está vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testUsuarioEmailVazio() {
		this.usuario = new Usuario("Higor", "9879878997", "");
	}

	/**
	 * Testa o construtor de Usuario quando o nome está vazio só que com espaços
	 * mesmo assim.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testUsuarioNomeVazioComEspacos() {
		this.usuario = new Usuario(" ", "93428573498", "icaro.lima@ccc.ufcg.edu.br");
	}

	/**
	 * Testa o construtor de Usuario quando o telefone está vazio só que com
	 * espaços mesmo assim.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testUsuarioTelefoneVazioComEspacos() {
		this.usuario = new Usuario("Higor", "   ", "icaro.lima@ccc.ufcg.edu.br");
	}

	/**
	 * Testa o construtor de Usuario quando o email está vazio só que com
	 * espaços mesmo assim.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testUsuarioEmailVazioComEspacos() {
		this.usuario = new Usuario("Higor", "9879878997", "  ");
	}

	/**
	 * Testa o construtor de Usuario quando o nome está nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testUsuarioNomeNulo() {
		this.usuario = new Usuario(null, "93428573498", "icaro.lima@ccc.ufcg.edu.br");
	}

	/**
	 * Testa o construtor de Usuario quando o telefone está nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testUsuarioTelefoneNulo() {
		this.usuario = new Usuario("Higor", null, "icaro.lima@ccc.ufcg.edu.br");
	}

	/**
	 * Testa o construtor de Usuario quando o email está nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testUsuarioEmailNulo() {
		this.usuario = new Usuario("Higor", "9879878997", null);
	}
	
	@Test
	public void testAdicionaItem()
	{
		assertEquals(0, this.usuario.getItens().size());
		Item item = new JogoEletronico("Arma3", 345.00, "PC");
		this.usuario.adicionaItem(item);
		assertEquals(1, this.usuario.getItens().size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaItemNull()
	{
		this.usuario.adicionaItem(null);
	}
	
	@Test
	public void testRemoverItem()
	{
		Item item = new JogoEletronico("Arma3", 345.00, "PC");
		this.usuario.adicionaItem(item);
		assertEquals(1, this.usuario.getItens().size());
		
		this.usuario.removerItem("Arma3");
		assertEquals(0, this.usuario.getItens().size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRemoverItemInvalido()
	{
		Item item = new JogoEletronico("Arma3", 345.00, "PC");
		this.usuario.adicionaItem(item);
		assertEquals(1, this.usuario.getItens().size());
		
		this.usuario.removerItem("Arma3");
		assertEquals(0, this.usuario.getItens().size());
		
		this.usuario.removerItem("Arma3");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddPecaPerdidaItemNaoExistente()
	{
		Item item = new JogoEletronico("Arma3", 345.00, "PC");
		this.usuario.adicionaItem(item);
		this.usuario.addPecaPerdida("kkkkk", "tabua");
	}
	
	@Test
	public void testAddPecaPerdida()
	{
		Item item = new JogoTabuleiro("xadrex", 10);
		this.usuario.adicionaItem(item);
		this.usuario.addPecaPerdida("xadrex", "cavalo");
		assertEquals("JOGO DE TABULEIRO: xadrex, R$ 10.0, Nao emprestado, COM PECAS PERDIDAS", this.usuario.getDetalhesItem("xadrex"));
	}
	
	@Test(expected=ItemNaoEhDoTipoEsperadoExcecao.class)
	public void testAddPecaPerdidaItemInvalido()
	{
		Item item = new JogoEletronico("Arma3", 345.00, "PC");
		this.usuario.adicionaItem(item);
		this.usuario.addPecaPerdida("Arma3", "tabua");
	}

	@Test
	public void testAddBlueray()
	{
		Item item = new Temporada("South park", 1000.10, "Primeira temporada de South park", 1000, "DEZOITO_ANOS", "COMEDIA", 1);
		this.usuario.adicionaItem(item);
		assertEquals(false, this.usuario.getItem("South park").podeSerEmprestado());
		this.usuario.addBlueray("South park", 1000);
		assertEquals(true, this.usuario.getItem("South park").podeSerEmprestado());
	}
	
	@Test(expected=ItemNaoEhDoTipoEsperadoExcecao.class)
	public void testAddBluerayItemInvalido()
	{
		Item item = new JogoEletronico("Arma3", 345.00, "PC");
		this.usuario.adicionaItem(item);
		this.usuario.addBlueray("Arma3", 20);
	}
	
	@Test
	public void testAttItem()
	{
		Item item = new JogoEletronico("Arma3", 345.00, "PC");
		this.usuario.adicionaItem(item);
		this.usuario.attItem("Arma3", "Nome", "Arma");
		assertEquals("Arma", this.usuario.getInfoItem("Arma", "Nome"));
		this.usuario.attItem("Arma", "Preco", "100.00");
		assertEquals("100.0", this.usuario.getInfoItem("Arma", "Preco"));
		
		Item newItem = new JogoEletronico("Arma4", 500.00, "MAC");
		this.usuario.adicionaItem(newItem);
		this.usuario.attItem("Arma4", "Nome", "Arma");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAttItemExistente()
	{
		Item item = new JogoEletronico("Arma3", 345.00, "PC");
		this.usuario.adicionaItem(item);
		this.usuario.attItem("Arma3", "Nome", "Arma");
		assertEquals("Arma", this.usuario.getInfoItem("Arma", "Nome"));
		this.usuario.attItem("Arma", "Preco", "100.00");
		assertEquals("100.0", this.usuario.getInfoItem("Arma", "Preco"));
		
		Item newItem = new JogoEletronico("Arma4", 500.00, "PC");
		this.usuario.adicionaItem(newItem);
		this.usuario.attItem("Arma4", "Nome", "Arma");
	}
	
	@Test(expected=OperacaoNaoPermitidaNoMomentoExcecao.class)
	public void testRecebeItem()
	{
		Item item = new JogoEletronico("Arma3", 345.00, "PC");
		this.usuario.adicionaItem(item);
		this.usuario.recebeItem("Arma3");
	}
	
	@Test
	public void testGetInfor()
	{
		assertEquals("0.0", this.usuario.getInfor("Reputacao"));
	}
	
	/**
	 * Testa o equals de um Usuario.
	 */
	@Test
	public void testEqualsObject() {
		Usuario userTest = new Usuario("Ícaro", "+55 (83) 9.9384-7651", "icaro.lima@ccc.ufcg.edu.br");
		assertTrue(this.usuario.equals(userTest));
		assertFalse(this.usuario.equals(this.usuario2));
	}

	/**
	 * Testa o toString de um Usuario.
	 */
	@Test
	public void testToString() {
		assertEquals("Ícaro, +55 (83) 9.9384-7651, icaro.lima@ccc.ufcg.edu.br", this.usuario.toString());
	}

}
