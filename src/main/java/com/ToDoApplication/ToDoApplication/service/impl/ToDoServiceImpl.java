package com.ToDoApplication.ToDoApplication.service.impl;


import com.ToDoApplication.ToDoApplication.model.ToDo;
import com.ToDoApplication.ToDoApplication.repository.ToDoRepository;
import com.ToDoApplication.ToDoApplication.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public List<ToDo> getAllTask() {
        ToDo toDo = new ToDo();
        return toDoRepository.findAll();
    }

    @Override
    public ToDo saveTask(ToDo todoList) {
        return toDoRepository.save(todoList);
    }

    @Override
    public void deleteTaskById(Long id) {
        toDoRepository.deleteById(id);
    }

    @Override
    public ToDo findTaskById(Long id){
        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
        return optionalToDo.orElse(null);
    }

    @Override
    public ToDo updateTaskById(Long id, ToDo updatedTask) {
        if(toDoRepository.existsById(id)){
            updatedTask.setId(id);  //Ensure the ID Remain Same
            return toDoRepository.save(updatedTask);
        }
            return null;  // if task does not exist.
    }

    @Override
    public void deleteAllTask() {
        toDoRepository.deleteAll();
    }

    @Override
    public Page<ToDo> findPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return toDoRepository.findAll(pageable);
    }
}
