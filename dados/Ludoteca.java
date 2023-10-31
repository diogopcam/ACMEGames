package dados;
import java.util.ArrayList;
import java.util.Iterator;
import aplicacao.ACMEGames;

import java.text.DecimalFormat; 

public class Ludoteca implements Iterador {
	private int contador;
	private ArrayList<Jogo> listaJogos;
	private double precoFinalLudoteca;
	private double totalPrecosBases;
	private double media;
	
	public Ludoteca(){
		contador = 0;
		listaJogos = new ArrayList<Jogo>();
		precoFinalLudoteca = 0;
		totalPrecosBases = 0;
	}

	public void jogosIniciaisLudoteca(){
		JogoEletronico jogoum = new JogoEletronico("Resident Evil", 2004, 6000, "Playstation", Categoria.ACT);
		JogoEletronico jogodois = new JogoEletronico("God of War Ragnarok", 2000,5999, "Playstation", Categoria.ACT);
		JogoEletronico jogotres = new JogoEletronico("The Last of Us", 1200,6002, "Playstation", Categoria.STR);
		JogoTabuleiro jogoquatro = new JogoTabuleiro("Damas", 1555, 6009, 20); 
		JogoTabuleiro jogocinco = new JogoTabuleiro("Domino", 2001, 7000, 90);
		JogoTabuleiro jogoseis = new JogoTabuleiro("Quebra cabeça", 1120,  8000, 80);
		listaJogos.add(jogoum);
		listaJogos.add(jogodois);
		listaJogos.add(jogotres);
		listaJogos.add(jogoquatro);
		listaJogos.add(jogocinco);
		listaJogos.add(jogoseis);
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

	public double defineMedia(double totalPrecosBases){
		double media = valorTotalPrecosBases()/listaJogos.size();
		return media;
	}

	public Jogo jogoProximoMedia(){
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
}








