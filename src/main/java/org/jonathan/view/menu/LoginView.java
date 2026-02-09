package org.jonathan.view.menu;

import org.jonathan.domain.dto.UserDTO.UserRequestDTO;
import org.jonathan.domain.dto.UserDTO.UserResponseDTO;
import org.jonathan.view.helpers.InputHelpers;

import java.util.Scanner;

public class LoginView {

    Scanner sc = new Scanner(System.in);

    public UserRequestDTO login(){
        System.out.println("[--------- LOGIN NO SISTEMA ---------]");
        String email = InputHelpers.inputString("[ - E-mail: ", sc);
        String password = InputHelpers.inputString("[ - Senha: ", sc);
        return new UserRequestDTO(null, email, password);
    }
}
