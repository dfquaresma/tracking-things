package usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import item.Item;
import item.blueray.Filme;
import item.blueray.Show;
import item.blueray.Temporada;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;


/**
 * Description: 
 *
 */
public class Usuario {
	
	private String nome;
	private String telefone;
	private String email;
	private Map<String, Item> itens;
	private Set<Emprestimo> emprestimosComoEmprestador;
	private Set<Emprestimo> emprestimosComoRequerente;

	public Usuario(String nome, String telefone, String email){
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.itens = new HashMap<>();
		this.emprestimosComoEmprestador = new HashSet<>();
		this.emprestimosComoRequerente = new HashSet<>();

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
		verificaPreco(preco);
		Item novoItem = new JogoEletronico(nomeItem, preco, plataforma);
		this.itens.put(nomeItem, novoItem);
	}

	public void cadastrarJogoTabuleiro(String nomeItem, double preco) {
		verificaPreco(preco);
		Item novoItem = new JogoTabuleiro(nomeItem, preco);
		this.itens.put(nomeItem, novoItem);
	}

	public void addPecaPerdida(String nomeItem, String nomePeca) {
		validaItemParaUso(nomeItem);

		Item item = this.itens.get(nomeItem);
		
		if (!(item instanceof JogoTabuleiro)) {
			throw new IllegalArgumentException();			
		}
		
		JogoTabuleiro jogo = (JogoTabuleiro) item;
		jogo.adicionarPecaPerdida(nomePeca);
		
	}

	public void cadastrarBlurayFilme(String nomeItem, double preco, int duracao, String genero, String classificacao,
			int anoLancamento) {
		verificaPreco(preco);
		Item novoItem = new Filme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		itens.put(nomeItem, novoItem);
	}

	public void cadastrarBluRaySerie(String nomeItem, double preco, String descricao, int duracao, String classificacao,
			String genero, int temporada) {
		verificaPreco(preco);
		Item novoItem = new Temporada(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
		itens.put(nomeItem, novoItem);
	}

	public void cadastrarBlurayShow(String nomeItem, double preco, int duracao, int numeroFaixas, String artista,
			String classificacao) {
		verificaPreco(preco);
		Item novoItem = new Show(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		itens.put(nomeItem, novoItem);
	}

	public void addBlueray(String nomeBlueray, int duracao) {
		Temporada temporada = (Temporada) this.pegaItem(nomeBlueray);
		temporada.addBlueray(duracao);
	}

	public void removerItem(String nomeItem) {
		if(!(itens.containsKey(nomeItem))){
			throw new IllegalArgumentException("Item nao encontrado");
		}
		itens.remove(nomeItem);
	}
	
	public Item pegaItem(String nomeItem) {
		return this.itens.get(nomeItem);
	}

	public void attItem(String nomeItem, String atributo, String valor) {
		validaItemParaUso(nomeItem);
		
		if(atributo.equals("Nome")){
			validaAttNomeDeItem(valor); // VERIFICAR SE JA EXISTE ALGUM ITEM COM ESSE NOME NO SISTEMA. 
			Item itemAtt = this.itens.get(nomeItem);
			itemAtt.setNome(valor);
			this.itens.remove(nomeItem);
			this.itens.put(valor,itemAtt);
		} else if (atributo.equals("Preco")){
			this.itens.get(nomeItem).setValor(Double.parseDouble(valor));
		} else {
			throw new IllegalArgumentException(); // AMANDA COMPLETA!
		}
	}

	private void validaAttNomeDeItem(String nomeItem) {
		if (this.itens.containsKey(nomeItem)) {
			throw new IllegalArgumentException();
		}
		
	}

	public String getInfoItem(String nomeItem, String atributo) {
		validaItemParaUso(nomeItem);
		Item item = itens.get(nomeItem);
		return item.getInfo(atributo);
	}

	public String getDetalhesItem(String nomeItem) {
		validaItemParaUso(nomeItem);
		Item item = itens.get(nomeItem);
		return item.toString();
	}

	public void emprestaItem(String nomeItem, String dataEmprestimo, int periodo, Usuario userRequerente) {
		Emprestimo emprestimo = new Emprestimo(this.nome, userRequerente.nome, nomeItem, dataEmprestimo, periodo);
		userRequerente.pegaEmprestado(emprestimo);
		this.emprestimosComoEmprestador.add(emprestimo);
	}

	private void pegaEmprestado(Emprestimo emprestimo) {
		this.emprestimosComoRequerente.add(emprestimo);	
	}

	public ArrayList<Item> getItens() {
		ArrayList<Item> itensToCopy = new ArrayList<>(this.itens.values());
		//ArrayList<Item> itens = new ArrayList<>();
		//Collections.copy(itens, itensToCopy); Pretendo retornar uma cópia, assim que conseguir fazer sem dar "source does not fit in dest"
		return itensToCopy;
	}

	public void devolveItem(String nomeDono, String telefoneDono, String nomeItem, String dataEmprestimo,
			String dataDevolucao) {
		Emprestimo emprestimo = encontraEmprestimo(nomeDono, telefoneDono, nomeItem, dataEmprestimo);
		emprestimo.finaliza(dataDevolucao);
	
	}

	private Emprestimo encontraEmprestimo(String nomeDono, String telefoneDono, String nomeItem,
			String dataEmprestimo) {
		// TODO Auto-generated method stub
		return null;
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
	
	public void verificaPreco(double preco){
		if(preco < 0){
			throw new IllegalArgumentException("Preco invalido");
		}
	}
	
	private void validaItemParaUso(String nomeItem){
		if(!(itens.containsKey(nomeItem))){
			throw new IllegalArgumentException("Item nao encontrado");
		}
	}

	
	
	
}
