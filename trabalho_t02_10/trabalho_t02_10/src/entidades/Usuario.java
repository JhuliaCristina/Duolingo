package entidades;

import java.util.List;

public class Usuario {
	
	private String nome;
	private String email;
	private String apelido;
	private String senha;
	private int vidas = 5;
	private byte foto;
	private boolean premium;
	private Curso[] cursos = new Curso[10];
	private Usuario[] amigos = new Usuario[100];
	private int numCursos = 0; 
	private int numAmigos = 0;
 	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public byte getFoto() {
		return foto;
	}
	public void setFoto(byte foto) {
		this.foto = foto;
	}
	
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + ", apelido=" + apelido + ", senha=" + senha + ", vidas="
				+ vidas + ", foto=" + foto + ", premium=" + premium + "]";
	}
	public Usuario(String nome, String email, String apelido, String senha) {
		this.nome = nome;
		this.email = email;
		this.apelido = apelido;
		this.senha = senha;
	}
	
	public String verCursos() {
		String saida = "***** Lista de Cursos cadastrados ***** \n" ;
		for(int i = 0; i < numCursos; i++) {
			System.out.println(i);
			saida = saida + "\n"+ cursos[i].getLingua().toString();
		}
		return saida;
	}	
	
	public String buscarAmigos(String apelido){
		
		String saida = null;
		for(int i = 0; i <= numAmigos ; i++) {
			System.out.println(i);
			saida = saida + "\n"+ amigos[i].getNome().toString();
		}
		
		return saida;
	}
	
	public void adicionarAmigo(Usuario usuario) {
		if(numAmigos <= 100) {
			amigos[numAmigos] = usuario;
		}
		
	}
	
	
	
	
	


}
