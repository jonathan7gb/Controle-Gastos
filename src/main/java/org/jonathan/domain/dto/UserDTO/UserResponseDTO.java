package org.jonathan.domain.dto.UserDTO;

import java.time.LocalDateTime;

public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private LocalDateTime creation_date;

    public UserResponseDTO(Long id, String name, String email, LocalDateTime creation_date) {
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

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }
}
