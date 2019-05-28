import javax.swing.*;

public class MostrarIndicadores {
    Indicadores indicadores = new Indicadores();
    void menuIndicadores(Votacao[] votacao){
        boolean troca = true;
        int qntSecoes = 1, qntCandidatos = 1;
        int[] classificaCandidatos = new int[votacao.length-1];

        for(int i=0; i< votacao.length-1; i++){
            if(votacao[i].secaoVotacao != votacao[i+1].secaoVotacao){
                qntSecoes++;
            }
            classificaCandidatos[i] = votacao[i].numeroCandidato;
        }

        while (troca){
            troca = false;
            for(int i = 0; i<classificaCandidatos.length-1; i++){
                if(classificaCandidatos[i]>classificaCandidatos[i+1]){
                    int aux = classificaCandidatos[i];
                        classificaCandidatos[i] = classificaCandidatos[i+1];
                    classificaCandidatos[i+1] = aux;
                    troca = true;
                }
            }
        }

        for(int i = 0; i<classificaCandidatos.length-1; i++){
            if(classificaCandidatos[i] != classificaCandidatos[i+1]){
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
                    indicadores.votosPorCandidato(classificaCandidatos,candidatos);
                    break;
                case 4:
                    indicadores.rankearCandidatos(classificaCandidatos, candidatos);
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
