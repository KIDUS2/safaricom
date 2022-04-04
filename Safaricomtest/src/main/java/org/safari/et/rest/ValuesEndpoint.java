package org.safari.et.rest;

import io.swagger.annotations.Api;
import org.safari.et.Service.ValuesService;
import org.safari.et.dto.RequestDto.ValuesRequestDto;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/values")
@Consumes({"application/json"})
@Produces({"application/json"})
@Api(value = "values")
public class ValuesEndpoint {
    @Inject
    private ValuesService valuesService;

    @POST

    @Path("/Sum")
    public int Sum(ValuesRequestDto valuesRequestDto) {
        return valuesService.Sum(valuesRequestDto);
    }


    @POST
    @Path("/sub")
    public int sub(ValuesRequestDto valuesRequestDto) {
        return valuesService.sub(valuesRequestDto);
    }


    @POST
    @Path("/Sum")
    public int divid(ValuesRequestDto valuesRequestDto) {
        return valuesService.divid(valuesRequestDto);
    }


    @POST
    @Path("/Sum")
    public int mult(ValuesRequestDto valuesRequestDto) {
        return valuesService.mult(valuesRequestDto);
    }


}