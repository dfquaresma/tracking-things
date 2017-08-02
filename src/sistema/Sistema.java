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
		// TODO Auto-generated method stub
		
	}

	public String getInfoUser(String nome, String telefone, String atributo) {
		return "";
		
	}

	public void attUsuario(String nome, String telefone, String atributo, String valor) {
		// TODO Auto-generated method stub
		
	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco,String plataforma) {
		// TODO Auto-generated method stub
		
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		// TODO Auto-generated method stub
		
	}

	public void addPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		// TODO Auto-generated method stub
		
	}

	public void cadastrarBlurayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		// TODO Auto-generated method stub
		
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, String temporada) {
		// TODO Auto-generated method stub
		
	}

	public void cadastrarBlurayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) {
		// TODO Auto-generated method stub
		
	}

	public void addBluray(String nome, String telefone, String nomeBluray, int duracao) {
		// TODO Auto-generated method stub
		
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		// TODO Auto-generated method stub
		
	}

	public void attItem(String nome, String telefone, String nomeItem, double valor, String atributo) {
		// TODO Auto-generated method stub
		
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		return "";
		
	}

	public String listarOrdenadosNome() {
		// TODO Auto-generated method stub
		return null;
	}

	public String listarOrdenadosValor() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDetalhesItem(String nome, String telefone, String nomeItem) {
		// TODO Auto-generated method stub
		return null;
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {
		// TODO Auto-generated method stub
		
	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		// TODO Auto-generated method stub
		
	}
	
	

}
