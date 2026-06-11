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

        validarVolume(pedido.getVolumeM3());
        validarPeso(pedido.getPesoKG());

        if (pedido.getIdCliente() == null || pedido.getIdCliente() <= 0) {
            throw new RuntimeException("Cliente inválido para o pedido");
        }

        try{
            pedidoRepository.create(pedido);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar pedido: "+e.getStackTrace());
        }
    }

    public List<Pedido> listarPedidos(){
        List<Pedido> pedidos = new ArrayList<>();
        try{
            pedidos =  pedidoRepository.findAll();
        } catch(SQLException e){
            throw new RuntimeException("Erro ao listar pedidos: "+e.)
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

    private void validarPeso(Double peso) {
        if (peso == null || peso <= 0 ) {
            throw new RuntimeException("Peso deve ser maior que zero");    
        }
    }
}
