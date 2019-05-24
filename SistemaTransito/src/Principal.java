import javax.swing.*;
import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        Metodos metodos = new Metodos();
        int opc = 0;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("MENU ESTATÍSTICA\t\t\t|\n" +
                    " Estatísticas de acidentes em 2015\t\t\n" +
                    " 1 - Cadastro Estatística\n" +
                    " 2 - Consulta por tipo de veículo\n" +
                    " 3 - Consulta por quantidade de acidentes\n" +
                    "4 - Consulta todos as cidades\n" +
                    " 5 - Consulta maior menor média de acidentes\n" +
                    " 9 - Finaliza.\n"));

            switch (opc){
                case 1:
                    metodos.cadastraEstatistica();
                    break;
                case 2:
                    int termo = 0;
                    termo = Integer.parseInt(JOptionPane.showInputDialog("Informe o tipo do veículo que pretende buscar"));

                    System.out.println(metodos.consultarTipoVeiculo(termo));
                    break;
                case 3:
                    System.out.println("Estatísticas de cidades com quantidade de acidente entre 100 e 500" + metodos.consultarQntAcidente());
                    break;
                case 4:
                    metodos.consltarTudo();
                    break;
                case 5:
                    metodos.menorMaiorMedia();
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null,"FINALIZADO!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
            }
        }while(opc != 9);
    }
}
