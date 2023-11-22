package dados;

import entidades. *;

public class Dados {
	
	private Usuario[] usuarios;
	private int numUsuarios = 0;
	private Curso[] cursos ;
	private int numCursos = 0;
	
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



	public void setNumCursos(int nProfs) {
		this.nProfs = nProfs;
	}

	public Matricula[] getMatriculas() {
		return matriculas;
	}
	
	public Matricula getMatricula(int i) {
		return matriculas[i];
	}

	public void setMatriculas(Matricula[] matriculas) {
		this.matriculas = matriculas;
	}
	
	public void setMatricula(int i, Matricula m) {
		matriculas[i] = m;
	}



	public int getnMatriculas() {
		return nMatriculas;
	}



	public void setnMatriculas(int nMatriculas) {
		this.nMatriculas = nMatriculas;
	}



	public void preencherDados() {
		for(int i = 0; i < 10; i++) {
			String s = String.valueOf(i);
			alunos[i] = new Aluno("Aluno".concat(s), "id".concat(s), "cpf".concat(s), 
					"telefone".concat(s), "dataNascimento".concat(s), "endereco".concat(s));
			professores[i] = new Professor("Professor".concat(s), "id".concat(s), "cpf".concat(s), 
					"telefone".concat(s), i);
			cursos[i] = new Curso("Curso".concat(s), "Conteudo".concat(s), i, professores[i]);
			cursos[i].matricular(new Matricula(alunos[i], "hoje", i, "turma".concat(s) ));			
		}
		nAlunos = nProfs = nCursos = 10;
	}
}
