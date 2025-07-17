package com.samuel.todo.repository;

import com.samuel.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // não precisa implementar nada aqui pois já traz métodos CRUD prontos
    // (findAll, save, deleteById, etc.)
}