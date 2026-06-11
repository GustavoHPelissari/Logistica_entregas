package org.logistica.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.logistica.enums.StatusEntrega;
import org.logistica.enums.StatusPedido;
import org.logistica.model.Cliente;
import org.logistica.model.Entrega;
import org.logistica.model.Motorista;
import org.logistica.model.Pedido;
import org.logistica.service.ClienteService;
import org.logistica.service.EntregaService;
import org.logistica.service.MotoristaService;
import org.logistica.service.PedidoService;

public class EntregaView {
    public void criar() {
        List<Pedido> pedidos = new ArrayList<>();
        List<Integer> idsPedidos = new ArrayList<>();
        List<Motorista> motoristas = new ArrayList<>();
        List<Integer> idsMotoristas = new ArrayList<>();

        var pedidoService = new PedidoService();
        var motoristaService =  new MotoristaService();

        try{
            pedidos = pedidoService.listarPedidos();
            motoristas = motoristaService.listarMotoristas();
        } catch(Exception e) {
            e.printStackTrace();
        }
        for(Pedido pedido : pedidos) {
            idsPedidos.add(pedido.getId());
        }
        for(Motorista motorista : motoristas) {
            idsMotoristas.add(motorista.getId());
        }

        FerramentaView.exibirLista(pedidos);

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o id do pedido: ");
        Integer idPedido = FerramentaView.sc.nextInt();
        FerramentaView.sc.nextLine();
        System.out.println("------------------------------------------------------------");

        if(!FerramentaView.checkIdExists(idPedido, idsPedidos)) return;

        FerramentaView.exibirLista(motoristas);

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o id do motorista: ");
        Integer idMotorista = FerramentaView.sc.nextInt();
        FerramentaView.sc.nextLine();
        System.out.println("------------------------------------------------------------");

        if(!FerramentaView.checkIdExists(idMotorista, idsMotoristas)) return;

        Entrega entrega =  new Entrega(idPedido,
            idMotorista,
            LocalDate.now(), 
            null,
            StatusEntrega.EM_ROTA);

        var entregaService = new EntregaService();

        try{
            entregaService.criarEntrega(entrega);
        } catch(Exception e){
            System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("[ERRO] ► "+ e.getMessage());
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }
    }

    public void listar() {
        List<Entrega> entregas = new ArrayList<>();
        
        var entregaService =  new EntregaService();

        try {
            entregas = entregaService.listarEntregas();
        } catch(Exception e) {
            System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("[ERRO] ► "+ e.getMessage());
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            return;
        }

        FerramentaView.exibirLista(entregas);
    }

    public void atualizarStatus() {
        List<Entrega> entregas = new ArrayList<>();
        List<Integer> idsEntregas = new ArrayList<>();

        var entregaService = new EntregaService();

        try{
            entregas = entregaService.listarEntregas();
        } catch(Exception e) {
            e.printStackTrace();
        }
        for(Entrega entrega : entregas){
            idsEntregas.add(entrega.getId());
        }

        FerramentaView.exibirLista(entregas);

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o id da entrega: ");
        Integer idEntrega = FerramentaView.sc.nextInt();
        FerramentaView.sc.nextLine();
        System.out.println("------------------------------------------------------------");

        if (!FerramentaView.checkIdExists(idEntrega, idsEntregas)) return;

        FerramentaView.exibirEnums(2);

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o id do novo status: ");
        Integer idStatus = FerramentaView.sc.nextInt();
        FerramentaView.sc.nextLine();
        System.out.println("------------------------------------------------------------");

        Entrega entrega = null;

        for(Entrega entrada : entregas) {
            if (entrega.getId().equals(idEntrega)) {
                entrega = entrada;
            }
        }

        entrega.setStatusEntrega(StatusEntrega.extractStatus(idStatus));

        entregaService.atualizarEntrega(entrega);
    }

