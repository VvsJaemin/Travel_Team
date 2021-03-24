package com.example.demo.qbs.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class QnaBoardDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private long boardNo;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private String comments;
}
