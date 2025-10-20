package org.aster.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum TaskTypeEnum {
    STUDY("STUDY"),
    WORK("WORK"),
    EXERCISE("EXERCISE"),
    HYDRATION("HYDRATION"),
    MEAL("MEAL"),
    HOBBY("HOBBY"),
    SLEEP("SLEEP");

    private final String taskTypeValue;

    TaskTypeEnum(String taskTypeValue) {
        this.taskTypeValue = taskTypeValue;
    }

    public static List<TaskTypeEnum> getAllTasksTypeValues() {
        return Arrays.asList(TaskTypeEnum.values());
    }

    public static boolean verifyIfTypeExists(String inputType) {
        if (inputType == null || inputType.isBlank()) {
            return false;
        }

        return Arrays.stream(TaskTypeEnum.values())
            .anyMatch(taskType -> taskType.getTaskTypeValue().equalsIgnoreCase(inputType)
        );
    }
}
