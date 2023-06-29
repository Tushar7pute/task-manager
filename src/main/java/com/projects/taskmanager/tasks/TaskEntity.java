package com.projects.taskmanager.tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Entity(name="tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @NonNull
    String name;
    LocalDate dueDate;

    public TaskEntity(String name) {
        this.name = name;
        this.dueDate = LocalDate.now().plus(7, ChronoUnit.DAYS);
        this.status = false;
    }

    @Column(columnDefinition = "boolean default false")
    boolean status;
}
