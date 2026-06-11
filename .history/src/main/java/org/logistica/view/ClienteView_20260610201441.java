package org.logistica.view;

import java.util.ArrayList;
import java.util.List;

import org.logistica.model.Cliente;
import org.logistica.service.ClienteService;

public class ClienteView {

    private final ClienteService clienteService;

    public ClienteView() {
        this.clienteService = new ClienteService();
    }

    public void cadastrar() {
        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o nome do cliente: ");
        String nome = FerramentaView.sc.next();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o cpf/cnpj do cliente (apenas dígitos) : ");
        String cpf = FerramentaView.sc.next();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o endereço do cliente: ");
        String endereco = FerramentaView.sc.next();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite a cidade do cliente: ");
        String cidade = FerramentaView.sc.next();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o estado do cliente: ");
        String estado = FerramentaView.sc.next();
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

    public void listar() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            
        }
    }
}
