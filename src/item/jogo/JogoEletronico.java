package item.jogo;

import item.Item;

public class JogoEletronico  extends Item {

	private Plataforma plataforma;

	public JogoEletronico(String nome, double valor, String plataforma) {
		super(nome, valor);
		this.plataforma = ajustaPlataforma(plataforma);
	}

	public String getPlataforma() {
		return plataforma.toString();
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = ajustaPlataforma(plataforma);
	}
	
	@Override
	public String getInfo(String atributo){
	
		if (atributo.equals("Plataforma")) {
			return this.plataforma.toString();
		}
		return super.getInfo(atributo);
	}

	private Plataforma ajustaPlataforma(String classificacao) {
		
		switch (classificacao) {
		
		case  ("PC"):
			return Plataforma.PC;

		case  ("MAC"):
			return Plataforma.MAC;

		case  ("PS3"):
			return Plataforma.PS3;
			
		case  ("PS4"):
			return Plataforma.PS4;

		case  ("XBOX360"):
			return Plataforma.XBOX360;

		case  ("XBOX_ONE"):
			return Plataforma.XBOX_ONE;
			
		case  ("NINTENDO_3DS"):
			return Plataforma.NINTENDO_3DS;
			
		case  ("OUTRO"):
			return Plataforma.OUTRO;

		default:
			throw new IllegalArgumentException();
	
		}
		
	}

	private String isEmprestadoString() {
		if(super.isEmprestado()){
			return "Emprestado";
		} else {
			return "Nao emprestado";
		}
	}

	@Override
	public String toString() {
		return "JOGO ELETRONICO: " + super.getNome() + ", R$ " + super.getValor() + ", " + this.isEmprestadoString()
		+ ", " + this.getPlataforma();
	}

	
}
