package usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import item.FabricaDeItem;
import item.Item;
import item.blueray.Temporada;
import sistema.Emprestimo;

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

	public void cadastrarEletronico(String nomeItem, double preco, String plataforma) {
		this.fabricaDeItem.criaJogoEletronico(nomeItem, preco, plataforma);
		
	}

	public void cadastrarJogoTabuleiro(String nomeItem, double preco) {
		this.fabricaDeItem.criaJogoTabuleiro(nomeItem, preco);
		
	}

	public void addPecaPerdida(String nomeItem, String nomePeca) {
		// TODO Auto-generated method stub
		
	}

	public void cadastrarBlurayFilme(String nomeItem, double preco, int duracao, String genero, String classificacao,
			int anoLancamento) {
		this.fabricaDeItem.criaFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		
	}

	public void cadastrarBluRaySerie(String nomeItem, double preco, String descricao, int duracao, String classificacao,
			String genero, int temporada) {
		this.fabricaDeItem.criaTemporada(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
	}

	public void cadastrarBlurayShow(String nomeItem, double preco, int duracao, int numeroFaixas, String artista,
			String classificacao) {
		this.fabricaDeItem.criaShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		
	}

	public void addBlueray(String nomeBlueray, int duracao) {
		Temporada temporada = (Temporada) this.pegaItem(nomeBlueray);
		temporada.addBlueray(duracao);
	}

	public void removerItem(String nomeItem) {
		// TODO Auto-generated method stub
		
	}
	
	public Item pegaItem(String nomeItem) {
		return this.itens.get(nomeItem);
	}

	public void attItem(String nomeItem, double valor, String atributo) {
		// TODO Auto-generated method stub
		
	}

	public String getInfoItem(String nomeItem, String atributo) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDetalhesItem(String nomeItem) {
		// TODO Auto-generated method stub
		return null;
	}

	public void empresta(Emprestimo emprestimo) {
		
	}

	public void pegaEmprestado(Emprestimo emprestimo) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Item> getItens() {
		ArrayList<Item> itensToCopy = new ArrayList<>(this.itens.values());
		ArrayList<Item> itens = new ArrayList<>();
		Collections.copy(itens, itensToCopy);
		return itens;
	}

	public void devolveItem(String nomeDono, String telefoneDono, String nomeItem, String dataEmprestimo,
			String dataDevolucao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return this.nome + ", " + this.email + ", " + this.telefone;
	}
}
