package org.aster.services;

import jakarta.ws.rs.BadRequestException;

import org.aster.dtos.TaskDTO;
import org.aster.models.Task;
import org.aster.models.User;
import org.aster.repositories.TaskRepository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.Objects;

@RequestScoped
public class TaskService {
    @Inject
    TaskRepository taskRepository;

    @Inject
    UserService userService;

    public Task createTask(TaskDTO taskDTO) {
        validateTaskDTO(taskDTO);

        User user = userService.getUserById(taskDTO.getUserId());

        Task taskEntity = new Task();
        taskEntity.setName(taskDTO.getName());
        taskEntity.setDescription(taskDTO.getDescription());
        taskEntity.setType(taskDTO.getType());
        taskEntity.setUser(user);

        return taskRepository.save(taskEntity);
    }

    private void validateTaskDTO(TaskDTO taskDTO) {
        if (Objects.isNull(taskDTO) || Objects.isNull(taskDTO.getType()) ||
                Objects.isNull(taskDTO.getName()) || Objects.isNull(taskDTO.getDescription())) {
            throw new BadRequestException("Error: Missing required fields of Tasks.");
        }
    }
}

