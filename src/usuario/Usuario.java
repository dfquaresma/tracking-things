package usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import excecoes.ItemNaoEhDoTipoEsperadoExcecao;
import excecoes.OperacaoNaoPermitidaNoMomentoExcecao;
import item.Item;
import item.bluray.Temporada;
import item.jogo.JogoTabuleiro;
import validador.Validador;

/**
 * Representação de um usuário no sistema.
 * 
 * @author David Ferreira
 *
 */
public class Usuario {

	private String nome;
	private String telefone;
	private String email;
	private Map<String, Item> itens;
	private Validador validador;
	private Reputacao reputacao;

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
		this.reputacao = new Reputacao();

	}

	/**
	 * Adiciona um item a um usuário específico.
	 * 
	 * @param item
	 */
	public void adicionaItem(Item item) {
		String nomeDoItem = item.getNome();
		this.validador.validaAtributosDeCadastroDeItem(nomeDoItem, item.getPreco());
		this.itens.put(nomeDoItem, item);
		
		this.reputacao.adicionandoItemParaEmprestimo(item.getPreco());
	}
	
	/**
	 * Remove um item de um usuário específico.
	 * 
	 * @param nomeItem
	 *            o nome do item.
	 */
	public void removerItem(String nomeItem) {
		this.validaItemParaUso(nomeItem);
		Item item = this.getItem(nomeItem);
		
		this.itens.remove(nomeItem);
		
		this.reputacao.removendoItemParaEmprestimo(item.getPreco());
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
	public void addBlueray(String nomeBlueray, int duracao) {
		this.validador.validaNome(nomeBlueray);
		this.validador.validaDuracao(duracao);

		Item item = getItem(nomeBlueray);
		if (!(item instanceof Temporada)) {
			throw new ItemNaoEhDoTipoEsperadoExcecao("O item de nome informado nao é do tipo temporada");
		}

		Temporada temporada = (Temporada) item;
		temporada.addBlueray(duracao);
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
	 * Atualiza os status de um item ao ser emprestado.
	 * 
	 * @param nomeItem
	 *            o nome do item que está sendo emprestado.
	 */
	public void emprestaItem(String nomeItem) {
		this.validaItemParaUso(nomeItem);

		Item item = this.getItem(nomeItem);
		if (item.isEmprestado()) {
			throw new OperacaoNaoPermitidaNoMomentoExcecao("Item emprestado no momento");
		}
		item.setEmprestado(true);
		
		this.reputacao.emprestandoItem(item.getPreco());
	}

	/**
	 * Atualiza os status de um item que está sendo devoldido.
	 * 
	 * @param nomeItem
	 *            o nome do item que está sendo devolvido.
	 */
	public void recebeItem(String nomeItem) {
		this.validaItemParaUso(nomeItem);

		Item item = this.getItem(nomeItem);
		if (!item.isEmprestado()) {
			throw new OperacaoNaoPermitidaNoMomentoExcecao("Item nao esta emprestado no momento");
		}
		item.setEmprestado(false);
	}
	
	/**
	 * 
	 */
	public void devolveItem(String nomeItem, int diasAtraso)
	{
		this.validaItemParaUso(nomeItem);
		
		Item item = this.getItem(nomeItem);
		this.reputacao.devolveItem(dias)
	}

	/**
	 * Atualiza um atributo específico do usuário.
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
	 * Recupera um atributo específico do usuário.
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
		case ("Reputacao"):
			return String.format("%f", this.getReputacao());
		default:
			throw new IllegalArgumentException("Atributo invalido.");
		}
	}
	
	private void validaItemParaUso(String nomeItem) {
		this.validador.validaNomeItem(nomeItem);

		if (!(itens.containsKey(nomeItem))) {
			throw new IllegalArgumentException("Item nao encontrado");
		}
	}

	private void validaAttNomeDeItem(String nomeItem) {

		if (this.itens.containsKey(nomeItem)) {
			throw new IllegalArgumentException();
		}

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
	
	public double getReputacao()
	{
		return this.reputacao.getReputacao();
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
		return new ArrayList<>(this.itens.values());
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
}
