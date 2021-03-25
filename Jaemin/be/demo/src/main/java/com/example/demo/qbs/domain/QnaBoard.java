package com.example.demo.qbs.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "qnas")
public class QnaBoard {
    @Id @GeneratedValue 
    @Column(name = "board_no")
    private long boardNo;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "writer")
    private String writer;
    @Column(name = "comments")
    private String comments;
    @Column(name = "reg_date")
    private Date regDate;
   
   
    @Builder
    public QnaBoard(long boardNo, String title, String writer, String content, Date regDate, String comments) {
        this.boardNo = boardNo;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.regDate = regDate;
        this.comments = comments;
    }
    

    

    
    

}