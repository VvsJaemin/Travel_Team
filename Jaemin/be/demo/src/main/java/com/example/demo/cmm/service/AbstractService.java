package com.example.demo.cmm.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.qbs.domain.QnaBoard;
import com.example.demo.qbs.domain.QnaBoardDto;

public abstract class AbstractService<T> {
    public abstract long count();
	public abstract boolean existsById(long id);
	public abstract List<T> findAll();
	public abstract Optional<QnaBoard> findOne();
	public abstract void deleteById(long id);
	public abstract T getOne(long id);
	public abstract QnaBoard save(T entity);
	
	public abstract  Optional<QnaBoard> findById(long id);

	
}
