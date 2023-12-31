package com.projects.taskmanager.tasks;


import com.projects.taskmanager.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RequestMapping("/tasks")
@RestController
public class TaskController {
    private TasksService tasksService;

    public TaskController(TasksService tasksService){
        this.tasksService = tasksService;
    }

    @GetMapping("/all")
    ResponseEntity<List<TaskEntity>> getAllTasks() {
        return ResponseEntity.ok(tasksService.getAllTasks());
    }
    @GetMapping("")
    ResponseEntity<List<TaskEntity>> getTasksByPageAndSize(@RequestParam int pageNumber,@RequestParam int size) {
        System.out.println("Pagination called");
        return ResponseEntity.ok(tasksService.getTasksByPageAndSize(pageNumber, size));
    }

    @GetMapping("/{taskId}")
    ResponseEntity<TaskEntity> getTaskById(@PathVariable Long taskId) {

        return ResponseEntity.ok(tasksService.getTaskById(taskId));
    }

    @PostMapping("")
    ResponseEntity<TaskEntity> createTask(@RequestBody TaskCreationRequestBody requestBody) {
        TaskEntity savedTask = tasksService.createTask(requestBody.name);
        return ResponseEntity
                .created(URI.create(Constants.BASE_URL + "/tasks/" + savedTask.id))
                .body(savedTask);

    }
}
