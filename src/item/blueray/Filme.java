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
		this.genero = ajustatGenero(genero);
		this.anoDeLancamento = anoDeLancamento;
	}

	public String getGenero() {
		return genero.toString();
	}

	public void setGenero(String genero) {
		this.genero = ajustatGenero(genero);
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

	private Genero ajustatGenero(String genero) {

		switch (genero) {

		case ("ACAO"):
			return Genero.ACAO;

		case ("ANIMACAO"):
			return Genero.ANIMACAO;

		case ("AVENTURA"):
			return Genero.AVENTURA;

		case ("COMEDIA"):
			return Genero.COMEDIA;

		case ("DOCUMENTARIO"):
			return Genero.DOCUMENTARIO;

		case ("DRAMA"):
			return Genero.DRAMA;

		case ("EROTICO"):
			return Genero.EROTICO;

		case ("FAROESTE"):
			return Genero.FAROESTE;

		case ("FICCAO"):
			return Genero.FICCAO;

		case ("MUSICAL"):
			return Genero.MUSICAL;

		case ("POLICIAL"):
			return Genero.POLICIAL;

		case ("ROMANCE"):
			return Genero.ROMANCE;

		case ("SUSPENSE"):
			return Genero.SUSPENSE;

		case ("TERROR"):
			return Genero.TERROR;

		case ("OUTRO"):
			return Genero.OUTRO;

		default:
			throw new IllegalArgumentException();

		}

	}

	@Override
	public String toString() {
		return "FILME: " + super.getNome() + ", R$ " + super.getValor() + ", " + super.isEmprestadoString() + ", "
				+ super.getDuracao() + " min, " + super.getClassificacao() + ", " + this.getGenero() + ", " + this.anoDeLancamento;
	}

}
