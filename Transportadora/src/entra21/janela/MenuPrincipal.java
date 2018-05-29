package entra21.janela;

import javax.swing.JOptionPane;

public class MenuPrincipal {
	public void monstraMenu() {
		// Inicia a instancia da Classe Funcionario
		MenuFuncionario funcionario = new MenuFuncionario();
		// Inicia a instancia da Classe Empresa
		MenuEmpresa empresa = new MenuEmpresa();
		// Inicia a instancia da Classe Transporte
		MenuTransporte transporte = new MenuTransporte();
		// Inicia a instancia da Classe Encomenda
		MenuEncomenda encomenda = new MenuEncomenda();
		
		// Condicao para validacao
		boolean continua = true;
		
		// Enquanto condicao do menu ser valido, continua
		while (continua) {
			// Tratamento de erros
			try {
				// Apresenta um menu de entrada para usuario
				int menuPrincipal = Integer.parseInt(
					JOptionPane.showInputDialog(null, 
					"*** TRANSPORTATORA CONSERVAS - MENU ***\n"
					+ "\n[1] FUNCIONARIO"
					+ "\n[2] EMPRESA"
					+ "\n[3] TRANSPORTE"
					+ "\n[4] ENCOMENDA"
					+ "\n\n[0] ENCERRAR"
				));
				
				// Atribui uma condicao para a opcao escolhida.
				// Caso condicao bater, entra na funcao da Classe de acesso
				switch (menuPrincipal) {
					case 1:
						// Acessa funcao da classe Funcionario
						funcionario.menu();
						break;
					case 2:
						// Acessa funcao da Classe Empresa
						empresa.menu();
						break;
					case 3:
						// Acessa funcao da Classe Transporte
						transporte.menu();
						break;
					case 4:
						// Acessa funcao da Classe Encomenda
						encomenda.menu();
						break;
					case 0:
						// Encerra execucao
						continua = false;
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opcao incorreta");
						break;
				}
			} catch (Exception ex) {
				// Exibe uma mensagem para usuario e um erro de sistema oculto
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "UPS... Entre uma opcao valida");
			}
		}
	}
}
