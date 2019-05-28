import javax.swing.*;

public class MostrarIndicadores {
    Indicadores indicadores = new Indicadores();
    void menuIndicadores(Votacao[] votacao){
        int qntSecoes = 1;
        for(int i=0; i< votacao.length-1; i++){
            if(votacao[i].secaoVotacao != votacao[i+1].secaoVotacao){
                qntSecoes++;
            }
        }
        int[][] secoes = new int[2][qntSecoes];

        int opc = 0;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção"));

            switch (opc){

                case 1:
                    indicadores.calcularEleitores(votacao, secoes);
                    break;
                case 2:
                    indicadores.classificarSecao(votacao, secoes);
                    break;
                case 3:
                    indicadores.votosPorCandidato(votacao);
                    break;
                case 4:
                    indicadores.rankearCandidatos(votacao);
                    break;
                case 9:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA");
                    break;
            }

        }while(opc != 9);

    }
}
