package org.logistica.enums;

public enum StatusEntrega {
    EM_ROTA,
    ENTREGUE,
    ATRASADA;

    public static StatusEntrega extractStatus(String status) {
        String statusConvertido = status.toUpperCase();

        if (statusConvertido.equals("EM_ROTA")) {
            return StatusPedido.E;
        }
        else if (statusConvertido.equals("ENTREGUE")) {
            return StatusPedido.PENDENTE;
        }
        else if (statusConvertido.equals("CANCELADO")) {
            return StatusPedido.CANCELADO;
        }
        else {
            return StatusPedido.PENDENTE;
        }
    }
}
