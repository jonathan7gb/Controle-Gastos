package org.jonathan.controller;

import org.jonathan.domain.dto.UserDTO.UserRequestDTO;
import org.jonathan.domain.entities.User;

import org.jonathan.service.UserService;
import org.jonathan.view.menu.AdminMenu;
import org.jonathan.view.menu.LoginView;

public class MainController {

    LoginView loginView = new LoginView();
    AdminMenu adminMenu = new AdminMenu();
    UserService userService = new UserService();

    public void startSystem(){
       boolean leftSystem = false;
       User user = null;

            while(user == null){
               UserRequestDTO userRequestDTO = loginView.login();
               user = userService.login(userRequestDTO);
            }

           if(user.getEmail().equals("admin@gmail.com")){
               int adminChoice = -1;
               do {
                    adminChoice = adminMenu.menuAdmin();

                    switch (adminChoice){
                        case 1 -> {
                            UserRequestDTO userRequestDTO = adminMenu.createUserView();
                            User userCreated = userService.createUser(userRequestDTO);
                        }
                        case 2 -> {}
                        case 3 -> {}
                        case 4 -> {}
                        case 5 -> {}
                        case 0 -> {
                            return;
                        }
                    }
               }while(true);
           }else{

           }

    }
}
