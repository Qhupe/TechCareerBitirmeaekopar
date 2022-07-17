package com.aekopar.data.repository;

import com.aekopar.data.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository  extends JpaRepository<TaskEntity, Long> {
}
