package com.newsocial.transaction;

import com.newsocial.model.User;
import com.newsocial.rest.response.WSResponse;

public interface UserTransaction {

    public WSResponse createUser(User user);

    public WSResponse updateUser(User user);

    public User getUserByUsername(String username);

}
