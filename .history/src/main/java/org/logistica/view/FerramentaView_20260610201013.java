package org.logistica.view;

import java.util.List;

import org.logistica.enums.StatusEntrega;
import org.logistica.enums.StatusPedido;
import org.logistica.model.Cliente;
import org.logistica.model.Entrega;
import org.logistica.model.HistoricoEntrega;
import org.logistica.model.Motorista;
import org.logistica.model.Pedido;

public class FerramentaView {

    public static void Scanner sc = new Scanner(System.in);

    public static void exibirLista(List<?> lista) {
        if (lista == null) {
            System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("[ERRO] ► Nenhum elemento cadastrado encontrado");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }

        if (lista.get(0) instanceof Cliente) {
            System.out.println("\n\n============================================================");
            System.out.println("                      👤👤 CLIENTES 👤👤");
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
                System.out.println("[DATA-ENTREGA] ► "+entrega.getDataEntrega());
                System.out.println("[STATUS] ► "+entrega.getStatusEntrega());
                System.out.println("============================================================");
            }
        }
        if (lista.get(0) instanceof HistoricoEntrega) {
            System.out.println("\n\n============================================================");
            System.out.println("             🗺️🗺️ HISTÓRICO DE ENTREGAS 🗺️🗺️");
            System.out.println("============================================================");
            for(Object obj : lista) {
                HistoricoEntrega historico = (HistoricoEntrega) obj;
                System.out.println("["+historico.getId()+"]");
                System.out.println("[ID_ENTREGA] ► "+historico.getEntregaId());
                System.out.println("[DATA_EVENTO] ► "+historico.getDataEvento());
                System.out.println("[DESCRIÇÃO] ► "+historico.getDescricao());
                System.out.println("============================================================");
            }
        }
    }

    public static void exibirEnums(Integer index){
        if (index == 1) {
            System.out.println("\n\n============================================================");
            System.out.println("                      📊📊 STATUS PEDIDO 📊📊");
            System.out.println("============================================================");
            for(StatusPedido status : StatusPedido.values()) {
                System.out.println("["+status.ordinal()+"] - "+status.name());
                System.out.println("============================================================");
            }
        }
        if (index == 2) {
            System.out.println("\n\n============================================================");
            System.out.println("                      📊📊 STATUS ENTREGA 📊📊");
            System.out.println("============================================================");
            for(StatusEntrega status : StatusEntrega.values()) {
                System.out.println("["+status.ordinal()+"] - "+status.name());
                System.out.println("============================================================");
            }
        }
    }
}
