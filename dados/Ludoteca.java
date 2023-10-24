package dados;
import java.util.ArrayList;
import java.util.Iterator;

public class Ludoteca implements Iterador {
	private int contador;
	int tamanho;
	private ArrayList<Jogo> listaJogos;
	
	public Ludoteca(){
		tamanho = 0;
		contador = 0;
		listaJogos = new ArrayList();
	}

	public boolean addJogo(Jogo jogo){
		if(verificaJogo(jogo) == false){
			//apresentaErro(jogo);
			return false;
		}
		tamanho++;
		return listaJogos.add(jogo);
	}

	// public void apresentaErro(){
	// }

	public void apresentaErro(Jogo jogo){
		String nome = jogo.getNome();
		System.out.println("1:Erro-jogo com nome repetido:"+ nome);
	}

	public Jogo consultaPorNome(String nome) {
		return null;
	}

	public ArrayList<Jogo> consultaPorAno(int ano) {
		return null;
	}

	public boolean verificaJogo(Jogo jogochave){
		if(listaJogos.size()<1) return true;
		else{
			reset();
			while(hasNext() == true){
				JogoEletronico jogo = (JogoEletronico) next();
				if(jogo.getNome().equals(jogochave.getNome())){
					return false;
				} else {
					return true;
				}
			}
		}
		return true;
	}
	// public void buscaJogoPorNome(String nome){
	// 	for(Jogo jogo: listaJogos){
	// 		if(jogo.getNome().equals(nome){

	// 		}
	// 	}
	// }

	public void reset() {
		contador = 0;
	}

	public boolean hasNext() {
		return contador < listaJogos.size();
	}

	public Object next() {
		if (hasNext()){
			Jogo objeto = listaJogos.get(contador);
			contador++;
			return objeto;
		}
		return null;
	}

	public int getTamanho() {
		return tamanho;
	}
}
