package usuario.fidelidade;

public class FreeRider implements CartaoFidelidade {
	
	private final int PERIODO = 5;
	
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
		return "FreeRider";
	}


}
