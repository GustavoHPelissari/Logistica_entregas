package org.logistica.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.logistica.config.database.ConnectionFactory;
import org.logistica.enums.StatusPedido;
import org.logistica.model.Entrega;
import org.logistica.model.Pedido;

public class EntregaRepository {
    public Entrega create(Pedido pedido) throws SQLException {
        String command = """
                INSERT INTO pedido (
                        cliente_id,
                        data_pedido,
                        volume_m3,
                        peso_kg,
                        status)
                VALUES (?,?,?,?)
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
