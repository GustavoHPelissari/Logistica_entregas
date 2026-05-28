package org.logistica.view;

import java.util.List;
import java.util.Scanner;

import org.logistica.model.Cliente;
import org.logistica.model.Entrega;
import org.logistica.model.Motorista;
import org.logistica.model.Pedido;
import org.logistica.service.ClienteService;
import org.logistica.service.MotoristaService;

public class MenuLogistica {

    public static Scanner sc = new Scanner(System.in);
    public static ClienteService clienteService = new ClienteService();
    public static MotoristaService motoristaService = new MotoristaService();

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
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
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

    public void exibirLista(List<Object> lista) {
        if (lista.get(0) instanceof Cliente) {
            System.out.println("\n\n============================================================");
            System.out.println("                      ◄◄ CLIENTES ►►");
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
            System.out.println("                     🏍️🏍️ PEDIDOS 🏍️🏍️");
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
                System.out.println("[DATA-ENTREGA] ► "+entrega.getStatusEntrega() ? );
                System.out.println("[STATUS ATUAL] ► "+entrega.getStatusEntrega());
                System.out.println("============================================================");
            }
        }
    }
}
