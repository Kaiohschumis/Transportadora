package entra21.classe;

import javax.swing.JOptionPane;

import entra21.validacao.ValidacaoCampos;

public class Empresa {
	// Define um tamanho fixo para os Arrays da Classe
	static int tamanho = 100;
		
	static String[] vetorEmpresa = new String[tamanho];
	static String[] vetorCnpj = new String[tamanho];
	static String[] vetorCep = new String[tamanho];
	static String[] vetorEndereco = new String[tamanho];
	static String[] vetorNumero = new String[tamanho];
	static String[] vetorCidade = new String[tamanho];
	static String[] vetorEstado = new String[tamanho];
	
	// Cria uma funcao de cadastro para armazenar valores
	public void cadastraEmpresa() {
		// Inicia instancia de acesso da Classe
		ValidacaoCampos validaCampo = new ValidacaoCampos();
		
		// Acessa a funcao para obter o ultima posicao de array
		int posicao = ultimaPosicao();
		
		// Os vetores somente recebem um valor na posicao caso
		// a funcao de insercao de registro validar
		vetorEmpresa[posicao] = JOptionPane.showInputDialog(null, "Nome da Empresa:");
		vetorCnpj[posicao] = validaCampo.validaCNPJ();
		vetorCep[posicao] = validaCampo.validaCEP();
		vetorEndereco[posicao] = JOptionPane.showInputDialog(null, "Endereço:");
		vetorNumero[posicao] = JOptionPane.showInputDialog(null, "Numero:");
		vetorCidade[posicao] = JOptionPane.showInputDialog(null, "Cidade:");
		vetorEstado[posicao] = validaCampo.validaEstado();
	}
	
	// Percorre o array para pegar a posicao mais atual 
	private static int ultimaPosicao() {
		// Define uma posicao
		int posicao = 0;
		
		// Percorre array e verifica se contem informacao
		for (int i = 0; i < vetorEmpresa.length; i++) {
			// Caso somente conter info, entao captura e 
			// valida condicao
			if (vetorEmpresa[i] == null) {
				posicao = i;
				break;
			}
		}
		// Retorno do metodo de validacao
		return posicao;
	}
	
	// Acesso de reigstros da Classe
	public void consultaEmpresa() {
		// Atribui inicializacao de objetos da funcao
		boolean encontrado = false;
		String pesquisaEmpresa = "", listagem = "";
		int contador = 0;
		
		// Enquanto condicao ser diferente, prossege execucao
		while (!encontrado) {
			// Usuario entra com um valor com Caixa Baixa
			pesquisaEmpresa = JOptionPane.showInputDialog(null, 
				"Pesquisar Nome da Empresa:\n[ESC] Sair").toLowerCase();
			
			// Verifica se Usuario digitou algo, senao repete
			if (!pesquisaEmpresa.isEmpty()) {
				// Percorre array por valores
				for (int i = 0; i < vetorEmpresa.length; i++) {
					// Somente traz registros, caso corresponder
					if (vetorEmpresa[i].toLowerCase().contains(pesquisaEmpresa)) {
						// Variavel de incremento para exibir resultados, 
						// contador de registros e validacao de condicao
						listagem += "\n" + vetorEmpresa[i];
						contador = contador + 1;
						encontrado = true;
					}
				}
				// Caso nao validar, mostra mensagem
				if (!encontrado) {
					JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Informe uma Empresa");
			}
			// Caso tiver 1 ou mais registros exibe mensagem
			if (contador > 0) {
				JOptionPane.showMessageDialog(null, 
					"*** RESULTADO ***\n\n[" + contador + "] NOMES COM \"" 
					+ pesquisaEmpresa + "\" ENCONTRADOS:\n" + listagem);
			}
		}
	}
	
	// Funcao para lista todos os registros do array
	public void listaEmpresa() {
		// Inicializ variaveis da funcao
		String listagem = "";
		boolean vazio = true;
		int contador = 0;
		
		// Percorre vetor por registros
		for (int i = 0; i < vetorEmpresa.length; i++) {
			// Caso vetor trazer algum valor
			if (vetorEmpresa[i] != null) {
				// Para cada posicao com valores, recebe variavel
				// Contador de registros encontrados e condicao validada
				listagem += "\n" + vetorEmpresa[i] + " - " + vetorCnpj[i] 
					+ " - " + vetorCep[i];
				
				contador = contador + 1;
				vazio = false;
			}
		}
		// Caso condicao, monstra mensagem
		if (vazio) {
			JOptionPane.showMessageDialog(null, "Nenhuma Empresa cadastrado");
		} else {
			// Exibe resultados do array
			JOptionPane.showMessageDialog(null,
				"*** LISTA DE EMPRESAS [ " + contador + " ] ***\n" + listagem);
		}
	}
}
