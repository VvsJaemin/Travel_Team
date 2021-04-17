package com.example.demo.qbs.repository;

import java.util.Date;
import java.util.List;

import com.example.demo.qbs.domain.QnaBoard;
import com.example.demo.qbs.domain.QnaBoardDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

       
@Repository
public interface QnaBoardRepository extends JpaRepository<QnaBoard, Long>{

   
}
