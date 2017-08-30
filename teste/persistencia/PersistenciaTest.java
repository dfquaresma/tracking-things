package persistencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

/**
 * Testa os métodos da classe Persistencia.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class PersistenciaTest {

	private String diretorioDefault;
	private String diretorioParaPersistencia;
	private Persistencia persistencia;
	private File fileAux;
	private Capsula capsula;

	/**
	 * Prepara o ambiente de testes.
	 */
	@Before
	public void setUp() {

		this.diretorioDefault = "data" + File.separator + "tt_default_test.dat";
		this.diretorioParaPersistencia = "data" + File.separator + "tt_objects.dat";
		this.persistencia = new Persistencia(this.diretorioDefault, this.diretorioParaPersistencia);
		this.fileAux = new File(diretorioParaPersistencia);
		this.capsula = new Capsula();
		this.capsula.addObjeto("Ob1");
		this.capsula.addObjeto(3);
		this.capsula.addObjeto(true);

	}

	/**
	 * Testa os construtores de Persistenca verificando se é lançado exceção
	 * quando necessário.
	 */
	@Test
	public void testConstrutorPersistencia() {

		try {
			this.persistencia = new Persistencia();
		} catch (Exception e) {
			fail();
		}

		try {
			this.persistencia = new Persistencia(this.diretorioDefault + "AlgumaCoisaSoParaQuebrar",
					this.diretorioParaPersistencia);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("DiretoiDefault nao existe.", e.getMessage());
		}

		try {
			this.persistencia = new Persistencia(this.diretorioDefault, this.diretorioParaPersistencia);

		} catch (IllegalArgumentException e) {
			fail();
		}

	}

	/**
	 * Testa se os métodos salvaObjeto() e carregaOjetos estão funcionando
	 * corretamente.
	 * 
	 * @throws Exception
	 *             quando algum erro acontece durante a execução.
	 */
	@Test
	public void testSalvaECarregaObjeto() throws Exception {

		this.persistencia.salvaObjeto(this.capsula);

		Capsula o = (Capsula) this.persistencia.carregaObjeto();
		assertEquals(this.capsula.getObjeto(), o.getObjeto());
		assertEquals(this.capsula.getObjeto(), o.getObjeto());
		assertEquals(this.capsula.getObjeto(), o.getObjeto());

		this.persistencia.deletarPersistencia();
		this.persistencia.carregaObjeto();
		this.persistencia.deletarPersistencia();

	}

	/**
	 * Verifica se as exceção estão sendo lançadas nos métodos salvaObjeto() e
	 * carregaObjeto().
	 * 
	 * @throws Exception
	 *             quando algum erro acontece durante a execução.
	 */
	@Test
	public void testExcecoesEmSalvaECarregaObjeto() throws Exception {

		try {
			this.persistencia.salvaObjeto(null);
			fail();

		} catch (Exception e) {
			assertEquals("Objeto nao pode ser nulo.", e.getMessage());
		}

		try {
			this.persistencia.salvaObjeto(new Object());
			fail();

		} catch (Exception e) {
			assertEquals(
					"Nao foi possivel salvar o objeto. Diretorio de persistencia nao pode ser criado/modificado ou o objeto nao é serializavel.",
					e.getMessage());
		}

		Persistencia persistencia = new Persistencia(this.diretorioParaPersistencia,
				this.diretorioParaPersistencia + "Aux");
		this.persistencia.deletarPersistencia();
		try {
			persistencia.carregaObjeto();
			fail();

		} catch (Exception e) {
			assertEquals("Ocorreu um erro ao tentar utilizar o diretorio default.", e.getMessage());
		}

		persistencia.deletarPersistencia();
		this.persistencia.deletarPersistencia();

	}

	/**
	 * Verifica se a classe de Persistencia está deletando corretamente o
	 * arquivo de persistencia.
	 * 
	 * @throws Exception
	 *             quando algum erro acontece durante a execução.
	 */
	@Test
	public void testDeletarPersistencia() throws Exception {

		assertFalse(this.fileAux.exists());

		this.persistencia.salvaObjeto(this.capsula);
		assertTrue(this.fileAux.exists());

		this.persistencia.deletarPersistencia();
		assertFalse(this.fileAux.exists());

	}

}


