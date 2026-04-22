package domain;

public class Compra {

    private final double valor;
    private final String tipoCliente;

    public Compra(double valor, String tipoCliente) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }
        this.valor = valor;
        this.tipoCliente = tipoCliente;
    }

    public double calcular(double descontoVip, double descontoAdicional, double limiarDescontoAdicional, double valorMinimo) {
        double total = valor;

        if ("VIP".equals(tipoCliente)) {
            total = total * (1 - descontoVip);
        }

        if (valor > limiarDescontoAdicional) {
            total = total * (1 - descontoAdicional);
        }

        if (total < valorMinimo) {
            total = valorMinimo;
        }

        return Math.round(total * 100.0) / 100.0;
    }

    public double getValor() {
        return valor;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }
}
