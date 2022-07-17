package com.aekopar.business.dto.services.impl;

import com.aekopar.business.dto.TaskDto;
import com.aekopar.business.dto.services.ITaskServices;
import com.aekopar.data.entity.TaskEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class TaskServicesImpl implements ITaskServices {
    @Override
    public TaskDto entityToDto(TaskEntity taskEntity) {
        return null;
    }

    @Override
    public TaskEntity dtoEntity(TaskDto taskDto) {
        return null;
    }

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        return null;
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return null;
    }

    @Override
    public ResponseEntity<TaskDto> getTaskById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<TaskDto> deleteTaskById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<TaskDto> updateTaskById(Long id, TaskDto taskDto) {
        return null;
    }
}
