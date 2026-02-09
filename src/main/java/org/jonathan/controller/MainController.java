package org.jonathan.controller;

import org.jonathan.domain.dto.UserDTO.UserRequestDTO;
import org.jonathan.domain.entities.User;

import org.jonathan.service.AdminService;
import org.jonathan.view.menu.AdminMenu;
import org.jonathan.view.menu.LoginView;

public class MainController {

    LoginView loginView = new LoginView();
    AdminMenu adminMenu = new AdminMenu();
    AdminController adminController = new AdminController();
    AdminService adminService = new AdminService();

    public void startSystem(){
       boolean leftSystem = false;
       User user = null;

            while(user == null){
               UserRequestDTO userRequestDTO = loginView.login();
               user = adminService.login(userRequestDTO);
            }

           if(user.getEmail().equals("admin@gmail.com")){
              adminController.adminController();
           }else{

           }


    }
}
