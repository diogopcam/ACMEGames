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
// 	. Mostrar os dados de um determinado jogo: lê o nome de um jogo. Se não existir
// um jogo com o nome indicado, mostra a mensagem de erro: 3:Nome
// inexistente.
// Se existir, mostra os dados do jogo no formato:
// 3:atributo1,atributo2,atributo3,...,preço final

	public abstract double calculaPrecoFinal();

}
