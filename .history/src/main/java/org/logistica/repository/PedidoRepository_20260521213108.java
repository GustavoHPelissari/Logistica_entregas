package org.logistica.repository;

import java.sql.SQLException;

import org.logistica.model.Pedido;

public class PedidoRepository {
    public Pedido create(Pedido pedido) throws SQLException {
        String command = """
                INSERT INTO motorista (
                        nome,
                        cnh,
                        veiculo,
                        cidade_base)
                VALUES (?,?,?,?)
                """;
    }
}
