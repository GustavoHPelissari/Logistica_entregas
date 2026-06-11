package org.logistica.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.logistica.enums.StatusEntrega;
import org.logistica.enums.StatusPedido;
import org.logistica.model.Cliente;
import org.logistica.model.Entrega;
import org.logistica.model.HistoricoEntrega;
import org.logistica.model.Motorista;
import org.logistica.model.Pedido;
import org.logistica.service.ClienteService;
import org.logistica.service.EntregaService;
import org.logistica.service.HistoricoEntregaService;
import org.logistica.service.MotoristaService;
import org.logistica.service.PedidoService;

public class MenuLogistica {

    public static Scanner sc = new Scanner(System.in);
    public static ClienteService clienteService = new ClienteService();
    public static MotoristaService motoristaService = new MotoristaService();
    public static PedidoService pedidoService = new PedidoService();

    public static void main(String[] args) {
        boolean encessarSessao = false;
        while (!encessarSessao) {
            exibirMenu();

            System.out.print("[Digite sua opção]: ");
            int option = sc.nextInt();
            sc.nextLine();
            System.out.println("=-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-=");

            switch (option) {
                case 0:
                    encessarSessao = true;
                    break;
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarMotorista();
                    break;
                case 3:
                    cadastrarPedido();
                    break;
                case 4:
                    cadastrarEntrega();
                    break;
                case 5:
                    cadastrarEventoEntrega();
                    break;
                case 6:
                    atualizarStatusEntrega();
                    break;
                case 7:
                    listarEntregasClienteMotorista();
                    break;
                case 8:
                    relatarEntregasPorMotorista();
                    break;
                case 9:
                    relatarClientesMaiorVolumeEntregue();
                    break;
                case 10:
                    relatarPedidosPendentesPorEstado();
                    break;
                case 11:
                    relatarEntregasAtrasadasPorCidade();
                    break;
                case 12:
                    relatarPedidoPorCpfCnpjCliente();
                    break;
                case 13:
                    cancelarPedido();
                    break;
                case 14:
                    excluirEntrega();
                    break;
                case 15:
                    excluirCliente();
                    break;
                case 16:
                    excluirMotorista();
                    break;
                default:
                    System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    System.out.println("[ERRO] ► Opção inválida");
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    break;
            }
        }
    }
    
    private static void exibirMenu() {
        System.out.println("=-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-=");
        System.out.println("          CENTRO DE LOGISTIA DE ENTREGAS B'ACK-E'ND ");
        System.out.println("=-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-=");
        System.out.println("[1]  - Cadastrar Cliente");
        System.out.println("[2]  - Cadastrar Motorista");
        System.out.println("[3]  - Criar Pedido");
        System.out.println("[4]  - Atribuir Pedido a Motorista");
        System.out.println("[5]  - Registrar Evento de Entrega");
        System.out.println("[6]  - Atualizar Status da Entrega");
        System.out.println("[7]  - Listar Todas as Entregas com Cliente e Motorista");
        System.out.println("[8]  - [Relatório]: Total de Entregas por Motorista");
        System.out.println("[9]  - [Relatório]: Clientes com Maior Volume Entregue");
        System.out.println("[10] - [Relatório]: Pedidos Pendentes por Estado");
        System.out.println("[11] - [Relatório]: Entregas Atrasadas por Cidade");
        System.out.println("[12] - Buscar Pedido por CPF/CNPJ do Cliente");
        System.out.println("[13] - Cancelar Pedido");
        System.out.println("[14] - Excluir Entrega");
        System.out.println("[15] - Excluir Cliente");
        System.out.println("[16] - Excluir Motorista");
        System.out.println("[0]  - Sair");
        System.out.println("=-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-=");
    }

    public static void cadastrarEventoEntrega(){
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

        exibirLista(entregas);

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o id da entrega: ");
        Integer idEntrega = sc.nextInt();
        sc.nextLine();
        System.out.println("------------------------------------------------------------");

        if (!checkIdExists(idEntrega, idsEntregas)) return;

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite a descrição do evento: ");
        String descricao = sc.nextLine();
        System.out.println("------------------------------------------------------------");

        HistoricoEntrega historicoEntrega = new HistoricoEntrega(idEntrega,
             null, 
             descricao);

        var historicoEntregaService = new HistoricoEntregaService();

        try{
            historicoEntregaService.criarHistoricoEntrega(historicoEntrega);
        } catch(Exception e){
            System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("[ERRO] ► "+ e.getMessage());
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }
    }

    public static void listarEntregasClienteMotorista() {
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

    public static void relatarEntregasPorMotorista(){
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

    public static void relatarClientesMaiorVolumeEntregue(){
        Map<Cliente, Double> rankingClientes = new LinkedHashMap<>();
        var clienteService = new ClienteService();

        try{
            rankingClientes = clienteService.listarClientesVolumeMaisAlto();
        } catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("\n\n============================================================");
        System.out.println("      🏆🏆RANKING CLIENTES MAIOR VOLUME ENTREGUE🏆🏆");
        System.out.println("============================================================");

        int i = 1;

        for(Map.Entry<Cliente, Double> entrada : rankingClientes.entrySet()){
            System.out.println("["+i+"°] ► "+entrada.getKey().getNome());
            System.out.println("[TOTAL VOLUME ENTREGUE] ► "+entrada.getValue()+"m³");
            System.out.println("============================================================");
            i++;
        }
    }

    public static void relatarPedidosPendentesPorEstado(){
        List<Pedido> pedidos = new ArrayList<>();

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o estado do Brasil que deseja procurar (ex: SC, SP): ");
        String estado = sc.nextLine();
        System.out.println("------------------------------------------------------------");
    
        var pedidoService = new PedidoService();

        try{
            pedidos = pedidoService.listarPedidosPendentesEstado(estado.toUpperCase());
        } catch(Exception e) {
            e.printStackTrace();
        }

        exibirLista(pedidos);
    }

    public static void  relatarEntregasAtrasadasPorCidade(){
        List<Entrega> entregas = new ArrayList<>();

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite a cidade que deseja procurar: ");
        String cidade = sc.nextLine();
        System.out.println("------------------------------------------------------------");
    
        var entregaService = new EntregaService();

        try{
            entregas = entregaService.listarEntregasAtrasadasPorCidade(cidade);
        } catch(Exception e){
            e.printStackTrace();
        }

        exibirLista(entregas);
    }

    public static void relatarPedidoPorCpfCnpjCliente(){
        List<Cliente> clientes = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();

        var clienteService = new ClienteService();

        try{
            clientes = clienteService.listarClientes();
        } catch(Exception e){
            e.printStackTrace();
        }

        exibirLista(clientes);

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o cpf ou cnpj para procurar: ");
        String cidade = sc.nextLine();
        System.out.println("------------------------------------------------------------");
    
        var pedidoService = new PedidoService();

        try{
            pedidos = pedidoService.listarPedidosPorCpfCnpjCliente(cidade);
        } catch(Exception e){
            e.printStackTrace();
        }

        exibirLista(pedidos);
    }
}
