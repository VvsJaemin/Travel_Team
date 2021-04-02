package com.example.demo.qbs.domain;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.example.demo.uss.domain.User;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "qnas")
public class QnaBoard {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "board_no")
    private long boardNo;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "content")
    private String content;

    @NotNull
    @Column(name = "writer")
    private String writer;

    @Temporal(TemporalType.TIMESTAMP) 
    @UpdateTimestamp 
    @Column(name = "reg_date")
    private Date regDate = new Date();


    @Builder
    public QnaBoard(long boardNo, String title, String writer, String content, Date regDate) {
        this.boardNo = boardNo;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.regDate = regDate;
       
    }


  
    
    

}