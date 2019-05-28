public class Votacao {
    int secaoVotacao;
    int numeroCandidato;

    Votacao(){
        this(0,0);
    }
    Votacao(int secaoVotacao, int numeroCandidato){
        this.secaoVotacao = secaoVotacao;
        this.numeroCandidato = numeroCandidato;
    }
}
