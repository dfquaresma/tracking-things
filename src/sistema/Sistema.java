package sistema;

import java.util.HashMap;
import java.util.Map;

import usuario.Usuario;

public class Sistema {
	private Map<String, Usuario> usuarios;
	
	public Sistema() {
		this.usuarios = new HashMap<>();
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		Usuario user = new Usuario(nome, telefone, email);
		String id = nome + telefone; // a se pensar...
		this.usuarios.put(id, user);
		
	}

	public String getInfoUser(String nome, String telefone, String atributo) {
		return "";
		
	}

	public void attUsuario(String nome, String telefone, String atributo, String valor) {
		
	}

	public void removeUsuario(String nome, String telefone) {
		
	}
	
	
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco,String plataforma) {
		
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		
	}

	public void addPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		
	}

	public void cadastrarBlurayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, String temporada) {
		
	}

	public void cadastrarBlurayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) {
		
	}

	public void addBluray(String nome, String telefone, String nomeBluray, int duracao) {
		
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		
	}

	public void attItem(String nome, String telefone, String nomeItem, double valor, String atributo) {
		
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		return "";
	}

	
	public String listarOrdenadosNome() {
		return null;
	}

	public String listarOrdenadosValor() {
		return null;
	}

	public String getDetalhesItem(String nome, String telefone, String nomeItem) {
		return null;
	}

	
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {
		
	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
  }
   
    


}
