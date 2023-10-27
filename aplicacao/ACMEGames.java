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
		JogoEletronico jogoEletExemplo = new JogoEletronico("Devil May Cry", 2004, 200, "Playstation", Categoria.ACT);
		ludoteca.addJogo(jogoEletExemplo);
		
		//Segundo passo: Cadastrar um jogo de tabuleiro
		JogoTabuleiro jogoTabExemplo = new JogoTabuleiro("Monopoly", 2000, 150, 60);
		ludoteca.addJogo(jogoTabExemplo);

		//Terceiro passo: Verificar se existe um jogo pelo nome
		ludoteca.consultaPorNome("the last of us");
		ludoteca.consultaPorNome("god of war");

		//Quarto passo: Verificar se existem jogos de determinado ano
		ludoteca.jogosDoAnoToString(2002);

		//Quinto passo: Mostrar os dados de jogos de determinada categoria
		//(optei por construir o metodo utilizando o tipo String, utilizando o atributo nome do enum Categoria)
		ludoteca.preencheJogosEletronicos();
		//aconselhavel alterar esse método, para que n seja necessario invocar um método para prencher o array sempre que um objeto for instanciado
		ludoteca.consultaJogosCat("terror");
	}
}

