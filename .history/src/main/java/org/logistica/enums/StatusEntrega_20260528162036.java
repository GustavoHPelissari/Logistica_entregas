package org.logistica.enums;

public enum StatusEntrega {
    EM_ROTA,
    ENTREGUE,
    ATRASADA,
    CANCELADA;

    public static StatusEntrega extractStatus(String status) {
        String statusConvertido = status.toUpperCase();

        if (statusConvertido.equals("EM_ROTA")) {
            return StatusEntrega.EM_ROTA;
        }
        else if (statusConvertido.equals("ENTREGUE")) {
            return StatusEntrega.ENTREGUE;
        }
        else if (statusConvertido.equals("ATRASADA")) {
            return StatusEntrega.ATRASADA;
        }
        else if (statusConvertido.equals("CANCELADA")) {
            return StatusEntrega.CANCELADA;            
        }
        else {
            return StatusEntrega.EM_ROTA;
        }
    }

    public static StatusEntrega extractStatus(Integer index){
        switch (index){
            case 1:
                return StatusEntrega.EM_ROTA;
            case 2:
                return StatusEntrega.ENTREGUE;
            case 3:
                return StatusEntrega.ATRASADA;
            case 4:
                return StatusEntrega.CANCELADA;
            default:
                return StatusEntrega.EM_ROTA;
        }
    }
}
