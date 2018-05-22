package entra21.pkg.classe;

public class Funcionario {
	private static int codigoFuncionario;
	private static String nomeFuncionario;
	private static String cpf;
	private static double salario21;
	private static int idade;
	private static char sexo;
	private static String funcao;
	
	public final int getCodigoFuncionario() {
		return codigoFuncionario;
	}
	
	public final void setCodigoFuncionario(int codigoFuncionario) {
		Funcionario.codigoFuncionario = codigoFuncionario;
	}
	
	public final String getNomeFuncionario() {
		return nomeFuncionario;
	}
	
	public final void setNomeFuncionario(String nomeFuncionario) {
		Funcionario.nomeFuncionario = nomeFuncionario;
	}
	
	public final String getCpf() {
		return cpf;
	}
	
	public final void setCpf(String cpf) {
		Funcionario.cpf = cpf;
	}
	
	public final double getSalario() {
		return salario;
	}
	
	public final void setSalario(double salario) {
		Funcionario.salario = salario;
	}
	
	public final int getIdade() {
		return idade;
	}
	
	public final void setIdade(int idade) {
		Funcionario.idade = idade;
	}
	
	public final char getSexo() {
		return sexo;
	}
	
	public final void setSexo(char sexo) {
		Funcionario.sexo = sexo;
	}
	
	public final String getFuncao() {
		return funcao;
	}
	
	public final void setFuncao(String funcao) {
		Funcionario.funcao = funcao;
	}
}
