package entidades;


import java.util.*;

public class Curso {
	
	private String lingua;
	private int unidades;
	private Unidade[] unidadesCurso = new Unidade[50];
	private int numUnidades = 10;
	 
	@Override
	public String toString() {
		return "Curso lingua=" + lingua + ", Unidades=" + unidades + "]";
	}
	
	public Curso(String lingua) {
		this.lingua = lingua;
	}
	
	public String verUnidades(String lingua){
		
		String saida = "";
		System.out.print(this.lingua + "\n");
		for(int i = 1; i <= numUnidades ; i++) {
			saida = saida + "\n"+ unidadesCurso[i].getTitulo().toString() + "\n";
		}
		
		return saida;
	}

	public String getLingua() {
		return lingua;
	}

	public void setLingua(String lingua) {
		this.lingua = lingua;
	}
	
	public void setUnidade(int i, Unidade unidade) {
		this.unidadesCurso[i] = unidade;
	}
	
	
}
