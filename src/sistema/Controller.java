package sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import item.Item;
import usuario.IdUsuario;
import usuario.Usuario;
import util.Listador;
import util.Validacoes;

public class Controller {
	
	private Map<IdUsuario, Usuario> usuarios;
	private Listador listador;
	private Validacoes valida;

	public Controller() {
		this.usuarios = new HashMap<>();
		this.listador = new Listador();
		this.valida =  new Validacoes();
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		valida.validaNome(nome);
		valida.validaTelefone(telefone);
		valida.validaEmail(email);
		
		IdUsuario id = new IdUsuario(nome, telefone);
		Usuario user = new Usuario(nome, telefone, email);

		if (this.usuarios.containsKey(id)) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}
		this.usuarios.put(id, user);
	}

	private Usuario getUser(String nome, String telefone) {
		valida.validaNome(nome);
		valida.validaTelefone(telefone);
		
		IdUsuario id = new IdUsuario(nome, telefone);
		validaIdeParaUso(id);
		return this.usuarios.get(id);
	}

	private void validaIdeParaUso(IdUsuario id) {
		if (!this.usuarios.containsKey(id)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	}

	public String getInfoUser(String nome, String telefone, String atributo) {
		valida.validaNome(nome);
		valida.validaTelefone(telefone);
		
		Usuario user = getUser(nome, telefone);

		switch (atributo) {

		case ("Nome"):
			return user.getNome();
		case ("Telefone"):
			return user.getTelefone();
		case ("Email"):
			return user.getEmail();
		default:
			throw new IllegalArgumentException();

		}
	}

	public void attUsuario(String nome, String telefone, String atributo, String valor) {
		valida.validaNome(nome);
		valida.validaTelefone(telefone);
		valida.validaValor(valor);
		
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
			throw new IllegalArgumentException();
		}

		IdUsuario novoId = new IdUsuario(user.getNome(), user.getTelefone());
		this.usuarios.remove(idAntigo);
		this.usuarios.put(novoId, user);

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
			throw new IllegalArgumentException("Usuario invalido");
		}
	}

	public void removeUsuario(String nome, String telefone) {
		valida.validaNome(nome);
		valida.validaTelefone(telefone);
		
		IdUsuario id = new IdUsuario(nome, telefone);
		validaIdeParaUso(id);
		this.usuarios.remove(id);

	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		valida.validaNome(nome);
		valida.validaTelefone(telefone);
		valida.validaNomeItem(nomeItem);
		valida.validaPreco(preco);
		
		Usuario user = getUser(nome, telefone);
		user.cadastrarEletronico(nomeItem, preco, plataforma);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		valida.validaNome(nome);
		valida.validaTelefone(telefone);
		valida.validaNomeItem(nomeItem);
		valida.validaPreco(preco);
		
		Usuario user = getUser(nome, telefone);
		user.cadastrarJogoTabuleiro(nomeItem, preco);
	}

	public void addPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		valida.validaNome(nome);
		valida.validaTelefone(telefone);
		valida.validaNomeItem(nomeItem);
		
		Usuario user = getUser(nome, telefone);
		user.addPecaPerdida(nomeItem, nomePeca);
	}

	public void cadastrarBlurayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		valida.validaNome(nome);
		valida.validaTelefone(telefone);
		valida.validaNomeItem(nomeItem);
		valida.validaDuracao(duracao);
		valida.validaGenero(genero);
		valida.validaClassificacao(classificacao);
		valida.validaAnoLancamento(anoLancamento);
		valida.validaPreco(preco);
		
		Usuario user = getUser(nome, telefone);
		user.cadastrarBlurayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		valida.validaNome(nome);
		valida.validaTelefone(telefone);
		valida.validaNomeItem(nomeItem);
		valida.validaDuracao(duracao);
		valida.validaGenero(genero);
		valida.validaClassificacao(classificacao);
		valida.validaTemporada(temporada);
		valida.validaPreco(preco);
		
		Usuario user = getUser(nome, telefone);
		user.cadastrarBluRaySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
	}

	public void cadastrarBlurayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) {
		valida.validaNome(nome);
		valida.validaTelefone(telefone);
		valida.validaNomeItem(nomeItem);
		valida.validaDuracao(duracao);
		valida.validaClassificacao(classificacao);
		
		
		Usuario user = getUser(nome, telefone);
		user.cadastrarBlurayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
	}

	public void addBluray(String nome, String telefone, String nomeBluray, int duracao) {
		valida.validaNome(nome);
		valida.validaTelefone(telefone);
		valida.validaNomeBluray(nomeBluray);
		valida.validaDuracao(duracao);
		
		Usuario user = getUser(nome, telefone);
		user.addBlueray(nomeBluray, duracao);
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		valida.validaNome(nome);
		valida.validaTelefone(telefone);
		valida.validaNomeItem(nomeItem);
		
		Usuario user = getUser(nome, telefone);
		user.removerItem(nomeItem);
	}

	public void attItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		valida.validaNome(nome);
		valida.validaTelefone(telefone);
		valida.validaNomeItem(nomeItem);
		valida.validaValor(valor);
		
		Usuario user = getUser(nome, telefone);
		user.attItem(nomeItem, atributo, valor);
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		valida.validaNome(nome);
		valida.validaTelefone(telefone);
		valida.validaNomeItem(nomeItem);
		
		Usuario user = getUser(nome, telefone);
		return user.getInfoItem(nomeItem, atributo);
	}

	public String listarOrdenadosNome() {
		List<Item> itens = new ArrayList<>();

		for (Usuario user : this.usuarios.values()) {
			itens.addAll(user.getItens());
		}
		return this.listador.listaItensOrdenadosPorNome(itens);
	}

	public String listarOrdenadosValor() {
		List<Item> itens = new ArrayList<>();

		for (Usuario user : this.usuarios.values()) {
			itens.addAll(user.getItens());
		}
		return this.listador.listaItensOrdenadosPorValor(itens);
	}

	public String getDetalhesItem(String nome, String telefone, String nomeItem) {
		valida.validaNome(nome);
		valida.validaTelefone(telefone);
		valida.validaNomeItem(nomeItem);
		
		Usuario user = getUser(nome, telefone);
		return user.getDetalhesItem(nomeItem);
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {
		Usuario userEmprestador = getUser(nomeDono, telefoneDono);
		Usuario userRequerente = getUser(nomeRequerente, telefoneRequerente);
		userEmprestador.emprestaItem(nomeItem, dataEmprestimo, periodo, userRequerente);

	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		Usuario user = getUser(nomeRequerente, telefoneRequerente);
		user.devolveItem(nomeDono, telefoneDono, nomeItem, dataEmprestimo, dataDevolucao);			
	}

}
