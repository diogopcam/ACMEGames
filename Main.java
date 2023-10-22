import aplicacao.ACMEGames;
import dados.Categoria;
import dados.JogoEletronico;
import dados.JogoTabuleiro;

public class Main {

	public static void main(String[] args) {
		JogoEletronico jogoum = new JogoEletronico("God of War", 2000,900, "Playstation", Categoria.STR);
		JogoTabuleiro jogodois = new JogoTabuleiro("Banco Imobiliario", 2000, 1345, 90);
		//System.out.println(jogoum.getCategoria().getNome());
		System.out.println(jogoum.getPrecoBase());
		System.out.println(jogoum.calculaPrecoFinal());
	}
}
