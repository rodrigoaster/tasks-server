package org.aster.domain.services;

import org.aster.application.dtos.TaskDTO;
import org.aster.domain.mapper.TaskMapper;
import org.aster.domain.models.TaskModel;
import org.aster.infra.entities.Task;
import org.aster.infra.repositories.TaskRepository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class TaskService {
    @Inject
    TaskRepository taskRepository;

    public TaskModel createTask(TaskDTO taskDTO) {
       try {
        Task taskEntity = new Task();
        taskEntity.setName(taskDTO.getName());
        taskEntity.setDescription(taskDTO.getDescription());

        return TaskMapper.INSTANCE.taskEntityToModel(this.taskRepository.save(taskEntity));
       } catch(Exception errorException) {
        throw new Error(errorException);
       }
    }
}
