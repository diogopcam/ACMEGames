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
		ludoteca.consultaPorNome("Minecraft");
	}
}

