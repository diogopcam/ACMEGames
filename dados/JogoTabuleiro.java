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
		double valorFinal = getPrecoBase() + (((1.0/100.0)*getPrecoBase()) * numeroPecas);
		return Double.parseDouble(String.format("%.2f", valorFinal));
	}

	public void jogoTabToString(){
		System.out.println(getNome()+","+getAno()+","+getPrecoBase()+","+getNumeroPecas()+","+calculaPrecoFinal());
	}
}
