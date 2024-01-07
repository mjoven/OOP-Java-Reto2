package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.*;
import org.springframework.stereotype.Repository;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.Set;


@Getter
@Setter
public class UsuarioJDBCRepo implements IUsuarioRepository {
    private String db_url;


    @Override
    public Usuario crear(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario values (NULL,?,?,?,?)";
        try (

                Connection conn = DriverManager.getConnection(db_url);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            usuario.valido();
            stmt.setBoolean(1, usuario.isActivo());
            stmt.setDate(2, Date.valueOf(usuario.getAlta()));
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getNombre());
            int rows = stmt.executeUpdate();

            ResultSet genKeys = stmt.getGeneratedKeys();
            if (genKeys.next()) {
                usuario.setId(genKeys.getInt(1));
            } else {
                throw new SQLException("NO ID asignado");

            }

        } catch (UsuarioException e) {
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e);
        }
        return usuario;
    }


    @Override
    public Usuario actualizar(Usuario usuario) throws SQLException {
        return null;
    }

    @Override
    public boolean borrar(Usuario usuario) throws SQLException {
        return false;
    }

    @Override
    public Set<Usuario> obtenerPosiblesDestinatarios(Integer id, Integer max) throws SQLException {
        return null;
    }

    @Override
    public Usuario getById(int Id) throws SQLException {
        Usuario usuario;
        String sql = "SELECT * FROM usuario where id = ?";
        try (

                Connection conn = DriverManager.getConnection(db_url);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, Id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"),
                        rs.getDate("alta").toLocalDate(), rs.getBoolean("activo"));

            } else {
                throw new SQLException("ID no encontrado");

            }

        } catch (UsuarioException e) {
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e);
        }
        return usuario;
    }
}