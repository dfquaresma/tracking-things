package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persistencia {

	private String diretorio;

	public Persistencia(String diretorio) {
		this.diretorio = diretorio;

	}

	public void salvaObjeto(Object obj) {

		ObjectOutputStream oos = null;

		try {
			FileOutputStream fos = new FileOutputStream(this.diretorio, true);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.flush();

		} catch (Exception e) {
			// VAMOS COLOCAR UMA OUTRA EXCEÇÃO DAORA AQUI

		} finally {

			if (oos != null) {

				try {
					oos.close();

				} catch (Exception e) {
					// AQUI TAMBÈM :D

				}
			}
		}

	}

	public Object carregaObjeto() {

		Object obj = null;
		ObjectInputStream ois = null;

		try {
			FileInputStream fis = new FileInputStream(this.diretorio);
			ois = new ObjectInputStream(fis);
			obj = ois.readObject();

		} catch (Exception e) {
			// EXCEÇÃO AQUI YEYEYE

		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (Exception e) {
					// EXCEÇÃO AQUI TAMBÉM YEYEYE
				}
			}

		}
		return obj;
	}

}
