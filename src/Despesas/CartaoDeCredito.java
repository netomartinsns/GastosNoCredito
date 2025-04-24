package Despesas;

import java.util.ArrayList;
import java.util.List;

public class CartaoDeCredito {
    private double limiteDisponivel;
    private double saldo;
    private List<Compra> compras;

    public CartaoDeCredito(double limiteDisponivel) {
        this.limiteDisponivel = limiteDisponivel;
        this.saldo = limiteDisponivel;
        this.compras = new ArrayList<>();
    }

    public boolean lancamentoDeCompra(Compra compra) {
        if (this.saldo > compra.getValor()) {
            this.saldo -= compra.getValor();
            this.compras.add(compra);
            return  true;
        }

        return false;
    }

    public double getLimiteDisponivel() {
        return limiteDisponivel;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getCompras() {
        return compras;
    }
}
