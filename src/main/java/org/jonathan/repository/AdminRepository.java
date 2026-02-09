package org.jonathan.repository;

import org.jonathan.config.ConnectDB;
import org.jonathan.domain.dto.UserDTO.UserRequestDTO;
import org.jonathan.domain.dto.UserDTO.UserResponseDTO;
import org.jonathan.domain.entities.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdminRepository {

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

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) throws SQLException{
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
                return new UserResponseDTO(rs.getLong(1), userRequestDTO.getName(), userRequestDTO.getEmail(), LocalDate.now());
            }
        }
        return null;
    }

    public UserResponseDTO findUserById(Long id) throws SQLException{
        String sql = """
                SELECT nome, email, data_criacao
                FROM usuarios
                WHERE id = ?;
                """;

        UserResponseDTO user = null;

        try(Connection conn = ConnectDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                user = new UserResponseDTO(id, rs.getString(1), rs.getString(2), rs.getDate(3).toLocalDate());
            }
        }
        return user;
    }

    public List<UserResponseDTO> showAllUsers() throws SQLException{
        String sql = """
                SELECT id, nome, email, data_criacao
                FROM usuarios
                """;

        UserResponseDTO user = null;
        List<UserResponseDTO> users = new ArrayList<>();

        try(Connection conn = ConnectDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){

            while(rs.next()){
                user = new UserResponseDTO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate() );
                users.add(user);
            }
        }

        return users;
    }
}
