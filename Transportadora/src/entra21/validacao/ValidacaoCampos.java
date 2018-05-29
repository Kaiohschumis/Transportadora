package entra21.validacao;

import javax.swing.JOptionPane;

public class ValidacaoCampos {
	// Variaveis de acesso da Classe
	String cpf = "", tipoFuncao = "", dataDiaMesAno = "",
		cnpj = "", cep = "", estado = "";
	int idade = 0, ano = 0;
	double salario = 0, capacidade = 0, kilometragem = 0, peso = 0;
	char sexo = 0;
	
	// Validacao de campos Idade
	public int validaIdade() {
		// Define condicao
		boolean valida = false;
		
		// Enquanto condicao nao corresponder
		while (!valida) {
			try {
				// Captura entrada de Usuario
				idade = Integer.parseInt(
					JOptionPane.showInputDialog(null, "Entre uma Idade:"));
				
				// Caso idade for diferente
				if (idade <= 0 || idade > 130) {
					JOptionPane.showMessageDialog(null, "Entre uma idade corretamente");
				} else {
					// Valida condicao
					valida = true;
				}
			} catch (Exception ex) {
				// Exibe mensagem para Usuario e erro para Desenvolvedor
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Por favor, preencha com uma idade");
			}
		}
		// Retorna variavel da funcao
		return idade;
	}
	
