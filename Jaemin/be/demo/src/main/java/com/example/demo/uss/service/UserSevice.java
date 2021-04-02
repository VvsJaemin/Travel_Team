package com.example.demo.uss.service;

import com.example.demo.uss.domain.User;

public interface UserSevice {
    
    User login(String username, String password)throws Exception;
}
