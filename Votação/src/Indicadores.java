import javax.swing.*;

public class Indicadores {

    void calcularEleitores(Votacao[] votacao, int[][] secoes){
        int secao = 0, votos = 1;
        String msgsecao = "SEÇÃO:", msgvoto = "VOTOS:";

        for (int i=0; i<votacao.length; i++){
            if(i+1>=votacao.length){
                if(votacao[i-1].secaoVotacao == votacao[i].secaoVotacao){
                    msgvoto += " |" + String.format("%02d",(votos+1)) + "|";
                    secoes[1][secao] = votos+1;
                    votos = 1;

                    msgsecao += " |" + String.format("%02d",votacao[i].secaoVotacao) + "|";
                    secoes[0][secao] = votacao[i].secaoVotacao;

                }
            }else if(votacao[i].secaoVotacao != votacao[i+1].secaoVotacao){
                msgvoto += " |" + String.format("%02d",votos) + "|";
                secoes[1][secao] = votos;
                votos = 1;

                msgsecao += " |" + String.format("%02d",votacao[i].secaoVotacao) + "|";
                secoes[0][secao] = votacao[i].secaoVotacao;

                secao++;

                secoes[1][secao] = 1;
            }else{
                votos++;
            }


        }

        JOptionPane.showMessageDialog(null,msgsecao + "\n" + msgvoto);
        System.out.println(msgsecao);
        System.out.println(msgvoto);
    }

    void classificarSecao(Votacao[] votacao, int[][] secoes){
        int maior = secoes[1][0];
        int menor = secoes[1][0];
        String msgMaior = "Seção com menor número de votos: " + secoes[0][0]+ " (" + secoes[1][0] + ")";
        String msgMenor = "Seção com menor número de votos: " + secoes[0][0]+ " (" + secoes[1][0] + ")";
        for(int i=1;i<secoes[1].length;i++){
            if(secoes[1][i] <= menor){
                menor = secoes[1][i];
                msgMenor = "Seção com menor número de votos: " + secoes[0][i] + " (" + menor + ")";
            }

            if(secoes[1][i] >= maior){
                maior = secoes[1][i];
                msgMaior = "Seção com maior número de votos: " + secoes[0][i] + " (" + maior + ")";
            }
        }
        JOptionPane.showMessageDialog(null, msgMaior + "\n" + msgMenor);

    }

    void votosPorCandidato(int[] classificaCandidato, int[][] candidatos){

        int candidato = 0, votos = 1;
        String msgCandidato = "CANDIDATO:", msgvoto = "NUM VOTOS:";

        for (int i=0; i<classificaCandidato.length; i++){
            if(i+1>=classificaCandidato.length){
                if(classificaCandidato[i-1] == classificaCandidato[i]){
                    msgvoto += " |" + String.format("%03d",(votos+1)) + "|";
                    candidatos[1][candidato] = votos+1;
                    votos = 1;

                    msgCandidato += " |" + String.format("%03d",classificaCandidato[i]) + "|";
                    candidatos[0][candidato] = classificaCandidato[i];

                }
            }else if(classificaCandidato[i] != classificaCandidato[i+1]){
                msgvoto += " |" + String.format("%03d",votos) + "|";
                candidatos[1][candidato] = votos;
                votos = 1;

                msgCandidato += " |" + String.format("%03d",classificaCandidato[i]) + "|";
                candidatos[0][candidato] = classificaCandidato[i];

                candidato++;

                candidatos[1][candidato] = 1;
            }else{
                votos++;
            }


        }


        JOptionPane.showMessageDialog(null,msgCandidato + "\n" + msgvoto);
        System.out.println(msgCandidato);
        System.out.println(msgvoto);
    }

    void rankearCandidatos(int[] classificaCandidato, int[][] candidatos){
        boolean troca = true;
        int auxVoto, auxCandidato;
        String msgCandidato = "CANDIDATO:", msgvoto = "NUM VOTOS:";

        while (troca){
            troca = false;
            for(int i = candidatos[0].length-1; i>0; i--){
                if(candidatos[1][i]>candidatos[1][i-1]){

                    auxCandidato = candidatos[0][i];
                    auxVoto = candidatos[1][i];

                    candidatos[0][i] = candidatos[0][i-1];
                    candidatos[1][i] = candidatos[1][i-1];

                    candidatos[0][i-1] = auxCandidato;
                    candidatos[1][i-1] = auxVoto;

                    troca = true;
                }
            }
        }

        System.out.println();

        for(int y=0; y<=10;y++){
            msgCandidato += " [" + String.format("%03d", candidatos[0][y])+ "]";
        }
        for(int y=0; y<=10;y++){
            msgvoto += " [" + String.format("%03d", candidatos[1][y])+ "]";
        }

        for(int x=0;x<candidatos.length; x++){
            for(int y=0; y<=10;y++){
                System.out.print(" [" + String.format("%03d", candidatos[x][y])+ "]");
            }
            System.out.println();
        }

        JOptionPane.showMessageDialog(null, msgCandidato + "\n" + msgvoto);
    }




}
