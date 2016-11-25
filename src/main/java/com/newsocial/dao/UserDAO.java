package com.newsocial.dao;

import com.newsocial.dao.response.UserDAOResponse;
import com.newsocial.model.User;

public interface UserDAO {

    /**
     * Create a new User by the values set:
     * email, username, password
     * @param user with email, username and password set
     * @return userDAOResponse
     * @throws Exception
     */
    public UserDAOResponse createUser(User user) throws Exception;

    /**
     * Update the User passed as argument.
     * @param user to update
     * @return userDAOResponse
     */
    public UserDAOResponse updateUser(User user);

    /**
     * Update the activation status for the specific user
     * identified by the uid
     * @param uid
     * @param activated
     * @return userDAOResponse
     */
    public UserDAOResponse activateDeactivateUser(String uid, boolean activated);

    /**
     * Get the User by the email.
     * @param email
     * @return userDAOResponse
     */
    public UserDAOResponse getUserByEmail(String email);

    /**
     * Get the User by the username.
     * @param username
     * @return userDAOResponse
     */
    public UserDAOResponse getUserByUsername(String username);

    /**
     * Get the User by the id.
     * @param id
     * @return userDAOResponse
     */
    public UserDAOResponse getUserById(String id);

}
