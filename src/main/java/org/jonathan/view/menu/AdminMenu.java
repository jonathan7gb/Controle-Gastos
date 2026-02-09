package org.jonathan.view.menu;

import org.jonathan.domain.dto.UserDTO.UserRequestDTO;
import org.jonathan.domain.dto.UserDTO.UserResponseDTO;
import org.jonathan.view.helpers.InputHelpers;

import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    Scanner sc = new Scanner(System.in);

    public int menuAdmin(){
        System.out.println("""
                [--------- MENU ADMIN ---------]
                [ 1 - Criar Usuário
                [ 2 - Buscar Usuário
                [ 3 - Listar Usuários
                [ 4 - Editar Usuário
                [ 5 - Excluir Usuário
                [ 0 - Sair do Sistema
                [------------------------------]""");
        return InputHelpers.inputInteger("[ ? - Sua Escolha: ", sc);
    }

    public UserRequestDTO createUserView(){
        System.out.println("\n[--------- CRIAR USUÁRIO ---------]");
        String name = InputHelpers.inputString("[ - Insira o nome: ", sc);
        String email = InputHelpers.inputString("[ - Insira o email: ", sc);
        String password = InputHelpers.inputString("[ - Insira a senha: ", sc);
        return new UserRequestDTO(name, email, password);
    }

    public void showUserDetail(UserResponseDTO u){
        System.out.println("[ ------------------------------ ]");
        System.out.println("[ [" + u.getId() + "] " + u.getName());
        System.out.println("[ Email: " + u.getEmail());
        System.out.println("[ Data de Criacão: " + u.getCreation_date());
        System.out.println("[ ------------------------------ ] ");
    }

    public int foundUserById(String mensagem){
        System.out.println("\n[--------- "+mensagem+" ---------]");
        return InputHelpers.inputInteger("[ - Insira o ID do usuário: ", sc);
    }

    public void showAllUsers(List<UserResponseDTO> users){
        System.out.println("\n[--------- LISTAR USUÁRIOS ---------]");
        for(UserResponseDTO u : users){
            showUserDetail(u);
        }
    }

    public UserRequestDTO editUserView(UserRequestDTO uDTO){
        System.out.println("\n[--------- EDITAR USUÁRIO ---------]");
        String newName = InputHelpers.inputString("[ - Editar nome (Atual: "+uDTO.getName() +"): ", sc);
        String newEmail = InputHelpers.inputString("[ - Editar e-mail (Atual: "+uDTO.getEmail() +"): ", sc);
        return new UserRequestDTO(newName, newEmail, uDTO.getPassword());
    }

}
