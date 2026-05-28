package org.logistica.service;

import java.sql.SQLException;

import org.logistica.repository.PedidoRepository;

public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService() {
        this.pedidoRepository = new PedidoRepository;
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
