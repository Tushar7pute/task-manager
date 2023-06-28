package com.projects.taskmanager.notes;

import com.projects.taskmanager.tasks.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Note {
    @Id
    Integer id;
    String body;

    @ManyToOne
    Task task;
}
