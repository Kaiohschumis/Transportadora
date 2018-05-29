package entra21.janela;

import javax.swing.JOptionPane;
import entra21.classe.Funcionario;

public class MenuFuncionario {
	public void menu() {
		// Inicializa a Classe Funcionario com instancia
		Funcionario funcionario = new Funcionario();
		// Condicao de validacao
		boolean continua = true;
		
		// Continua execucao ate condicao nao corresponder
		while (continua) {
			try {
				// Valor de entrada pra usuario
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
					"*** MENU FUNCIONARIO ***\n" 
					+ "\n[1] NOVO FUNCIONARIO"
					+ "\n[2] LISTA DE FUNCIONARIOS"
					+ "\n[3] PESQUISA FUNCIONARIO"
					+ "\n[4] ESTATISTICA"
					+ "\n\n[0] MENU PRINCIPAL"
				));
				
				// Pega o valor de entrada e atribui uma opcao
				switch (opcao) {
					case 1:
						// Acesso a funcao .cadastro da Classe Funcionario
						funcionario.cadastraFuncionario();
					break;
					case 2:
						// Acesso a funcao .listagem da Classe Funcionario
						funcionario.listaFuncionario();
					break;
					case 3:
						// Acesso a funcao .consulta da Classe Funcionario
						funcionario.consultaFuncionario();
					break;
					case 4:
						// Acesso a funcao .estatistica da Classe Funcionario
						funcionario.estatisticaFuncionario();
					break;
					case 0:
						// Caso corresponder, finaliza loop
						continua = false;
					break;
					default:
						// Mensagem padrao caso nenhuma condicao validar
						JOptionPane.showMessageDialog(null, "Opcao incorreta");
					break;
				}
			} catch (Exception ex) {
				// Para tratar erro de sistema, exibe mensagem para usuario
				// Erro de sistema sera visto pelo desenvolvedor
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "UPS... Entre uma opcao valida");
			}
		}
	}
}
