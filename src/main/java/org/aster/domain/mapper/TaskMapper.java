package org.aster.domain.mapper;

import org.aster.domain.models.TaskModel;
import org.aster.infra.entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "CDI")
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);
    TaskModel taskEntityToModel(Task taskEntity);
}
