package dados;

public abstract class Jogo {

	private String nome;
	private int ano;
	private double precoBase;

	public Jogo(String nome, int ano, double precoBase) {
		this.nome = nome;
		this.ano = ano;
		this.precoBase = precoBase;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getAno() {
		return ano;
	}

	public void setPrecoBase(double precoBase) {
		this.precoBase = precoBase;
	}

	public double getPrecoBase() {
		return precoBase;
	}

	public void jogoToString(){
		System.out.println("Nome: "+getNome());
		System.out.println("Ano: "+getAno());
		System.out.println("Preço base: "+getPrecoBase());
	}

	public abstract double calculaPrecoFinal();

}
