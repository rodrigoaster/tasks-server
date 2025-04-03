package org.aster.controllers;

import org.aster.dtos.TaskDTO;
import org.aster.models.Task;
import org.aster.services.TaskService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/task")
public class TaskController {
    @Inject
    TaskService taskService;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Task createTask(TaskDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }
}
