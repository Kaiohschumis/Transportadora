/**
 * Define os pacotes de arquivos do projeto
 */
package entra21.pkg.principal;

import entra21.pkg.tela.MenuPrincipal;

/**
 * @author Freakazed-PC
 */
public final class Inicializa {
	public static void main(String[] args) {
		// Inicializa a classe principal de execu��o
		MenuPrincipal menu = new MenuPrincipal();
		
		// Chama m�todo de execu��o da Classe
		menu.abreMenu();
	}
}
