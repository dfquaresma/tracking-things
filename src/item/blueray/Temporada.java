package item.blueray;

/**
 * Description: No blu ray de uma temporada você deve guardar a coleção de blu-rays que compõem a temporada.
 * 
 * @author paulofelipe
 *
 */
public class Temporada extends BlueRay {

	private String descricao;
	private String genero;
	private int temporada;

	public Temporada(String nome, double valor, String descricao, int duracao, String classificacao, String genero, int temporada) {
		super(nome, valor, duracao, classificacao);
		this.descricao = descricao;
		this.genero = genero;
		this.temporada = temporada;		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getTemporada() {
		return temporada;
	}

	public void setTemporada(int temporada) {
		this.temporada = temporada;
	}

	public void addBlueray(int duracao) {
		// TODO Auto-generated method stub
	}
	
	
	@Override
	public String getInfo(String atributo){
		
		switch (atributo) {
		case("Descricao"):
			return this.descricao;
		case("Genero"):
			return this.genero.toString();
		case("Temporada"):
			return String.valueOf(this.temporada);
		default:
			return super.getInfo(atributo);
		}
		
	}
	

}
