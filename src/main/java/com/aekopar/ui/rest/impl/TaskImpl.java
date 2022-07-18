package com.aekopar.ui.rest.impl;

import com.aekopar.business.dto.TaskDto;
import com.aekopar.business.dto.services.ITaskServices;
import com.aekopar.ui.rest.ITaskRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")

//Kullanıcı ile buluşacak kısım

class TaskImpl implements ITaskRest {

    @Autowired
    ITaskServices services;

    //http://localhost:8080/api/v1
    //http://localhost:8080/api/v1/index
    @GetMapping({"/","/index"})
    public  String getRoot(){
        return "index";
    }

    @Override
    //http://localhost:8080/api/v1/tasks
    @PostMapping("/tasks")
    public TaskDto createTask(@RequestBody TaskDto taskDto) {
        services.createTask(taskDto);
        return taskDto;
    }

    @Override
    //http://localhost:8080/api/v1/tasks
    @GetMapping("/tasks")
    public List<TaskDto> getAllEmployes() {
        List<TaskDto> list = services.getAllTasks();
        return list;
    }

    @Override
    //http://localhost:8080/api/v1/tasks/1
    @PostMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable(name = "id") Long id) {
        ResponseEntity<TaskDto> dto = services.getTaskById(id);
        return dto;
    }

    @Override
    //http://localhost:8080/api/v1/tasks/1
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTaskById(@PathVariable(name = "id") Long id) {
        services.deleteTaskById(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Silindi",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    //http://localhost:8080/api/v1/tasks/1
    @PutMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> updateTaskById(@PathVariable(name = "id") Long id, @RequestBody TaskDto taskDto) {
        services.updateTask(id, taskDto);
        return ResponseEntity.ok(taskDto);
    }
}
