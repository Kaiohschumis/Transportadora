package entra21.pkg.tela;

import javax.swing.JOptionPane;
import entra21.pkg.classe.Funcionario;

public class CadastraFuncionario {
	Funcionario funcionario = new Funcionario();
	int tamanho = 100, contador = 0;
	
	int[] arrayCodigo = new int[tamanho];
	int[] arrayIdade = new int[tamanho];
	String[] arrayNome = new String[tamanho];
	String[] arrayCpf = new String[tamanho];
	String[] arrayFuncao = new String[tamanho];
	double[] arraySalario = new double[tamanho];
	char[] arraySexo = new char[tamanho];
	
	String texto = "*** CADASTRO DE FUNCIONARIO***\n\n";
	
	public void registra() {
		contador = arrayCodigo.length + 1;
		String nome = JOptionPane.showInputDialog(null, "Nome do Funcionário:");
		String cpf = JOptionPane.showInputDialog(null, "CPF:");
		double salario = Double.parseDouble(
			JOptionPane.showInputDialog("Salário (R$):"));
		int idade = Integer.parseInt(
			JOptionPane.showInputDialog(null, "Idade:"));
		char sexo = JOptionPane.showInputDialog(null, 
			"Sexo:\n[M] Masculino\n[F] Feminino").charAt(0);
		String funcao = JOptionPane.showInputDialog(null, "Função:");
		
		funcionario.setCodigoFuncionario(contador);
		funcionario.setNomeFuncionario(nome);
		funcionario.setCpf(cpf);
		funcionario.setSalario(salario);
		funcionario.setIdade(idade);
		funcionario.setSexo(sexo);
		funcionario.setFuncao(funcao);
	}
	
	public void insere() {
		arrayCodigo[contador] = funcionario.getCodigoFuncionario();
		arrayNome[contador] = funcionario.getNomeFuncionario();
		arrayCpf[contador] = funcionario.getCpf();
		arraySalario[contador] = funcionario.getSalario();
		arrayIdade[contador] = funcionario.getIdade();
		arraySexo[contador] = funcionario.getSexo();
		arrayFuncao[contador] = funcionario.getFuncao();
	}
	
	public void consulta() {
		int codigo = Integer.parseInt(
			JOptionPane.showInputDialog(null, "Digite o Codigo:"));
		
		for (int i = 0; i < codigo; i++) {
			System.out.println(
				arrayCodigo[i] + "\n" +
				arrayNome[i] + "\n" +
				arrayCpf[i] + "\n" +
				arraySalario[i] + "\n" +
				arrayIdade[i] + "\n" +
				arraySexo[i] + "\n" +
				arrayFuncao[i] + "\n" +
				arrayCodigo[i] + "\n" +
				arrayCodigo[i] + "\n"
			);
		}
	}
}