	public double validaPeso() {
		boolean valida = false;
		
		while (!valida) {
			try {
				peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Peso:"));
				
				if (peso != 0) {
					valida = true;
				} else {
					JOptionPane.showMessageDialog(null, "Valor de Peso incorreto");
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Por favor, informe um peso");
			}
		}
		
		return peso;
	}
	
	// Funcao valida CPF
	public String validaCPF() {
		char findDot = '.', findDash = '-';
		boolean validate = false;
		
		while (!validate) {
			try {
				cpf = JOptionPane.showInputDialog(null, "Entre com CPF:\nExemplo: 123.456.789-01");

				if (cpf != null && cpf.length() == 14) {
					if (cpf.charAt(3) == findDot && cpf.charAt(7) == findDot && 
						cpf.charAt(11) == findDash) {
						
						validate = true;
					} else {
						JOptionPane.showMessageDialog(null, "Formato de CPF incorreto");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Este eh um CPF invalido");
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Por favor, tente novamente");
			}
		}
		return cpf;
	}
	
	// Valida valor de Salario
	public double validaSalario() {
		// Define condicao de validacao
		boolean valida = false;
		
		// Enquanto nao corresponder, executa
		while (!valida) {
			try {
				// Valor de entrada do Usuario. Por se tratar de Double,
				// um valor diferente de numeros ira gerar um erro
				salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Salario R$:\nEx: 9.99"));
				
				// Confere valor negativo
				if (salario < 0) {
					JOptionPane.showMessageDialog(null, "Salario nao pode ser negativo");
				} else {
					// Senao valida
					valida = true;
				}
			} catch (Exception ex) {
				// Trata erro e exibe mensagem para usuario e desenvolvedor
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Informe um numero de Salario");
			}
		}
		// Retorna variavel
		return salario;
	}
	
	public String validaCEP() {
		char findDash = '-';
		boolean validate = false;
		
		while (!validate) {
			try {
				cep = JOptionPane.showInputDialog(null, "Entre com CEP:\nExemplo: 12345-678");
	
				if (cep != null && cep.length() == 9) {
					if (cep.charAt(5) == findDash) {
						
						validate = true;
					} else {
						JOptionPane.showMessageDialog(null, "Formato de CEP incorreto");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Este eh um CEP invalido");
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Por favor, tente novamente");
			}
		}
		return cep;
	}
	
	public String validaCNPJ() {
		char findBar = '/', findDot = '.', findDash = '-';
		boolean validate = false;
		
		while (!validate) {
			try {
				cnpj = JOptionPane.showInputDialog(null, "Entre com CNPJ:\nExemplo: 12.345.678/9012-34");

				if (cnpj != null && cnpj.length() == 18) {
					if (cnpj.charAt(2) == findDot && cnpj.charAt(6) == findDot && 
						cnpj.charAt(10) == findBar && cnpj.charAt(15) == findDash) {
						
						validate = true;
					} else {
						JOptionPane.showMessageDialog(null, "Formato de CNPJ incorreto");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Este eh um CNPJ invalido");
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Por favor, tente novamente");
			}
		}
		
		return cnpj;
	}
	
	public String validaEstado() {
		boolean valida = false;
		
		while (!valida) {
			try {
				estado = JOptionPane.showInputDialog(null, "Estado:").toUpperCase();
				
				if (estado.length() == 2) {
					if (!estado.matches("[a-z]")) {
						
						valida = true;
					} else {
						JOptionPane.showMessageDialog(null, "Nao eh um Estado");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Entre um Estado valido\nExemplo: AZ");
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Estado nao confere");
			}
		}
		
		return estado;
	}
	
	public String validaData() {
		char findBar = '/', findDot = '.';
		boolean validate = false;
		
		while (!validate) {
			try {
				dataDiaMesAno = JOptionPane.showInputDialog(null, 
					"Entre com uma Data:\nExemplo: 99/99/9999");
				
				if (dataDiaMesAno != null && dataDiaMesAno.length() == 10) {
					if (dataDiaMesAno.charAt(2) == findBar && dataDiaMesAno.charAt(5) == findBar ||
							dataDiaMesAno.charAt(2) == findDot && dataDiaMesAno.charAt(5) == findDot) {
						
						validate = true;
						break;
					} else {
						JOptionPane.showMessageDialog(null, "Formato de Data incorreta");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Esta eh uma Data invalida");
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				System.out.println("Erro de Sistema");
			}
		}
		
		return dataDiaMesAno;
	}
	
	public char validaSexo() {
		// Condicao de validacao
		boolean valida = false;
		
		// Enquanto condicao nao corresponder
		while (!valida) {
			try {
				// Captura char de entrada de Usuario
				sexo = JOptionPane.showInputDialog(null, "Sexo:\n[M] Masculino\n[F] Feminino")
					.toLowerCase().charAt(0);
				// Caso entrada de char 'M-m' ou 'F-f', será validado
				if (sexo == 'm' || sexo == 'f') {
					valida = true;
				} else {
					JOptionPane.showMessageDialog(null, "Ups... esse tipo de Sexo nao existe");
				}
			} catch (Exception ex) {
				// Exibe mensagem para usuario e erro para Desenvolvedor
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Ups... Sexo nao correponde");
			}
		}
		// Retorna variavel
		return sexo;
	}
	
	public String validaFuncao() {
		// Condicao de validacao e valor de variaveis
		boolean valida = false;
		int funcao = 0;
		String op1 = "ANALISTA DE ESTOQUE", op2 = "ANALISTA DE VENDA",
			op3 = "ENGENHEIRO LOGISTICO", op4 = "EXECUTOR DE VENDA",
			op5 = "MOTORISTA", op6 = "RECEPTOR DE ENCOMENDA", 
			op7 = "SUPERVISOR DE CARGA", op8 = "TECNICO DE EQUIPAMENTO";
		
		// Executa loop ate validacao
		while (!valida) {
			try {
				// Recebe entrada de Usuario
				funcao = Integer.parseInt(JOptionPane.showInputDialog(null, 
					"Escolha uma Funcao\n"
					+ "\n[1] " + op1
					+ "\n[2] " + op2
					+ "\n[3] " + op3
					+ "\n[4] " + op4
					+ "\n[5] " + op5
					+ "\n[6] " + op6
					+ "\n[7] " + op7
					+ "\n[8] " + op8));
				
				// O numero existente sera atribuido para cada objeto do Menu
				switch (funcao) {
					case 1:
						// Para cada opcao escolhida, sera armazenado no 
						// vetorFuncao o tipo de Funcao escolhido pelo Usuario
						tipoFuncao = op1;
						valida = true;
					break;
					case 2:
						tipoFuncao = op2;
						valida = true;
					break;
					case 3:
						tipoFuncao = op3;
						valida = true;
					break;
					case 4:
						tipoFuncao = op4;
						valida = true;
					break;
					case 5:
						tipoFuncao = op5;
						valida = true;
					break;
					case 6:
						tipoFuncao = op6;
						valida = true;
					break;
					case 7:
						tipoFuncao = op7;
						valida = true;
					break;
					case 8:
						tipoFuncao = op8;
						valida = true;
					break;
					default:
						JOptionPane.showMessageDialog(null, "Ups... entre uma opcao acima");
					break;
				}
			} catch (Exception ex) {
				// Mensagem exibida pra usuario e erro para Desenvolvedor
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Opcao incorreta");
			}
		}
		// Retorna variavel
		return tipoFuncao;
	}
	
	public String selecionaTransporte() {
		boolean valida = false;
		int opcao = 0;
		String tipo1 = "AVIAO", tipo2 = "CAMINHAO", tipo3 = "MOTO",
			tipo4 = "NAVIO", tipo5 = "VAN", escolhido = "";
		
		while (!valida) {
			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog(null, 
					"*** CADASTRO TRANSPORTE - TIPO ***\n"
					+ "\n[1] " + tipo1
					+ "\n[2] " + tipo2
					+ "\n[3] " + tipo3
					+ "\n[4] " + tipo4
					+ "\n[5] " + tipo5
				));
				
				switch (opcao) {
					case 1:
						escolhido = tipo1;
						valida = true;
						break;
					case 2:
						escolhido = tipo2;
						valida = true;
						break;
					case 3:
						escolhido = tipo3;
						valida = true;
						break;
					case 4:
						escolhido = tipo4;
						valida = true;
						break;
					case 5:
						escolhido = tipo5;
						valida = true;
						break;
					default:
						JOptionPane.showMessageDialog(null, "Informe uma opcao acima");
						break;
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Opcao nao corresponde");
			}
		}
		// Retorna valor da variavel
		return escolhido;
	}
	
	public double validaCapacidade() {
		// Define condicao de validacao
		boolean valida = false;
		
		// Enquanto nao corresponder, executa
		while (!valida) {
			try {
				// Valor de entrada do Usuario. Por se tratar de Double,
				// um valor diferente de numeros ira gerar um erro
				capacidade = Double.parseDouble(
					JOptionPane.showInputDialog(null, "Capacidade:\nEntre 5 Kg e 950 Kg"));
				
				// Confere valor negativo
				if (capacidade < 5 && capacidade < 950) {
					JOptionPane.showMessageDialog(null, "Capacidade deve ser entre 5Kg e 950 Kg");
				} else {
					// Senao valida
					valida = true;
				}
			} catch (Exception ex) {
				// Trata erro e exibe mensagem para usuario e desenvolvedor
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Informe uma Capacidade");
			}
		}
		// Retorna variavel
		return capacidade;
	}
	
	public int validaAno() {
		boolean valida = false;
		
		while (!valida) {
			try {
				ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe um Ano:\nEx.: 1999"));
				
				if (ano == 4) {
					valida = true;
				} else {
					JOptionPane.showMessageDialog(null, "Informe um Ano:\nEx.: 1999");
				}
			} catch (Exception ex) {
				// Trata erro e exibe mensagem para usuario e desenvolvedor
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Numero do Ano nao corresponde");
			}
		}
		
		return ano;
	}
	
	public double validaKilometragem() {
		boolean valida = false;
		
		while (!valida) {
			try {
				kilometragem = Double.parseDouble(JOptionPane.showInputDialog(null, "Kilometragem:"));
				
				if (kilometragem != 0) {
					valida = true;
				} else {
					JOptionPane.showMessageDialog(null, "Entre uma Kilometragem valida\nExemplo: 99.9");
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Kilometragem nao confere");
			}
		}
		return kilometragem;
	}
}
