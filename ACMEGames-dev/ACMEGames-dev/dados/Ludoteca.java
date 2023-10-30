package dados;
import java.util.ArrayList;
import java.util.Iterator;
import aplicacao.ACMEGames;

import java.text.DecimalFormat; 

public class Ludoteca implements Iterador {
	private int contador;
	private int tamanho;
	private ArrayList<Jogo> listaJogos;
	private double precoFinalLudoteca;
	private double totalPrecosBases;
	private double media;
	
	public Ludoteca(){
		contador = 0;
		tamanho = 0;
		listaJogos = new ArrayList();
		precoFinalLudoteca = 0;
		totalPrecosBases = 0;
		media = 0;
	}

	public boolean addJogo(Jogo jogo){
		//ACMEGames n = new ACMEGames();
		if(verificaJogo(jogo) == false){
		    //apresentaErro(jogo);
			return false;
		}
		//apresentaSucesso(jogo);
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
	
	// public void consultaPorNome(String nome){
	// 	reset();
	// 	boolean analise = false;
		
	// 	while(hasNext() == true){
	// 		Jogo jogo = (Jogo) next();
			
	// 		if(jogo.getNome().equalsIgnoreCase(nome)){
	// 			analise = true;
	// 			if(jogo instanceof JogoEletronico){
	// 				JogoEletronico jogoE = (JogoEletronico) jogo; 
	// 				System.out.println("3:"+jogoE.getNome()+","+jogoE.getAno()+","+jogoE.getPrecoBase()+","+jogoE.getPlataforma()+","+jogoE.getCategoria().getNome()+","+jogoE.calculaPrecoFinal());
	// 			} else if(jogo instanceof JogoTabuleiro){
	// 				JogoTabuleiro jogoT = (JogoTabuleiro) jogo;
	// 				System.out.println("3:"+jogoT.getNome()+","+jogoT.getAno()+","+jogoT.getPrecoBase()+","+jogoT.getNumeroPecas()+","+jogoT.calculaPrecoFinal());
	// 			}
	// 		}
	// 	}
	// 	if (!analise){
	// 		System.out.println("3:Nome inexistente.");
	// 	}
	// }

	// public double somatorio(){
	// 	double valorTotal = 0;
	// 	reset();
	// 	while(hasNext() == true){
	// 		Jogo jogo = (Jogo) next();
	// 		valorTotal += jogo.calculaPrecoFinal();
	// 	}
	// 	precoFinalLudoteca = valorTotal;
	// 	return valorTotal;
	// }

	// public ArrayList<Jogo> consultaPorAno(int ano) {
	// 	ArrayList<Jogo> jogosDoAno = new ArrayList<>();
	// 	reset();
	// 	while(hasNext()==true){
	// 		Jogo jogo = (Jogo) next();
	// 		if(jogo.getAno() == ano){
	// 			jogosDoAno.add(jogo);
	// 		}
	// 	}
	// 	if(jogosDoAno.size() < 1) return null;
	// 	return jogosDoAno;
	// }

    // public void jogosDoAnoToString(int ano){
	// 	if(consultaPorAno(ano) == null){
	// 		System.out.println("4:Nenhum jogo encontrado.");
	// 	} else{
	// 		for(Jogo jogo: consultaPorAno(ano)){
	// 			if(jogo instanceof JogoEletronico){
	// 				JogoEletronico jogoE = (JogoEletronico) jogo; 
	// 				System.out.println("4:"+jogoE.getNome()+","+jogoE.getAno()+","+jogoE.getPrecoBase()+","+jogoE.getPlataforma()+","+jogoE.getCategoria().getNome()+","+jogoE.calculaPrecoFinal());
	// 			} else if(jogo instanceof JogoTabuleiro){
	// 				JogoTabuleiro jogoT = (JogoTabuleiro) jogo;
	// 				System.out.println("4:"+jogoT.getNome()+","+jogoT.getAno()+","+jogoT.getPrecoBase()+","+jogoT.getNumeroPecas()+","+jogoT.calculaPrecoFinal());
	// 			}
	// 		}
	// 	}
	// }
	
	// public ArrayList<JogoEletronico> preencheJogosEletronicos(){
	// 	ArrayList<JogoEletronico> listaJogosEletronicos = new ArrayList<>();
	// 	reset();
	// 		while(hasNext() == true){
	// 			Jogo jogo = (Jogo) next();
	// 			if(jogo instanceof JogoEletronico){
	// 				JogoEletronico jogoE = (JogoEletronico) jogo;
	// 				listaJogosEletronicos.add(jogoE);
	// 			}
	// 		}
	// 		return listaJogosEletronicos;
	// }

	// public ArrayList<JogoTabuleiro> preencheJogosTabuleiro(){
	// 	ArrayList<JogoTabuleiro> listaJogosTabuleiro = new ArrayList<>();
	// 		reset();
	// 		while(hasNext() == true){
	// 			Jogo jogo = (Jogo) next();
	// 			if(jogo instanceof JogoTabuleiro){
	// 				JogoTabuleiro jogoT = (JogoTabuleiro) jogo;
	// 				listaJogosTabuleiro.add(jogoT);
	// 			}
	// 		}
	// 		return listaJogosTabuleiro;
	// }

	// public void consultaJogosCat(String c){
	// 	String nomeAct = Categoria.ACT.getNome();
	// 	String nomeStr = Categoria.STR.getNome();
	// 	String nomeSim = Categoria.SIM.getNome();

	// 	if((!c.equalsIgnoreCase(nomeAct) && !c.equalsIgnoreCase(nomeStr)) && !c.equalsIgnoreCase(nomeSim)){
	// 		System.out.println("5:Categoria inexistente");
	// 		return;		
	//     } else{
	// 		apresentaJogosCategoria(c);
	// 	}
	// }
	
	// public void apresentaJogosCategoria(String c){
	// 	boolean categoriaVer = false;
	// 	for(JogoEletronico jogo: preencheJogosEletronicos()){
	// 		if(jogo.getCategoria().getNome().equalsIgnoreCase(c)){
	// 			System.out.println("5:"+jogo.getNome()+","+jogo.getAno()+","+jogo.getPrecoBase()+","+jogo.getPlataforma()+","+jogo.getCategoria()+","+jogo.calculaPrecoFinal());
	// 			categoriaVer = true;
	// 		} 
	// 	}
	// 	if(!categoriaVer){
	// 		System.out.println("5:Não existe jogo com essa categoria");
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

	public void setPrecoFinal(double preco){
		precoFinalLudoteca = preco;
	}

	public int getTamanho() {
		return listaJogos.size();
	}

	// public void mostraSomatorio(){
	// 	double somatorio = 0;
	// 	if(listaJogos.size()<1){
	// 		System.out.println("6:Nenhum jogo encontrado.");
	// 	} else{
	// 		for (Jogo jogo : listaJogos) {
	// 			double valorJogo = jogo.calculaPrecoFinal();
	// 			somatorio += valorJogo;
	// 		}
	// 		System.out.printf("6: R$ %.2f %n", somatorio);
	// 	}
	// }

	// public void maiorPrecoFinal(){
	// 	JogoTabuleiro jogoMaisCaro = null;
    //     double maior = 0;
	// 	preencheJogosTabuleiro();
        
    //     for (JogoTabuleiro jogoT : preencheJogosTabuleiro()) {
    //         double precoFinal = jogoT.calculaPrecoFinal();
    //         if (precoFinal > maior) {
    //             maior = precoFinal; 
    //             jogoMaisCaro = jogoT; 
    //         }
    //     } 

    //     if (jogoMaisCaro != null) {
    //         System.out.println("7:" + jogoMaisCaro.getNome() + ",R$ " + jogoMaisCaro.calculaPrecoFinal());
    //     } else {
    //         System.out.println("7:Nenhum jogo encontrado.");
    //     }
    // }

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
		double media = valorTotalPrecosBases()/getTamanho();
		this.media = media;
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








