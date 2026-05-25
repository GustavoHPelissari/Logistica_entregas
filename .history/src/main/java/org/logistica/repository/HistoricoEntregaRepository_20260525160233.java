package org.logistica.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.logistica.config.database.ConnectionFactory;
import org.logistica.enums.StatusEntrega;
import org.logistica.model.Entrega;
import org.logistica.model.HistoricoEntrega;

public class HistoricoEntregaRepository {
    public HistoricoEntrega store(HistoricoEntrega historicoEntrega) throws SQLException {
        String command = """
                INSERT INTO historico_entrega (
                        entrega_id,
                        data_evento,
                        descrisao)
                VALUES (?,?,?)
                """;
        try(Connection  conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setInt(1, historicoEntrega.getEntregaId());
            stmt.setDate(2, Date.valueOf(historicoEntrega.getDataEvento()));
            stmt.setString(3, historicoEntrega.getDescrisao());

            int numLinhas = stmt.executeUpdate();

            if (numLinhas > 1) {
                ResultSet resultSet = stmt.getGeneratedKeys();
                historicoEntrega = extractHistoricoEntrega(resultSet);
            }

            return historicoEntrega;
        }     

    }

    private static Entrega extractHistoricoEntrega(ResultSet resultSet) throws SQLException {
        return new HistoricoEntrega(
            resultSet.getInt("id"),
            resultSet.getInt("entrega_id"),
            resultSet.getDate("data_evento").toLocalDate()
        )
        );
    }
}
