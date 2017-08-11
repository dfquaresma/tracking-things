package usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import excecoes.ItemNaoEhDoTipoEsperadoExcecao;
import excecoes.OperacaoNaoPermitidaNoMomentoExcecao;
import item.Item;
import item.bluray.Filme;
import item.bluray.Show;
import item.bluray.Temporada;
import item.jogo.JogoEletronico;
import item.jogo.JogoTabuleiro;
import util.Validador;

/**
 * Representação de um usuário no sistema.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
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

	/**
	 * Constrói um usuário com nome, telefone e email.
	 * 
	 * @param nome
	 *            o nome do usuário.
	 * @param telefone
	 *            o telefone do usuário.
	 * @param email
	 *            o email do usuário.
	 */
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

	/**
	 * Recupera o nome do usuário.
	 * 
	 * @return o nome do usuário.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Recupera o telefone do usuário.
	 * 
	 * @return o telefone do usuário.
	 */
	public String getTelefone() {
		return this.telefone;
	}

	/**
	 * Recupera o email do usuário.
	 * 
	 * @return o email do usuário.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Recupera um item deste usuário.
	 * 
	 * @param nomeItem
	 *            o nome do item a ser recuperado.
	 * @return o item.
	 */
	public Item getItem(String nomeItem) {
		this.validaItemParaUso(nomeItem);
		return this.itens.get(nomeItem);
	}

	/**
	 * Recupera os itens deste usuário.
	 * 
	 * @return o itens.
	 */
	public ArrayList<Item> getItens() {
		ArrayList<Item> itensToCopy = new ArrayList<>(this.itens.values());
		return itensToCopy;
	}

	/**
	 * Muda o nome do usuário para o nome recebido no parâmetro.
	 * 
	 * @param nome
	 *            o novo nome deste usuário.
	 */
	public void setNome(String nome) {
		this.validador.validaNome(nome);
		this.nome = nome;
	}

	/**
	 * Muda o telefone do usuário para o telefone recebido no parâmetro.
	 * 
	 * @param telefone
	 *            o novo telefone deste usuário.
	 */
	public void setTelefone(String telefone) {
		this.validador.validaTelefone(telefone);
		this.telefone = telefone;
	}

	/**
	 * Muda o email do usuário para o email recebido no parâmetro.
	 * 
	 * @param email
	 *            o novo email do deste usuário.
	 */
	public void setEmail(String email) {
		this.validador.validaEmail(email);
		this.email = email;
	}

	/**
	 * Cadastra um jogo eletrônico.
	 * 
	 * @param nomeItem
	 *            o nome do jogo.
	 * @param preco
	 *            o preço do jogo.
	 * @param plataforma
	 *            a plataforma do jogo.
	 */
	public void cadastrarEletronico(String nomeItem, double preco, String plataforma) {
		this.validador.validaAtributosDeCadastroDeItem(nomeItem, preco);
		this.validador.validaPlataforma(plataforma);
		Item novoItem = new JogoEletronico(nomeItem, preco, plataforma);
		this.itens.put(nomeItem, novoItem);
	}

	/**
	 * Cadastra um jogo de tabuleiro.
	 * 
	 * @param nomeItem
	 *            o nome do jogo.
	 * @param preco
	 *            o preço do jogo.
	 */
	public void cadastrarJogoTabuleiro(String nomeItem, double preco) {
		this.validador.validaAtributosDeCadastroDeItem(nomeItem, preco);
		Item novoItem = new JogoTabuleiro(nomeItem, preco);
		this.itens.put(nomeItem, novoItem);
	}

	/**
	 * Cadastra um filme blu-ray.
	 * 
	 * @param nomeItem
	 *            o nome do filme.
	 * @param preco
	 *            o preço do filme.
	 * @param duracao
	 *            a duração do filme.
	 * @param genero
	 *            o gênero do filme.
	 * @param classificacao
	 *            a classificação do filme.
	 * @param anoLancamento
	 *            o ano de lançamento do filme.
	 */
	public void cadastrarBlurayFilme(String nomeItem, double preco, int duracao, String genero, String classificacao,
			int anoLancamento) {
		this.validador.validaAtributosDeCadastroDeItem(nomeItem, preco);
		this.validador.validaAtributosDeCadastroDeBluRays(duracao, classificacao);
		this.validador.validaGenero(genero);
		this.validador.validaAnoLancamento(anoLancamento);

		Item novoItem = new Filme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		itens.put(nomeItem, novoItem);
	}

	/**
	 * Cadastra uma temporada em blu-ray.
	 * 
	 * @param nomeItem
	 *            o nome da temporada.
	 * @param preco
	 *            o preço da temporada.
	 * @param descricao
	 *            a descrição da temporada.
	 * @param duracao
	 *            a duração da temporada.
	 * @param classificacao
	 *            a classificação da temporada.
	 * @param genero
	 *            o gênero da temporada.
	 * @param temporada
	 *            a temporada da temporada.
	 */
	public void cadastrarBluRaySerie(String nomeItem, double preco, String descricao, int duracao, String classificacao,
			String genero, int temporada) {
		this.validador.validaAtributosDeCadastroDeItem(nomeItem, preco);
		this.validador.validaAtributosDeCadastroDeBluRays(duracao, classificacao);
		this.validador.validaDescricao(descricao);
		this.validador.validaGenero(genero);
		this.validador.validaTemporada(temporada);
		Item novoItem = new Temporada(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
		itens.put(nomeItem, novoItem);
	}

	/**
	 * Cadastra um show blu-ray.
	 * 
	 * @param nomeItem
	 *            o nome do show.
	 * @param preco
	 *            o preço do show.
	 * @param duracao
	 *            a duração do show.
	 * @param numeroFaixas
	 *            o número de faixar do show.
	 * @param artista
	 *            o artista do show.
	 * @param classificacao
	 *            a classificação do show.
	 */
	public void cadastrarBlurayShow(String nomeItem, double preco, int duracao, int numeroFaixas, String artista,
			String classificacao) {
		this.validador.validaAtributosDeCadastroDeItem(nomeItem, preco);
		this.validador.validaAtributosDeCadastroDeBluRays(duracao, classificacao);
		this.validador.validaNumeroDeFaixas(numeroFaixas);
		this.validador.validaArtista(artista);

		Item novoItem = new Show(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		itens.put(nomeItem, novoItem);
	}

	/**
	 * Adiciona uma peça perdida a um jogo de tabuleiro.
	 * 
	 * @param nomeItem
	 *            o nome do jogo.
	 * @param nomePeca
	 *            a peça a ser adicionada.
	 */
	public void addPecaPerdida(String nomeItem, String nomePeca) {
		this.validaItemParaUso(nomeItem);
		this.validador.validaPeca(nomePeca);

		Item item = getItem(nomeItem);
		if (!(item instanceof JogoTabuleiro)) {
			throw new ItemNaoEhDoTipoEsperadoExcecao("O item de nome informado nao é do tipo tabuleiro");
		}

		JogoTabuleiro jogo = (JogoTabuleiro) item;
		jogo.adicionarPecaPerdida(nomePeca);

	}

	/**
	 * Adiciona um episódio a uma temporada.
	 * 
	 * @param nomeBluray
	 *            o nome da série.
	 * @param duracao
	 *            a duração do episódio.
	 */
	public void addBlueray(String nomeBluray, int duracao) {
		this.validador.validaNome(nomeBluray);
		this.validador.validaDuracao(duracao);

		Item item = getItem(nomeBluray);
		if (!(item instanceof Temporada)) {
			throw new ItemNaoEhDoTipoEsperadoExcecao("O item de nome informado nao é do tipo temporada");
		}

		Temporada temporada = (Temporada) item;
		temporada.addBlueray(duracao);
	}

	/**
	 * Remove um item de um usuário específico.
	 * 
	 * @param nomeItem
	 *            o nome do item.
	 */
	public void removerItem(String nomeItem) {
		this.validaItemParaUso(nomeItem);
		itens.remove(nomeItem);
	}

	/**
	 * Atualiza o atributo de um item.
	 * 
	 * @param nomeItem
	 *            o nome do item.
	 * @param valor
	 *            o novo valor do atributo depois de atualizado.
	 * @param atributo
	 *            o atributo a ser atualizado.
	 */
	public void attItem(String nomeItem, String atributo, String valor) {
		this.validador.validaNome(nomeItem);
		this.validador.validaAtributo(atributo);
		this.validador.validaValor(valor);

		Item itemAtt = getItem(nomeItem);

		if (atributo.equals("Nome")) {
			
			this.validaAttNomeDeItem(valor);
			itemAtt.atualizaAtributo(atributo, valor);
			this.itens.put(valor, itemAtt);
			this.itens.remove(nomeItem);

		} else {
			itemAtt.atualizaAtributo(atributo, valor);

		}
	}

	private void validaAttNomeDeItem(String nomeItem) {

		if (this.itens.containsKey(nomeItem)) {
			throw new IllegalArgumentException();
		}

	}

	/**
	 * Recupera um atributo de um item.
	 * 
	 * @param nomeItem
	 *            o nome do item de interesse.
	 * @param atributo
	 *            o atributo de interesse.
	 * @return o atributo a ser recuperado.
	 */
	public String getInfoItem(String nomeItem, String atributo) {
		this.validador.validaAtributo(atributo);

		Item item = getItem(nomeItem);
		return item.getInfo(atributo);
	}

	/**
	 * Recupera os detalhes de um item.
	 * 
	 * @param nomeItem
	 *            o nome do item.
	 * @return os detalhes do item.
	 */
	public String getDetalhesItem(String nomeItem) {
		this.validaItemParaUso(nomeItem);

		Item item = getItem(nomeItem);
		return item.toString();
	}

	/**
	 * Empresta um item a um outro usuário.
	 * 
	 * @param nomeItem
	 *            o nome do item a ser emprestado.
	 * @param userRequerente
	 *            o usuário que pegará emprestado o item.
	 * @param emprestimo
	 *            o emprestimo a ser adicionado a lista de emprestimos caso o
	 *            item esteja disponível para emprestimo.
	 */
	public void emprestaItem(String nomeItem, Usuario userRequerente, Emprestimo emprestimo) {
		this.validaItemParaUso(nomeItem);

		Item item = this.getItem(nomeItem);

		if (item.isEmprestado()) {
			throw new OperacaoNaoPermitidaNoMomentoExcecao("Item emprestado no momento");
		}

		item.setEmprestado(true);
		userRequerente.emprestimosComoRequerente.add(emprestimo);
		this.emprestimosComoEmprestador.add(emprestimo);
	}

	/**
	 * Devolve um item finalizando o emprestimo.
	 * 
	 * @param nomeItem
	 *            o nome do item emprestado.
	 * @param dataEmprestimo
	 *            a data em que o emprestimo se iniciou.
	 * @param dataDevolucao
	 *            a data em que o emprestimo foi finalizado.
	 * @param userEmprestador
	 *            o usuário dono do item.
	 */
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

	/**
	 * Retorna um valor hash code desse Usuário.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	/**
	 * Indica quando um outro objeto é igual a este.
	 */
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

	/**
	 * Retorna uma representação em string deste usuário.
	 */
	@Override
	public String toString() {
		return this.nome + ", " + this.telefone + ", " + this.email;
	}

	private void validaItemParaUso(String nomeItem) {
		this.validador.validaNome(nomeItem);

		if (!(itens.containsKey(nomeItem))) {
			throw new IllegalArgumentException("Item nao encontrado");
		}
	}

	/**
	 * Atualiza um atributo específico.
	 * 
	 * @param atributo
	 *            o atributo a ser atualizado.
	 * @param valor
	 *            o novo valor do atributo atualizado.
	 */
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

	/**
	 * Recupera um atributo específico.
	 * 
	 * @param atributo
	 *            o atributo a ser recuperado.
	 * @return o atributo.
	 */
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
