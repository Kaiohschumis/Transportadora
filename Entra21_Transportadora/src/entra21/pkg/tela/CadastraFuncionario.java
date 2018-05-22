package entra21.pkg.tela;

import javax.swing.JOptionPane;
import entra21.pkg.classe.Funcionario;

public class CadastraFuncionario {
	Funcionario funcionario = new Funcionario();
	
	static int id;
	static String nome;
	static String cpf;
	static double salario;
	static int idade;
	static char sexo;
	static String funcao; 
	
	public void cadastrar(int codigo) {
		id = funcionario.ultimoCodigo();
		nome = JOptionPane.showInputDialog(null, "Nome Completo:");
		cpf = JOptionPane.showInputDialog(null, "CPF:");
		salario = Double.parseDouble(
			JOptionPane.showInputDialog(null, "Salário (R$):"));
		idade = Integer.parseInt(
			JOptionPane.showInputDialog(null, "Idade:"));
		sexo = JOptionPane.showInputDialog(null, "Sexo:\n[M]\n[F]").charAt(0);
		funcao = JOptionPane.showInputDialog(null, "Função");
		
		
	}
}
