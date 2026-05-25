package org.logistica.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import org.logistica.config.database.ConnectionFactory;
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
                VALUES (?,?,?,?)
                """;
        try(Connection  conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setInt(1, pedido.getIdCliente());
            stmt.setDate(2,Date.valueOf(pedido.getDataPedido()
                .toLocalDate()));
            stmt.setDouble(3, pedido.getVolumeM3());
            stmt.setDouble(4, pedido.getPesoKG());
            stmt.setString(5, pedido.getStatusPedido()
                .toString().toUpperCase());

            int numLinhas = stmt.executeUpdate();

            if (numLinhas > 1) {
                ResultSet resultSet = stmt.getGeneratedKeys();
                pedido = extractCliente(resultSet);
            }

            return cliente;
        }     
    }
}
