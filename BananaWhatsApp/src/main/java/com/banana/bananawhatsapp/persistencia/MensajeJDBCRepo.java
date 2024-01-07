package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.exceptions.MensajeException;
import com.banana.bananawhatsapp.modelos.Mensaje;
import com.banana.bananawhatsapp.modelos.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.List;


@Getter
@Setter

public class MensajeJDBCRepo implements IMensajeRepository {
    private String db_url;


    @Override
    public Mensaje crear(Mensaje mensaje) throws SQLException {
        String sql = "INSERT INTO mensaje values (NULL,?,?,?,?)";
        try (

                Connection conn = DriverManager.getConnection(db_url);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            mensaje.valido();

            stmt.setString(1, mensaje.getCuerpo());
            stmt.setDate(2, Date.valueOf(mensaje.getFecha()));
            int remi = mensaje.getRemitente().getId();
            int dest = mensaje.getDestinatario().getId();
            stmt.setInt(3, remi);
            stmt.setInt(4, dest);
            int rows = stmt.executeUpdate();

            ResultSet genKeys = stmt.getGeneratedKeys();
            if (genKeys.next()) {
                mensaje.setId(genKeys.getInt(1));
            } else {
                throw new SQLException("NO ID asignado");

            }

        } catch (MensajeException e) {
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e);
        }
        return mensaje;
    }

    @Override
    public List<Mensaje> obtener(Usuario usuario) throws SQLException {
        return null;
    }

    @Override
    public boolean borrarTodos(Usuario usuario) throws SQLException {
        return false;
    }

    //@Override
    //public Usuario getById() {
    //    return null;
    //}


}
