package org.logistica.enums;

public enum StatusEntrega {
    EM_ROTA,
    ENTREGUE,
    ATRASADA;

    public static StatusEntrega extractStatus(String status) {
        String statusConvertido = status.toUpperCase();

        if (statusConvertido.equals("EM_ROTA")) {
            return StatusPedido.EM_ROTA;
        }
        else if (statusConvertido.equals("ENTREGUE")) {
            return StatusPedido.ENTREGUE;
        }
        else if (statusConvertido.equals("CANCELADO")) {
            return StatusPedido.ATRASADA;
        }
        else {
            return StatusPedido.PENDENTE;
        }
    }
}
