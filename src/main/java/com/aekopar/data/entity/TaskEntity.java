package com.aekopar.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

//lombol
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

@Entity

public class TaskEntity extends BaseEntity {
    private String taskName;
}
