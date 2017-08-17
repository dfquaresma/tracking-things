package usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import excecoes.UsuarioJaExistenteExcecao;
import item.Item;
import util.Validador;

/**
 * Representação de um sistema de emprestimos de itens entre usuários.
 * 
 * @author David Ferreira
 *
 */
public class UsuarioController {

	private Map<IdUsuario, Usuario> usuarios;
	private Validador validador;

	/**
	 * Constrói um sistema de emprestimos.
	 */
	public UsuarioController() {
		this.usuarios = new HashMap<>();
		this.validador = new Validador();
	}

	/**
	 * Cadastra um usuário no sistema.
	 * 
	 * @param nome
	 *            nome do usuário a ser cadastrado.
	 * @param telefone
	 *            telefone do usuário a ser cadastrado.
	 * @param email
	 *            email do usuário a ser cadastrado.
	 */
	public void cadastrarUsuario(String nome, String telefone, String email) {
		this.validador.validaDadosDeIdentificacao(nome, telefone);
		this.validador.validaEmail(email);

		IdUsuario id = new IdUsuario(nome, telefone);
		Usuario user = new Usuario(nome, telefone, email);

		if (this.usuarios.containsKey(id)) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}

		this.usuarios.put(id, user);
	}

	public Usuario getUser(String nome, String telefone) {
		this.validador.validaDadosDeIdentificacao(nome, telefone);
		IdUsuario id = new IdUsuario(nome, telefone);

		this.validaIdeParaUso(id);
		return this.usuarios.get(id);
	}

	/**
	 * Recupera um atributo de um usuário específico.
	 * 
	 * @param nome
	 *            o nome do usuário que se dejesa recuperar o atributo.
	 * @param telefone
	 *            o telefone do usuário que se dejesa recuperar o atributo.
	 * @param atributo
	 *            o atributo do usuário que se dejesa recuperar.
	 * 
	 * @return o atributo recuperado.
	 */
	public String getInfoUser(String nome, String telefone, String atributo) {
		this.validador.validaDadosDeIdentificacao(nome, telefone);
		this.validador.validaAtributo(atributo);

		Usuario user = getUser(nome, telefone);
		return user.getInfor(atributo);

	}

	/**
	 * Atualiza um atributo de um usuário específico.
	 * 
	 * @param nome
	 *            o nome do usuário que se deseja atualizar um atributo.
	 * @param telefone
	 *            o telefone do usuário que se deseja atualizar um atributo.
	 * @param atributo
	 *            o atributo que se deseja atualizar.
	 * @param valor
	 *            o novo valor do atributo a ser atualizado.
	 */
	public void attUsuario(String nome, String telefone, String atributo, String valor) {
		this.validador.validaDadosDeIdentificacao(nome, telefone);
		this.validador.validaAtributo(atributo);
		this.validador.validaValor(valor);

		Usuario user = getUser(nome, telefone);

		this.validaAtualizacao(user, atributo, valor);

		IdUsuario idAntigo = new IdUsuario(nome, telefone);
		user.atualizaAtributo(atributo, valor);

		IdUsuario novoId = new IdUsuario(user.getNome(), user.getTelefone());
		this.usuarios.remove(idAntigo);
		this.usuarios.put(novoId, user);

	}

	/**
	 * Remove um usuário do sistema.
	 * 
	 * @param nome
	 *            o nome do usuário.
	 * @param telefone
	 *            o telefone do usuário.
	 */
	public void removeUsuario(String nome, String telefone) {
		this.validador.validaDadosDeIdentificacao(nome, telefone);

		IdUsuario id = new IdUsuario(nome, telefone);
		this.validaIdeParaUso(id);
		this.usuarios.remove(id);

	}

	public void adicionaItem(String nome, String telefone, Item item) {
		this.validador.validaDadosDeIdentificacao(nome, telefone);

		Usuario user = getUser(nome, telefone);
		user.adicionaItem(item);		
		
	}
	
	/**
	 * Recupera um atributo de um item de um usuário específico.
	 * 
	 * @param nome
	 *            o nome o usuário.
	 * @param telefone
	 *            o telefone do usuário.
	 * @param nomeItem
	 *            o nome do item de interesse.
	 * @param atributo
	 *            o atributo de interesse.
	 * @return o atributo a ser recuperado.
	 */
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		this.validador.validaDadosDeIdentificacao(nome, telefone);
		this.validador.validaNomeItem(nomeItem);
		this.validador.validaAtributo(atributo);
		
		Usuario user = getUser(nome, telefone);
		return user.getInfoItem(nomeItem, atributo);
	}

	/**
	 * Recupera os detalhes de um item de um usuário em específico.
	 * 
	 * @param nome
	 *            o nome do usuário.
	 * @param telefone
	 *            o telefone do usuário.
	 * @param nomeItem
	 *            o nome do item.
	 * @return os detalhes do item.
	 */
	public String getDetalhesItem(String nome, String telefone, String nomeItem) {
		this.validador.validaDadosDeIdentificacao(nome, telefone);
		this.validador.validaNomeItem(nomeItem);

		Usuario user = getUser(nome, telefone);
		return user.getDetalhesItem(nomeItem);
	}
	
	/**
	 * Adiciona uma peça perdida a um jogo de tabuleiro de um usuário
	 * específico.
	 * 
	 * @param nome
	 *            o nome do usuário.
	 * @param telefone
	 *            o telefone do usuário.
	 * @param nomeItem
	 *            o nome do jogo.
	 * @param nomePeca
	 *            a peça a ser adicionada.
	 */
	public void addPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		this.validador.validaDadosDeIdentificacao(nome, telefone);
		this.validador.validaNomeItem(nomeItem);
		this.validador.validaPeca(nomePeca);

		Usuario user = getUser(nome, telefone);
		user.addPecaPerdida(nomeItem, nomePeca);
	}

	/**
	 * Adiciona um episódio a uma temporada de um usuário específico.
	 * 
	 * @param nome
	 *            o nome do usuário.
	 * @param telefone
	 *            o telefone do usuário.
	 * @param nomeBluray
	 *            o nome da série.
	 * @param duracao
	 *            a duração do episódio.
	 */
	public void addBluray(String nome, String telefone, String nomeBluray, int duracao) {
		this.validador.validaDadosDeIdentificacao(nome, telefone);
		this.validador.validaNomeBluray(nomeBluray);
		this.validador.validaDuracao(duracao);

		Usuario user = getUser(nome, telefone);
		user.addBlueray(nomeBluray, duracao);
	}

	/**
	 * Remove um item de um usuário específico.
	 * 
	 * @param nome
	 *            o nome do usuário.
	 * @param telefone
	 *            o telefone do usuário.
	 * @param nomeItem
	 *            o nome do item.
	 */
	public void removerItem(String nome, String telefone, String nomeItem) {
		this.validador.validaDadosDeIdentificacao(nome, telefone);
		this.validador.validaNomeItem(nomeItem);

		Usuario user = getUser(nome, telefone);
		user.removerItem(nomeItem);
	}

	/**
	 * Atualiza o atributo de um item de um usuário específico.
	 * 
	 * @param nome
	 *            o nome o usuário.
	 * @param telefone
	 *            o telefone do usuário.
	 * @param nomeItem
	 *            o nome do item.
	 * @param valor
	 *            o novo valor do atributo depois de atualizado.
	 * @param atributo
	 *            o atributo a ser atualizado.
	 */
	public void attItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		this.validador.validaDadosDeIdentificacao(nome, telefone);
		this.validador.validaNomeItem(nomeItem);
		this.validador.validaAtributo(atributo);
		this.validador.validaValor(valor);

		Usuario user = getUser(nome, telefone);
		user.attItem(nomeItem, atributo, valor);
	}

	public List<Item> getItensNoSistema() {
		List<Item> itens = new ArrayList<>();

		for (Usuario user : this.usuarios.values()) {
			itens.addAll(user.getItens());
		}
		return itens;
	}

	private void validaIdeParaUso(IdUsuario id) {
		if (!this.usuarios.containsKey(id)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	}

	private void validaAtualizacao(Usuario user, String atributo, String valor) {
		if (atributo.equals("Nome")) {
			IdUsuario id = new IdUsuario(valor, user.getTelefone());
			this.validaIdeParaAtt(id);

		} else if (atributo.equals("Telefone")) {
			IdUsuario id = new IdUsuario(user.getNome(), valor);
			this.validaIdeParaAtt(id);
		}

	}

	private void validaIdeParaAtt(IdUsuario id) {
		if (this.usuarios.containsKey(id)) {
			throw new UsuarioJaExistenteExcecao("Usuario invalido");
		}
	}
	
	public List<Usuario> getUsuariosNoSistema() {
		return new ArrayList<Usuario>(this.usuarios.values());
	}

}
