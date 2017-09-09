package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Entidade responsável pela persistencia do sitema.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class Persistencia {

	private String diretorioParaPersistencia;
	private String diretorioTTDefault;

	/**
	 * Constrói uma entidade de persistencia com diretórios internos padrão.
	 */
	public Persistencia() {
		this("data" + File.separator + "tt_default.dat",
				"src" + File.separator + "tt_objects.dat");
	}

	/**
	 * Constrói uma entidade de persistencia com diretórios especificados.
	 * 
	 * @param diretorioDefault
	 *            o diretório padrão que guarda o estado base inicial do
	 *            sistema, quando o mesmo ainda não foi executado.
	 * @param diretorio
	 *            o diretório onde será salvo e recuperado o estado do sistema
	 *            ao ser executado.
	 */
	public Persistencia(String diretorioDefault, String diretorio) {

		File file = new File(diretorioDefault);
		if (!file.exists()) {
			throw new IllegalArgumentException("DiretoiDefault nao existe.");
		}

		this.diretorioTTDefault = diretorioDefault;
		this.diretorioParaPersistencia = diretorio;
	}

	/**
	 * Salva um objeto em um arquivo para uso posterior.
	 * 
	 * @param obj
	 *            o objeto a ser salvo.
	 * @throws IOException
	 *             quando alguma operação de entrada e saída não é suportada.
	 */
	public void salvaObjeto(Object obj) throws IOException {
		if (obj == null) {
			throw new NullPointerException("Objeto nao pode ser nulo.");
		}
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(this.diretorioParaPersistencia);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.flush();

		} catch (IOException ioe) {
			throw new IOException(
					"Nao foi possivel salvar o objeto. Diretorio de persistencia nao pode ser criado/modificado ou o objeto nao é serializavel.");

		} finally {

			if (oos != null) {

				try {
					oos.close();

				} catch (IOException ioe) {
					throw new IOException(
							"Aconteceu um erro de entrada e/ou saída e o sistema não pode fechar o fluxo de dados.");

				}
			}
		}
	}

	/**
	 * Recupera um objeto salvo.
	 * 
	 * @return o objeto salvo anteriormente.
	 * @throws IOException
	 *             quando alguma operação de entrada e/ou saída não é suportada.
	 * @throws ClassNotFoundException
	 *             quando não há objetos serializados salvos.
	 */
	public Object carregaObjeto() throws IOException, ClassNotFoundException {

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Object obj = null;
		try {
			fis = new FileInputStream(this.diretorioParaPersistencia);
			ois = new ObjectInputStream(fis);
			obj = ois.readObject();

		} catch (FileNotFoundException fnfe) {
			try {
				fis = new FileInputStream(this.diretorioTTDefault);
				ois = new ObjectInputStream(fis);
				obj = ois.readObject();

			} catch (Exception e) {
				throw new IOException("Ocorreu um erro ao tentar utilizar o diretorio default.");
			}

		} catch (ClassNotFoundException cnfe) {
			throw new ClassNotFoundException("Nao foi possivel carregar o objeto.");

		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException ioe) {
					throw new IOException(
							"Aconteceu um erro de entrada e/ou saída e o sistema não pode fechar o fluxo de dados.");
				}
			}
		}

		return obj;

	}

	/**
	 * Deleta todos os dados persistentes de uma instancia de objeto que faz uso
	 * dessa classe.
	 */
	public void deletarPersistencia() {
		File file = new File(this.diretorioParaPersistencia);
		file.delete();
	}

}
