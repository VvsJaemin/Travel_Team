package com.example.demo.qbs.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity@Table(name = "qnas")
public class QnaBoard {
    @Id @GeneratedValue 
    @Column(name = "board_no")
    private long boardNo;
    @Column(name = "title")
    private String title;
    @Column(name = "writer")
    private String writer;
    @Column(name = "content")
    private String content;
    @Column(name = "reg_date")
    private Date regDate;
    @Column(name = "comments")
    private String comments;
}