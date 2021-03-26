package com.example.demo.qbs.domain;

import java.io.Serializable;
import java.util.Date;


import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class QnaBoardDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private long boardNo;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private String comments;

    public QnaBoard toEntity(){
            return QnaBoard.builder()
            .boardNo(boardNo)
            .title(title)
            .writer(writer)
            .content(content)
            .regDate(regDate)
            .comments(comments)
            .build();

    }

    @Builder
    public QnaBoardDto(long boardNo, String title, String writer, String content, Date regDate, String comments) {
        this.boardNo = boardNo;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.regDate = regDate;
        this.comments = comments;
    }

    

}
