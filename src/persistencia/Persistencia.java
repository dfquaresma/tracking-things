package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Entidade responsável pel persistencia do sitema.
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
	 * Constrói uma entidade de Persistencia com diretório internos padrão.
	 */
	public Persistencia() {
		this.diretorioTTDefault = "src" + File.separator + "persistencia" + File.separator + "tt_default.dat";
		this.diretorioParaPersistencia = "src" + File.separator + "persistencia" + File.separator + "tt_objects.dat";
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

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(this.diretorioParaPersistencia);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.flush();

		} catch (IOException ioe) {
			throw new IOException(
					"Nao foi possivel salvar o objeto. Diretorio de persistencia nao pode ser criado/modificado.");

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
			fis = new FileInputStream(this.diretorioTTDefault);
			ois = new ObjectInputStream(fis);
			obj = ois.readObject();

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

}
