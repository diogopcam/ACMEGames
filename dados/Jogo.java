package dados;

public abstract class Jogo {

	private String nome;

	private int ano;

	private double precoBase;

	public Jogo(String nome, int ano, double precoBase) {

	}

	public abstract double calculaPrecoFinal();

}
