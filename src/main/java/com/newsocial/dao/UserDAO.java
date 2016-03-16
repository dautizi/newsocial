package com.newsocial.dao;

import com.newsocial.model.User;

public interface UserDAO {

    public User createUser(User user);

    public User updateUser(User user);

    public boolean deleteUser(User user);

    public User getUserByUsername(String username);

    public User getUserById(String id);

}
