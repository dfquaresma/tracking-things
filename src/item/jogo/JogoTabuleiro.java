package item.jogo;

import item.Item;

public class JogoTabuleiro extends Item {

	public JogoTabuleiro(String nome, double valor) {
		super(nome, valor);
	}

	@Override
	public boolean podeSerEmprestado() {
		// TODO Auto-generated method stub
		return true;
	}

}
