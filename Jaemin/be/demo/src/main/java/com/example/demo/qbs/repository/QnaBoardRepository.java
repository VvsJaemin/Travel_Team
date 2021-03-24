package com.example.demo.qbs.repository;

import java.util.List;

import com.example.demo.qbs.domain.QnaBoard;

import org.springframework.data.jpa.repository.JpaRepository;


public interface QnaBoardRepository extends JpaRepository<QnaBoard, Long>{

    void create(QnaBoard qnaboard);

    QnaBoard read(Long boardNo);

    void update(QnaBoard qnaboard);

    void remove(Long boardNo);

    List<QnaBoard> list();
    


}