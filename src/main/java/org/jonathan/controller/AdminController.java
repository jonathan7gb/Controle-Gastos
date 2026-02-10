package org.jonathan.controller;

import org.jonathan.domain.dto.UserDTO.UserRequestDTO;
import org.jonathan.domain.dto.UserDTO.UserResponseDTO;
import org.jonathan.domain.entities.User;
import org.jonathan.domain.mapper.UserMapper;
import org.jonathan.service.AdminService;
import org.jonathan.view.menu.AdminMenu;
import org.jonathan.view.menu.UserMenu;

import java.util.List;

public class AdminController {

    AdminMenu adminMenu = new AdminMenu();
    AdminService adminService = new AdminService();

    public void adminController(){
        int adminChoice = -1;
        do {
            adminChoice = adminMenu.menuAdmin();

            switch (adminChoice){
                case 1 -> {
                    UserRequestDTO userRequestDTO = adminMenu.createUserView();
                    adminService.createUser(userRequestDTO);
                }
                case 2 -> {
                    Long idUser = adminMenu.findUserById("Insira o Id do usuário: ");
                    UserResponseDTO userFound = adminService.findUserById(idUser);
                    if(userFound != null){
                        System.out.println();
                        adminMenu.showUserDetail(userFound);
                        System.out.println();
                    }
                }
                case 3 -> {
                    List<UserResponseDTO> userList = adminService.showAllUsers();
                    adminMenu.showAllUsers(userList);
                    System.out.println();
                }
                case 4 -> {
                    Long idUser = adminMenu.findUserById("Insira o Id do usuário: ");
                    UserResponseDTO userFound = adminService.findUserById(idUser);
                    System.out.println();
                    adminMenu.showUserDetail(userFound);
                    UserRequestDTO userRequestDTO = adminMenu.editUserView(userFound);
                    boolean updated = adminService.updateUser(idUser, userRequestDTO);
                }
                case 5 -> {}
                case 0 -> {
                    System.out.println("\n[---- SISTEMA ENCERRADO COM SUCESSO ----]");
                    return;
                }
            }
        }while(true);
    }
}
