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
                    menuCadastros();
                    break;
                case 2:
                    menuRelatorios();
                    break;
                case 3:
                    menuGerenciamento();
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
        System.out.println("[1]  - CADASTROS");
        System.out.println("[2]  - RELATÓRIOS");
        System.out.println("[3]  - GERENCIAMENTO");
        System.out.println("[4]  - SAIR");
        System.out.println("=-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-=");
    }
}
