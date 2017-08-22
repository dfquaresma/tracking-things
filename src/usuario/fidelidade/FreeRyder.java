package usuario.fidelidade;

/**
 * Representacao da categoria FreeRyder do cartao fidelidade.
 *
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class FreeRyder implements CartaoFidelidade {

	private final int PERIODO = 5;

	/**
	 * Retorna o periodo que a categoria pode pegar um item emprestado
	 */
	@Override
	public int getPeriodo() {
		return PERIODO;
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
		return "FreeRyder";
	}

}
