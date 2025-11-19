package org.aster.dtos;

import org.aster.enums.TaskTypeEnum;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class TaskDTO {
    private String name;
    private String description;
    private String type;
    private DayOfWeek day;
    private Long userId;
    private LocalDateTime deadline; // NOVO
}
