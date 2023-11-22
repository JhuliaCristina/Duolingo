package entidades;

public class Unidade {
	
	private String titulo;
	private String licoes;
	private String lingua;
	
	@Override
	public String toString() {
		return "Unidade [titulo=" + titulo + "]";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Unidade(String titulo, String lingua) {
		this.titulo = titulo;
		this.lingua = lingua;
	}
	
	
}
