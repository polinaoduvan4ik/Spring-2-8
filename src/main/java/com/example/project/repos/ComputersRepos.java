package com.example.project.repos;

import com.example.project.domain.Computers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComputersRepos extends CrudRepository<Computers, Long> {

    List<Computers> findByName(String name);
}
