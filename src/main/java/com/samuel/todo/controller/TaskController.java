package com.samuel.todo.controller;

import com.samuel.todo.model.Task;
import com.samuel.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // define como controller REST
@RequestMapping("/tasks") // todas as rotas começam com /tasks
@CrossOrigin(origins = "*") // libera acesso para qualquer front-end
public class TaskController {

    @Autowired
    private TaskRepository repository;

    // GET /tasks (listar todas as tarefas)
    @GetMapping
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    // POST /tasks (criar nova tarefa)
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return repository.save(task);
    }

    // PUT /tasks/{id} (atualizar tarefa)
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        Task task = repository.findById(id).orElseThrow();
        task.setTitle(updatedTask.getTitle());
        task.setCompleted(updatedTask.isCompleted());
        return repository.save(task);
    }

    // DELETE /tasks/{id} (deletar tarefa)
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

