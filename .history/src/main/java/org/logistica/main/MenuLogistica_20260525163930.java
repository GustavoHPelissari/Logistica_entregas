package org.logistica.main;

import java.util.Scanner;

public class MenuLogistica {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
    }
    
    private static void exibirMenu() {
        System.out.print("=-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-=");
        System.out.print("       Logistica ");
        System.out.print("=-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-==-<>-=");
        System.out.print("[1]  - Cadastrar Cliente");
        System.out.print("[2]  - Cadastrar Motorista");
        System.out.print("[3]  - Criar Pedido");
        System.out.print("[4]  - Atribuir Pedido a Motorista");
        System.out.print("[5]  - Registrar Evento de Entrega");
        System.out.print("[6]  - Atualizar Status da Entrega");
        System.out.print("[7]  - Listar Todas as Entregas com Cliente e Motorista");
        System.out.print("[8]  - [Relatório]: Total de Entregas por Motorista");
        System.out.print("[9]  - [Relatório]: Clientes com Maior Volume Entregue");
        System.out.print("[10] - [Relatório]: Pedidos Pendentes por Estado");
        System.out.print("[11] - [Relatório]: Entregas Atrasadas por Cidade");
        System.out.print("[12] - Buscar Pedido por CPF/CNPJ do Cliente");
        System.out.print("[13] - Cancelar Pedido");
        System.out.print("[14] - Excluir Entrega");
        System.out.print("[15] - Excluir Cliente");
        System.out.print("[16] - Excluir Motorista");
        System.out.print("[0]  - Sair");
    }
}
