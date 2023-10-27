package dados;
import java.util.ArrayList;
import java.util.Iterator;

public class Ludoteca implements Iterador {
	private int contador;
	private int tamanho;
	private ArrayList<Jogo> listaJogos;
	private ArrayList<JogoEletronico> listaJogosEletronicos;
	private ArrayList<JogoTabuleiro> listaJogosTabuleiro;
	private double precoFinalLudoteca;
	
	public Ludoteca(){
		tamanho = 0;
		contador = 0;
		listaJogos = new ArrayList();
		listaJogosEletronicos = new ArrayList();
		listaJogosTabuleiro = new ArrayList();
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
	
	public void preencheJogosEletronicos(){
			reset();
			while(hasNext() == true){
				Jogo jogo = (Jogo) next();
				if(jogo instanceof JogoEletronico){
					JogoEletronico jogoE = (JogoEletronico) jogo;
					listaJogosEletronicos.add(jogoE);
				}
			}
	}

	public void preencheJogosTabuleiro(){
			reset();
			while(hasNext() == true){
				Jogo jogo = (Jogo) next();
				if(jogo instanceof JogoTabuleiro){
					JogoTabuleiro jogoT = (JogoTabuleiro) jogo;
					listaJogosTabuleiro.add(jogoT);
				}
			}
	}

	public void consultaJogosCat(String c){
	ArrayList<JogoEletronico> jogosDaCategoria = new ArrayList<>();
		String nomeAct = Categoria.ACT.getNome();
		String nomeStr = Categoria.STR.getNome();
		String nomeSim = Categoria.SIM.getNome();

		if((!c.equals(nomeAct) && !c.equals(nomeStr)) && !c.equals(nomeSim)){
			System.out.println("5:Categoria inexistente");
			return;		
	    } else{
			apresentaJogosCategoria(c);
		}

	}
	
	public void apresentaJogosCategoria(String c){
		boolean categoriaVer = false;
		for(JogoEletronico jogo: listaJogosEletronicos){
			if(jogo.getCategoria().getNome().equals(c)){
				System.out.println("5:"+jogo.getNome()+","+jogo.getAno()+","+jogo.getPrecoBase()+","+jogo.getPlataforma()+","+jogo.getCategoria()+","+jogo.calculaPrecoFinal());
				categoriaVer = true;
			} 
		}

		if(!categoriaVer){
			System.out.println("5:Não existe jogo com essa categoria");
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

	public void mostraSomatorio(){
		// boolean verificacao;
		double somatorio = 0;
		if(listaJogos.size()<1){
			System.out.println("6:Nenhum jogo encontrado.");
			// verificacao = false;
		} else{
			for (Jogo jogo : listaJogos) {
				double valorJogo = jogo.calculaPrecoFinal();
				somatorio += valorJogo;
			}
			System.out.println("6:" + somatorio);
		}
	}

	public void maiorPrecoFinal(){
		JogoTabuleiro jogoMaisCaro = null;
        double maior = 0;
        
        for (JogoTabuleiro jogoT : listaJogosTabuleiro) {
            double precoFinal = jogoT.calculaPrecoFinal();
            if (precoFinal > maior) {
                maior = precoFinal; 
                jogoMaisCaro = jogoT; 
            }
        } 
		//return jogoMaisCaro;

        if (jogoMaisCaro != null) {
            System.out.println("7:" + jogoMaisCaro.getNome() + "," + jogoMaisCaro.calculaPrecoFinal());
        } else {
            System.out.println("7:Nenhum jogo encontrado.");
        }
    }
}

// Mostrar os dados do jogo de tabuleiro com maior preço final: localiza o jogo
// de tabuleiro cadastrado com maior preço final. Se não existir nenhum jogo de
// tabuleiro cadastrado, mostra a mensagem de erro: 7:Nenhum jogo
// encontrado.
// Se existir, mostra os dados do jogo no formato: 7:nome,preço final

// Mostrar o somatório de preço final de todos os jogos: calcula o somatório do
// preço final de todos os jogos do sistema. Se não existir jogo cadastrado no sistema,
// mostra a mensagem de erro: 6:Nenhum jogo encontrado.





