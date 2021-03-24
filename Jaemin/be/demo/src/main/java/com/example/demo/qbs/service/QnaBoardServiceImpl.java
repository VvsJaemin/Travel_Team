package com.example.demo.qbs.service;




import java.util.List;

import com.example.demo.qbs.domain.QnaBoard;
import com.example.demo.qbs.repository.QnaBoardRepository;


import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnaBoardServiceImpl implements QnaBoardService{
    
    private final QnaBoardRepository repository;

    @Override
    public void register(QnaBoard qnaboard) throws Exception {
        

        repository.create(qnaboard);
        
    }

    @Override
    public QnaBoard read(Long boardNo) throws Exception {
        
       System.out.println("Q&A BoardService read(boardNo): " + boardNo );

        return repository.read(boardNo);
    }

    @Override
    public void modify(QnaBoard qnaboard) throws Exception {
        System.out.println("Q&A BoardService modify(qnaboard) : " + qnaboard);      
        
        repository.update(qnaboard);
    }

    @Override
    public void remove(Long boardNo) throws Exception {
        
        repository.remove(boardNo);
        
    }

    @Override
    public List<QnaBoard> list() throws Exception {

        return repository.list();
    }

    


    

    
}
