package org.logistica.service;

public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public void criarPedido(Pedido pedido) {
        if (pedido == null){
            throw new RuntimeException("Pedido não pode ser nulo");
        }

        
    }
}
