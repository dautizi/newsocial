package com.newsocial.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.newsocial.model.User;
import com.newsocial.transaction.UserTransaction;

@Component
@Path("/user")
public class UserService {

    @Autowired
    UserTransaction userTransaction;

    @GET
    @Path("/username/{username}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUserByUsername(@PathParam("username") String username) {
        String json = "";
        User user = userTransaction.getUserByUsername(username);
        if (user != null) {
            Gson gson = new Gson();
            json = gson.toJson(user);
        }

        return Response.status(200).entity(json).build();
    }

}