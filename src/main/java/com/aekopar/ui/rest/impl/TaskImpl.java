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

    //SAVE
    //http://localhost:8080/api/v1/tasks
    @Override
    @PostMapping("/tasks")
    public TaskDto createTask(@RequestBody TaskDto taskDto) {
        services.createTask(taskDto);
        return taskDto;
    }

    //LIST
    //http://localhost:8080/api/v1/tasks
    @Override
    @GetMapping("/tasks")
    public List<TaskDto> getAllEmployes() {
        List<TaskDto> list = services.getAllTasks();
        return list;
    }

    //FIND
    //http://localhost:8080/api/v1/tasks/1
    @Override
    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable(name = "id") Long id) {
        ResponseEntity<TaskDto> dto = services.getTaskById(id);
        return dto;
    }

    //DELETE
    //http://localhost:8080/api/v1/tasks/1
    @Override
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTaskById(@PathVariable(name = "id") Long id) {
        services.deleteTaskById(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Silindi",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    //UPDATE
    //http://localhost:8080/api/v1/tasks/1
    @Override
    @PutMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> updateTaskById(@PathVariable(name = "id") Long id, @RequestBody TaskDto taskDto) {
        services.updateTask(id, taskDto);
        return ResponseEntity.ok(taskDto);
    }
}
