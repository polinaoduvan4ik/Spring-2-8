package com.example.project.repos;

import com.example.project.domain.Computers;
import org.springframework.data.repository.CrudRepository;

public interface ComputersRepos extends CrudRepository<Computers, Long> {
}
