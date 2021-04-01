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
    private String username;
    private String password;

    @Builder
    public UserDto(long userNo, String username, String password) {
        this.userNo = userNo;
        this.username = username;
        this.password = password;
    }




    

}