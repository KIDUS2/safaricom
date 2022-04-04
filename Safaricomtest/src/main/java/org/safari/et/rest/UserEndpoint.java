package org.safari.et.rest;

import io.swagger.annotations.Api;
import org.safari.et.Service.UserService;
import org.safari.et.dto.RequestDto.UserRequestDto;
import org.safari.et.dto.StatusDto;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("/user")
@Consumes({"application/json"})
@Produces({"application/json"})
@Api(value = "user")
public class UserEndpoint {
    @Inject
    private UserService userService;
    @POST

    @Path("/create")
    public StatusDto create(UserRequestDto userRequestDto){
        return userService.register(userRequestDto);
    }

    @POST
    @Path("/update")
    public StatusDto update(UserRequestDto userRequestDto, @QueryParam("id") Long id){
        return userService.update(userRequestDto,id);
    }
}
