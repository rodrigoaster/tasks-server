package org.aster.domain.models;

import lombok.Getter;
import lombok.Setter;
import org.aster.application.enums.TaskType;

@Getter
@Setter
public class TaskModel {
    private String name;
    private String description;
    private TaskType type;
}
