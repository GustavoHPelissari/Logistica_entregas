package org.logistica.view;

import java.util.ArrayList;
import java.util.List;

import org.logistica.model.Cliente;
import org.logistica.model.Entrega;
import org.logistica.model.Pedido;
import org.logistica.service.ClienteService;
import org.logistica.service.EntregaService;
import org.logistica.service.PedidoService;

public class ClienteView {

    public void cadastrar() {
        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o nome do cliente: ");
        String nome = FerramentaView.sc.next();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o cpf/cnpj do cliente (apenas dígitos) : ");
        String cpf = FerramentaView.sc.next();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o endereço do cliente: ");
        String endereco = FerramentaView.sc.next();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite a cidade do cliente: ");
        String cidade = FerramentaView.sc.next();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o estado do cliente: ");
        String estado = FerramentaView.sc.next();
        System.out.println("------------------------------------------------------------");

        Cliente cliente = new Cliente(nome, 
            cpf, 
            endereco, 
            cidade, 
            estado);
    
        var clienteService = new ClienteService();

        try {
            clienteService.criarCliente(cliente);
        }
        catch(Exception e) {
            System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("[ERRO] ► "+ e.getMessage());
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }
    }

    public void listar() {
        var clienteService = new ClienteService();

        List<Cliente> clientes = new ArrayList<>();
        try {
            clientes = clienteService.listarClientes();
        } catch(Exception e) {
            System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("[ERRO] ► "+ e.getMessage());
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            return;
        }
        FerramentaView.exibirLista(clientes);
    }

    public void excluir() {
        List<Pedido> pedidos = new ArrayList<>();
        List<Entrega> entregas = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<Integer> idsClientes = new ArrayList<>();

        var clienteService = new ClienteService();
        var pedidoService = new PedidoService();
        var entregaService = new EntregaService();
        
        try{
            clientes = clienteService.listarClientes();
            pedidos = pedidoService.listarPedidos();
            entregas = entregaService.listarEntregas();
        } catch(Exception e){
            e.printStackTrace();
        }

        for(Cliente cliente : clientes){
            idsClientes.add(cliente.getId());
        }

        FerramentaView.exibirLista(pedidos);

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o id do cliente que deseja excluir: ");
        Integer idCliente = FerramentaView.sc.nextInt();
        FerramentaView.sc.nextLine();
        System.out.println("------------------------------------------------------------");

        if (!checkIdExists(idCliente, idsClientes)) return;

        for(Cliente cliente : clientes){
            if (cliente.getId().equals(idCliente)) {
                for(Pedido pedido : pedidos){
                    if (pedido.getIdCliente().equals(cliente.getId())) {
                        for(Entrega entrega : entregas){
                            if (entrega.getPedidoId().equals(pedido.getId())) {
                                try{
                                    entregaService.excluirEntrega(entrega.getId());
                                } catch(Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }
                        try{
                            pedidoService.excluirPedido(pedido.getId());
                        } catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }
                try{
                    clienteService.deletarCliente(cliente.getId());
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
