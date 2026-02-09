package org.jonathan.repository;

import org.jonathan.config.ConnectDB;
import org.jonathan.domain.dto.UserDTO.UserRequestDTO;
import org.jonathan.domain.entities.User;

import java.sql.*;
import java.time.LocalDate;
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
                LocalDate creationDate = rs.getDate("data_criacao").toLocalDate();
                user = new User(id, name, email, password, creationDate);
            }
        }
        return user;
    }

    public User createUser(UserRequestDTO userRequestDTO) throws SQLException{
        String sql = """
                INSERT INTO usuarios(nome, email, senha)
                VALUES (?, ?, ?);
                """;

        try(Connection conn = ConnectDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, userRequestDTO.getName());
            stmt.setString(2, userRequestDTO.getEmail());
            stmt.setString(3, userRequestDTO.getPassword());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                return new User(rs.getLong(1), userRequestDTO.getName(), userRequestDTO.getEmail(), LocalDate.now());
            }
        }
        return null;
    }
}
