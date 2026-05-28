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
        else if (statusConvertido.equals("CANCELADO")) {
            return StatusPedido.CANCELADO;
        }
        else {
            return StatusPedido.PENDENTE;
        }
    }

    public static StatusPedido extractStatus(Integer index){
        switch (index){
            case 1:
                return StatusPedido.PENDENTE;
            case 2:
                return StatusPedido.
        }
    }
}
