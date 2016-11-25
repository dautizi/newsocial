package com.newsocial.rest.error;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.newsocial.rest.response.WSResponse;
import com.newsocial.util.AppConstants;

public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    public Response toResponse(Throwable ex) {
        WSResponse errorMessage = new WSResponse();
        setHttpStatus(ex, errorMessage);
        errorMessage.setErrorCode(AppConstants.GENERIC_APP_ERROR_CODE);
        errorMessage.setMessage(ex.getMessage());
        StringWriter errorStackTrace = new StringWriter();
        ex.printStackTrace(new PrintWriter(errorStackTrace));
        errorMessage.setStatusReason(errorStackTrace.toString());

        return Response.status(errorMessage.getStatusCode())
                .entity(errorMessage)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    private void setHttpStatus(Throwable ex, WSResponse wsResponse) {
        if(ex instanceof WebApplicationException ) { //NICE way to combine both of methods, say it in the blog 
            wsResponse.setStatusCode(((WebApplicationException)ex).getResponse().getStatus());
        } else {
            wsResponse.setStatusCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()); //defaults to internal server error 500
        }
    }
}

