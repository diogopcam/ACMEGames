package dados;
import java.util.ArrayList;

public class Ludoteca implements Iterador {
	private int contador;
	private ArrayList<Jogo> listaJogos;
	
	public Ludoteca(){
		contador = 0;
		listaJogos = new ArrayList();
	}

	public boolean addJogo(Jogo jogo){
		return listaJogos.add(jogo);
	}

	public Jogo consultaPorNome(String nome) {
		return null;
	}

	public ArrayList<Jogo> consultaPorAno(int ano) {
		return null;
	}

	// 	//Cadastrar jogos eletrônicos: lê todos os dados de cada jogo eletrônico e, se o
	// nome não for repetido no sistema, cadastra-o no sistema. Se o nome do jogo for
	// repetido mostra a mensagem no formato: 1:Erro-jogo com nome repetido:
	// nome do jogo
	// Para cada jogo el

	public boolean verificaJogo(Jogo jogochave){
		if(listaJogos.isEmpty()) return addJogo(jogochave);
		else{
			for(Jogo jogo: listaJogos){
				if(jogo.getNome().equals(jogochave.getNome())){
					System.out.println("Cadastro não pode ser feito!");
					return false;
				}
			}
		}
		return true;
	}

	public void reset() {

	}

	public boolean hasNext() {
	
	}

	public Object next() {
		return null;
	}
}
