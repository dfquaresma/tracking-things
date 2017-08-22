package usuario.fidelidade;
/**
 * Representacao da categoria BomAmigo do cartao fidelidade
 *
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class BomAmigo implements CartaoFidelidade {

	private final int PERIODO = 14;
	/**
	 * Retorna o periodo que a categoria pode pegar um item emprestado
	 */
	@Override
	public int getPeriodo() {
		return this.PERIODO;
	}
	/**
	 * Retorna se a categoria pode pegar itens emprestado
	 */
	@Override
	public boolean podePegarEmprestado() {
		return true;
	}
	/**
	 * Retorna a representacao em string da categoria
	 */
	@Override
	public String toString() {
		return "BomAmigo";
	}

}
