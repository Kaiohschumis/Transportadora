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
		// Inicializa a classe principal de execução
		MenuPrincipal menu = new MenuPrincipal();
		
		// Chama método de execução da Classe
		menu.abreMenu();
	}
}
