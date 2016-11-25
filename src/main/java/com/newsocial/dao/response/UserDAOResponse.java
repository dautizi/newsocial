package com.newsocial.dao.response;

import java.util.List;

import com.newsocial.model.User;
import com.newsocial.util.DatetimeManager;

public class UserDAOResponse extends DAOResponse {

    private User user;
    private List<User> users;
    private int  noUsers = 0;

    public UserDAOResponse(int statusCode, String message, User user) {
        this.statusCode= statusCode;
        this.time = DatetimeManager.getJodaNowInString();
        this.message = message;
        this.user = user;
    }

    public UserDAOResponse(int statusCode, String time, String message, User user) {
        this.statusCode= statusCode;
        this.time = time;
        this.message = message;
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public int getNoUsers() {
        return noUsers;
    }
    public void setNoUsers(int noUsers) {
        this.noUsers = noUsers;
    }

    @Override
    public String toString() {
        return "UserDAOResponse [user=" + user + ", users=" + users
                + ", noUsers=" + noUsers + "]";
    }

}
