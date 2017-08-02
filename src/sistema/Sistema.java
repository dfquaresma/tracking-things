package sistema;

import java.util.ArrayList;
import java.util.List;

import item.Item;
import usuario.Usuario;

public class Sistema {
	private List<Usuario> usuarios;
	private Listador listador;

	public Sistema() {
		this.usuarios = new ArrayList<>();
		this.listador = new Listador();
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		Usuario user = new Usuario(nome, telefone, email);

		if (this.usuarios.contains(user)) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}
		this.usuarios.add(user);

	}

	private Usuario getUser(String nome, String telefone) {

		for (Usuario user : this.usuarios) {
			if (user.getNome().equals(nome) && user.getTelefone().equals(telefone)) {
				return user;
			}
		}
		throw new IllegalArgumentException("Usuario invalido");

	}

	public String getInfoUser(String nome, String telefone, String atributo) {
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
		Usuario user = getUser(nome, telefone);

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

	}

	public void removeUsuario(String nome, String telefone) {

		for (int i = 0; i < this.usuarios.size(); i++) {
			Usuario user = this.usuarios.get(i);
			if (user.getNome().equals(nome) && user.getTelefone().equals(telefone)) {
				this.usuarios.remove(i);
				return;
			}
		}
		throw new IllegalArgumentException("Usuario invalido");

	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		Usuario user = getUser(nome, telefone);
		user.cadastrarEletronico(nomeItem, preco, plataforma);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		Usuario user = getUser(nome, telefone);
		user.cadastrarJogoTabuleiro(nomeItem, preco);
	}

	public void addPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		Usuario user = getUser(nome, telefone);
		user.addPecaPerdida(nomeItem, nomePeca);
	}

	public void cadastrarBlurayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		Usuario user = getUser(nome, telefone);
		user.cadastrarBlurayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		Usuario user = getUser(nome, telefone);
		user.cadastrarBluRaySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
	}

	public void cadastrarBlurayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) {
		Usuario user = getUser(nome, telefone);
		user.cadastrarBlurayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
	}

	public void addBluray(String nome, String telefone, String nomeBluray, int duracao) {
		Usuario user = getUser(nome, telefone);
		user.addBlueray(nomeBluray, duracao);
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		Usuario user = getUser(nome, telefone);
		user.removerItem(nomeItem);
	}

	public void attItem(String nome, String telefone, String nomeItem, double valor, String atributo) {
		Usuario user = getUser(nome, telefone);
		user.attItem(nomeItem, valor, atributo);

	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		Usuario user = getUser(nome, telefone);
		return user.getInfoItem(nomeItem, atributo);
	}

	public String listarOrdenadosNome() {
		List<Item> itens = new ArrayList<>();

		for (Usuario user : this.usuarios) {
			itens.addAll(user.getItens());
		}
		return this.listador.listaItensOrdenadosPorNome(itens);
	}

	public String listarOrdenadosValor() {
		List<Item> itens = new ArrayList<>();

		for (Usuario user : this.usuarios) {
			itens.addAll(user.getItens());
		}
		return this.listador.listaItensOrdenadosPorValor(itens);
	}

	public String getDetalhesItem(String nome, String telefone, String nomeItem) {
		Usuario user = getUser(nome, telefone);
		return user.getDetalhesItem(nomeItem);
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {
		Usuario userEmprestador = getUser(nomeDono, telefoneDono);
		Usuario userRequerente = getUser(nomeRequerente, telefoneRequerente);
		Emprestimo emprestimo = new Emprestimo(nomeDono, nomeRequerente, nomeItem, dataEmprestimo, periodo);
		userEmprestador.empresta(emprestimo);
		userRequerente.pegaEmprestado(emprestimo);

	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		Usuario user = getUser(nomeRequerente, telefoneRequerente);
		user.devolveItem(nomeDono, telefoneDono, nomeItem, dataEmprestimo, dataDevolucao);

	}

}
