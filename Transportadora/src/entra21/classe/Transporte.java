package entra21.classe;

import javax.swing.JOptionPane;

import entra21.validacao.ValidacaoCampos;

public class Transporte {
	static int tamanho = 100;
	
	// Criacao dos arrays da classe para armazenar as infos
	// Array padrao fixo para inserir valores
	static String[] vetorTipo = new String[tamanho];
	// Array padrao fixo para inserir valores
	static double[] vetorCapacidade = new double[tamanho];
	// Array padrao fixo para inserir valores
	static String[] vetorModelo = new String[tamanho];
	// Array padrao fixo para inserir valores
	static String[] vetorMarca = new String[tamanho];
	// Array padrao fixo para inserir valores
	static double[] vetorKilometro = new double[tamanho];
	// Array padrao fixo para inserir valores
	static int[] vetorAno = new int[tamanho];
	// Array padrao fixo para inserir valores
	static double[] vetorCusto = new double[tamanho];
	
	public void cadastraTransporte() {
		// Instancia a classe de validação
		ValidacaoCampos validacao = new ValidacaoCampos();
		
		// Recebe a posicao mais nova do vetor
		int posicao = ultimaPosicao();
		
		vetorTipo[posicao] = validacao.selecionaTransporte();
		vetorCapacidade[posicao] = validacao.validaCapacidade();
		
		// Segue sem validação de Campos
		vetorModelo[posicao] = JOptionPane.showInputDialog(null, "Modelo Veiculo:");
		vetorMarca[posicao] = JOptionPane.showInputDialog(null, "Marca Veiculo:");
		vetorKilometro[posicao] = validacao.validaKilometragem();
		vetorAno[posicao] = validacao.validaAno();
		vetorCusto[posicao] = Double.parseDouble(
			JOptionPane.showInputDialog(null, "Custo padrao do Veiculo R$:"));
	}
	
	// Percorre o vetor para pegar posicao mais atual 
	private static int ultimaPosicao() {
		// Define uma posicao
		int posicao = 0;
		
		// Percorre vetor e verifica se contem informacao
		for (int i = 0; i < vetorTipo.length; i++) {
			// Caso somente conter info e entao captura e 
			// valida condicao
			if (vetorTipo[i] == null) {
				posicao = i;
				break;
			}
		}
		// Retorno do metodo de validacao
		return posicao;
	}
	
	public void listaTransporte() {
		// Inicializa as variaveis da funcao
		String listagem = "";
		boolean vazio = true;
		int contador = 0;
		
		// Percorre todo vetor por registros
		for (int i = 0; i < vetorTipo.length; i++) {
			// Traz a posicao com registros 
			if (vetorTipo[i] != null) {
				// Armazena os registros nas posicoes contidas e conta
				listagem += "\n" + vetorTipo[i] + " - " + vetorCapacidade[i]
					+ " Kg - " + vetorAno[i];
				contador = contador + 1;
				vazio = false;
			}
		}
		// Caso condicao, monstra mensagem
		if (vazio) {
			JOptionPane.showMessageDialog(null, "Nenhum Tipo encontrado");
		} else {
			// Exibe resultados do array
			JOptionPane.showMessageDialog(null,
				"*** LISTA DE TIPOS [ " + contador + " ] ***\n" + listagem);
		}
	}
	
	public void estatisticaTransporte() {
		// Define uma opcao de Menu
		int opcao = 0;
		
		try {
			// Recebe a entrada do Usuario
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null, 
				"*** TRANSPORTE - ESTATISTICA ***\n"
				+ "\n[1] MAIOR CAPACIDADE E MENOR CAPACIDADE"
				+ "\n[2] MAIOR KILOMETRO E MENOR KILOMETRO"
			));
			
			// Verifica a opcao existente do menu
			switch (opcao) {
			case 1:
				// Verifica maior e menor Nome
				maiorMenorCapacidade();
				break;
			case 2:
				// Verifica maior e menor Idade
				maiorMenorKilometragem();
				break;
			case 3:
				// Verifica sexo Masculino e Feminino
				//sexoMascFemi();
				break;
			case 4:
				// Verifica menor e maior Salario
				//maiorMenorSalario();
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
	
	private static void maiorMenorCapacidade() {
		// Define as variaveis padrao do metodo
		double maiorCapacidade = 0, menorCapacidade = 0;
		String maiorTipo = "", menorTipo = "";
		
		// Percorre o vetor para ler registros
		for (int i = 0; i < vetorTipo.length; i++) {
			// Verifica o maior registro e armazena
			if (vetorCapacidade[i] > maiorCapacidade) {
				// Encontrado, subscreve os registros novos
				maiorCapacidade = vetorCapacidade[i];
				maiorTipo = vetorTipo[i];
			}
			
			// Verifica o novo menor registro e guarda
			if (menorCapacidade == 0) {
				menorCapacidade = vetorCapacidade[i];
			}
			// Verifica o menor registro no vetor e armazena
			if (vetorCapacidade[i] < menorCapacidade) {
				menorCapacidade = vetorCapacidade[i];
				menorTipo = vetorTipo[i];
			}
		}
		// Aprensenta os resultados encontrados no vetores
		JOptionPane.showMessageDialog(null,
			"[1] MAIOR CAPACIDADE E MENOR CAPACIDADE\n"
			+ "\nMaior Capacidade: " + maiorTipo
			+ "\nCapacidade KG: " + maiorCapacidade
			+ "\n\nMenor Capacidade: " + menorTipo
			+ "\nCapacidade KG: " + menorCapacidade);
	}
	
	private static void maiorMenorKilometragem() {
		// Define as variaveis padrao do metodo
		double maiorKilometragem = 0, menorKilometragem = 0;
		String maiorTipo = "", menorTipo = "";
		
		// Percorre o vetor para ler registros
		for (int i = 0; i < vetorTipo.length; i++) {
			// Verifica o maior registro e armazena
			if (vetorKilometro[i] > maiorKilometragem) {
				// Encontrado, subscreve os registros novos
				maiorKilometragem = vetorKilometro[i];
				maiorTipo = vetorTipo[i];
			}
			
			// Verifica o novo menor registro e guarda
			if (menorKilometragem == 0) {
				menorKilometragem = vetorKilometro[i];
			}
			// Verifica o menor registro no vetor e armazena
			if (vetorKilometro[i] < menorKilometragem) {
				menorKilometragem = vetorKilometro[i];
				menorTipo = vetorTipo[i];
			}
		}
		// Aprensenta os resultados encontrados no vetores
		JOptionPane.showMessageDialog(null,
			"[2] MAIOR KILOMETRO E MENOR KILOMETRO\n"
			+ "\nMaior Kilometragem: " + maiorTipo
			+ "\nKilometragem KM: " + maiorKilometragem
			+ "\n\nMenor Kilometragem: " + menorTipo
			+ "\nKilometragem KM: " + menorKilometragem);
	}
}
