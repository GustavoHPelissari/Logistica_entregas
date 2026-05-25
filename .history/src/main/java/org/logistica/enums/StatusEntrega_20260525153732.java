package org.logistica.enums;

public enum StatusEntrega {
    EM_ROTA,
    ENTREGUE,
    ATRASADA;

    public static StatusEntrega extractStatus(String status) {
        String statusConvertido = status.toUpperCase();

        if (statusConvertido.equals("EM_ROTA")) {
            return StatusEntrega.EM_ROTA;
        }
        else if (statusConvertido.equals("ENTREGUE")) {
            return StatusEntrega.ENTREGUE;
        }
        else if (statusConvertido.equals("CANCELADO")) {
            return StatusEntrega.ATRASADA;
        }
        else {
            return StatusPedido.EM_ROTA;
        }
    }
}
