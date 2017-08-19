package projeto;

import java.util.List;

import emprestimo.Emprestimo;
import emprestimo.EmprestimoController;
import item.Item;
import item.ItemController;
import usuario.Usuario;
import usuario.UsuarioController;
import util.Listador;

/**
 * Representação de uma fachada do tracking things (Sistema de emprestimos de
 * itens).
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class Facade {

	private UsuarioController usuarioController;
	private ItemController itemController;
	private EmprestimoController emprestimoController;
	private Listador listador;

	/**
	 * Constrói a fachada de um sistema de emprestimos.
	 */
	public Facade() {
		this.usuarioController = new UsuarioController();
		this.itemController = new ItemController();
		this.emprestimoController = new EmprestimoController();
		this.listador = new Listador();
	}

	/**
	 * Inicializa os sistema de emprestimos.
	 */
	public void iniciarSistema() {
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
		this.usuarioController.cadastrarUsuario(nome, telefone, email);
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
	public String getInfoUsuario(String nome, String telefone, String atributo) {
		return this.usuarioController.getInfoUser(nome, telefone, atributo);
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
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		this.usuarioController.attUsuario(nome, telefone, atributo, valor);
	}

	/**
	 * Remove um usuário do sistema.
	 * 
	 * @param nome
	 *            o nome do usuário.
	 * @param telefone
	 *            o telefone do usuário.
	 */
	public void removerUsuario(String nome, String telefone) {
		this.usuarioController.removeUsuario(nome, telefone);
	}

	/**
	 * Cadastra um jogo eletrônico a um usuário específico.
	 * 
	 * @param nome
	 *            o nome do usuário.
	 * @param telefone
	 *            o telefone do usuário.
	 * @param nomeItem
	 *            o nome do jogo.
	 * @param preco
	 *            o preço do jogo.
	 * @param plataforma
	 *            a plataforma do jogo.
	 */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		Item novoItem = this.itemController.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
		this.usuarioController.adicionaItem(nome, telefone, novoItem);
	}

	/**
	 * Cadastra um jogo de tabuleiro a um usuário específico.
	 * 
	 * @param nome
	 *            o nome do usuário.
	 * @param telefone
	 *            o telefone do usuário.
	 * @param nomeItem
	 *            o nome do jogo.
	 * @param preco
	 *            o preço do jogo.
	 */
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		Item novoItem = this.itemController.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
		this.usuarioController.adicionaItem(nome, telefone, novoItem);
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
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		this.usuarioController.addPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}

	/**
	 * Cadastra um filme blu-ray a um usuário específico.
	 * 
	 * @param nome
	 *            o nome do usuário.
	 * @param telefone
	 *            o telefone do usuário.
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
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		Item novoItem = this.itemController.cadastrarBlurayFilme(nome, telefone, nomeItem, preco, duracao, genero,
				classificacao, anoLancamento);
		this.usuarioController.adicionaItem(nome, telefone, novoItem);
	}

	/**
	 * Cadastra uma temporada em blu-ray de uma série a um usuário específico.
	 * 
	 * @param nome
	 *            o nome do usuário.
	 * @param telefone
	 *            o telefone do usuário.
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
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		Item novoItem = this.itemController.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao,
				classificacao, genero, temporada);
		this.usuarioController.adicionaItem(nome, telefone, novoItem);
	}

	/**
	 * Cadastra um show blu-ray a um usuário específico.
	 * 
	 * @param nome
	 *            o nome do usuário.
	 * @param telefone
	 *            o telefone do usuário.
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
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) {
		Item novoItem = this.itemController.cadastrarBlurayShow(nome, telefone, nomeItem, preco, duracao, numeroFaixas,
				artista, classificacao);
		this.usuarioController.adicionaItem(nome, telefone, novoItem);
	}

	/**
	 * Adiciona um episódio a uma temporada.
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
	public void adicionarBluRay(String nome, String telefone, String nomeBluray, int duracao) {
		this.usuarioController.addBluray(nome, telefone, nomeBluray, duracao);
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
		this.usuarioController.removerItem(nome, telefone, nomeItem);
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
	public void atualizarItem(String nome, String telefone, String nomeItem, String valor, String atributo) {
		this.usuarioController.attItem(nome, telefone, nomeItem, valor, atributo);
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
		return this.usuarioController.getInfoItem(nome, telefone, nomeItem, atributo);
	}

	/**
	 * Recupera uma listagem de todos os itens no sistema em ordem alfabética.
	 * 
	 * @return a listagem.
	 */
	public String listarItensOrdenadosPorNome() {
		List<Item> itens = this.usuarioController.getItensNoSistema();
		return this.listador.listaItensOrdenadosPorNome(itens);
	}

	/**
	 * Recupera uma listagem de todos os itens no sistema ordenados por valor.
	 * 
	 * @return a listagem.
	 */
	public String listarItensOrdenadosPorValor() {
		List<Item> itens = this.usuarioController.getItensNoSistema();
		return this.listador.listaItensOrdenadosPorValor(itens);
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
	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		return this.usuarioController.getDetalhesItem(nome, telefone, nomeItem);
	}

	/**
	 * Registra um emprestimo de um item.
	 * 
	 * @param nomeDono
	 *            o nome do usuário dono do item.
	 * @param telefoneDono
	 *            o telefone do usuário dono do item.
	 * @param nomeRequerente
	 *            o nome do usuário requerente do item.
	 * @param telefoneRequerente
	 *            o telefone do usuário requerente do item.
	 * @param nomeItem
	 *            o nome do item.
	 * @param dataEmprestimo
	 *            a data em que o emprestimo foi iniciado.
	 * @param periodo
	 *            o período em que o item ficará emprestado.
	 */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {
		Usuario userEmprestador = usuarioController.getUser(nomeDono, telefoneDono);
		Usuario userRequerente = usuarioController.getUser(nomeRequerente, telefoneRequerente);
		this.emprestimoController.registrarEmprestimo(userEmprestador, userRequerente, nomeItem, dataEmprestimo,
				periodo);
	}

	/**
	 * Devolve um item.
	 * 
	 * @param nomeDono
	 *            o nome do usuário dono do item.
	 * @param telefoneDono
	 *            o telefone do usuário dono do item.
	 * @param nomeRequerente
	 *            o nome do usuário requerente do item.
	 * @param telefoneRequerente
	 *            o telefone do usuário requerente do item.
	 * @param nomeItem
	 *            o nome do item.
	 * @param dataEmprestimo
	 *            a data em que o emprestimo foi iniciado.
	 * @param dataDevolucao
	 *            a data em que o item foi devolvido.
	 */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		Usuario userEmprestador = usuarioController.getUser(nomeDono, telefoneDono);
		Usuario userRequerente = usuarioController.getUser(nomeRequerente, telefoneRequerente);
		this.emprestimoController.devolverItem(userEmprestador, userRequerente, nomeItem, dataEmprestimo,
				dataDevolucao);
	}

	public String listarItensNaoEmprestados() {
		List<Item> itens = this.usuarioController.getItensNoSistema();
		List<Item> itensNaoEmprestados = this.itemController.getItensNaoEmprestados(itens);
		return this.listador.listarItensNaoEmprestados(itensNaoEmprestados);
	}

	public String listarItensEmprestados() {
		List<Emprestimo> emprestimos = this.emprestimoController.getEmprestimosNaoFinalizados();
		return this.listador.listarItensEmprestados(emprestimos);
	}

	public String listarTop10Itens() {
		List<Item> itens = this.usuarioController.getItensNoSistema();
		return this.listador.listarTop10Itens(itens);
	}

	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {
		Usuario user = this.usuarioController.getUser(nome, telefone);
		List<Emprestimo> emprestimos = this.emprestimoController.getEmprestimosUserEmprestando(user);
		return this.listador.listarEmprestimosUsuarioEmprestando(emprestimos);
	}

	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		Usuario user = this.usuarioController.getUser(nome, telefone);
		List<Emprestimo> emprestimos = this.emprestimoController.getEmprestimosUserPegandoEmprestado(user);
		return this.listador.listarEmprestimosUsuarioPegandoEmprestado(emprestimos);
	}

	public String listarEmprestimosItem(String nomeItem) {
		List<Emprestimo> emprestimos = this.emprestimoController.getEmprestimosItem(nomeItem);
		return this.listador.listarEmprestimosItem(emprestimos);
	}
	
	public String listarCaloteiros() {
		return this.listador.listarCaloteiros(this.usuarioController.getUsuariosNoSistema());
	}
	
	public String listarTop10MelhoresUsuarios() {
		return this.listador.listarTop10MelhoresUsuarios(this.usuarioController.getUsuariosNoSistema());
	}
	
	public String listarTop10PioresUsuarios() {
		return this.listador.listarTop10PioresUsuarios(this.usuarioController.getUsuariosNoSistema());
	}

	public String listarCaloteiros() {
		List<Usuario> usuarios = this.usuarioController.getUsuariosNoSistema();
		return this.listador.listarCaloteiros(usuarios);
	}
	
	public String listarTop10MelhoresUsuarios() {
		List<Usuario> usuarios = this.usuarioController.getUsuariosNoSistema();
		return "";
	}
	
	public String listarTop10PioresUsuarios() {
		List<Usuario> usuarios = this.usuarioController.getUsuariosNoSistema();
		return "";
	}
	
	
	
	/**
	 * Fecha o sistema de apostas.
	 */
	public void fecharSistema() {

	}

}
