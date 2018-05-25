package entra21.pkg.menu;

import javax.swing.JOptionPane;

import entra21.pkg.Carga;
import entra21.pkg.Empresa;
import entra21.pkg.Encomenda;
import entra21.pkg.Transporte;

public class MenuPrincipal {
	MenuFuncionario menuFuncionario = new MenuFuncionario();
	Transporte transportee = new Transporte();
	Encomenda encomenda = new Encomenda(); 
	Carga carga = new Carga();
	Empresa empresa = new Empresa();
	
	public void abreMenu() {
		boolean valida = false;
		
		while (!valida) {
			try {
				int menu = Integer.parseInt(JOptionPane.showInputDialog(null,
					"*** MENU PRINCIPAL ***\n\n" 
					+ "[1] FUNCIONARIO\n"
					+ "[2] TRANSPORTE\n"
				    + "[3] ENCOMENDA\n"
					+ "[4] CARGA\n"
				    + "[5] EMPRESA\n"
					+ "[0] ENCERRAR"));
				
				switch (menu) {
				case 1:
					menuFuncionario.funcionario();
				case 2:
					 transportee.cadastroTransporte();
				case 3:
					 encomenda.cadastroEncomeda();
				case 4:
					 carga.cadastroCarga();
				case 5:
					 empresa.cadastroEmpresa();
				case 0:
					valida = true;
					break;
				default:
					JOptionPane.showMessageDialog(null, "UPS, informe uma opção acima");
					break;
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
	
				JOptionPane.showMessageDialog(null, "Opção informada incorreta!");
			}
		}
	}
}
