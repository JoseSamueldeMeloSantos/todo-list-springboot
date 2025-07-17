package com.samuel.todo.model;

import jakarta.persistence.*;

@Entity // diz que essa classe vira uma tabela no banco
@Table(name = "tasks") // nome da tabela
public class Task {

    @Id // chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremento
    private Long id;
    private String title;
    private boolean completed = false;

    // Construtor vazio (obrigatório pro JPA)
    public Task() {}

    // Construtor com título
    public Task(String title) {
        this.title = title;
        this.completed = false;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
