package entidades;

public class Licao {
	
	private String titulo;
	private String conteudo;
	private boolean completo;
	private int unidade;
	@Override
	public String toString() {
		return "Licao [titulo=" + titulo + ", conteudo=" + conteudo + ", completo=" + completo + ", unidade=" + unidade
				+ "]";
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public int getUnidade() {
		return unidade;
	}
	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}
	
	
}
