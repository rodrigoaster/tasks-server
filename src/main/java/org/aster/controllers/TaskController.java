package org.aster.controllers;

import org.aster.dtos.TaskDTO;
import org.aster.services.TaskService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/task")
public class TaskController {
    @Inject
    TaskService taskService;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTask(TaskDTO taskDTO) {
        taskService.createTask(taskDTO);
        return Response.ok(Response.Status.CREATED).build();
    }

    @GET
    @Path("/find/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTask() {
        return Response.ok(taskService.getAllTasks()).build();
    }
}
