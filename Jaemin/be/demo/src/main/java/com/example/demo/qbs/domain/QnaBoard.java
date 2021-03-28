package com.example.demo.qbs.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "qnas")
public class QnaBoard {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "board_no")
    private long boardNo;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "writer")
    private String writer;
    @Temporal(TemporalType.TIMESTAMP)  
    @Column(name = "reg_date")
    private Date regDate;
   
   
    @Builder
    public QnaBoard(long boardNo, String title, String writer, String content, Date regDate) {
        this.boardNo = boardNo;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.regDate = regDate;
       
    }


  
    
    

}