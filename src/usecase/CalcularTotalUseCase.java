package usecase;

import domain.Compra;
import repository.CompraConfigRepository;

public class CalcularTotalUseCase {

    private final CompraConfigRepository configRepository;

    public CalcularTotalUseCase(CompraConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    public double executar(double valor, String tipoCliente) {
        Compra compra = new Compra(valor, tipoCliente);
        return compra.calcular(
            configRepository.getDescontoVip(),
            configRepository.getDescontoAdicional(),
            configRepository.getLimiarDescontoAdicional(),
            configRepository.getValorMinimo()
        );
    }
}
