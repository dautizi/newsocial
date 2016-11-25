package com.newsocial.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.newsocial.model.User;
import com.newsocial.rest.error.AppException;
import com.newsocial.rest.response.WSResponse;
import com.newsocial.transaction.UserTransaction;
import com.newsocial.util.DictionaryDB;

@Component
@Path("/account")
public class UserService {

    protected final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserTransaction userTransaction;

    @POST
    @Path("/signup")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
    public Response createUser(@FormParam(DictionaryDB.USER_EMAIL) String email,
                                @FormParam(DictionaryDB.USER_PASSWORD) String password,
                                @FormParam(DictionaryDB.USER_USERNAME) String username) throws AppException {

        String responseJson = "";
        logger.info("New user request: email=" + email + ", password=" + password + ", username=" + username);
        User user = new User(username, password, email);
        WSResponse wsResponse = userTransaction.createUser(user);
        Gson gson = new Gson();
        responseJson = gson.toJson(wsResponse);

        return Response.status(200).entity(responseJson).build();
    }

    @GET
    @Path("/username/{username}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUserByUsername(@PathParam("username") String username) throws AppException {
        String responseJson = "";
        User user = userTransaction.getUserByUsername(username);
        if (user != null) {
            Gson gson = new Gson();
            String json = gson.toJson(user);
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = (JsonObject) jsonParser.parse(json);
            WSResponse wsResponse = new WSResponse(jsonObject);
            responseJson = gson.toJson(wsResponse);
        }

        return Response.status(200).entity(responseJson).build();
    }

}