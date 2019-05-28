import javax.swing.*;

public class MostrarIndicadores {
    Indicadores indicadores = new Indicadores();
    void menuIndicadores(Votacao[] votacao){
        int qntSecoes = 1, qntCandidatos = 0;
        for(int i=0; i< votacao.length-1; i++){
            if(votacao[i].secaoVotacao != votacao[i+1].secaoVotacao){
                qntSecoes++;
            }
            if(votacao[i].numeroCandidato != votacao[i+1].numeroCandidato){
                qntCandidatos++;
            }
        }
        int[][] secoes = new int[2][qntSecoes];
        int[][] candidatos = new int[2][qntCandidatos];

        int opc = 0;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção\n" +
                    "[1]Quantidade Eleitores por Seção\n" +
                    "[2]Seção com Maior e Menor número de Eleitores  \n" +
                    "[3]Quantidade de votos por candidato\n" +
                    "[4]10 primeiros colocadas (nro  cand. e qtd votos)\n" +
                    "[9]Voltar para o menu principal"));

            switch (opc){

                case 1:
                    indicadores.calcularEleitores(votacao, secoes);
                    break;
                case 2:
                    indicadores.classificarSecao(votacao, secoes);
                    break;
                case 3:
                    indicadores.votosPorCandidato(votacao,candidatos);
                    break;
                case 4:
                    indicadores.rankearCandidatos(votacao, candidatos);
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
