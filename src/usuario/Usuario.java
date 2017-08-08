package usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import excecoes.ExcecaoItemNaoEhDoTipoEsperado;
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

	public Usuario(String nome, String telefone, String email) {
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
		// ArrayList<Item> itens = new ArrayList<>();
		// Collections.copy(itens, itensToCopy); Pretendo retornar uma cópia,
		// assim que conseguir fazer sem dar "source does not fit in dest"
		return itensToCopy;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void cadastrarEletronico(String nomeItem, double preco, String plataforma) {
		Item novoItem = new JogoEletronico(nomeItem, preco, plataforma);
		this.itens.put(nomeItem, novoItem);
	}

	public void cadastrarJogoTabuleiro(String nomeItem, double preco) {
		Item novoItem = new JogoTabuleiro(nomeItem, preco);
		this.itens.put(nomeItem, novoItem);
	}

	public void cadastrarBlurayFilme(String nomeItem, double preco, int duracao, String genero, String classificacao,
			int anoLancamento) {
		Item novoItem = new Filme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		itens.put(nomeItem, novoItem);
	}

	public void cadastrarBluRaySerie(String nomeItem, double preco, String descricao, int duracao, String classificacao,
			String genero, int temporada) {
		Item novoItem = new Temporada(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
		itens.put(nomeItem, novoItem);
	}

	public void cadastrarBlurayShow(String nomeItem, double preco, int duracao, int numeroFaixas, String artista,
			String classificacao) {
		Item novoItem = new Show(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		itens.put(nomeItem, novoItem);
	}

	public void addPecaPerdida(String nomeItem, String nomePeca) {
		validaItemParaUso(nomeItem);

		Item item = getItem(nomeItem);
		if (!(item instanceof JogoTabuleiro)) {
			throw new ExcecaoItemNaoEhDoTipoEsperado("O nome do item informad nao pertence a um tabuleiro");
		}

		JogoTabuleiro jogo = (JogoTabuleiro) item;
		jogo.adicionarPecaPerdida(nomePeca);

	}

	public void addBlueray(String nomeBlueray, int duracao) {
		Temporada temporada = (Temporada) this.getItem(nomeBlueray);
		temporada.addBlueray(duracao);
	}

	public void removerItem(String nomeItem) {
		if (!(itens.containsKey(nomeItem))) {
			throw new IllegalArgumentException("Item nao encontrado");
		}
		itens.remove(nomeItem);
	}

	public void attItem(String nomeItem, String atributo, String valor) {
		validaItemParaUso(nomeItem);

		if (atributo.equals("Nome")) {
			validaAttNomeDeItem(valor);
			Item itemAtt = getItem(nomeItem);
			itemAtt.setNome(valor);
			this.itens.remove(nomeItem);
			this.itens.put(valor, itemAtt);

		} else if (atributo.equals("Preco")) {
			getItem(nomeItem).setValor(Double.parseDouble(valor));

		} else {
			throw new IllegalArgumentException("Atributo invalido");
		}
	}

	private void validaAttNomeDeItem(String nomeItem) {
		if (this.itens.containsKey(nomeItem)) {
			throw new IllegalArgumentException();
		}

	}

	public String getInfoItem(String nomeItem, String atributo) {
		validaItemParaUso(nomeItem);
		Item item = getItem(nomeItem);
		return item.getInfo(atributo);
	}

	public String getDetalhesItem(String nomeItem) {
		validaItemParaUso(nomeItem);
		Item item = getItem(nomeItem);
		return item.toString();
	}

	public void emprestaItem(String nomeItem, Usuario userRequerente, Emprestimo emprestimo) {
		validaItemParaUso(nomeItem);
		
		if (emprestimosComoEmprestador.contains(emprestimo)) {
			throw new IllegalArgumentException("Item emprestado no momento");
		}
		getItem(nomeItem).setEmprestado(true);
		userRequerente.pegaEmprestado(emprestimo);
		this.emprestimosComoEmprestador.add(emprestimo);
	}

	private void pegaEmprestado(Emprestimo emprestimo) {
		this.emprestimosComoRequerente.add(emprestimo);
	}

	public void devolveItem(String nomeItem, String dataEmprestimo, String dataDevolucao, Usuario userEmprestador) {
		Emprestimo emprestimo = encontraEmprestimo(userEmprestador.nome, nomeItem, dataEmprestimo);
		emprestimo.finaliza(dataDevolucao);
		userEmprestador.recebeItem(nomeItem);
	}

	private void recebeItem(String nomeItem) {
		getItem(nomeItem).setEmprestado(false);
	}

	private Emprestimo encontraEmprestimo(String nomeDono, String nomeItem, String dataEmprestimo) {

		for (Emprestimo emprestimo : emprestimosComoRequerente) {
			if (emprestimo.getNomeItem().equals(nomeItem) && emprestimo.getNomeDono().equals(nomeDono)
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
		if (!(itens.containsKey(nomeItem))) {
			throw new IllegalArgumentException("Item nao encontrado");
		}
	}

}
