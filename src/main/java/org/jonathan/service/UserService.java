package org.jonathan.service;

import org.jonathan.domain.dto.UserDTO.UserRequestDTO;
import org.jonathan.domain.entities.User;
import org.jonathan.domain.mapper.UserMapper;
import org.jonathan.repository.UserRepository;
import org.jonathan.view.helpers.MessageHelper;
import org.jonathan.view.menu.LoginView;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class UserService {

        LoginView loginView = new LoginView();
        UserRepository userRepository = new UserRepository();

    public User login(UserRequestDTO userRequestDTO){
        User user =  null;

            try {
                user = userRepository.searchUserByEmailAndPassword(userRequestDTO.getEmail(), userRequestDTO.getPassword());

                if (user == null) {
                    MessageHelper.error("Credenciais inválidas. Tente Novamente\n");

                } else {
                    MessageHelper.success("Logado com sucesso.\n");
                }
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao buscar os dados!");
            }


        return user;
    }

    public User createUser(UserRequestDTO userRequestDTO){
        User user = null;

        if(userRequestDTO == null){
            MessageHelper.error("Erro ao criar usuário!\n");
        }else {
            try {
                user = userRepository.createUser(userRequestDTO);

                if(user != null){
                    MessageHelper.success("Usuário criado com sucesso.\n");
                }
            }catch (SQLIntegrityConstraintViolationException e){
                MessageHelper.error("Usuário não cadastrado, verifique as informações inseridas. Tente Novamente\n");
            }catch (SQLException e){
                throw new RuntimeException("Erro ao salvar dados no banco");
            }
        }

        return user;
    }

    public User findUserById(Long id){
        User user = null;

        try{
            user = userRepository.findUserById(id);

            if(user == null){
                MessageHelper.error("Usuário não encontrado! Tente novamente.\n");
            }
        }catch (SQLException e){
            throw new RuntimeException("Erro ao retornar dados do banco");
        }
        return user;
    }
}
