package usuario;

/**
 * Description: A reputação de um usuário inicia com 5% do valor total dos os itens disponíveis pelo usuário no início
 * 				Assim, cada vez que um usuário adiciona um item para empréstimo, a sua reputação sobe um valor de 5% do valor do item adicionado
 * 				Os usuários que não dispõem de itens para empréstimo tem reputação inicial zero
 * 
 * 				Cada vez que um usuário empresta um item, sua reputação deve subir um valor de 10% do valor do item emprestado.
 * 
 * 				Quando um usuário que pegou um item emprestado vai entregar o item, o sistema deve ser capaz de atualizar a reputação do usuário que 
 * 				está devolvendo o item como explicado a seguir. Cada vez que um usuário tomar algo emprestado e devolver obedecendo o prazo, a sua 
 * 				reputação deve aumentar um valor de 5% do valor do item emprestado.
 * 				
 * 				Quando o usuário entrega um item com atraso, sua reputação deve ser diminuída de um valor proporcional ao valor do item emprestado da 
 * 				seguinte forma: para cada dia de atraso adicionamos 1% nessa proporção. Com 3 dias de atraso a proporção é 3%. 
 * 
 * @author paulofelipefeitosa
 *
 */
public class Reputacao
{
	private double reputacao;
	
	public Reputacao()
	{
		this.reputacao = 0;
	}
	
	public void adicionandoItemParaEmprestimo(double valorItem)
	{
		this.reputacao += valorItem*0.05;
	}
	
	public void removendoItemParaEmprestimo(double valorItem)
	{
		this.reputacao -= valorItem*0.05;
	}
	
	public void emprestandoItem(double valorItem)
	{
		this.reputacao += valorItem*0.10;
	}
	
	public void devolvendoItemNoPrazo(double valorItem, int diasAtraso)
	{
		if(diasAtraso <= 0)
			this.reputacao += valorItem*0.05;
		else
			this.reputacao -= valorItem*(0.01*diasAtraso);
	}
	
	public void devolvendoItemForaDoPrazo(double valorItem)
	{
		
	}
	
	public double getReputacao()
	{
		return this.reputacao;
	}
}