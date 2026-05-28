package org.logistica.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.logistica.config.database.ConnectionFactory;
import org.logistica.enums.StatusEntrega;
import org.logistica.model.Entrega;

public class EntregaRepository {
    public Entrega store(Entrega entrega) throws SQLException {
        String command = """
                INSERT INTO entrega (
                        pedido_id,
                        motorista_id,
                        data_saida,
                        data_entrega,
                        status)
                VALUES (?,?,?,?,?)
                """;
        try(Connection  conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setInt(1, entrega.getPedidoId() );
            stmt.setInt(2, entrega.getMotoristaId());
            stmt.setDate(3,Date.valueOf(entrega.getDataSaida()));
            stmt.setDate(4,Date.valueOf(entrega.getDataEntrega()));
            stmt.setString(5, entrega.getStatusEntrega()
                .toString().toUpperCase());

            int numLinhas = stmt.executeUpdate();

            if (numLinhas > 1) {
                ResultSet resultSet = stmt.getGeneratedKeys();
                entrega = extractEntrega(resultSet);
            }

            return entrega;
        }     

    }

    public List<Entrega> listAll() throws SQLException {
        List<Entrega> entregas = new ArrayList<>();
        String command = """
                SELECT id,
                   pedido_id,
                    motorista_id,
                        data_saida,
                        data_entrega,
                        status 
                """;
    }

    private static Entrega extractEntrega(ResultSet resultSet) throws SQLException {
        return new Entrega(resultSet.getInt("id"),
         resultSet.getInt("pedido_id"),
         resultSet.getInt("motorista_id"), 
         resultSet.getDate("data_saida").toLocalDate(),
         resultSet.getDate("data_entrega").toLocalDate(), 
         StatusEntrega.extractStatus(resultSet.getString("status"))
        );
    }
}
