package org.aster.mocks.factory;

import org.aster.infra.entities.Task;

public class EntityFactoryUtil {
    private static final String NAME_MOCK = "Fulano de Tal";
    private static final String DESC_MOCK = "Description Mock";

    public static Task createTaskEntity() {
        Task taskMock = new Task();
        taskMock.setName(NAME_MOCK);
        taskMock.setDescription(DESC_MOCK);
        return taskMock;
    }
}
