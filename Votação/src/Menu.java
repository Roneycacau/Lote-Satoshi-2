import javax.swing.*;
import java.io.IOException;

public class Menu {
    public static void main(String[] args) throws IOException {
        Votacao[] votacao = new Votacao[100];
        Votacao2016 votacao2016 = new Votacao2016();
        MostrarIndicadores menuIndicadores = new MostrarIndicadores();
        int opc = 0;
        String menssagem;

        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção"));

            switch (opc){
                case 1:
                    votacao = votacao2016.registarVoto(votacao);
                    JOptionPane.showMessageDialog(null,"Votação finalizada!");
                    break;
                case 2:
                    menssagem = votacao2016.classificarRegistro(votacao);
                    JOptionPane.showMessageDialog(null, menssagem);
                    break;
                case 3:
                    menssagem = votacao2016.gravarVotacao(votacao);
                    JOptionPane.showMessageDialog(null, menssagem);
                    break;
                case 4:
                    menuIndicadores.menuIndicadores(votacao);
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "FINALIZADO!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção Inválida!");
                    break;
            }
        }while (opc != 9);

    }
}
