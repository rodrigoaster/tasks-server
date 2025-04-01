package org.aster.mocks.factory;

import org.aster.application.enums.TaskType;
import org.aster.infra.entities.Task;

public class EntityFactoryUtil {
    private static final String NAME_MOCK = "Fulano de Tal";
    private static final String DESC_MOCK = "Description Mock";
    private static final TaskType TASK_TYPE = TaskType.STUDY;


    public static Task createTaskEntity() {
        Task taskMock = new Task();
        taskMock.setName(NAME_MOCK);
        taskMock.setDescription(DESC_MOCK);
        taskMock.setType(TASK_TYPE);
        return taskMock;
    }
}
