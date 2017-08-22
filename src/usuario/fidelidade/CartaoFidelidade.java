package usuario.fidelidade;
/**
 * Representa um cartao fidelidade

 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class CartaoFidelidade {
	
	private Fidelidade fidelidade;

	public CartaoFidelidade() {
		this.fidelidade = new FreeRyder();
	}

	/**
	 * Retorna o periodo que um usuario pode pegar itens emprestado
	 * 
	 * @return o periodo
	 */
	public int getPeriodoEmprestado() {
		return this.fidelidade.getPeriodo();
	}
	/**
	 * Atualiza a classificacao do usuario de acordo com os cartoes fidelidade
	 */
	public void attCartao(double reputacao, boolean temItens) {
		if (reputacao > 0 && reputacao <= 100 && !temItens) {
			this.fidelidade = new Noob();
		} else if (reputacao < 0) {
			this.fidelidade = new Caloteiro();
		} else {
			this.fidelidade = new BomAmigo();
		}
	}
	/**
	 * Retorna a representacao em string do cartao
	 */
	@Override
	public String toString() {
		return this.fidelidade.toString();
	}
}
