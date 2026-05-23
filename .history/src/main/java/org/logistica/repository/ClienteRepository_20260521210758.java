package org.logistica.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            PreparedStatement stmt = conn.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf_cnpj());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getCidade());
            stmt.setString(5, cliente.getEstado());

            int numLinhas = stmt.executeUpdate();

            ResultSet resultSet = stmt.getGeneratedKeys();
            cliente.
        } 
    }

    private static Cliente extractCliente(ResultSet resultSet) throws SQLException {
        return new Cliente(resultSet.getInt, null, null, null, null, null)
    }
}
