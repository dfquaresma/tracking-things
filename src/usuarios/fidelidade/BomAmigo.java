package usuarios.fidelidade;

public class BomAmigo implements CartaoFidelidade {

	private final int PERIODO = 14;
	
	@Override
	public int getPeriodo() {
		return this.PERIODO;
	}

	@Override
	public boolean podePegarEmprestado() {
		return true;
	}
	
	@Override
	public String toString(){
		return "BomAmigo";
	}

}
