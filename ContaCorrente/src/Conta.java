public class Conta {
    int codConta;
    String nomeCliente;
    double saldo;
    double limite;
    int tipoConta;

    Conta(){
        this(0,"",0.0,0.0,0);
    }

    Conta(int codConta,String nomeCliente, double saldo, double limite, int tipoConta){
        this.codConta = codConta;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
        this.limite = limite;
        this.tipoConta = tipoConta;
    }

    String saque(double valor){
        if(valor<=saldo){
            saldo -= valor;
            return "Saque Efetuado com Sucesso!";
        }else if(valor>saldo && valor <= limite){
            saldo -= valor;
            limite += saldo;
            return "Saque efetuado";
        }else{
            return "Saque não realizado, saldo insuficiente.";
        }
    }

    String deposito (double valor){
        saldo += valor;
        return "Deposito efetuado";
    }

}
