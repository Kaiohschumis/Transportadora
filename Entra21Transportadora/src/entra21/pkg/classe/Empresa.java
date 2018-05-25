package entra21.pkg.classe;

import javax.swing.JOptionPane;

public class Empresa{
    public void cadastroEmpresa(){
    
    int tamanho = 100;
    int atuall = 0;
    String[] cnpjs = new String[tamanho];
    String[] razaoSocials = new String[tamanho];
    String[] nomeFantasias = new String[tamanho];
    String[] enderecos = new String[tamanho];
    String[] bairros = new String[tamanho];
    String[] cidades = new String[tamanho];
    String[] estados = new String[tamanho];
    String[] ceps = new String[tamanho];
    
    cnpjs[atuall] = JOptionPane.showInputDialog(null, "CNPJ da empresa");
    razaoSocials[atuall] = JOptionPane.showInputDialog(null, "Razão Social");
    nomeFantasias[atuall] = JOptionPane.showInputDialog(null, "Nome Fantasia");
    enderecos[atuall] = JOptionPane.showInputDialog(null, "Endereço");
    bairros[atuall] = JOptionPane.showInputDialog(null, "Bairros");
    cidades[atuall] = JOptionPane.showInputDialog(null, "Cidades");
    estados[atuall] = JOptionPane.showInputDialog(null, "Estados");
    ceps[atuall] = JOptionPane.showInputDialog(null, "CEP");
    
        
    }
    }