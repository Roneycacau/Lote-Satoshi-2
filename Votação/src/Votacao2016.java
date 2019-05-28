import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Votacao2016 {
    Random random = new Random();

    Votacao[] registarVoto(Votacao[] votacao){
        for (int i = 0; i<votacao.length; i++){
            votacao[i] = new Votacao();
        }

        for (int i = 0; i<votacao.length; i++){
            votacao[i].secaoVotacao = random.nextInt(10)+1;
            System.out.println(votacao[i].secaoVotacao);
            votacao[i].numeroCandidato = random.nextInt(5)+1;
            System.out.println(votacao[i].numeroCandidato);
        }
        return votacao;
    }

    String classificarRegistro(Votacao[] votacao){
        boolean troca = true;
        int aux = 0;
        while (troca){
            troca = false;
            for(int i = 0; i<votacao.length-1; i++){
                if(votacao[i].secaoVotacao>votacao[i+1].secaoVotacao){
                    aux = votacao[i].secaoVotacao;
                    votacao[i].secaoVotacao = votacao[i+1].secaoVotacao;
                    votacao[i+1].secaoVotacao = aux;
                    troca = true;
                }
            }
        }
        return "dados classificados";
    }

    String gravarVotacao(Votacao[] votacao)throws IOException {
        String filename = "Votacao2016.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        for (int i = 0; i<votacao.length; i++) {
            writer.write(Integer.toString(votacao[i].secaoVotacao));
            writer.write(", ");
            writer.write(Integer.toString(votacao[i].numeroCandidato));
            writer.newLine();
        }
        writer.close();
        return "arquivo gerado";
    }
}
