package com.example.demo.uss.domain;
import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
public class UserDto implements Serializable {
    private static final long serialVersionUID  = 1L;
    private long userNo;
    private String name;
    private String password;
    private String email;

    @Builder
    public UserDto(long userNo, String name, String password, String email) {
        this.userNo = userNo;
        this.name = name;
        this.password = password;
        this.email = email;
    }


    

}