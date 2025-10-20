package utils;

import jakarta.enterprise.context.RequestScoped;
import org.aster.enums.TaskTypeEnum;
import org.aster.models.Task;

import static org.aster.enums.TaskTypeEnum.getAllTasksTypeValues;

@RequestScoped
public class TaskUtils {
    public static void validateInputTaskType(String inputType, Task task) {
        TaskTypeEnum filteredByInputType = getAllTasksTypeValues()
            .stream()
            .filter(type -> type.getTaskTypeValue().equalsIgnoreCase(inputType))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Invalid task type: " + inputType)
        );

        task.setType(filteredByInputType);
    }
}
