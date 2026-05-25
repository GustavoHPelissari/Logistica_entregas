package org.logistica.enums;

public enum StatusPedido {
    PENDENTE,
    ENTREGUE,
    CANCELADO;

    public static StatusPedido extractStatus(String status) {
        String statusConvertido = status.toUpperCase();

        if (statusConvertido.equals("PENDENTE")) {
            return StatusPedido.PENDENTE;
        }
        else if (statusConvertido.equals("ENTREGUE")) {
            return StatusPedido.PENDENTE;
        }
        else if (statusConvertido.e) {
            
        }
    }
}
