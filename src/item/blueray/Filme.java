package item.blueray;

/**
 * Description: Os blu rays de filmes devem ainda ter genero e ano de lancamento.
 * 
 *
 */
public class Filme extends BlueRay {

	private String genero;
	private int anoDeLancamento;

	public Filme(String nome, double valor, int duracao, String genero, String classificacao, int anoDeLancamento) {
		super(nome, valor, duracao, classificacao);
		this.genero = genero;
		this.anoDeLancamento = anoDeLancamento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public void setAnoDeLancamento(int anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}

	@Override
	public boolean podeSerEmprestado() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
