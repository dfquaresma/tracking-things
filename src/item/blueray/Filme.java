package item.blueray;

/**
 * Description: Os blu rays de filmes devem ainda ter genero e ano de
 * lancamento.
 * 
 *
 */
public class Filme extends BlueRay {

	private Genero genero;
	private int anoDeLancamento;

	public Filme(String nome, double valor, int duracao, String genero, String classificacao, int anoDeLancamento) {
		super(nome, valor, duracao, classificacao);
		this.genero = Genero.valueOf(genero);
		this.anoDeLancamento = anoDeLancamento;
	}

	public String getGenero() {
		return genero.toString();
	}

	public void setGenero(String genero) {
		this.genero = Genero.valueOf(genero);
	}

	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public void setAnoDeLancamento(int anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}

	@Override
	public String getInfo(String atributo) {

		switch (atributo) {
		case ("Genero"):
			return this.genero.toString();
		case ("Lancamento"):
			return String.valueOf(this.anoDeLancamento);
		default:
			return super.getInfo(atributo);
		}

	}

	@Override
	public String toString() {
		return "FILME: " + this.getNome() + ", R$ " + String.valueOf(this.getPreco()) + ", "
				+ this.getEstadoEmprestimo() + ", " + this.getDuracao() + " min, " + this.getClassificacao() + ", "
				+ this.getGenero() + ", " + this.getAnoDeLancamento();
	}
	
	@Override
	public void atualizaAtributo(String atributo, String valor) {
		
		if (atributo.equals("Genero")) {
			this.genero = Genero.valueOf(valor);			
			
		} else if (atributo.equals("Ano de Lancamento")) {
			this.anoDeLancamento = Integer.parseInt(valor);
		
		} else {
			super.atualizaAtributo(atributo, valor);
		}
		
	}

}
