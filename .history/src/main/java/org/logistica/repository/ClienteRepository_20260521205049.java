package org.logistica.repository;

import org.logistica.model.Cliente;

public class ClienteRepository {
    public Cliente create(Cliente cliente) {
        String command = """
                INSERT (
                        nome,
                        cpf_cnpj,
                        endereco,
                         cidade, estado)
                """;
    }
}
