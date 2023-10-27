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
		if(entradaSaida.entrada != null){
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

		//Segundo passo: Cadastrar um jogo de tabuleiro
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

        //Terceiro passo: Verificar se existe um jogo pelo nome
		String linhaNome = entradaSaida.entrada.nextLine();
		ludoteca.consultaPorNome(linhaNome);
	

		// Quarto passo: Verificar se existem jogos de determinado ano
		String linhaAno = entradaSaida.entrada.nextLine();
		int anoDesejado = Integer.parseInt(linhaAno);
		ludoteca.jogosDoAnoToString(anoDesejado);

		//Quinto passo: Mostrar os dados de jogos de determinada categoria
	    //aconselhavel alterar esse método, para que n seja necessario invocar um método para prencher o array sempre que um objeto for instanciado
		String linhaCategoria = entradaSaida.entrada.nextLine();
		ludoteca.consultaJogosCat(linhaCategoria);

		//Sexto passo: Mostrar o somatório de preço de todos os jogos
		ludoteca.mostraSomatorio();
	}
		//Sétimo passo: mostrar os dados do jogo de tabuleiro com maior preço final
		ludoteca.maiorPrecoFinal();
	}
}

