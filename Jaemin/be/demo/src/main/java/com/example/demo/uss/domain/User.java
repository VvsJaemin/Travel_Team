package com.example.demo.uss.domain;
import java.beans.JavaBean;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.qbs.domain.QnaBoard;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@Getter
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="user_no")
    private long userNo;
    
    @NotNull
    @Column(name="`username`")
    private String username;

    @Column(name="password")
    private String password;

    // @Column(name="name")
    // private String name;

    // @Email
    // @NotNull(message="이메일을 다시 입력해주세요")
    // @Column(name="email")
    // private String email;

    // @Column(name="birthday")
    // private String birthday;

    // @Column(name="gender")
    // private String gender;
   

    public User toEntity(){
        return User.builder()
        .userNo(userNo)
        
        .password(password)
        .username(username)
     
        .build();

}
     @Builder
    public User(long userNo, @NonNull @Size(min = 1, max = 10, message = "아이디는 10자 이내로 입력해주세요") String username,
            String password) {
        this.userNo = userNo;
        this.username = username;
        this.password = password;
    }








  
}