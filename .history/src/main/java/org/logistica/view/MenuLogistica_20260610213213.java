package org.logistica.view;

import java.util.Scanner;


public class MenuLogistica {

    private static Scanner sc = new Scanner(System.in);

    private static ClienteView  clienteView = new ClienteView();
    private static MotoristaView motoristaView = new MotoristaView();
    private static PedidoView pedidoView = new PedidoView();
    private static EntregaView entregaView = new EntregaView();
    private static HistoricoEntregaView historicoEntregaView = new HistoricoEntregaView();

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

    private static void menuCadastros() {
        boolean voltar = false;
        while (!voltar) {
            exibirMenuCadastros();

            System.out.print("[Digite sua opção]: ");
            int option = sc.nextInt();
            sc.nextLine();
            System.out.println("=-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-=");

            switch (option) {
                case 0:
                    voltar = true;
                    break;
                case 1:
                    clienteView.cadastrar();
                    break;
                case 2:
                    motoristaView.cadastrar();
                    break;
                case 3:
                    menuGerenciamento();
                    break;
                case 4:
                    menuGerenciamento();
                    break;
                case 5:
                    menuGerenciamento();
                    break;
                default:
                    System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    System.out.println("[ERRO] ► Opção inválida");
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    break;
            }
        }
    }

    private static void exibirMenuCadastros() {
        System.out.println("=-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-=");
        System.out.println("          CENTRO DE LOGISTIA DE ENTREGAS B'ACK-E'ND ");
        System.out.println("=-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-=");
        System.out.println("[1]  - Cadastrar Cliente");
        System.out.println("[2]  - Cadastrar Motorista");
        System.out.println("[3]  - Criar Pedido");
        System.out.println("[4]  - Atribuir Pedido a Motorista");
        System.out.println("[5]  - Registrar Evento de Entrega");
        System.out.println("[0]  - Voltar");
        System.out.println("=-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-=");
    }

    private static void menuRelatorios() {

    }

    private static void menuGerenciamento() {

    }
}
