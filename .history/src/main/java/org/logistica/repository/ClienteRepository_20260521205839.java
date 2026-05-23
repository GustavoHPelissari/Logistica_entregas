package org.logistica.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.logistica.config.database.ConnectionFactory;
import org.logistica.model.Cliente;

public class ClienteRepository {
    public Cliente create(Cliente cliente) throws SQLException {
        String command = """
                INSERT INTO cliente(
                        nome,
                        cpf_cnpj,
                        endereco,
                        cidade,
                        estado)
                VALUES (?,?,?,?,?)
                """;
        try(Connection  conn = ConnectionFactory.getConnection()
            PreparedStatement stmt = conn.prepareStatement(command)
            ResultSet resultSet = stmt.RETURN_GENERATED_KEYS
        ) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(1, cliente.getNome());
            stmt.setString(1, cliente.getNome());
            stmt.setString(1, cliente.getNome());
            stmt.setString(1, cliente.getNome());
        }
    }
}
