package com.example.demo.uss.repository;

import com.example.demo.uss.domain.User;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    @Transactional
    @Query(value="select user_no userNo, username, password from users where user_no='userNo' and username='username' and password='password'", nativeQuery = true )
        public User login(@Param("userNo") long userNo, @Param("username") String username, @Param("password") String password);
    
}
