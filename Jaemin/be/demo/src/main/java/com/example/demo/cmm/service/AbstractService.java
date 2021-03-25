package com.example.demo.cmm.service;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T> {
    public abstract T save(T entity);
	
}
