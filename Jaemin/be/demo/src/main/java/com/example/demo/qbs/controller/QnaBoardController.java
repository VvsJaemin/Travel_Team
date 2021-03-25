package com.example.demo.qbs.controller;

import java.util.List;

import com.example.demo.qbs.domain.QnaBoard;
import com.example.demo.qbs.repository.QnaBoardRepository;
import com.example.demo.qbs.repository.QnaBoardRepositoryImpl;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
@RestController
@RequestMapping("/qna")
@CrossOrigin(origins="*")
public class QnaBoardController {

    private final QnaBoardService service;

     @GetMapping("/{boardNo}")
     public ResponseEntity<QnaBoard> read(
             @PathVariable("boardNo") Long boardNo) throws Exception {
         log.info("read()");
 
         QnaBoard qnaboard = service.read(boardNo);
         System.out.println("QnaBoardController: " + qnaboard);
 
         return new ResponseEntity<QnaBoard>(qnaboard, HttpStatus.OK);
     }

     @GetMapping("")
     public ResponseEntity<List<QnaBoard>> list() throws Exception {
         log.info("list()");
 
         return new ResponseEntity<>(service.list(), HttpStatus.OK);
     }

     @PostMapping("")
     public ResponseEntity<QnaBoard> register(
             @Validated @RequestBody QnaBoard qnaboard,
             UriComponentsBuilder uriBuilder) throws Exception {
         log.info("POST register()");
 
         service.register(qnaboard);
 
         log.info("register board.getBoardNo() = " + qnaboard.getBoardNo());
        
         return new ResponseEntity<>(qnaboard, HttpStatus.OK);

    }

    @DeleteMapping("/{boardNo}")
    public ResponseEntity<Void> remove(
            @PathVariable("boardNo") Long boardNo) throws Exception {
        log.info("remove");

        service.remove(boardNo);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{boardNo}")
    public ResponseEntity<QnaBoard> modify(
            @PathVariable("boardNo") Long boardNo,
            @Validated @RequestBody QnaBoard qnaboard) throws Exception {
        log.info("Put - modify()");
        System.out.println(qnaboard);

        qnaboard.setBoardNo(boardNo);
        service.modify(qnaboard);

        return new ResponseEntity<>(qnaboard, HttpStatus.OK);
    }

}
