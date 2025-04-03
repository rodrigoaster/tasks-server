package org.aster.mocks;

import org.aster.dtos.TaskDTO;
import org.aster.enums.TaskType;

public class DTOFactoryUtil {
    private static final String NAME_MOCK = "Fulano de Tal";
    private static final String DESC_MOCK = "Description Mock";
    private static final TaskType TASK_TYPE = TaskType.STUDY;

    public static TaskDTO createTaskDTOEntity() {
        TaskDTO taskDTOMock = new TaskDTO();
        taskDTOMock.setName(NAME_MOCK);
        taskDTOMock.setDescription(DESC_MOCK);
        taskDTOMock.setType(TASK_TYPE);
        return taskDTOMock;
    }
}
