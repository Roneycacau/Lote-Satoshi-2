public class Estatistica {
    int codCidade;
    String nomeCidade;
    int quandidadeAcidente;
    int tipoVeiculo;


    Estatistica(){
        this(0,"",0,0);
    }

    public Estatistica(int codCidade, String nomeCidade, int quandidadeAcidente, int tipoVeiculo) {
        this.codCidade = codCidade;
        this.nomeCidade = nomeCidade;
        this.quandidadeAcidente = quandidadeAcidente;
        this.tipoVeiculo = tipoVeiculo;
    }
}
