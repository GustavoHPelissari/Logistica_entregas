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
            return StatusEntrega.EM_ROTA;
        }
    }

    public static StatusEntrega extractStat(Integer index){
        switch (index){
            case 1:
                return StatusPedido.PENDENTE;
            case 2:
                return StatusPedido.ENTREGUE;
            case 3:
                return StatusPedido.CANCELADO;
            default:
                return StatusPedido.PENDENTE;
        }
    }
}
