package org.logistica.main;

import java.util.Scanner;

public class MenuLogistica {

    public static Scanner sc = new Scanner(System.in);

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
                    
                    break;
                case 3:
                    
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
        
    }
}
