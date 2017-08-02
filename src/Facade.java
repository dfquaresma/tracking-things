
import sistema.Sistema;

public class Facade {

	private Sistema sistema;
	
	public Facade(){
		this.sistema = new Sistema();
	}
	
	public void cadastrarUsuario(String nome,String telefone,String email){
		this.sistema.cadastrarUsuario(nome,telefone,email);
	}
	
	public String getInfoUsuario(String nome,String telefone,String atributo){
		return this.sistema.getInfoUser(nome,telefone,atributo);	
	}
	
	public void atualizarUsuario(String nome,String telefone,String atributo,String valor){
		this.sistema.attUsuario(nome,telefone,atributo,valor);
	}
	
	public void removerUsuario(String nome, String telefone) {
		this.sistema.removeUsuario(nome, telefone);		
	}
	
	public void cadastrarEletronico(String nome,String telefone,String nomeItem,double preco,String plataforma){
		this.sistema.cadastrarEletronico(nome,telefone,nomeItem,preco,plataforma);
	}
	
	public void cadastrarJogoTabuleiro(String nome,String telefone,String nomeItem,double preco){
		this.sistema.cadastrarJogoTabuleiro(nome,telefone,nomeItem,preco);
	}
	
	public void adicionarPecaPerdida(String nome,String telefone,String nomeItem,String nomePeca){
		this.sistema.addPecaPerdida(nome,telefone,nomeItem,nomePeca);
	}
	
	public void cadastrarBluRayFilme(String nome,String telefone,String nomeItem,double preco,int duracao,String genero,String classificacao,int anoLancamento){
		this.sistema.cadastrarBlurayFilme(nome,telefone,nomeItem,preco,duracao,genero,classificacao,anoLancamento);
	} 
	
	public void cadastrarBluRaySerie(String nome,String telefone,String nomeItem,double preco,String descricao,int duracao,String classificacao,String genero,String temporada){
		this.sistema.cadastrarBluRaySerie(nome,telefone,nomeItem,preco,descricao,duracao,classificacao,genero,temporada);
	}
	
	public void cadastrarBluRayShow(String nome,String telefone,String nomeItem,double preco,int duracao,int numeroFaixas,String artista,String classificacao){
		this.sistema.cadastrarBlurayShow(nome,telefone,nomeItem,preco,duracao,numeroFaixas,artista,classificacao);
	}
	
	public void adicionarBluRay(String nome,String telefone,String nomeBluray,int duracao){
		this.sistema.addBluray(nome,telefone,nomeBluray,duracao);
	}
	
	public void removerItem(String nome,String telefone,String nomeItem){
		this.sistema.removerItem(nome,telefone,nomeItem);
	}
	
	public void atualizarItem(String nome,String telefone,String nomeItem,double valor,String atributo){
		this.sistema.attItem(nome,telefone,nomeItem,valor,atributo);
	}
	
	public String getInfoItem(String nome,String telefone,String nomeItem,String atributo){
		return this.sistema.getInfoItem(nome,telefone,nomeItem,atributo);
	}
	
	public String listarItensOrdenadosPorNome(){
		return this.sistema.listarOrdenadosNome();
	}
	
	public String listarOrdenadosPorValor(){
		return this.sistema.listarOrdenadosValor();
	}
	
	public String pesquisarDetalhesItem(String nome,String telefone,String nomeItem){
		return this.sistema.getDetalhesItem(nome,telefone,nomeItem);
	}
	
	public void registrarEmprestimo(String nomeDono,String telefoneDono,String nomeRequerente,String telefoneRequerente,String nomeItem,String dataEmprestimo,int periodo){
		this.sistema.registrarEmprestimo(nomeDono,telefoneDono,nomeRequerente,telefoneRequerente,nomeItem,dataEmprestimo,periodo);
	}
	
	public void devolverItem(String nomeDono,String telefoneDono,String nomeRequerente,String telefoneRequerente,String nomeItem,String dataEmprestimo,String dataDevolucao){
		this.sistema.devolverItem(nomeDono,telefoneDono,nomeRequerente,telefoneRequerente,nomeItem,dataEmprestimo,dataDevolucao);
	}
	
}
