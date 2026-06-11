package org.logistica.view;

import org.logistica.model.Motorista;

public class MotoristaView {
    public void cadastrar() {
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
}
