package sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import excecoes.OperacaoNaoPermitidaNoMomentoExcecao;
import excecoes.UsuarioJaExistenteExcecao;
import item.Item;
import usuario.Emprestimo;
import usuario.IdUsuario;
import usuario.Usuario;
import util.Listador;
import util.Validador;

public class Controller {

	private Map<IdUsuario, Usuario> usuarios;
	private Listador listador;
	private Validador validador;

	public Controller() {
		this.usuarios = new HashMap<>();
		this.listador = new Listador();
		this.validador = new Validador();
	}
	
	public void iniciaSistema() {
		// TODO Auto-generated method stub

	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		validaDadosDeIdentificacao(nome, telefone);
		this.validador.validaEmail(email);

		IdUsuario id = new IdUsuario(nome, telefone);
		Usuario user = new Usuario(nome, telefone, email);

		if (this.usuarios.containsKey(id)) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}

		this.usuarios.put(id, user);
	}

	private void validaDadosDeIdentificacao(String nome, String telefone) {
		this.validador.validaNome(nome);
		this.validador.validaTelefone(telefone);
	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		validaDadosDeIdentificacao(nome, telefone);
		validaAtributosDeCadastroDeItem(nomeItem, preco);

		Usuario user = getUser(nome, telefone);
		user.cadastrarEletronico(nomeItem, preco, plataforma);
	}

	private void validaAtributosDeCadastroDeItem(String nomeItem, double preco) {
		this.validador.validaNomeItem(nomeItem);
		this.validador.validaPreco(preco);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		validaDadosDeIdentificacao(nome, telefone);
		validaAtributosDeCadastroDeItem(nomeItem, preco);

		Usuario user = getUser(nome, telefone);
		user.cadastrarJogoTabuleiro(nomeItem, preco);
	}

	public void cadastrarBlurayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		validaDadosDeIdentificacao(nome, telefone);
		validaAtributosDeCadastroDeItem(nomeItem, preco);
		validaAtributosDeCadastroDeItensCinematograficos(duracao, genero, classificacao);
		this.validador.validaAnoLancamento(anoLancamento);

		Usuario user = getUser(nome, telefone);
		user.cadastrarBlurayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		validaDadosDeIdentificacao(nome, telefone);
		validaAtributosDeCadastroDeItem(nomeItem, preco);
		validaAtributosDeCadastroDeItensCinematograficos(duracao, genero, classificacao);
		this.validador.validaTemporada(temporada);

		Usuario user = getUser(nome, telefone);
		user.cadastrarBluRaySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
	}
	
	private void validaAtributosDeCadastroDeItensCinematograficos(int duracao, String genero, String classificacao) {
		this.validador.validaDuracao(duracao);
		this.validador.validaGenero(genero);
		this.validador.validaClassificacao(classificacao);
	}

	public void cadastrarBlurayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) {
		validaDadosDeIdentificacao(nome, telefone);
		validaAtributosDeCadastroDeItem(nomeItem, preco);
		this.validador.validaClassificacao(classificacao);
		this.validador.validaDuracao(duracao);

		Usuario user = getUser(nome, telefone);
		user.cadastrarBlurayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
	}

	private Usuario getUser(String nome, String telefone) {
		validaDadosDeIdentificacao(nome, telefone);
		IdUsuario id = new IdUsuario(nome, telefone);
		validaIdeParaUso(id);
		return this.usuarios.get(id);
	}

	public String getInfoUser(String nome, String telefone, String atributo) {
		validaDadosDeIdentificacao(nome, telefone);
		this.validador.validaAtributo(atributo);
		
		Usuario user = getUser(nome, telefone);

		switch (atributo) {
		case ("Nome"):
			return user.getNome();
		case ("Telefone"):
			return user.getTelefone();
		case ("Email"):
			return user.getEmail();
		default:
			throw new IllegalArgumentException("Atributo invalido.");
		}
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		validaDadosDeIdentificacao(nome, telefone);
		this.validador.validaNomeItem(nomeItem);
		this.validador.validaAtributo(atributo);

		Usuario user = getUser(nome, telefone);
		return user.getInfoItem(nomeItem, atributo);
	}

	public String getDetalhesItem(String nome, String telefone, String nomeItem) {
		validaDadosDeIdentificacao(nome, telefone);
		this.validador.validaNomeItem(nomeItem);

		Usuario user = getUser(nome, telefone);
		return user.getDetalhesItem(nomeItem);
	}

	public void attUsuario(String nome, String telefone, String atributo, String valor) {
		validaDadosDeIdentificacao(nome, telefone);
		this.validador.validaAtributo(atributo);
		this.validador.validaValor(valor);

		Usuario user = getUser(nome, telefone);

		validaAtualizacao(user, atributo, valor);
		IdUsuario idAntigo = new IdUsuario(nome, telefone);

		switch (atributo) {

		case ("Nome"):
			user.setNome(valor);
			break;
		case ("Telefone"):
			user.setTelefone(valor);
			break;
		case ("Email"):
			user.setEmail(valor);
			break;
		default:
			throw new IllegalArgumentException("Atributo invalido");
		}

		IdUsuario novoId = new IdUsuario(user.getNome(), user.getTelefone());
		this.usuarios.remove(idAntigo);
		this.usuarios.put(novoId, user);

	}

	private void validaIdeParaUso(IdUsuario id) {
		if (!this.usuarios.containsKey(id)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	}

	private void validaAtualizacao(Usuario user, String atributo, String valor) {
		if (atributo.equals("Nome")) {
			IdUsuario id = new IdUsuario(valor, user.getTelefone());
			validaIdeParaAtt(id);

		} else if (atributo.equals("Telefone")) {
			IdUsuario id = new IdUsuario(user.getNome(), valor);
			validaIdeParaAtt(id);
		}

	}

	private void validaIdeParaAtt(IdUsuario id) {
		if (this.usuarios.containsKey(id)) {
			throw new UsuarioJaExistenteExcecao("Usuario invalido");
		}
	}

	public void removeUsuario(String nome, String telefone) {
		validaDadosDeIdentificacao(nome, telefone);

		IdUsuario id = new IdUsuario(nome, telefone);
		validaIdeParaUso(id);
		this.usuarios.remove(id);

	}

	public void addPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		validaDadosDeIdentificacao(nome, telefone);
		this.validador.validaNomeItem(nomeItem);
		this.validador.validaPeca(nomePeca);

		Usuario user = getUser(nome, telefone);
		user.addPecaPerdida(nomeItem, nomePeca);
	}

	public void addBluray(String nome, String telefone, String nomeBluray, int duracao) {
		validaDadosDeIdentificacao(nome, telefone);
		this.validador.validaNomeBluray(nomeBluray);
		this.validador.validaDuracao(duracao);

		Usuario user = getUser(nome, telefone);
		user.addBlueray(nomeBluray, duracao);
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		validaDadosDeIdentificacao(nome, telefone);
		this.validador.validaNomeItem(nomeItem);

		Usuario user = getUser(nome, telefone);
		user.removerItem(nomeItem);
	}

	public void attItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		validaDadosDeIdentificacao(nome, telefone);
		this.validador.validaNomeItem(nomeItem);
		this.validador.validaAtributo(atributo);
		this.validador.validaValor(valor);

		Usuario user = getUser(nome, telefone);
		user.attItem(nomeItem, atributo, valor);
	}

	public String listarOrdenadosNome() {
		List<Item> itens = new ArrayList<>();

		for (Usuario user : this.usuarios.values()) {
			itens.addAll(user.getItens());
		}
		
		validaListagem(itens.size());
		
		return this.listador.listaItensOrdenadosPorNome(itens);
	}

	public String listarOrdenadosValor() {
		List<Item> itens = new ArrayList<>();

		for (Usuario user : this.usuarios.values()) {
			itens.addAll(user.getItens());
		}
		
		validaListagem(itens.size());
		
		return this.listador.listaItensOrdenadosPorValor(itens);
	}

	private void validaListagem(int size) {
		if (size == 0) {
			throw new OperacaoNaoPermitidaNoMomentoExcecao("Nao ha itens para serem listados no momento");
		}
	}
	
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {
		Usuario userEmprestador = getUser(nomeDono, telefoneDono);
		Usuario userRequerente = getUser(nomeRequerente, telefoneRequerente);
		Item item = userEmprestador.getItem(nomeItem);
		Emprestimo emprestimo = new Emprestimo(userEmprestador, userRequerente, item, dataEmprestimo, periodo);
		userEmprestador.emprestaItem(nomeItem, userRequerente, emprestimo);

	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		Usuario userEmprestador = getUser(nomeDono, telefoneDono);
		Usuario userRequerente = getUser(nomeRequerente, telefoneRequerente);
		userRequerente.devolveItem(nomeItem, dataEmprestimo, dataDevolucao, userEmprestador);
	}

	public void fechaSistema() {
		// TODO Auto-generated method stub

	}

}
