package org.logistica.service;

import java.sql.SQLException;

public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public void criarPedido(Pedido pedido) {
        if (pedido == null){
            throw new RuntimeException("Pedido não pode ser nulo");
        }

        try{
            pedidoRepository.store(pedido);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
