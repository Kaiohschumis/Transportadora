package entra21.pkg.menu;

import javax.swing.JOptionPane;

public class MenuPrincipal {
	MenuFuncionario menuFuncionario = new MenuFuncionario();
	
	public void abreMenu() {
		boolean valida = false;
		
		while (!valida) {
			try {
				int menu = Integer.parseInt(JOptionPane.showInputDialog(null,
					"*** MENU PRINCIPAL ***\n\n" 
					+ "[1] FUNCIONARIO\n"
					+ "[0] ENCERRAR"));
				
				switch (menu) {
				case 1:
					menuFuncionario.funcionario();
					break;
				case 0:
					valida = true;
					break;
				default:
					JOptionPane.showMessageDialog(null, "UPS, informe uma op��o acima");
					break;
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
	
				JOptionPane.showMessageDialog(null, "Op��o informada incorreta!");
			}
		}
	}
}
