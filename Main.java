import aplicacao.ACMEGames;
import dados.Categoria;
import dados.JogoEletronico;

public class Main {

	public static void main(String[] args) {
		JogoEletronico jogoum = new JogoEletronico("God of War", 2000,250, "Playstation", Categoria.ACT);

		System.out.println(jogoum.getCategoria().getNome());
	}
}
