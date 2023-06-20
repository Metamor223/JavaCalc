package ru.neoflex.practice.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface RepositoryCalc extends CrudRepository<Constructor, Long>{
}