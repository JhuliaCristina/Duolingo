package dados;

import entidades. *;

public class Dados {
	
	private Usuario[] usuarios;
	private int numUsuarios = 0;
	private Curso[] cursos ;
	private int numCursos = 0;
	private String[] linguas = new String[] {"Inglês", "Português", "Francês", "Italiano", "Alemão", "Japonês", "Mandarim", "Russo", "Espanhol", "Coreano"}; 
	
	public Dados() {
		usuarios = new Usuario[100];
		cursos = new Curso[10];
	}
	
	
	
	public Usuario[] getUsuarios() {
		return usuarios;
	}
	
	public Usuario getUsuario(int i) {
		return usuarios[i];
	}


	public String[] getNomeUsuarios() {
		String[] s = new String[numUsuarios];
		for(int i = 0; i < numUsuarios; i++) {
			s[i] = usuarios[i].getApelido();
		}
		return s;
	}
	
	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}
	
	public void setUsuario(int i, Usuario usuario) {
		usuarios[i] = usuario;
	}

	public int getNumUsuarios() {
		return numUsuarios;
	}

	public void setNumUsuarios(int numUsuarios) {
		this.numUsuarios = numUsuarios;
	}

	public Curso[] getCursos(){
		return cursos;
	}
	
	public Curso getCurso(int i) {
		return cursos[i];
	}

	public String[] getNomeCursos() {
		String[] s = new String[numCursos];
		for(int i = 0; i < numCursos; i++) {
			s[i] = cursos[i].getLingua();
		}
		return s;
	}


	public void setCursos(Curso[] cursos) {
		this.cursos = cursos;
	}
	
	public void setCurso(int i, Curso curso) {
		cursos[i] = curso;
	}

	public int getNumCursos() {
		return numCursos;
	}



	public void setNumCursos(int numCursos) {
		this.numCursos = numCursos;
	}

	public void preencherDados() {
		for(int i = 0; i < 10; i++){
			String s = String.valueOf(i);
			usuarios[i] = new Usuario("Nome".concat(s), "Email".concat(s), "Apelido".concat(s), 
					"Senha".concat(s));
			cursos[i] = new Curso(linguas[i].concat(s));
						
		}
		numUsuarios = numCursos  = 10;
	}
	
	
}
