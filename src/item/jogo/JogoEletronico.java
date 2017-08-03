package item.jogo;

import item.Item;

public class JogoEletronico  extends Item {

	private String plataforma;

	public JogoEletronico(String nome, double valor, String plataforma) {
		super(nome, valor);
		this.plataforma = plataforma;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	@Override
	public String getInfo(String atributo){
	
		if (atributo.equals("Plataforma")) {
			return this.plataforma.toString();
		}
		return super.getInfo(atributo);
	}

}
