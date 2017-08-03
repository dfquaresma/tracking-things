package util;

public class Validacoes {
	
	public void validaNome(String nome){
		if(nome.trim().isEmpty()){
			throw new IllegalArgumentException("Nome nao pode ser vazio");
		}
		if(nome == null){
			throw new NullPointerException("Nome nao pode ser nulo");
		}
	}
	
	public void validaTelefone(String telefone){
		if(telefone.trim().isEmpty()){
			throw new IllegalArgumentException("Telefone nao pode ser vazio");
		}
		if(telefone == null){
			throw new NullPointerException("Telefone nao pode ser nulo");
		}
	}
	
	public void validaEmail(String email){
		if(email.trim().isEmpty()){
			throw new IllegalArgumentException("Email nao pode ser vazio");
		}
		if(email == null){
			throw new NullPointerException("Email nao pode ser nulo");
		}
	}
	
	public void validaValor(String valor){
		if(valor.trim().isEmpty()){
			throw new IllegalArgumentException("Valor nao pode ser vazio");
		}
		if(valor == null){
			throw new NullPointerException("Valor nao pode ser nulo");
		}
	}
	
	public void validaNomeItem(String nomeItem){
		if(nomeItem.trim().isEmpty()){
			throw new IllegalArgumentException("Nome do item nao pode ser vazio");
		}
		if(nomeItem == null){
			throw new NullPointerException("Nome do item nao pode ser nulo");
		}
	}
	
	public void validaDuracao(int duracao){
		if(duracao <= 0){
			throw new IllegalArgumentException("Duracao nao pode ser negativa");
		}
	}
	
	public void validaArtista(String artista){
		if(artista.trim().isEmpty()){
			throw new IllegalArgumentException("Artista nao pode ser vazio");
		}
		if(artista == null){
			throw new NullPointerException("Artista nao pode ser nulo");
		}
	}
	
	public void validaClassificacao(String classificacao){
		if(classificacao.trim().isEmpty()){
			throw new IllegalArgumentException("Classificacao nao pode ser vazia");
		}
		if(classificacao == null){
			throw new NullPointerException("Classificacao nao pode ser nula");
		}
	}
	
	public void validaNomeBluray(String nomeBluray){
		if(nomeBluray.trim().isEmpty()){
			throw new IllegalArgumentException("Nome do bluray nao pode ser vazio");
		}
		if(nomeBluray == null){
			throw new NullPointerException("Nome do bluray nao pode ser nulo");
		}
	}
	
	public void validaGenero(String genero){
		if(genero.trim().isEmpty()){
			throw new IllegalArgumentException("Genero nao pode ser vazio");
		}
		if(genero == null){
			throw new NullPointerException("Genero nao pode ser nulo");
		}
	}
}
