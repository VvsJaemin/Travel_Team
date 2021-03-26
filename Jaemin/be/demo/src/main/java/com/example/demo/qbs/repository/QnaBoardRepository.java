package com.example.demo.qbs.repository;

import java.util.Date;
import java.util.List;

import com.example.demo.qbs.domain.QnaBoard;
import com.example.demo.qbs.domain.QnaBoardDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

       
@Repository
public interface QnaBoardRepository extends JpaRepository<QnaBoard, Long>{


    @Modifying
    @Query(value="insert into qnas (title, content, writer, comments) values (:title, :content, :writer, :comments)", nativeQuery = true)
    public void create(@Param("title") String title, @Param("content") String content, @Param("writer") String writer, @Param("comments") String comments); 

    
}
