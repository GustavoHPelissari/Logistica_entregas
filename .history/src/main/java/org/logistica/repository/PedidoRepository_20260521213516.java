package org.logistica.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            stmt.setInt(0, 0);

            int numLinhas = stmt.executeUpdate();

            if (numLinhas > 1) {
                ResultSet resultSet = stmt.getGeneratedKeys();
                cliente = extractCliente(resultSet);
            }

            return cliente;
        }     
    }
}
