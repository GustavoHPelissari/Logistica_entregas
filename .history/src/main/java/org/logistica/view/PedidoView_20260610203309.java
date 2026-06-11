package org.logistica.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.logistica.enums.StatusPedido;
import org.logistica.model.Cliente;
import org.logistica.model.Pedido;
import org.logistica.service.ClienteService;
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
        exibirLista(clientes);

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o id do cliente: ");
        Integer id = sc.nextInt();
        sc.nextLine();
        System.out.println("------------------------------------------------------------");

        if(!ids.contains(id)){
            System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("[ERRO] ► Cliente com id "+id+" não encontrado.");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            return;
        }

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o volume em m³ do pedido: ");
        Double volume = sc.nextDouble();
        sc.nextLine();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o peso em kg do pedido: ");
        Double peso = sc.nextDouble();
        sc.nextLine();
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
}
