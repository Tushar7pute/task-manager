package com.projects.taskmanager.tasks;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    List<TaskEntity> getTasksByPageAndSize(int pageNumber, int size){
        Page page = tasksRepository.findAll(PageRequest.of(pageNumber-1, size));

        return page.toList();
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
