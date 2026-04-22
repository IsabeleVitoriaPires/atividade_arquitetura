package repository;

public class CompraConfigRepository {

    public double getDescontoVip() {
        return 0.10;
    }

    public double getDescontoAdicional() {
        return 0.05;
    }

    public double getLimiarDescontoAdicional() {
        return 100.0;
    }

    public double getValorMinimo() {
        return 10.0;
    }
}
