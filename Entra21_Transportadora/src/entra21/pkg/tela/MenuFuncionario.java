package entra21.pkg.tela;

import javax.swing.JOptionPane;

public class MenuFuncionario {
	CadastraFuncionario cadastro = new CadastraFuncionario();
	//MenuPrincipal menu = new MenuPrincipal();
	
	public void funcionario() {
		int menu = Integer.parseInt(JOptionPane.showInputDialog(null, 
			"*** MENU FUNCIONARIO ***\n\n[1] CADASTRO\n[2] Consulta\n[0] VOLTAR"));
		
		try {
			while (menu != 0) {
				switch (menu) {
				case 1:
					cadastro.registra();
					break;
				case 2:
					cadastro.consulta();
					break;
				case 0:
					//menuPrincipal.abreMenu();
					break;
				default:
					break;
				}
				menu = Integer.parseInt(JOptionPane.showInputDialog(null, 
					"*** MENU FUNCIONARIO ***\n\n[1] CADASTRO\n[2] Consulta\n[0] VOLTAR"));
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
