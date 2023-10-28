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
				return Double.parseDouble(String.format("%.2f", valorFinal));
			case SIM:
				valorFinal = getPrecoBase() + ((30.0/100.0)*getPrecoBase());
				return Double.parseDouble(String.format("%.2f", valorFinal));
			case STR:
				valorFinal = getPrecoBase() + ((70.0/100.0)*getPrecoBase());
				return Double.parseDouble(String.format("%.2f", valorFinal));
		}
		return Double.parseDouble(String.format("%.2f", valorFinal));
	}

	public void jogoEletToString(){
		System.out.println(getNome()+","+getAno()+","+getPrecoBase()+","+getPlataforma()+","+getCategoria().getNome()+","+calculaPrecoFinal());
	}
}
