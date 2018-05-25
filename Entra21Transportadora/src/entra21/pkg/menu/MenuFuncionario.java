package entra21.pkg.menu;

import javax.swing.JOptionPane;
import entra21.pkg.classe.Funcionario;

public class MenuFuncionario {
	Funcionario funcionario = new Funcionario();
	//MenuPrincipal menuPrincipal = new MenuPrincipal();
	
	public void funcionario() {
		boolean valida = false;
		
		while (!valida) {
			int menu = Integer.parseInt(JOptionPane.showInputDialog(null, 
				"*** MENU FUNCIONARIO ***\n\n"
				+ "[1] CADASTRA FUNCIONARIO\n"
				+ "[2] CONSULTA FUNCIONARIO\n"
				+ "[0] MENU PRINCIPAL"
			));
			
			try {
				switch (menu) {
				case 1:
					funcionario.cadastro();
					break;
				case 2:
					funcionario.consulta();
					break;
				case 0:
					//menuPrincipal.abreMenu();
					valida = true;
					break;
				default:
					JOptionPane.showMessageDialog(null, "Entre uma opcao acima");
					break;
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
