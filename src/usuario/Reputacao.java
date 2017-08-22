package usuario;

/**
 * Classe que representa a reputacao de um usuario de acordo com seu
 * comportamento.
 * 
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class Reputacao {
	private double reputacao;

	/**
	 * Método que constrói um objeto reputação.
	 */
	public Reputacao() {
		this.reputacao = 0;
	}

	/**
	 * Método que a atualiza a reputação de acordo com o valor do Item quando o
	 * usuário adiciona este Item para empréstimo.
	 * 
	 * @param valorItem
	 *            Double que representa o valor do item a ser emprestado.
	 */
	public void adicionandoItemParaEmprestimo(double valorItem) {
		this.reputacao += valorItem * 0.05;
	}

	/**
	 * Método que atualiza a reputação de acordo com o valor do Item quando o
	 * usuário empresta um dos seus itens.
	 * 
	 * @param valorItem
	 *            Double que representa o valor do item a ser emprestado.
	 */
	public void emprestandoItem(double valorItem) {
		this.reputacao += valorItem * 0.10;
	}

	/**
	 * Método que atualiza a reputação de acordo com o valor do Item quando o
	 * usuário está devolvendo um item que pegou emprestado.
	 * 
	 * @param valorItem
	 *            Double que representa o valor do item a ser emprestado.
	 * @param diasAtraso
	 *            Inteiro que representa a quantidade de dias em atraso do
	 *            emprestimo.
	 */
	public void devolvendoItem(double valorItem, int diasAtraso) {
		if (diasAtraso <= 0)
			this.reputacao += valorItem * 0.05;
		else
			this.reputacao -= valorItem * (0.01 * diasAtraso);
	}

	/**
	 * Método que retorna o valor da reputação do objeto reputação.
	 * 
	 * @return Double que representa o valor da reputação.
	 */
	public double getReputacao() {
		return this.reputacao;
	}
}