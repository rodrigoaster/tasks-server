package org.aster.application.dtos;

import lombok.Getter;
import lombok.Setter;
import org.aster.application.enums.TaskType;

@Getter
@Setter
public class TaskDTO {
    private String name;
    private String description;
    private TaskType type;
}
