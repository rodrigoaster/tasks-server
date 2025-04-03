package org.aster.services;

import jakarta.ws.rs.BadRequestException;

import org.aster.dtos.TaskDTO;
import org.aster.mocks.DTOFactoryUtil;
import org.aster.mocks.EntityFactoryUtil;
import org.aster.models.Task;
import org.aster.repositories.TaskRepository;
import org.aster.services.TaskService;
import org.gradle.internal.impldep.org.apache.commons.lang.NullArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@QuarkusTest
public class TaskServiceTest {
    @Inject
    TaskService sut;

    @Mock
    TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // @Test
    // void shouldBeCreateTask() {
    //     Task taskMock = EntityFactoryUtil.createTaskEntity();
    //     when(taskRepository.save(taskMock)).thenReturn(taskMock);

    //     TaskModel taskModelMock = ModelFactoryUtil.createTaskModel();
    //     TaskDTO taskDTOMock = DTOFactoryUtil.createTaskDTOEntity();

    //     TaskModel result = sut.createTask(taskDTOMock);

    //     assertEquals(taskModelMock.getName(), result.getName());
    //     assertEquals(taskModelMock.getDescription(), result.getDescription());
    //     assertEquals(taskModelMock.getType(), result.getType());
    // }

    // @Test
    // void shouldBeRThrowsExceptionIfNameIsNull() {
    //     TaskDTO taskDTOMock = DTOFactoryUtil.createTaskDTOEntity();
    //     taskDTOMock.setName(null);
    //     taskDTOMock.setDescription(null);
    //     taskDTOMock.setType(null);

    //     assertThrows(BadRequestException.class, () -> {
    //         sut.createTask(taskDTOMock);
    //     });
    // }
}