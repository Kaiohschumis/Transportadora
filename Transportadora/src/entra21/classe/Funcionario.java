package entra21.classe;

import javax.swing.JOptionPane;
import entra21.validacao.ValidacaoCampos;

public class Funcionario {
	// Define um tamanho fixo para os Arrays da Classe
	static int tamanho = 100;
	
	// Criacao dos arrays da classe para armazenar as infos
	// Array padrao fixo para inserir valores
	static String[] vetorNome = new String[tamanho];
	// Array padrao fixo para inserir valores
	static int[] vetorIdade = new int[tamanho];
	// Array padrao fixo para inserir valores
	static String[] vetorCPF = new String[tamanho];
	// Array padrao fixo para inserir valores
	static double[] vetorSalario = new double[tamanho];
	// Array padrao fixo para inserir valores
	static char[] vetorSexo = new char[tamanho];
	// Array padrao fixo para inserir valores
	static String[] vetorFuncao = new String[tamanho];
	// Array padrao fixo para inserir valores
	static String[] vetorAdmissao = new String[tamanho];
	
	// Cria uma funcao de cadastro para armazenar valores
	public void cadastraFuncionario() {
		// Inicia instancia de acesso da Classe
		ValidacaoCampos validaCampo = new ValidacaoCampos();
		
		// Acessa a funcao para obter o ultima posicao de array
		int posicao = ultimaPosicao();
		
		// Os vetores somente recebem um valor na posicao caso
		// a funcao de insercao de registro validar
		vetorNome[posicao] = JOptionPane.showInputDialog(null, "Nome Completo:");
		vetorCPF[posicao] = validaCampo.validaCPF();
		vetorIdade[posicao] = validaCampo.validaIdade();
		vetorSexo[posicao] = validaCampo.validaSexo();
		vetorFuncao[posicao] = validaCampo.validaFuncao();
		vetorSalario[posicao] = validaCampo.validaSalario();
		vetorAdmissao[posicao] = validaCampo.validaData();
	}
	
	// Percorre o array para pegar a posicao mais atual 
	private static int ultimaPosicao() {
		// Define uma posicao
		int posicao = 0;
		
		// Percorre array e verifica se contem informacao
		for (int i = 0; i < vetorNome.length; i++) {
			// Caso somente conter info, entao captura e 
			// valida condicao
			if (vetorNome[i] == null) {
				posicao = i;
				break;
			}
		}
		// Retorno do metodo de validacao
		return posicao;
	}
	
