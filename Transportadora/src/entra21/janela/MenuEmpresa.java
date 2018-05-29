package entra21.janela;

import javax.swing.JOptionPane;
import entra21.classe.Empresa;

public class MenuEmpresa {
	public void menu() {
		// Inicializa a Classe Empresa com instancia
		Empresa empresa = new Empresa();
		// Condicao de validacao
		boolean continua = true;
		
		// Continua execucao ate condicao nao corresponder
		while (continua) {
			try {
				// Valor de entrada pra usuario
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
					"*** MENU EMPRESA ***\n" 
					+ "\n[1] NOVA EMPRESA"
					+ "\n[2] LISTA DE EMPRESAS"
					+ "\n[3] PESQUISA EMPRESA"
					+ "\n\n[0] MENU PRINCIPAL"
				));
				
				// Pega o valor de entrada e atribui uma opcao
				switch (opcao) {
					case 1:
						// Acesso a funcao .cadastro da Classe Empresa
						empresa.cadastraEmpresa();
						break;
					case 2:
						// Acesso a funcao .lista da Classe Empresa
						empresa.listaEmpresa();
						break;
					case 3:
						empresa.consultaEmpresa();
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
