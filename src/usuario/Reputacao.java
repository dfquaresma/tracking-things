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

	public Reputacao() {
		this.reputacao = 0;
	}

	public void adicionandoItemParaEmprestimo(double valorItem) {
		this.reputacao += valorItem * 0.05;
	}

	public void removendoItemParaEmprestimo(double valorItem) {
		this.reputacao -= valorItem * 0.05;
	}

	public void emprestandoItem(double valorItem) {
		this.reputacao += valorItem * 0.10;
	}

	public void devolvendoItem(double valorItem, int diasAtraso) {
		if (diasAtraso <= 0)
			this.reputacao += valorItem * 0.05;
		else
			this.reputacao -= valorItem * (0.01 * diasAtraso);
	}

	public double getReputacao() {
		return this.reputacao;
	}
}