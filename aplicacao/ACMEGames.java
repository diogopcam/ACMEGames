package aplicacao;
import java.util.ArrayList;

import dados.Categoria;
import dados.Jogo;
import dados.JogoEletronico;
import dados.JogoTabuleiro;
import dados.Ludoteca;

public class ACMEGames {

	private Ludoteca ludoteca;
	private EntradaSaida entradaSaida;


	public ACMEGames() {
		ludoteca = new Ludoteca();
		entradaSaida = new EntradaSaida();
		//executa();
	}

	public void executa() {
		ludoteca.jogosIniciaisLudoteca();
		
		//Primeiro passo: Cadastrar um jogo eletrônico 
		if(entradaSaida.getEntrada() != null){
			while(entradaSaida.getEntrada().hasNextLine()){
				String linha = entradaSaida.getEntrada().nextLine();
				if(linha.equals("-1")){
					System.out.println("Saiu do loop porque digitei -1!"); 
					break;
				}
				String[] camposSeparados = linha.split(";");
				String nome = camposSeparados[0];
				int ano = Integer.parseInt(camposSeparados[1]);
				double preco = Double.parseDouble(camposSeparados[2]);
				String plataforma = camposSeparados[3];
				String categoria = camposSeparados[4];

				
				JogoEletronico jogoAnalisado = new JogoEletronico(nome, ano, preco, plataforma, ludoteca.defineCategoria(categoria));
				ludoteca.addJogo(jogoAnalisado);
			}

		//Segundo passo: Cadastrar um jogo de tabuleiro
			while(entradaSaida.getEntrada().hasNextLine()){
				String linha = entradaSaida.getEntrada().nextLine();
				if(linha.equals("-1")){
					System.out.println("Saiu do loop porque digitei -1!"); 
					break;
				}
				String[] camposSeparados = linha.split(";");
				String nome = camposSeparados[0];
				int ano = Integer.parseInt(camposSeparados[1]);
				double preco = Double.parseDouble(camposSeparados[2]);
				int numeroPecas = Integer.parseInt(camposSeparados[3]);

				JogoTabuleiro jogoAnalisado = new JogoTabuleiro(nome, ano, preco, numeroPecas);
				ludoteca.addJogo(jogoAnalisado);
		}

        //Terceiro passo: Verificar se existe um jogo pelo nome
		String linhaNome = entradaSaida.getEntrada().nextLine();
		consultaPorNome(linhaNome);
	

		// Quarto passo: Verificar se existem jogos de determinado ano
		String linhaAno = entradaSaida.getEntrada().nextLine();
		int anoDesejado = Integer.parseInt(linhaAno);
		jogosDoAnoToString(anoDesejado);

		//Quinto passo: Mostrar os dados de jogos de determinada categoria
	    //aconselhavel alterar esse método, para que n seja necessario invocar um método para prencher o array sempre que um objeto for instanciado
		String linhaCategoria = entradaSaida.getEntrada().nextLine();
		consultaJogosCat(linhaCategoria);

		//Sexto passo: Mostrar o somatório de preço de todos os jogos
		mostraSomatorio();
	}
		//Sétimo passo: mostrar os dados do jogo de tabuleiro com maior preço final
		maiorPrecoFinal();

		//Oitavo passo: apresentar valor mais proximo da media dos precos bases
		double valor = ludoteca.valorTotalPrecosBases();
		System.out.println(ludoteca.defineMedia(valor));
		ludoteca.jogoProximoMedia().jogoToString();
		apresentaMedia();

		//Nono passo: • Mostrar os dados do jogo de tabuleiro mais antigo: mostra os dados do jogo d
		//ludoteca.jogoTabuleiroAntigo().jogoTabToString();
		apresentaJogoTabMaisAntigo();
	}

	// public void apresentaErro(Jogo jogo){
	// 	if(jogo instanceof JogoEletronico){
	// 		String nome = jogo.getNome();
	// 		System.out.println("1:Erro-jogo com nome repetido:"+ nome);
	// 	}
	// 	if(jogo instanceof JogoTabuleiro){
	// 		String nome = jogo.getNome();
	// 		System.out.println("2:Erro-jogo com nome repetido:"+ nome);
	// 	}
	// }

