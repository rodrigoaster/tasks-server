package org.aster.infra.repositories;

import org.aster.infra.entities.Task;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TaskRepository implements PanacheRepository<Task> {
    @Transactional
    public Task save(Task taskEntity) {
        this.persist(taskEntity);
        return taskEntity;
    }
}
