package aplicacao;
import dados.Categoria;
import dados.Jogo;
import dados.JogoEletronico;
import dados.JogoTabuleiro;
import dados.Ludoteca;

public class ACMEGames {

	private Ludoteca ludoteca;

	public ACMEGames() {
		//Ludoteca ludoteca = new Ludoteca();
		executa();
	}

	public void executa() {
		Ludoteca ludoteca = new Ludoteca();
		ludoteca.jogosIniciaisLudoteca();
		//este método prenche a ludoteca com alguns jogos iniciais (Eletronicos e de Tabuleiro) para facilitar os testes

		//Primeiro passo: Cadastrar um jogo eletrônico 
		JogoEletronico jogoEletExemplo = new JogoEletronico("Devil May Cry", 2004, 150, "Playstation", Categoria.ACT);
		System.out.println(jogoEletExemplo.calculaPrecoFinal());
		ludoteca.addJogo(jogoEletExemplo);
		
		//Segundo passo: Cadastrar um jogo de tabuleiro
		//JogoTabuleiro jogoTabExemplo = new JogoTabuleiro("Monopoly", 2000, 150, 60);
		//ludoteca.addJogo(jogoTabExemplo);

		//Terceiro passo: Verificar se existe um jogo pelo nome
		ludoteca.consultaPorNome("the last of us");
		ludoteca.consultaPorNome("god of war");

		//Quarto passo: Verificar se existem jogos de determinado ano
		ludoteca.jogosDoAnoToString(2002);

		//Quinto passo: Mostrar os dados de jogos de determinada categoria
		//(optei por construir o metodo utilizando o tipo String, utilizando o atributo nome do enum Categoria)
		//aconselhavel alterar esse método, para que n seja necessario invocar um método para prencher o array sempre que um objeto for instanciado
		ludoteca.consultaJogosCat("acao");

		//Sexto passo: Mostrar o somatório de preço de todos os jogos
		ludoteca.mostraSomatorio();

		//Sétimo passo: mostrar os dados do jogo de tabuleiro com maior preço final
		//ludoteca.preencheJogosTabuleiro();
		ludoteca.maiorPrecoFinal();
	}
}

