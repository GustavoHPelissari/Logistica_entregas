package org.logistica.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.logistica.config.database.ConnectionFactory;
import org.logistica.enums.StatusPedido;
import org.logistica.model.Entrega;
import org.logistica.model.Pedido;

public class PedidoRepository {
    public Pedido create(Pedido pedido) throws SQLException {
        String command = """
                INSERT INTO pedido (
                        cliente_id,
                        data_pedido,
                        volume_m3,
                        peso_kg,
                        status)
                VALUES (?,?,?,?,?)
                """;
        try(Connection  conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setInt(1, pedido.getIdCliente());
            stmt.setDate(2,Date.valueOf(pedido.getDataPedido()));
            stmt.setDouble(3, pedido.getVolumeM3());
            stmt.setDouble(4, pedido.getPesoKG());
            stmt.setString(5, pedido.getStatusPedido()
                .toString().toUpperCase());

            int numLinhas = stmt.executeUpdate();

            if (numLinhas > 1) {
                ResultSet resultSet = stmt.getGeneratedKeys();
                pedido = extractPedido(resultSet);
            }

            return pedido;
        }     

    }

    public List<Pedido> findAll() throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();
        String command = """
                SELECT id,
                    cliente_id,
                    data_pedido,
                    volume_m3,
                    peso_kg,
                    status
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command);
            ResultSet resultSet = stmt.executeQuery();
        ) {
            while (resultSet.next()) {
                Pedido pedido = extractPedido(resultSet);
                pedidos.add(pedido);
            }
        }

        return pedidos;
    }

    public List<Pedido> findPedidosPendentesEstado(String estado) throws SQLException{
        List<Pedido> pedidos = new ArrayList<>();
        String command = """
                SELECT P.id,
                    P.cliente_id,
                    P.data_pedido,
                    P.volume_m3,
                    P.peso_kg,
                    P.status
                FROM pedido P
                INNER JOIN cliente C ON P.cliente_id = C.id
                WHERE P.status = 'PENDENTE' AND C.estado = ?
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)
        ){
            stmt.setString(1, estado);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Pedido pedido = extractPedido(resultSet);
                pedidos.add(pedido);
            }
        } 

        return pedidos;
    }

    public List<Pedido> findPedidosCpfCnpj(String cpfCnpj) throws SQLException {
       List<Pedido> pedidos = new ArrayList<>();
        String command = """
                SELECT P.id,
                    P.cliente_id,
                    P.data_pedido,
                    P.volume_m3,
                    P.peso_kg,
                    P.status
                FROM pedido P
                INNER JOIN cliente C ON P.cliente_id = C.id
                WHERE C.cpf_cnpj = ?
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)
        ){
            stmt.setString(1, cpfCnpj);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Pedido pedido = extractPedido(resultSet);
                pedidos.add(pedido);
            }
        } 

        return pedidos; 
    }

    public void update(Pedido pedido) throws SQLException{
        String command = """
                UPDATE entrega 
                    SET cliente_id = ?,
                    SET data_pedido = ?,
                    SET volume_m3 = ?,
                    SET peso_kg = ?,
                    SET status = ?
                WHERE id = ? 
                """;
        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)
        ){
            stmt.setInt(1, pedido.getIdCliente());
            stmt.setDate(2 null);

            stmt.executeUpdate();
        }
    }

    public void delete(Integer id) throws SQLException {
        String command = """
                DELETE FROM pedido
                WHERE id = ?
                """;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(command)
        ) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private static Pedido extractPedido(ResultSet resultSet) throws SQLException {
        return new Pedido(resultSet.getInt("id"),
         resultSet.getInt("cliente_id"), 
         resultSet.getDate("data_pedido").toLocalDate(), 
         resultSet.getDouble("volume_m3"), 
         resultSet.getDouble("peso_kg"),
         StatusPedido.extractStatus(resultSet.getString("status"))
        );
    }
}
