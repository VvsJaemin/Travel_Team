package com.example.demo.qbs.service;

import java.util.List;

import com.example.demo.qbs.domain.QnaBoard;
import com.example.demo.qbs.domain.QnaBoardDto;

import org.springframework.stereotype.Service;

public interface QnaBoardService {

    public void register(QnaBoard qnaboard)throws Exception;

    public void update(QnaBoard qnaboard)throws Exception;

}
