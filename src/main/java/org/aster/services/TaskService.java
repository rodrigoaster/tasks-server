package org.aster.services;

import jakarta.ws.rs.BadRequestException;

import org.aster.dtos.TaskDTO;
import org.aster.models.Task;
import org.aster.repositories.TaskRepository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Objects;

@RequestScoped
public class TaskService {
    @Inject
    TaskRepository taskRepository;

    public Task createTask(TaskDTO taskDTO) {
        validateTaskDTO(taskDTO);

        Task taskEntity = new Task();
        taskEntity.setName(taskDTO.getName());
        taskEntity.setDescription(taskDTO.getDescription());
        taskEntity.setType(taskDTO.getType());

        return taskRepository.save(taskEntity);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll().list();
    }

    private void validateTaskDTO(TaskDTO taskDTO) {
        if (Objects.isNull(taskDTO) || 
            Objects.isNull(taskDTO.getType()) ||
            Objects.isNull(taskDTO.getName()) || 
            Objects.isNull(taskDTO.getDescription())) {
            throw new BadRequestException("Error: Missing required fields of Tasks.");
        }
    }
}

