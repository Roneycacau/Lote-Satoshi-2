import javax.swing.*;
import java.util.Random;

public class Metodos {
    static Estatistica[] estatisticas = new Estatistica[15];
    Random random = new Random();
    void cadastraEstatistica(){
        for(int i = 0; i < estatisticas.length; i++){
            estatisticas[i] = new Estatistica();
        }

        for (int i=0;i<estatisticas.length;i++){
            estatisticas[i].codCidade = i+1;

            estatisticas[i].nomeCidade = JOptionPane.showInputDialog("Informe o nome da Cidade");

            estatisticas[i].quandidadeAcidente = random.nextInt(1000);

            do{
                estatisticas[i].tipoVeiculo = Integer.parseInt(JOptionPane.showInputDialog("Informe o tipo de veículo: \n" +
                        "[1]Carro de Passeio\n" +
                        "[2]Moto\n" +
                        "[3]Transporte Coletivo\n" +
                        "[4]Veículo de serviço(PM, SAMU, etc)\n" +
                        "[5]Outro"));

                if(estatisticas[i].tipoVeiculo<1 || estatisticas[i].tipoVeiculo >5 ){
                    JOptionPane.showMessageDialog(null, "Tipo Inválido");
                }
            }while (estatisticas[i].tipoVeiculo<1 || estatisticas[i].tipoVeiculo >5);
        }
    }


    String consultarTipoVeiculo(int termo){
        String resultado = "";
        for (int i = 0; i<estatisticas.length; i++){
            if(termo == estatisticas[i].tipoVeiculo){
                resultado += "\n" + estatisticas[i].codCidade;
                resultado += "\n" + estatisticas[i].nomeCidade;
                resultado += "\n" + estatisticas[i].quandidadeAcidente;
                resultado+= "\n" + estatisticas[i].tipoVeiculo;
                resultado+="\n====================================";
            }
        }
        return resultado.equalsIgnoreCase("")?  "Termo informado não foi encontrado" : resultado;
    }

    String consultarQntAcidente(){
        String resultado = "";
        for(int i= 0; i<estatisticas.length;i++){
            if(estatisticas[i].quandidadeAcidente>=100 && estatisticas[i].quandidadeAcidente<=500){
                resultado += "\n" + estatisticas[i].codCidade;
                resultado += "\n" + estatisticas[i].nomeCidade;
                resultado += "\n" + estatisticas[i].quandidadeAcidente;
                resultado+= "\n" + estatisticas[i].tipoVeiculo;
                resultado+="\n====================================";
            }
        }
        return resultado;
    }

    void consltarTudo(){
        for(int i = 0; i< estatisticas.length; i++){
            System.out.println(estatisticas[i].codCidade +
                    "\n" + estatisticas[i].nomeCidade +
                    "\n" + estatisticas[i].quandidadeAcidente +
                    "\n" + estatisticas[i].tipoVeiculo +
                    "\n ===================================");
        }
    }

    void menorMaiorMedia(){
        double media = 0;
        int menor=99999999, maior=0,count = 0;
        String resultadoMenor="",resultadoMaior="", resultadoMedia="";

        for(int i = 0; i<estatisticas.length;i++){
            if(estatisticas[i].quandidadeAcidente<menor){
                resultadoMenor = estatisticas[i].codCidade +
                        "\n" + estatisticas[i].nomeCidade +
                        "\n" + estatisticas[i].quandidadeAcidente +
                        "\n" + estatisticas[i].tipoVeiculo +
                        "\n ===================================";
            }
            if(estatisticas[i].quandidadeAcidente>maior){
                resultadoMaior = estatisticas[i].codCidade +
                        "\n" + estatisticas[i].nomeCidade +
                        "\n" + estatisticas[i].quandidadeAcidente +
                        "\n" + estatisticas[i].tipoVeiculo +
                        "\n ===================================";
            }
            media += estatisticas[i].quandidadeAcidente;
        }
        media /= estatisticas.length-1;

        for(int i = 0; i<estatisticas.length;i++){
            if(estatisticas[i].quandidadeAcidente>media){
                count++;
                resultadoMedia += estatisticas[i].codCidade +
                        "\n" + estatisticas[i].nomeCidade +
                        "\n" + estatisticas[i].quandidadeAcidente +
                        "\n" + estatisticas[i].tipoVeiculo +
                        "\n ===================================\n";
            }
        }
        if (count > 0 ){
        JOptionPane.showMessageDialog(null, "Menor: \n" + resultadoMenor + "\n Maior: \n" + resultadoMaior + "\n \n    Cidades acima da média(" + String.format("%.2f",media) + ")   \n"
                + resultadoMedia);
        }else{
            JOptionPane.showMessageDialog(null, "Menor: \n" + resultadoMenor + "\n Maior: \n" + resultadoMaior + "\n \nTodas as cidades abaixo da média(" + media + ")");
        }

    }


}
