package usuario;

/**
 * Classe que implementa a pontuacao da reputacao de um usuario de acordo com seu comportamento.
 * 	 
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
	
	public void devolvendoItem(double valorItem, int diasAtraso)
	{
		if(diasAtraso <= 0)
			this.reputacao += valorItem*0.05;
		else
			this.reputacao -= valorItem*(0.01*diasAtraso);
	}
	
	public double getReputacao()
	{
		return this.reputacao;
	}
}