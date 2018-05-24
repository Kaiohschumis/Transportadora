package entra21.pkg.classe;

import javax.swing.JOptionPane;

public class Funcionario {
	int tamanho = 100;
	
	int[] vetorCodigo = new int[tamanho];
	String[] vetorNome = new String[tamanho];
	String[] vetorCpf = new String[tamanho];
	double[] vetorSalario = new double[tamanho];
	int[] vetorIdade = new int[tamanho];
	char[] vetorSexo = new char[tamanho];
	String[] vetorFuncao = new String[tamanho];
	
	int ultimo = 0;
	
	public void cadastro() {
		insere(ultimo);
		ultimo++;
	}
	
	public void insere(int posicao) {
		vetorCodigo[posicao] = posicao;
		vetorNome[posicao] = JOptionPane.showInputDialog(null, "Nome Completo:");
		vetorCpf[posicao] = JOptionPane.showInputDialog(null, "CPF:");
		vetorSalario[posicao] = Double.parseDouble(
			JOptionPane.showInputDialog(null, "Salário (R$):"));
		vetorIdade[posicao] = Integer.parseInt(
			JOptionPane.showInputDialog(null, "Idade:"));
		vetorSexo[posicao] = JOptionPane.showInputDialog(null, "Sexo:\n[M]\n[F]").charAt(0);
		vetorFuncao[posicao] = JOptionPane.showInputDialog(null, "Função");
	}
	
	public void consulta() {
		String busca = JOptionPane.showInputDialog(null, 
			"[P] Pesquisar por Nome\n[T] Listar todos\n[R] Retornar");
		
		switch (busca) {
			case "P":
				break;
			case "T":
				consultaTodos();
				break;
			case "R":
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Invalida");
				break;
			}
		
		/*for (int i = 0; i < vetorCodigo.length; i++) {
			if (vetorNome[i] == busca) {
				System.out.println("encontrado: " + vetorNome[i]);
				break;
			} else {
				System.out.println("nao encontrado");
			}
		}*/
	}
	
	public void consultaTodos() {
		for (int i = 0; i < vetorNome.length; i++) {
			if (vetorNome[i] != null) {
				System.out.println(vetorNome[i]);
			}
		}
	}
}
