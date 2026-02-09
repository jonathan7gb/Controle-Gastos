package org.jonathan.view.menu;

import org.jonathan.model.entities.User;
import org.jonathan.view.helpers.InputHelpers;

import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    Scanner sc = new Scanner(System.in);

    public int menuAdmin(){
        System.out.println("""
                [--------- MENU ADMIN ---------]
                [ 1 - Criar Usuário
                [ 2 - Procurar Usuário
                [ 3 - Listar Usuários
                [ 4 - Editar Usuário
                [ 5 - Excluir Usuário
                [ 6 - Sair do Sistema
                [------------------------------]
                """);
        return InputHelpers.inputInteger("[ ? - Sua Escolha: ", sc);
    }

    public User createUserView(){
        System.out.println("[--------- CRIAR USUÁRIO ---------]");
        String name = InputHelpers.inputString("[ - Insira o nome: ", sc);
        String email = InputHelpers.inputString("[ - Insira o email: ", sc);
        String password = InputHelpers.inputString("[ - Insira a senha: ", sc);
        return new User(name, email, password);
    }

    public void showUserDetail(User u){
        System.out.println("[ ------------------------------ ]");
        System.out.println("[ [" + u.getId() + "] " + u.getName());
        System.out.println("[ Email: " + u.getEmail());
        System.out.println("[ Password: " + u.getPassword());
        System.out.println("[ ------------------------------ ] ");
    }

    public int foundUserById(){
        System.out.println("[--------- PROCURAR USUÁRIO ---------]");
        return InputHelpers.inputInteger("[ - Insira o ID do usuário: ", sc);
    }

    public void showAllUsers(List<User> users){
        System.out.println("[--------- LISTAR USUÁRIOS ---------]");
        for(User user : users){
            showUserDetail(user);
        }
    }
}
