package dados;
import java.util.ArrayList;
import java.util.Iterator;
import java.text.DecimalFormat; 

public class Ludoteca implements Iterador {
	private int contador;
	private int tamanho;
	private ArrayList<Jogo> listaJogos;
	private double precoFinalLudoteca;
	
	public Ludoteca(){
		tamanho = 0;
		contador = 0;
		listaJogos = new ArrayList();
		//listaJogosEletronicos = new ArrayList();
		//listaJogosTabuleiro = new ArrayList();
	}

	public void jogosIniciaisLudoteca(){
		JogoEletronico jogoum = new JogoEletronico("Resident Evil", 2004, 200, "Playstation", Categoria.ACT);
		JogoEletronico jogodois = new JogoEletronico("God of War Ragnarok", 2000,350, "Playstation", Categoria.ACT);
		JogoEletronico jogotres = new JogoEletronico("The Last of Us", 2000,70, "Playstation", Categoria.STR);
		JogoTabuleiro jogoquatro = new JogoTabuleiro("Damas", 2002, 25, 20); 
		JogoTabuleiro jogocinco = new JogoTabuleiro("Domino", 2001, 1234567, 90);
		JogoTabuleiro jogoseis = new JogoTabuleiro("Quebra cabeça", 2000,  50000, 80);
		listaJogos.add(jogoum);
		listaJogos.add(jogodois);
		listaJogos.add(jogotres);
		listaJogos.add(jogoquatro);
		listaJogos.add(jogocinco);
		listaJogos.add(jogoseis);
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
			
			if(jogo.getNome().equalsIgnoreCase(nome)){
				analise = true;
				if(jogo instanceof JogoEletronico){
					JogoEletronico jogoE = (JogoEletronico) jogo; 
					System.out.println("3:"+jogoE.getNome()+","+jogoE.getAno()+","+jogoE.getPrecoBase()+","+jogoE.getPlataforma()+","+jogoE.getCategoria().getNome()+","+jogoE.calculaPrecoFinal());
				} else if(jogo instanceof JogoTabuleiro){
					JogoTabuleiro jogoT = (JogoTabuleiro) jogo;
					System.out.println("3:"+jogoT.getNome()+","+jogoT.getAno()+","+jogoT.getPrecoBase()+","+jogoT.getNumeroPecas()+","+jogoT.calculaPrecoFinal());
				}
			}
		}
		if (!analise){
			System.out.println("3:Nome inexistente.");
		}
	}

	public double somatorio(){
		double valorTotal = 0;
		reset();
		while(hasNext() == true){
			Jogo jogo = (Jogo) next();
			valorTotal += jogo.calculaPrecoFinal();
		}
		precoFinalLudoteca = valorTotal;
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
			System.out.println("4:Nenhum jogo encontrado.");
		} else{
			for(Jogo jogo: consultaPorAno(ano)){
				if(jogo instanceof JogoEletronico){
					JogoEletronico jogoE = (JogoEletronico) jogo; 
					System.out.println("4:"+jogoE.getNome()+","+jogoE.getAno()+","+jogoE.getPrecoBase()+","+jogoE.getPlataforma()+","+jogoE.getCategoria().getNome()+","+jogoE.calculaPrecoFinal());
				} else if(jogo instanceof JogoTabuleiro){
					JogoTabuleiro jogoT = (JogoTabuleiro) jogo;
					System.out.println("4:"+jogoT.getNome()+","+jogoT.getAno()+","+jogoT.getPrecoBase()+","+jogoT.getNumeroPecas()+","+jogoT.calculaPrecoFinal());
				}
			}
		}
	}
	
	public ArrayList<JogoEletronico> preencheJogosEletronicos(){
		ArrayList<JogoEletronico> listaJogosEletronicos = new ArrayList<>();
		reset();
			while(hasNext() == true){
				Jogo jogo = (Jogo) next();
				if(jogo instanceof JogoEletronico){
					JogoEletronico jogoE = (JogoEletronico) jogo;
					listaJogosEletronicos.add(jogoE);
				}
			}
			return listaJogosEletronicos;
	}

	public ArrayList<JogoTabuleiro> preencheJogosTabuleiro(){
		ArrayList<JogoTabuleiro> listaJogosTabuleiro = new ArrayList<>();
			reset();
			while(hasNext() == true){
				Jogo jogo = (Jogo) next();
				if(jogo instanceof JogoTabuleiro){
					JogoTabuleiro jogoT = (JogoTabuleiro) jogo;
					listaJogosTabuleiro.add(jogoT);
				}
			}
			return listaJogosTabuleiro;
	}

	public void consultaJogosCat(String c){
		String nomeAct = Categoria.ACT.getNome();
		String nomeStr = Categoria.STR.getNome();
		String nomeSim = Categoria.SIM.getNome();

		if((!c.equalsIgnoreCase(nomeAct) && !c.equalsIgnoreCase(nomeStr)) && !c.equalsIgnoreCase(nomeSim)){
			System.out.println("5:Categoria inexistente");
			return;		
	    } else{
			apresentaJogosCategoria(c);
		}
	}
	
	public void apresentaJogosCategoria(String c){
		boolean categoriaVer = false;
		for(JogoEletronico jogo: preencheJogosEletronicos()){
			if(jogo.getCategoria().getNome().equalsIgnoreCase(c)){
				System.out.println("5:"+jogo.getNome()+","+jogo.getAno()+","+jogo.getPrecoBase()+","+jogo.getPlataforma()+","+jogo.getCategoria()+","+jogo.calculaPrecoFinal());
				categoriaVer = true;
			} 
		}
		if(!categoriaVer){
			System.out.println("5:Não existe jogo com essa categoria");
		}
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
		double somatorio = 0;
		if(listaJogos.size()<1){
			System.out.println("6:Nenhum jogo encontrado.");
		} else{
			for (Jogo jogo : listaJogos) {
				double valorJogo = jogo.calculaPrecoFinal();
				somatorio += valorJogo;
			}
			System.out.printf("6: R$ %.2f %n", somatorio);
		}
	}

	public void maiorPrecoFinal(){
		JogoTabuleiro jogoMaisCaro = null;
        double maior = 0;
		preencheJogosTabuleiro();
        
        for (JogoTabuleiro jogoT : preencheJogosTabuleiro()) {
            double precoFinal = jogoT.calculaPrecoFinal();
            if (precoFinal > maior) {
                maior = precoFinal; 
                jogoMaisCaro = jogoT; 
            }
        } 

        if (jogoMaisCaro != null) {
            System.out.println("7:" + jogoMaisCaro.getNome() + "," + jogoMaisCaro.calculaPrecoFinal());
        } else {
            System.out.println("7:Nenhum jogo encontrado.");
        }
    }

	public ArrayList<Jogo> getListaJogos(){
		return listaJogos;
	}
}







