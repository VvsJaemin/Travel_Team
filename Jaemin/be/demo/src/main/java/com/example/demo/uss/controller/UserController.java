package com.example.demo.uss.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import com.example.demo.uss.domain.User;
import com.example.demo.uss.service.UserServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
@RestController
@RequestMapping(value="/user", method={})
@CrossOrigin("*")
public class UserController {

    private final UserServiceImpl service;
    

    @PostMapping("")
    public ResponseEntity<String> save(
        @RequestBody User user){
            log.info("회원 가입 완료");
            service.save(user);

            log.info("Register user.getUserNo() = " + user.getUserNo());

            return new ResponseEntity<>("등록 성공", HttpStatus.OK);
        }
    
        
        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody User user)throws Exception{
            log.info("login()");
            log.info("로그인 성공 : " + user.getUserNo());
            service.login(user);

            return new ResponseEntity<>(user,HttpStatus.OK);
        }
}
