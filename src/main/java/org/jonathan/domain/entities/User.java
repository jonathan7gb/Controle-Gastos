package org.jonathan.domain.entities;

import java.time.LocalDateTime;

public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime creation_date;

    public User(Long id, String name, String email, String password, LocalDateTime creation_date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.creation_date = creation_date;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(Long id, String name, String email, LocalDateTime creation_date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.creation_date = creation_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }
}
