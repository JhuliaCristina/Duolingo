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
					break;
				case 2:
					verCursosCadastrados(usuarioLogado);
					break;
				case 3: 
					fazerCurso(usuarioLogado);
					break;
				case 4:
					tornarPremium(usuarioLogado);
					break;
				case 5:
					editarPerfil(usuarioLogado);
					break;
				case 6:
					adicionarAmigos(usuarioLogado); 
					break;
				case 7:
					verAmigos(usuarioLogado);
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
		String saida = new String("\nEscolha uma das opcoes a seguir:\n");
		saida = saida + "00 - Sair do duolingo\n";
		saida = saida + "01 - Começar nova Língua\n";
		saida = saida + "02 - Ver cursos cadastrados\n";
		saida = saida + "03 - Fazer curso\n";
		saida = saida + "04 - Tornar premium\n";
		saida = saida + "05 - Editar perfil\n";
		saida = saida + "06 - Adicionar amigo\n";
		saida = saida + "07 - Ver Amigos\n";
		
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
		System.out.print("Usuário não encontrado. Voltando ao menu principal... \n\n\n");
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
		return true;
	}
	
	
	public static Usuario lerDadosUsuario() {
		String nome;
		String apelido;
		String email;
		String senha;
		Usuario usuario;
		
		
		input.nextLine();
		System.out.print("Digite um nome:");
		nome = input.nextLine();
		System.out.print("Digite um apelido:");
		apelido = input.nextLine();
		System.out.print("Digite um email:");
		email = input.nextLine();
		System.out.print("Digite uma senha:");
		senha = input.nextLine();
		
		usuario = new Usuario(nome, email, apelido, senha);
		return usuario;
	}
	
	public static void escolherLingua(Usuario usuario) {
		
		
		System.out.print("Escolha uma das Línguas a seguir: \n");
		for(int i = 0; i < dados.getNumCursos(); i++) {
			System.out.print( "\n"+ dados.getCursos()[i].getLingua() + "\n");
			
		}
		
		System.out.print("\nDigite a Língua desejada: \n");
		String lingua;
		input.nextLine();
		lingua = input.nextLine();
		
		
		for(int i = 0; i < dados.getNumCursos(); i++) {
			if(dados.getCursos()[i].getLingua().equalsIgnoreCase(lingua)) {
				System.out.print("\nCurso cadastrado com sucesso\n");
				usuario.adicionarCurso(dados.getCursos()[i]);
				System.out.print("Voltando ao menu... \n\n\n");
			}
			
		}
		
	}
	
	public static void verCursosCadastrados(Usuario usuario) {
		
		for(int i = 0; i < usuario.getNumCursos(); i++) {
			System.out.print(usuario.getCursos()[i].getLingua());
		}
		
		System.out.print("\nDigite qualquer coisa para voltar ao menu: \n\n");
		String sair;
		input.nextLine();
		sair = input.nextLine();
	
	}
	
	public static void fazerCurso(Usuario usuario) {
		
		System.out.print("Busque pelo curso que você deseja fazer: \n\n");
		String buscar;
		input.nextLine();
		buscar = input.nextLine();
		Curso cursoASerFeito = null;
		
		for(int i = 0; i < usuario.getNumCursos(); i++) {
			if(buscar.equals(usuario.getCursos()[i].getLingua())) {
				cursoASerFeito = usuario.getCursos()[i];
			}
		}
		
		
		if(cursoASerFeito == null) System.out.print("Curso não cadastrado");
		else System.out.print(cursoASerFeito.verUnidades(buscar));
	}
	
	public static void tornarPremium(Usuario usuario) {
		String querPremium;
		System.out.print("Deseja se tornar premium?(Sim/Não): \n\n");
		
		input.nextLine();
		querPremium = input.nextLine();
		
		if(querPremium.equalsIgnoreCase("Sim")) usuario.setPremium(true);
		System.out.print("Digite algo para continuar: \n");
		String continuar;
		continuar = input.nextLine();
	}
	
	public static void editarPerfil(Usuario usuario) {
		Usuario novasInformacoes = lerDadosUsuario();
		
		usuario.setNome(novasInformacoes.getNome());
		usuario.setApelido(novasInformacoes.getApelido());
		usuario.setEmail(novasInformacoes.getEmail());
		usuario.setSenha(novasInformacoes.getSenha());
	}
	
	public static void adicionarAmigos(Usuario usuario) {
		System.out.print("Digite o email do amigo que você deseja adicionar: \n");
		String email;
		
		input.nextLine();
		email = input.nextLine();
		
		for(int i = 0; i < dados.getNumUsuarios(); i++) {
			if(email.equals(dados.getUsuarios()[i].getEmail())) {
				usuario.adicionarAmigo(dados.getUsuarios()[i]);
				System.out.print("Amigo adicionado com sucesso!\n");
			}
		}
		
		
	}
	
	public static void verAmigos(Usuario usuario) {
		System.out.print("Seus amigos : \n");
		for(int i = 0; i < usuario.getNumAmigos(); i++) {
			System.out.print("\n Amigo: " + usuario.getAmigos()[i].getNome() + " Email: " + usuario.getAmigos()[i].getEmail()
					+ "\n");
		}
	}
}
