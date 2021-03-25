package com.example.demo.qbs.repository;

import java.util.Date;
import java.util.List;

import com.example.demo.qbs.domain.QnaBoard;
import com.example.demo.qbs.domain.QnaBoardDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface QnaBoardCustomRepository {

    @Query("insert into qnas (title, content, writer, comments) " + "values(:title, :content, :writer, :comments)")
    public void create(@Param("title") String title, @Param("content") String content, @Param("writer") String writer, @Param ("comments") String comments); // Q&A 등록

    @Query("")
       
    
    


public interface QnaBoardRepository extends JpaRepository<QnaBoard, Long>, QnaBoardCustomRepository{

    
    
    @Query(value= "select board_no, title, content, writer, reg_date, comments) values(:board_no, :title, :content, :writer, :reg_date, :comments)",
    nativeQuery=true)

    void selectQnaBoard (@Param("board_no") long board_no, @Param("title") String title, @Param("content") String content,  @Param ("writer") String writer, @Param ("reg_date") Date reg_date, @Param("comments") String comments);


    @Query(value= "update title, content, comments) values(:title, :content, :comments)",
    nativeQuery=true)

    @Modifying
    void updateQnaBoard (@Param("title") String title, @Param("content") String content, @Param("comments") String comments);


    @Query(value= "delete from board_no) values(:board_no)",
    nativeQuery=true)
    
    void deleteQnaBoard (@Param("board_no") long board_no);

    @Query(value= "select board_no, title, content, writer, regDate, comments) values(:board_no, :title, :content, :writer, :reg_date, :comments)",
    nativeQuery=true)

    void listQnaBoard (@Param("board_no") long board_no, @Param("title") String title, @Param("content") String content,  @Param ("writer") String writer, @Param ("reg_date") Date reg_date, @Param("comments") String comments);

}