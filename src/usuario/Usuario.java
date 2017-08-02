package usuario;

import java.util.HashMap;
import java.util.Map;

import item.FabricaDeItem;
import item.Item;

public class Usuario {
	
	private String nome;
	private String telefone;
	private String email;
	private FabricaDeItem fabricaDeItem;
	private Map<String, Item> itens;

	public Usuario(String nome, String telefone, String email){
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.fabricaDeItem = new FabricaDeItem();
		this.itens = new HashMap<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	
}
