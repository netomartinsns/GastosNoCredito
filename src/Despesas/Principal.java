package Despesas;

import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o limite do Cartão: ");
        double limite = leitura.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        while (sair != 0) {
            System.out.println("Digite o item da compra: ");
            String item = leitura.next();

            System.out.println("Digite o valor da compra: ");
            double valor = leitura.nextDouble();

            Compra compra = new Compra(item, valor);
            boolean compraRealizada = cartao.lancamentoDeCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada com sucesso! ");
                System.out.println("Digite 0 para Sair ou 1 para Continuar: ");
                sair = leitura.nextInt();
            } else {
                System.out.println("Saldo insuficiente");
                sair = 0;

            }
        }

        System.out.println("========================================");
        System.out.println("COMPRAS REALIZADAS: \n");
        Collections.sort(cartao.getCompras());
        for (Compra c : cartao.getCompras()) {
            System.out.println(c.getItem() + " - " +c.getValor());
        }
        System.out.println("\n========================================");

        System.out.println("\nSaldo do Cartão: " +cartao.getSaldo());
    }
}
