package org.jonathan.domain.mapper;

import org.jonathan.domain.dto.UserDTO.UserRequestDTO;
import org.jonathan.domain.dto.UserDTO.UserResponseDTO;
import org.jonathan.domain.entities.User;

public class UserMapper {

    public static User toEntity(UserRequestDTO u){
        return new User(u.getName(), u.getEmail(), u.getPassword());
    }

    public static UserResponseDTO toDTO(User u){
        return new UserResponseDTO(u.getId(), u.getName(), u.getEmail(), u.getCreation_date());
    }
}
