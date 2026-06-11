package org.logistica.view;

import java.util.ArrayList;
import java.util.List;

import org.logistica.enums.StatusPedido;
import org.logistica.model.Cliente;
import org.logistica.model.Entrega;
import org.logistica.model.Motorista;
import org.logistica.model.Pedido;
import org.logistica.service.ClienteService;
import org.logistica.service.EntregaService;
import org.logistica.service.MotoristaService;
import org.logistica.service.PedidoService;

public class MotoristaView {
    public void cadastrar() {
        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o nome do motorista: ");
        String nome = FerramentaView.sc.next();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite a cnh (apenas dígitos) : ");
        String cpf = FerramentaView.sc.next();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o veículo do motorista: ");
        String veiculo = FerramentaView.sc.next();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite a cidade base do motorista: ");
        String cidade = FerramentaView.sc.next();
        System.out.println("------------------------------------------------------------");

        Motorista motorista = new Motorista(nome,
            cpf,
            veiculo,
            cidade);
    
        var motoristaService = new MotoristaService();
        
        try {
            motoristaService.criarMotorista(motorista);
        }
        catch(Exception e) {
            System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("[ERRO] ► "+ e.getMessage());
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }
    }

    public void listar() {
        var motoristaService = new MotoristaService();

        List<Motorista> motoristas = new ArrayList<>();
        try {
            motoristas = motoristaService.listarMotoristas();
        } catch(Exception e) {
            System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("[ERRO] ► "+ e.getMessage());
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            return;
        }
        FerramentaView.exibirLista(motoristas);
    }

    public void excluir() {
        List<Pedido> pedidos = new ArrayList<>();
        List<Entrega> entregas = new ArrayList<>();
        List<Motorista> motoristas = new ArrayList<>();
        List<Integer> idsMotoristas = new ArrayList<>();

        var motoristaService = new MotoristaService();
        var pedidoService = new PedidoService();
        var entregaService = new EntregaService();
        
        try{
            motoristas = motoristaService.listarMotoristas();
            pedidos = pedidoService.listarPedidos();
            entregas = entregaService.listarEntregas();
        } catch(Exception e){
            e.printStackTrace();
        }

        for(Motorista motorista : motoristas){
            idsMotoristas.add(motorista.getId());
        }

        FerramentaView.exibirLista(pedidos);

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o id do motorista que deseja excluir: ");
        Integer idMotorista = FerramentaView.sc.nextInt();
        FerramentaView.sc.nextLine();
        System.out.println("------------------------------------------------------------");

        if (!FerramentaView.checkIdExists(idMotorista, idsMotoristas)) return;

        for(Motorista motorista : motoristas){
            if (motorista.getId().equals(idMotorista)) {
                for(Entrega entrega : entregas){
                    if (entrega.getMotoristaId().equals(motorista.getId())) {
                        for(Pedido pedido : pedidos){
                            if (pedido.getId().equals(entrega.getPedidoId())) {
                                pedido.setStatusPedido(StatusPedido.PENDENTE);
                                try{
                                    pedidoService.atualizarPedido(pedido);
                                } catch(Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }
                        try{
                            entregaService.excluirEntrega(entrega.getId());
                        } catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }
                try{
                    motoristaService.excluirMotorista(idMotorista);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
