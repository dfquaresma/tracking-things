package excecoes;

public class ExcecaoOperacaoNaoPermitidaNoMomento extends RuntimeException {

	private static final long serialVersionUID = 5861420653202594172L;
	
	public ExcecaoOperacaoNaoPermitidaNoMomento(String msg) {
		super(msg);
	}
	

}
