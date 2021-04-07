package com.example.demo.uss.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.amazonaws.services.simplesystemsmanagement.model.SessionStatus;
import com.example.demo.uss.domain.User;
import com.example.demo.uss.domain.UserDto;
import com.example.demo.uss.service.UserServiceImpl;

import org.springframework.boot.web.servlet.server.Session.Cookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping(value = "/user")
@CrossOrigin("*")
public class UserController {

    private final UserServiceImpl service;

    @PostMapping("")
    public ResponseEntity<?> save(@Validated @RequestBody User user) {
        log.info("회원 가입 완료");
        service.save(user);

        log.info("Register user.getUserNo() = " + user.getUserNo());

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody User user) throws Exception {

        String login = service.login(user.getUsername(), user.getPassword());

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        if (login != null) {
            log.info("로그인 성공");
            System.out.println("login 세션 확인 : " + login);
            return new ResponseEntity<>(login, HttpStatus.OK);
        } else {
            log.info("다시 로그인 해주세요");
            return new ResponseEntity<>(login, HttpStatus.UNAUTHORIZED);
        }

    }


    // @GetMapping("/list")
    // public ResponseEntity<List<User>> list() {
    //     log.info("get list()");

    //     return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    // }

    @GetMapping("/read/{username}")
    public ResponseEntity <Optional<User>> read(@PathVariable("username") String username) {
        log.info("read()");
        Optional<User> u = service.findByUsername(username);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @PutMapping("/modify/{username}")
    public ResponseEntity<User> modify(@PathVariable("username") String username, @RequestBody User user) {
       
        
        log.info("put modify()" + user);

        log.info("username : " + username);

        return new ResponseEntity<>(service.save(user), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<String> remove(@PathVariable String username) {

        service.deleteByUsername(username);
        log.info("delete");

        return new ResponseEntity<>("delete success!", HttpStatus.NO_CONTENT);
    }
}
