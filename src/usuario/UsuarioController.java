package usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import excecoes.OperacaoNaoPermitidaNoMomentoExcecao;
import excecoes.UsuarioJaExistenteExcecao;
import item.Item;
import util.ValidadorUsuario;

/**
 * Representa um controlador de usuários. Nele estão todos os usuários do
 * sistema.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class UsuarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<IdUsuario, Usuario> usuarios;
	private ValidadorUsuario validador;

	/**
	 * Constrói um controlador de usuários.
	 */
	public UsuarioController() {
		this.usuarios = new HashMap<>();
		this.validador = new ValidadorUsuario();
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
			throw new UsuarioJaExistenteExcecao("Usuario ja cadastrado");
		}

		this.usuarios.put(id, user);
	}

	/**
	 * Recupera um usuário a partir do seu nome e telefone.
	 * 
	 * @param nome
	 *            o nome do usuário que se deseja recuperar.
	 * @param telefone
	 *            o telefone do usuário que se deseja recuperar.
	 * @return o usuário a ser recuperado.
	 */
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

	/**
	 * Adiciona um idem a um usuário específico.
	 * 
	 * @param nome
	 *            o nome do usuário.
	 * @param telefone
	 *            o telefone do usuário.
	 * @param item
	 *            o item a ser adicionado.
	 */
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

		Usuario user = getUser(nome, telefone);
		user.addBluray(nomeBluray, duracao);
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
			throw new UsuarioJaExistenteExcecao("Usuario ja existente");
		}
	}

	/**
	 * Recupera os usuários do sistema.
	 * 
	 * @return uma lista com os usuários do sistema.
	 */
	public List<Usuario> getUsuariosNoSistema() {
		return new ArrayList<Usuario>(this.usuarios.values());
	}

	/**
	 * Recupera o mapa de usuários do sistema.
	 * 
	 * @return o mapa de usuários.
	 */
	public Map<IdUsuario, Usuario> getUsuarios() {
		return this.usuarios;

	}

	/**
	 * Atribui ao mapa de usuários o mapa recebido.
	 * 
	 * @param usuarios
	 *            o novo mapa de usuários.
	 */
	public void setUsuarios(Map<IdUsuario, Usuario> usuarios) {
		if (usuarios == null) {
			throw new NullPointerException("usurios nao pode ser nulo");
		}
		if (!usuarios.isEmpty()) {
			for (Usuario u : usuarios.values()) {
				if (u.getUID() != 1L) {
					throw new OperacaoNaoPermitidaNoMomentoExcecao("Persistencia invalida. Usuário(s) obsoleto(s).");
				}
			}
		}

		this.usuarios = usuarios;
	}

}
