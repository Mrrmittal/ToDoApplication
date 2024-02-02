package com.ToDoApplication.ToDoApplication.service;

import com.ToDoApplication.ToDoApplication.model.ToDo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ToDoService {

    List<ToDo> getAllTask();
    ToDo saveTask(ToDo todoList);
    void deleteTaskById(Long id);
    ToDo findTaskById (Long id);
    ToDo updateTaskById(Long id, ToDo updatedTask);
    void deleteAllTask();
    Page<ToDo> findPagination(int pageNo, int pazeSize);

}
