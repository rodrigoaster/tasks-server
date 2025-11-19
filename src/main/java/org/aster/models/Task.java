package org.aster.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.*;
import org.aster.enums.TaskStatusEnum;
import org.aster.enums.TaskTypeEnum;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "task")
public class Task extends PanacheEntity {

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private TaskStatusEnum status = TaskStatusEnum.CREATED;

    @NonNull
    @Column(name = "type")
    private TaskTypeEnum type;

    @Enumerated(EnumType.STRING)
    private DayOfWeek day;

    @Column(name = "deadline")
    private LocalDateTime deadline;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}