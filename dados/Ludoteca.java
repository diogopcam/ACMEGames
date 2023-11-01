package dados;
import java.util.ArrayList;

public class Ludoteca implements Iterador {
	private int contador;
	private ArrayList<Jogo> listaJogos;
	private double precoFinalLudoteca;
	private double totalPrecosBases;
	
	public Ludoteca(){
		contador = 0;
		listaJogos = new ArrayList<Jogo>();
		precoFinalLudoteca = 0;
		totalPrecosBases = 0;
	}

	public boolean addJogo(Jogo jogo){
		if(verificaJogo(jogo) == false){
			return false;
		}
		return listaJogos.add(jogo);
	}

	public boolean verificaJogo(Jogo jogochave){
		if(listaJogos.size()<1) return true;
		reset();
		while(hasNext() == true){
			Jogo jogo = (Jogo) next();
			if(jogo.getNome().equalsIgnoreCase(jogochave.getNome())){
				return false;
			}
		}
		return true;
	}

	public Jogo consultaPorNome(String nome){
		reset();
		while(hasNext() == true){
			Jogo jogo = (Jogo) next();
			if(jogo.getNome().equalsIgnoreCase(nome)){
				return jogo;
			}
		}
		return null;
	}

	public Categoria defineCategoria(String c){
		if(c.equalsIgnoreCase("Acao")){
			return Categoria.ACT;
		}
		if(c.equalsIgnoreCase("Simulacao")){
			return Categoria.SIM;
		}
		if(c.equalsIgnoreCase("Estrategia")){
			return Categoria.STR;
		}
		return null;
	}

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

	public void setPrecoFinal(double preco){
		precoFinalLudoteca = preco;
	}

	public ArrayList<Jogo> getListaJogos(){
		ArrayList<Jogo> cloneLista = (ArrayList<Jogo>) listaJogos.clone();
		return cloneLista;
	}

	public double valorTotalPrecosBases(){
		if(listaJogos.size()<1) return 0;
		double valorTotalPrecos = 0;
		reset();
		while(hasNext() == true){
			Jogo jogo = (Jogo) next();
			valorTotalPrecos += jogo.getPrecoBase();
		}
		totalPrecosBases = valorTotalPrecos;
		return Double.parseDouble(String.format("%.2f", totalPrecosBases));
	}

	public double defineMedia(){
		double media = valorTotalPrecosBases()/listaJogos.size();
		return Double.parseDouble(String.format("%.2f", media));
	}

	public Jogo jogoProximoMedia(double media) {		
			if(listaJogos.size() < 1) return null;
			
			reset();
			Jogo jogoMaisProximo = null;
			double diferenca = 99999999;
			double apoio = 0;
			while(hasNext() == true){
				Jogo jogo = (Jogo) next();
				if(media > jogo.getPrecoBase()){
					apoio = media - jogo.getPrecoBase();
				}
				
				if(media < jogo.getPrecoBase()){
					apoio = jogo.getPrecoBase() - media;
				}
				
				if(apoio < diferenca){
					diferenca = apoio;
					jogoMaisProximo = jogo;
				}
				}
				return jogoMaisProximo;
		}

		public JogoTabuleiro jogoTabuleiroAntigo(){
			if(listaJogos.size() < 1) return null;
			reset();
			int anoAntigo = 9999;
			JogoTabuleiro jogoMaisAntigo = null;
			while(hasNext() == true){
				Jogo jogoApoio = (Jogo) next();
				if(jogoApoio instanceof JogoTabuleiro){
					JogoTabuleiro jogoT = (JogoTabuleiro) jogoApoio;
					int anoTab = jogoApoio.getAno();
					if(anoTab < anoAntigo){
						anoAntigo = anoTab;
						jogoMaisAntigo = jogoT;
					}
				}
			}
			return jogoMaisAntigo;
	}

	public ArrayList<Jogo> consultaPorAno(int ano) {
		ArrayList<Jogo> jogosDoAno = new ArrayList<>();
		reset();
		while(hasNext()==true){
			Jogo jogo = (Jogo) next();
			if(jogo.getAno() == ano){
				jogosDoAno.add(jogo);
			}
		}
		if(jogosDoAno.size() < 1) return null;
		return jogosDoAno;
	}
}








