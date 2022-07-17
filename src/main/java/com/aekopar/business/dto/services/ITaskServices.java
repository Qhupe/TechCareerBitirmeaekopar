package com.aekopar.business.dto.services;

import com.aekopar.business.dto.TaskDto;
import com.aekopar.data.entity.TaskEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITaskServices {

    //Model Mapper

    public TaskDto entityToDto(TaskEntity taskEntity);

    public TaskEntity dtoEntity(TaskDto taskDto);


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>CRUD<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    //Save
    public TaskDto createTask(TaskDto taskDto);

    //list
    public List<TaskDto> getAllTasks();

    //find
    public ResponseEntity<TaskDto> getTaskById(Long id);

    //delete
    public ResponseEntity<TaskDto> deleteTaskById(Long id);

    //update
    public ResponseEntity<TaskDto> updateTaskById(Long id, TaskDto taskDto);



}