	// public void apresentaSucesso(Jogo jogo){
	// 	if(jogo instanceof JogoEletronico){
	// 		String nome = jogo.getNome();
	// 		double preco = jogo.calculaPrecoFinal();
	// 		System.out.println("1:"+nome+ ","+preco);
	// 	}
	// 	if(jogo instanceof JogoTabuleiro){
	// 		String nome = jogo.getNome();
	// 		double preco = jogo.calculaPrecoFinal();
	// 		System.out.println("2:"+nome+ ","+preco);
	// 	}
	// }
	
	public void consultaPorNome(String nome){
		ludoteca.reset();
		boolean analise = false;
		
		while(ludoteca.hasNext() == true){
			Jogo jogo = (Jogo) ludoteca.next();
			
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
		ludoteca.reset();
		while(ludoteca.hasNext() == true){
			Jogo jogo = (Jogo) ludoteca.next();
			valorTotal += jogo.calculaPrecoFinal();
		}
		ludoteca.setPrecoFinal(valorTotal);
		return valorTotal;
	}

	public ArrayList<Jogo> consultaPorAno(int ano) {
		ArrayList<Jogo> jogosDoAno = new ArrayList<>();
		ludoteca.reset();
		while(ludoteca.hasNext()==true){
			Jogo jogo = (Jogo) ludoteca.next();
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
		ludoteca.reset();
			while(ludoteca.hasNext() == true){
				Jogo jogo = (Jogo) ludoteca.next();
				if(jogo instanceof JogoEletronico){
					JogoEletronico jogoE = (JogoEletronico) jogo;
					listaJogosEletronicos.add(jogoE);
				}
			}
			return listaJogosEletronicos;
	}

	public ArrayList<JogoTabuleiro> preencheJogosTabuleiro(){
		ArrayList<JogoTabuleiro> listaJogosTabuleiro = new ArrayList<>();
			ludoteca.reset();
			while(ludoteca.hasNext() == true){
				Jogo jogo = (Jogo) ludoteca.next();
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

	public void mostraSomatorio(){
		double somatorio = 0;
		if(ludoteca.getListaJogos().size()<1){
			System.out.println("6:Nenhum jogo encontrado.");
		} else{
			for (Jogo jogo : ludoteca.getListaJogos()) {
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
            System.out.println("7:" + jogoMaisCaro.getNome() + ",R$ " + jogoMaisCaro.calculaPrecoFinal());
        } else {
            System.out.println("7:Nenhum jogo encontrado.");
        }
    }

	public void apresentaMedia(){
		double media = ludoteca.defineMedia(ludoteca.valorTotalPrecosBases());
		Jogo jogoGuia = ludoteca.jogoProximoMedia();
		if(jogoGuia==null) System.out.println("8: Nenhum jogo encontrado");
		if(jogoGuia instanceof JogoEletronico){
			JogoEletronico jogoE = (JogoEletronico) jogoGuia;
			System.out.println("8:"+media+","+jogoE.getNome()+","+jogoE.getAno()+","+jogoE.getPrecoBase()+","+jogoE.getPlataforma()+","+jogoE.getCategoria().getNome()+","+jogoE.calculaPrecoFinal());
		}
		if(jogoGuia instanceof JogoTabuleiro){
			JogoTabuleiro jogoT = (JogoTabuleiro) jogoGuia;
			System.out.println("8:"+media+","+jogoT.getNome()+","+jogoT.getAno()+","+jogoT.getPrecoBase()+","+jogoT.getNumeroPecas());
	}
}

public void apresentaJogoTabMaisAntigo(){
	JogoTabuleiro jogoAntigo = ludoteca.jogoTabuleiroAntigo();
	if(jogoAntigo == null) System.out.println("9:Nenhum jogo encontrado.");
	System.out.println("9:"+jogoAntigo.getNome()+","+jogoAntigo.getAno());
}
}

