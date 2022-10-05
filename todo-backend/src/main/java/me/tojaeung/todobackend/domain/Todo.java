package me.tojaeung.todobackend.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo {

    @Id
    @GeneratedValue
    @Column(name = "todo_id")
    private Long id;
    private String name;
    private boolean completed;

    public Todo(String name, boolean completed) {
        this.name = name;
        this.completed = completed;
    }
}
