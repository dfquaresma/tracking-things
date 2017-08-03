package item.blueray;

import item.Item;

/**
 * Description: Alem das informacoes gerais que todo item possui, todo blu ray deve ter uma duracao e uma classificacao
 * 
 *
 */
public abstract class BlueRay extends Item {

	private int duracao;
	private String classificacao;

	public BlueRay(String nome, double valor, int duracao, String classificacao) {
		super(nome, valor);
		this.duracao = duracao;
		this.classificacao = classificacao; 
		
	}

	public int getDuracao() {
		return duracao;
	}
	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	
	

}
