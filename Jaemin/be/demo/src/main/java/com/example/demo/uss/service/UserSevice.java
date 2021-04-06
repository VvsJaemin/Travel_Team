package com.example.demo.uss.service;

import java.util.Optional;

import com.example.demo.uss.domain.User;

public interface UserSevice {
    
     String login(String username, String password)throws Exception;
     
     Optional <User> findByUsername (String username);

     public void deleteByUsername (String username);

     boolean existsByUsername(String username);

}