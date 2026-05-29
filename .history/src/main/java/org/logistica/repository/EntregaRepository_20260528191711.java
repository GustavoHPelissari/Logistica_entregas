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

    public void delete(Integer id) throws SQLException {
        String command = """
                DELETE FROM entrega
                WHERE id = ?
                """;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(command)
        ) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Entrega> findAll() throws SQLException {
        List<Entrega> entregas = new ArrayList<>();
        String command = """
                SELECT id,
                    pedido_id,
                    motorista_id,
                    data_saida,
                    data_entrega,
                    status
                FROM entrega 
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command);
            ResultSet resultSet = stmt.executeQuery();
        ) {
            while (resultSet.next()) {
                Entrega entrega = extractEntrega(resultSet);
                entregas.add(entrega);
            }
        } 
        return entregas;
    }

    public List<Entrega> findEntregasAtrasadasCidade() 

    public void update(Entrega entrega) throws SQLException{
        String command = """
                UPDATE entrega 
                    SET pedido_id = ?,
                    SET motorista_id = ?,
                    SET data_saida = ?,
                    SET data_entrega = ?,
                    SET status = ?
                WHERE id = ? 
                """;
        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)
        ){
            stmt.setInt(1, entrega.getPedidoId());
            stmt.setInt(2, entrega.getMotoristaId());
            stmt.setDate(3, Date.valueOf(entrega.getDataSaida()));
            stmt.setDate(4, Date.valueOf(entrega.getDataEntrega()));
            stmt.setString(5, entrega.getStatusEntrega().toString().toString().toUpperCase());
            stmt.setInt(6, entrega.getId());

            stmt.executeUpdate();
        }
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
