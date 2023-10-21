package dados;
import java.util.ArrayList;

public class Ludoteca implements Iterador {

	private int contador;

	private Jogo[] jogo;

	public Ludoteca() {

	}

	public boolean addJogo(Jogo jogo) {
		return false;
	}

	public Jogo consultaPorNome(String nome) {
		return null;
	}

	public ArrayList<Jogo> consultaPorAno(int ano) {
		return null;
	}


	/**
	 * @see dados.Iterador#reset()
	 */
	public void reset() {

	}


	/**
	 * @see dados.Iterador#hasNext()
	 */
	public boolean hasNext() {
		return false;
	}


	/**
	 * @see dados.Iterador#next()
	 */
	public Object next() {
		return null;
	}

}
