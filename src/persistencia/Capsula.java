package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import excecoes.OperacaoNaoPermitidaNoMomentoExcecao;

/**
 * Representação de uma capsula que guarda objetos.
 * 
 * @author Amanda V. A. de Luna e Costa
 * @author David Ferreira Quaresma
 * @author Ícaro Dantas de Araújo Lima
 * @author Paulo Felipe Feitosa da Silva
 *
 */
public class Capsula implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Object> objetos;

	/**
	 * Constrói uma capsula vazia pronta para uso.
	 */
	public Capsula() {
		this.objetos = new ArrayList<>();
	}

	/**
	 * Adiciona um objeto à capsula.
	 * 
	 * @param obj
	 *            o objeto a ser adicionado.
	 */
	public void addObjeto(Object obj) {
		if (obj == null) {
		throw new NullPointerException("Objeto nao pode ser nulo.");
		}
		
		this.objetos.add(obj);

	}

	/**
	 * Recupera um objeto na capsula. Todo objeto recuperado é imediatamente
	 * removido da capsula. A ordem em que é recuperado os objetos é a ordem em
	 * que foram adicionados. Como em uma fila, o primeiro que entra é o
	 * primeiro que sai.
	 * 
	 * @return o objeto a ser recuperado.
	 */
	public Object getObjeto() {

		if (this.objetos.size() > 0) {
			Object objeto = this.objetos.get(0);
			this.objetos.remove(0);

			return objeto;
		}
		throw new OperacaoNaoPermitidaNoMomentoExcecao("Nao ha mais objetos a serem desencapsulados.");

	}

	/**
	 * Recupera a quantidade de objetos guardados na capsula.
	 * 
	 * @return um inteiro representando a quantidade.
	 */
	public int qtdObjetosContidos() {
		return this.objetos.size();

	}

}
