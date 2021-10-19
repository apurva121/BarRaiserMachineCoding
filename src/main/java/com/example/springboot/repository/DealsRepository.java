package com.example.springboot.repository;

import com.example.springboot.model.Deal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealsRepository extends CrudRepository<Deal, Long> {

}