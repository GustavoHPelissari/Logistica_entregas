package org.logistica.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.logistica.config.database.ConnectionFactory;
import org.logistica.model.Motorista;

public class MotoristaRepository {
    public Motorista store(Motorista motorista) throws SQLException {
        String command = """
                INSERT INTO motorista (
                        nome,
                        cnh,
                        veiculo,
                        cidade_base)
                VALUES (?,?,?,?)
                """;
        try(Connection  conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setString(1, motorista.getNome());
            stmt.setString(2, motorista.getCnh());
            stmt.setString(3, motorista.getVeiculo());
            stmt.setString(4, motorista.getCidadeBase());

            int numLinhas = stmt.executeUpdate();

            if (numLinhas > 1) {
                ResultSet resultSet = stmt.getGeneratedKeys();
                motorista = extractMotorista(resultSet);
            }

            return motorista;
        } 
    }

    public List<Motorista> listAll

    // Método de extração de usuário caso o sistema precisa escalar futuramente para mais métodos
    private static Motorista extractMotorista(ResultSet resultSet) throws SQLException {
        return new Motorista(resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("cnh"),
                        resultSet.getString("veiculo"),
                        resultSet.getString("cidade_base"));
    }
}
