package org.aster.mocks.factory;

import org.aster.domain.models.TaskModel;

public class ModelFactoryUtil {
    private static final String NAME_MOCK = "Fulano de Tal";
    private static final String DESC_MOCK = "Description Mock";

    public static TaskModel createTaskModel() {
        TaskModel taskModelMock = new TaskModel();
        taskModelMock.setName(NAME_MOCK);
        taskModelMock.setDescription(DESC_MOCK);
        return taskModelMock;
    }
}
