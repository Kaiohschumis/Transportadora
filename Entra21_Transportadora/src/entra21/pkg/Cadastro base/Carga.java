import javax.swing.JOptionPane;

public class Carga{
    public static void main(String[] args){
    
    int tamanho = 100;
    int atual = 0;
    String[] idsCarga = new String[tamanho];
    double[] pesos = new double[tamanho];
    String[] origens = new String[tamanho];
    String[] destinos = new String[tamanho];
    int[] kms = new int[tamanho];
    double[] prices = new double[tamanho];
    String[] descricao = new String[tamanho];
    
    idsCarga[atual] = JOptionPane.showInputDialog(null, "Digite o id da carga");
    pesos[atual] = Double.parseDouble(JOptionPane.showInputDialog(null, "Tipo de encomenda"));
    origens[atual] = JOptionPane.showInputDialog(null, "Origem da carga");
    destinos[atual] = JOptionPane.showInputDialog(null, "Destino da carga");
    kms[atual] = Integer.parseInt(JOptionPane.showInputDialog(null, "Quilometragem até destino"));
    prices[atual] = Double.parseDouble(JOptionPane.showInputDialog(null, "Valor da carga"));
    descricao[atual] = JOptionPane.showInputDialog(null, "Descrição" + "\n*opcional");
    

    
    }
    }
















