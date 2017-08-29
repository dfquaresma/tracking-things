package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Capsula implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Object> objetos;

	public Capsula() {
		this.objetos = new ArrayList<>();
	}

	public void addObjeto(Object o) {
		this.objetos.add(o);

	}

	public Object getObject() {
		
		if (this.objetos.size() > 0) {
			Object objeto = this.objetos.get(0);
			this.objetos.remove(0);
			
			return objeto;			
		} 
		return "";

	}

}
