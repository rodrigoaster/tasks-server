package org.aster.services;

import org.aster.dtos.TaskDTO;
import org.aster.models.Task;

import java.util.List;

public interface TaskService {
    void createTask(TaskDTO taskDTO);
    List<Task> findAllTasks();
    List<Task> findTasksByDayWeek(String dayWeek);
}
