package usuarios.fidelidade;

public class Caloteiro implements CartaoFidelidade {

	private final int PERIODO = 0;
	
	@Override
	public int getPeriodo() {
		return this.PERIODO;
	}

	@Override
	public boolean podePegarEmprestado() {
		return false;
	}
	
	@Override
	public String toString(){
		return "Caloteiro";
	}


}
