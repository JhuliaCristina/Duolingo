package entidades;

public class Amigo {

	private Usuario amigo;
	private Usuario usuario;
	
	
	public Usuario getAmigo() {
		return amigo;
	}
	public void setAmigo(Usuario amigo) {
		this.amigo = amigo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "Amigo [amigo=" + amigo + ", usuario=" + usuario + "]";
	}

	
	
}
