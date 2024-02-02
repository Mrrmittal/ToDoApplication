package com.ToDoApplication.ToDoApplication.controller;


import com.ToDoApplication.ToDoApplication.model.ToDo;
import com.ToDoApplication.ToDoApplication.service.ToDoService;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class ToDoController {

        @Autowired
        ToDoService toDoService;

        @GetMapping
        public String ShowToDoList(Model model){
            return findPaginated(1,model);
        }

        @GetMapping("/add")
        public String addNewTask(Model model){
            model.addAttribute("tasks", new ToDo());
            return "ToDo/new_task";
        }

        @PostMapping("/add")
        public String saveNewTask(@ModelAttribute("tasks") ToDo tasks){
            toDoService.saveTask(tasks);
            return "redirect:add?success";
        }

        @PostMapping("/delete/{id}")
        public String deleteTask(@PathVariable(name = "id") Long id){
            toDoService.deleteTaskById(id);
            return "redirect:/todo";
        }

        @PostMapping("/delete/all")
        public String deleteAllTask(){
            toDoService.deleteAllTask();
            return "redirect:/todo?success";
        }

        @GetMapping("/edit/{id}")
        public String getEditTask(@PathVariable(name = "id") Long id, Model model){
            ToDo tasks = toDoService.findTaskById(id);
            model.addAttribute("tasks", tasks );
            return "ToDo/edit_task";
        }

        @PostMapping("/update/{id}")
        public String updateTasks(@PathVariable(value = "id") @ModelAttribute("tasks") Long id, ToDo updateTask){
            toDoService.updateTaskById(id,updateTask);
            return "redirect:/todo";
        }

        @GetMapping("/page/{pageNo}")
        public String findPaginated(@PathVariable(value = "pageNo") int pageNo,Model model){
            int pageSize = 3;
            Page<ToDo> page = toDoService.findPagination(pageNo, pageSize);
            List<ToDo> tasks = page.getContent();

            model.addAttribute("currentPage", pageNo);
            model.addAttribute("totalPages", page.getTotalPages());
            model.addAttribute("totalElements", page.getTotalElements());
            model.addAttribute("tasks", tasks);
            return "ToDo/todo_list";
        }

}
