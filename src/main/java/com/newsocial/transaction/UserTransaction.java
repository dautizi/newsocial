package com.newsocial.transaction;

import com.newsocial.model.User;

public interface UserTransaction {

    public User getUserByUsername(String username);

}
