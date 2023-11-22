package entidades;


import java.util.*;

public class Curso {
	
	private String lingua;
	private int unidades;
	private Unidade[] unidadesCurso = new Unidade[50];
	private int numUnidades = 0;
	 
	@Override
	public String toString() {
		return "Curso lingua=" + lingua + ", Unidades=" + Unidades + "]";
	}
	
	public Curso(String lingua) {
		this.lingua = lingua;
	}
	
	public String verUnidades(String lingua){
		
		String saida = null;
		for(int i = 0; i <= numUnidades ; i++) {
			
			System.out.println("Unidade: " + i);
			saida = saida + "\n"+ unidades[i].getTitulo().toString();
		}
		
		return saida;
	}

	public String getLingua() {
		return lingua;
	}

	public void setLingua(String lingua) {
		this.lingua = lingua;
	}
	
	
}
