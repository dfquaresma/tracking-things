package item.jogo;

import java.util.ArrayList;
import java.util.List;

import item.Item;

public class JogoTabuleiro extends Item {

	List<String> pecasPerdidas;

	public JogoTabuleiro(String nome, double valor) {
		super(nome, valor);
		this.pecasPerdidas = new ArrayList<>();
	}

	public void addPecaPerdida(String peca) {
		this.pecasPerdidas.add(peca);
	}

	public String existePecaPerdida() {
		if (this.pecasPerdidas.size() > 0) {
			return "COM PECAS PERDIDAS";
		} else {
			return "COM TODAS AS PECAS";
		}
	}

	public String isEmprestadoString() {
		if (super.isEmprestado()) {
			return "Emprestado";
		} else {
			return "Nao emprestado";
		}
	}

	@Override
	public String toString() {
		return "JOGO DE TABULEIRO: " + super.getNome() + ", R$ " + super.getValor() + ", " + this.isEmprestadoString()
				+ ", " + this.existePecaPerdida();
	}

}
