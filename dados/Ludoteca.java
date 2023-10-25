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
			apresentaErro(jogo);
			return false;
		}
		apresentaSucesso(jogo);
		tamanho++;
		return listaJogos.add(jogo);
	}

	public void apresentaErro(Jogo jogo){
		if(jogo instanceof JogoEletronico){
			String nome = jogo.getNome();
			System.out.println("1:Erro-jogo com nome repetido:"+ nome);
		}
		if(jogo instanceof JogoTabuleiro){
			String nome = jogo.getNome();
			System.out.println("2:Erro-jogo com nome repetido:"+ nome);
		}
	}

	public void apresentaSucesso(Jogo jogo){
		if(jogo instanceof JogoEletronico){
			String nome = jogo.getNome();
			double preco = jogo.calculaPrecoFinal();
			System.out.println("1:"+nome+ ","+preco);
		}
		if(jogo instanceof JogoTabuleiro){
			String nome = jogo.getNome();
			double preco = jogo.calculaPrecoFinal();
			System.out.println("2:"+nome+ ","+preco);
		}
	}

	public void consultaPorNome(String nome){
		reset();
		boolean analise = false;
		
		while(hasNext() == true){
			Jogo jogo = (Jogo) next();
			
			if(jogo.getNome().equals(nome)){
				analise = true;
				
				if(jogo instanceof JogoEletronico){
					JogoEletronico jogoE = (JogoEletronico) jogo; 
					System.out.println("3:"+jogoE.getNome()+","+jogoE.getAno()+","+jogoE.getPrecoBase()+","+jogoE.getPlataforma()+","+jogoE.getCategoria()+","+jogoE.calculaPrecoFinal());
				} else if(jogo instanceof JogoTabuleiro){
					JogoTabuleiro jogoT = (JogoTabuleiro) jogo;
					System.out.println("3:"+jogoT.getNome()+","+jogoT.getAno()+","+jogoT.getPrecoBase()+","+jogoT.getNumeroPecas()+","+jogoT.calculaPrecoFinal());
				}
			}
		}

		if (!analise){
			System.out.println("3:Nome inexistente");
		}
	}

	public double somatorio(){
		double valorTotal = 0;
		reset();
		while(hasNext() == true){
			Jogo jogo = (Jogo) next();
			valorTotal += jogo.calculaPrecoFinal();
		}
		return valorTotal;
	}

	//
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

    public void jogosDoAnoToString(int ano){
		if(consultaPorAno(ano) == null){
			System.out.println("4:Nenhum jogo encontrado");
		} else{
			for(Jogo jogo: consultaPorAno(ano)){
				if(jogo instanceof JogoEletronico){
					JogoEletronico jogoE = (JogoEletronico) jogo; 
					System.out.println("4:"+jogoE.getNome()+","+jogoE.getAno()+","+jogoE.getPrecoBase()+","+jogoE.getPlataforma()+","+jogoE.getCategoria()+","+jogoE.calculaPrecoFinal());
				} else if(jogo instanceof JogoTabuleiro){
					JogoTabuleiro jogoT = (JogoTabuleiro) jogo;
					System.out.println("4:"+jogoT.getNome()+","+jogoT.getAno()+","+jogoT.getPrecoBase()+","+jogoT.getNumeroPecas()+","+jogoT.calculaPrecoFinal());
				}
			}
		}
	}


	public boolean verificaJogo(Jogo jogochave){
		if(listaJogos.size()<1) return true;
		reset();
		while(hasNext() == true){
			Jogo jogo = (Jogo) next();
			if(jogo.getNome().equals(jogochave.getNome())){
				return false;
			}
		}
		return true;
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

	public int getTamanho() {
		return tamanho;
	}
}

