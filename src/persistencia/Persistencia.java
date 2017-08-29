package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persistencia {

	private String diretorioParaPersistencia;
	private String diretorioTTDefault;

	public Persistencia() {
		this.diretorioTTDefault = "src" + File.separator + "persistencia" + File.separator + "tt_default.dat";
		this.diretorioParaPersistencia = "src" + File.separator + "persistencia" + File.separator + "tt_objects.dat";
	}

	public void salvaObjeto(Object obj) throws IOException {

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(this.diretorioParaPersistencia);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.flush();

		} catch (IOException e) {
			// TODO: handle exception

		} finally {

			if (oos != null) {

				try {
					oos.close();

				} catch (IOException e) {
					// TODO: handle exception

				}
			}
		}
	}

	public Object carregaObjeto() throws IOException, ClassNotFoundException {

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Object obj = null;
		try {
			fis = new FileInputStream(this.diretorioParaPersistencia);
			ois = new ObjectInputStream(fis);
			obj = ois.readObject();

		} catch (FileNotFoundException e) {
			fis = new FileInputStream(this.diretorioTTDefault);
			ois = new ObjectInputStream(fis);
			obj = ois.readObject();

		} catch (ClassNotFoundException e) {
			// TODO: handle exception

		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}

		return obj;

	}

}
