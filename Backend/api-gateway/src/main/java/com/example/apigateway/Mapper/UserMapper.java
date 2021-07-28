package com.example.apigateway.Mapper;

import com.example.apigateway.DTO.UserDTO;
import com.example.apigateway.Entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class UserMapper {
    public static UserDTO convertToDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setConfirmed(userEntity.isConfirmed());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setContactNumber(userEntity.getContactNumber());

        String[] userTypes = userEntity.getUserType().split(",");
        List<GrantedAuthority> userTypeList = new ArrayList<>();
        for(String userType: userTypes){
            userTypeList.add(new SimpleGrantedAuthority(userType));
        }

        userDTO.setUserType(userTypeList);

        return userDTO;
    }
}
