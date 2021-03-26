package com.example.demo.qbs.controller;

import java.util.List;

import com.example.demo.qbs.domain.QnaBoard;
import com.example.demo.qbs.domain.QnaBoardDto;
import com.example.demo.qbs.service.QnaBoardService;

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
import org.springframework.web.util.UriComponentsBuilder;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;


@Log
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/qna", method= {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins="*")
public class QnaBoardController {

    private final QnaBoardService service;

 
     @PostMapping("")
     public ResponseEntity<QnaBoard> register(
             @RequestBody QnaBoard qnaboard) throws Exception {
         log.info("POST register()");
 
        service.register(qnaboard);
 
         log.info("register board.getBoardNo() = " + qnaboard.getBoardNo());
        
         return new ResponseEntity<>(qnaboard, HttpStatus.OK);

    }


}
