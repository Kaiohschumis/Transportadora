package entra21.classe;

import javax.swing.JOptionPane;

import entra21.validacao.ValidacaoCampos;

public class Encomenda {
	// Define um tamanho fixo para os Arrays da Classe
	static int tamanho = 100;
	
	// Criacao dos arrays da classe para armazenar as infos
	// Array padrao fixo para inserir valores
	static String[] vetorEncomenda = new String[tamanho];
	static String[] vetorDataEmissao = new String[tamanho];
	static String[] vetorDataEntrega = new String[tamanho];
	static int[] vetorQuantidade = new int[tamanho];
	static double[] vetorPeso = new double[tamanho];
	static double[] vetorValorFixo = new double[tamanho];
	static String[] vetorResponsavel = new String[tamanho];
	static String[] vetorTransporte = new String[tamanho];
	
	public void cadastraEncomenda() {
		ValidacaoCampos validacao = new ValidacaoCampos();
		
		// Acessa a funcao para obter o ultima posicao de array
		int posicao = ultimaPosicao();
		
		// Os vetores somente recebem um valor na posicao caso
		// a funcao de insercao de registro validar
		vetorEncomenda[posicao] = JOptionPane.showInputDialog(null, "Nome de Encomenda:");
		vetorDataEmissao[posicao] = validacao.validaData();
		vetorDataEntrega[posicao] = validacao.validaData();
		vetorQuantidade[posicao] = validacao.validaIdade();
		vetorPeso[posicao] = validacao.validaPeso();
		vetorValorFixo[posicao] = Double.parseDouble(
			JOptionPane.showInputDialog(null, "Valor Fixo: R$"));
		vetorResponsavel[posicao] = JOptionPane.showInputDialog(null, "Responsavel:");
		vetorTransporte[posicao] = JOptionPane.showInputDialog(null, "Transporte:");
	}
	
	private static int ultimaPosicao() {
		// Define uma posicao
		int posicao = 0;
		
		// Percorre array e verifica se contem informacao
		for (int i = 0; i < vetorEncomenda.length; i++) {
			// Caso somente conter info, entao captura e 
			// valida condicao
			if (vetorEncomenda[i] == null) {
				posicao = i;
				break;
			}
		}
		// Retorno do metodo de validacao
		return posicao;
	}
	
	public void listaEncomenda() {
		// Inicializa variaveis da funcao
		String listagem = "";
		boolean vazio = true;
		int contador = 0;
		
		// Percorre vetor por registros
		for (int i = 0; i < vetorEncomenda.length; i++) {
			// Caso vetor trazer algum valor
			if (vetorEncomenda[i] != null) {
				// Para cada posicao com valores, recebe variavel
				// Contador de registros encontrados e condicao validada
				listagem += "\n" + vetorEncomenda[i] 
					+ " - R$" + vetorValorFixo[i] + " - " + vetorResponsavel[i];
				contador = contador + 1;
				vazio = false;
			}
		}
		// Caso condicao, monstra mensagem
		if (vazio) {
			JOptionPane.showMessageDialog(null, "Nenhum Encomenda registrada");
		} else {
			// Exibe resultados do array
			JOptionPane.showMessageDialog(null,
				"*** LISTA DE ENCOMENDAS [ " + contador + " ] ***\n" + listagem);
		}
	}
	
	public void estatisticaEncomenda() {
		// Define uma opcao de Menu
		int opcao = 0;
		
		try {
			// Recebe a entrada do Usuario
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null, 
				"*** ENCOMENDA - ESTATISTICA ***\n"
				+ "\n[1] MAIOR QUANTIDADE E MENOR QUANTIDADE"
				+ "\n[2] MAIOR VALOR FIXO E MENOR VALOR FIXO"
			));
			
			// Verifica a opcao existente do menu
			switch (opcao) {
			case 1:
				// Verifica maior e menor Quantidade
				maiorMenorQuantidade();
				break;
			case 2:
				// Verifica maior e menor Valor fixo
				maiorMenorValor();
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
	
	private static void maiorMenorQuantidade() {
		// Define as variaveis padrao do metodo
		int maior = 0, menor = 0;
		String maiorQuantidade = "", menorQuantidade = "";
		
		// Percorre o vetor
		for (int i = 0; i < vetorEncomenda.length; i++) {
			// Verifica o maior registro do vetor e armazena
			if (vetorQuantidade[i] > maior) {
				maior = vetorQuantidade[i];
				maiorQuantidade = vetorEncomenda[i];
			}
		
			// Verifica se o menor registro eh vazio e armazena o novo
			if (menor == 0) {
				menor = vetorQuantidade[i];
			}
			// Verifica o menor registro e armazena na variavel
			if (vetorQuantidade[i] < menor) {
				menor = vetorQuantidade[i];
				menorQuantidade = vetorEncomenda[i];
			}
		}
		
		// Exibe os resultados obtidos no vetor
		JOptionPane.showMessageDialog(null, 
			"[1] MAIOR QUANTIDADE E MENOR QUANTIDADE\n"
			+ "\nEncomenda: " + maiorQuantidade
			+ "\nMaior Quantidade: " + maior
			+ "\n\nEncomenda: " + menorQuantidade
			+ "\nMenor Quantidade: " + menor
		);
	}
	
	private static void maiorMenorValor() {
		// Define as variaveis padrao do metodo
		double maiorValor = 0, menorValor = 0;
		String maiorNome = "", menorNome = "";
		
		// Percorre o vetor
		for (int i = 0; i < vetorEncomenda.length; i++) {
			// Verifica o maior registro e armazena
			if (vetorValorFixo[i] > maiorValor) {
				// Encontrado, subscreve os registros novos
				maiorValor = vetorValorFixo[i];
				maiorNome = vetorEncomenda[i];
			}
			
			// Verifica o novo menor registro e guarda
			if (menorValor == 0) {
				menorValor = vetorValorFixo[i];
			}
			// Verifica o menor registro no vetor e armazena
			if (vetorValorFixo[i] < menorValor) {
				menorValor = vetorValorFixo[i];
				menorNome = vetorEncomenda[i];
			}
		}
		// Aprensenta os resultados encontrados no vetores
		JOptionPane.showMessageDialog(null,
			"[2] MAIOR VALOR FIXO E MENOR VALOR FIXO\n"
			+ "\nMaior Valor: " + maiorNome
			+ "\nValor R$: " + maiorValor
			+ "\n\nMenor Valor: " + menorNome
			+ "\nValor R$: " + menorValor);
	}
}
