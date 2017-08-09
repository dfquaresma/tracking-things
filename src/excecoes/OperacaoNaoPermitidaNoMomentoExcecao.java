package excecoes;

public class OperacaoNaoPermitidaNoMomentoExcecao extends RuntimeException {

	private static final long serialVersionUID = 5861420653202594172L;
	
	public OperacaoNaoPermitidaNoMomentoExcecao(String msg) {
		super(msg);
	}
	

}
