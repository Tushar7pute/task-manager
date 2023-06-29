package com.projects.taskmanager.tasks;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService {

    private TasksRepository tasksRepository;

    public TasksService(TasksRepository tasksRepository){
        this.tasksRepository = tasksRepository;
    }

    List<TaskEntity> getAllTasks(){
        return tasksRepository.findAll();
    }

    TaskEntity getTaskById(Long taskId){
        Optional<TaskEntity> task = tasksRepository.findById(taskId);
        return task.get();
    }


    TaskEntity createTask(String taskName){
        TaskEntity task = new TaskEntity(taskName);
        TaskEntity savedTask = tasksRepository.save(task);
        return savedTask;
    }
}
