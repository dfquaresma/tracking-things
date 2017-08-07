package sistema;

public class Facade {

	private Controller controller;
	
	public Facade(){
		this.controller = new Controller();
	}

	public void iniciarSistema(){
		this.controller.iniciaSistema();
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		this.controller.cadastrarUsuario(nome, telefone, email);
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		return this.controller.getInfoUser(nome, telefone, atributo);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		this.controller.attUsuario(nome, telefone, atributo, valor);
	}

	public void removerUsuario(String nome, String telefone) {
		this.controller.removeUsuario(nome, telefone);
	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		this.controller.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		this.controller.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		this.controller.addPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}

	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		this.controller.cadastrarBlurayFilme(nome, telefone, nomeItem, preco, duracao, genero, classificacao,
				anoLancamento);
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		this.controller.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao, genero,
				temporada);
	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) {
		this.controller.cadastrarBlurayShow(nome, telefone, nomeItem, preco, duracao, numeroFaixas, artista,
				classificacao);
	}

	public void adicionarBluRay(String nome, String telefone, String nomeBluray, int duracao) {
		this.controller.addBluray(nome, telefone, nomeBluray, duracao);
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		this.controller.removerItem(nome, telefone, nomeItem);
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String valor, String atributo) {
		this.controller.attItem(nome, telefone, nomeItem, valor, atributo);
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		return this.controller.getInfoItem(nome, telefone, nomeItem, atributo);
	}

	public String listarItensOrdenadosPorNome() {
		return this.controller.listarOrdenadosNome();
	}

	public String listarItensOrdenadosPorValor() {
		return this.controller.listarOrdenadosValor();
	}

	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		return this.controller.getDetalhesItem(nome, telefone, nomeItem);
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {
		this.controller.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
				dataEmprestimo, periodo);
	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		this.controller.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo,
				dataDevolucao);
	}
	
	public void fecharSistema(){
		this.controller.fechaSistema();
		
	}

}
