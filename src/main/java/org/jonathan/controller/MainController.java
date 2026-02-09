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
        do {
           UserRequestDTO userRequestDTO = loginView.login();
           User user = userService.login(userRequestDTO);

           if(user.getEmail().equals("admin@gmail.com")){
               int adminChoice = adminMenu.menuAdmin();
           }else{

           }

       }while(!leftSystem);
    }
}
