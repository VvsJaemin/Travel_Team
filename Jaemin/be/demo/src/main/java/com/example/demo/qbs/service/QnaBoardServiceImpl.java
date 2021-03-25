package com.example.demo.qbs.service;




import java.util.List;
import java.util.Optional;

import com.example.demo.cmm.service.AbstractService;
import com.example.demo.qbs.domain.QnaBoard;
import com.example.demo.qbs.repository.QnaBoardRepository;


import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnaBoardServiceImpl extends AbstractService <QnaBoard> implements QnaBoardService{
    
    private final QnaBoardRepository repo;

    @Override
    public void register(QnaBoard qnaboard) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public QnaBoard read(Long boardNo) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void modify(QnaBoard qnaboard) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void remove(Long boardNo) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<QnaBoard> list() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public QnaBoard save(QnaBoard entity) {
        
        return null;
    }

  



   

    


    

    
}
