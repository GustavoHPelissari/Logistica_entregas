package org.logistica.repository;

import java.sql.Connection;

import org.logistica.config.database.ConnectionFactory;
import org.logistica.model.Cliente;

public class ClienteRepository {
    public Cliente create(Cliente cliente) {
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
            )
    }
}
