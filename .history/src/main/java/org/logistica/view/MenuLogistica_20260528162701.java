package org.logistica.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
                    
                    break;
                case 6:
                    atualizarStatusEntrega();
                    break;
                case 7:
                    
                    break;
                case 8:
                    
                    break;
                case 9:
                    
                    break;
                case 10:
                    
                    break;
                case 11:
                    
                    break;
                case 12:
                    
                    break;
                case 13:
                    
                    break;
                case 14:
                    
                    break;
                case 15:
                    
                    break;
                case 16:
                    
                    break;
                default:
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

    public static void cadastrarCliente() {
        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o nome do cliente: ");
        String nome = sc.next();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o cpf/cnpj do cliente (apenas dígitos) : ");
        String cpf = sc.next();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o endereço do cliente: ");
        String endereco = sc.next();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite a cidade do cliente: ");
        String cidade = sc.next();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o estado do cliente: ");
        String estado = sc.next();
        System.out.println("------------------------------------------------------------");

        Cliente cliente = new Cliente(nome, 
            cpf, 
            endereco, 
            cidade, 
            estado);
    
        try {
            clienteService.criarCliente(cliente);
        }
        catch(Exception e) {
            System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("[ERRO] ► "+ e.getMessage());
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }
    }

    public static void cadastrarMotorista() {
        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o nome do motorista: ");
        String nome = sc.next();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite a cnh (apenas dígitos) : ");
        String cpf = sc.next();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o veículo do motorista: ");
        String veiculo = sc.next();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite a cidade base do motorista: ");
        String cidade = sc.next();
        System.out.println("------------------------------------------------------------");

        Motorista motorista = new Motorista(nome,
            cpf,
            veiculo,
            cidade);
    
        try {
            motoristaService.criarMotorista(motorista);
        }
        catch(Exception e) {
            System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("[ERRO] ► "+ e.getMessage());
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }
    }

    public static void cadastrarPedido() {
        List<Cliente> clientes =  new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
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

        
        try {
            pedidoService.criarPedido(pedido);
        } catch(Exception e) {
            System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("[ERRO] ► "+ e.getMessage());
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }
    }

    public static void cadastrarEntrega(){
        List<Pedido> pedidos = new ArrayList<>();
        List<Integer> idsPedidos = new ArrayList<>();
        List<Motorista> motoristas = new ArrayList<>();
        List<Integer> idsMotoristas = new ArrayList<>();

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

        exibirLista(pedidos);

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o id do pedido: ");
        Integer idPedido = sc.nextInt();
        sc.nextLine();
        System.out.println("------------------------------------------------------------");

        if(!checkIdExists(idPedido, idsPedidos)) return;

        exibirLista(motoristas);

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o id do motorista: ");
        Integer idMotorista = sc.nextInt();
        sc.nextLine();
        System.out.println("------------------------------------------------------------");

        if(!checkIdExists(idMotorista, idsMotoristas)) return;

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

        
    }

    public static void atualizarStatusEntrega() {
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

        exibirEnums(2);

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o id do novo status: ");
        Integer idStatus = sc.nextInt();
        sc.nextLine();
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

    private static void exibirLista(List<?> lista) {
        if (lista == null) {
            System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("[ERRO] ► Nenhum elemento cadastrado encontrado");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }

        if (lista.get(0) instanceof Cliente) {
            System.out.println("\n\n============================================================");
            System.out.println("                      👤👤 CLIENTES 👤👤");
            System.out.println("============================================================");
            for(Object obj : lista) {
                Cliente cliente = (Cliente) obj;
                System.out.println("["+cliente.getId()+"] - "+cliente.getNome());
                System.out.println("[CPF/CNPJ] ► "+cliente.getCpf_cnpj());
                System.out.println("[ENDEREÇO] ► "+cliente.getEndereco());
                System.out.println("[CIDADE] ► "+cliente.getCidade());
                System.out.println("[ESTADO] ► "+cliente.getEstado());
                System.out.println("============================================================");
            }
        }
        if (lista.get(0) instanceof Motorista) {
            System.out.println("\n\n============================================================");
            System.out.println("                   🚴🚴 MOTORISTAS 🚴🚴");
            System.out.println("============================================================");
            for(Object obj : lista) {
                Motorista motorista = (Motorista) obj;
                System.out.println("["+motorista.getId()+"] - "+motorista.getNome());
                System.out.println("[CNH] ► "+motorista.getCnh());
                System.out.println("[VEÍCULO] ► "+motorista.getVeiculo());
                System.out.println("[CIDADE-BASE] ► "+motorista.getCidadeBase());
                System.out.println("============================================================");
            }
        }
        if (lista.get(0) instanceof Pedido) {
            System.out.println("\n\n============================================================");
            System.out.println("                    🏍️🏍️ PEDIDOS 🏍️🏍️");
            System.out.println("============================================================");
            for(Object obj : lista) {
                Pedido pedido = (Pedido) obj;
                System.out.println("["+pedido.getId()+"]");
                System.out.println("[ID_CLIENTE] ► "+pedido.getIdCliente());
                System.out.println("[VOLUME] ► "+pedido.getVolumeM3()+"m³");
                System.out.println("[PESO] ► "+pedido.getId()+"kg");
                System.out.println("[DATA-PEDIDO] ► "+pedido.getDataPedido());
                System.out.println("[STATUS ATUAL] ► "+pedido.getStatusPedido());
                System.out.println("============================================================");
            }
        }
        if (lista.get(0) instanceof Entrega) {
            System.out.println("\n\n============================================================");
            System.out.println("                    📋📋 ENTREGAS 📋📋");
            System.out.println("============================================================");
            for(Object obj : lista) {
                Entrega entrega = (Entrega) obj;
                System.out.println("["+entrega.getId()+"]");
                System.out.println("[ID_PEDIDO] ► "+entrega.getPedidoId());
                System.out.println("[ID_MOTORISTA] ► "+entrega.getMotoristaId());
                System.out.println("[DATA-SAÍDA] ► "+entrega.getDataSaida());
                System.out.println("[DATA-ENTREGA] ► "+entrega.getDataEntrega());
                System.out.println("[STATUS] ► "+entrega.getStatusEntrega());
                System.out.println("============================================================");
            }
        }
        if (lista.get(0) instanceof HistoricoEntrega) {
            System.out.println("\n\n============================================================");
            System.out.println("             🗺️🗺️ HISTÓRICO DE ENTREGAS 🗺️🗺️");
            System.out.println("============================================================");
            for(Object obj : lista) {
                HistoricoEntrega historico = (HistoricoEntrega) obj;
                System.out.println("["+historico.getId()+"]");
                System.out.println("[ID_ENTREGA] ► "+historico.getEntregaId());
                System.out.println("[DATA_EVENTO] ► "+historico.getDataEvento());
                System.out.println("[DESCRIÇÃO] ► "+historico.getDescricao());
                System.out.println("============================================================");
            }
        }
    }

    private static void exibirEnums(Integer index){
        if (index == 1) {
            System.out.println("\n\n============================================================");
            System.out.println("                      📊📊 STATUS PEDIDO 📊📊");
            System.out.println("============================================================");
            for(StatusPedido status : StatusPedido.values()) {
                System.out.println("["+status.ordinal()+"] - "+status.name());
                System.out.println("============================================================");
            }
        }
        if (index == 2) {
            System.out.println("\n\n============================================================");
            System.out.println("                      📊📊 STATUS ENTREGA 📊📊");
            System.out.println("============================================================");
            for(StatusEntrega status : StatusEntrega.values()) {
                System.out.println("["+status.ordinal()+"] - "+status.name());
                System.out.println("============================================================");
            }
        }
    }

    private static boolean checkIdExists(Integer index, List<Integer> list) {
        if (!list.contains(index)) {
            System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("[ERRO] ► Id "+index+" não encontrado.");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            return false;
        }
        return true;
    }
}
