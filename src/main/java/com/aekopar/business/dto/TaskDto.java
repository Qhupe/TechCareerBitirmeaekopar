package com.aekopar.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Lambok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TaskDto {

    private Long taskId;
    private String taskName;

}
