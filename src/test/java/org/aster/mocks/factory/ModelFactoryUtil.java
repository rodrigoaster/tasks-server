package org.aster.mocks.factory;

import org.aster.application.enums.TaskType;
import org.aster.domain.models.TaskModel;

public class ModelFactoryUtil {
    private static final String NAME_MOCK = "Fulano de Tal";
    private static final String DESC_MOCK = "Description Mock";
    private static final TaskType TASK_TYPE = TaskType.STUDY;


    public static TaskModel createTaskModel() {
        TaskModel taskModelMock = new TaskModel();
        taskModelMock.setName(NAME_MOCK);
        taskModelMock.setDescription(DESC_MOCK);
        taskModelMock.setType(TASK_TYPE);
        return taskModelMock;
    }
}
