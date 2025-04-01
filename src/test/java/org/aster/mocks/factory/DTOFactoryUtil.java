package org.aster.mocks.factory;

import org.aster.application.dtos.TaskDTO;
import org.aster.application.enums.TaskType;

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
