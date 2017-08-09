package item.jogo;

import item.Item;

public class JogoEletronico extends Item {

	private Plataforma plataforma;

	public JogoEletronico(String nome, double valor, String plataforma) {
		super(nome, valor);
		this.validador.validaPlataforma(plataforma);
		this.plataforma = Plataforma.valueOf(plataforma);
	}

	public String getPlataforma() {
		return plataforma.toString();
	}

	public void setPlataforma(String plataforma) {
		this.validador.validaPlataforma(plataforma);
		this.plataforma = Plataforma.valueOf(plataforma);
	}
	
	@Override
	public String getInfo(String atributo){
		this.validador.validaAtributo(atributo);
	
		if (atributo.equals("Plataforma")) {
			return this.plataforma.toString();
		}
		return super.getInfo(atributo);
	}
	
	@Override
	public String toString() {
		return "JOGO ELETRONICO: " + this.getNome() + ", R$ " + String.valueOf(this.getPreco()) + ", " + this.getEstadoEmprestimo() + ", " + this.getPlataforma();
	}
	
	@Override
	public void atualizaAtributo(String atributo, String valor) {
		this.validador.validaAtributo(atributo);
		this.validador.validaValor(valor);
		
		if (atributo.equals("Plataforma")) {
			this.plataforma = Plataforma.valueOf(valor);
			
		} else {
			super.atualizaAtributo(atributo, valor);			
		}
		
	}
}
