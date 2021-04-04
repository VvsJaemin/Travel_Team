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
    private String name;
    private String email;
    private String birthday;
    private String gender;

    @Builder
    public UserDto(long userNo, String username, String password, String name, String email, String birthday,
            String gender) {
        this.userNo = userNo;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
    }

   




    

}