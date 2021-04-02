package com.example.demo.uss.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.example.demo.uss.domain.User;
import com.example.demo.uss.domain.UserDto;
import com.example.demo.uss.service.UserServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
@RestController
@RequestMapping(value="/user")
@CrossOrigin("*")
public class UserController {

    private final UserServiceImpl service;
    

    @PostMapping("")
    public ResponseEntity<?> save(@Validated
        @RequestBody User user){
            log.info("회원 가입 완료");
            service.save(user);

            log.info("Register user.getUserNo() = " + user.getUserNo());

            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    
        
        @PostMapping("/login")
        public ResponseEntity<String> login(@Valid @RequestBody User user) throws Exception{

           String login = service.login(user.getUsername(), user.getPassword());

           System.out.println(user.getUsername());

           if(login != null){
               log.info("로그인 성공");
               return new ResponseEntity<>(HttpStatus.OK);
           }else{
               log.info("다시 로그인 해주세요");
               return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
           }

        }
}
