package org.aster.controllers;

import jakarta.ws.rs.*;
import org.aster.dtos.DeleteTaskRequestDTO;
import org.aster.dtos.TaskDTO;
import org.aster.dtos.UpdateStatusRequestDTO;
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

            String message = String.format("Task '%s' foi criada com sucesso!", taskDTO.getName());
            return Response.status(Response.Status.CREATED)
                .entity(Collections.singletonMap("result", message))
                .build();
        } catch (Exception e) {
            String errorMessage = "Um erro ocorreu na tentativa de criar uma nova tarefa, tente novamente mais tarde!";
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
    public Response updateTaskStatus(UpdateStatusRequestDTO request) {
        try {
            taskService.updateTaskStatus(request.getId(), request.getNewStatus());

            String message = "Status da tarefa atualizado com sucesso!";
            return Response.status(Response.Status.OK)
                    .entity(Collections.singletonMap("result", message))
                    .build();
        } catch (Exception e) {
            String errorMessage = String.format("Um erro ocorreu ao tentar atualizar o status da tarefa: %s", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Collections.singletonMap("error", errorMessage))
                    .build();
        }
    }

    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTask(DeleteTaskRequestDTO request) {
        try {
            taskService.deleteTask(request.getId());

            String message = String.format("Task '%s' foi deletada com sucesso!", request.getTaskName());
            return Response.status(Response.Status.OK)
                    .entity(Collections.singletonMap("result", message))
                    .build();
        } catch (Exception e) {
            String errorMessage = "Um erro ocorreu na tentativa de deletar a tarefa, tente novamente mais tarde!";
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Collections.singletonMap("error", errorMessage))
                    .build();
        }
    }
}
