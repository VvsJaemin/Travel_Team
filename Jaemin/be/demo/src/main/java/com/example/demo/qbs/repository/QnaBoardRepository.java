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
import org.springframework.transaction.annotation.Transactional;

       
@Repository
public interface QnaBoardRepository extends JpaRepository<QnaBoard, Long>{

    @Transactional
    @Modifying
    @Query(value="insert into qnas (title, content, writer) values (:title, :content, :writer)", nativeQuery = true)
    public void create(@Param("title") String title, @Param("content") String content, @Param("writer") String writer);

    @Transactional
    @Modifying
    @Query(value = "UPDATE qnas SET title =:title, content = :content WHERE board_no LIKE :boardNo", nativeQuery = true) public void modify(@Param("title") String title, @Param("content") String content, @Param("boardNo") long boardNo );
    
        // WHERE board_no Like

    // @Query(value="SELECT board_no boardNo, title, content, writer, comments, reg_date regDate FROM qnas WHERE board_no LIKE :boardNo", nativeQuery = true)
    // public QnaBoard read(@Param("boardNo") long boardNo);


    // @Query(value="DELETE FROM qnas where board_no LIKE :boardNo", nativeQuery = true)
    // public void delete(@Param("boardNo") long BoardNo);

    // @Query(value="SELECT board_no boardNo, title, content, writer, comments, reg_date regDate FROM qnas WHERE board_no LIKE :boardNo", nativeQuery=true)

    // public void list (@Param("boardNo") long boardNo, @Param("title") String title, @Param("content") String content,  @Param ("writer") String writer, @Param ("regDate") Date regDate, @Param("comments") String comments);

}
