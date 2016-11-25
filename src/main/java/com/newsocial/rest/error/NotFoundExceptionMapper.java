package com.newsocial.rest.error;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.google.gson.Gson;
import com.newsocial.rest.response.WSResponse;
import com.sun.jersey.api.NotFoundException;

public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    public Response toResponse(NotFoundException ex) {
        WSResponse wsResponse = new WSResponse(ex);
        Gson gson = new Gson();
        String responseJson = gson.toJson(wsResponse);
        return Response.status(ex.getResponse().getStatus())
                .entity(responseJson)
                .type(MediaType.APPLICATION_JSON) //this has to be set to get the generated JSON 
                .build();
    }

}