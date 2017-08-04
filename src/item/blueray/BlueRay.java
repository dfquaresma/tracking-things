package item.blueray;

import item.Item;

/**
 * Description: Alem das informacoes gerais que todo item possui, todo blu ray
 * deve ter uma duracao e uma classificacao
 * 
 *
 */
public abstract class BlueRay extends Item {

	private int duracao;
	private Classificacao classificacao;

	public BlueRay(String nome, double valor, int duracao, String classificacao) {
		super(nome, valor);
		this.duracao = duracao;
		this.classificacao = this.ajustaClassificacao(classificacao);

	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getClassificacao() {
		return classificacao.toString();
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = this.ajustaClassificacao(classificacao);
	}

	@Override
	public String getInfo(String atributo) {

		switch (atributo) {
		case ("Duracao"):
			return String.valueOf(this.duracao);
		case ("Classificacao"):
			return this.classificacao.toString();
		default:
			return super.getInfo(atributo);
		}

	}

	private Classificacao ajustaClassificacao(String classificacao) {
		
		switch (classificacao) {
		
		case  ("LIVRE"):
			return Classificacao.LIVRE;
		case  ("DEZ_ANOS"):
			return Classificacao.DEZ_ANOS;
		case  ("DOZE_ANOS"):
			return Classificacao.DOZE_ANOS;
		case  ("QUATORZE_ANOS"):
			return Classificacao.QUATORZE_ANOS;
		case  ("DEZESSEIS_ANOS"):
			return Classificacao.DEZESSEIS_ANOS;
		case  ("DEZOITO_ANOS"):
			return Classificacao.DEZOITO_ANOS;
		default:
			throw new IllegalArgumentException();
	
		}
		
	}

	public String isEmprestadoString(){
		if(super.isEmprestado()){
			return "Emprestado";
		} else {
			return "Nao emprestado";
		}
	}
	
}
