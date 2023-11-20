package entidades;

import java.util.List;

public class Usuario {
	
	private String nome;
	private String email;
	private String apelido;
	private String senha;
	private int vidas;
	private byte foto;
	private boolean premium;
	private List<Curso> cursos;
	private List<Amigo> amigos;
 	
	
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
	public Usuario(String nome, String email, String apelido, String senha, byte foto) {
		super();
		this.nome = nome;
		this.email = email;
		this.apelido = apelido;
		this.senha = senha;
		this.foto = foto;
	}
	
	public String verCursos(String apelido){
			
			String saida = null;
			for(int i = 0; i <= cursos.size() ; i++) {
				System.out.println(i);
				saida = saida + "\n"+ cursos.get(i).getLingua().toString();
			}
			
			return saida;

	}
	
	public String buscarAmigos(String apelido){
		
		String saida = null;
		for(int i = 0; i <= amigos.size() ; i++) {
			System.out.println(i);
			saida = saida + "\n"+ amigos.get(i).getAmigo().getNome().toString();
		}
		
		return saida;
	}
	
	
	
	
	


}
