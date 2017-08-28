package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persistencia {

	private String diretorio;

	public Persistencia(String diretorio) {
		this.diretorio = diretorio;

	}

	public void salvaObjeto(Object obj) throws IOException {
		FileOutputStream fos = new FileOutputStream(this.diretorio);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.flush();
		oos.close();

	}

	public Object carregaObjeto() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(this.diretorio);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		ois.close();
		return obj;
		
	}

	
}
