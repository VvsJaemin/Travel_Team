package com.example.demo.cmm.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.uss.domain.User;

public  abstract class UserAbstractService<T> {
    public abstract long count();
	public abstract boolean existsById(long id);
	public abstract List<T> findAll();
	public abstract Optional<User> findOne();
	public abstract void deleteById(long id);
	public abstract T getOne(long id);
	public abstract User save(T entity);
	public abstract  Optional<User> findById(long id);
	
}
