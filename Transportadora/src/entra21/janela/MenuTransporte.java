package entra21.janela;

import javax.swing.JOptionPane;
import entra21.classe.Transporte;

public class MenuTransporte {
	public void menu() {
		Transporte transporte = new Transporte();
		
		boolean continua = false;
		
		while (!continua) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, 
					"*** MENU TRANSPORTE ***\n"
					+ "\n[1] CADASTRO TRANSPORTE"
					+ "\n[2] LISTA TRANSPORTE"
					+ "\n[3] ESTATISTICA"
					+ "\n\n[0] MENU PRINCIPAL"));
				
				switch (opcao) {
					case 1:
						transporte.cadastraTransporte();
						break;
					case 2:
						transporte.listaTransporte();
						break;
					case 3:
						transporte.estatisticaTransporte();
						break;
					case 0:
						continua = true;
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opcao incorreta");
						break;
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Entre com uma das opcoes acima");
				System.out.println(ex.getMessage());
			}
		}
	}
}
