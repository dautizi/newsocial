package com.newsocial.transaction.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.newsocial.dao.UserDAO;
import com.newsocial.dao.response.UserDAOResponse;
import com.newsocial.model.User;
import com.newsocial.rest.response.WSResponse;
import com.newsocial.transaction.UserTransaction;
import com.sun.jersey.api.NotFoundException;

public class UserTransactionImpl implements UserTransaction{

    protected final Logger logger = LoggerFactory.getLogger(UserTransactionImpl.class);

    @Autowired
    protected UserDAO userDAO;

    public WSResponse createUser(User user) {
        WSResponse wsResponse = null;
        User createdUser = null;

        try {
            UserDAOResponse userDAOResponse = userDAO.createUser(user);
            createdUser = userDAOResponse.getUser();
            if (createdUser != null) {
                String email = createdUser.getEmail();
                userDAOResponse = userDAO.getUserByEmail(email);
                createdUser = userDAOResponse.getUser();
                logger.info("User created: username=" + createdUser.getUsername() + 
                        ", email=" + createdUser.getEmail() + ", uid=" + createdUser.getId());
            }

            // build the ws response
            wsResponse = new WSResponse(userDAOResponse);
            Gson gson = new Gson();
            String json = gson.toJson(createdUser);
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = (JsonObject) jsonParser.parse(json);
            wsResponse.setResult(jsonObject);
        } catch (Exception e) {
            logger.error("User creation failure: " + e);
        }

        return wsResponse;
    }

    public WSResponse updateUser(User user) {
        WSResponse wsResponse = null;
        User updatedUser = null;

        try {
            UserDAOResponse userDAOResponse = userDAO.updateUser(user);
            updatedUser = userDAOResponse.getUser();
            if (updatedUser != null) {
                String email = updatedUser.getEmail();
                userDAOResponse = userDAO.getUserByEmail(email);
                updatedUser = userDAOResponse.getUser();
                logger.info("User updated: username=" + updatedUser.getUsername() + 
                        ", email=" + updatedUser.getEmail() + ", uid=" + updatedUser.getId());
            }

            // build the ws response
            wsResponse = new WSResponse(userDAOResponse);
            Gson gson = new Gson();
            String json = gson.toJson(updatedUser);
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = (JsonObject) jsonParser.parse(json);
            wsResponse.setResult(jsonObject);
        } catch (Exception e) {
            logger.error("User update failure: " + e);
        }

        return wsResponse;
    }

    public User getUserByUsername(String username) {
        UserDAOResponse userDAOResponse = userDAO.getUserByUsername(username);
        User user = userDAOResponse.getUser();
        if (user == null) {
            throw new NotFoundException();
        }

        return user;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

}
