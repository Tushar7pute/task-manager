package com.projects.taskmanager.tasks;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Task {
    @Id
    Integer id;
    String name;
    LocalDate dueDate;
    boolean status;
}
