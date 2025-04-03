package org.aster.dtos;

import org.aster.enums.TaskType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO {
    private String name;
    private String description;
    private TaskType type;
    private Long userId;
}
