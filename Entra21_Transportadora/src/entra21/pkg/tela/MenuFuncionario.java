package entra21.pkg.tela;

import javax.swing.JOptionPane;
import entra21.pkg.classe.Funcionario;

public class MenuFuncionario {
	Funcionario funcionario = new Funcionario();
	
	public void funcionario() {
		int menu = Integer.parseInt(JOptionPane.showInputDialog(null, 
			"*** MENU FUNCIONARIO ***\n\n[1] CADASTRO\n[2] Consulta\n[0] VOLTAR"));
		
		try {
			while (menu != 0) {
				switch (menu) {
				case 1:
					funcionario.cadastro();
					break;
				case 2:
					funcionario.consulta();
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
