package item.jogo;

import java.util.ArrayList;
import java.util.Locale;

import item.Item;

public class JogoTabuleiro extends Item {

	private ArrayList<String> pecasPerdidas;

	public JogoTabuleiro(String nome, double valor) {
		super(nome, valor);

		this.pecasPerdidas = new ArrayList<>();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		JogoTabuleiro other = (JogoTabuleiro) obj;
		if (pecasPerdidas == null) {
			if (other.pecasPerdidas != null) {
				return false;
			}
		} else if (!pecasPerdidas.equals(other.pecasPerdidas)) {
			return false;
		}
		if (this.getNome() == null) {
			if (other.getNome() != null) {
				return false;
			}
		} else if (!this.getNome().equals(other.getNome())) {
			return false;
		}
		return true;
	}

	public void adicionarPecaPerdida(String nomePeca) {
		this.getPecasPerdidas().add(nomePeca);
	}

	private ArrayList<String> getPecasPerdidas() {
		return this.pecasPerdidas;
	}

	public boolean isCompleto() {
		return this.getPecasPerdidas().size() == 0;
	}

	@Override
	public String toString() {
		return "JOGO DE TABULEIRO: " + this.getNome() + ", R$ " + String.format(Locale.US, "%.2f", this.getValor())
				+ ", " + this.getEstadoEmprestimo() + ", "
				+ (this.isCompleto() ? "SEM PECAS PERDIDAS" : "COM PECAS PERDIDAS");
	}

}
