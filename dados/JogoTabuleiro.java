package dados;

public class JogoTabuleiro extends Jogo {
	private int numeroPecas;

	public JogoTabuleiro(String nome, int ano, double precoBase, int numeroPecas) {
		super(nome, ano, precoBase);
		this.numeroPecas = numeroPecas;
	}

	public void setNumeroPecas(int numeroPecas) {
		this.numeroPecas = numeroPecas;
	}

	public int getNumeroPecas() {
		return numeroPecas;
	}

	public double calculaPrecoFinal(){
		double valorFinal = getPrecoBase() + ((1.0/100.0)*getPrecoBase());
		return valorFinal;
	}
}
