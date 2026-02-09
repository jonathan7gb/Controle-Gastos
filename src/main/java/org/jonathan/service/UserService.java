package org.jonathan.service;

import org.jonathan.domain.dto.UserDTO.UserRequestDTO;
import org.jonathan.domain.entities.User;
import org.jonathan.domain.mapper.UserMapper;
import org.jonathan.repository.UserRepository;
import org.jonathan.view.helpers.MessageHelper;
import org.jonathan.view.menu.LoginView;

import java.sql.SQLException;

public class UserService {

        LoginView loginView = new LoginView();
        UserRepository userRepository = new UserRepository();

    public User login(UserRequestDTO userRequestDTO){
        User user =  null;

        do {
            userRequestDTO = loginView.login();

            try {
                user = userRepository.searchUserByEmailAndPassword(userRequestDTO.getEmail(), userRequestDTO.getPassword());

                if (user == null) {
                    MessageHelper.error("Credenciais inválidas. Tente Novamente");
                } else {
                    MessageHelper.success("Logado com sucesso.");
                }
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao buscar os dados!");
            }

        }while(user == null);

        return user;
    }
}
