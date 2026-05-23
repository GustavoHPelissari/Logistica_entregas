package org.logistica.repository;

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
        try(Conn)
    }
}
