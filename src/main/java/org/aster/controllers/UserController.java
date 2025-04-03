package org.aster.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.aster.dtos.UserDTO;
import org.aster.entities.User;
import org.aster.services.UserService;


@Path("/user")
public class UserController {
    @Inject
    UserService userService;

    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User createUser(UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @Path("/find/{userId}")
    @GET
    public User getUserById(@PathParam(value = "userId") Long userId) {
        return userService.getUserById(userId);
    }
}
