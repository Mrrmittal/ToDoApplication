package com.ToDoApplication.ToDoApplication.repository;

import com.ToDoApplication.ToDoApplication.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
