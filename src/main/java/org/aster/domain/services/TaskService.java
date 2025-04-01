package org.aster.domain.services;

import org.aster.application.dtos.TaskDTO;
import org.aster.domain.mapper.TaskMapper;
import org.aster.domain.models.TaskModel;
import org.aster.infra.entities.Task;
import org.aster.infra.repositories.TaskRepository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.mapstruct.ap.shaded.freemarker.template.utility.NullArgumentException;

@RequestScoped
public class TaskService {
    @Inject
    TaskRepository taskRepository;

    public TaskModel createTask(TaskDTO taskDTO) {
       try {
        Task taskEntity = new Task();

        if (taskDTO.getType() == null || taskDTO.getName() == null || taskDTO.getDescription() == null) {
            throw new NullArgumentException("Error, fields are not provided.");
        }
        taskEntity.setName(taskDTO.getName());
        taskEntity.setDescription(taskDTO.getDescription());
        taskEntity.setType(taskDTO.getType());

        return TaskMapper.INSTANCE.taskEntityToModel(this.taskRepository.save(taskEntity));
       } catch(Exception errorException) {
        throw new Error(errorException);
       }
    }
}
