package com.example.demo.qbs.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.cmm.service.AbstractService;
import com.example.demo.qbs.domain.QnaBoard;
import com.example.demo.qbs.domain.QnaBoardDto;
import com.example.demo.qbs.repository.QnaBoardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@AllArgsConstructor
public class QnaBoardServiceImpl extends AbstractService<QnaBoard> implements QnaBoardService {

    private final QnaBoardRepository repo;

    @Override public void update(QnaBoard qnaboard)throws Exception {
        // TODO Auto-generated method stub

        repo.modify(qnaboard.getTitle(), qnaboard.getContent(), qnaboard.getBoardNo());
    }

    @Override public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override public boolean existsById(long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override public List<QnaBoard> findAll() {
        // TODO Auto-generated method stub
        return repo.findAll();
    }

    @Override public Optional<QnaBoard> findOne() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override public void deleteById(long id) {
        repo.deleteById(id);
    }

    @Override public QnaBoard getOne(long id) {
        // TODO Auto-generated method stub
        return repo.getOne(id);
    }

    @Override public QnaBoard save(QnaBoard entity) {
        // TODO Auto-generated method stub
        return repo.save(entity);
    }

    @Override public Optional<QnaBoard> findById(long id) {

        return repo.findById(id);
    }

    @Override public void register(QnaBoard qnaboard)throws Exception {
        // TODO Auto-generated method stub
        repo.create(qnaboard.getTitle(), qnaboard.getContent(), qnaboard.getWriter());
    }

}
