package org.jonathan.view.menu;

import org.jonathan.domain.dto.UserDTO.UserRequestDTO;
import org.jonathan.domain.dto.UserDTO.UserResponseDTO;
import org.jonathan.view.helpers.InputHelpers;

import java.util.Scanner;

public class LoginView {

    Scanner sc = new Scanner(System.in);

    public int menuLogin(){
        System.out.println("""
                [--------- LOGIN ---------]
                [ 1 - Entrar
                [ 2 - Sair do Sistema
                [------------------------------]
                """);
        return InputHelpers.inputInteger("[ ? - Sua Escolha: ", sc);
    }

    public UserRequestDTO login(){
        System.out.println("[--------- ENTRAR ---------]");
        String email = InputHelpers.inputString("[ - E-mail: ", sc);
        String password = InputHelpers.inputString("[ - Senha: ", sc);
        return new UserRequestDTO(null, email, password);
    }
}
