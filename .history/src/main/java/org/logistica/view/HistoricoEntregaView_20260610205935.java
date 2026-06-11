package org.logistica.view;

import java.util.ArrayList;
import java.util.List;

import org.logistica.model.Entrega;
import org.logistica.model.HistoricoEntrega;
import org.logistica.service.EntregaService;
import org.logistica.service.HistoricoEntregaService;

public class HistoricoEntregaView {
    public void registrar() {
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

        FerramentaView.exibirLista(entregas);

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite o id da entrega: ");
        Integer idEntrega = FerramentaView.sc.nextInt();
        FerramentaView.sc.nextLine();
        System.out.println("------------------------------------------------------------");

        if (!FerramentaView.checkIdExists(idEntrega, idsEntregas)) return;

        System.out.println("\n\n------------------------------------------------------------");
        System.out.println("• Digite a descrição do evento: ");
        String descricao = FerramentaView.sc.nextLine();
        System.out.println("------------------------------------------------------------");

        HistoricoEntrega historicoEntrega = new HistoricoEntrega(idEntrega,
             null, 
             descricao);

        var historicoEntregaService = new HistoricoEntregaService();

        try{
            historicoEntregaService.criarHistoricoEntrega(historicoEntrega);
        } catch(Exception e){
            System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("[ERRO] ► "+ e.getMessage());
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }
    }
}
