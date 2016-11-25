package com.newsocial.rest.error;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.newsocial.rest.response.WSResponse;

public class AppExceptionMapper implements ExceptionMapper<AppException> {

    public Response toResponse(AppException ex) {
        return Response.status(ex.getStatus())
                .entity(new WSResponse(ex))
                .type(MediaType.APPLICATION_JSON).
                build();
    }

}
