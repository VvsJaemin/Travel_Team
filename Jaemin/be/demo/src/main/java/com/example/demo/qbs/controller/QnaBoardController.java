package com.example.demo.qbs.controller;

import java.util.List;

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
@RequestMapping(value = "/qna", method= {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins="*")
public class QnaBoardController {

    private final QnaBoardServiceImpl service; 

    @PostMapping("/reg")
    public ResponseEntity<?> save(
            @RequestBody QnaBoard qnaboard){
                log.info("등록완료");
                service.save(qnaboard);

                log.info("register board.getBoardNo() = " + qnaboard.getBoardNo());
                return new ResponseEntity<>(HttpStatus.OK);
            }
    
            @GetMapping("/list")
            public ResponseEntity<?> list(){
    
                log.info("list()");
    
                return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
            }


           
        	@GetMapping("/list/{id}")
	public ResponseEntity<QnaBoard> getOne(@PathVariable Long id){
		System.out.println("read()");
		
		return new ResponseEntity<>(service.getOne(id), HttpStatus.OK);
	}
            

            
            @PutMapping("/{boardNo}")
            public ResponseEntity<QnaBoard> modify(@PathVariable("boardNo") Long boardNo, @RequestBody QnaBoard qnaboard){

            qnaboard.getBoardNo();
            service.save(qnaboard);

            log.info("Put - modify()");
            
            return new ResponseEntity<>(qnaboard, HttpStatus.OK);
            }

                @DeleteMapping("/{boardNod}")

                public ResponseEntity<?> remove(){
    
                    log.info("remove");
    
                    return new ResponseEntity<>(service.findOne(), HttpStatus.NO_CONTENT);
                }
            

}
