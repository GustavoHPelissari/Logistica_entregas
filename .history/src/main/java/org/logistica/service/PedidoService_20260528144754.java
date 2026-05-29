package org.logistica.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.logistica.model.Pedido;
import org.logistica.repository.PedidoRepository;

public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService() {
        this.pedidoRepository = new PedidoRepository();
    }

    public void criarPedido(Pedido pedido) {
        if (pedido == null){
            throw new RuntimeException("Pedido não pode ser nulo");
        }

        try{
            pedidoRepository.create(pedido);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pedido> listarPedidos(){
        List<Pedido> pedidos = new ArrayList<>();
        try{
            pedidos =  pedidoRepository.findAll()
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
