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
		JogoTabuleiro jogodois = new JogoTabuleiro("Banco Imobiliario", 2000, 1345, 90);
		JogoEletronico jogotres = new JogoEletronico("God of War", 2000,900, "Playstation", Categoria.STR);
		//System.out.println(jogoum.getCategoria().getNome());
		// System.out.println(jogoum.getPrecoBase());
		// System.out.println(jogoum.calculaPrecoFinal());

		System.out.println(ludoteca.addJogo(jogoum));
		ludoteca.apresentaErro(jogoum);
		// System.out.println(ludoteca.getTamanho());
		// //System.out.println(ludoteca.getTamanho());
		// System.out.println(ludoteca.addJogo(jogotres));
		// System.out.println(ludoteca.getTamanho());


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
