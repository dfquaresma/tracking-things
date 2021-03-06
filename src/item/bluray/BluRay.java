package item.bluray;

import java.io.Serializable;

import item.Item;

/**
 * Representação de um Blu-Ray. Guarda as informações básicas para o que é
 * classificado com blue-ray neste sistema.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public abstract class BluRay extends Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int duracao;
	private Classificacao classificacao;

	/**
	 * Constrói um blu-ray com nome, preço, duração e classificação.
	 * 
	 * @param nome
	 *            o nome do blu-ray.
	 * @param preco
	 *            o preço do blu-ray.
	 * @param duracao
	 *            a duração do blu-ray.
	 * @param classificacao
	 *            a classificação do blu-ray.
	 */
	public BluRay(String nome, double preco, int duracao, String classificacao) {
		super(nome, preco);
		this.validador.validaDuracao(duracao);
		this.validador.validaClassificacao(classificacao);

		this.duracao = duracao;
		this.classificacao = Classificacao.valueOf(classificacao);

	}

	/**
	 * Recupera a duração deste blu-ray.
	 * 
	 * @return a duração.
	 */
	public int getDuracao() {
		return duracao;
	}

	/**
	 * Atualiza a duração deste blu-ray.
	 * 
	 * @param duracao
	 *            a nova duração.
	 */
	public void setDuracao(int duracao) {
		this.validador.validaDuracao(duracao);
		this.duracao = duracao;
	}

	/**
	 * Recupera a classificação deste blu-ray.
	 * 
	 * @return uma string representando a classificação.
	 */
	public String getClassificacao() {
		return classificacao.toString();
	}

	/**
	 * Atualiza a classificação deste blu-ray.
	 * 
	 * @param classificacao
	 *            a nova classificação.
	 */
	public void setClassificacao(String classificacao) {
		this.validador.validaClassificacao(classificacao);
		this.classificacao = Classificacao.valueOf(classificacao);
	}

	/**
	 * Sobrescreve o método da classe mãe para verificar se o atributo a ser
	 * recuperado pertence a esta classe. Caso não seja, o método da classe mãe
	 * é chamado.
	 */
	@Override
	public String getInfo(String atributo) {
		this.validador.validaAtributo(atributo);

		switch (atributo) {
		case ("Duracao"):
			return String.valueOf(this.duracao);
		case ("Classificacao"):
			return this.classificacao.toString();
		default:
			return super.getInfo(atributo);
		}

	}

	/**
	 * Sobrescreve o método da classe mãe para verificar se o atributo a ser
	 * atualizado pertence a esta classe. Caso não seja, o método da classe mãe
	 * é chamado.
	 */
	@Override
	public void atualizaAtributo(String atributo, String valor) {

		this.validador.validaAtributo(atributo);
		this.validador.validaValor(valor);

		if (atributo.equals("Duracao")) {
			this.validador.validaConversaoStringToInt(atributo, valor);

			this.setDuracao(Integer.parseInt(valor));
		} else if (atributo.equals("Classificacao")) {
			this.setClassificacao(valor);
		} else {
			super.atualizaAtributo(atributo, valor);
		}

	}

}
