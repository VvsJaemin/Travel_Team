package com.example.demo.uss.domain;
import java.util.List;

import javax.persistence.*;

import com.example.demo.qbs.domain.QnaBoard;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@Getter
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    @Column(name="user_no")
    private long userNo;
    @Column(name="name")
    private String name;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
   

    @ManyToOne
    @JoinColumn(name = "board_no")
    private QnaBoard qnaboard;


    public User toEntity(){
        return User.builder()
        .userNo(userNo)
        .name(name)
        .password(password)
        .email(email)
        .build();

}




    @Builder
    public User(long userNo, String name, String password, String email) {
        this.userNo = userNo;
        this.name = name;
        this.password = password;
        this.email = email;
    }
  
}