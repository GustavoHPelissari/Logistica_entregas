package org.logistica.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.logistica.enums.StatusPedido;
import org.logistica.model.Cliente;
import org.logistica.model.Entrega;
import org.logistica.model.Pedido;
import org.logistica.service.ClienteService;
import org.logistica.service.EntregaService;
import org.logistica.service.PedidoService;

public class PedidoView {
    public void criar() {
        List<Cliente> clientes =  new ArrayList<>();
        List<Integer> ids = new ArrayList<>();

        var clienteService =  new ClienteService();

        try{
            clientes = clienteService.listarClientes();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        for(Cliente cliente : clientes){
            ids.add(cliente.getId());
        }
        FerramentaView.exibirLista(clientes);

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o id do cliente: ");
        Integer id = FerramentaView.sc.nextInt();
        FerramentaView.sc.nextLine();
        System.out.println("------------------------------------------------------------");

        if(!ids.contains(id)){
            System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("[ERRO] ► Cliente com id "+id+" não encontrado.");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            return;
        }

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o volume em m³ do pedido: ");
        Double volume = FerramentaView.sc.nextDouble();
        FerramentaView.sc.nextLine();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o peso em kg do pedido: ");
        Double peso = FerramentaView.sc.nextDouble();
        FerramentaView.sc.nextLine();
        System.out.println("------------------------------------------------------------");

        Pedido pedido = new Pedido(id, 
            LocalDate.now(), 
            volume, 
            peso, 
            StatusPedido.PENDENTE);

        var pedidoService = new PedidoService();

        try {
            pedidoService.criarPedido(pedido);
        } catch(Exception e) {
            System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("[ERRO] ► "+ e.getMessage());
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }
    }

    public void listar() {
        List<Pedido> pedidos = new ArrayList<>();

        var pedidoService = new PedidoService();

        try{
            pedidos = pedidoService.listarPedidos();
        } catch(Exception e) {
            System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("[ERRO] ► "+ e.getMessage());
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            return;
        }

        FerramentaView.exibirLista(pedidos);
    }

    public void cancelar() {
        List<Pedido> pedidos = new ArrayList<>();
        List<Entrega> entregas = new ArrayList<>();
        List<Integer> idsPedidos = new ArrayList<>();

        var pedidosService = new PedidoService();
        var entregaService = new EntregaService();

        try{
            pedidos = pedidosService.listarPedidos();
            entregas = entregaService.listarEntregas();
        } catch(Exception e){
            e.printStackTrace();
        }

        for(Pedido pedido : pedidos){
            idsPedidos.add(pedido.getId());
        }

        FerramentaView.exibirLista(pedidos);

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o id do pedido que deseja cancelar: ");
        Integer id = FerramentaView.sc.nextInt();
        FerramentaView.sc.nextLine();
        System.out.println("------------------------------------------------------------");
    
        if (!FerramentaView.checkIdExists(id, idsPedidos)) return;
        Pedido pedido = null;
        
        for(Pedido entrada : pedidos){
            if (entrada.getId().equals(id)) {
                pedido = entrada;
            }
        }

        pedido.cancelarPedido();

        for(Entrega entrega : entregas){
            if (entrega.getPedidoId().equals(pedido.getId())) {
                entrega.cancelarEntrega();
                try{
                    entregaService.atualizarEntrega(entrega);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

        var pedidoService = new 

        try{
            pedidoService.atualizarPedido(pedido);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
