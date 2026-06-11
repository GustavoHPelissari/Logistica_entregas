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
        System.out.println("[1]  - Cadastrar Cl");
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
}
