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
            pedidos =  pedidoRepository.findAll();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return pedidos;
    }

    public List<Pedido> listarPedidosPendentesEstado(String estado){
        List<Pedido> pedidos = new ArrayList<>();
        try{
            pedidos = pedidoRepository.findPedidosPendentesEstado(estado);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return pedidos;
    }

    public List<Pedido> listarPedidosPorCpfCnpjCliente(String cpfCnpj){
        List<Pedido> pedidos = new ArrayList<>();
        try{
            pedidos = pedidoRepository.findPedidosCpfCnpj(cpfCnpj);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return pedidos;
    }

    public void atualizarPedido(Pedido pedido){
        if (pedido == null){
            throw new RuntimeException("Pedido não pode ser nulo");
        }
        try{
            pedidoRepository.update(pedido);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirPedido(Integer id){
        try{
            pedidoRepository.delete(id);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    private void validarVolume(Double volume){
        if (volume == null || volume <= 0) {
            throw new RuntimeException("VOlume deve ser maior que zero");
        }
    }
}
