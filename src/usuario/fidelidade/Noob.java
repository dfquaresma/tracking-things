package usuario.fidelidade;

public class Noob implements CartaoFidelidade {

	private final int PERIODO = 7;
	
	@Override
	public int getPeriodo() {
		return PERIODO;
	}

	@Override
	public boolean podePegarEmprestado() {
		return true;
	}
	
	@Override
	public String toString(){
		return "Noob";
	}


}
