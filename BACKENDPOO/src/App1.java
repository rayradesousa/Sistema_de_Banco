package src;

import src.model.ContaCorrente;
import src.model.ContaPoupança;

import src.utils.DataUtil;

public class App1 {
    
    public static void main(String[] args) {
        System.out.println("Criando nosso Banco Digital");
        System.out.println();

        ContaCorrente conta = new ContaCorrente("0001", "7542", 5, 100.0);
        System.out.println("Saldo altura de R$ " + conta.getSaldo());
        System.out.println();
        
        conta.depositar(250.0);
        System.out.println("Saldo atual de R$ " + conta.getSaldo());
        System.out.println();

        conta.sacar(150.0);
        System.out.println("Saldo atual de R$ " + conta.getSaldo());
        System.out.println();

        ContaPoupança conta2 = new ContaPoupança("0001", "7543", 6, 200.0);

        conta2.transferir(100.0, conta);
        System.out.println("Saldo conta destino de R$ " + conta2.getSaldo());
        System.out.println();
        
        System.out.println("Saldo atual de R$ " + conta.getSaldo());
        System.out.println();

        System.out.println(conta2.getDataAbertura());

         
        String f1 = DataUtil.converterDateParaDataHora(conta2.getDataAbertura());
        String f2 = DataUtil.converterDateParaData(conta2.getDataAbertura());
        String f3 = DataUtil.converterDateParaHora(conta2.getDataAbertura());
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);

        //Extrato bacario é composto por movimentacoes bancarias.
        //Ter algo que possa ser a movimentação.
        //Ter uma lista de movimentacoes
      
        //Conta corrente
        conta.imprimirExtrato();
        System.out.println();
       
        //Conta poupança
        System.out.println();
        conta2.imprimirExtrato();
       
  
        }

    }

