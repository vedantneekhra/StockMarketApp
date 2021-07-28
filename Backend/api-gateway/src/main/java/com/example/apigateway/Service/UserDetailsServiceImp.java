package com.example.apigateway.Service;

import com.example.apigateway.Entity.UserEntity;
import com.example.apigateway.Mapper.UserMapper;
import com.example.apigateway.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserEntity> byUserName = userRepository.findByUserName(userName);

        if(byUserName.isEmpty()){
            throw new NullPointerException("No user found against the username["+userName+"]");
        }

        return UserMapper.convertToDTO(byUserName.get());
    }
}
