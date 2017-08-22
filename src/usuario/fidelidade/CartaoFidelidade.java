package usuario.fidelidade;
/**
 * Interface que contem os metodos dos cartoes fidelidade
 *
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public interface CartaoFidelidade {
	/**
	 * Retorna o periodo da categoria
	 * @return o periodo
	 */
	public int getPeriodo();
	/**
	 * Retorna se a categoria pode pegar itens emprestado
	 * @return true se sim, false se nao
	 */
	public boolean podePegarEmprestado();

}
