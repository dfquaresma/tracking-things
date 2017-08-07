package util;

public class Validacoes {
	
	private void validaString(String atributo, String atributoMsg){
		if(atributo == null){
			throw new NullPointerException(atributoMsg + " nao pode ser nulo");
		}
		if(atributo.trim().isEmpty()){
			throw new IllegalArgumentException(atributoMsg + " nao pode ser vazio");
		}
	}
	
	public void validaNome(String nome){
		this.validaString(nome, "Nome");
	}
	
	public void validaTelefone(String telefone){
		this.validaString(telefone, "Telefone");
	}
	
	public void validaEmail(String email){
		this.validaString(email, "Email");
	}
	
	public void validaValor(String valor){
		this.validaString(valor, "Valor");
	}
	
	public void validaNomeItem(String nomeItem){
		this.validaString(nomeItem, "Nome do item");
	}
	
	public void validaDuracao(int duracao){
		if(duracao <= 0){
			throw new IllegalArgumentException("Duracao nao pode ser negativa");
		}
	}
	
	public void validaArtista(String artista){
		this.validaString(artista, "Artista");
	}
	
	public void validaClassificacao(String classificacao){
		this.validaString(classificacao, "Classificacao");
	}
	
	public void validaNomeBluray(String nomeBluray){
		this.validaString(nomeBluray, "Nome do bluray");
	}
	
	public void validaGenero(String genero){
		this.validaString(genero, "Genero");
	}
	
	public void validaTemporada(int temporada){
		if(temporada <= 0){
			throw new IllegalArgumentException("Temporada nao pode ser negativa");
		}
	}
	
	public void validaPlataforma(String plataforma){
		this.validaString(plataforma, "Plataforma");
	}
	
	public void validaAnoLancamento(int ano){
		if(ano <= 0){
			throw new IllegalArgumentException("Ano nao pode ser negativo");
		}
	}
	
	public void validaData(String data){
		this.validaString(data, "Data");
	}
	
	public void validaPreco(double preco){
		if(preco < 0){
			throw new IllegalArgumentException("Preco nao pode ser negativo");
		}
	}
	
}
