package org.logistica.view;

import java.util.ArrayList;
import java.util.List;

import org.logistica.model.Cliente;
import org.logistica.model.Motorista;
import org.logistica.service.ClienteService;
import org.logistica.service.MotoristaService;

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
        var motoristaService = new moTO();

        List<Cliente> clientes = new ArrayList<>();
        try {
            clientes = clienteService.listarClientes();
        } catch(Exception e) {
            System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("[ERRO] ► "+ e.getMessage());
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            return;
        }
        FerramentaView.exibirLista(clientes);
    }
}
