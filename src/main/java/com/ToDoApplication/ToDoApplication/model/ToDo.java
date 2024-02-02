package com.ToDoApplication.ToDoApplication.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ToDo_list")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskName;
    private LocalDateTime startingTime;
    private LocalDateTime endTime;
    private String remarks;
}