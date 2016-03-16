package com.newsocial.dao;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.newsocial.model.User;

public class UserDAOImpl implements UserDAO {

    private MongoOperations mongoOps;
    private static final String USER_COLLECTION = "user";

    public UserDAOImpl(MongoOperations mongoOps) {
        this.mongoOps = mongoOps;
    }

    public User createUser(User user) {
        User newUser = null;
        
        return newUser;
    }

    public User updateUser(User user) {
        User updated = null;
        
        return updated;
    }

    public boolean deleteUser(User user) {
        boolean opResult = false;
        
        return opResult;
    }

    public User getUserByUsername(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        return this.mongoOps.findOne(query, User.class, USER_COLLECTION);
    }

    public User getUserById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return this.mongoOps.findOne(query, User.class, USER_COLLECTION);
    }

}
