package com.aekopar.business.dto.services.impl;

import com.aekopar.business.dto.TaskDto;
import com.aekopar.business.dto.services.ITaskServices;
import com.aekopar.data.entity.TaskEntity;
import com.aekopar.data.repository.TaskRepository;
import com.aekopar.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
public class TaskServicesImpl implements ITaskServices {

    @Autowired
    TaskRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public TaskDto entityToDto(TaskEntity taskEntity) {
        TaskDto dto = modelMapper.map(taskEntity, TaskDto.class);
        return dto;
    }

    @Override
    public TaskEntity dtoEntity(TaskDto taskDto) {

        TaskEntity taskEntity = modelMapper.map(taskDto, TaskEntity.class);

        return taskEntity;
    }

    @Override
    @PostMapping("/save/tasks")
    public TaskDto createTask(TaskDto taskDto) {
        TaskEntity entity = dtoEntity(taskDto);
        repository.save(entity);
        return taskDto;
    }

    @Override
    @GetMapping("/list/tasks")
    public List<TaskDto> getAllTasks() {
        List<TaskEntity> listem = repository.findAll();

        List<TaskDto> dtoList = new ArrayList<>();

        for (TaskEntity entity : listem) {
            TaskDto dto = entityToDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    @GetMapping({"/find/tasks","find/tasks/{id}"})
    public ResponseEntity<TaskDto> getTaskById(@PathVariable(name = "id", required = false) Long id) {
        TaskEntity entity = repository.findById(id).orElseThrow(()->new ResourceNotFoundException(id+"-Bu id Bulunamadı"));
        TaskDto taskDto = entityToDto(entity);
        return ResponseEntity.ok(taskDto);
    }

    @Override
    @DeleteMapping({"/delete/tasks","find/delete/{id}"})
    public ResponseEntity<Map<String,Boolean>> deleteTaskById(@PathVariable(name = "id", required = false) Long id) {
        TaskEntity entity = repository.findById(id).orElseThrow(()->new ResourceNotFoundException(id+"-Bu id Bulunamadı"));
        repository.delete(entity);

        Map<String,Boolean> response = new HashMap<String, Boolean>();
        response.put("Silindi",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    @PutMapping({"/update/tasks","find/update/{id}"})
    public ResponseEntity<TaskDto> updateTaskById(Long id, TaskDto taskDto) {

        TaskEntity entityFind = repository.findById(id).orElseThrow(()->new ResourceNotFoundException(id+"-Bu id Bulunamadı"));

        TaskEntity entity = dtoEntity(taskDto);

        entityFind.setTaskName(entityFind.getTaskName());

        TaskEntity saveEntity = repository.save(entityFind);

        entityToDto(saveEntity);

        TaskDto dto = entityToDto(saveEntity);



        return ResponseEntity.ok(dto);
    }
}
