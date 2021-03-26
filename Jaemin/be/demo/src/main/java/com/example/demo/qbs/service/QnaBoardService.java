package com.example.demo.qbs.service;

import java.util.List;

import com.example.demo.qbs.domain.QnaBoard;
import com.example.demo.qbs.domain.QnaBoardDto;

import org.springframework.stereotype.Service;

public interface QnaBoardService {
    

    public void register(QnaBoard qnaboard) throws Exception;




    // public QnaBoard read(Long boardNo) throws Exception;

    // public void modify(QnaBoard qnaboard) throws Exception;

    // public void remove(Long boardNo) throws Exception;

    // public List<QnaBoard> list() throws Exception;
    
}
