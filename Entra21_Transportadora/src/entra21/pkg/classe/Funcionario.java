package entra21.pkg.classe;

public class Funcionario {
	int tamanho = 100;
	
	int[] vetorCodigo = new int[tamanho];
	String[] vetorNome = new String[tamanho];
	String[] vetorCpf = new String[tamanho];
	double[] vetorSalario = new double[tamanho];
	int[] vetorIdade = new int[tamanho];
	char[] vetorSexo = new char[tamanho];
	String[] vetorFuncao = new String[tamanho];
	
	//CadastraFuncionario cadastra = new CadastraFuncionario();
	
	public int ultimoCodigo() {
		int ultimo = 0;
		
		for (int i = 0; i < vetorCodigo.length; i++) {
			ultimo = i;
		}
		
		return ultimo;
	}
	
	public void insere() {
		for (int i = 0; i < vetorCodigo.length; i++) {
			if (ultimoCodigo() != vetorCodigo[i]) {
				System.out.println("Posicao diferente do codigo");
			} else {
				
			}
		}
	}
}
