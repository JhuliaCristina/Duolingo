package main;
import java.util.*;
import estruturasDeDados.*;
import dados.*;
import entidades.Curso;
import entidades.Usuario;

public class Main {
	
	private static Scanner input = new Scanner(System.in);
	private static Dados dados = new Dados();
	private static Usuario usuarioLogado;
	
	
	public static void main(String[] args) {
		
		dados.preencherDados();
		int op = -1;
		boolean logado = false;
	

		
		while(op != 0 && !logado){
			for(int i = 0; i < dados.getNumUsuarios(); i++) {
				System.out.println(dados.getUsuarios()[i].toString());
			}
			
			System.out.print(imprimirMenuIncial());
			op = input.nextInt();
			
			switch(op){
				case 0:
					System.out.println("Obrigada por utilizar o Duolingo. Até a próxima!");
			 		break;
				case 1:
					Pair<String, String> login = loginUsuario();
					usuarioLogado = entrar(login.getKey(), login.getValue());
					if(usuarioLogado != null) {
						logado= true;
					}
					break;
				case 2:
					cadastrarUsuario();
					break;
					
			}
		}
		
		while(op != 0 && logado) {
			System.out.print(imprimirMenu());
			op = input.nextInt();
			
			switch(op) {
				case 0: 
					System.out.println("Obrigada por utilizar o Duolingo. Até a próxima!");
					break;
				case 1:
					escolherLingua(usuarioLogado);
					
			}
		}
		
	
	}
	
	public static String imprimirMenuIncial() {
		String saida = new String("DUOLINGO\n\n");
		saida = saida + "Escolha uma opção a seguir:\n";
		saida = saida + "00 - Sair\n";
		saida = saida + "01 - Entrar \n";
		saida = saida + "02 - Cadastrar \n";
		return saida;
	}
	
	
	public static String imprimirMenu() {
		String saida = new String("Escolha uma das opcoes a seguir:\n");
		saida = saida + "00 - Sair da aplicacao\n";
		saida = saida + "01 - Começar nova Língua\n";
		return saida;
	}
	
	public static Pair<String, String> loginUsuario() {
		 Pair<String, String> login ;
		 String email;
		 String senha;
		 
		 
		 input.nextLine();
		 System.out.println("Digite o seu email:");
		 email = input.nextLine();
		 System.out.println("Digite sua senha:");
		 senha = input.nextLine();
		 
		 login = new Pair<>(email,senha);
		 return login;
	}
	
	
	public static Usuario entrar(String email, String senha) {
		
		for(int i = 0; i < dados.getNumUsuarios(); i++) {
			if(email.equalsIgnoreCase(dados.getUsuarios()[i].getEmail()) && senha.equals(dados.getUsuarios()[i].getSenha())) {
				System.out.println("\nLogin efetuado com sucesso!\n");
				return dados.getUsuarios()[i];
			}
		}
		return null;
	}
	
	
	public static boolean cadastrarUsuario(){
		Usuario usuario = lerDadosUsuario();
		
		for(int i = 0; i < dados.getNumUsuarios(); i++) {
			if(dados.getUsuarios()[i] == usuario) {
				System.out.print("Usuario já cadastrado\n");
				return false;
			}
		}
		dados.setUsuario(dados.getNumUsuarios(), usuario);
		dados.setNumUsuarios(dados.getNumUsuarios() + 1);
		System.out.print("Usuário cadastrado com sucesso\n\n");
		System.out.print(dados.getNumUsuarios() );
		return true;
	}
	
	
	public static Usuario lerDadosUsuario() {
		String nome;
		String apelido;
		String email;
		String senha;
		Usuario usuario;
		
		
		input.nextLine();
		System.out.print("Digite o seu nome:");
		nome = input.nextLine();
		System.out.print("Digite o seu apelido:");
		apelido = input.nextLine();
		System.out.print("Digite o seu email:");
		email = input.nextLine();
		System.out.print("Digite a sua senha:");
		senha = input.nextLine();
		
		usuario = new Usuario(nome, email, apelido, senha);
		return usuario;
	}
	
	public static void escolherLingua(Usuario usuario) {
		
		boolean podeAdicionar = true;
		
		
		System.out.print("Escolha uma das Línguas a seguir: \n");
		for(int i = 0; i < dados.getNumCursos(); i++) {
			System.out.print(i + " "+ dados.getCursos()[i].getLingua() + "\n");
			
		}
		
		System.out.print("Digite a Língua desejada: \n");
		String lingua;
		input.nextLine();
		lingua = input.nextLine();
		
		for(int i = 0; i < usuario.getNumCursos(); i++) {
			if(usuario.getCursos()[i].getLingua() == lingua) podeAdicionar = false ;
			if(!podeAdicionar) System.out.print("Curso já cadastrado.\n"); 
		}
		
		
		for(int i = 0; i < dados.getNumCursos(); i++) {
			if(dados.getCursos()[i].getLingua().equalsIgnoreCase(lingua) && podeAdicionar) {
				System.out.print("\nCurso cadastrado com sucesso\n");
				usuario.adicionarCurso(dados.getCursos()[i]);
				System.out.print("Voltando ao menu... \n\n\n");
			}
			
		}
		
	}
	
}
