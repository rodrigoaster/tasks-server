package org.aster.domain.services;

import jakarta.ws.rs.BadRequestException;
import org.aster.application.dtos.TaskDTO;
import org.aster.domain.mapper.TaskMapper;
import org.aster.domain.models.TaskModel;
import org.aster.infra.entities.Task;
import org.aster.infra.repositories.TaskRepository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.Objects;

@RequestScoped
public class TaskService {
    @Inject
    private TaskRepository taskRepository;

    public TaskModel createTask(TaskDTO taskDTO) {
        validateTaskDTO(taskDTO);

        Task taskEntity = new Task();
        taskEntity.setName(taskDTO.getName());
        taskEntity.setDescription(taskDTO.getDescription());
        taskEntity.setType(taskDTO.getType());

        Task savedTask = taskRepository.save(taskEntity);
        return TaskMapper.INSTANCE.taskEntityToModel(savedTask);
    }

    private void validateTaskDTO(TaskDTO taskDTO) {
        if (Objects.isNull(taskDTO) || Objects.isNull(taskDTO.getType()) ||
                Objects.isNull(taskDTO.getName()) || Objects.isNull(taskDTO.getDescription())) {
            throw new BadRequestException("Error: Missing required fields of Tasks.");
        }
    }
}

