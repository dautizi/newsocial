package com.newsocial.transaction.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.newsocial.dao.UserDAO;
import com.newsocial.model.User;
import com.newsocial.transaction.UserTransaction;

public class UserTransactionImpl implements UserTransaction{

    @Autowired
    protected UserDAO userDAO;

    public User getUserByUsername(String username) {
        /*
         * ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.userDAO = ctx.getBean("userDAO", UserDAO.class);
        ctx.close();
         */
        
        User user = userDAO.getUserByUsername(username);
        System.out.println("User username: "+user.getUsername());
        System.out.println("User: "+user.toString());

        return user;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

}
