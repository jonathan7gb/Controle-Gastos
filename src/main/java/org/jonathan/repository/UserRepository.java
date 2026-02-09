package org.jonathan.repository;

import org.jonathan.config.ConnectDB;
import org.jonathan.domain.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class UserRepository {

    public User searchUserByEmailAndPassword(String email, String password) throws SQLException{
        String sql = """
                SELECT id, nome, data_criacao
                FROM usuarios
                WHERE email = ? AND senha = ?;
                """;

        User user = null;

        try(Connection conn = ConnectDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                Long id = rs.getLong(1);
                String name = rs.getString(2);
                LocalDateTime creationDate = (LocalDateTime) rs.getObject( 3);
                user = new User(id, name, email, password, creationDate);
            }
        }
        return user;
    }
}
