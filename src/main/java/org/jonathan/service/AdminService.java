package org.jonathan.service;

import org.jonathan.domain.dto.UserDTO.UserRequestDTO;
import org.jonathan.domain.dto.UserDTO.UserResponseDTO;
import org.jonathan.domain.entities.User;
import org.jonathan.repository.AdminRepository;
import org.jonathan.view.helpers.MessageHelper;
import org.jonathan.view.menu.LoginView;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class AdminService {

        LoginView loginView = new LoginView();
        AdminRepository adminRepository = new AdminRepository();

    public User login(UserRequestDTO userRequestDTO){
        User user =  null;

            try {
                user = adminRepository.searchUserByEmailAndPassword(userRequestDTO.getEmail(), userRequestDTO.getPassword());

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

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO){
        UserResponseDTO user = null;

        if(userRequestDTO == null){
            MessageHelper.error("Erro ao criar usuário!\n");
        }else {
            try {
                user = adminRepository.createUser(userRequestDTO);

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

    public UserResponseDTO findUserById(Long id){
        UserResponseDTO user = null;

        try{
            user = adminRepository.findUserById(id);

            if(user == null){
                MessageHelper.error("Usuário não encontrado! Tente novamente.\n");
            }
        }catch (SQLException e){
            throw new RuntimeException("Erro ao retornar dados do banco");
        }
        return user;
    }

    public List<UserResponseDTO> showAllUsers(){
        List<UserResponseDTO> users = new ArrayList<>();
        try{
            users = adminRepository.showAllUsers();

            if(users.isEmpty()){
                MessageHelper.error("Nenhum usuário encontrado! Tente Novamente.\n");
            }
        }catch (SQLException e){
            throw new RuntimeException("Erro ao retornar dados do banco");
        }
        return users;
    }
}