	// Acesso de reigstros da Classe
	public void consultaFuncionario() {
		// Atribui inicializacao de objetos da funcao
		boolean encontrado = false;
		String pesquisaNome = "", nomes = "";
		int contador = 0;
		
		// Enquanto condicao ser diferente, prossege execucao
		while (!encontrado) {
			// Usuario entra com um valor com Caixa Baixa
			pesquisaNome = JOptionPane.showInputDialog(null, 
				"Pesquisar Nome de Funcionario:\n[ESC] Sair").toLowerCase();
			
			// Verifica se Usuario digitou algo, senao repete
			if (!pesquisaNome.isEmpty()) {
				// Percorre array por valores
				for (int i = 0; i < vetorNome.length; i++) {
					// Somente traz registros, caso corresponder
					if (vetorNome[i].toLowerCase().contains(pesquisaNome)) {
						// Variavel de incremento para exibir resultados, 
						// contador de registros e validacao de condicao
						nomes += "\n" + vetorNome[i];
						contador = contador + 1;
						encontrado = true;
					}
				}
				// Caso nao validar, mostra mensagem
				if (!encontrado) {
					JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Entre um Nome");
			}
			// Caso tiver 1 ou mais registros exibe mensagem
			if (contador > 0) {
				JOptionPane.showMessageDialog(null, 
					"*** RESULTADO ***\n\n[" + contador + "] NOMES COM \"" 
					+ pesquisaNome + "\" ENCONTRADOS:\n" + nomes);
			}
		}
	}
	
	// Funcao para lista todos os registros do array
	public void listaFuncionario() {
		// Inicializ variaveis da funcao
		String nomes = "";
		boolean vazio = true;
		int contador = 0;
		
		// Percorre vetor por registros
		for (int i = 0; i < vetorNome.length; i++) {
			// Caso vetor trazer algum valor
			if (vetorNome[i] != null) {
				// Para cada posicao com valores, recebe variavel
				// Contador de registros encontrados e condicao validada
				nomes += "\n" + vetorNome[i] + ", " + vetorIdade[i] 
					+ " anos - " + vetorFuncao[i];
				
				contador = contador + 1;
				vazio = false;
			}
		}
		// Caso condicao, monstra mensagem
		if (vazio) {
			JOptionPane.showMessageDialog(null, "Nenhum Funcionario cadastrado");
		} else {
			// Exibe resultados do array
			JOptionPane.showMessageDialog(null,
				"*** LISTA DE FUNCIONARIOS [ " + contador + " ] ***\n" + nomes);
		}
	}
	
	public void estatisticaFuncionario() {
		// Define uma opcao de Menu
		int opcao = 0;
		
		try {
			// Recebe a entrada do Usuario
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null, 
				"*** FUNCIONARIO - ESTATISTICA ***\n"
				+ "\n[1] MAIOR NOME E MENOR NOME"
				+ "\n[2] MAIOR IDADE E MENOR IDADE"
				+ "\n[3] SEXO FEMININO E SEXO MASCULINO"
				+ "\n[4] MAIOR SALARIO E MENOR SALARIO"
			));
			
			// Verifica a opcao existente do menu
			switch (opcao) {
			case 1:
				// Verifica maior e menor Nome
				maiorMenorNome();
				break;
			case 2:
				// Verifica maior e menor Idade
				maiorMenorIdade();
				break;
			case 3:
				// Verifica sexo Masculino e Feminino
				sexoMascFemi();
				break;
			case 4:
				// Verifica menor e maior Salario
				maiorMenorSalario();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Entre com uma opcao acima");
				break;
			}
		} catch (Exception ex) {
			// Captura excessao para usuario e programador
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Opcao incorreta");
		}
	}
	
	private static void maiorMenorNome() {
		// Define variaveis padrao da funcao
		int maior = 0, menor = 0;
		String maiorNome = "", menorNome = "";
		
		// Percorre vetor Nome para leitura de registros
		for (int i = 0; i < vetorNome.length; i++) {
			// Verifica no vetor o maior registro
			if (vetorNome[i].length() > maior) {
				// Caso encontrado, armazena e subscreve
				maior = vetorNome[i].length();
				maiorNome = vetorNome[i];
			}
			
			// Verifica se o menor registro eh vazio e recebe
			if (menor == 0) {
				menor = vetorNome[i].length();
			}
			// Verifica o menor registro do vetor
			if (vetorNome[i].length() < menor) {
				// Armazena o valor do vetor
				menor = vetorNome[i].length();
				menorNome = vetorNome[i];
			}
		}
		
		// Exibe os resultados obtidos no vetor
		JOptionPane.showMessageDialog(null, 
			"[1] MAIOR NOME E MENOR NOME\n"
			+ "\nMaior Nome: " + maiorNome
			+ "\nTamanho: " + maior
			+ "\n\nMenor Nome: " + menorNome
			+ "\nTamanho: " + menor
		);
	}
	
	private static void maiorMenorIdade() {
		// Define as variaveis padrao do metodo
		int maior = 0, menor = 0;
		String maiorIdade = "", menorIdade = "";
		
		// Percorre o vetor
		for (int i = 0; i < vetorNome.length; i++) {
			// Verifica o maior registro do vetor e armazena
			if (vetorIdade[i] > maior) {
				maior = vetorIdade[i];
				maiorIdade = vetorNome[i];
			}
		
			// Verifica se o menor registro eh vazio e armazena o novo
			if (menor == 0) {
				menor = vetorIdade[i];
			}
			// Verifica o menor registro e armazena na variavel
			if (vetorIdade[i] < menor) {
				menor = vetorIdade[i];
				menorIdade = vetorNome[i];
			}
		}
		
		// Exibe os resultados obtidos no vetor
		JOptionPane.showMessageDialog(null, 
			"[2] MAIOR IDADE E MENOR IDADE\n"
			+ "\nFuncionario: " + maiorIdade
			+ "\nMaior Idade: " + maior
			+ "\n\nFuncionario: " + menorIdade
			+ "\nMenor Idade: " + menor
		);
	}
	
	private static void sexoMascFemi() {
		// Define as variaveis padrao do metodo
		String sexoFemi = "", sexoMasc = "";
		int contadorMasc = 0, contadorFemi = 0;
		
		// Percorre o vetor para armazenar registros
		for (int i = 0; i < vetorNome.length; i++) {
			// Verifica no vetor se char existe
			if (vetorSexo[i] == 'm' || vetorSexo[i] == 'M') {
				// Armazena todos os registros encontrados 
				sexoMasc += "\n- " + vetorNome[i];
				contadorMasc = contadorMasc + 1;
			}
			
			// Armazena todos os outros registros
			if (vetorSexo[i] == 'f' || vetorSexo[i] == 'F') {
				sexoFemi += "\n- " + vetorNome[i];
				contadorFemi = contadorFemi + 1;
			}
		}
		
		// Apresenta os resultados obtidos no Vetor
		JOptionPane.showMessageDialog(null, 
			"[3] SEXO FEMININO E SEXO MASCULINO\n" 
			+ "\nMASCULINO [" + contadorMasc + "]" + sexoMasc 
			+ "\n\nFEMININO [" + contadorFemi + "]" + sexoFemi);
	}
	
	private static void maiorMenorSalario() {
		// Define as variaveis padrao do metodo
		double maiorSalario = 0, menorSalario = 0;
		String maiorNome = "", menorNome = "";
		
		// Percorre o vetor
		for (int i = 0; i < vetorNome.length; i++) {
			// Verifica o maior registro e armazena
			if (vetorSalario[i] > maiorSalario) {
				// Encontrado, subscreve os registros novos
				maiorSalario = vetorSalario[i];
				maiorNome = vetorNome[i];
			}
			
			// Verifica o novo menor registro e guarda
			if (menorSalario == 0) {
				menorSalario = vetorSalario[i];
			}
			// Verifica o menor registro no vetor e armazena
			if (vetorSalario[i] < menorSalario) {
				menorSalario = vetorSalario[i];
				menorNome = vetorNome[i];
			}
		}
		// Aprensenta os resultados encontrados no vetores
		JOptionPane.showMessageDialog(null,
			"[4] MAIOR SALARIO E MENOR SALARIO\n"
			+ "\nMaior Salario: " + maiorNome
			+ "\nSalario R$: " + maiorSalario
			+ "\n\nMenor Salario: " + menorNome
			+ "\nSalario R$: " + menorSalario);
	}
}
