package org.aster.services.impl;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.aster.dtos.TaskDTO;
import org.aster.enums.TaskStatusEnum;
import org.aster.models.Task;
import org.aster.repositories.TaskRepository;
import org.aster.services.TaskService;

import java.util.List;

import static utils.DayWeekUtils.validateDayOfWeek;
import static utils.TaskUtils.validateInputTaskType;

@RequestScoped
public class TaskServiceImpl implements TaskService {
    @Inject
    TaskRepository taskRepository;
    @Override
    public void createTask(TaskDTO taskDTO) {
        Task newTask = new Task();
        newTask.setName(taskDTO.getName());
        newTask.setDescription(taskDTO.getDescription());
        validateInputTaskType(taskDTO.getType(), newTask);
        newTask.setDay(taskDTO.getDay());
        taskRepository.save(newTask);
    }

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.listAll();
    }

    @Override
    public List<Task> findTasksByDayWeek(String dayWeek) {
        return taskRepository.find("day", validateDayOfWeek(dayWeek)).list();
    }

    @Override
    @Transactional
    public void updateTaskStatus(Long id, String newStatus) {
        Task taskGot = taskRepository.findById(id);
        if (taskGot == null) {
            throw new NullPointerException("Task not found, please, try again!");
        }

        System.out.println(newStatus);
        taskGot.setStatus(TaskStatusEnum.valueOf(newStatus));
        taskRepository.persist(taskGot);
    }
}
