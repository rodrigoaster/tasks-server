package org.aster.mocks.factory;

import org.aster.application.dtos.TaskDTO;

public class DTOFactoryUtil {
    private static final String NAME_MOCK = "Fulano de Tal";
    private static final String DESC_MOCK = "Description Mock";

    public static TaskDTO createTaskDTOEntity() {
        TaskDTO taskDTOMock = new TaskDTO();
        taskDTOMock.setName(NAME_MOCK);
        taskDTOMock.setDescription(DESC_MOCK);
        return taskDTOMock;
    }
}
