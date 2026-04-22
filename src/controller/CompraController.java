package controller;

import usecase.CalcularTotalUseCase;

import java.util.HashMap;
import java.util.Map;

public class CompraController {

    private final CalcularTotalUseCase calcularTotalUseCase;

    public CompraController(CalcularTotalUseCase calcularTotalUseCase) {
        this.calcularTotalUseCase = calcularTotalUseCase;
    }

    public Map<String, Object> calcularTotal(Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            Double valor = (Double) request.get("valor");
            String tipoCliente = (String) request.get("tipo_cliente");

            if (valor == null) {
                response.put("erro", "Valor inválido");
                response.put("status_code", 400);
                return response;
            }

            double valorFinal = calcularTotalUseCase.executar(valor, tipoCliente);

            response.put("valor_original", valor);
            response.put("tipo_cliente", tipoCliente);
            response.put("valor_final", valorFinal);
            response.put("status_code", 200);

        } catch (IllegalArgumentException e) {
            response.put("erro", e.getMessage());
            response.put("status_code", 400);
        } catch (Exception e) {
            response.put("erro", e.getMessage());
            response.put("status_code", 500);
        }

        return response;
    }
}
