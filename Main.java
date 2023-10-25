import java.util.ArrayList;
import aplicacao.ACMEGames;
import dados.Categoria;
import dados.JogoEletronico;
import dados.JogoTabuleiro;
import dados.Ludoteca;
public class Main {
	public static void main(String[] args) {
		Ludoteca ludoteca = new Ludoteca();

		JogoEletronico jogoum = new JogoEletronico("God of War", 2000,900, "Playstation", Categoria.STR);
		JogoTabuleiro jogodois = new JogoTabuleiro("Tetris", 2000, 1345, 90);
		JogoEletronico jogotres = new JogoEletronico("The Last of Us", 2000,900, "Playstation", Categoria.STR);
		JogoTabuleiro jogoquat = new JogoTabuleiro("Domino", 2000, 1345, 90);
		//System.out.println(jogoum.getCategoria().getNome());
		// System.out.println(jogoum.getPrecoBase());
		// System.out.println(jogoum.calculaPrecoFinal());

		// ludoteca.addJogo(jogoum);
		// ludoteca.addJogo(jogodois);
		// ludoteca.addJogo(jogotres);
		// ludoteca.addJogo(jogoquat);
		//ludoteca.apresentaErro(jogoum);
		// ludoteca.apresentaErro(jogoum);
		// ludoteca.apresentaErro(jogodois);
		// ludoteca.apresentaSucesso(jogoum);
		// ludoteca.apresentaSucesso(jogodois);
		// //System.out.println(ludoteca.getTamanho());
		// System.out.println(ludoteca.addJogo(jogotres));
		// System.out.println(ludoteca.getTamanho());

		System.out.println(ludoteca.consultaPorAno(2010));
		//ludoteca.jogosDoAnoToString(2010);


		// Object objeto = ludoteca.next();
		// JogoEletronico objparajogo = (JogoEletronico) objeto;



		//ludoteca.verificaJogo(jogoum);
		// System.out.println(ludoteca.verificaJogo(jogodois));
		//ludoteca.verificaJogo(jogotres);
		//System.out.println(ludoteca.addJogo(jogotres));
		//ludoteca.reset();


        //	System.out.println(ludoteca.hasNext());
		// ludoteca.addJogo(jogotres);
		//ludoteca.verificaJogo(jogoum);
		// ludoteca.verificaJogo(jogotres);

	}
}
