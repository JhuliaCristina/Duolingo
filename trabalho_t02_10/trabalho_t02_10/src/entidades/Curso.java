package entidades;


import java.util.*;

public class Curso {
	
	private String lingua;
	private int Unidades;
	private List<Unidade> unidades;
	 
	@Override
	public String toString() {
		return "Curso [lingua=" + lingua + ", Unidades=" + Unidades + "]";
	}
	
	public String verUnidades(String lingua){
		
		String saida = null;
		for(int i = 0; i <= unidades.size() ; i++) {
			System.out.println(i);
			saida = saida + "\n"+ unidades.get(i).getTitulo().toString();
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
