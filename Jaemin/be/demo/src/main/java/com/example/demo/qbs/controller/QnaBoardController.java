package com.example.demo.qbs.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.qbs.domain.QnaBoard;
import com.example.demo.qbs.domain.QnaBoardDto;
import com.example.demo.qbs.service.QnaBoardService;
import com.example.demo.qbs.service.QnaBoardServiceImpl;

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
@RequestMapping(value = "/qna")
@CrossOrigin(origins = "*")
public class QnaBoardController {

    private final QnaBoardServiceImpl service;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody QnaBoard qnaboard) {
        log.info("등록완료");
        service.save(qnaboard);

        log.info("register board.getBoardNo() = " + qnaboard.getBoardNo());
        return new ResponseEntity<>(qnaboard, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<QnaBoard>> list() {

        log.info("list()");

        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Optional<QnaBoard>> read(@PathVariable long id) {
        log.info("read()");

        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PutMapping("/modify/{boardNo}")
    public ResponseEntity<QnaBoard> modify(
        @PathVariable("boardNo")long boardNo,
        @RequestBody QnaBoard qnaboard
    ) {

        log.info("Put - modify()");
        log.info("boardNo long: " + boardNo);
        log.info("boardNo entity: " + qnaboard.getBoardNo());

        return new ResponseEntity<>(service.save(qnaboard), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{boardNo}")

    public ResponseEntity<String> remove(@PathVariable long boardNo) {

        service.deleteById(boardNo);
        log.info("remove");

        return new ResponseEntity<>("delete success!", HttpStatus.OK);
    }

}
