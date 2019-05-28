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
        for(int x=0;x<secoes.length; x++){
            for(int y=0; y<secoes[x].length;y++){
                System.out.print(secoes[x][y]);
            }
            System.out.println();
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

    void votosPorCandidato(Votacao[] votacao, int[][] candidatos){
        
    }

    void rankearCandidatos(Votacao[] votacao, int[][] candidatos){}




}
