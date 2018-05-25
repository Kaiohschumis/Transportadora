package entra21.pkg.classe;

import javax.swing.JOptionPane;

import entra21.pkg.menu.MenuPrincipal;

public class Funcionario {
	static int tamanho = 100, ultimo = 0;
	static boolean continua = false;
	
	static int[] vetorCodigo = new int[tamanho];
	static String[] vetorNome = new String[tamanho];
	static String[] vetorCpf = new String[tamanho];
	static double[] vetorSalario = new double[tamanho];
	static int[] vetorIdade = new int[tamanho];
	static char[] vetorSexo = new char[tamanho];
	static String[] vetorFuncao = new String[tamanho];
	
	public void cadastro() {
		validaCampos(ultimo);
		ultimo++;
	}
	
	public void validaCampos(int posicao) {
		while (!continua) {
			vetorCodigo[posicao] = posicao;
			
			validaNome(posicao);
			
			validaIdade(posicao);
			
			validaCPF(posicao);
			
			validaSalario(posicao);
			
			validaSexo(posicao);
			
			vetorFuncao[posicao] = JOptionPane.showInputDialog(null, "Função");
			
			JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!");
			
			continua = true;
		}
	}
	
	public void consulta() {
		MenuPrincipal menu = new MenuPrincipal();
		
		char busca = JOptionPane.showInputDialog(null, 
			"*** CONSULTA FUNCIONARIO ***\n\n" +
			"[P] Pesquisa por nome\n" +
			"[T] Exibir Todos\n" +
			"[R] Retorna ao Menu Principal").toLowerCase().charAt(0);
		
		switch (busca) {
			case 'p':
				consultaNome();
				break;
			case 't':
				consultaTodos();
				break;
			case 'r':
				menu.abreMenu();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Invalida");
				break;
			}
	}
	
	public static String validaNome(int posicao) {
		String nome = "";
		
		while (!continua) {
			try {
				nome =removeSpeciais(
					JOptionPane.showInputDialog(null, "Nome Completo:"));
				break;
			} catch (Exception ex) {}
		}
		vetorNome[posicao] = nome;
		
		return vetorNome[posicao];
	}
	
	public static int validaIdade(int posicao) {
		int idade = 0;
		
		while (!continua) {
			try {
				idade = Integer.parseInt(
					JOptionPane.showInputDialog(null, "Idade:"));
				
				continua = true;
				break;
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Ups, não eh numero");
			}
		}
		vetorIdade[posicao] = idade;
		
		return vetorIdade[posicao];
	}
	
	public static String validaCPF(int posicao) {
		boolean validaCPF = false;
		String cpf = "";
		
		while (continua) {
			try {
				while (!validaCPF) {
					cpf = JOptionPane.showInputDialog(null, 
						"CPF:").replace(".", "").replace("-", "").trim();
					
					if (cpf.isEmpty() || cpf.length() != 11) {
						JOptionPane.showMessageDialog(null, "CPF tem de ter 11 digitos");
					} else {
						validaCPF = true;
					}
				}
				break;
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "CPF incorreto");
			}
		}
		vetorCpf[posicao] = cpf;
		return vetorCpf[posicao];
	}
	
	public static double validaSalario(int posicao) {
		double salario = 0;
		
		while (continua) {
			try {
				salario = Double.parseDouble(
					JOptionPane.showInputDialog(null, "Salário (R$):"));
				break;
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Salario incorreto");
			}
		}
		vetorSalario[posicao] = salario;
		
		return vetorSalario[posicao];
	}
	
	public static char validaSexo(int posicao) {
		boolean validaSexo = false;
		
		while (continua) {
			while (!validaSexo) {
				try {
					char sexo = 0;
					
					sexo = JOptionPane.showInputDialog(
						null, "Informe o Sexo:\n[M] Masculino\n[F] Feminino").charAt(0);
					
					if (sexo == 'M' || sexo == 'm') {
						vetorSexo[posicao] = sexo;
						validaSexo = true;
					} else if (sexo == 'F' || sexo == 'f') {
						vetorSexo[posicao] = sexo;
						validaSexo = true;
					} else {
						JOptionPane.showMessageDialog(null, "Sexo nao corresponde");
					}
					break;
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Sexo invalido");
				}
			}
			continua = false;
		}
		return vetorSexo[posicao];
	}
	
	public static void consultaNome() {
		boolean procura = false;
		
		while (!procura) {
			String nome = JOptionPane.showInputDialog(
				"Entre um nome de Funcionario:");
			
			for (int i = 0; i < vetorCodigo.length; i++) {
				if (nome == vetorNome[i]) {
					JOptionPane.showMessageDialog(null, nome + "\n");
					System.out.println("1");
				} else {
					JOptionPane.showMessageDialog(null, 
						"Funcionario \"" + nome + "\" nao encontrado");
					
					System.out.println("2");
				}
			}
			System.out.println("3");
			//procura = true;
		}
	}
	
	public static String removeSpeciais(String texto) {
		texto = texto.replaceAll("[a-zA-Z\\w]", "").trim();
		
		return texto;
	}
	
	public void consultaTodos() {
		for (int i = 0; i < vetorNome.length; i++) {
			if (vetorNome[i] != null) {
				JOptionPane.showMessageDialog(null,
					vetorNome[i] + "\n");
			} else {
				JOptionPane.showMessageDialog(null, "Nenhum Funcionario registrado");
			}
		}
	}
}
