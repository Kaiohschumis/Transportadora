package entra21.pkg.tela;

import javax.swing.JOptionPane;

public class MenuPrincipal {
	MenuFuncionario menuFuncionario = new MenuFuncionario();
	
	public void abreMenu() {
		int menu = Integer.parseInt(JOptionPane.showInputDialog(null, 
			"*** MENU PRINCIPAL ***\n\n"
			+ "[1] FUNCIONARIO\n"
			+ "[0] ENCERRAR"
		));
		
		while (menu != 0) {
			try {
				switch (menu) {
				case 1:
					menuFuncionario.funcionario();
					break;
				case 0:
					
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção Incorreta.");
					break;
				}
				
				
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			menu = Integer.parseInt(JOptionPane.showInputDialog(null, 
					"*** MENU PRINCIPAL ***\n\n"
					+ "[1] FUNCIONARIO\n"
					+ "[0] ENCERRAR"
				));
		}
	}
}
