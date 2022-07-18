package com.aekopar.ui.rest;

import com.aekopar.business.dto.TaskDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ITaskRest {

    //SAVE
    TaskDto createTask(TaskDto taskDto);

    //LIST
    List<TaskDto> getAllEmployes();

    //FIND
    ResponseEntity<TaskDto> getTaskById(Long id);

    //DELETE
    ResponseEntity<Map<String,Boolean>> deleteTaskById(Long id);

    //UPDATE
    ResponseEntity<TaskDto> updateTaskById(Long id, TaskDto taskDto);



}
