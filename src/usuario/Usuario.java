package usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import excecoes.ItemNaoEhDoTipoEsperadoExcecao;
import item.Item;
import item.bluray.Filme;
import item.bluray.Show;
import item.bluray.Temporada;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;
import util.Validador;

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
	private Validador validador;

	public Usuario(String nome, String telefone, String email) {
		this.validador = new Validador();
		this.validador.validaNome(nome);
		this.validador.validaTelefone(telefone);
		this.validador.validaEmail(email);
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

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public Item getItem(String nomeItem) {
		this.validaItemParaUso(nomeItem);
		return this.itens.get(nomeItem);
	}

	public ArrayList<Item> getItens() {
		ArrayList<Item> itensToCopy = new ArrayList<>(this.itens.values());
		return itensToCopy;
	}

	public void setNome(String nome) {
		this.validador.validaNome(nome);
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.validador.validaTelefone(telefone);
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.validador.validaEmail(email);
		this.email = email;
	}

	public void cadastrarEletronico(String nomeItem, double preco, String plataforma) {
		this.validaAtributosDeCadastroDeItem(nomeItem, preco);
		this.validador.validaPlataforma(plataforma);
		Item novoItem = new JogoEletronico(nomeItem, preco, plataforma);
		this.itens.put(nomeItem, novoItem);
	}

	private void validaAtributosDeCadastroDeItem(String nomeItem, double preco) {
		this.validador.validaNome(nomeItem);
		this.validador.validaPreco(preco);
	}

	public void cadastrarJogoTabuleiro(String nomeItem, double preco) {
		this.validaAtributosDeCadastroDeItem(nomeItem, preco);
		Item novoItem = new JogoTabuleiro(nomeItem, preco);
		this.itens.put(nomeItem, novoItem);
	}

	private void validaAtributosDeCadastroDeBluRays(int duracao, String classificacao) {
		this.validador.validaDuracao(duracao);
		this.validador.validaClassificacao(classificacao);
	}
	
	public void cadastrarBlurayFilme(String nomeItem, double preco, int duracao, String genero, String classificacao,
			int anoLancamento) {
		this.validaAtributosDeCadastroDeItem(nomeItem, preco);
		this.validaAtributosDeCadastroDeBluRays(duracao, classificacao);
		this.validador.validaGenero(genero);
		this.validador.validaAnoLancamento(anoLancamento);
		
		Item novoItem = new Filme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		itens.put(nomeItem, novoItem);
	}


	public void cadastrarBluRaySerie(String nomeItem, double preco, String descricao, int duracao, String classificacao,
			String genero, int temporada) {
		this.validaAtributosDeCadastroDeItem(nomeItem, preco);
		this.validaAtributosDeCadastroDeBluRays(duracao, classificacao);
		this.validador.validaDescricao(descricao);
		this.validador.validaGenero(genero);
		this.validador.validaTemporada(temporada);
		Item novoItem = new Temporada(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
		itens.put(nomeItem, novoItem);
	}

	public void cadastrarBlurayShow(String nomeItem, double preco, int duracao, int numeroFaixas, String artista,
			String classificacao) {
		this.validaAtributosDeCadastroDeItem(nomeItem, preco);
		this.validaAtributosDeCadastroDeBluRays(duracao, classificacao);
		this.validador.validaNumeroDeFaixas(numeroFaixas);
		this.validador.validaArtista(artista);
		
		Item novoItem = new Show(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		itens.put(nomeItem, novoItem);
	}

	public void addPecaPerdida(String nomeItem, String nomePeca) {
		this.validaItemParaUso(nomeItem);
		this.validador.validaPeca(nomePeca);

		Item item = getItem(nomeItem);
		if (!(item instanceof JogoTabuleiro)) {
			throw new ItemNaoEhDoTipoEsperadoExcecao("O nome do item informad nao pertence a um tabuleiro");
		}

		JogoTabuleiro jogo = (JogoTabuleiro) item;
		jogo.adicionarPecaPerdida(nomePeca);

	}

	public void addBlueray(String nomeBlueray, int duracao) {
		this.validador.validaNome(nomeBlueray);
		this.validador.validaDuracao(duracao);
		
		Temporada temporada = (Temporada) this.getItem(nomeBlueray);
		temporada.addBlueray(duracao);
	}

	public void removerItem(String nomeItem) {
		this.validador.validaNome(nomeItem);
		
		if (!(itens.containsKey(nomeItem))) {
			throw new IllegalArgumentException("Item nao encontrado");
		}
		itens.remove(nomeItem);
	}

	public void attItem(String nomeItem, String atributo, String valor) {
		this.validador.validaNome(nomeItem);
		this.validador.validaAtributo(atributo);
		this.validador.validaValor(valor);
		
		Item itemAtt = getItem(nomeItem);

		if (atributo.equals("Nome")) {
			this.validaAttNomeDeItem(valor);
			itemAtt.atualizaAtributo(atributo, valor);
			this.itens.remove(nomeItem);
			this.itens.put(valor, itemAtt);
			
		} else {
			itemAtt.atualizaAtributo(atributo, valor);
			
		}
	}

	private void validaAttNomeDeItem(String nomeItem) {
		
		if (this.itens.containsKey(nomeItem)) {
			throw new IllegalArgumentException();
		}

	}

	public String getInfoItem(String nomeItem, String atributo) {
		this.validaItemParaUso(nomeItem);
		this.validador.validaAtributo(atributo);
		
		Item item = getItem(nomeItem);
		return item.getInfo(atributo);
	}

	public String getDetalhesItem(String nomeItem) {
		this.validaItemParaUso(nomeItem);
		
		Item item = getItem(nomeItem);
		return item.toString();
	}

	public void emprestaItem(String nomeItem, Usuario userRequerente, Emprestimo emprestimo) {
		this.validaItemParaUso(nomeItem);

		if (emprestimosComoEmprestador.contains(emprestimo)) {
			throw new IllegalArgumentException("Item emprestado no momento");
		}
		this.getItem(nomeItem).setEmprestado(true);
		userRequerente.emprestimosComoRequerente.add(emprestimo);
		this.emprestimosComoEmprestador.add(emprestimo);
	}

	public void devolveItem(String nomeItem, String dataEmprestimo, String dataDevolucao, Usuario userEmprestador) {
		Emprestimo emprestimo = encontraEmprestimo(userEmprestador, nomeItem, dataEmprestimo);
		emprestimo.finaliza(dataDevolucao);
		userEmprestador.getItem(nomeItem).setEmprestado(false);
	}

	private Emprestimo encontraEmprestimo(Usuario userEmprestador, String nomeItem, String dataEmprestimo) {

		for (Emprestimo emprestimo : emprestimosComoRequerente) {
			if (emprestimo.getNomeDono().equals(userEmprestador.nome)
					&& emprestimo.getTelefoneDono().equals(userEmprestador.telefone)
					&& emprestimo.getNomeItem().equals(nomeItem)
					&& emprestimo.getDataEmprestimo().equals(dataEmprestimo)) {
				return emprestimo;
			}
		}
		throw new IllegalArgumentException("Emprestimo nao encontrado");
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
	public String toString() {
		return this.nome + ", " + this.email + ", " + this.telefone;
	}

	private void validaItemParaUso(String nomeItem) {
		this.validador.validaNome(nomeItem);
		
		if (!(itens.containsKey(nomeItem))) {
			throw new IllegalArgumentException("Item nao encontrado");
		}
	}

	public void atualizaAtributo(String atributo, String valor) {
		this.validador.validaAtributo(atributo);
		this.validador.validaValor(valor);
		
		switch (atributo) {
		case ("Nome"):
			setNome(valor);
			break;
		case ("Telefone"):
			setTelefone(valor);
			break;
		case ("Email"):
			setEmail(valor);
			break;
			
		default:
			throw new IllegalArgumentException("Atributo invalido");
		}
		
	}
	
	public String getInfor(String atributo) {
		this.validador.validaAtributo(atributo);
		
		switch (atributo) {
		case ("Nome"):
			return getNome();
		case ("Telefone"):
			return getTelefone();
		case ("Email"):
			return getEmail();
		default:
			throw new IllegalArgumentException("Atributo invalido.");
		}
	}
	
	
}
