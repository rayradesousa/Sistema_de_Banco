package src.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

public abstract class ContaBancaria {

    //#region atributos
    
    protected String agencia;

    protected String conta;

    protected Integer digito;

    protected Double saldo;

    protected Date dataAbertura;

    protected ArrayList<Movimentacao> movimentacoes;

    protected Double VALOR_MINIMO_DEPOSITO = 10.0;

    //#endregion


    //#region construtores

    public ContaBancaria(String agencia, String conta, Integer digito, Double saldoInicial) {
        this.agencia = agencia;
        this.conta = conta;
        this.digito = digito;
        this.saldo = saldoInicial;
        this.dataAbertura = new Date();
        //Se não instanciar, vai dar uma exception de nullPointerException
        this.movimentacoes = new ArrayList<Movimentacao>();

        //Criando a primeira movimentaçã.
        Movimentacao movimentacao = new Movimentacao("Abertura de conta", saldoInicial);

        //Aqui estou salvando a movinetação dentro do meu array de movimentação
        //Aqui estou iniciando o meu extrato bancario.
        this.movimentacoes.add(movimentacao);
    }

    //#endregion

    //#region
    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Integer getDigito() {
        return digito;
    }

    public void setDigito(Integer digito) {
        this.digito = digito;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
    //#endregion

    //#region Metodos

    public void depositar(Double valor){
        //Verificar se o valor de deposito é menos que o valor minimo
        //Se for não pode acontecer deposito.
        if(valor < VALOR_MINIMO_DEPOSITO){
            throw new InputMismatchException("O valor minimo de deposito é R$" + VALOR_MINIMO_DEPOSITO);
        }
        //Efetua o deposito somando o valor ao saldo
        this.saldo += valor;

        //Aqui faço uma movimentação no extrato
        Movimentacao movimentacao = new Movimentacao("Deposito", valor);
        this.movimentacoes.add(movimentacao);
    }

    public Double sacar(Double valor){
     
        if(valor >  this.saldo){
         throw new InputMismatchException("O saldo é insuficiente");
        }
        this.saldo -= valor;

        //Aqui faço uma movimentação no extrato
        Movimentacao movimentacao = new Movimentacao("Retirada de valor", valor);
        this.movimentacoes.add(movimentacao);

        return valor;
    }

    public void transferir(Double valor, ContaBancaria contaDestino){   

        this.sacar(valor);

        contaDestino.depositar(valor);
    }

    //#endregion Metodos

    //Metodo abstrato obriga as classes que estão herdando de implementarem esta metodo
    public abstract void imprimirExtrato();
    
}
