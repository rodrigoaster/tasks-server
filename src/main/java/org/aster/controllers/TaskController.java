package org.aster.controllers;

import jakarta.ws.rs.*;
import org.aster.dtos.TaskDTO;
import org.aster.dtos.UpdateStatusDTO;
import org.aster.services.TaskService;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Collections;

@Path("/task")
public class TaskController {
    @Inject
    TaskService taskService;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTask(TaskDTO taskDTO) {
        try {
            taskService.createTask(taskDTO);

            String message = String.format("Task '%s' has been successfully created!", taskDTO.getName());
            return Response.status(Response.Status.CREATED)
                .entity(Collections.singletonMap("result", message))
                .build();
        } catch (Exception e) {
            String errorMessage = String.format("An error occurred while creating the task: %s", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(Collections.singletonMap("error", errorMessage))
                .build();
        }
    }

    @GET
    @Path("/find/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTask() {
        return Response.ok(taskService.findAllTasks()).build();
    }

    @GET
    @Path("/find")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTaskByDayWeek(@QueryParam("day") String day) {
        return Response.ok(taskService.findTasksByDayWeek(day)).build();
    }

    @PUT
    @Path("/updateTaskStatus")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTaskStatus(UpdateStatusDTO request) {
        try {
            taskService.updateTaskStatus(request.getId(), request.getNewStatus());

            String message = "Task status has been updated!";
            return Response.status(Response.Status.OK)
                    .entity(Collections.singletonMap("result", message))
                    .build();
        } catch (Exception e) {
            String errorMessage = String.format("An error occurred while updating the task: %s", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Collections.singletonMap("error", errorMessage))
                    .build();
        }
    }
}