    public void excluir() {
        List<Pedido> pedidos = new ArrayList<>();
        List<Entrega> entregas = new ArrayList<>();
        List<Integer> idsEntregas = new ArrayList<>();

        var pedidoService = new PedidoService();
        var entregaService = new EntregaService();

        try{
            pedidos = pedidoService.listarPedidos();
            entregas = entregaService.listarEntregas();
        } catch(Exception e){
            e.printStackTrace();
        }

        for(Entrega entrega : entregas){
            idsEntregas.add(entrega.getId());
        }

        FerramentaView.exibirLista(pedidos);

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o id da entrega que deseja excluir: ");
        Integer idEntrega = FerramentaView.sc.nextInt();
        FerramentaView.sc.nextLine();
        System.out.println("------------------------------------------------------------");

        if (!FerramentaView.checkIdExists(idEntrega, idsEntregas)) return;

        for(Entrega entrega : entregas){
            if (entrega.getId().equals(idEntrega)) {
                for(Pedido pedido : pedidos){
                    if (pedido.getId().equals(entrega.getId())) {
                        pedido.setStatusPedido(StatusPedido.PENDENTE);
                        try{
                            pedidoService.atualizarPedido(pedido);
                        } catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }
                try{
                    entregaService.excluirEntrega(idEntrega);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void listarEntregasClienteMotorista() {
        List<Entrega> entregas = new ArrayList<>();
        List<Pedido> pedidos =  new ArrayList<>();
        List<Motorista> motoristas = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();

        var entregaService = new EntregaService();
        var pedidoService = new PedidoService();
        var motoristaService = new MotoristaService();
        var clienteService = new ClienteService();

        try{
            entregas = entregaService.listarEntregas();
            pedidos = pedidoService.listarPedidos();
            motoristas = motoristaService.listarMotoristas();
            clientes = clienteService.listarClientes();
        }catch(Exception e){
            e.printStackTrace();
        }

        if (entregas == null) {
            System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("[ERRO] ► Nenhum elemento cadastrado encontrado");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            return;
        }

        System.out.println("\n\n============================================================");
        System.out.println("       👤👤 ENTREGAS COM CLIENTES E MOTORISTAS 👤👤");
        System.out.println("============================================================");
    
        for(Entrega entrega : entregas){
            System.out.println("["+entrega.getId()+"]");
            System.out.println("[ID_PEDIDO] ► "+entrega.getPedidoId());
            for(Motorista motorista : motoristas){
                if (motorista.getId().equals(entrega.getMotoristaId())) {
                    System.out.println("[MOTORISTA] ► "+motorista.getNome());
                    System.out.println("[MOTORISTA-CNH] ► "+motorista.getCnh());
                }
            }
            for(Pedido pedido : pedidos){
                if (pedido.getId().equals(entrega.getPedidoId())) {
                    for(Cliente cliente : clientes){
                        if (cliente.getId().equals(pedido.getId())) {
                            System.out.println("[CLIENTE] ► "+cliente.getNome());
                            System.out.println("[CLIENTE-CPF/CNPJ] ► "+cliente.getCpf_cnpj());
                        }
                    }
                }
            }
            System.out.println("[DATA-SAÍDA] ► "+entrega.getDataSaida());
            System.out.println("[DATA-ENTREGA] ► "+entrega.getDataEntrega());
            System.out.println("[STATUS] ► "+entrega.getStatusEntrega());
            System.out.println("============================================================");
        }
    }

    public void listarEntregras() {
        List<Motorista> motoristas = new ArrayList<>();
        List<Entrega> entregas = new ArrayList<>();
        List<Integer> idsMotoristas = new ArrayList<>();

        var motoristaService = new MotoristaService();
        var entregaService = new EntregaService();

        try{
            motoristas = motoristaService.listarMotoristas();
            entregas = entregaService.listarEntregas();
        } catch(Exception e){
            e.printStackTrace();
        }

        for(Motorista motorista : motoristas){
            idsMotoristas.add(motorista.getId());
        }

        exibirLista(motoristas);

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o id do motorista: ");
        Integer idMotorista = sc.nextInt();
        sc.nextLine();
        System.out.println("------------------------------------------------------------");

        if (!checkIdExists(idMotorista, idsMotoristas)) return;

        System.out.println("\n\n============================================================");
        System.out.println("                   LISTA DE ENTREGAS POR MOTORISTAS");
        System.out.println("============================================================");
    
        for(Motorista motorista : motoristas){
            Integer totalMotorista = 0;
            System.out.println("["+motorista.getId()+"] - "+motorista.getNome());
            System.out.println("[ENTREGAS] ▼ ");
            for(Entrega entrega : entregas){
                if (entrega.getMotoristaId().equals(motorista.getId())) {
                    System.out.println("    ["+entrega.getId()+"] - [STATUS]: "+entrega.getStatusEntrega());
                    totalMotorista++;
                }
            }
            System.out.println("[TOTAL DE ENTREGAS] ► "+totalMotorista);
            System.out.println("============================================================");
        }
    }
}
