package dados;

public class JogoEletronico extends Jogo{
	private String plataforma;
	private Categoria categoria;

	public JogoEletronico(String nome, int ano, double precoBase, String plataforma, Categoria categoria){
		super(nome, ano, precoBase);
		this.plataforma = plataforma;
		this.categoria = categoria;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public double calculaPrecoFinal(){
		double valorFinal = 0;
		switch(this.categoria){
			case ACT:
				valorFinal = getPrecoBase() + ((10.0/100.0)*getPrecoBase());
				return valorFinal;
			case SIM:
				valorFinal = getPrecoBase() + ((30.0/100.0)*getPrecoBase());
				return valorFinal;
			case STR:
				valorFinal = getPrecoBase() + ((70.0/100.0)*getPrecoBase());
				return valorFinal;
		}
		return valorFinal;
	}

	public void jogoEletToString(){
		jogoToString();
		System.out.println("Plataforma: "+getPlataforma());
		System.out.println("Categoria: "+getCategoria().getNome());
	}
}
