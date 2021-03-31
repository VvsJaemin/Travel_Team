package com.example.demo.uss.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.cmm.service.AbstractService;
import com.example.demo.cmm.service.UserAbstractService;
import com.example.demo.qbs.domain.QnaBoard;
import com.example.demo.uss.domain.User;
import com.example.demo.uss.repository.UserRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl extends UserAbstractService<User>implements UserSevice {
    
    private final UserRepository repo;

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean existsById(long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<User> findOne() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteById(long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public User getOne(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User save(User entity) {
        // TODO Auto-generated method stub
        return repo.save(entity);
    }

    @Override
    public Optional<User> findById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    

   
    
   
    
}
