package aplicacao;
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
		executa();
	}

	public void executa() {
		ludoteca.jogosIniciaisLudoteca();
		//Primeiro passo: Cadastrar um jogo eletrônico 
		// JogoEletronico jogoEletExemplo = new JogoEletronico("Devil May Cry", 2004, 150, "Playstation", Categoria.ACT);
		// System.out.println(jogoEletExemplo.calculaPrecoFinal());
		// ludoteca.addJogo(jogoEletExemplo);
		
		if(entradaSaida.entrada != null){
			//System.out.println("menos mal;");
			while(entradaSaida.entrada.hasNextLine()){
				String linha = entradaSaida.entrada.nextLine();
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

			while(entradaSaida.entrada.hasNextLine()){
				String linha = entradaSaida.entrada.nextLine();
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

		while(entradaSaida.entrada.hasNextLine()){
				String linha = entradaSaida.entrada.nextLine();
				if(linha.equals("-1")){
					System.out.println("Saiu do loop porque digitei -1!"); 
					break;
				}
				//String[] camposSeparados = linha.split(";");
				//String nome = camposSeparados[0];
				//int ano = Integer.parseInt(camposSeparados[1]);
				//double preco = Double.parseDouble(camposSeparados[2]);
				//int numeroPecas = Integer.parseInt(camposSeparados[3]);
				ludoteca.consultaPorNome(linha);
		}



		// // 	//Segundo passo: Cadastrar um jogo de tabuleiro
		// // //JogoTabuleiro jogoTabExemplo = new JogoTabuleiro("Monopoly", 2000, 150, 60);
		// // //ludoteca.addJogo(jogoTabExemplo);

		// // //Terceiro passo: Verificar se existe um jogo pelo nome
		// // ludoteca.consultaPorNome("the last of us");
		// // ludoteca.consultaPorNome("god of war");

		// // //Quarto passo: Verificar se existem jogos de determinado ano
		// // ludoteca.jogosDoAnoToString(2002);

		// // //Quinto passo: Mostrar os dados de jogos de determinada categoria
		// // //(optei por construir o metodo utilizando o tipo String, utilizando o atributo nome do enum Categoria)
		// // //aconselhavel alterar esse método, para que n seja necessario invocar um método para prencher o array sempre que um objeto for instanciado
		// // ludoteca.consultaJogosCat("acao");

		// // //Sexto passo: Mostrar o somatório de preço de todos os jogos
		// // ludoteca.mostraSomatorio();

		// // //Sétimo passo: mostrar os dados do jogo de tabuleiro com maior preço final
		// // //ludoteca.preencheJogosTabuleiro();
		// // ludoteca.maiorPrecoFinal();
	}
}
}
