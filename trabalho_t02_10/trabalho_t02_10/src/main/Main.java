package main;
import java.util.*;
import estruturasDeDados.*;
import dados.*;
import entidades.Curso;
import entidades.Usuario;

public class Main {
	
	private static Scanner input = new Scanner(System.in);
	private static Dados dados = new Dados();
	
	
	
	public static void main(String[] args) {
		dados.preencherDados();
		int op = -1;
		boolean logado = false;
		Usuario usuarioLogado;
		

		
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
					if(usuarioLogado != null) 
					break;
				case 2:
					cadastrarUsuario();
					break;
					
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
		saida = saida + "01 - Cadastrar novo aluno\n";
		saida = saida + "02 - Remover aluno existente\n";
		saida = saida + "03 - Editar aluno existente\n";
		saida = saida + "04 - Listar alunos\n";
		saida = saida + "05 - Cadastrar novo professor\n";
		saida = saida + "06 - Remover professor existente\n";
		saida = saida + "07 - Editar professor existente\n";
		saida = saida + "08 - Listar professores\n";
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
			if(email == dados.getUsuarios()[i].getEmail() && senha == dados.getUsuarios()[i].getSenha()) {
				System.out.println("Login efetuado com sucesso!");
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
		System.out.print("Usuário cadastrado com sucesso\n");
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
	
}
